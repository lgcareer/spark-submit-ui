package controllers

import play.api.mvc.{Action, Controller}

/**
 * Created by manbu on 16/6/24.
 */
object SparkStream extends Controller with Secured{
  def sparkstream = IsAuthenticated {username => implicit request =>
    Ok(views.html.strem())
  }

  def upload = Action(parse.multipartFormData) { implicit request =>
    request.body.file("file").map { picture =>
      import java.io.File
      val filename = picture.filename
      val contentType = picture.contentType
      picture.ref.moveTo(new File(s"/tmp/file/$filename"))
      Redirect(routes.SparkJar.executejar())
    }.getOrElse {
      Redirect(routes.SparkJar.errorpage())
    }
  }

//  def executejarpage = Action { implicit request =>
//
//    Ok(views.html.sparkjar(executeForm))
//
//  }


}
