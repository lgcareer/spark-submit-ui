package models

import java.util.{Date}

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class JarModel (
    username:String,
    fileLocation:String
    ) 

object  StoreJars {
    def insertJarToDb (jarFile: JarModel) = {
        play.api.db.DB.withConnection{ implicit connection =>

            SQL("""insert into applocation (user,applocation) values ({user},{applocation})""").on(
                'user -> jarFile.username,
                'applocation -> jarFile.fileLocation).executeUpdate()
        }
    }
}
