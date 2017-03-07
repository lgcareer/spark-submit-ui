package models

import java.util.concurrent.TimeUnit

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.util.Timeout
import models.JobManagerActor.{Initializ, StoreJar, SubmitJob}
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart
import akka.pattern.ask
import models.deploy.CreateBatchRequest
import models.utils.{Config, Configuration}

import scala.concurrent.duration.Duration
import scala.concurrent._
/**
  * Created by liangkai1 on 16/4/21.
  */
object Execute {

  private[this] var _actorSystem :ActorSystem= _
  private[this] var _jobMange:ActorRef= _
  private[this] val _config:Config =new Configuration
  private[this] val _task_dao :TaskDao =new TaskInfoDao
  private[this] val _dao: JobFileDAO = new JobFileDAO(_config)

  makeSystem

  private  def makeSystem: Unit ={
    _actorSystem = ActorSystem("jobSystem")
    _jobMange=_actorSystem.actorOf((JobManagerActor.props(_config,_dao,_task_dao)), "JobManger")
    _actorSystem.registerOnTermination(System.exit(0))
  }

  /**
    * 初始化参数&&参数超时
    * @param executeModel
    * @return
    */
  private def getRequest(executeModel: ExecuteModel): CreateBatchRequest ={
    val timeoutSecs: Long = _config.getLong("job.request.timeout.seconds")
    Await.result( (_jobMange ? Initializ(executeModel))(Timeout(timeoutSecs,TimeUnit.SECONDS)) ,
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration).asInstanceOf[CreateBatchRequest]
  }


  /**
    * 任务提交&&任务超时
    * @param executeModel
    */
   def main(executeModel: ExecuteModel)={
    val timeoutSecs: Long = _config.getLong("job.submit.timeout.seconds")
      Await.result(
      (_jobMange ? SubmitJob(getRequest(executeModel)))
      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration)
}


  /**
    * 上传jar文件 && 任务超时
    * @param userName
    * @param filePart
    * @return
    */
  def storeJar(userName:String,filePart: FilePart[TemporaryFile]):Any = {
    val timeoutSecs: Long = _config.getLong("job.upload.timeout.seconds")
    Await.result( (_jobMange ? StoreJar(userName,filePart))
      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration);
  }


  /**
    * 根据类型获取任务调度列表
    * @param jobtype
    * @return
    */
//  def jobList(jobtype:String) :String= {
//    val timeoutSecs: Long = _config.getLong("job.submit.timeout.seconds")
//    Await.result( (_scheduleManager ? SHOW(jobtype))
//      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
//      new Timeout(Duration.create(timeoutSecs,"seconds")).duration) toString
//  }

  /**
    * 调度任务提交 && 任务超时
    * @param parameters
    * @return
    */
//  def handleJob(user:String,parameters:Seq[String]) = {
//    val timeoutSecs: Long = _config.getLong("job.submit.timeout.seconds")
//    Await.result( (_scheduleManager ? Submited(user,parameters))
//      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
//      new Timeout(Duration.create(timeoutSecs,"seconds")).duration) toString
//  }

  /**
    * save on hdfs
    * @param user
    * @param filePart
    * @return
    */
//  def storeJarOnHdfs(user:String,filePart: FilePart[TemporaryFile]) ={
//    val timeoutSecs: Long = _config.getLong("job.upload.timeout.seconds")
//    Await.result( (_scheduleManager ? StoreFile(user,filePart))
//      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
//      new Timeout(Duration.create(timeoutSecs,"seconds")).duration)
//  }







}
