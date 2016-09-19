package controllers

import models._
import models.io.UserCountDao
import models.utils.Configuration
import play.api.libs.json._
import play.api.mvc._


object YarnList  extends Controller  with Secured {
   var config : Configuration = new Configuration()

  /**
   * Yarn数据列表显示
   */

  def yarnInfo = IsAuthenticated { username => implicit request =>
    val groupName = UserCountDao.userBygroup(username)
    val group_queue = UserCountDao.find_group_queue()
    val queue = group_queue(groupName)
    val yarn_url = "http://"+config.getString("hadoop.yarn.host")+ "/ws/v1/cluster/apps"
    val indexSource = scala.io.Source.
      fromURL(yarn_url).mkString
    val json = Json.parse(indexSource)
    val length = (json \\ "queue").length
    if (queue == "") {
      Ok(json)
    } else {
      var strjson = "{\"apps\":{\"app\":["
      for (i <- 0 until length) {
        val app = (json \ "apps" \ "app")(i)
        if (app.toString().contains(queue)) {
          strjson += app + ","
        }
      }
      strjson = strjson.substring(0, strjson.length - 1)
      strjson += "]}}"
      Ok(strjson)
    }
  }
  /**
   * Yarn数据列表
   * 根据不同权限显示不同yarn任务列表
   * @return
   */
  def yarnlist = IsAuthenticated { username => implicit request =>
      Ok(views.html.yarnlist())
  }


  /**
   * Spark Worker信息
   * @return
   */
  def workerlist = IsAuthenticated { username => implicit request =>
    val spark_url = "http://"+config.getString("spark.master.host")+ "/json"
    val sparkDashboard = scala.io.Source.fromURL(spark_url).mkString
    val json = Json.parse(sparkDashboard)
    val workerList = json \ "workers"
    Ok(workerList)
  }

  def runTasklist = IsAuthenticated { username => implicit request =>
    val spark_url = "http://"+config.getString("spark.master.host")+ "/json"
    val sparkDashboard = scala.io.Source.fromURL(spark_url).mkString
    val json = Json.parse(sparkDashboard)
    val runTaskLength = (json \ "activeapps" \\ "id").length
    val finishTaskLength = (json \ "completedapps" \\ "id").length
    val runTasklist = json \ "activeapps"
    val finishTasklist = json \ "completedapps"
    var apps = "{\"apps\":["
    for(i <- 0 until runTaskLength){
         apps += (json \ "activeapps")(i) + ","
    }
    for(i <- 0 until finishTaskLength){
        apps += (json \ "completedapps")(i) + ","
    }
    apps = apps.substring(0, apps.length - 1)
    apps += "]}"
    Ok(apps)
  }


  def workerInfo = IsAuthenticated { username => implicit request =>
    Ok(views.html.workerInfo())
  }

  /**
   * Spark 任务列表 Standalone
   * @return
   */
  def sparklist = IsAuthenticated { username => implicit request =>
    Ok(views.html.sparklist())
  }

  /**
   * Dashboard 页面Spark指标
   * 数据库获取(spark_total_info)
   * @return
   */
  def spark_info = IsAuthenticated { username => implicit request =>
     val sparkinfo = Json.parse(SparkTotalinfo.findAll())
    Ok(sparkinfo)

  }


}

