package controllers

import play.api.mvc.Controller
import play.api.libs.json._


/*用户名称识别,一般为邮箱格式,如果不是邮箱格式,返回全名*/


object UserName extends Controller with Secured {

  def userName = IsAuthenticated { username => implicit request =>

    var shortName = username

    if (username.contains("@")){
      shortName = username.split("@")(0)
    }

    val data = "{\"user\":" + "\"" + username + "\",\"shortName\":" + "\"" + shortName + "\"}"

    Ok(Json.parse(data))

  }
}
