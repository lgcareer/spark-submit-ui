package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Registration, User}
import org.apache.commons.lang3.StringUtils

import scala.util.matching.Regex

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
    mapping(
      "email" ->nonEmptyText.verifying("邮箱格式验证错误",validateEmail(_)).verifying("邮箱已存在",!models.User.findByEmail(_).isDefined),
      "name"-> nonEmptyText.verifying("姓名含有非法字符",validateName(_)),
      "password" -> nonEmptyText,
      "repassword"->nonEmptyText
    )(Registration.apply)(Registration.unapply) verifying ("两次密码不一致", result => result match {
      case  registration => validatePassword(registration)
    })
  )

  def registration =Action{
    Ok(views.html.register(registForm))
  }


  def verifying = Action { implicit request =>
    registForm.bindFromRequest.fold(
      formWithErrors => {
        //formWithErrors.errors.map(x=> Logger.info(x.message))
        formWithErrors.hasErrors
        formWithErrors.globalError.map(x=> Logger.info(x.message))
        BadRequest(views.html.register(formWithErrors))
      },
      registration => {
        val user:User= models.User.verifying(registration = registration)
         //Redirect(routes.Application.home(id))
          Ok("用户注册成功:"+user.email)
      }
    )
  }


  /**
    * 验证邮箱
     * @param email
    * @return
    */
  def validateEmail(email: String) :Boolean= {
    val regex =("""^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$""").r
    regex.findAllIn(email).hasNext
  }

  /**
    * 验证用户名
    * @param name
    * @return
    */
  def validateName(name: String) :Boolean= {
    val regex: Regex = ("""^[\u4E00-\u9FA5A-Za-z][\u4E00-\u9FA5A-Za-z0-9]+$""").r
    regex.findAllIn(name).hasNext
  }

  /**
    * 验证密码
    * @param password
    * @param repassword
    * @return
    */
  def validatePassword(registration:Registration): Boolean ={
    StringUtils.equals(registration.password,registration.repassword)
  }


}
