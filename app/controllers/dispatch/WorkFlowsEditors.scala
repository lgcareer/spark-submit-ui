package controllers

import models.Execute
import models.ScheduleManager.{InvalidJar, JarStored}
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import play.api.libs.json._

/**
  * Created by king on 2016/11/9.
  */
object WorkFlowsEditors extends Controller with  Secured{

  def editorsList=Action{
    Ok(views.html.oozie_editors_list())
  }

  def editors=Action{
    Ok(views.html.oozie_edit())
  }

  val args = Form(
    tuple(
      "para" -> text.verifying(!_.isEmpty),
      "kio" -> text
    )
  )

  def submit =IsAuthenticated {
    username => implicit request =>
      args.bindFromRequest.fold(
        formWithErrors => BadRequest("参数为空"),
        arg => {
          Logger.info(arg._1)
          val jsValue: JsValue = Json.parse(arg._1)
          val kvs = jsValue.as[Seq[String]]
           val job = Execute.handleJob(username,kvs)
          Ok(job)

        }
    )
  }

  def upload = Action(parse.multipartFormData) { implicit request =>
    request.body.file("file").map { jobFile =>
      session.get("email").map { user =>
        Logger.info("用户名=>"+user)
        Execute.storeJarOnHdfs(user,jobFile) match {
          case JarStored(msg) => Logger.info(msg); Ok(msg)
          case InvalidJar(error) => Logger.info(error); BadRequest(error)
          case _ => NotFound
        }
      }.getOrElse {
        Unauthorized("用户不存在,请重新登录!")
      }
    }.getOrElse {
      Redirect(routes.SparkJar.errorpage("上传失败"))
    }
  }










}
