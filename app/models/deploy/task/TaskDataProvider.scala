package models

import com.google.inject.Inject
import models.TaskDataProvider.{AppDataObject, TaskData, YarnTaskInfoList}
import models.utils.Config
import play.api.Logger
import play.api.libs.ws.WS
import play.libs.Akka

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

/**
  * Created by liangkai on 16/8/18.
  * 数据内容提供者
  */
object TaskDataProvider{

  case class  TaskData(activeapps:Seq[TaskInfo],completedapps:Seq[TaskInfo])

  case class AppDataObject(var appId:String,var user:String,var url:String = "yarn")

  case class YarnTaskInfoList(app: Seq[YarnTaskInfo])
}

class TaskDataProvider @Inject()(config: Config,taskDao: TaskDao)extends TaskProvider[AppDataObject]{


  import play.api.libs.functional.syntax._
  import play.api.libs.json.Reads._
  import play.api.libs.json._

  scheduleTaskDate


  /**
         TaskInfo(
                     app_id:String,
                     name:String,
                     cores: Int,
                     memoryperslave:String,
                     state:String,
                     starttime:String,
                     duration:String
                   )
    */
  implicit val standaloneReads: Reads[TaskInfo] = (
      (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "cores").read[Int] and
      (JsPath \ "memoryperslave").read[Long] and
      (JsPath \ "state").read[String] and
      (JsPath \ "starttime").read[Long] and
      (JsPath \ "duration").read[Long]
    )(TaskInfo.apply _)



  implicit val taskListReads: Reads[TaskData] = (
    (JsPath \ "activeapps").read[Seq[TaskInfo]] and
      (JsPath \ "completedapps").read[Seq[TaskInfo]]
    )(TaskData.apply _)



  /**
    * YarnTaskInfo(
                     application_id:String,
                     name:String,
                     apptype:String,
                     queue:String,
                     starttime:String,
                     finishtime:String,
                     state:String,
                   )
    */
  implicit val yarnReads: Reads[YarnTaskInfo] = (
      (JsPath \ "id").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "applicationType").read[String] and
      (JsPath \ "queue").read[String] and
      (JsPath \ "startedTime").read[Long] and
      (JsPath \ "state").read[String] and
      (JsPath \ "finishedTime").read[Long]
    )(YarnTaskInfo.apply _)



  implicit  val areads = (__ \ 'apps \ 'app).read[Seq[YarnTaskInfo]].map{ l => YarnTaskInfoList(l) }


  def loadTaskInfo(app:AppDataObject): Unit ={
    val appId: String = app.appId
    Logger.info(s"用户任务Id====>$appId")
    MatchEngine.matchURI(appId).map(
      data=>
      data._1 match {
        case m if m.equals("yarn") => app.url=data._2;proTaskOnYarn(app)
        case m if m.equals("standalone") => app.url=data._2;proTaskOnMaster(app)
        //case m if m.equals("local") => saveTaskOnLocal(m,appId)
      }
    )
  }



  override  def proTaskOnMaster(app: AppDataObject): Unit ={
     WS.url(app.url).get() map{
      response => response.status match {
        case  200 => Some{
          response.json .validate[TaskData].fold(
            invalid = {
              fieldErrors => fieldErrors.foreach(x => {
                Logger.error("field: " + x._1 + ", errors: " + x._2)
              })
                None
            },
            valid = {
              tasks => {
                /**
                  * 将正在运行列表与id匹配,取出第一个任务信息保存
                  */
                  val runingTask=tasks.activeapps.filter(_.app_id.equals(app.appId))(0)
                  taskDao.saveTask(runingTask)(app.user)
              }
            })
        }
        case _ => None
      }
    }
  }



  override  def proTaskOnYarn(app:AppDataObject): Unit ={
    WS.url(app.url).get() map{
      response => response.status match {
        case  200 => Some{
          response.json .validate[YarnTaskInfoList].fold(
            invalid = {
              fieldErrors => fieldErrors.foreach(x => {
                Logger.error("field: " + x._1 + ", errors: " + x._2)
              })
                None
            },
            valid = {
              tasks => {
                 val runingTask= tasks.app.filter(_.application_id.equals(app.appId))(0)
                  taskDao.saveYarnTask(runingTask)(app.user)
              }
            })
        }
        case _ => None
      }
    }
  }

  import scala.concurrent.duration._

  def scheduleTaskDate={

    Akka.system.scheduler.schedule(0.second, 5 second, new Runnable {
      override def run(): Unit = {
        WS.url("http://"+config.getString("hadoop.yarn.host")+"/ws/v1/cluster/apps").get() map{
          response => response.status match {
            case  200 => Some{
              response.json .validate[YarnTaskInfoList].fold(
                invalid = {
                  fieldErrors => fieldErrors.foreach(x => {
                    Logger.error("field: " + x._1 + ", errors: " + x._2)
                  })
                    None
                },
                valid = {
                  tasks => {
                      taskDao.updateYarnTaskList(tasks.app)
                  }
                })
            }
            case _ => None
          }
        }

        val url: String = "http://"+config.getString("spark.master.host")+"/json"
        WS.url(url).get() map{
          response => response.status match {
            case  200 => Some{
              response.json .validate[TaskData].fold(
                invalid = {
                  fieldErrors => fieldErrors.foreach(x => {
                    Logger.error("field: " + x._1 + ", errors: " + x._2)
                  })
                    None
                },
                valid = {
                  tasks => {
                    val taskInfoes = tasks.activeapps++tasks.completedapps
                    taskDao.updateTaskList(taskInfoes)

                  }
                })
            }
            case _ => None
          }
        }

      }
    })
  }


  def coverTask(appId:String): Unit ={
    MatchEngine.matchURI(appId).map(
      data=>
        data._1 match {
          case m if m.equals("yarn") => {
            Runtime.getRuntime.exec(s"app/models/shell/kill_job.sh $appId")
            taskDao.rmYarnTaskInfo(appId)
          }
          case m if m.equals("standalone") => {
            WS.url("http://127.0.0.1:8080/app/kill/").post(Map("id" -> Seq(appId),"terminate"->Seq("true")))
            taskDao.rmYarnTaskInfo(appId)
          }
        }
    )
  }





}
