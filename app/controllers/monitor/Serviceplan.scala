package controllers

import models.io.ServicePlan
import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/20.
 */
object Serviceplan extends Controller with Secured{

  def servicedao = IsAuthenticated { username => implicit request =>
    val service =ServicePlan.service()
    Ok(service)
  }

  def serviceplan = IsAuthenticated { username => implicit request =>
    Ok(views.html.widgets())
  }

  def functionplan = IsAuthenticated { username => implicit request =>
    Ok(views.html.widgetsfun())
  }

}
