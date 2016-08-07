package models

import anorm.SqlParser._
import play.api.db.DB
import anorm._
import play.api.Play.current
/**
  * Created by liangkai1 on 16/8/4.
  * 用户组数据操作相关
  */

case class  UserGroup(email:String,name:String,group:String,queue:String)
case class  Group(userGroup: Seq[UserGroup])
object UserGroup {

  val simple = {
      get[String]("user_group.email") ~
      get[String]("user_group.name") ~
      get[String]("user_group.password")~
      get[String]("user_group.queue") map {
      case email ~ name ~ group ~ queue => UserGroup(email,name, group,queue)
    }
  }


  /**
    *查找所有用户组
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

  def addGroup(userGroup: UserGroup): UserGroup ={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          insert into user_group values (
            {email}, {name}, {group}, {queue},0
          )
        """).on(
        'email -> userGroup.email,
        'name -> userGroup.name,
        'password -> 123,
        'group -> userGroup.group,
         'queue ->userGroup.queue
         ).executeUpdate()
      userGroup
    }
  }


}
