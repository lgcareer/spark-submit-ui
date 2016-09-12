package controllers

import models.JobManagerActor.{InvalidJar, JarStored}
import models._
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

/**
 * Created by manbu on 16/6/24.
 */
object SparkStream extends Controller with Secured{
  val executeForm:Form[ExecuteModel] = Form{
    mapping (
      "master"->text,
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

  /**
    * 上传jar
    * @return
    */
  def stremupload = Action(parse.multipartFormData) { implicit request =>
    request.body.file("file").map { jobFile =>
      session.get("email").map { user =>
        Logger.info("用户名=>"+user)
        Execute.storeJar(user,jobFile) match {
          case JarStored(id) => Redirect(routes.SparkStream.streamArgs())
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



  def streamArgs = Action { implicit request =>
    Ok(views.html.streamArgs(executeForm))
  }

  def streamExecute = IsAuthenticated { username => implicit request =>
    executeForm.bindFromRequest.fold(
      formWithErrors => {
        formWithErrors.errors.map(x => Logger.info(x.message))
        formWithErrors.globalError.map(x => Logger.info(x.message))
        BadRequest(views.html.error(formWithErrors.toString))
      },

      executeArguments => {
        Execute.main(executeArguments)
        match {
          case JobSubmitSuccess(msg) => Logger.info(msg); Ok("提交成功! ")
          case JobRunExecption(error) => BadRequest(error)
          case _ => NotFound
        }
      }
    )



  }


  def errorpage = IsAuthenticated {username => implicit request =>
    Ok(views.html.index())
  }


}
