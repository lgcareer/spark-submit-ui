package models

import anorm.SqlParser._
import anorm._
import models._
import play.api.Play.current
import play.api.db.DB

/**
  * Created by king on 16/8/18.
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
object TaskInfoDao extends TaskDao{

    override def saveTask(task: TaskInfo): Unit = ???

    override def getYarnTaskList(username:String): Seq[YarnTaskInfo] = {
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

    override def saveYarnTask(yarnTask: YarnTaskInfo): Unit = ???

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
