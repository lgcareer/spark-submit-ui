package models

import anorm.SqlParser._
import anorm.~


/**
  * Created by king on 16/8/22.
  */
case class TaskInfo(
                     app_id:String,
                     name:String,
                     cores: Int,
                     memoryperslave:Long,
                     state:String,
                     submitdate:String,
                     duration:Long
                   )

case class YarnTaskInfo(
                         applicaton_id:String,
                         name:String,
                         apptype:String,
                         queue:String,
                         starttime:String,
                         finishtime:String,
                         state:String,
                         finalstatus:String
                       )
case class YarnTaskList(list:Seq[YarnTaskInfo])
case class TaskList(list:Seq[TaskInfo])


trait TaskDao{


  val yarn = {
    get[String]("task_yarn.applicaton_id") ~
      get[String]("task_yarn.name") ~
      get[String]("task_yarn.apptype")~
      get[String]("task_yarn.queue") ~
      get[String]("task_yarn.starttime")~
      get[String]("task_yarn.finishtime") ~
      get[String]("task_yarn.state")~
      get[String]("task_yarn.finalstatus") map {
      case applicaton_id ~ name ~ apptype ~ queue ~starttime ~finishtime ~state~finalstatus=> YarnTaskInfo(applicaton_id,name,apptype,queue,starttime,finishtime,state,finalstatus)
    }
  }

  val standalone = {
    get[String]("task_standalone.app_id") ~
      get[String]("task_standalone.name") ~
      get[Int]("task_standalone.cores")~
      get[Long]("task_standalone.memoryperslave")~
      get[String]("task_standalone.state") ~
      get[String]("task_standalone.submitdate")~
      get[Long]("task_standalone.duration") map {
      case app_id ~ name ~ cores ~ memoryperslave ~ state ~ submitdate ~ duration  => TaskInfo(app_id,name,cores,memoryperslave,state,submitdate,duration)
    }
  }


  def saveTask(task: TaskInfo)(user:String): TaskInfo

  def saveYarnTask(yarnTask: YarnTaskInfo)(user:String): YarnTaskInfo

  def getTaskInfoList(username:String): Seq[TaskInfo]

  def getYarnTaskList(username:String): Seq[YarnTaskInfo]



}