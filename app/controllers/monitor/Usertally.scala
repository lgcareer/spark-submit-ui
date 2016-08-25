package controllers

import models.io.UserCountDao
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/22.
 */
object Usertally extends Controller with Secured{

  def usertatol = IsAuthenticated { username => implicit request =>
    val users = UserCountDao.userCount()
    implicit val userstatotal = Json.writes[UserCountDao]
    val json: JsValue = Json.toJson(UserCountDao.findAll)
    val counts = users.length
    val aduits = UserCountDao.auditUser()
    Ok(views.html.userelevan(aduits))
  }

  def userGroup = IsAuthenticated { username => implicit request =>
    implicit val userstatotal = Json.writes[UserCountDao]
    val json: JsValue = Json.toJson(UserCountDao.findAll)
    Ok(json)
  }

  /**
   * 用户组资源计算
   */

  def userResource = IsAuthenticated { username => implicit request =>
      val rate = UserCountDao.userResourceRate(username)
      val rateData = "{\"user\":" + "\"" + username + "\",\"rateData\":" + "" + rate + "}"
     Ok(Json.parse(rateData))
  }


}
