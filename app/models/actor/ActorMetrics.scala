package models.actor

import java.util.concurrent.TimeUnit

import akka.actor.Actor
import com.sun.javafx.font.Metrics

/**
  * Created by liangkai on 16/7/4.
  */
trait ActorMetrics extends ActorStack {
  // Timer includes a histogram of wrappedReceive() duration as well as moving avg of rate of invocation
  //val metricReceiveTimer = Metrics.newTimer(getClass, "message-handler",
 //                                           TimeUnit.MILLISECONDS, TimeUnit.SECONDS)

//  override def receive: Receive = {
//    case x =>
//      val context = metricReceiveTimer.time()
//      try {
//        super.receive(x)
//      } finally {
//        context.stop()
//      }
//  }
}
