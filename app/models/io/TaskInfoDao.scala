package models

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
  * Created by liangkai on 16/8/18.
  *
  *
  * 运行时任务数据
  * "starttime" : 1471494218651,
  * "id" : "app-20160818122338-0000",
  * "name" : "HFDSWordCount",
  * "user" : "king",
  * "memoryperslave" : 1024,
  * "submitdate" : "Thu Aug 18 12:23:38 HKT 2016",
  * "state" : "RUNNING",
  * "duration" : 17290
  */
class TaskInfoDao  extends  TaskDao{

  override def saveTask(task: TaskInfo)(user:String): TaskInfo = {
      play.api.db.DB.withConnection { implicit connection =>
        SQL(
          """
          insert into task_standalone values (
            {app_id}, {name}, {cores}, {memoryperslave},{state},{submitdate},{duration},{email}
          )
          """).on(
          'app_id -> task.app_id,
          'name -> task.name,
          'cores -> task.cores,
          'memoryperslave ->task.memoryperslave,
          'state ->task.state,
          'submitdate ->task.submitdate,
          'duration ->task.duration,
          'email ->user
        ).executeUpdate()
      }
      task
    }

  override  def getYarnTaskList(username:String): Seq[YarnTaskInfo] = {
        DB.withConnection{
            implicit  connection =>
                SQL(
                    """
                 select * from task_yarn where email={email}
                    """
                ).on( 'email -> username)
                  .as(yarn *)
        }
    }

  override def saveYarnTask(yarnTask: YarnTaskInfo)(user:String): YarnTaskInfo = {
      play.api.db.DB.withConnection { implicit connection =>
        SQL(
          """
          insert into task_yarn values (
            {application_id}, {name}, {apptype}, {queue},{starttime},{finishtime},{state},{finalstatus}
          )
          """).on(
          'app_id -> yarnTask.applicaton_id,
          'name -> yarnTask.name,
          'apptype -> yarnTask.apptype,
          'queue -> yarnTask.queue,
          'starttime -> yarnTask.starttime,
          'finishtime ->yarnTask.finishtime,
          'state ->yarnTask.state,
          'finalstatus ->yarnTask.finalstatus
        ).executeUpdate()
      }
      yarnTask
    }

  override def getTaskInfoList(username:String): Seq[TaskInfo] = {
        DB.withConnection{
            implicit  connection =>
                SQL(
                    """
                 select * from task_standalone where email={email}
                    """
                ).on( 'email -> username)
               .as(standalone *)
        }
    }




}
