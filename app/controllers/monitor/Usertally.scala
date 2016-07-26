package controllers

import models.io.UserCountDao
import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/22.
 */
object Usertally extends Controller with Secured{

  def usertatol = IsAuthenticated { username => implicit request =>
    val users = UserCountDao.userCount()
    val counts = users.length
    Ok(views.html.userelevan(counts))
  }
}
