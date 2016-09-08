package models.io

import anorm._
import play.api.Play.current
import play.api.db.DB

/**
 * Created by manbu on 16/7/21.
 */
object ServicePlan {
  def service(): Map[String,String] = {
      DB.withConnection { implicit connection =>
      val servicequery = SQL("select ip,service from serviceplan")
      val stream = servicequery().map(row =>
         row[String]("ip") ->
         row[String]("service")
      ).toMap
        stream
    }

  }
}
