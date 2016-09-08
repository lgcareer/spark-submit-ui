package controllers

import play.api.mvc.Controller

/**
 * Created by manbu on 16/8/8.
 * 任务调度
 */
object fairXML extends Controller with Secured {

  def yarnfairXML = IsAuthenticated { username => implicit request =>

    /**
     * yarn任务调度
     */
    Ok(views.html.yarnfairXML())
  }

}