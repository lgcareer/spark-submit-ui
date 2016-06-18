package models

import play.api.db
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import org.apache.commons.lang3.StringUtils
import play.api.db.DB

case class User(email: String, name: String, password: String)
case class Registration(email:String,name:String,password:String,repassword:String)


object User {

  /**
   * Parse a User from a ResultSet
   */
  val simple = {
    get[String]("user.email") ~
    get[String]("user.name") ~
    get[String]("user.password") map {
      case email ~ name ~ password => User(email, name, password)
    }
  }


  /**
   * Retrieve all users.
   */
  def findAll: Seq[User] = {
    play.api.db.DB.withConnection { implicit connection =>
      SQL("select * from user").as(User.simple *)
    }
  }

  /**
   * Authenticate a User.
   */
  def authenticate(email: String, password: String): Option[User] = {
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         select * from user where 
         email = {email} and password = {password}
        """).on(
          'email -> email,
          'password -> password).as(User.simple.singleOpt)
    }
  }

  def isActivate(email: String): Option[User] ={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         select * from user where
         email = {email} and status = 1
        """).on(
        'email -> email
        ).as(User.simple.singleOpt)
    }
  }



  def verifying(registration : Registration): User={
      val newUser = models.User(registration.email,registration.name,registration.password)
      create(newUser)
  }

  /**
    * Retrieve a User from email.
    */
  def findByEmail(email: String): Option[User] = {
    play.api.db.DB.withConnection { implicit connection =>
      SQL("select * from user where email = {email}").on(
        'email -> email).as(User.simple.singleOpt)
    }
  }


  def findByStatusByEmail(email: String): Int = {
    play.api.db.DB.withConnection { implicit connection =>
      SQL("select status from user where email = {email}").on(
        'email -> email).as(SqlParser.scalar[Int].single)
    }
  }


  def updateStatus(email:String): Int ={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          update  user set status=1 where email={email}
        """).on(
        'email -> email
        ).executeUpdate()
    }
  }

  /**
   * Create a User.
   */
  def create(user: User): User = {
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          insert into user values (
            {email}, {name}, {password},0
          )
        """).on(
          'email -> user.email,
          'name -> user.name,
          'password -> user.password).executeUpdate()
      user
    }
  }

}

