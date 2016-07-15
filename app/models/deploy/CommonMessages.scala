package models

/**
  * Created by liangkai1 on 16/7/11.
  */
sealed trait CommonMessages

class JobSubmitExecption(msg:String) extends  RuntimeException(msg) with CommonMessages
class JobRunExecption(msg:String) extends  RuntimeException(msg) with CommonMessages



