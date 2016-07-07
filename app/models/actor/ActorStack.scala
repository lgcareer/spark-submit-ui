package models.actor

import akka.actor.Actor

/**
  * Created by liangkai on 16/7/4.
  */
trait ActorStack extends Actor {
  /** Actor classes should implement this partialFunction for standard actor message handling */
  def wrappedReceive: Receive

  /** Stackable traits should override and call super.receive(x) for stacking functionality */
  def receive: Receive = {
    case x => if (wrappedReceive.isDefinedAt(x)) wrappedReceive(x) else unhandled(x)
  }
}
