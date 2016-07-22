package controllers

import com.fasterxml.jackson.databind.ObjectMapper
import models.utils.SparkSqlPool
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.Controller
import play.libs.Json

import scala.collection.mutable.ArrayBuffer

object SparkSql extends Controller with Secured {

  def sqlpage = IsAuthenticated { username => implicit request =>
    Ok(views.html.sparksql())
  }

  //接受页面输入sql
  val sqlForm = Form(
    single("sql" -> text)
  )

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
          println("rsmd:"+rsmd)
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
            println("result:"+result)
          }
          SparkSqlPool.releaseConn(connection)
          Ok(Json.toJson(
            Map[String, Any](
              "header" -> header.toArray,
              "data" -> result.toArray
            )
          ).toString())
        }
      })
  }

}
