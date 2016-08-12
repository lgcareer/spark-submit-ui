package controllers

import play.api.mvc.Controller
import play.api.libs.json._

/**
  * Created by manbu on 16/7/22.
  */


object UserName extends Controller with Secured {

  def userName = IsAuthenticated { username => implicit request =>

    val data = "{\"user\":" + "\"" + username + "\"}"

    Ok(Json.parse(data))

  }
}
