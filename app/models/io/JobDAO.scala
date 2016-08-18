package models

import anorm.SqlParser._
import anorm.~
import org.joda.time.DateTime
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart

/**
  * Created by liangkai1 on 16/7/11.
  */
case class JarInfo(userName: String, uploadTime: String, location:String)


trait JobDAO {

  def saveJar(userName: String, uploadTime: DateTime, filePart: FilePart[TemporaryFile]):String

  def getJar(id: String) : JarInfo

}

case class TaskInfo(
                     app_id:String,
                     name:String,
                     cores: Int,
                     memoryperslave:String,
                     state:String,
                     submitdate:String,
                     duration:String
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
      get[String]("task_standalone.memoryperslave")~
      get[String]("task_standalone.state") ~
      get[String]("task_standalone.submitdate")~
      get[String]("task_standalone.duration") map {
      case app_id ~ name ~ cores ~ memoryperslave ~ state ~ submitdate ~ duration  => TaskInfo(app_id,name,cores,memoryperslave,state,submitdate,duration)
    }
  }


  def saveTask(task:TaskInfo)

  def saveYarnTask(yarnTask:YarnTaskInfo)

  def getYarnTaskList(username:String): Seq[YarnTaskInfo]

  def getTaskInfoList(username:String): Seq[TaskInfo]

}
