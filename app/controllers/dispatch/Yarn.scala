package controllers

import models.utils.XmlParse
import play.api.libs.json.Json
import play.api.mvc.Controller

/**
 * Created by manbu on 16/8/8.
 */
object Yarn extends Controller with Secured {

  def yarnSchedulerJson = IsAuthenticated { username => implicit request =>
    val Jsonyarn = scala.io.Source.fromURL("http://10.77.136.159:8088/ws/v1/cluster/scheduler").mkString
    val json = Json.parse(Jsonyarn)
    Ok(json)
  }
  def yarnDispatch = IsAuthenticated { username => implicit request =>
    Ok(views.html.dispatchyarn("test"))
  }
  def UserResource(queueName:String,
                   mem:String,
                   cpu:String,
                   apps:String) = IsAuthenticated { username => implicit request =>
     XmlParse.XMLParses(queueName,mem,cpu,apps)
    Ok(views.html.userlist())
  }
}