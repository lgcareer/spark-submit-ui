package models.io

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * Created by manbu on 16/7/22.
 */
case class  UserCountDao(group:String,tatol:Long)
object UserCountDao {
   val simple = {
     get[String]("group") ~
     get[Long]("tatol") map{
       case group ~ tatol => UserCountDao(group,tatol)
     }
   }

  //统计各组用户
  def findAll(): Seq[UserCountDao] = {
    DB.withConnection { implicit connection =>
      SQL("select `group`,count(*) as tatol " +
        "from user_group group by `group`").as(UserCountDao.simple *)
    }
  }

  //计算各组资源
  def groupResouce(userEmail:String) :String ={
    DB.withConnection { implicit connection =>
      val user_group = SQL("select g.group as `group` from user_group g where g.email = {email}")
                        .on("email" -> userEmail)
      val group = user_group().map(
       row => row[String]("group")
      ).toList
      group(0)
    }
  }

    //待审核用户
    def auditUser() :Long= {
      DB.withConnection { implicit connection =>
       val audit = SQL("select count(distinct name) as tatol " +
          "from user where audit = 0")
       val auditUser = audit().map(row =>
        row [Long]("tatol")
        ).toList
        auditUser(0)
      }
    }


  def userCount(): List[String] = {
    DB.withConnection("default") { implicit connection =>
      val user_group = SQL("select name from user_group")
//      println("开始执行sql")
//      val user_count = SQL("select `group`,count(*) as tatol " +
//        "from user_group group by `group`")

//      val dsp = user_count().map(row =>
//        row [String]("group")
//        )
//      println(user_count)

      val users = user_group().map(row =>
        row[String]("name")
      ).toList
      users.toList
//      val UserJson =Json.toJson(users)
//      UserJson.toString
    }
  }
}
