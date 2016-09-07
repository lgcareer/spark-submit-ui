package controllers

import play.api.mvc.Controller

/**
 * Created by manbu on 16/8/8.
 */
object fairXML extends Controller with Secured {

  def yarnfairXML = IsAuthenticated { username => implicit request =>
    Ok(views.html.yarnfairXML("aa"))
  }

}