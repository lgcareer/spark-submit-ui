// @SOURCE:/Users/manbu/Desktop/ficusspark/conf/routes
// @HASH:50aed78bdb0424879ffde05464edd33c6e4e1ba3
// @DATE:Wed Jun 29 16:40:14 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


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

// @LINE:36
class ReverseAssets {
    

// @LINE:36
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
class ReverseAuthentication {
    

// @LINE:9
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
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
   Call("POST", _prefix + { _defaultPrefix } + "sparksql")
}
                                                
    
}
                          

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseSparkJar {
    

// @LINE:13
def upload(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "sparkjar")
}
                                                

// @LINE:15
def executejar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "executejar")
}
                                                

// @LINE:16
def errorpage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "errorpage")
}
                                                

// @LINE:12
def uploadpage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sparkjar")
}
                                                

// @LINE:14
def executejarpage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "executejar")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
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
                          

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:31
def yarnlist(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "yarnlist")
}
                                                

// @LINE:33
def spark_info(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "spark_info")
}
                                                

// @LINE:30
def yarnInfo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "yarnInfo")
}
                                                

// @LINE:34
def sparklist(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sparklist")
}
                                                

// @LINE:32
def workerlist(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "workerlist")
}
                                                
    
}
                          
}
                  


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

// @LINE:36
class ReverseAssets {
    

// @LINE:36
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
// @LINE:7
class ReverseAuthentication {
    

// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
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
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sparksql"})
      }
   """
)
                        
    
}
              

// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseSparkJar {
    

// @LINE:13
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkJar.upload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sparkjar"})
      }
   """
)
                        

// @LINE:15
def executejar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkJar.executejar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "executejar"})
      }
   """
)
                        

// @LINE:16
def errorpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkJar.errorpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "errorpage"})
      }
   """
)
                        

// @LINE:12
def uploadpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkJar.uploadpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparkjar"})
      }
   """
)
                        

// @LINE:14
def executejarpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkJar.executejarpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "executejar"})
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
              

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
class ReverseYarnList {
    

// @LINE:31
def yarnlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.yarnlist",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnlist"})
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
                        

// @LINE:30
def yarnInfo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.yarnInfo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnInfo"})
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
                        

// @LINE:32
def workerlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.workerlist",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workerlist"})
      }
   """
)
                        
    
}
              
}
        


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


// @LINE:36
class ReverseAssets {
    

// @LINE:36
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
class ReverseAuthentication {
    

// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.logout(), HandlerDef(this, "controllers.Authentication", "logout", Seq(), "GET", """""", _prefix + """logout""")
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
   controllers.SparkSql.executesql(), HandlerDef(this, "controllers.SparkSql", "executesql", Seq(), "POST", """""", _prefix + """sparksql""")
)
                      
    
}
                          

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
        
    