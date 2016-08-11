package controllers
import play.api.mvc._

object Application extends  Controller with Secured {

  def index = IsAuthenticated { username => implicit request =>
    Ok(views.html.index())
  }
}
