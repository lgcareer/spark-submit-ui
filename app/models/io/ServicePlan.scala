package models.io

import anorm._
import play.api.Play.current
import play.api.db.DB
import play.libs.Json

/**
 * Created by manbu on 16/7/21.
 */
object ServicePlan {
  def service(): String = {
    DB.withConnection("test") { implicit connection =>
      val servicequery = SQL("select ip,service from serviceplan")

      val stream = servicequery().map(row =>
        "ip"-> row[String]("ip") ->
        "service" -> row[String]("service")
      ).toMap

      val stream1 = servicequery().map(row =>
         row[String]("ip") ->
         row[String]("service")
      ).toMap

      val serviceJson =Json.toJson(stream1)
      serviceJson.toString
    }

  }
}
