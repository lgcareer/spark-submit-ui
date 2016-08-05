package controllers

import models.{User, UserGroup}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}

/**
  * Created by liangkai1 on 16/8/4.
  * 用户管理相关
  */
object UserManager extends Controller{

  def userlist =Action{
    Ok(views.html.userlist())
  }

  def usergroup=Action{
    implicit val residentWrites = Json.writes[User]
    implicit val clusterListWrites = Json.writes[UserGroup]

    val json: JsValue = Json.toJson(UserGroup(User.findAll))
    Ok(json)
  }


}
