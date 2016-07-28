package controllers

import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/27.
 */
object RunTask extends Controller with Secured{

  def runTask = IsAuthenticated {username => implicit request =>
    Ok(views.html.runtask())
  }
  def runTaskLogs = IsAuthenticated {username => implicit request =>
    Ok(views.html.runtasklogs())
  }
}
