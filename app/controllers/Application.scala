package controllers
import models._
import play.api.libs.iteratee.Concurrent.Channel
import play.api.libs.iteratee.{Concurrent, Enumerator, Iteratee}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import play.libs.Akka

import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * webSocket 消息推送(个人)
 */
object Application extends  Controller with Secured {

  val _paths =mutable.Map.empty[String,(Enumerator[String], Channel[String])]

  def index = IsAuthenticated { username => implicit request =>
    Ok(views.html.index())
  }

  def startpush =  WebSocket.using[String] { implicit request =>
    val user: String = request.session.get("email").get
    if(!_paths.get(user).isDefined) {
      val (out,channel) = Concurrent.broadcast[String]
      val webSocketChannel = Akka.system.actorOf(WebSocketChannel.props(channel))
      Akka.system.actorOf(MessagePool.props(webSocketChannel),s"MessagePool$user")
      _paths += (user-> (out, channel));
    }

    val in = Iteratee.foreach[String] { msg =>

    }

    (in,_paths(user)._1)
  }


  def msglist =IsAuthenticated { username => implicit request =>
    implicit val residentWrites = Json.writes[TaskMessage]
    implicit val clusterListWrites = Json.writes[MessageList]
    val json: JsValue = Json.toJson(MessageList(Message.getMessages(username)))
    Ok(json)
  }

  def read(appId:String)=Action{
    Message.deleteMessage(appId)
    Ok(views.html.tasklist())
  }

  def readall=IsAuthenticated{ username => implicit request =>
    Message.deleteAllMessage(username)
    Ok(views.html.tasklist())
  }


}
