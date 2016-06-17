package models.Mail

/**
  * Created by liangkai1 on 16/6/17.
  */
abstract  class RegisterStatus(val ex:String) extends Exception(ex){
  def unapply(arg: RegisterStatus): Option[String] ={ Some(ex) }
}

case class EmailExecption(name:String) extends RegisterStatus(name)
case class VerifyException(name:String) extends  RegisterStatus(name)
case class  Success(name:String) extends RegisterStatus(name)
case class  Failure(name:String) extends RegisterStatus(name)



