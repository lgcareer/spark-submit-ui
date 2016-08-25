package models.deploy.task

/**
  * Created by king on 16/8/22.
  */
trait TaskProvider[T] {

  def findTaskInfo(appid:String)(user:String)

  def proTaskOnMaster(app:T)

  def proTaskOnYarn(app:T)


}
