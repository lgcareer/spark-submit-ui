package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import views._
import java.util.concurrent.{ExecutorService, Executors}

import controllers.auth.Secured
case class SqlModel (
    sql:String
)

object SparkSql extends Controller with Secured {
  val threadPool:ExecutorService = Executors.newFixedThreadPool(5)
  val sqlForm:Form[SqlModel] = Form{
    mapping(
        "sql" -> text)(SqlModel.apply)(SqlModel.unapply)
  }

  def sqlpage = IsAuthenticated { username => implicit request =>
    Ok(views.html.sparksql(sqlForm))
  }

  def executesql = IsAuthenticated { username => implicit request =>
      sqlForm.bindFromRequest.fold(
        formWithErrors => BadRequest(views.html.error(formWithErrors.toString)),
        sqlFormData => {
            val sqldata = SqlModel(sqlFormData.sql)
      def executeSql():Unit={
        try{threadPool.execute(new ThreadDemo("execute sql"))}
    finally{}
      }
      executeSql()
      class ThreadDemo(filename:String) extends Runnable{
        override def run(){
        println("start execute sql")
        val argus = Array(sqldata.sql)
        models.utils.ExecuteSql.main(argus)
        println("end execute sql")
    }
      }
            Ok(views.html.index())
        }
      )
  }

}
