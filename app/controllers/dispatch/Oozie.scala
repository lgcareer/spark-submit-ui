package controllers


import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/25.
 */
object Oozie extends Controller with Secured{

  def oozie = IsAuthenticated { username => implicit request =>

    /**
     * 接入oozie 调度，调用API
     */
    Ok(views.html.dispatch())
  }
}
