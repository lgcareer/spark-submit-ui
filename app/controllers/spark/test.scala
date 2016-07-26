package controllers

import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/25.
 */
object test extends Controller with Secured{
  def test = IsAuthenticated {username => implicit request =>
    Ok(views.html.test())
  }
}
