package controllers

import models.io.UserCountDao
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/22.
 */
object Usertally extends Controller with Secured{

  def usertatol = IsAuthenticated { username => implicit request =>
    val users = UserCountDao.userCount()
    implicit val userstatotal = Json.writes[UserCountDao]
    val json: JsValue = Json.toJson(UserCountDao.findAll)
    val counts = users.length
    val aduits = UserCountDao.auditUser()
    Ok(views.html.userelevan(aduits))
  }

  def userGroup = IsAuthenticated { username => implicit request =>
    implicit val userstatotal = Json.writes[UserCountDao]
    val json: JsValue = Json.toJson(UserCountDao.findAll)
    //用户组资源计算
    val group = UserCountDao.groupResouce(username)
    val scheduleryarn = scala.io.Source.fromURL("http://10.77.136.159:8088/ws/v1/cluster/scheduler").mkString
    val scheduler :JsValue = Json.parse(scheduleryarn)
    val childQueues = (scheduler \ "scheduler" \ "schedulerInfo"
                        \ "rootQueue" \ "childQueues")
    println("childQueues: " + childQueues)
    val queueNameList = childQueues \\ "queueName"
    val queueNameListSize = queueNameList.length
    println("queueNameListSize :" + queueNameListSize)
    for(i <- 0 until queueNameListSize){
      val node = childQueues(i)

      val queueName = node \ "queueName"
      val maxMemory = node \ "maxResources"
      println("queueName :" +queueName)
      println("maxMemory :" +maxMemory)


    }
//
//    val jsonchildQueues :JsValue = Json.parse(childQueues.toString())
//    println("jsonchildQueues :" + jsonchildQueues)




//    var map = Map[String,String]()
//    for(queue <- jsonchildQueues){
//            val queueNameList = queue \ "queueName"
//              println(queueNameList)


//      println(queueNameList)
//      for (name <- queueNameList){
////        map += (name.toString() -> queue.toString()) )
//        val queueName = name.toString()
//        if(queueName == "\"root.pt_UserGrowth\""){
//          val resource = queue \ "maxResources"
//          println(resource)
//        }
//      }


//      queueName match {
//       case _ => "root.pt_UserGrowth"
//         val resource = queue \\ "maxResources"
//         println(resource)
//       case _ => None
//       }




//      println("queueName:" +queueName)
//    }




    Ok(json)
  }
}
