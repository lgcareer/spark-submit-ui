package models

import java.io.{File, IOException}
import java.util.concurrent.Executors._

import akka.actor.{ActorRef, Props}
import com.typesafe.config.Config
import models.actor.InstrumentedActor
import models.deploy.CreateBatchRequest
import models.deploy.process.{LineBufferedProcess, SparkProcessBuilder}
import org.apache.commons.lang.StringUtils
import org.apache.spark.{SparkEnv, deploy}
import org.apache.spark.deploy.SparkSubmit
import org.joda.time.DateTime
import play.api.Logger
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global
import scala.collection.mutable

/**
  * Created by liangkai1 on 16/7/11.
  */
case  class ExecuteModel(
                          master:String,
                          executeClass:String,
                          numExecutors:String,
                          driverMemory:String,
                          executorMemory:String,
                          total_executor_cores:String,
                          jarLocation:String,
                          args1:String)

object  JobManagerActor{
  case class SubmitJob(request: CreateBatchRequest)
  case class SubmitJobed(msg:String)
  case class StoreJar(userName: String, filePart: FilePart[TemporaryFile])

  case class Initializ(executeModel: ExecuteModel)
  case class InitError(t: Throwable)
  case class JobLoading(msg: String)
  case class SaveTask(appId:String)


  case class InvalidJar(error:String)
  case class JarStored(uri :String)

  def props(contextConfig: Config): Props = Props(classOf[JobManagerActor], contextConfig)
}

/**
  * [[models.JobDAO]]
  * @param jobDAO
  */
private class JobManagerActor(jobDAO: JobDAO) extends InstrumentedActor{

  import JobManagerActor._

  val config = mutable.HashMap.empty[String,String]
  val executionContext = ExecutionContext.fromExecutorService(newFixedThreadPool(20))

  private val master_uri="spark://localhost:7077";
  private val yarn="yarn-cluster"
  private val nameSpance="usr"
  private val nameLocal="local"
  private val YARN = 1
  private val STANDALONE = 2
  private val MESOS = 4
  private val LOCAL = 8

  /**
    * jar 文件验证
    * @param fileName
    * @return
    */
  def validateJar(fileName:String): Boolean ={
    val prefix=fileName.substring(fileName.lastIndexOf(".")+1);
    StringUtils.equals(prefix,"jar")
  }

  /**
    * 完整校验
    * @param jarBytes
    * @return
    */
  def validateJarBytes(jarBytes: Array[Byte]): Boolean = {
    jarBytes.size > 4 && jarBytes(0) == 0x50 && jarBytes(1) == 0x4b && jarBytes(2) == 0x03 && jarBytes(3) == 0x04
  }

  def sparkSubmit(): String = {
    sparkHome().map { _ + "bin" + File.separator + "spark-submit" }.get
  }

  def sparkHome(): Option[String] = Some(config.get("SPARK_HOME").get)

  override def preStart()={
    config+=
   ("SPARK_HOME"->(File.separator+nameSpance
      +File.separator+
      nameLocal+
      File.separator+
      "spark"
      +File.separator)
      )
  }

  def wrappedReceive: Receive = {

    case Initializ(executeModel) => {
      val request: CreateBatchRequest = CreateBatchRequest()
      request.className=Some(executeModel.executeClass)
      request.numExecutors=Some(executeModel.numExecutors)
      request.total_executor_cores=Some(executeModel.total_executor_cores)
      request.driverMemory=Some(executeModel.driverMemory)
      request.executorMemory=Some(executeModel.executorMemory)
      request.jarLocation = Some(executeModel.jarLocation)

      val masters: Int = executeModel.master match {
        case m if m.startsWith("yarn") =>   request.master=Some(yarn); YARN
        case m if m.startsWith("standalone") => request.master=Some(master_uri);STANDALONE
        case m if m.startsWith("mesos") => MESOS
        case m if m.startsWith("local") => request.master=Some(executeModel.master);LOCAL
      }
      Logger.info(s"select mode $masters")
      val args: Array[String] = executeModel.args1.split("\\s+")
      request.args=args.toList
      sender ! request
    }

    case SubmitJob(request) => {
      runJobFuture(request, sparkEnv =SparkEnv.get,sender)
    }

    case StoreJar(userName,filePart) => {
      if(!validateJar(filePart.filename)){
        sender ! InvalidJar("文件类型不正确!")
      }else{
        val jar = jobDAO.saveJar(userName,DateTime.now(),filePart)
        if(jar.nonEmpty){
          sender ! JarStored(jar)
        }else{
          sender ! InvalidJar("文件路径保存失败!")
        }
      }
    }
  }


  /**
    * 任务部署
    *
    * @param request
    */
  def runJobFuture(request:CreateBatchRequest, sparkEnv: SparkEnv,act :ActorRef): Future[Any] = {
    logger.info("Starting job")
    Future {
      try {
        SparkEnv.set(sparkEnv)
        val builder = new SparkProcessBuilder(act)
        request.className.foreach(builder.className)
        request.driverMemory.foreach(builder.driverMemory)
        request.executorMemory.foreach(builder.executorMemory)
        request.total_executor_cores.foreach(builder.executorCores)
        request.numExecutors.foreach(builder.numExecutors)
        request.jarLocation.foreach(builder.jarLocation)
        request.master.foreach(builder.master)
        val process: LineBufferedProcess = builder.start(Some(sparkSubmit()), request.args)
        val output = process.inputIterator.mkString("\n")
        //val regex = """Shutdown (.*)""".r.unanchored
        val regex_local = """Starting executor ID driver on host localhost(.*)""".r.unanchored
        val regex_id = """Spark cluster with app ID (.*)""".r.unanchored

        output match {
          case regex_local(success) => {
             JobRunFinish("执行结束!")
          }
          case regex_id(success) => {
            JobRunFinish("执行结束!")
          }
          case _ =>
            throw new JobRunExecption(output)
        }
      } catch {
        case e: AbstractMethodError => {
          logger.error("AbstractMethodError")
          throw e
        }
        case e: Throwable => {
          logger.error("Got Throwable", e)
          throw new JobRunExecption(e.getMessage)
        }
      }
    }(executionContext).andThen {
      case scala.util.Success(result:Any) => Logger.info(result.msg); self ! JobLoading(result.msg)
      case scala.util.Failure(error :Throwable) => act ! JobRunExecption(error.getMessage)
    }
  }




}
