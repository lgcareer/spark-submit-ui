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
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global
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
    * 任务提交
    * @param executeModel
    */
  def main(executeModel: ExecuteModel) {
    val timeoutSecs: Long = 5
    if(!_actorSystem.isTerminated)
    (_jobMange ? Initializ(executeModel))(Timeout(timeoutSecs,TimeUnit.SECONDS)).map(
      request=>
       _jobMange ! SubmitJob(request.asInstanceOf[CreateBatchRequest])
    )
  }


  /**
    * 上传jar文件
    * @param userName
    * @param filePart
    * @return
    */
  def storeJar(userName:String,filePart: FilePart[TemporaryFile]) = {
    val timeoutSecs: Long = 50
    Await.result( (_jobMange ? StoreJar(userName,filePart))
      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
      new Timeout(Duration.create(50,"seconds")).duration);
  }



}
