package controllers

import models.io.UserCountDao
import play.api.mvc.Controller
import play.api.libs.json._


/*用户名称识别,一般为邮箱格式,如果不是邮箱格式,返回全名*/


object UserName extends Controller with Secured {

  def userName = IsAuthenticated { username => implicit request =>
    //获取用户名
    var shortName = username
    if (username.contains("@")){
      shortName = username.split("@")(0)
    }
    //判断用户权限
    val group = UserCountDao.userBygroup(username)
    //用户组和队列映射
    val group_queue = UserCountDao.find_group_queue()
    val queue = group_queue(group)
    val data = "{\"user\":" + "\"" + username + "\",\"shortName\":" + "\"" + shortName + "\",\"queueName\":" + "\"" + queue +"\"}"
    Ok(Json.parse(data))

  }
}
