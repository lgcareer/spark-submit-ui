package models

import anorm.SqlParser._
import play.api.db.DB
import anorm._
import play.api.Logger
import play.api.Play.current
/**
  * Created by liangkai1 on 16/8/4.
  * 用户组数据操作相关
  */

case class  UserGroup(email:String,name:String,group:String,queue:String)
case class  Group(userGroup: Seq[UserGroup])
sealed class  UserStatus(msg:String) {
  def unapply(arg: UserStatus): Option[String] = {
    Some(msg)
  }
}

case class CreateSuccess(msg:String) extends UserStatus(msg)
case class CreateFail(msg:String) extends UserStatus(msg)
case class  UpdateSuccess(msg:String) extends UserStatus(msg)
case class  UpdateFail(msg:String) extends UserStatus(msg)

object UserGroup {

  val simple = {
      get[String]("user_group.email") ~
      get[String]("user_group.name") ~
      get[String]("user_group.group")~
      get[String]("user_group.queue") map {
      case email ~ name ~ group ~ queue => UserGroup(email,name, group,queue)
    }
  }


  /**
    *查找所有用户组
    *
    * @return
    */
  def findGroup : Seq[UserGroup] = {
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("select * from user_group").as(UserGroup.simple *)
      }
    }
  }


  /**
    * 移除用户组
    *
    * @param email
    * @return
    */
  def removeGroup(email:String): Int ={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         delete  from user_group where
         email = {email}
        """).on(
        'email -> email
        ).executeUpdate()
    }
  }


  def findByEmail(email: String): Option[UserGroup] = {
    play.api.db.DB.withConnection { implicit connection =>
      SQL("select * from user_group where email = {email}").on(
        'email -> email).as(UserGroup.simple.singleOpt)
    }
  }


  /**
    * 添加用户or修改用户
    *
    * @return
    */
  def addOrUpdate : PartialFunction[UserGroup,UserStatus]={
    case user if findByEmail(user.email).isDefined =>  updateGroup(user)
    case user => addGroup(user)
  }


  /**
    * 修改用户组
    *
    * @param userGroup
    * @return
    */
  def updateGroup(userGroup: UserGroup): UserStatus ={
    val rc=play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          update  user_group set email=
            {email}, name={name}, `group`={group}, queue={queue}
            where email={email}
        """).on(
        'email -> userGroup.email,
        'name -> userGroup.name,
        'group -> userGroup.group,
        'queue ->userGroup.queue
      ).executeUpdate()
    }
    if(rc!=0) UpdateSuccess("修改成功!") else UpdateFail("修改失败!")
  }


  /**
    * 新增用户到组
    *
    * @param userGroup
    * @return
    */
  def addGroup(userGroup: UserGroup): UserStatus ={
    val rc=play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          insert into user_group values (
            {email}, {name}, {group}, {queue},0
          )
        """).on(
        'email -> userGroup.email,
        'name -> userGroup.name,
        'group -> userGroup.group,
         'queue ->userGroup.queue
         ).executeUpdate()
    }
    if(rc!=0) CreateSuccess("添加成功!") else CreateFail("添加失败!")
  }

}
