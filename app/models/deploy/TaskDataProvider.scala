package models.deploy

import play.api.libs.ws.WS

import scala.concurrent.Await

/**
  * Created by king on 16/8/18.
  */
class TaskDataProvider {


  def findTaskInfoById(): Unit ={

  }

//  val url3 ="http://http://localhost:8080/json/"
//  val timeFuture= WS.url(url3).get() map{
//    response => response.status match {
//      case  200 => Some{
//        val timeline: String = (response.json \ "timeline").as[String]
//        val active: String = (response.json \  "active").as[String]
//        val completed: String = (response.json \  "completed").as[String]
//        val failed: String = (response.json \  "failed").as[String]
//        new JobUi(timeline,active,completed,failed)
//      }
//      case _ => None
//    }
//  }
//
//  val job = Await.result(timeFuture, 50 seconds).get

}
