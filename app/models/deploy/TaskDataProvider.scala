package models

import com.google.inject.Inject
import play.api.Logger
import play.api.libs.ws.WS

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

/**
  * Created by liangkai on 16/8/18.
  * 数据内容提供者
  */
case class  TaskData(activeapps:Seq[TaskInfo],completedapps:Seq[TaskInfo])
case class  YarnData(apps:Seq[YarnTaskInfo])
case class  YarnTaskInfoList(app:YarnData,app2:YarnData)

case class AppDataObject(appId:String,url:String,user:String)

class TaskDataProvider @Inject()(taskDao: TaskDao)extends TaskProvider[AppDataObject]{


  import play.api.libs.json._
  import play.api.libs.json.Reads._
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
                     finalstatus:String
                   )
    */
  implicit val yarnReads: Reads[YarnTaskInfo] = (
      (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "applicationType").read[String] and
      (JsPath \ "queue").read[String] and
      (JsPath \ "startedTime").read[String] and
      (JsPath \ "state").read[String] and
      (JsPath \ "finishtime").read[String] and
      (JsPath \ "finalStatus").read[String]
    )(YarnTaskInfo.apply _)

//  implicit val yarnDataReads:Reads[YarnData]=((JsPath \ "apps").read[Seq[models.YarnTaskInfo]] and null)(YarnData.apply _)
//
//  implicit val yarnListReads: Reads[YarnTaskInfoList]=(
//    (JsPath \ "app").read[String])
//    (YarnTaskInfoList.apply _)




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
          response.json .validate[TaskData].fold(
            invalid = {
              fieldErrors => fieldErrors.foreach(x => {
                Logger.error("field: " + x._1 + ", errors: " + x._2)
              })
                None
            },
            valid = {
              tasks => {

              }
            })
        }
        case _ => None
      }
    }
  }





}
