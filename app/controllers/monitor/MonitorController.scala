package controllers

import models._
import play.api.libs.ws.WS
import play.api.mvc._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
object MonitorController  extends Controller with Secured{

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  //  def index = Action {
  //    Ok(views.html.index("Your new application is ready."))
  //  }

  def jobs=Action{

    val url3 ="http://10.77.136.159:4040/jobs/json/"
    val timeFuture= WS.url(url3).get() map{
      response => response.status match {
        case  200 => Some{
          val timeline: String = (response.json \ "timeline").as[String]
          val active: String = (response.json \  "active").as[String]
          val completed: String = (response.json \  "completed").as[String]
          val failed: String = (response.json \  "failed").as[String]
          new JobUi(timeline,active,completed,failed)
        }
        case _ => None
      }
    }

    val job = Await.result(timeFuture, 50 seconds).get
    Ok(views.html.jobs(job))

  }

  def streaming (appui:String) =Action {
    val aa = appui
    println("任务监控URL:"+aa)
    val url3 = s"$aa/streaming/json/"
    val timeFuture = WS.url(url3).get() map {
      response => response.status match {
        case 200 => Some {
          val statTable: String = (response.json \ "statTable").as[String]
          new StreamingUi(statTable)
        }
        case _ => None
      }
    }

    val job = Await.result(timeFuture, 50 seconds).get
    Ok(views.html.streaming(job))
  }




}