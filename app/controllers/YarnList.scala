package controllers

import models._
import modules.DashboardMetrics
import play.api.mvc._
import play.api.libs.json.Json


object YarnList extends Controller with Secured {

  def yarnInfo = IsAuthenticated { username => implicit request =>
    val indexSource = scala.io.Source.fromURL("http://10.209.0.207:8088/ws/v1/cluster/apps").mkString
    val json = Json.parse(indexSource)

    Ok(json)
  }

  def yarnlist = IsAuthenticated { username => implicit request =>

    Ok(views.html.yarnlist.render())
  }

  def workerlist = IsAuthenticated { username => implicit request =>
    val workersJson = scala.io.Source.fromURL("http://10.209.0.207:8080/json").mkString
    val workerlist = Json.parse(workersJson)
    Ok(workerlist)
  }
}

