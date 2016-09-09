package controllers

import models.io.UserCountDao
import models.utils.Configuration
import play.api.libs.json._
import play.api.mvc._
import models._


object YarnList  extends Controller  with Secured {
   var config : Configuration = new Configuration()

  /**
   * Yarn数据列表显示
   */

  def yarnInfo = IsAuthenticated { username => implicit request =>
//  val yarn_url = "http://"+config.getString("hadoop.yarn.host")+ ":8088/ws/v1/cluster/apps"
    val indexSource = scala.io.Source.fromURL("http://10.77.136.159:8088/ws/v1/cluster/apps").mkString
    val json = Json.parse(indexSource)
    Ok(json)
  }

  /**
   * Yarn数据列表
   * 根据不同权限显示不同yarn任务列表
   * @return
   */
  def yarnlist = IsAuthenticated { username => implicit request =>
    val groupName = UserCountDao.userBygroup(username)
    val group_queue_all :Map[String,String] = UserCountDao.find_group_queue()
    val queueName = group_queue_all(groupName)
    if(queueName == "") {
      Ok(views.html.yarnlist("SuperAdmin"))
     }else {
      Ok(views.html.yarnlist(queueName))
    }
  }


  /**
   * Spark Worker信息
   * @return
   */
  def workerlistdata = IsAuthenticated { username => implicit request =>
    val workersJson = scala.io.Source.fromURL("http://10.77.136.159:8080/json").mkString
    Ok(Json.parse(workersJson))
  }

  def workerInfo = IsAuthenticated { username => implicit request =>
    Ok(views.html.workerInfo.render())
  }

  /**
   * Spark 任务列表 Standalone
   * @return
   */
  def sparklist = IsAuthenticated { username => implicit request =>
    Ok(views.html.sparklist.render())
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

