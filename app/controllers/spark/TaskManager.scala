package controllers

import models.user.UserAudit
import models._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}

/**
  * Created by liangkai on 16/8/18.
  * 任务运行管理相关
  */
object TaskManager extends Controller with Secured{

   def tasklist=Action{
     Ok(views.html.tasklist())
   }


   def standaloneInfo =IsAuthenticated{
     username => implicit request =>
       implicit val residentWrites = Json.writes[TaskInfo]
       implicit val clusterWrites = Json.writes[TaskList]
       val json: JsValue = Json.toJson(TaskList(TaskInfoDao.getTaskInfoList(username)))
       Ok(json)
   }


  def yarnInfo =IsAuthenticated{
    username => implicit request =>
      implicit val residentWrites = Json.writes[YarnTaskInfo]
      implicit val clusterWrites = Json.writes[YarnTaskList]
      val json: JsValue = Json.toJson(YarnTaskList(TaskInfoDao.getYarnTaskList(username)))
      Ok(json)
  }

}
