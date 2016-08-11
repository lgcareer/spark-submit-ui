package controllers

import models.{Group, UserGroup}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}

/**
  * Created by king on 16/8/8.
  */
object Member extends Controller with  Secured{


  def members=IsAuthenticated{
    username => implicit request =>

    implicit val residentWrites = Json.writes[UserGroup]
    implicit val clusterListWrites = Json.writes[Group]
     val group:UserGroup=UserGroup.findByEmail(username).getOrElse(null)

      val json: JsValue = Json.toJson(Group(UserGroup.findByGroup(group)))
      Ok(json)
  }

}
