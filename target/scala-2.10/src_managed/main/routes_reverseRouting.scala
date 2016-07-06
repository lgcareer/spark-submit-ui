// @SOURCE:/Users/liangkai1/IdeaProjects/ficusspark/conf/routes
// @HASH:27b698fd2ab5b974ad9b3c6bb5fd86d6a0cec438
// @DATE:Wed Jul 06 15:28:12 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:73
// @LINE:72
package controllers.monitor {

// @LINE:73
// @LINE:72
class ReverseMonitorController {
    

// @LINE:72
def jobs(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "jobs")
}
                                                

// @LINE:73
def streaming(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "streaming")
}
                                                
    
}
                          
}
                  

// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
package controllers.hadoop {

// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:66
// @LINE:31
def yarnlist(): Call = {
   () match {
// @LINE:31
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnlist")
                                                        
// @LINE:66
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnlist")
                                                        
   }
}
                                                

// @LINE:33
def spark_info(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "spark_info")
}
                                                

// @LINE:65
// @LINE:30
def yarnInfo(): Call = {
   () match {
// @LINE:30
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnInfo")
                                                        
// @LINE:65
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnInfo")
                                                        
   }
}
                                                

// @LINE:34
def sparklist(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sparklist")
}
                                                

// @LINE:67
// @LINE:32
def workerlist(): Call = {
   () match {
// @LINE:32
case () if true => Call("GET", _prefix + { _defaultPrefix } + "workerlist")
                                                        
// @LINE:67
case () if true => Call("GET", _prefix + { _defaultPrefix } + "workerlist")
                                                        
   }
}
                                                
    
}
                          
}
                  

// @LINE:69
// @LINE:36
// @LINE:6
package controllers {

// @LINE:69
// @LINE:36
class ReverseAssets {
    

// @LINE:69
// @LINE:36
def at(file:String): Call = {
   (file: @unchecked) match {
// @LINE:36
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
// @LINE:69
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
   }
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.auth {

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseAuthentication {
    

// @LINE:47
def updatepwd(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updatepwd")
}
                                                

// @LINE:44
def captcha(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "captcha")
}
                                                

// @LINE:41
def mail(user:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mail" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user", user)))))
}
                                                

// @LINE:43
def findpwd(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "findpwd")
}
                                                

// @LINE:42
def verifyingmail(email:String, validateCode:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mail/verifyingmail" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("email", email)), Some(implicitly[QueryStringBindable[String]].unbind("validateCode", validateCode)))))
}
                                                

// @LINE:39
def registration(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "registration")
}
                                                

// @LINE:9
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:45
def resetpwd(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "findpwd")
}
                                                

// @LINE:40
def verifying(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "registration")
}
                                                

// @LINE:46
def setpwd(email:String, pwdToken:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mail/setpwd" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("email", email)), Some(implicitly[QueryStringBindable[String]].unbind("pwdToken", pwdToken)))))
}
                                                

// @LINE:8
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:7
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  

// @LINE:62
// @LINE:61
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
package controllers.spark {

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseSparkStream {
    

// @LINE:23
def errorpage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "errorpage")
}
                                                

// @LINE:22
def streamExecute(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "streamExecute")
}
                                                

// @LINE:20
def stremupload(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "stremupload")
}
                                                

// @LINE:19
def stream(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "stream")
}
                                                

// @LINE:21
def streamArgs(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "streamArgs")
}
                                                
    
}
                          

// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseSparkJar {
    

// @LINE:53
// @LINE:13
def upload(): Call = {
   () match {
// @LINE:13
case () if true => Call("POST", _prefix + { _defaultPrefix } + "sparkjar")
                                                        
// @LINE:53
case () if true => Call("POST", _prefix + { _defaultPrefix } + "sparkjar")
                                                        
   }
}
                                                

// @LINE:55
// @LINE:15
def executejar(): Call = {
   () match {
// @LINE:15
case () if true => Call("POST", _prefix + { _defaultPrefix } + "executejar")
                                                        
// @LINE:55
case () if true => Call("POST", _prefix + { _defaultPrefix } + "executejar")
                                                        
   }
}
                                                

// @LINE:56
// @LINE:16
def errorpage(): Call = {
   () match {
// @LINE:16
case () if true => Call("GET", _prefix + { _defaultPrefix } + "errorpage")
                                                        
// @LINE:56
case () if true => Call("GET", _prefix + { _defaultPrefix } + "errorpage")
                                                        
   }
}
                                                

