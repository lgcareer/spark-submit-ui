// @SOURCE:/Users/liangkai1/IdeaProjects/ficusspark/conf/routes
// @HASH:3ab57eb4d38fbabaf8925a579a56666384e15f54
// @DATE:Wed Jul 06 11:28:08 CST 2016


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
private[this] lazy val controllers_auth_Authentication_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:8
private[this] lazy val controllers_auth_Authentication_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:9
private[this] lazy val controllers_auth_Authentication_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:12
private[this] lazy val controllers_spark_SparkJar_uploadpage4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:13
private[this] lazy val controllers_spark_SparkJar_upload5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:14
private[this] lazy val controllers_spark_SparkJar_executejarpage6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:15
private[this] lazy val controllers_spark_SparkJar_executejar7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:16
private[this] lazy val controllers_spark_SparkJar_errorpage8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("errorpage"))))
        

// @LINE:19
private[this] lazy val controllers_spark_SparkStream_stream9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stream"))))
        

// @LINE:20
private[this] lazy val controllers_spark_SparkStream_stremupload10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stremupload"))))
        

// @LINE:21
private[this] lazy val controllers_spark_SparkStream_streamArgs11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("streamArgs"))))
        

// @LINE:22
private[this] lazy val controllers_spark_SparkStream_streamExecute12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("streamExecute"))))
        

// @LINE:23
private[this] lazy val controllers_spark_SparkStream_errorpage13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("errorpage"))))
        

// @LINE:26
private[this] lazy val controllers_spark_SparkSql_sqlpage14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:27
private[this] lazy val controllers_spark_SparkSql_executesql15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:30
private[this] lazy val controllers_hadoop_YarnList_yarnInfo16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnInfo"))))
        

// @LINE:31
private[this] lazy val controllers_hadoop_YarnList_yarnlist17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnlist"))))
        

// @LINE:32
private[this] lazy val controllers_hadoop_YarnList_workerlist18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workerlist"))))
        

// @LINE:33
private[this] lazy val controllers_hadoop_YarnList_spark_info19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("spark_info"))))
        

// @LINE:34
private[this] lazy val controllers_hadoop_YarnList_sparklist20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparklist"))))
        

// @LINE:36
private[this] lazy val controllers_Assets_at21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:39
private[this] lazy val controllers_auth_Authentication_registration22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:40
private[this] lazy val controllers_auth_Authentication_verifying23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:41
private[this] lazy val controllers_auth_Authentication_mail24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mail"))))
        

// @LINE:42
private[this] lazy val controllers_auth_Authentication_verifyingmail25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mail/verifyingmail"))))
        

// @LINE:43
private[this] lazy val controllers_auth_Authentication_findpwd26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findpwd"))))
        

// @LINE:44
private[this] lazy val controllers_auth_Authentication_captcha27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("captcha"))))
        

// @LINE:45
private[this] lazy val controllers_auth_Authentication_resetpwd28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findpwd"))))
        

// @LINE:46
private[this] lazy val controllers_auth_Authentication_setpwd29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mail/setpwd"))))
        

// @LINE:47
private[this] lazy val controllers_auth_Authentication_updatepwd30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updatepwd"))))
        

// @LINE:52
private[this] lazy val controllers_spark_SparkJar_uploadpage31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:53
private[this] lazy val controllers_spark_SparkJar_upload32 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparkjar"))))
        

// @LINE:54
private[this] lazy val controllers_spark_SparkJar_executejarpage33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:55
private[this] lazy val controllers_spark_SparkJar_executejar34 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("executejar"))))
        

// @LINE:56
private[this] lazy val controllers_spark_SparkJar_errorpage35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("errorpage"))))
        

// @LINE:61
private[this] lazy val controllers_spark_SparkSql_sqlpage36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:62
private[this] lazy val controllers_spark_SparkSql_executesql37 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:65
private[this] lazy val controllers_hadoop_YarnList_yarnInfo38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnInfo"))))
        

// @LINE:66
private[this] lazy val controllers_hadoop_YarnList_yarnlist39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnlist"))))
        

