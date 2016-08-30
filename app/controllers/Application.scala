package controllers
import play.api.libs.iteratee.{Concurrent, Enumerator, Iteratee}
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends  Controller with Secured {

  def index = IsAuthenticated { username => implicit request =>
    Ok(views.html.index())
  }




  def ws =  WebSocket.using[String] { implicit request =>
    val username = request.session.get("email").get
    val (out,channel) = Concurrent.broadcast[String]

    val in = Iteratee.foreach[String] {
      msg =>
        if(msg.equals(username)){
              channel push("RESPONSE: wo sh shuo"+msg)
              for(i<- (1 to 1000)){
                Thread.sleep(1000)
                channel.push("aadsdsd=>"+i)
              }
        }

    }

    (in,out)
  }


}