// @LINE:52
// @LINE:12
def uploadpage(): Call = {
   () match {
// @LINE:12
case () if true => Call("GET", _prefix + { _defaultPrefix } + "sparkjar")
                                                        
// @LINE:52
case () if true => Call("GET", _prefix + { _defaultPrefix } + "sparkjar")
                                                        
   }
}
                                                

// @LINE:54
// @LINE:14
def executejarpage(): Call = {
   () match {
// @LINE:14
case () if true => Call("GET", _prefix + { _defaultPrefix } + "executejar")
                                                        
// @LINE:54
case () if true => Call("GET", _prefix + { _defaultPrefix } + "executejar")
                                                        
   }
}
                                                
    
}
                          

// @LINE:62
// @LINE:61
// @LINE:27
// @LINE:26
class ReverseSparkSql {
    

// @LINE:61
// @LINE:26
def sqlpage(): Call = {
   () match {
// @LINE:26
case () if true => Call("GET", _prefix + { _defaultPrefix } + "sparksql")
                                                        
// @LINE:61
case () if true => Call("GET", _prefix + { _defaultPrefix } + "sparksql")
                                                        
   }
}
                                                

// @LINE:62
// @LINE:27
def executesql(): Call = {
   () match {
// @LINE:27
case () if true => Call("POST", _prefix + { _defaultPrefix } + "sparksql")
                                                        
// @LINE:62
case () if true => Call("POST", _prefix + { _defaultPrefix } + "sparksql")
                                                        
   }
}
                                                
    
}
                          
}
                  


// @LINE:73
// @LINE:72
package controllers.monitor.javascript {

// @LINE:73
// @LINE:72
class ReverseMonitorController {
    

// @LINE:72
def jobs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.monitor.MonitorController.jobs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jobs"})
      }
   """
)
                        

// @LINE:73
def streaming : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.monitor.MonitorController.streaming",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "streaming"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
package controllers.hadoop.javascript {

// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:66
// @LINE:31
def yarnlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.hadoop.YarnList.yarnlist",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnlist"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnlist"})
      }
      }
   """
)
                        

// @LINE:33
def spark_info : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.hadoop.YarnList.spark_info",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "spark_info"})
      }
   """
)
                        

// @LINE:65
// @LINE:30
def yarnInfo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.hadoop.YarnList.yarnInfo",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnInfo"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnInfo"})
      }
      }
   """
)
                        

// @LINE:34
def sparklist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.hadoop.YarnList.sparklist",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparklist"})
      }
   """
)
                        

// @LINE:67
// @LINE:32
def workerlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.hadoop.YarnList.workerlist",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workerlist"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workerlist"})
      }
      }
   """
)
                        
    
}
              
}
        

// @LINE:69
// @LINE:36
// @LINE:6
package controllers.javascript {

// @LINE:69
// @LINE:36
class ReverseAssets {
    

// @LINE:69
// @LINE:36
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.auth.javascript {

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseAuthentication {
    

// @LINE:47
def updatepwd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.updatepwd",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updatepwd"})
      }
   """
)
                        

// @LINE:44
def captcha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.captcha",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "captcha"})
      }
   """
)
                        

// @LINE:41
def mail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.mail",
   """
      function(user) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user", user)])})
      }
   """
)
                        

// @LINE:43
def findpwd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.findpwd",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findpwd"})
      }
   """
)
                        

// @LINE:42
def verifyingmail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.verifyingmail",
   """
      function(email,validateCode) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mail/verifyingmail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("validateCode", validateCode)])})
      }
   """
)
                        

// @LINE:39
def registration : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.registration",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        

// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:45
def resetpwd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.resetpwd",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "findpwd"})
      }
   """
)
                        

// @LINE:40
def verifying : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.verifying",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        

// @LINE:46
def setpwd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.setpwd",
   """
      function(email,pwdToken) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mail/setpwd" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pwdToken", pwdToken)])})
      }
   """
)
                        

// @LINE:8
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.auth.Authentication.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:62
// @LINE:61
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
package controllers.spark.javascript {

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseSparkStream {
    

// @LINE:23
def errorpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkStream.errorpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "errorpage"})
      }
   """
)
                        

// @LINE:22
def streamExecute : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkStream.streamExecute",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "streamExecute"})
      }
   """
)
                        

