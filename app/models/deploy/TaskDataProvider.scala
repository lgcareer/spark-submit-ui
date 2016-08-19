package models.deploy

import models.{TaskInfo, YarnTaskInfo}
import play.api.libs.ws.WS

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.Await

/**
  * Created by liangkai on 16/8/18.
  * 数据内容提供者
  */
case class  TaskList(activeapps:Seq[TaskInfo],completedapps:Seq[TaskInfo])
class TaskDataProvider {

  import play.api.libs.json._
  import play.api.libs.functional.syntax._


  /**
         TaskInfo(
                     app_id:String,
                     name:String,
                     cores: Int,
                     memoryperslave:String,
                     state:String,
                     submitdate:String,
                     duration:String
                   )
    */
  implicit val standaloneReads: Reads[TaskInfo] = (
    (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "cores").read[Int] and
      (JsPath \ "memoryperslave").read[String] and
      (JsPath \ "submitdate").read[String] and
      (JsPath \ "state").read[String] and
      (JsPath \ "duration").read[String]
    )(TaskInfo.apply _)

  /**
    * YarnTaskInfo(
                     applicaton_id:String,
                     name:String,
                     apptype:String,
                     queue:String,
                     starttime:String,
                     finishtime:String,
                     state:String,
                     finalstatus:String
                   )
    */

  implicit val localReads: Reads[TaskList] = (
      (JsPath \ "activeapps").read[Seq[TaskInfo]] and
      (JsPath \ "completedapps").read[Seq[TaskInfo]]
    )(TaskList.apply _)



  //val placeResult: JsResult[Place] = json.validate[Place]
  // JsSuccess(Place(...),)



  val saprk_uri ="http://http://localhost:8080/json/"


  def findTaskInfoById(appId:String): Unit ={
      val timeFuture= WS.url(saprk_uri).get() map{
        response => response.status match {
          case  200 => Some{
            val activeapps = (response.json \ "activeapps");





            val completedapps: JsResult[TaskInfo] = (response.json \ "completedapps")(1).validate[TaskInfo]






            //val completedapps: String = (response.json \ "completedapps").as[String]








          }
          case _ => None
        }
      }

      val job = Await.result(timeFuture, 50 seconds).get
  }



}
