package controllers


import java.io.{ByteArrayOutputStream, OutputStream}

import models.Mail._
import models.utils.CaptchaUtils
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Registration, User}
import org.apache.commons.lang3.StringUtils
import org.apache.commons.mail.{DefaultAuthenticator, Email, SimpleEmail}
import play.api.libs.json.{JsValue, Json}
import play.libs.F.Tuple

import scala.concurrent.Future
import scala.language.postfixOps
import scala.util.matching.Regex

object Authentication  extends Controller {

  val loginForm = Form(
    tuple(
      "email" -> text.verifying("用户还未激活",User.isActivate(_).isDefined),
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
        formWithErrors.errors.map(x=> Logger.info(x.message))
        formWithErrors.globalError.map(x=> Logger.info(x.message))
        BadRequest(views.html.register(formWithErrors))
      },
      registration => {
        val user:User= models.User.verifying(registration = registration)
        implicit val clusterListWrites = Json.writes[User]
        Redirect("/mail?user="+Json.toJson(user).toString)
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
    val regex: Regex = ("""^[A-Za-z0-9]+$""").r
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


  /**
    * 发送邮件验证
    * @return
    */
  def sendEmail(user:String): String ={
    val jsValue: JsValue = Json.parse(user)
    val email: Option[String] = jsValue.\("email").asOpt[String]
    val name: Option[String] = jsValue.\("name").asOpt[String]
    val password: Option[String] = jsValue.\("password").asOpt[String]
    if (!email.isEmpty && ! name.isEmpty&& ! password.isEmpty)
        RegisterWithEmail.sendHtmlMail(User(email.get,name.get,password.get))
    else "发送邮件失败,请检查注册信息"
  }



  import play.api.libs.concurrent.Execution.Implicits.defaultContext

  def mail(user:String) = Action.async {
    val future: Future[String] = scala.concurrent.Future { sendEmail(user) }
    future.map(i => Ok("Got result: " + i))
  }


  /**
    * 验证激活
    * @param email
    * @param validateCode
    * @return
    */
  def verifyingmail(email:String,validateCode:String)=Action{
    RegisterWithEmail.activateUser((email,validateCode)) match {
      case  e : EmailExecption =>  BadRequest(views.html.registed(e.unapply(e)))
      case  v : VerifyException => BadRequest(views.html.registed(v.unapply(v)))
      case  f : Failure => BadRequest(views.html.registed(f.unapply(f)))
      case  s : Success => Ok(email+" 激活成功 "+validateCode)
    }
  }

  val findPasswordForm = Form(
    tuple(
      "email" -> text.verifying("用户还未激活",User.isActivate(_).isDefined),
      "password" -> text
    ) verifying ("Invalid email or password", result => result match {
      case (email, password) => User.authenticate(email, password).isDefined
    })
  )



  def findpassword=Action{
    implicit request =>
      Ok(views.html.findpassword(findPasswordForm))
  }

  def captcha =Action{
    implicit request =>
    //生成随机字串
    val verifyCode = CaptchaUtils.generateVerifyCode(4);
      System.out.println(verifyCode)
      val outputImage: Array[Byte] = CaptchaUtils.outputImage(134, 52, verifyCode)
      Ok(outputImage).withHeaders("Pragma"->"No-cache","Cache-Control"->"no-cache","Expires"->"0").withSession("captcha"-> verifyCode)
        .as("image/jpeg")

  }


}
