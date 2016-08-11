package controllers

import models._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}

/**
  * Created by liangkai1 on 16/8/4.
  * 用户管理相关
  */
object UserManager extends Controller with  Secured{


  /**
    * 超级用户组Table页面
    * @return
    */
  def userlist =IsAuthenticated{
    username => implicit request =>
     if(UserGroup.hasAdminGroup(username)) Ok(views.html.userlist())  else
    Ok(views.html.memberlist())
  }


  /**
    * 获取所有用户组列表
    * @return
    */
  def usergroup=Action{
    implicit val residentWrites = Json.writes[UserGroup]
    implicit val clusterListWrites = Json.writes[Group]
    val json: JsValue = Json.toJson(Group(UserGroup.findGroup))
    Ok(json)
  }


  /**
    * 移除所在用户组
    * @param email
    * @return
    */
  def rmgroup(email:String)=IsAuthenticated{
    username => implicit request =>
     UserGroup.removeGroup(email) match {
       case 1 => Ok("删除成功!")
       case _ => BadRequest("删除失败!")
     }
  }


  /**
    * 新增&&修改用户到组
    * @return
    */
  def addgroup(email:String,name:String,group:String,queue:String) =IsAuthenticated{
    username => implicit request =>
      val user: UserGroup = UserGroup(email,name,group,queue)
      UserGroup.addOrUpdate(user) match {
        case user=> Ok(user.unapply(user).getOrElse("系统错误,修改失败!"))
      }
  }


  def auditList=Action{
    implicit val residentWrites = Json.writes[User]
    implicit val clusterListWrites = Json.writes[UserList]
    val json: JsValue = Json.toJson(UserList(User.findAuditUser))
    Ok(json)
  }



}
