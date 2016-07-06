package models.io

import anorm._
import play.api.Play.current
import play.api.db._

case class JarModel (
    username:String,
    fileLocation:String
    ) 

object  StoreJars {
  def insertJarToDb(jarFile: JarModel) = {
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>

        SQL("""insert into applocation (user,applocation) values ({user},{applocation})""").on(
          'user -> jarFile.username,
          'applocation -> jarFile.fileLocation).executeUpdate()
      }
    }
  }
}
