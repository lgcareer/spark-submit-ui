package controllers

import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/25.
 * 报警管理
 */
object AlarmDisk extends Controller with Secured{

  def alarmDisk = IsAuthenticated { username => implicit request =>

    /**
     * 调用it.sina接口
     */
    Ok(views.html.alarm())
  }
}
