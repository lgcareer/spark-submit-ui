package models

import java.util.concurrent.TimeUnit

import akka.actor._
import akka.actor.{ActorRef, ActorSystem, Props}
import akka.util.Timeout
import models.JobManagerActor.{Initializ, StoreJar, SubmitJob}
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart
import akka.pattern.ask
import com.google.inject.Inject
import models.deploy.CreateBatchRequest
import models.utils.{Config, Configuration}
import play.api.Logger

import scala.concurrent.duration.Duration
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent
/**
  * Created by leslie on 16/4/21.
  */
object Execute {

  var _actorSystem :ActorSystem= _
  var _jobMange:ActorRef= _
  val _config:Config =new Configuration
  val _task_dao :TaskDao =new TaskInfoDao
  val _dao: JobFileDAO = new JobFileDAO(_config)

  makeSystem

  def makeSystem: Unit ={
    _actorSystem = ActorSystem("jobSystem")
    _jobMange=_actorSystem.actorOf((JobManagerActor.props(_config,_dao,_task_dao)), "JobManger")
    _actorSystem.registerOnTermination(System.exit(0))
  }

  /**
    * 初始化参数&&参数超时
    * @param executeModel
    * @return
    */
  def getRequest(executeModel: ExecuteModel): CreateBatchRequest ={
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
    * 上传jar文件&&任务超时
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




}