// @LINE:20
def stremupload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkStream.stremupload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "stremupload"})
      }
   """
)
                        

// @LINE:19
def stream : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkStream.stream",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stream"})
      }
   """
)
                        

// @LINE:21
def streamArgs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkStream.streamArgs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "streamArgs"})
      }
   """
)
                        
    
}
              

// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseSparkJar {
    

// @LINE:53
// @LINE:13
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkJar.upload",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sparkjar"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sparkjar"})
      }
      }
   """
)
                        

// @LINE:55
// @LINE:15
def executejar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkJar.executejar",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "executejar"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "executejar"})
      }
      }
   """
)
                        

// @LINE:56
// @LINE:16
def errorpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkJar.errorpage",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "errorpage"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "errorpage"})
      }
      }
   """
)
                        

// @LINE:52
// @LINE:12
def uploadpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkJar.uploadpage",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparkjar"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparkjar"})
      }
      }
   """
)
                        

// @LINE:54
// @LINE:14
def executejarpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkJar.executejarpage",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "executejar"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "executejar"})
      }
      }
   """
)
                        
    
}
              

// @LINE:62
// @LINE:61
// @LINE:27
// @LINE:26
class ReverseSparkSql {
    

// @LINE:61
// @LINE:26
def sqlpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkSql.sqlpage",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparksql"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparksql"})
      }
      }
   """
)
                        

// @LINE:62
// @LINE:27
def executesql : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.spark.SparkSql.executesql",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sparksql"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sparksql"})
      }
      }
   """
)
                        
    
}
              
}
        


// @LINE:73
// @LINE:72
package controllers.monitor.ref {


// @LINE:73
// @LINE:72
class ReverseMonitorController {
    

// @LINE:72
def jobs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.monitor.MonitorController.jobs(), HandlerDef(this, "controllers.monitor.MonitorController", "jobs", Seq(), "GET", """""", _prefix + """jobs""")
)
                      

// @LINE:73
def streaming(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.monitor.MonitorController.streaming(), HandlerDef(this, "controllers.monitor.MonitorController", "streaming", Seq(), "GET", """""", _prefix + """streaming""")
)
                      
    
}
                          
}
        

// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
package controllers.hadoop.ref {


// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:31
def yarnlist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.hadoop.YarnList.yarnlist(), HandlerDef(this, "controllers.hadoop.YarnList", "yarnlist", Seq(), "GET", """""", _prefix + """yarnlist""")
)
                      

// @LINE:33
def spark_info(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.hadoop.YarnList.spark_info(), HandlerDef(this, "controllers.hadoop.YarnList", "spark_info", Seq(), "GET", """""", _prefix + """spark_info""")
)
                      

// @LINE:30
def yarnInfo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.hadoop.YarnList.yarnInfo(), HandlerDef(this, "controllers.hadoop.YarnList", "yarnInfo", Seq(), "GET", """Dashboard""", _prefix + """yarnInfo""")
)
                      

// @LINE:34
def sparklist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.hadoop.YarnList.sparklist(), HandlerDef(this, "controllers.hadoop.YarnList", "sparklist", Seq(), "GET", """""", _prefix + """sparklist""")
)
                      

// @LINE:32
def workerlist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.hadoop.YarnList.workerlist(), HandlerDef(this, "controllers.hadoop.YarnList", "workerlist", Seq(), "GET", """""", _prefix + """workerlist""")
)
                      
    
}
                          
}
        

