package controllers.spark

import java.util.concurrent.{ExecutorService, Executors}

import controllers.auth.Secured
import models._
import models.io.{JarModel, StoreJars}
import play.api._
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._





case  class  ExecuteModel(
  executeClass:String,
  numExecutors:String,
  driverMemory:String,
  executorMemory:String,
  executorCores:String,
  jarLocation:String,
  args1:String)

object SparkJar extends Controller with Secured {
  val threadPool:ExecutorService = Executors.newFixedThreadPool(5)
  play.api.libs.concurrent.Execution
  val executeForm:Form[ExecuteModel] = Form{
    mapping (
      "executeClass"->text,
      "numExecutors"->text,
      "driverMemory"->text,
      "executorMemory"->text,
      "executorCores"->text,
      "jarLocation"->text,
      "args1"->text
      )(ExecuteModel.apply)(ExecuteModel.unapply)
    }

    def uploadpage = IsAuthenticated {username => implicit request =>

      Ok(views.html.upload())

    }

    def upload = Action(parse.multipartFormData) { implicit request =>
      request.body.file("file").map { picture =>
        import java.io.File
        val filename = picture.filename
        val contentType = picture.contentType
        picture.ref.moveTo(new File(s"/tmp/file/$filename"),true)

        Redirect(controllers.spark.routes.SparkJar.executejar())
        }.getOrElse {
          Redirect(controllers.spark.routes.SparkJar.errorpage())
        }
      }

      def executejarpage = Action { implicit request =>
        Ok(views.html.sparkjar(executeForm))
      }

      def executejar = IsAuthenticated { username => implicit request =>
        val format = new java.text.SimpleDateFormat("yyyyMMddHHmmss")
        val current = format.format(new java.util.Date()).toString
        executeForm.bindFromRequest.fold(
          formWithErrors => BadRequest(views.html.error(formWithErrors.toString)),
          executeArguments => {
            val argss = ExecuteModel(executeArguments.executeClass,executeArguments.numExecutors,executeArguments.driverMemory,executeArguments.executorMemory,executeArguments.executorCores,executeArguments.jarLocation,executeArguments.args1)
            val arguments = Array(
              "/usr/local/spark/bin/spark-submit",
              "--class", argss.executeClass,
              "--num-executors", argss.numExecutors,
              "--driver-memory", argss.driverMemory,
              "--executor-memory", argss.executorMemory,
              "--executor-cores", argss.executorCores,
              "--master  yarn-cluster",
              argss.jarLocation,
              argss.args1
              )
            StoreJars.insertJarToDb(JarModel(username,argss.jarLocation))
            class ThreadDemo(filename:String) extends Runnable{
              override def run(){
                println("start execute jar")
              //  models.utils.Execute.main(arguments)
                models.utils.Execute.main(arguments)
                println("end execute jar")
              }
            }
            def executeJar():Unit={
              try{threadPool.execute(new ThreadDemo("filename"))}
              finally{}
            }
            executeJar()
       //utils.Execute.main(arguments)
       //Ok(views.html.blank(arguments))
       Ok(views.html.index())
     }
     )

}

    def errorpage = IsAuthenticated {username => implicit request =>
      Ok(views.html.index())
    }

 }






