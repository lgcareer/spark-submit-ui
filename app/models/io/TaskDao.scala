package models

import anorm.SqlParser._
import anorm.~


/**
  * Created by liangkai on 16/8/22.
  */
case class TaskInfo(
                     app_id:String,
                     name:String,
                     cores: Int,
                     memoryperslave:Long,
                     state:String,
                     starttime:Long,
                     duration:Long
                   )

case class YarnTaskInfo(
                         application_id:String,
                         name:String,
                         apptype:String,
                         queue:String,
                         starttime:Long,
                         state:String,
                         finishtime:Long
                       )
case class YarnTaskList(list:Seq[YarnTaskInfo])
case class TaskList(list:Seq[TaskInfo])


trait TaskDao{

  val yarn = {
      get[String]("task_yarn.application_id") ~
      get[String]("task_yarn.name") ~
      get[String]("task_yarn.apptype")~
      get[String]("task_yarn.queue") ~
      get[Long]("task_yarn.starttime")~
      get[String]("task_yarn.state")~
      get[Long]("task_yarn.finishtime") map {
      case application_id ~ name ~ apptype ~ queue ~starttime ~state~finishtime=> YarnTaskInfo(application_id,name,apptype,queue,starttime,state,finishtime)
    }
  }

  val standalone = {
    get[String]("task_standalone.app_id") ~
      get[String]("task_standalone.name") ~
      get[Int]("task_standalone.cores")~
      get[Long]("task_standalone.memoryperslave")~
      get[String]("task_standalone.state") ~
      get[Long]("task_standalone.starttime")~
      get[Long]("task_standalone.duration") map {
      case app_id ~ name ~ cores ~ memoryperslave ~ state ~ starttime ~ duration  => TaskInfo(app_id,name,cores,memoryperslave,state,starttime,duration)
    }
  }


  val args = {
      get[String]("task_args.master") ~
      get[String]("task_args.executeClass") ~
      get[String]("task_args.numExecutors")~
      get[String]("task_args.driverMemory")~
      get[String]("task_args.executorMemory") ~
      get[String]("task_args.total_executor_cores") ~
      get[String]("task_args.jarLocation")~
      get[String]("task_args.args1") map {
      case master ~ executeClass ~ numExecutors ~ driverMemory ~ executorMemory ~ total_executor_cores ~ jarLocation ~ args1 => ExecuteModel(master,executeClass,numExecutors,driverMemory,executorMemory,total_executor_cores,jarLocation,args1)
    }
  }


  /**
    * 保存任务参数
    * @param executeModel
    * @param appId
    * @return
    */
  def saveTaskArgs(executeModel: ExecuteModel)(appId:String) : ExecuteModel


  /**
    * 获取任务参数
    * @param appId
    * @return
    */
  def getTaskArgs(appId:String):ExecuteModel


  /**
    * 保存spark参数
    * @param task
    * @param user
    * @return
    */
  def saveTask(task: TaskInfo)(user:String): TaskInfo

  /**
    * 保存yarn任务
    * @param yarnTask
    * @param user
    * @return
    */
  def saveYarnTask(yarnTask: YarnTaskInfo)(user:String): YarnTaskInfo

  /**
    * 获取用户所有spark 任务
    * @param user
    * @return
    */
  def getTaskInfoList(user:String): Seq[TaskInfo]

  /**
    * 获取用户所有yarn 任务
    * @param user
    * @return
    */
  def getYarnTaskList(user:String): Seq[YarnTaskInfo]

  /**
    * 更新yarn任务信息
    * @param tasks
    */
  def updateYarnTaskList(tasks: Seq[YarnTaskInfo])

  /**
    * 更新spark任务信息
    * @param tasks
    */
  def updateTaskList(tasks:Seq[TaskInfo])

  /**
    * 查询yarn 任务状态
    * @param appId
    * @return
    */
  def queryYarnState(appId:String):Option[YarnTaskInfo]


  /**
    * 查询spark 任务状态
    * @param appId
    * @return
    */
  def queryState(appId:String):Option[TaskInfo]

  /**
    * 移除yarn任务
    * @param appId
    */
  def rmYarnTaskInfo(appId:String)

  /**
    * 移除spark任务
    * @param appId
    */
  def rmTaskInfo(appId:String)


  def findTaskUser(appId:String):String

  def findyarnTaskUser(appId:String):String









}