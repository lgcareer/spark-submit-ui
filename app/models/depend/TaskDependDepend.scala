package models

import com.tzavellas.sse.guice.ScalaModule
import models.TaskDataProvider.AppDataObject
/**
  * Created by liangkai on 16/8/22.
  */
class TaskDependDepend extends ScalaModule{
  override def configure(): Unit =  {
    bind[TaskDao].to[TaskInfoDao]
    bind[TaskProvider[AppDataObject]].to[TaskDataProvider]
  }

}
