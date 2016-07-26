package controllers

import models.io.ServicePlan
import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/20.
 */
object Serviceplan extends Controller with Secured{

  def servicedao = IsAuthenticated { username => implicit request =>

    val service =ServicePlan.service()
//    val serviceJson =Json.toJson(service)
//    println("serviceJson" + serviceJson)
    println("调用service方法" + service)
    Ok(views.html.widgets(service))
  }
  def functionplan = IsAuthenticated { username => implicit request =>
    Ok(views.html.widgetsfun())
  }

  def graph = IsAuthenticated {username => implicit request =>
    //spark graph 处理
    val ip = "10.75.16.239"
    Ok(views.html.graph(ip))
  }

}
