package models

/**
  * Created by kinge on 16/7/11.
  *
  */
sealed trait CommonMessages

/** 任务提交异常 */
case class JobSubmitExecption(msg:String) extends  RuntimeException(msg) with CommonMessages

/** 任务运行结束 */
case class JobRunFinish(msg:String) extends  RuntimeException(msg) with CommonMessages

/** 任务运行异常 */
case class JobRunExecption(msg:String) extends  RuntimeException(msg) with CommonMessages

/** 任务提交成功 */
case class JobSubmitSuccess(msg:String) extends  RuntimeException(msg) with CommonMessages


