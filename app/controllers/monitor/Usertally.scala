package controllers

import models.io.UserCountDao
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/22.
 */
object Usertally extends Controller with Secured{

  def usertatol = IsAuthenticated { username => implicit request =>
    //待审核用户
    val aduits = UserCountDao.auditUser()
    Ok(views.html.userelevan(aduits))
  }

  def userGroup = IsAuthenticated { username => implicit request =>
    implicit val userstatotal = Json.writes[UserCountDao]
    val json: JsValue = Json.toJson(UserCountDao.findAll)
    Ok(json)
  }

  /**
   * 用户组Yarn资源计算
   */

  def userResource = IsAuthenticated { username => implicit request =>
      val rate = UserCountDao.userResourceRate(username)
      val rateData = "{\"user\":" + "\"" + username + "\",\"rateData\":" + "" + rate + "}"
    println("userResource==>" + rateData)
     Ok(Json.parse(rateData))
  }

  def userResourceSpark = IsAuthenticated { username => implicit request =>
    val rateSpark = UserCountDao.userResourceRateSpark(username)
    val rateJson = "{\"user\":" + "\"" + username + "\",\"rateSpark\":" + "" + rateSpark + "}"
    Ok(rateJson)
  }

}
