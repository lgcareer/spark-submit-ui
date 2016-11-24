package models

import java.net.URI
import java.util.{Properties, UUID}

import akka.actor.{ActorRef, AllForOneStrategy, PoisonPill, Props, Terminated}
import akka.actor.SupervisorStrategy.Stop
import models.ScheduleManager._
import models.actor.InstrumentedActor
import models.utils.Config
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.oozie.client.OozieClient
import org.joda.time.DateTime
import play.api.Logger
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart

import scala.collection.mutable

/**
  * Created by king on 2016/11/2.
  */
object  ScheduleManager{

  case class  StoreFile(user:String,filePart: FilePart[TemporaryFile])
  case class  Submited(user:String,para:Seq[String])
  case class SHOW(jobtype:String)
  case class InvalidJar(error:String)
  case class JarStored(msg :String)

  def props(config:Config,scheduleProvider: ScheduleProvider,jobDao: JobDAO): Props = Props(classOf[ScheduleManager], config,scheduleProvider,jobDao)

}

class ScheduleManager(config: Config,scheduleProvider: ScheduleProvider,jobDao: JobDAO) extends InstrumentedActor {
  private[this] var hdfs :FileSystem = _
  private[this] val wc = new OozieClient("http://10.211.55.8:11000/oozie")
  private[this] var apps = Map.empty[String,mutable.Stack[String]];



  override val supervisorStrategy = AllForOneStrategy() {
    case anyException => Stop
  }
  override def preStart()={
    scheduleProvider.setClient(wc)
  }


  def runJonb(user:String,pa: Seq[String]): String = {
     val prop: String = WorkFlowsProp.createProp(pa)
      val dest=getPathInfo(user).map{
        dest =>
          val dest1: String = dest.substring(0,dest.indexOf("lib/"))
          Logger.info(s"xml path==>$dest1")
          copyFromLocalFile(prop,dest1).get
      }.get


    val conf: Properties = wc.createConfiguration
    //conf.setProperty(OozieClient.APP_PATH,"hdfs://192.168.1.133:9000"  + appPath);
    conf.setProperty("nameNode", "hdfs://10.211.55.8:9000")
    conf.setProperty("queueName", "default")
    conf.setProperty("oozie.wf.application.path", "${nameNode}/user/hadoop/"+dest+"mr-workflow.xml")
    conf.setProperty("jobTracker", "http://10.211.55.8:8032")
    val jobId: String = wc.run(conf)
    Logger.info(jobId)
    jobId
  }

  def copyFromLocalFile(src:String,dest:String):Option[String] = {
        try {
          val config = new Configuration
          config.set("fs.default.name", "hdfs://hadoop01:9000")
          hdfs = FileSystem.get(new URI("hdfs://hadoop01:9000"), config, "hadoop")
          val srcPath = new Path(src)
          val destPath = new Path(dest)
          if(!hdfs.exists(destPath)){
            hdfs.mkdirs(destPath)
          }
          hdfs.copyFromLocalFile(srcPath, destPath)
          Some(dest)
        } catch  {
        case e:Exception =>
          e.printStackTrace
            None
        } finally {
          if (hdfs != null) {
            try {
              hdfs.close
            } catch {
              case e :Exception => e.printStackTrace
                None
            }
          }
        }
  }


  def addPathStcak(user:String,path:String): Unit ={
    if(apps.get(user).isDefined){
      val stacks: mutable.Stack[String] = apps.get(user).getOrElse(new mutable.Stack[String]())
      stacks.push(path)
      apps+=user->stacks
    }else{
      val stack: mutable.Stack[String] = new mutable.Stack[String]
      apps += (user-> stack.push(path))
    }
  }

  def getPathInfo(user:String): Option[String] ={
    if(apps.get(user).isDefined){
      val stacks: mutable.Stack[String] = apps.get(user).get
      val pop: String = stacks.pop()
      Logger.info(s"pop===>$pop")
      Some(pop)
    }else{
      None
    }
  }


  override def wrappedReceive: Receive = {
    case SHOW(jobtype) =>  sender ! scheduleProvider.jobList(jobtype=jobtype)
    case t: Terminated => self ! PoisonPill

    case Submited(user,pa) =>  sender ! runJonb(user,pa)

    case StoreFile(user,part) => {
      val uuid: String = UUID.randomUUID.toString
      val nickName: String = user.split("@")(0)
      Logger.info(uuid)
      val destfile = s"workspance/$nickName/wf-$uuid/lib/"
      val fsrc = jobDao.saveJar(user,DateTime.now(),part)
      Logger.info("src==>"+fsrc)
      Logger.info("dest==>"+destfile)
      val dest = copyFromLocalFile(fsrc,destfile)
      if (dest.isDefined) {
       sender ! JarStored("上传成功！")
       addPathStcak(user,dest.get)
      }else{
        sender ! InvalidJar("上传失败！")
      }



    }



  }




}
