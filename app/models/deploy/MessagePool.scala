package models

import akka.actor.{ActorRef, AllForOneStrategy, PoisonPill, Props, Terminated}
import akka.actor.SupervisorStrategy._
import models.actor.InstrumentedActor



object Grow
sealed  trait State
object RUNNING extends State
object FINISHED extends State
object KILLED extends State
object FAILED extends State
object NEW extends  State



/**
  * Created by liangkai on 16/8/31.
  */
object MessagePool {
  def props(webSocketChannel: ActorRef): Props = Props(new MessagePool(webSocketChannel))
}


class MessagePool(webSocketChannel: ActorRef) extends InstrumentedActor {

  override val supervisorStrategy = AllForOneStrategy() {
    case anyException => Stop
  }
  override def preStart()={
    snakes += ("user" -> webSocketChannel)
    context.watch(webSocketChannel)
  }

  var snakes = Map.empty[String, ActorRef]

  override def wrappedReceive: Receive = {
        case RUNNING => webSocketChannel ! Send("任务正在执行!")
        case  FINISHED => webSocketChannel ! Send("任务执行结束!")
        case KILLED  => webSocketChannel ! Send("任务已经KILLED");
        case  FAILED => webSocketChannel ! Send("任务执行失败!")



        case t: Terminated => self ! PoisonPill

 }
}