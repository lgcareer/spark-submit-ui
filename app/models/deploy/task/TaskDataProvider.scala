package models.deploy.task

import com.google.inject.Inject
import models.{MatchEngine, TaskDao, TaskInfo, YarnTaskInfo}
import play.api.Logger
import play.api.libs.ws.WS

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

/**
  * Created by liangkai on 16/8/18.
  * 数据内容提供者
  */
object TaskDataProvider{

  case class  TaskData(activeapps:Seq[TaskInfo],completedapps:Seq[TaskInfo])

  case class AppDataObject(appId:String,url:String,user:String)

  case class YarnTaskInfoList(app: Seq[YarnTaskInfo])
}

class TaskDataProvider @Inject()(taskDao: TaskDao)extends TaskProvider[AppDataObject]{


  import play.api.libs.functional.syntax._
  import play.api.libs.json.Reads._
  import play.api.libs.json._


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
      (JsPath \ "memoryperslave").read[Long] and
      (JsPath \ "state").read[String] and
      (JsPath \ "submitdate").read[String] and
      (JsPath \ "duration").read[Long]
    )(TaskInfo.apply _)



  implicit val taskListReads: Reads[TaskData] = (
    (JsPath \ "activeapps").read[Seq[TaskInfo]] and
      (JsPath \ "completedapps").read[Seq[TaskInfo]]
    )(TaskData.apply _)



  /**
    * YarnTaskInfo(
                     applicaton_id:String,
                     name:String,
                     apptype:String,
                     queue:String,
                     starttime:String,
                     finishtime:String,
                     state:String,
                   )
    */
  implicit val yarnReads: Reads[YarnTaskInfo] = (
      (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "applicationType").read[String] and
      (JsPath \ "queue").read[String] and
      (JsPath \ "startedTime").read[Long] and
      (JsPath \ "state").read[String] and
      (JsPath \ "finishedTime").read[Long]
    )(YarnTaskInfo.apply _)



  implicit  val areads = (__ \ 'apps \ 'app).read[Seq[YarnTaskInfo]].map{ l => YarnTaskInfoList(l) }




  def findTaskInfo(appId:String)(user:String): Unit ={
    Logger.info(s"用户任务Id====>$appId")
    MatchEngine.matchURI(appId).map(
      app=>
      app._1 match {
        case m if m.equals("yarn") => proTaskOnYarn(AppDataObject(appId,app._2,user))
        case m if m.equals("standalone") => proTaskOnMaster(AppDataObject(appId,app._2,user))
        //case m if m.equals("local") => saveTaskOnLocal(m,appId)
      }
    )
  }



  override  def proTaskOnMaster(app: AppDataObject): Unit ={
     WS.url(app.url).get() map{
      response => response.status match {
        case  200 => Some{
          response.json .validate[TaskData].fold(
            invalid = {
              fieldErrors => fieldErrors.foreach(x => {
                Logger.error("field: " + x._1 + ", errors: " + x._2)
              })
                None
            },
            valid = {
              tasks => {
                /**
                  * 将正在运行列表与id匹配,取出第一个任务信息保存
                  */
                  val runingTask=tasks.activeapps.filter(_.app_id.equals(app.appId))(0)
                  taskDao.saveTask(runingTask)(app.user)
              }
            })
        }
        case _ => None
      }
    }
  }



  override  def proTaskOnYarn(app:AppDataObject): Unit ={
    WS.url(app.url).get() map{
      response => response.status match {
        case  200 => Some{
          response.json .validate[YarnTaskInfoList].fold(
            invalid = {
              fieldErrors => fieldErrors.foreach(x => {
                Logger.error("field: " + x._1 + ", errors: " + x._2)
              })
                None
            },
            valid = {
              tasks => {
                 val runingTask= tasks.app.filter(_.applicaton_id.equals(app.appId))(0)
                  taskDao.saveYarnTask(runingTask)(app.user)
              }
            })
        }
        case _ => None
      }
    }
  }





}
