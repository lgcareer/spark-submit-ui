// @SOURCE:/Users/manbu/Desktop/ficusspark/conf/routes
// @HASH:50cbb2513e564fb397f853ffbf8508d88f13a0b9
// @DATE:Fri Jun 24 10:13:13 CST 2016


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
private[this] lazy val controllers_SparkSql_sqlpage9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:20
private[this] lazy val controllers_SparkSql_executesql10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sparksql"))))
        

// @LINE:23
private[this] lazy val controllers_YarnList_yarnInfo11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnInfo"))))
        

// @LINE:24
private[this] lazy val controllers_YarnList_yarnlist12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("yarnlist"))))
        

// @LINE:25
private[this] lazy val controllers_YarnList_workerlist13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workerlist"))))
        

// @LINE:26
private[this] lazy val controllers_YarnList_spark_info14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("spark_info"))))
        

// @LINE:28
private[this] lazy val controllers_Assets_at15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Authentication.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.SparkJar.uploadpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparkjar""","""controllers.SparkJar.upload"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.SparkJar.executejarpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """executejar""","""controllers.SparkJar.executejar"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """errorpage""","""controllers.SparkJar.errorpage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.SparkSql.sqlpage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sparksql""","""controllers.SparkSql.executesql"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnInfo""","""controllers.YarnList.yarnInfo"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """yarnlist""","""controllers.YarnList.yarnlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workerlist""","""controllers.YarnList.workerlist"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """spark_info""","""controllers.YarnList.spark_info"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_SparkSql_sqlpage9(params) => {
   call { 
        invokeHandler(controllers.SparkSql.sqlpage, HandlerDef(this, "controllers.SparkSql", "sqlpage", Nil,"GET", """ Saprk Sql""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:20
case controllers_SparkSql_executesql10(params) => {
   call { 
        invokeHandler(controllers.SparkSql.executesql, HandlerDef(this, "controllers.SparkSql", "executesql", Nil,"POST", """""", Routes.prefix + """sparksql"""))
   }
}
        

// @LINE:23
case controllers_YarnList_yarnInfo11(params) => {
   call { 
        invokeHandler(controllers.YarnList.yarnInfo, HandlerDef(this, "controllers.YarnList", "yarnInfo", Nil,"GET", """Dashboard""", Routes.prefix + """yarnInfo"""))
   }
}
        

// @LINE:24
case controllers_YarnList_yarnlist12(params) => {
   call { 
        invokeHandler(controllers.YarnList.yarnlist, HandlerDef(this, "controllers.YarnList", "yarnlist", Nil,"GET", """""", Routes.prefix + """yarnlist"""))
   }
}
        

// @LINE:25
case controllers_YarnList_workerlist13(params) => {
   call { 
        invokeHandler(controllers.YarnList.workerlist, HandlerDef(this, "controllers.YarnList", "workerlist", Nil,"GET", """""", Routes.prefix + """workerlist"""))
   }
}
        

// @LINE:26
case controllers_YarnList_spark_info14(params) => {
   call { 
        invokeHandler(controllers.YarnList.spark_info, HandlerDef(this, "controllers.YarnList", "spark_info", Nil,"GET", """""", Routes.prefix + """spark_info"""))
   }
}
        

// @LINE:28
case controllers_Assets_at15(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     