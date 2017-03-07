package controllers
import java.text.SimpleDateFormat
import java.util.Date

import com.google.inject.Inject
import models._
import models.io.{Message, MessageList, TaskMessage}
import models.metrics.{MetricsProvider}
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
class Application @Inject()(metricsProvider: MetricsProvider) extends Controller with Secured {

  val _paths =mutable.Map.empty[String,(Enumerator[String], Channel[String])]

  def index = IsAuthenticated { username => implicit request =>
    val rpcInfo: RPCInfo = metricsProvider.getMetricMouled[RPCInfo](RPCInfo.getClass)
    val dfsInfo: DFSInfo = metricsProvider.getMetricMouled[DFSInfo](DFSInfo.getClass)
    val memInfo: MEMInfo = metricsProvider.getMetricMouled[MEMInfo](MEMInfo.getClass)
    Ok(views.html.index(rpcInfo,dfsInfo,memInfo,getNowDate))
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

  private[this] def getNowDate:String ={
    val before = 3*60*60*1000
    val currentTime = new Date(System.currentTimeMillis()-before)
    //将当前时间设置成整点
    currentTime.setMinutes(0)
    val formatter = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss")
    formatter.format(currentTime)
  }





}
