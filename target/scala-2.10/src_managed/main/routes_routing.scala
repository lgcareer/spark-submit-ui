// @SOURCE:/Users/liangkai1/IdeaProjects/ficusspark/conf/routes
// @HASH:8e8de0b5e625bf75313e2d6ac8263959b23576cc
// @DATE:Fri Jul 15 16:01:45 CST 2016


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Authentication_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:8
private[this] lazy val controllers_Authentication_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:9
private[this] lazy val controllers_Authentication_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:12
private[this] lazy val controllers_SparkJar_uploadpage4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:13
private[this] lazy val controllers_SparkJar_upload5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:14
private[this] lazy val controllers_SparkJar_executejarpage6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:15
private[this] lazy val controllers_SparkJar_executejar7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:16
private[this] lazy val controllers_SparkJar_errorpage8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("errorpage"))))
        

// @LINE:19
private[this] lazy val controllers_SparkStream_stream9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stream"))))
        

// @LINE:20
private[this] lazy val controllers_SparkStream_stremupload10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stremupload"))))
        

// @LINE:21
private[this] lazy val controllers_SparkStream_streamArgs11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("streamArgs"))))
        

// @LINE:22
private[this] lazy val controllers_SparkStream_streamExecute12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("streamExecute"))))
        

// @LINE:23
private[this] lazy val controllers_SparkStream_errorpage13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("errorpage"))))
        

// @LINE:26
private[this] lazy val controllers_SparkSql_sqlpage14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:27
private[this] lazy val controllers_SparkSql_executesql15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:30
private[this] lazy val controllers_YarnList_yarnInfo16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnInfo"))))
        

// @LINE:31
private[this] lazy val controllers_YarnList_yarnlist17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnlist"))))
        

// @LINE:32
private[this] lazy val controllers_YarnList_workerlist18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workerlist"))))
        

// @LINE:33
private[this] lazy val controllers_YarnList_spark_info19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("spark_info"))))
        

// @LINE:34
private[this] lazy val controllers_YarnList_sparklist20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparklist"))))
        

// @LINE:36
private[this] lazy val controllers_Assets_at21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:39
private[this] lazy val controllers_Authentication_registration22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:40
private[this] lazy val controllers_Authentication_verifying23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:41
private[this] lazy val controllers_Authentication_mail24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mail"))))
        

// @LINE:42
private[this] lazy val controllers_Authentication_verifyingmail25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mail/verifyingmail"))))
        

// @LINE:43
private[this] lazy val controllers_Authentication_findpwd26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findpwd"))))
        

// @LINE:44
private[this] lazy val controllers_Authentication_captcha27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("captcha"))))
        

// @LINE:45
private[this] lazy val controllers_Authentication_resetpwd28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findpwd"))))
        

// @LINE:46
private[this] lazy val controllers_Authentication_setpwd29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mail/setpwd"))))
        

// @LINE:47
private[this] lazy val controllers_Authentication_updatepwd30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updatepwd"))))
        

// @LINE:52
private[this] lazy val controllers_SparkJar_uploadpage31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:53
private[this] lazy val controllers_SparkJar_upload32 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:54
private[this] lazy val controllers_SparkJar_executejarpage33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:55
private[this] lazy val controllers_SparkJar_executejar34 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:56
private[this] lazy val controllers_SparkJar_errorpage35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("errorpage"))))
        

// @LINE:61
private[this] lazy val controllers_SparkSql_sqlpage36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:62
private[this] lazy val controllers_SparkSql_executesql37 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:65
private[this] lazy val controllers_YarnList_yarnInfo38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnInfo"))))
        

// @LINE:66
private[this] lazy val controllers_YarnList_yarnlist39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnlist"))))
        

// @LINE:67
private[this] lazy val controllers_YarnList_workerlist40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workerlist"))))
        

// @LINE:69
private[this] lazy val controllers_Assets_at41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:72
private[this] lazy val controllers_MonitorController_jobs42 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jobs"))))
        

