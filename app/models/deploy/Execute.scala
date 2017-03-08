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
  * Created by kinge on 16/4/21.
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

  private def getRequest(executeModel: ExecuteModel): CreateBatchRequest ={
    val timeoutSecs: Long = _config.getLong("job.request.timeout.seconds")
    Await.result( (_jobMange ? Initializ(executeModel))(Timeout(timeoutSecs,TimeUnit.SECONDS)) ,
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration).asInstanceOf[CreateBatchRequest]
  }


   def main(executeModel: ExecuteModel)={
    val timeoutSecs: Long = _config.getLong("job.submit.timeout.seconds")
      Await.result(
      (_jobMange ? SubmitJob(getRequest(executeModel)))
      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration)
}


  def storeJar(userName:String,filePart: FilePart[TemporaryFile]):Any = {
    val timeoutSecs: Long = _config.getLong("job.upload.timeout.seconds")
    Await.result( (_jobMange ? StoreJar(userName,filePart))
      (Timeout(timeoutSecs,TimeUnit.SECONDS)),
      new Timeout(Duration.create(timeoutSecs,"seconds")).duration);
  }







}
