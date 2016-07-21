package controllers

import models.JobManagerActor.{InvalidJar, JarStored}
import models._
import play.api.Logger
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._

<<<<<<< HEAD
case  class  ExecuteModel(
  executeClass:String,
  numExecutors:String,
  driverMemory:String,
  executorMemory:String,
  executorCores:String,
  jarLocation:String,
  args1:String)
=======
import scala.concurrent.Future
>>>>>>> 6c87dee3ccd36f4abb322413020222f473a51e93

object SparkJar extends Controller with Secured {

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
      request.body.file("file").map { jobFile =>
         session.get("email").map { user =>
           Logger.info("用户名=>"+user)
           Execute.storeJar(user,jobFile) match {
            case JarStored(id) => Redirect(routes.SparkJar.executejar())
            case InvalidJar(error) => Logger.info(error); BadRequest(error)
            case _ => NotFound
          }
        }.getOrElse {
          Unauthorized("用户不存在,请重新登录!")
        }
        }.getOrElse {
          Redirect(routes.SparkJar.errorpage())
        }
      }


      def executejarpage = Action { implicit request =>
        Ok(views.html.sparkjar(executeForm))
      }

      def executejar = IsAuthenticated { username => implicit request =>
        executeForm.bindFromRequest.fold(
          formWithErrors => {
            formWithErrors.errors.map(x => Logger.info(x.message))
            formWithErrors.globalError.map(x => Logger.info(x.message))
            BadRequest(views.html.error(formWithErrors.toString))
          },

          executeArguments => {
<<<<<<< HEAD
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
                Execute.main(arguments)
                println("end execute jar")
              }
            }
            def executeJar():Unit={
              try{threadPool.execute(new ThreadDemo("filename"))}
              finally{}
            }
            executeJar()
//       utils.Execute.main(arguments)
       //Ok(views.html.blank(arguments))
       Ok(views.html.index())
     }
=======
          Execute.main(executeArguments)
          match {
              case JobSubmitSuccess(msg) => Logger.info(msg); Ok("提交成功! ")
              case JobRunExecption(error) => BadRequest(error)
              case _ => NotFound
            }
       }
>>>>>>> 6c87dee3ccd36f4abb322413020222f473a51e93
     )
}

    def errorpage = IsAuthenticated {username => implicit request =>
      Ok(views.html.index())
    }

 }






