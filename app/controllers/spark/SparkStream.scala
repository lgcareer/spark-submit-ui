package controllers.spark

import java.util.concurrent.{ExecutorService, Executors}

import controllers.auth.Secured
import models.io.{JarModel, StoreJars}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

/**
 * Created by manbu on 16/6/24.
 */

case class StreamModel (
                         executeClass:String,
                         numExecutors:String,
                         driverMemory:String,
                         executorMemory:String,
                         executorCores:String,
                         jarLocation:String,
                         args1:String)

object SparkStream extends Controller with Secured{
  val threadPool:ExecutorService = Executors.newFixedThreadPool(5)
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

  def stream = IsAuthenticated {username => implicit request =>
    Ok(views.html.stream())
  }

  def stremupload = Action(parse.multipartFormData) { implicit request =>
    request.body.file("file").map { picture =>
      import java.io.File
      val filename = picture.filename
      val contentType = picture.contentType
      picture.ref.moveTo(new File(s"/tmp/file/$filename"))
      Redirect(controllers.spark.routes.SparkStream.streamArgs)
    }.getOrElse {
      Redirect(controllers.spark.routes.SparkJar.errorpage())
    }
  }



  def streamArgs = Action { implicit request =>
    Ok(views.html.streamArgs(executeForm))

  }

  def streamExecute = IsAuthenticated { username => implicit request =>
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
          "--master", "yarn-cluster","kafka-topic",
          argss.jarLocation,
          argss.args1
        )
        StoreJars.insertJarToDb(JarModel(username,argss.jarLocation))
        class ThreadDemo(filename:String) extends Runnable{
          override def run(){
            println("start execute jar")
            //  models.utils.Execute.main(arguments)
            println("end execute jar")
          }
        }
        def executeJar():Unit={
          try{threadPool.execute(new ThreadDemo("filename"))}
          finally{}
        }
        executeJar()
        Ok(views.html.index())
      }
    )

  }


  def errorpage = IsAuthenticated {username => implicit request =>
    Ok(views.html.index())
  }


}
