package models.io

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * Created by manbu on 16/7/22.
 */
object UserCountDao {
  def userCount(): List[String] = {
    DB.withConnection("default") { implicit connection =>
      val user_group = SQL("select name from user_group")
      val users = user_group().map(row =>
        row[String]("name")
      ).toList
      users.toList
//      val UserJson =Json.toJson(users)
//      UserJson.toString
    }
  }
}
