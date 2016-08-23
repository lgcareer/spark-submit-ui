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
            {app_id}, {name}, {cores}, {memoryperslave},{state},{submitdate},{duration},{user}
          )
          """).on(
          'app_id -> task.app_id,
          'name -> task.name,
          'cores -> task.cores,
          'memoryperslave ->task.memoryperslave,
          'state ->task.state,
          'submitdate ->task.submitdate,
          'duration ->task.duration,
          'user ->user
        ).executeUpdate()
      }
      task
    }

  override  def getYarnTaskList(user:String): Seq[YarnTaskInfo] = {
        DB.withConnection{
            implicit  connection =>
                SQL(
                    """
                 select * from task_yarn where user={user} order by starttime desc
                    """
                ).on( 'user -> user)
                  .as(yarn *)
        }
    }

  override def saveYarnTask(yarnTask: YarnTaskInfo)(user:String): YarnTaskInfo = {
      play.api.db.DB.withConnection { implicit connection =>
        SQL(
          """
          insert into task_yarn values (
            {application_id}, {name}, {apptype}, {queue},{starttime},{finishtime},{state},{user}
          )
          """).on(
          'application_id -> yarnTask.applicaton_id,
          'name -> yarnTask.name,
          'apptype -> yarnTask.apptype,
          'queue -> yarnTask.queue,
          'starttime -> yarnTask.starttime,
          'finishtime ->yarnTask.finishtime,
          'state ->yarnTask.state,
          'user ->user
        ).executeUpdate()
      }
      yarnTask
    }

  override def getTaskInfoList(user:String): Seq[TaskInfo] = {
        DB.withConnection{
            implicit  connection =>
                SQL(
                    """
                 select * from task_standalone where user={user} order by submitdate desc
                    """
                ).on( 'user -> user)
               .as(standalone *)
        }
    }




}
