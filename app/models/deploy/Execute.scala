package models

import java.util.concurrent.TimeUnit

import akka.actor._
import akka.actor.{ActorRef, ActorSystem, Props}
import akka.util.Timeout
import models.JobManagerActor.{Initializ, StoreJar, SubmitJob}
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart
import akka.pattern.ask
import models.utils.CreateBatchRequest
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
  val _dao: JobFileDAO = new JobFileDAO

  makeSystem

  def makeSystem: Unit ={
    _actorSystem = ActorSystem("jobSystem")
    _jobMange=_actorSystem.actorOf(Props(classOf[JobManagerActor],_dao), "JobManger")
    _actorSystem.registerOnTermination(System.exit(0))
  }

  /**
    * 初始化参数&&参数超时
    * @param executeModel
    * @return
    */
  def getRequest(executeModel: ExecuteModel): CreateBatchRequest ={
    val timeoutSecs: Long = 50
    Await.result( (_jobMange ? Initializ(executeModel))(Timeout(timeoutSecs,TimeUnit.SECONDS)) ,
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration).asInstanceOf[CreateBatchRequest]
  }


  /**
    * 任务提交&&任务超时
    * @param executeModel
    */
  def main(executeModel: ExecuteModel)={
    val timeoutSecs: Long = 300
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
    val timeoutSecs: Long = 100
    Await.result( (_jobMange ? StoreJar(userName,filePart))
      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration);
  }




}
