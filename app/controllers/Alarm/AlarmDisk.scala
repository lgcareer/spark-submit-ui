package controllers

import models.utils.TimeParseUtils
import play.api.libs.json.Json
import play.api.mvc.Controller

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
 * Created by manbu on 16/7/25.
 * 报警管理
 */
object AlarmDisk extends Controller with Secured{

  def alarmDiskInterface = IsAuthenticated { username => implicit request =>
    /**
     * 调用it.sina接口
     * http://iconnect.monitor.sina.com.cn/v1/host/last?ip=10.75.16.220
     */
    val sinaWatch = "http://iconnect.monitor.sina.com.cn/v1/host/last?ip=10.75.16.220"
    val indexSource = scala.io.Source.fromURL(sinaWatch).mkString
    val json = Json.parse(indexSource)
    val data = json \ "data" \ "sysdiskinfo" \ "data" \ "/data1"

    /**
     * 读取文件
     */
    //时间数组
    val timeArray = new ArrayBuffer[Object]()
    //master apps 个数
    val masterAppArray = new ArrayBuffer[Object]()
    //work free_mb
    val workFreeMbArray = new ArrayBuffer[Object]()
    //jvm pools used
    val jvmPoolsArray = new ArrayBuffer[Object]()
    //jvm total used
    val jvmTotalArray = new ArrayBuffer[Object]()

    val time = Source.fromFile("public/data/master.apps.csv").getLines().toList
    val workerMetics = Source.fromFile("public/data/worker.memFree_MB.csv").getLines().toList
    val jvmPoolMetics = Source.fromFile("public/data/jvm.pools.Metaspace.used.csv").getLines().toList
    val jvmUserMetics = Source.fromFile("public/data/jvm.total.used.csv").getLines().toList

    for(tuple <- time){
      val timeStamp = tuple.split(",")(0)
      val apps = tuple.split(",")(1)
      val timeDate = TimeParseUtils.timeFormat(timeStamp)
      timeArray += timeDate
      masterAppArray += apps
    }

    for(workTuple <- workerMetics){
      val workerFreeMB = workTuple.split(",")(1)
      workFreeMbArray += (workerFreeMB.toFloat/1024).toString + "g"
    }

    for(jvmPoolTuple <- jvmPoolMetics){
      val jvmPoolsMetaspaceUsed = jvmPoolTuple.split(",")(1)
      jvmPoolsArray += (jvmPoolsMetaspaceUsed.toFloat/1024/1024).toString + "g"
    }

    for(jvmUserTuple <- jvmUserMetics){
      val jvmTotalUsed = jvmUserTuple.split(",")(1)
      jvmTotalArray += (jvmTotalUsed.toFloat/1024/1024).toString + "mb"
    }

    println(timeArray)
    println(masterAppArray)
    println(workFreeMbArray)
    println(jvmPoolsArray)
    println(jvmTotalArray)




    Ok(data)
  }
  def alarmDisk = IsAuthenticated { username => implicit request =>
    Ok(views.html.alarm())
  }

}
