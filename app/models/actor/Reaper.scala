package models.actor

import akka.actor.{ActorRef, Terminated}

import scala.collection.mutable.ArrayBuffer


object Reaper {
  case class WatchMe(ref: ActorRef)
  case object Reaped
}

abstract class Reaper extends InstrumentedActor {
  import Reaper._

  val watched = ArrayBuffer.empty[ActorRef]

  def allSoulsReaped(): Unit

  override def wrappedReceive: Receive = {
    case Reaped =>
      watched.isEmpty

    case WatchMe(ref) =>
      logger.info("Watching actor {}", ref)
      context.watch(ref)
      watched += ref

    case Terminated(ref) =>
      logger.info("Actor {} terminated", ref)
      watched -= ref
      if (watched.isEmpty) allSoulsReaped()
  }
}

class ProductionReaper extends Reaper {
  def allSoulsReaped() {
    logger.warn("Shutting down actor system because all actors have terminated")
    context.system.shutdown()
  }
}

