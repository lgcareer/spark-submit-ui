// @SOURCE:/Users/manbu/IdeaProjects/ficusspark/conf/routes
// @HASH:fbd3c78d6849c09bd713ae1910325e87b441d38c
// @DATE:Mon Jul 18 15:34:24 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
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
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:63
// @LINE:36
class ReverseAssets {
    

// @LINE:63
// @LINE:36
def at(file:String): Call = {
   (file: @unchecked) match {
// @LINE:36
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
// @LINE:63
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
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
                          

// @LINE:27
// @LINE:26
class ReverseSparkSql {
    

// @LINE:26
def sqlpage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sparksql")
}
                                                

// @LINE:27
def executesql(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "executesql")
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
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:67
// @LINE:66
class ReverseMonitorController {
    

// @LINE:66
def jobs(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "jobs")
}
                                                

// @LINE:67
def streaming(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "streaming")
}
                                                
    
}
                          

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
                          

// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:60
// @LINE:31
def yarnlist(): Call = {
   () match {
// @LINE:31
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnlist")
                                                        
// @LINE:60
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnlist")
                                                        
   }
}
                                                

// @LINE:33
def spark_info(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "spark_info")
}
                                                

// @LINE:59
// @LINE:30
def yarnInfo(): Call = {
   () match {
// @LINE:30
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnInfo")
                                                        
// @LINE:59
case () if true => Call("GET", _prefix + { _defaultPrefix } + "yarnInfo")
                                                        
   }
}
                                                

// @LINE:34
def sparklist(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sparklist")
}
                                                

// @LINE:61
// @LINE:32
def workerlist(): Call = {
   () match {
// @LINE:32
case () if true => Call("GET", _prefix + { _defaultPrefix } + "workerlist")
                                                        
// @LINE:61
case () if true => Call("GET", _prefix + { _defaultPrefix } + "workerlist")
                                                        
   }
}
                                                
    
}
                          
}
                  


// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
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
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:63
// @LINE:36
class ReverseAssets {
    

// @LINE:63
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
   "controllers.Authentication.updatepwd",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updatepwd"})
      }
   """
)
                        

// @LINE:44
def captcha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.captcha",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "captcha"})
      }
   """
)
                        

// @LINE:41
def mail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.mail",
   """
      function(user) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user", user)])})
      }
   """
)
                        

// @LINE:43
def findpwd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.findpwd",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findpwd"})
      }
   """
)
                        

// @LINE:42
def verifyingmail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.verifyingmail",
   """
      function(email,validateCode) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mail/verifyingmail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("validateCode", validateCode)])})
      }
   """
)
                        

// @LINE:39
def registration : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.registration",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        

// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:45
def resetpwd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.resetpwd",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "findpwd"})
      }
   """
)
                        

// @LINE:40
def verifying : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.verifying",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        

// @LINE:46
def setpwd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.setpwd",
   """
      function(email,pwdToken) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mail/setpwd" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pwdToken", pwdToken)])})
      }
   """
)
                        

// @LINE:8
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:27
// @LINE:26
class ReverseSparkSql {
    

// @LINE:26
def sqlpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkSql.sqlpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparksql"})
      }
   """
)
                        

// @LINE:27
def executesql : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkSql.executesql",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "executesql"})
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
   "controllers.SparkJar.upload",
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
   "controllers.SparkJar.executejar",
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
   "controllers.SparkJar.errorpage",
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
   "controllers.SparkJar.uploadpage",
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
   "controllers.SparkJar.executejarpage",
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
              

// @LINE:67
// @LINE:66
class ReverseMonitorController {
    

// @LINE:66
def jobs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MonitorController.jobs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jobs"})
      }
   """
)
                        

// @LINE:67
def streaming : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MonitorController.streaming",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "streaming"})
      }
   """
)
                        
    
}
              

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseSparkStream {
    

// @LINE:23
def errorpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkStream.errorpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "errorpage"})
      }
   """
)
                        

// @LINE:22
def streamExecute : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkStream.streamExecute",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "streamExecute"})
      }
   """
)
                        

// @LINE:20
def stremupload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkStream.stremupload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "stremupload"})
      }
   """
)
                        

// @LINE:19
def stream : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkStream.stream",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stream"})
      }
   """
)
                        

// @LINE:21
def streamArgs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkStream.streamArgs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "streamArgs"})
      }
   """
)
                        
    
}
              

// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:60
// @LINE:31
def yarnlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.yarnlist",
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
   "controllers.YarnList.spark_info",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "spark_info"})
      }
   """
)
                        

// @LINE:59
// @LINE:30
def yarnInfo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.yarnInfo",
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
   "controllers.YarnList.sparklist",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparklist"})
      }
   """
)
                        

// @LINE:61
// @LINE:32
def workerlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.workerlist",
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
        


// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
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
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:63
// @LINE:36
class ReverseAssets {
    

// @LINE:36
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
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
class ReverseAuthentication {
    

// @LINE:47
def updatepwd(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.updatepwd(), HandlerDef(this, "controllers.Authentication", "updatepwd", Seq(), "POST", """""", _prefix + """updatepwd""")
)
                      

// @LINE:44
def captcha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.captcha(), HandlerDef(this, "controllers.Authentication", "captcha", Seq(), "GET", """""", _prefix + """captcha""")
)
                      

// @LINE:41
def mail(user:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.mail(user), HandlerDef(this, "controllers.Authentication", "mail", Seq(classOf[String]), "GET", """""", _prefix + """mail""")
)
                      

// @LINE:43
def findpwd(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.findpwd(), HandlerDef(this, "controllers.Authentication", "findpwd", Seq(), "GET", """""", _prefix + """findpwd""")
)
                      

// @LINE:42
def verifyingmail(email:String, validateCode:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.verifyingmail(email, validateCode), HandlerDef(this, "controllers.Authentication", "verifyingmail", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """mail/verifyingmail""")
)
                      

// @LINE:39
def registration(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.registration(), HandlerDef(this, "controllers.Authentication", "registration", Seq(), "GET", """TestIndex""", _prefix + """registration""")
)
                      

// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.logout(), HandlerDef(this, "controllers.Authentication", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:45
def resetpwd(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.resetpwd(), HandlerDef(this, "controllers.Authentication", "resetpwd", Seq(), "POST", """""", _prefix + """findpwd""")
)
                      

// @LINE:40
def verifying(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.verifying(), HandlerDef(this, "controllers.Authentication", "verifying", Seq(), "POST", """""", _prefix + """registration""")
)
                      

// @LINE:46
def setpwd(email:String, pwdToken:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.setpwd(email, pwdToken), HandlerDef(this, "controllers.Authentication", "setpwd", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """mail/setpwd""")
)
                      

// @LINE:8
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.authenticate(), HandlerDef(this, "controllers.Authentication", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.login(), HandlerDef(this, "controllers.Authentication", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:27
// @LINE:26
class ReverseSparkSql {
    

// @LINE:26
def sqlpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkSql.sqlpage(), HandlerDef(this, "controllers.SparkSql", "sqlpage", Seq(), "GET", """ Saprk Sql""", _prefix + """sparksql""")
)
                      

// @LINE:27
def executesql(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkSql.executesql(), HandlerDef(this, "controllers.SparkSql", "executesql", Seq(), "GET", """""", _prefix + """executesql""")
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
   controllers.SparkJar.upload(), HandlerDef(this, "controllers.SparkJar", "upload", Seq(), "POST", """""", _prefix + """sparkjar""")
)
                      

// @LINE:15
def executejar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkJar.executejar(), HandlerDef(this, "controllers.SparkJar", "executejar", Seq(), "POST", """""", _prefix + """executejar""")
)
                      

// @LINE:16
def errorpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkJar.errorpage(), HandlerDef(this, "controllers.SparkJar", "errorpage", Seq(), "GET", """""", _prefix + """errorpage""")
)
                      

// @LINE:12
def uploadpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkJar.uploadpage(), HandlerDef(this, "controllers.SparkJar", "uploadpage", Seq(), "GET", """ Spark Jar""", _prefix + """sparkjar""")
)
                      

// @LINE:14
def executejarpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkJar.executejarpage(), HandlerDef(this, "controllers.SparkJar", "executejarpage", Seq(), "GET", """""", _prefix + """executejar""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:67
// @LINE:66
class ReverseMonitorController {
    

// @LINE:66
def jobs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MonitorController.jobs(), HandlerDef(this, "controllers.MonitorController", "jobs", Seq(), "GET", """""", _prefix + """jobs""")
)
                      

// @LINE:67
def streaming(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MonitorController.streaming(), HandlerDef(this, "controllers.MonitorController", "streaming", Seq(), "GET", """""", _prefix + """streaming""")
)
                      
    
}
                          

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseSparkStream {
    

// @LINE:23
def errorpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkStream.errorpage(), HandlerDef(this, "controllers.SparkStream", "errorpage", Seq(), "GET", """""", _prefix + """errorpage""")
)
                      

// @LINE:22
def streamExecute(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkStream.streamExecute(), HandlerDef(this, "controllers.SparkStream", "streamExecute", Seq(), "POST", """""", _prefix + """streamExecute""")
)
                      

// @LINE:20
def stremupload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkStream.stremupload(), HandlerDef(this, "controllers.SparkStream", "stremupload", Seq(), "POST", """""", _prefix + """stremupload""")
)
                      

// @LINE:19
def stream(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkStream.stream(), HandlerDef(this, "controllers.SparkStream", "stream", Seq(), "GET", """ Spark Stream""", _prefix + """stream""")
)
                      

// @LINE:21
def streamArgs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkStream.streamArgs(), HandlerDef(this, "controllers.SparkStream", "streamArgs", Seq(), "GET", """""", _prefix + """streamArgs""")
)
                      
    
}
                          

// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:31
def yarnlist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.yarnlist(), HandlerDef(this, "controllers.YarnList", "yarnlist", Seq(), "GET", """""", _prefix + """yarnlist""")
)
                      

// @LINE:33
def spark_info(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.spark_info(), HandlerDef(this, "controllers.YarnList", "spark_info", Seq(), "GET", """""", _prefix + """spark_info""")
)
                      

// @LINE:30
def yarnInfo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.yarnInfo(), HandlerDef(this, "controllers.YarnList", "yarnInfo", Seq(), "GET", """Dashboard""", _prefix + """yarnInfo""")
)
                      

// @LINE:34
def sparklist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.sparklist(), HandlerDef(this, "controllers.YarnList", "sparklist", Seq(), "GET", """""", _prefix + """sparklist""")
)
                      

// @LINE:32
def workerlist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.workerlist(), HandlerDef(this, "controllers.YarnList", "workerlist", Seq(), "GET", """""", _prefix + """workerlist""")
)
                      
    
}
                          
}
        
    