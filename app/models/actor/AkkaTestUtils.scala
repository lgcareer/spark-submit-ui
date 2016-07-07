package models.actor

import akka.actor.{ActorRef, ActorSystem}
import akka.pattern.gracefulStop

import scala.concurrent.Await

/**
  * Created by liangkai on 16/7/4.
  */
object AkkaTestUtils {
  import scala.concurrent.duration._

  var timeout = 15 seconds

  def shutdownAndWait(actor: ActorRef) {
    if (actor != null) {
      val stopped = gracefulStop(actor, timeout)
      Await.result(stopped, timeout + (1 seconds))
    }
  }

  def shutdownAndWait(system: ActorSystem) {
    if (system != null) {
      system.shutdown()
      system.awaitTermination(timeout)
    }
  }
}
