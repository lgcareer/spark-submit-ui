package models

import akka.actor.{AllForOneStrategy, PoisonPill, Props, Terminated}
import akka.actor.SupervisorStrategy.Stop
import models.ScheduleManager.SHOW
import models.actor.InstrumentedActor
import models.utils.Config

/**
  * Created by king on 2016/11/2.
  */
object  ScheduleManager{

  case class SHOW(jobtype:String)

  def props(config:Config,scheduleProvider: ScheduleProvider): Props = Props(classOf[ScheduleManager], config,scheduleProvider)

}

class ScheduleManager(config: Config,scheduleProvider: ScheduleProvider) extends InstrumentedActor {

  override val supervisorStrategy = AllForOneStrategy() {
    case anyException => Stop
  }
  override def preStart()={

  }

  override def wrappedReceive: Receive = {
    case SHOW(jobtype) =>  sender ! scheduleProvider.jobList(jobtype=jobtype)
    case t: Terminated => self ! PoisonPill


  }



}
