package controllers

import java.io.{File, PrintWriter}

import com.fasterxml.jackson.databind.ObjectMapper
import models.utils.SparkSqlPool
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.Controller
import play.libs.Json

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object SparkSql extends Controller with Secured {

  def sqlpage = IsAuthenticated { username => implicit request =>
    Ok(views.html.sparksql())
  }

  //接受页面输入sql
  val sqlForm = Form(
    single("sql" -> text)
  )

  var n = Random.nextInt()

  val mapper = new ObjectMapper()
  mapper.registerModule(com.fasterxml.jackson.module.scala.DefaultScalaModule)
  Json.setObjectMapper(mapper)

  def executesql = IsAuthenticated { username => implicit request =>
    sqlForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.error(formWithErrors.toString)),
      sqlForm => {
        val connection = SparkSqlPool.getJdbcConn()
        val statement = connection.createStatement()
        val found = statement.execute(sqlForm)
        if (!found) {
          InternalServerError("error")
        } else {
          val resultSet = statement.getResultSet()
          val result = new ArrayBuffer[Array[Any]]()
          val rsmd = resultSet.getMetaData()
          println("rsmd:" + rsmd)
          val header = new ArrayBuffer[String]()
          for (i <- 1 to rsmd.getColumnCount()) {
            header += rsmd.getColumnName(i)
          }

          while (resultSet.next()) {
            val row = new ArrayBuffer[Any]()
            for (i <- 1 to rsmd.getColumnCount()) {
              row += resultSet.getObject(i)
            }
            result += row.toArray
          }


          val writer = new PrintWriter(new File(s"public/download/spark$n.txt"))

          val resultCSV = Json.toJson(
            Map[String, Any](
              "header" -> header.toArray,
              "data" -> result.toArray
            )
          ).toString()

          println("c :" + resultCSV.toString)

          header.toArray.toString + "\n" + result.toArray.toString

          writer.println(resultCSV.toString)
          writer.close()

          Responder.constant("text/plain")

          SparkSqlPool.releaseConn(connection)
          Ok(Json.toJson(
            Map[String, Any](
              "header" -> header.toArray,
              "data" -> result.toArray
            )
          ).toString())
        }
      })


    //    def download(file_path:String) = IsAuthenticated { username => implicit request =>
    //      Ok.sendFile(new java.io.File(s"public/download/$file_path"))
    //    }

    //    def toDownload = IsAuthenticated { username => implicit request =>
    //      val path = "public/uploads/"
    //      val fileNameListBuffer =new ListBuffer[String]
    //      daosql.getName(path,fileNameListBuffer)
    //      Ok(views.html.download(fileNameListBuffer.toList))
    //    }


  }

  def download = IsAuthenticated { username => implicit request =>
    Ok.sendFile(new File(s"public/download/spark$n.txt"))
  }

}
