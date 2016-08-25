package controllers

import models.io.UserCountDao
import play.api.libs.json._
import play.api.mvc._

import scala.collection.mutable.ArrayBuffer


object YarnList extends Controller with Secured {
  /**
   * Yarn数据列表显示
   */
  def yarnInfo = IsAuthenticated { username => implicit request =>
    val indexSource = scala.io.Source.fromURL("http://10.77.136.159:8088/ws/v1/cluster/apps").mkString
    val groupName = UserCountDao.userBygroup(username)
    val group_queue_all :Map[String,String] = UserCountDao.find_group_queue()
    val queueName = group_queue_all(groupName)
    val json = Json.parse(indexSource)
    val jsonNative = json \ "apps" \ "app"
    val jobList = jsonNative \\ "queue"
    var jobQueueList = ArrayBuffer[Any]()
    for(i <- 0 until jobList.size){
       val job = jsonNative(i)
       val queueNatName = job \ "queue"
        if(queueNatName.toString() == ("\""+queueName+"\"")){
          jobQueueList += (job.toString())
        }
    }
      val newjson = models.utils.JsonParse.jsonParse(jobQueueList)
    Ok(newjson)
  }

  /**
   * Yarn数据列表
   * @return
   */
  def yarnlist = IsAuthenticated { username => implicit request =>
    Ok(views.html.yarnlist.render())
  }


  /**
   * Spark Worker信息
   * @return
   */
  def workerlistdata = IsAuthenticated { username => implicit request =>
    val workersJson = scala.io.Source.fromURL("http://10.77.136.159:8080/json").mkString
    val workerlist = Json.parse(workersJson)
    Ok(workerlist)
  }

  def workerInfo = IsAuthenticated { username => implicit request =>
    Ok(views.html.workerInfo.render())
  }

  /**
   * Spark 任务列表 Standalon
   * @return
   */
  def sparklist = IsAuthenticated { username => implicit request =>
    Ok(views.html.sparklist.render())
  }

  /**
   * Dashboard 页面Spark指标 显示
   * @return
   */
  def spark_info = IsAuthenticated { username => implicit request =>
     import models._
     val sparkinfo = Json.parse(SparkTotalinfo.findAll())
    Ok(sparkinfo)

  }


}

