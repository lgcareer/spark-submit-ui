package models.actor

import akka.actor.Actor

/**
  * Created by liangkai on 16/7/4.
  */
abstract class InstrumentedActor extends Actor with Slf4jLogging with ActorMetrics {

  override def preRestart(reason: Throwable, message: Option[Any]) {
    logger.error("About to restart actor due to exception:", reason)
    super.preRestart(reason, message)
  }

  override def postStop() { logger.warn("Shutting down {}", getClass.getName) }
}
