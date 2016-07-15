package controllers

import java.util.concurrent.{ExecutorService, Executors}

import models.JobManagerActor.{InvalidJar, JarStored}
import models._
import play.api.Logger
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._

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
            case InvalidJar(error) => {
              Logger.info(error)
              NotFound
            }
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
//            val argss = ExecuteModel(
//              executeArguments.executeClass,
//              executeArguments.numExecutors,
//              executeArguments.driverMemory,
//              executeArguments.executorMemory,
//              executeArguments.executorCores,
//              executeArguments.jarLocation,
//              executeArguments.args1)
//
            //val model: ExecuteModel = ExecuteModel("mainq","1", "1G","1G","1","no","no")

            Execute.main(executeArguments)

            Ok(views.html.index())
      }
     )
}

    def errorpage = IsAuthenticated {username => implicit request =>
      Ok(views.html.index())
    }

 }






