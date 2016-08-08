package controllers

import models._
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}

/**
  * Created by liangkai1 on 16/8/4.
  * 用户管理相关
  */
object UserManager extends Controller with  Secured{


  /**
    * 用户组Table页面
    * @return
    */
  def userlist =Action{
    Ok(views.html.userlist())
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


  /**
    * 更新用户组
    * @param email
    * @param name
    * @param group
    * @param queue
    * @return
    */
  def udgroup(email:String,name:String,group:String,queue:String)=Action{
    Ok("add succus")
  }



}