// @LINE:73
private[this] lazy val controllers_MonitorController_streaming43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("streaming"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Authentication.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.SparkJar.uploadpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.SparkJar.upload"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.SparkJar.executejarpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.SparkJar.executejar"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """errorpage""","""controllers.SparkJar.errorpage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stream""","""controllers.SparkStream.stream"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stremupload""","""controllers.SparkStream.stremupload"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """streamArgs""","""controllers.SparkStream.streamArgs"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """streamExecute""","""controllers.SparkStream.streamExecute"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """errorpage""","""controllers.SparkStream.errorpage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.SparkSql.sqlpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.SparkSql.executesql"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnInfo""","""controllers.YarnList.yarnInfo"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnlist""","""controllers.YarnList.yarnlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workerlist""","""controllers.YarnList.workerlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """spark_info""","""controllers.YarnList.spark_info"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparklist""","""controllers.YarnList.sparklist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.Authentication.registration"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.Authentication.verifying"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mail""","""controllers.Authentication.mail(user:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mail/verifyingmail""","""controllers.Authentication.verifyingmail(email:String, validateCode:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findpwd""","""controllers.Authentication.findpwd"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """captcha""","""controllers.Authentication.captcha"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findpwd""","""controllers.Authentication.resetpwd"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mail/setpwd""","""controllers.Authentication.setpwd(email:String, pwdToken:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updatepwd""","""controllers.Authentication.updatepwd"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.SparkJar.uploadpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.SparkJar.upload"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.SparkJar.executejarpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.SparkJar.executejar"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """errorpage""","""controllers.SparkJar.errorpage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.SparkSql.sqlpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.SparkSql.executesql"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnInfo""","""controllers.YarnList.yarnInfo"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnlist""","""controllers.YarnList.yarnlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workerlist""","""controllers.YarnList.workerlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jobs""","""controllers.MonitorController.jobs"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """streaming""","""controllers.MonitorController.streaming""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Authentication_login1(params) => {
   call { 
        invokeHandler(controllers.Authentication.login, HandlerDef(this, "controllers.Authentication", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:8
case controllers_Authentication_authenticate2(params) => {
   call { 
        invokeHandler(controllers.Authentication.authenticate, HandlerDef(this, "controllers.Authentication", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:9
case controllers_Authentication_logout3(params) => {
   call { 
        invokeHandler(controllers.Authentication.logout, HandlerDef(this, "controllers.Authentication", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:12
case controllers_SparkJar_uploadpage4(params) => {
   call { 
        invokeHandler(controllers.SparkJar.uploadpage, HandlerDef(this, "controllers.SparkJar", "uploadpage", Nil,"GET", """ Spark Jar""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:13
case controllers_SparkJar_upload5(params) => {
   call { 
        invokeHandler(controllers.SparkJar.upload, HandlerDef(this, "controllers.SparkJar", "upload", Nil,"POST", """""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:14
case controllers_SparkJar_executejarpage6(params) => {
   call { 
        invokeHandler(controllers.SparkJar.executejarpage, HandlerDef(this, "controllers.SparkJar", "executejarpage", Nil,"GET", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:15
case controllers_SparkJar_executejar7(params) => {
   call { 
        invokeHandler(controllers.SparkJar.executejar, HandlerDef(this, "controllers.SparkJar", "executejar", Nil,"POST", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:16
case controllers_SparkJar_errorpage8(params) => {
   call { 
        invokeHandler(controllers.SparkJar.errorpage, HandlerDef(this, "controllers.SparkJar", "errorpage", Nil,"GET", """""", Routes.prefix + """errorpage"""))
   }
}
        

// @LINE:19
case controllers_SparkStream_stream9(params) => {
   call { 
        invokeHandler(controllers.SparkStream.stream, HandlerDef(this, "controllers.SparkStream", "stream", Nil,"GET", """ Spark Stream""", Routes.prefix + """stream"""))
   }
}
        

// @LINE:20
case controllers_SparkStream_stremupload10(params) => {
   call { 
        invokeHandler(controllers.SparkStream.stremupload, HandlerDef(this, "controllers.SparkStream", "stremupload", Nil,"POST", """""", Routes.prefix + """stremupload"""))
   }
}
        

// @LINE:21
case controllers_SparkStream_streamArgs11(params) => {
   call { 
        invokeHandler(controllers.SparkStream.streamArgs, HandlerDef(this, "controllers.SparkStream", "streamArgs", Nil,"GET", """""", Routes.prefix + """streamArgs"""))
   }
}
        

// @LINE:22
case controllers_SparkStream_streamExecute12(params) => {
   call { 
        invokeHandler(controllers.SparkStream.streamExecute, HandlerDef(this, "controllers.SparkStream", "streamExecute", Nil,"POST", """""", Routes.prefix + """streamExecute"""))
   }
}
        

// @LINE:23
case controllers_SparkStream_errorpage13(params) => {
   call { 
        invokeHandler(controllers.SparkStream.errorpage, HandlerDef(this, "controllers.SparkStream", "errorpage", Nil,"GET", """""", Routes.prefix + """errorpage"""))
   }
}
        

// @LINE:26
case controllers_SparkSql_sqlpage14(params) => {
   call { 
        invokeHandler(controllers.SparkSql.sqlpage, HandlerDef(this, "controllers.SparkSql", "sqlpage", Nil,"GET", """ Saprk Sql""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:27
case controllers_SparkSql_executesql15(params) => {
   call { 
        invokeHandler(controllers.SparkSql.executesql, HandlerDef(this, "controllers.SparkSql", "executesql", Nil,"POST", """""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:30
case controllers_YarnList_yarnInfo16(params) => {
   call { 
        invokeHandler(controllers.YarnList.yarnInfo, HandlerDef(this, "controllers.YarnList", "yarnInfo", Nil,"GET", """Dashboard""", Routes.prefix + """yarnInfo"""))
   }
}
        

// @LINE:31
case controllers_YarnList_yarnlist17(params) => {
   call { 
        invokeHandler(controllers.YarnList.yarnlist, HandlerDef(this, "controllers.YarnList", "yarnlist", Nil,"GET", """""", Routes.prefix + """yarnlist"""))
   }
}
        

// @LINE:32
case controllers_YarnList_workerlist18(params) => {
   call { 
        invokeHandler(controllers.YarnList.workerlist, HandlerDef(this, "controllers.YarnList", "workerlist", Nil,"GET", """""", Routes.prefix + """workerlist"""))
   }
}
        

// @LINE:33
case controllers_YarnList_spark_info19(params) => {
   call { 
        invokeHandler(controllers.YarnList.spark_info, HandlerDef(this, "controllers.YarnList", "spark_info", Nil,"GET", """""", Routes.prefix + """spark_info"""))
   }
}
        

// @LINE:34
case controllers_YarnList_sparklist20(params) => {
   call { 
        invokeHandler(controllers.YarnList.sparklist, HandlerDef(this, "controllers.YarnList", "sparklist", Nil,"GET", """""", Routes.prefix + """sparklist"""))
   }
}
        

// @LINE:36
case controllers_Assets_at21(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:39
case controllers_Authentication_registration22(params) => {
   call { 
        invokeHandler(controllers.Authentication.registration, HandlerDef(this, "controllers.Authentication", "registration", Nil,"GET", """TestIndex""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:40
case controllers_Authentication_verifying23(params) => {
   call { 
        invokeHandler(controllers.Authentication.verifying, HandlerDef(this, "controllers.Authentication", "verifying", Nil,"POST", """""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:41
case controllers_Authentication_mail24(params) => {
   call(params.fromQuery[String]("user", None)) { (user) =>
        invokeHandler(controllers.Authentication.mail(user), HandlerDef(this, "controllers.Authentication", "mail", Seq(classOf[String]),"GET", """""", Routes.prefix + """mail"""))
   }
}
        

// @LINE:42
case controllers_Authentication_verifyingmail25(params) => {
   call(params.fromQuery[String]("email", None), params.fromQuery[String]("validateCode", None)) { (email, validateCode) =>
        invokeHandler(controllers.Authentication.verifyingmail(email, validateCode), HandlerDef(this, "controllers.Authentication", "verifyingmail", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """mail/verifyingmail"""))
   }
}
        

// @LINE:43
case controllers_Authentication_findpwd26(params) => {
   call { 
        invokeHandler(controllers.Authentication.findpwd, HandlerDef(this, "controllers.Authentication", "findpwd", Nil,"GET", """""", Routes.prefix + """findpwd"""))
   }
}
        

// @LINE:44
case controllers_Authentication_captcha27(params) => {
   call { 
        invokeHandler(controllers.Authentication.captcha, HandlerDef(this, "controllers.Authentication", "captcha", Nil,"GET", """""", Routes.prefix + """captcha"""))
   }
}
        

// @LINE:45
case controllers_Authentication_resetpwd28(params) => {
   call { 
        invokeHandler(controllers.Authentication.resetpwd, HandlerDef(this, "controllers.Authentication", "resetpwd", Nil,"POST", """""", Routes.prefix + """findpwd"""))
   }
}
        

// @LINE:46
case controllers_Authentication_setpwd29(params) => {
   call(params.fromQuery[String]("email", None), params.fromQuery[String]("pwdToken", None)) { (email, pwdToken) =>
        invokeHandler(controllers.Authentication.setpwd(email, pwdToken), HandlerDef(this, "controllers.Authentication", "setpwd", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """mail/setpwd"""))
   }
}
        

// @LINE:47
case controllers_Authentication_updatepwd30(params) => {
   call { 
        invokeHandler(controllers.Authentication.updatepwd, HandlerDef(this, "controllers.Authentication", "updatepwd", Nil,"POST", """""", Routes.prefix + """updatepwd"""))
   }
}
        

// @LINE:52
case controllers_SparkJar_uploadpage31(params) => {
   call { 
        invokeHandler(controllers.SparkJar.uploadpage, HandlerDef(this, "controllers.SparkJar", "uploadpage", Nil,"GET", """ Spark Jar""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:53
case controllers_SparkJar_upload32(params) => {
   call { 
        invokeHandler(controllers.SparkJar.upload, HandlerDef(this, "controllers.SparkJar", "upload", Nil,"POST", """""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:54
case controllers_SparkJar_executejarpage33(params) => {
   call { 
        invokeHandler(controllers.SparkJar.executejarpage, HandlerDef(this, "controllers.SparkJar", "executejarpage", Nil,"GET", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:55
case controllers_SparkJar_executejar34(params) => {
   call { 
        invokeHandler(controllers.SparkJar.executejar, HandlerDef(this, "controllers.SparkJar", "executejar", Nil,"POST", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:56
case controllers_SparkJar_errorpage35(params) => {
   call { 
        invokeHandler(controllers.SparkJar.errorpage, HandlerDef(this, "controllers.SparkJar", "errorpage", Nil,"GET", """""", Routes.prefix + """errorpage"""))
   }
}
        

// @LINE:61
case controllers_SparkSql_sqlpage36(params) => {
   call { 
        invokeHandler(controllers.SparkSql.sqlpage, HandlerDef(this, "controllers.SparkSql", "sqlpage", Nil,"GET", """ Saprk Sql""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:62
case controllers_SparkSql_executesql37(params) => {
   call { 
        invokeHandler(controllers.SparkSql.executesql, HandlerDef(this, "controllers.SparkSql", "executesql", Nil,"POST", """""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:65
case controllers_YarnList_yarnInfo38(params) => {
   call { 
        invokeHandler(controllers.YarnList.yarnInfo, HandlerDef(this, "controllers.YarnList", "yarnInfo", Nil,"GET", """Dashboard""", Routes.prefix + """yarnInfo"""))
   }
}
        

// @LINE:66
case controllers_YarnList_yarnlist39(params) => {
   call { 
        invokeHandler(controllers.YarnList.yarnlist, HandlerDef(this, "controllers.YarnList", "yarnlist", Nil,"GET", """""", Routes.prefix + """yarnlist"""))
   }
}
        

// @LINE:67
case controllers_YarnList_workerlist40(params) => {
   call { 
        invokeHandler(controllers.YarnList.workerlist, HandlerDef(this, "controllers.YarnList", "workerlist", Nil,"GET", """""", Routes.prefix + """workerlist"""))
   }
}
        

// @LINE:69
case controllers_Assets_at41(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:72
case controllers_MonitorController_jobs42(params) => {
   call { 
        invokeHandler(controllers.MonitorController.jobs, HandlerDef(this, "controllers.MonitorController", "jobs", Nil,"GET", """""", Routes.prefix + """jobs"""))
   }
}
        

// @LINE:73
case controllers_MonitorController_streaming43(params) => {
   call { 
        invokeHandler(controllers.MonitorController.streaming, HandlerDef(this, "controllers.MonitorController", "streaming", Nil,"GET", """""", Routes.prefix + """streaming"""))
   }
}
        
}

}
     