// @LINE:67
private[this] lazy val controllers_hadoop_YarnList_workerlist40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workerlist"))))
        

// @LINE:69
private[this] lazy val controllers_Assets_at41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.auth.Authentication.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.auth.Authentication.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.auth.Authentication.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.spark.SparkJar.uploadpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.spark.SparkJar.upload"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.spark.SparkJar.executejarpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.spark.SparkJar.executejar"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """errorpage""","""controllers.spark.SparkJar.errorpage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stream""","""controllers.spark.SparkStream.stream"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stremupload""","""controllers.spark.SparkStream.stremupload"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """streamArgs""","""controllers.spark.SparkStream.streamArgs"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """streamExecute""","""controllers.spark.SparkStream.streamExecute"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """errorpage""","""controllers.spark.SparkStream.errorpage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.spark.SparkSql.sqlpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.spark.SparkSql.executesql"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnInfo""","""controllers.hadoop.YarnList.yarnInfo"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnlist""","""controllers.hadoop.YarnList.yarnlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workerlist""","""controllers.hadoop.YarnList.workerlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """spark_info""","""controllers.hadoop.YarnList.spark_info"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparklist""","""controllers.hadoop.YarnList.sparklist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.auth.Authentication.registration"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.auth.Authentication.verifying"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mail""","""controllers.auth.Authentication.mail(user:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mail/verifyingmail""","""controllers.auth.Authentication.verifyingmail(email:String, validateCode:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findpwd""","""controllers.auth.Authentication.findpwd"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """captcha""","""controllers.auth.Authentication.captcha"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findpwd""","""controllers.auth.Authentication.resetpwd"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mail/setpwd""","""controllers.auth.Authentication.setpwd(email:String, pwdToken:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updatepwd""","""controllers.auth.Authentication.updatepwd"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.spark.SparkJar.uploadpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.spark.SparkJar.upload"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.spark.SparkJar.executejarpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.spark.SparkJar.executejar"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """errorpage""","""controllers.spark.SparkJar.errorpage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.spark.SparkSql.sqlpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.spark.SparkSql.executesql"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnInfo""","""controllers.hadoop.YarnList.yarnInfo"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnlist""","""controllers.hadoop.YarnList.yarnlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workerlist""","""controllers.hadoop.YarnList.workerlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_auth_Authentication_login1(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.login, HandlerDef(this, "controllers.auth.Authentication", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:8
case controllers_auth_Authentication_authenticate2(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.authenticate, HandlerDef(this, "controllers.auth.Authentication", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:9
case controllers_auth_Authentication_logout3(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.logout, HandlerDef(this, "controllers.auth.Authentication", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:12
case controllers_spark_SparkJar_uploadpage4(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.uploadpage, HandlerDef(this, "controllers.spark.SparkJar", "uploadpage", Nil,"GET", """ Spark Jar""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:13
case controllers_spark_SparkJar_upload5(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.upload, HandlerDef(this, "controllers.spark.SparkJar", "upload", Nil,"POST", """""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:14
case controllers_spark_SparkJar_executejarpage6(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.executejarpage, HandlerDef(this, "controllers.spark.SparkJar", "executejarpage", Nil,"GET", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:15
case controllers_spark_SparkJar_executejar7(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.executejar, HandlerDef(this, "controllers.spark.SparkJar", "executejar", Nil,"POST", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:16
case controllers_spark_SparkJar_errorpage8(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.errorpage, HandlerDef(this, "controllers.spark.SparkJar", "errorpage", Nil,"GET", """""", Routes.prefix + """errorpage"""))
   }
}
        

// @LINE:19
case controllers_spark_SparkStream_stream9(params) => {
   call { 
        invokeHandler(controllers.spark.SparkStream.stream, HandlerDef(this, "controllers.spark.SparkStream", "stream", Nil,"GET", """ Spark Stream""", Routes.prefix + """stream"""))
   }
}
        

// @LINE:20
case controllers_spark_SparkStream_stremupload10(params) => {
   call { 
        invokeHandler(controllers.spark.SparkStream.stremupload, HandlerDef(this, "controllers.spark.SparkStream", "stremupload", Nil,"POST", """""", Routes.prefix + """stremupload"""))
   }
}
        

// @LINE:21
case controllers_spark_SparkStream_streamArgs11(params) => {
   call { 
        invokeHandler(controllers.spark.SparkStream.streamArgs, HandlerDef(this, "controllers.spark.SparkStream", "streamArgs", Nil,"GET", """""", Routes.prefix + """streamArgs"""))
   }
}
        

// @LINE:22
case controllers_spark_SparkStream_streamExecute12(params) => {
   call { 
        invokeHandler(controllers.spark.SparkStream.streamExecute, HandlerDef(this, "controllers.spark.SparkStream", "streamExecute", Nil,"POST", """""", Routes.prefix + """streamExecute"""))
   }
}
        

// @LINE:23
case controllers_spark_SparkStream_errorpage13(params) => {
   call { 
        invokeHandler(controllers.spark.SparkStream.errorpage, HandlerDef(this, "controllers.spark.SparkStream", "errorpage", Nil,"GET", """""", Routes.prefix + """errorpage"""))
   }
}
        

// @LINE:26
case controllers_spark_SparkSql_sqlpage14(params) => {
   call { 
        invokeHandler(controllers.spark.SparkSql.sqlpage, HandlerDef(this, "controllers.spark.SparkSql", "sqlpage", Nil,"GET", """ Saprk Sql""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:27
case controllers_spark_SparkSql_executesql15(params) => {
   call { 
        invokeHandler(controllers.spark.SparkSql.executesql, HandlerDef(this, "controllers.spark.SparkSql", "executesql", Nil,"POST", """""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:30
case controllers_hadoop_YarnList_yarnInfo16(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.yarnInfo, HandlerDef(this, "controllers.hadoop.YarnList", "yarnInfo", Nil,"GET", """Dashboard""", Routes.prefix + """yarnInfo"""))
   }
}
        

// @LINE:31
case controllers_hadoop_YarnList_yarnlist17(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.yarnlist, HandlerDef(this, "controllers.hadoop.YarnList", "yarnlist", Nil,"GET", """""", Routes.prefix + """yarnlist"""))
   }
}
        

// @LINE:32
case controllers_hadoop_YarnList_workerlist18(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.workerlist, HandlerDef(this, "controllers.hadoop.YarnList", "workerlist", Nil,"GET", """""", Routes.prefix + """workerlist"""))
   }
}
        

// @LINE:33
case controllers_hadoop_YarnList_spark_info19(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.spark_info, HandlerDef(this, "controllers.hadoop.YarnList", "spark_info", Nil,"GET", """""", Routes.prefix + """spark_info"""))
   }
}
        

// @LINE:34
case controllers_hadoop_YarnList_sparklist20(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.sparklist, HandlerDef(this, "controllers.hadoop.YarnList", "sparklist", Nil,"GET", """""", Routes.prefix + """sparklist"""))
   }
}
        

// @LINE:36
case controllers_Assets_at21(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:39
case controllers_auth_Authentication_registration22(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.registration, HandlerDef(this, "controllers.auth.Authentication", "registration", Nil,"GET", """TestIndex""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:40
case controllers_auth_Authentication_verifying23(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.verifying, HandlerDef(this, "controllers.auth.Authentication", "verifying", Nil,"POST", """""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:41
case controllers_auth_Authentication_mail24(params) => {
   call(params.fromQuery[String]("user", None)) { (user) =>
        invokeHandler(controllers.auth.Authentication.mail(user), HandlerDef(this, "controllers.auth.Authentication", "mail", Seq(classOf[String]),"GET", """""", Routes.prefix + """mail"""))
   }
}
        

// @LINE:42
case controllers_auth_Authentication_verifyingmail25(params) => {
   call(params.fromQuery[String]("email", None), params.fromQuery[String]("validateCode", None)) { (email, validateCode) =>
        invokeHandler(controllers.auth.Authentication.verifyingmail(email, validateCode), HandlerDef(this, "controllers.auth.Authentication", "verifyingmail", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """mail/verifyingmail"""))
   }
}
        

// @LINE:43
case controllers_auth_Authentication_findpwd26(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.findpwd, HandlerDef(this, "controllers.auth.Authentication", "findpwd", Nil,"GET", """""", Routes.prefix + """findpwd"""))
   }
}
        

// @LINE:44
case controllers_auth_Authentication_captcha27(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.captcha, HandlerDef(this, "controllers.auth.Authentication", "captcha", Nil,"GET", """""", Routes.prefix + """captcha"""))
   }
}
        

// @LINE:45
case controllers_auth_Authentication_resetpwd28(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.resetpwd, HandlerDef(this, "controllers.auth.Authentication", "resetpwd", Nil,"POST", """""", Routes.prefix + """findpwd"""))
   }
}
        

// @LINE:46
case controllers_auth_Authentication_setpwd29(params) => {
   call(params.fromQuery[String]("email", None), params.fromQuery[String]("pwdToken", None)) { (email, pwdToken) =>
        invokeHandler(controllers.auth.Authentication.setpwd(email, pwdToken), HandlerDef(this, "controllers.auth.Authentication", "setpwd", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """mail/setpwd"""))
   }
}
        

// @LINE:47
case controllers_auth_Authentication_updatepwd30(params) => {
   call { 
        invokeHandler(controllers.auth.Authentication.updatepwd, HandlerDef(this, "controllers.auth.Authentication", "updatepwd", Nil,"POST", """""", Routes.prefix + """updatepwd"""))
   }
}
        

// @LINE:52
case controllers_spark_SparkJar_uploadpage31(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.uploadpage, HandlerDef(this, "controllers.spark.SparkJar", "uploadpage", Nil,"GET", """ Spark Jar""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:53
case controllers_spark_SparkJar_upload32(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.upload, HandlerDef(this, "controllers.spark.SparkJar", "upload", Nil,"POST", """""", Routes.prefix + """sparkjar"""))
   }
}
        

// @LINE:54
case controllers_spark_SparkJar_executejarpage33(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.executejarpage, HandlerDef(this, "controllers.spark.SparkJar", "executejarpage", Nil,"GET", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:55
case controllers_spark_SparkJar_executejar34(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.executejar, HandlerDef(this, "controllers.spark.SparkJar", "executejar", Nil,"POST", """""", Routes.prefix + """executejar"""))
   }
}
        

// @LINE:56
case controllers_spark_SparkJar_errorpage35(params) => {
   call { 
        invokeHandler(controllers.spark.SparkJar.errorpage, HandlerDef(this, "controllers.spark.SparkJar", "errorpage", Nil,"GET", """""", Routes.prefix + """errorpage"""))
   }
}
        

// @LINE:61
case controllers_spark_SparkSql_sqlpage36(params) => {
   call { 
        invokeHandler(controllers.spark.SparkSql.sqlpage, HandlerDef(this, "controllers.spark.SparkSql", "sqlpage", Nil,"GET", """ Saprk Sql""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:62
case controllers_spark_SparkSql_executesql37(params) => {
   call { 
        invokeHandler(controllers.spark.SparkSql.executesql, HandlerDef(this, "controllers.spark.SparkSql", "executesql", Nil,"POST", """""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:65
case controllers_hadoop_YarnList_yarnInfo38(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.yarnInfo, HandlerDef(this, "controllers.hadoop.YarnList", "yarnInfo", Nil,"GET", """Dashboard""", Routes.prefix + """yarnInfo"""))
   }
}
        

// @LINE:66
case controllers_hadoop_YarnList_yarnlist39(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.yarnlist, HandlerDef(this, "controllers.hadoop.YarnList", "yarnlist", Nil,"GET", """""", Routes.prefix + """yarnlist"""))
   }
}
        

// @LINE:67
case controllers_hadoop_YarnList_workerlist40(params) => {
   call { 
        invokeHandler(controllers.hadoop.YarnList.workerlist, HandlerDef(this, "controllers.hadoop.YarnList", "workerlist", Nil,"GET", """""", Routes.prefix + """workerlist"""))
   }
}
        

// @LINE:69
case controllers_Assets_at41(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     