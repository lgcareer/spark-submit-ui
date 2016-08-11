package controllers

import play.api.mvc.Controller

/**
 * Created by manbu on 16/8/8.
 */
object fairXML extends Controller with Secured {

  def yarnfairXML = IsAuthenticated { username => implicit request =>
    val queueName = "default"
    val memory = "1234"
    val vcpu = "100"
    val maxRunningApps = "10"
    Ok(views.html.yarnfairXML("aa"))
  }

}