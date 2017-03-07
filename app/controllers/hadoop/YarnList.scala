package controllers

import java.net.URL

import models.SparkTotalinfo
import models.utils.Configuration
import play.api.libs.json._
import play.api.mvc._

import scala.collection.mutable.ArrayBuffer
import scala.io.Source


object YarnList  extends Controller  with Secured {
   var config : Configuration = new Configuration()

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

//  def sparkRunTasklist = IsAuthenticated { username => implicit request =>
//    val groupName = UserCountDao.userBygroup(username)
//    val spark_url = "http://"+config.getString("spark.master.host")+ "/json"
//    val sparkDashboard = scala.io.Source.fromURL(spark_url).mkString
//    val json = Json.parse(sparkDashboard)
//
//    val runTaskLength = (json \ "activeapps" \\ "id").length
//    var activeapps = "{\"activeapps\":["
//
//    for(i <- 0 until runTaskLength){
//      val runTaskuser = (json \ "activeapps")(i) \ "user"
//      if(groupName == "SuperAdmin"){
//        activeapps += (json \ "activeapps")(i) + ","
//      }else if(runTaskuser.toString() == "\"" + groupName+ "\""){
//        activeapps += (json \ "activeapps")(i) + ","
//      }
//    }
//    activeapps = activeapps.substring(0, activeapps.length - 1)
//    activeapps += "]}"
//    val boolean =activeapps.contains("[")
//    boolean match {
//      case false => Ok("""{"activeapps":[]}""")
//      case true  => Ok(activeapps)
//
//    }
//  }


//  def runTasklist = IsAuthenticated { username => implicit request =>
//    val spark_url = "http://"+config.getString("spark.master.host")+ "/json"
//    val sparkDashboard = scala.io.Source.fromURL(spark_url).mkString
//    val json = Json.parse(sparkDashboard)
//
//    /**
//     * 权限判断
//     */
//    val groupName = UserCountDao.userBygroup(username)
//    val runTaskLength = (json \ "activeapps" \\ "id").length
//    val finishTaskLength = (json \ "completedapps" \\ "id").length
//    val runTasklist = json \ "activeapps"
//    val finishTasklist = json \ "completedapps"
//    var apps = "{\"apps\":["
//    for(i <- 0 until runTaskLength){
//        val runTaskuser = (json \ "activeapps")(i) \ "user"
//        if(groupName == "SuperAdmin"){
//          apps += (json \ "activeapps")(i) + ","
//        }else if(runTaskuser.toString() == "\"" + groupName+ "\""){
//          apps += (json \ "activeapps")(i) + ","
//        }
//    }
//    for(i <- 0 until finishTaskLength){
//      val completTaskuser = (json \ "completedapps")(i) \ "user"
//      if(groupName == "SuperAdmin"){
//        apps += (json \ "completedapps")(i) + ","
//      }else if(completTaskuser.toString() == "\"" + groupName+ "\""){
//        apps += (json \ "completedapps")(i) + ","
//      }
//    }
//
//    apps = apps.substring(0, apps.length - 1)
//    apps += "]}"
//    val boolean =apps.contains("[")
//     boolean match {
//       case false => Ok("""{"apps":[]}""")
//       case true  => Ok(apps)
//     }
//  }


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

    var spark_total:Map[Any,Any] = Map()

     val sparkinfo = Json.parse(SparkTotalinfo.findAll())

    val sparkURL= "http://"+config.getString("spark.master.host")+""
    val source = Source.fromURL(new URL(sparkURL)).mkString
    val regex_key =
      """(?<=<strong>).*?(?=:</strong>)""".r
    val regex_value =
        """(?s)(?<=</strong>).*?(?=</li>)""".r
    val alive_key = regex_key.findAllIn(source)
    val alive_value = regex_value.findAllIn(source)
      val keyList = alive_key.toList
      val valueList = alive_value.toList
    for(i <- 0 until keyList.length){
      val arg_key = keyList(i)
      val arg_value = valueList(i)
      spark_total += (arg_key -> arg_value)
    }

      val alive_workers = spark_total("Alive Workers")
      val cores = spark_total("Cores in use").toString.split(",")(0)+","+spark_total("Cores in use").toString.split(",")(1).trim
      val memory = spark_total("Memory in use").toString.split(",")(0).trim+","+spark_total("Memory in use").toString.split(",")(1).trim
      val applications = spark_total("Applications").toString.split(",")(0).trim+","+spark_total("Applications").toString.split(",")(1).trim
      val drivers = spark_total("Drivers").toString.split(",")(0).trim+","+spark_total("Drivers").toString.split(",")(0).trim
      val status = spark_total("Status")

    val spark_info_json = "{\"alive_workers\":"+"\""+alive_workers+"\""+","+"\"cores\":"+"\""+cores+"\""+","+"\"memory\":"+"\""+memory+"\""+","+"\"applications\":"+"\""+applications+"\""+","+"\"drivers\":"+"\""+drivers+"\""+","+"\"status\":"+"\""+status+"\""+"}"

    println(spark_info_json)
//    Ok(sparkinfo)
    Ok(spark_info_json)
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

