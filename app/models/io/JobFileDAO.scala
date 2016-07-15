package models
import java.io.File
import org.joda.time.DateTime
import play.api.db.DB
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart
import anorm._
import play.api.Play.current

import scala.collection.mutable

/**
  * Created by liangkai1 on 16/7/11.
  */
class JobFileDAO extends JobDAO {


  private val rootDir = "/tmp/file/"
  private val rootDirFile = new File(rootDir)
  private  val  rootOV = true
  private val apps = mutable.HashMap.empty[String, Seq[DateTime]]


  init

  private def init() {
    if (!rootDirFile.exists()) {
      if (!rootDirFile.mkdirs()) {
        throw new RuntimeException("Could not create directory " + rootDir)
      }
    }
  }


  override def saveJar(userName: String, uploadTime: DateTime, filePart: FilePart[TemporaryFile]) {
    val jobName:String=filePart.filename
    val file: File = new File(s"/tmp/file/$jobName")
    filePart.ref.moveTo(file,rootOV)
      addJar(jobName,uploadTime)
      insertJarToDb(JarInfo(userName,uploadTime.toDateTimeISO.toString,file.getAbsoluteFile.toString))
  }

  private def addJar(jobName: String, uploadTime: DateTime) {
    if (apps.contains(jobName)) {
      apps(jobName) = uploadTime +: apps(jobName)
    } else {
      apps(jobName) = Seq(uploadTime)
    }
  }

  override def getJar(userName: String): JarInfo = ???

   def insertJarToDb(jarInfo: JarInfo): Unit = {
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("""insert into applocation (user,applocation) values ({user},{applocation})""").on(
          'user -> jarInfo.userName,
          'applocation -> jarInfo.location).executeUpdate()
      }
    }
  }
}
