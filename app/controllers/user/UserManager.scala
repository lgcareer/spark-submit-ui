package controllers

import models.{Group, User, UserGroup}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}

/**
  * Created by liangkai1 on 16/8/4.
  * 用户管理相关
  */
object UserManager extends Controller with  Secured{

//  val loginForm = Form(
//    tuple(
//      "email" -> text.verifying("用户还未激活",User.isActivate(_).isDefined),
//      "name" -> text,
//      "group" -> text,
//      "queue" -> text
//    )
//  )


  val groupForm:Form[UserGroup] = Form{
    mapping (
      "email"->text.verifying("用户还未激活",User.isActivate(_).isDefined),
      "name"->text,
      "group"->text,
      "queue"->text
    )(UserGroup.apply)(UserGroup.unapply)
  }


  /**
    * 用户组Table页面
    * @return
    */
  def userlist =Action{
    Ok(views.html.userlist())
  }

  /**
    * 获取所有用户组列表
    * @return
    */
  def usergroup=Action{
    implicit val residentWrites = Json.writes[UserGroup]
    implicit val clusterListWrites = Json.writes[Group]
    val json: JsValue = Json.toJson(Group(UserGroup.findGroup))
    Ok(json)
  }


  /**
    * 移除所在用户组
    * @param email
    * @return
    */
  def rmgroup(email:String)=IsAuthenticated{
    username => implicit request =>
     UserGroup.removeGroup(email) match {
       case 1 => Ok("删除成功!")
       case _ => BadRequest("删除失败!")
     }
  }

  /**
    * 新增用户到组
    * @param email
    * @param name
    * @param group
    * @param queue
    * @return
    */
  def addgroup(email:String,name:String,group:String,queue:String)=Action{
    Ok("add succus")
  }


  /**
    * 更新用户组
    * @param email
    * @param name
    * @param group
    * @param queue
    * @return
    */
  def udgroup(email:String,name:String,group:String,queue:String)=Action{
    Ok("add succus")
  }

//  def executejar = IsAuthenticated { username => implicit request =>
//    executeForm.bindFromRequest.fold(
//      formWithErrors => {
//        formWithErrors.errors.map(x => Logger.info(x.message))
//        formWithErrors.globalError.map(x => Logger.info(x.message))
//        BadRequest(views.html.error(formWithErrors.toString))
//      },
//      executeArguments => {
//        Execute.main(executeArguments)
//        match {
//          case JobSubmitSuccess(msg) => Logger.info(msg); Redirect(routes.SparkJar.he(msg))
//          case JobRunExecption(error) => BadRequest(error)
//          case _ => NotFound
//        }
//      }
//    )
//  }




}
