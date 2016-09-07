package models.user

import anorm._
import models.{Email, User}
import play.api.db.DB
import play.api.Play.current

/**
  * Created by liangkai1 on 16/8/11.
  */
sealed class  UserStatus(msg:String) {
  def unapply(arg: UserStatus): Option[String] = {
    Some(msg)
  }
}

case class  Reason(email:String,name:String,body:String)
case class  UpdateSuccess(msg:String) extends UserStatus(msg)
case class  UpdateFail(msg:String) extends UserStatus(msg)

object UserAudit {


  def findAuditUser: Seq[User] ={
    DB.withConnection{
      implicit  connection =>
        SQL(
          """
           select * from user where audit < 1
          """
        ).as(User.simple *)
    }
  }

  def pass(email:String): UserStatus ={
    val rc=play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          update  user set audit= 1
            where email={email}
        """).on(
        'email -> email
      ).executeUpdate()
    }
    if(rc!=0) UpdateSuccess("注册审核成功!") else UpdateFail("注册审核失败!")
  }


  def nopass(email: String,body:String): String ={
      val name: String = User.findNameByEmail(email)
      val reason: Reason = Reason(email,name,body)
      Email.sendHtmlMail(reason)
  }



}
