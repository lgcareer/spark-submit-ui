package controllers

import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/25.
 */
object AlarmDisk extends Controller with Secured{

  def alarmDisk = IsAuthenticated { username => implicit request =>

    Ok(views.html.alarm())
  }
}