// @LINE:69
// @LINE:36
// @LINE:6
package controllers.ref {


// @LINE:69
// @LINE:36
class ReverseAssets {
    

// @LINE:36
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.auth.ref {


// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseAuthentication {
    

// @LINE:47
def updatepwd(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.updatepwd(), HandlerDef(this, "controllers.auth.Authentication", "updatepwd", Seq(), "POST", """""", _prefix + """updatepwd""")
)
                      

// @LINE:44
def captcha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.captcha(), HandlerDef(this, "controllers.auth.Authentication", "captcha", Seq(), "GET", """""", _prefix + """captcha""")
)
                      

// @LINE:41
def mail(user:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.mail(user), HandlerDef(this, "controllers.auth.Authentication", "mail", Seq(classOf[String]), "GET", """""", _prefix + """mail""")
)
                      

// @LINE:43
def findpwd(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.findpwd(), HandlerDef(this, "controllers.auth.Authentication", "findpwd", Seq(), "GET", """""", _prefix + """findpwd""")
)
                      

// @LINE:42
def verifyingmail(email:String, validateCode:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.verifyingmail(email, validateCode), HandlerDef(this, "controllers.auth.Authentication", "verifyingmail", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """mail/verifyingmail""")
)
                      

// @LINE:39
def registration(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.registration(), HandlerDef(this, "controllers.auth.Authentication", "registration", Seq(), "GET", """TestIndex""", _prefix + """registration""")
)
                      

// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.logout(), HandlerDef(this, "controllers.auth.Authentication", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:45
def resetpwd(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.resetpwd(), HandlerDef(this, "controllers.auth.Authentication", "resetpwd", Seq(), "POST", """""", _prefix + """findpwd""")
)
                      

// @LINE:40
def verifying(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.verifying(), HandlerDef(this, "controllers.auth.Authentication", "verifying", Seq(), "POST", """""", _prefix + """registration""")
)
                      

// @LINE:46
def setpwd(email:String, pwdToken:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.setpwd(email, pwdToken), HandlerDef(this, "controllers.auth.Authentication", "setpwd", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """mail/setpwd""")
)
                      

// @LINE:8
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.authenticate(), HandlerDef(this, "controllers.auth.Authentication", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.auth.Authentication.login(), HandlerDef(this, "controllers.auth.Authentication", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          
}
        

// @LINE:62
// @LINE:61
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
package controllers.spark.ref {


// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseSparkStream {
    

// @LINE:23
def errorpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkStream.errorpage(), HandlerDef(this, "controllers.spark.SparkStream", "errorpage", Seq(), "GET", """""", _prefix + """errorpage""")
)
                      

// @LINE:22
def streamExecute(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkStream.streamExecute(), HandlerDef(this, "controllers.spark.SparkStream", "streamExecute", Seq(), "POST", """""", _prefix + """streamExecute""")
)
                      

// @LINE:20
def stremupload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkStream.stremupload(), HandlerDef(this, "controllers.spark.SparkStream", "stremupload", Seq(), "POST", """""", _prefix + """stremupload""")
)
                      

// @LINE:19
def stream(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkStream.stream(), HandlerDef(this, "controllers.spark.SparkStream", "stream", Seq(), "GET", """ Spark Stream""", _prefix + """stream""")
)
                      

// @LINE:21
def streamArgs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkStream.streamArgs(), HandlerDef(this, "controllers.spark.SparkStream", "streamArgs", Seq(), "GET", """""", _prefix + """streamArgs""")
)
                      
    
}
                          

// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseSparkJar {
    

// @LINE:13
def upload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkJar.upload(), HandlerDef(this, "controllers.spark.SparkJar", "upload", Seq(), "POST", """""", _prefix + """sparkjar""")
)
                      

// @LINE:15
def executejar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkJar.executejar(), HandlerDef(this, "controllers.spark.SparkJar", "executejar", Seq(), "POST", """""", _prefix + """executejar""")
)
                      

// @LINE:16
def errorpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkJar.errorpage(), HandlerDef(this, "controllers.spark.SparkJar", "errorpage", Seq(), "GET", """""", _prefix + """errorpage""")
)
                      

// @LINE:12
def uploadpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkJar.uploadpage(), HandlerDef(this, "controllers.spark.SparkJar", "uploadpage", Seq(), "GET", """ Spark Jar""", _prefix + """sparkjar""")
)
                      

// @LINE:14
def executejarpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkJar.executejarpage(), HandlerDef(this, "controllers.spark.SparkJar", "executejarpage", Seq(), "GET", """""", _prefix + """executejar""")
)
                      
    
}
                          

// @LINE:62
// @LINE:61
// @LINE:27
// @LINE:26
class ReverseSparkSql {
    

// @LINE:26
def sqlpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkSql.sqlpage(), HandlerDef(this, "controllers.spark.SparkSql", "sqlpage", Seq(), "GET", """ Saprk Sql""", _prefix + """sparksql""")
)
                      

// @LINE:27
def executesql(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.spark.SparkSql.executesql(), HandlerDef(this, "controllers.spark.SparkSql", "executesql", Seq(), "POST", """""", _prefix + """sparksql""")
)
                      
    
}
                          
}
        
    