package controllers

import com.fasterxml.jackson.databind.ObjectMapper
import models.io.daosql
import play.api.data.Forms._
import play.api.data.Form
import play.api.mvc.Controller
import play.libs.Json

object SparkSql extends Controller with Secured {
  var result=""
//  val threadPool:ExecutorService = Executors.newFixedThreadPool(5)
  val sqlForm = Form(
    single("sql" -> nonEmptyText)
  )

  def sqlpage = IsAuthenticated { username => implicit request =>
    Ok(views.html.sparksql(sqlForm))
  }

  def executesql = IsAuthenticated { username => implicit request =>
    sqlForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.error(formWithErrors.toString)),
      sqlForm => {
        val mapper = new ObjectMapper()
        mapper.registerModule((com.fasterxml.jackson.module.scala.DefaultScalaModule))
        Json.setObjectMapper(mapper)
        println("执行sql:" + sqlForm)
        val result1 = daosql.daosqlImpl(sqlForm)
        println("返回结果:" + result1.toArray)
        //          val resultJson = Json.parse(result1)
        Ok(Json.toJson(result1).toString())
        //          Redirect(routes.TestSql.sparksql())
      }
    )

  }


}
