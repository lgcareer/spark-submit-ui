package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import views._
import models.User

object Authentication extends Controller {

  val loginForm = Form(
    tuple(
      "email" -> text,
      "password" -> text
    ) verifying ("Invalid email or password", result => result match {
        case (email, password) => User.authenticate(email, password).isDefined
    })
  )

  /**
   * Login page.
   */
  def login = Action { implicit request =>
    Ok(views.html.login(loginForm))
  }

  /**
   * Logout and clean the session.
   */
  def logout = Action {
    Redirect(routes.Authentication.login).withNewSession.flashing(
      "success" -> "成功退出"
    )
  }

  /**
   * Handle login form submission.
   */
  def authenticate = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.login(formWithErrors)),
      user => Redirect(routes.Application.index()).withSession("email" -> user._1)
    )
  }


  val registForm = Form(
    tuple(
      "email" ->text,
      "name"-> text,
      "password" -> text,
      "repassword"->text
    ) //verifying ("Invalid email or password", result => result match {
      //case (email, name,password,repassword) => User.verifying(email,name,password,repassword).isEmpty
    //})
  )



  def registration =Action{
    Ok(views.html.register(registForm))
  }


  def verifying = Action { implicit request =>
//    registForm.bindFromRequest.fold(
//      formWithErrors => BadRequest("page err"),//BadRequest(views.html.login(formWithErrors)),
//      user => Ok("email:"+user._1+"name:"+user._2)
//    )

    val user: (String, String, String, String) = registForm.bindFromRequest().get
    Ok("email:"+user._1+"\nname:"+user._2+"\npassword="+user._3+"\nrepassword="+user._4)

  }

}
