package models

import java.net.URI
import java.util.{Properties, UUID}

import akka.actor.SupervisorStrategy.Stop
import akka.actor.{AllForOneStrategy, PoisonPill, Props, Terminated}
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
  * Created by liangkai1 on 2016/11/2.
  */
object  ScheduleManager{

  case class  StoreFile(user:String,filePart: FilePart[TemporaryFile])
  case class  Submited(user:String,para:Seq[String])
  case class SHOW(jobtype:String)
  case class InvalidJar(error:String)
  case class JarStored(msg :String)
  case class KillJobs(ids:Seq[String])
  case class ResumeJobs(ids:Seq[String])
  case class Suspend(ids:Seq[String])
  case class JobInfos(id:String)


  def props(config:Config,scheduleProvider: ScheduleProvider,jobDao: JobDAO): Props = Props(classOf[ScheduleManager], config,scheduleProvider,jobDao)

}

class ScheduleManager(config: Config,scheduleProvider: ScheduleProvider,jobDao: JobDAO) extends InstrumentedActor {
  private[this] var hdfs :FileSystem = _
  private[this] val wc = new OozieClient("http://"+config.getString("hadoop.oozie.host")+"/oozie")
  private[this] var apps = Map.empty[String,mutable.Stack[String]];
  private[this] val NAMENODE=config.getString("hadoop.nameode.host")



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
    conf.setProperty("nameNode", s"hdfs://$NAMENODE")
    conf.setProperty("queueName", "default")
    conf.setProperty("oozie.wf.application.path", "${nameNode}/user/hadoop/"+dest+"mr-workflow.xml")
    conf.setProperty("jobTracker", "http://"+config.getString("hadoop.jobTracker.host"))
    val jobId: String = wc.run(conf)
    Logger.info(jobId)
    jobId
  }

  def copyFromLocalFile(src:String,dest:String):Option[String] = {
        try {
          val config = new Configuration
          config.set("fs.default.name", s"hdfs://$NAMENODE")
          hdfs = FileSystem.get(new URI(s"hdfs://$NAMENODE"), config, "hadoop")
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


  /**
    * 最后上传的文件先执行
    * @param user
    * @param path
    */
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


    case KillJobs(ids) => {
      Logger.info(s"kill jobs ids ===>$ids")
      sender ! scheduleProvider.killJobs(ids)
    }

    case ResumeJobs(ids) => sender ! scheduleProvider.resumeJobs(ids)

    case Suspend(ids) => sender ! scheduleProvider.suspendJobs(ids)

    case JobInfos(id) => sender ! scheduleProvider.getJobInfosById(id)

  }




}
