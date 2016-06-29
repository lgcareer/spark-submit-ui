package controllers


import play.api.mvc._
import play.api.libs.json.Json


object YarnList extends Controller with Secured {

  def yarnInfo = IsAuthenticated { username => implicit request =>
    val indexSource = scala.io.Source.fromURL("http://10.77.136.159:8088/ws/v1/cluster/apps").mkString
    val json = Json.parse(indexSource)

    Ok(json)
  }

  def yarnlist = IsAuthenticated { username => implicit request =>

    Ok(views.html.yarnlist.render())
  }

  def workerlist = IsAuthenticated { username => implicit request =>
    val workersJson = scala.io.Source.fromURL("http://10.77.136.159:8080/json").mkString
    val workerlist = Json.parse(workersJson)
    Ok(workerlist)
  }

  def sparklist = IsAuthenticated { username => implicit request =>

    Ok(views.html.sparklist.render())
  }

  //从数据库获取数据发送到接口
  def spark_info = IsAuthenticated { username => implicit request =>
     import models.SparkTotalinfo
//   val sparkinfo = SparkTotalinfo.findAll()
     val sparkinfo = Json.parse(SparkTotalinfo.findAll())
    Ok(sparkinfo)

  }
}

