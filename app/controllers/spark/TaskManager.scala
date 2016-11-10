package controllers

import com.google.inject.Inject
import models.TaskDataProvider.AppDataObject
import models._
import models.utils.Config
import play.api.Logger
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WS
import play.api.mvc.{Action, Controller, Results}

import scala.concurrent.Await
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by liangkai on 16/8/18.
  * 任务运行时管理相关
  */
class TaskManager @Inject() (config: Config,taskProvider:TaskProvider[AppDataObject],taskDao: TaskDao) extends Controller with Secured{

  import play.api.libs.json._
  import play.api.libs.functional.syntax._

   def tasklist=Action{
     Ok(views.html.tasklist())
   }


   def standaloneInfo =IsAuthenticated{
     username => implicit request =>
       implicit val residentWrites = Json.writes[TaskInfo]
       implicit val clusterWrites = Json.writes[TaskList]
       val json: JsValue = Json.toJson(TaskList(taskDao.getTaskInfoList(username)))
       Ok(json)
   }



  def yarnInfo =IsAuthenticated{
    username => implicit request =>

      implicit val yarnWrites: Writes[YarnTaskInfo] = (
        (JsPath \ "application_id").write[String] and
          (JsPath \ "name").write[String] and
          (JsPath \ "apptype").write[String] and
          (JsPath \ "queue").write[String] and
          (JsPath \ "starttime").write[Long] and
          (JsPath \ "state").write[String] and
          (JsPath \ "finishtime").write[Long]
        )(unlift(YarnTaskInfo.unapply))


      implicit val clusterWrites = Json.writes[YarnTaskList]
      val json: JsValue = Json.toJson(YarnTaskList(taskDao.getYarnTaskList(username)))
      Ok(json)

  }

  def killTask(appId:String): Unit ={
    Runtime.getRuntime.exec(s"yarn application -kill $appId")
  }


  def kill(appId:String) =IsAuthenticated{
    username => implicit request =>

      if(appId.startsWith("application")){Map("id"->Seq(appId),"terminate"->Seq("true"))
        killTask(appId)
      }else{
        val spark_master = config.getString("spark.master.host")
           WS.url("http://"+spark_master+"/app/kill/").withQueryString(("terminate","true")).withQueryString(("id",appId)).post("content") map{
          response => response.status match {
            case  200 => Some{

            }
            case _ => None
          }
        }
      }
      Ok("KILLED")
  }


  def rerun(appId:String) =IsAuthenticated{
    username => implicit request =>
      val executeModel: ExecuteModel = taskDao.getTaskArgs(appId)
      Execute.main(executeModel) match {
        case JobSubmitSuccess(id) =>  {
          Logger.info(s"旧任务Id====> $appId,新任务id====> $id")
          /**
            *保存新的任务参数
            *将旧的任务删除,重新添加到队列
            */
          taskDao.saveTaskArgs(executeModel)(id)
          taskProvider.coverTask(appId)
          taskProvider.loadTaskInfo(AppDataObject(id,username));
          Ok(id)
        }
        case JobRunExecption(error) => Ok(error)
        case _ => NotFound
      }
  }





}
