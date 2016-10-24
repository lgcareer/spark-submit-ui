package controllers

import models._
import models.io.UserCountDao
import models.utils.Configuration
import play.api.libs.json._
import play.api.mvc._

import scala.collection.mutable.ArrayBuffer


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
    val workers = json \ "workers"
    val workerList = "{\"workers\":" + workers + "}"

    Ok(workerList)
  }


  def sparkRunTasklist = IsAuthenticated { username => implicit request =>
    val groupName = UserCountDao.userBygroup(username)
    val spark_url = "http://"+config.getString("spark.master.host")+ "/json"
    val sparkDashboard = scala.io.Source.fromURL(spark_url).mkString
    val json = Json.parse(sparkDashboard)

    val runTaskLength = (json \ "activeapps" \\ "id").length
    var activeapps = "{\"activeapps\":["

    for(i <- 0 until runTaskLength){
      val runTaskuser = (json \ "activeapps")(i) \ "user"
      if(groupName == "SuperAdmin"){
        activeapps += (json \ "activeapps")(i) + ","
      }else if(runTaskuser.toString() == "\"" + groupName+ "\""){
        activeapps += (json \ "activeapps")(i) + ","
      }
    }
    activeapps = activeapps.substring(0, activeapps.length - 1)
    activeapps += "]}"
    val boolean =activeapps.contains("[")
    boolean match {
      case false => Ok("""{"activeapps":[]}""")
      case true  => Ok(activeapps)

    }
  }


  def runTasklist = IsAuthenticated { username => implicit request =>
    val spark_url = "http://"+config.getString("spark.master.host")+ "/json"
    val sparkDashboard = scala.io.Source.fromURL(spark_url).mkString
    val json = Json.parse(sparkDashboard)

    /**
     * 权限判断
     */
    val groupName = UserCountDao.userBygroup(username)
    val runTaskLength = (json \ "activeapps" \\ "id").length
    val finishTaskLength = (json \ "completedapps" \\ "id").length
    val runTasklist = json \ "activeapps"
    val finishTasklist = json \ "completedapps"
    var apps = "{\"apps\":["
    for(i <- 0 until runTaskLength){
        val runTaskuser = (json \ "activeapps")(i) \ "user"
        if(groupName == "SuperAdmin"){
          apps += (json \ "activeapps")(i) + ","
        }else if(runTaskuser.toString() == "\"" + groupName+ "\""){
          apps += (json \ "activeapps")(i) + ","
        }
    }
    for(i <- 0 until finishTaskLength){
      val completTaskuser = (json \ "completedapps")(i) \ "user"
      if(groupName == "SuperAdmin"){
        apps += (json \ "completedapps")(i) + ","
      }else if(completTaskuser.toString() == "\"" + groupName+ "\""){
        apps += (json \ "completedapps")(i) + ","
      }
    }

    apps = apps.substring(0, apps.length - 1)
    apps += "]}"
    val boolean =apps.contains("[")
     boolean match {
       case false => Ok("""{"apps":[]}""")
       case true  => Ok(apps)
     }
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

  /**
   * netWork 变化
   *
   */
  def system_network = IsAuthenticated { username => implicit request =>
    val spark_url = "http://iconnect.monitor.sina.com.cn/v1/host/last?ip="+config.getString("spark.host.ha1")
    val spark_args = Json.parse(scala.io.Source.fromURL(spark_url).mkString)
    val network = spark_args \ "data" \ "sysifstat" \ "data" \ "eth2" \config.getString("spark.host.ha1")
    Ok(network)
  }

  /**
   * active_memory
   * @return
   */

  def active_memory = IsAuthenticated {username => implicit request =>
    val spark_url = "http://iconnect.monitor.sina.com.cn/v1/host/last?ip="+config.getString("spark.host.ha1")
    val spark_args = Json.parse(scala.io.Source.fromURL(spark_url).mkString)
    val active_memory = (spark_args \ "data" \ "sysmeminfo" \"data" \ "active").toString()
    val cpu_load_avg = (spark_args \ "data" \ "syscpuidle" \"data" \\ "cpuidle").toList
   val cpuBuffer = ArrayBuffer[Double]()
    for(i <- 0 until cpu_load_avg.length){
      cpuBuffer += cpu_load_avg(i).toString().toDouble
    }
    val cpuRate = cpuBuffer.sum/cpu_load_avg.length
    val memory_cpu = "{\"cpuRate\":" + "\"" + cpuRate + "\",\"active_memory\":" + "" + active_memory + "}"
    Ok(memory_cpu)
  }

}

