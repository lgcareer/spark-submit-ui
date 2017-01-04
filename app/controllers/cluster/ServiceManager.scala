package controllers

import controllers.Secured
import play.api.mvc.{Action, Controller}

/**
  * Created by king on 2016/12/20.
  * 服务管理
  */
object ServiceManager extends Controller with Secured{

  def summary =Action{
    Ok(views.html.services())
  }

}
