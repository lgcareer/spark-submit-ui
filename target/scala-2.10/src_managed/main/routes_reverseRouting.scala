// @SOURCE:/Users/manbu/Desktop/ficusspark/conf/routes
// @HASH:50cbb2513e564fb397f853ffbf8508d88f13a0b9
// @DATE:Fri Jun 24 10:13:13 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
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

// @LINE:28
class ReverseAssets {
    

// @LINE:28
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
                          

// @LINE:20
// @LINE:19
class ReverseSparkSql {
    

// @LINE:19
def sqlpage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "sparksql")
}
                                                

// @LINE:20
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
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseYarnList {
    

// @LINE:26
def spark_info(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "spark_info")
}
                                                

// @LINE:24
def yarnlist(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "yarnlist")
}
                                                

// @LINE:23
def yarnInfo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "yarnInfo")
}
                                                

// @LINE:25
def workerlist(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "workerlist")
}
                                                
    
}
                          
}
                  


// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
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

// @LINE:28
class ReverseAssets {
    

// @LINE:28
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
              

// @LINE:20
// @LINE:19
class ReverseSparkSql {
    

// @LINE:19
def sqlpage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkSql.sqlpage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sparksql"})
      }
   """
)
                        

// @LINE:20
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
              

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseYarnList {
    

// @LINE:26
def spark_info : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.spark_info",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "spark_info"})
      }
   """
)
                        

// @LINE:24
def yarnlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.yarnlist",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnlist"})
      }
   """
)
                        

// @LINE:23
def yarnInfo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.YarnList.yarnInfo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "yarnInfo"})
      }
   """
)
                        

// @LINE:25
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
        


// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
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


// @LINE:28
class ReverseAssets {
    

// @LINE:28
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
                          

// @LINE:20
// @LINE:19
class ReverseSparkSql {
    

// @LINE:19
def sqlpage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkSql.sqlpage(), HandlerDef(this, "controllers.SparkSql", "sqlpage", Seq(), "GET", """ Saprk Sql""", _prefix + """sparksql""")
)
                      

// @LINE:20
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
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseYarnList {
    

// @LINE:26
def spark_info(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.spark_info(), HandlerDef(this, "controllers.YarnList", "spark_info", Seq(), "GET", """""", _prefix + """spark_info""")
)
                      

// @LINE:24
def yarnlist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.yarnlist(), HandlerDef(this, "controllers.YarnList", "yarnlist", Seq(), "GET", """""", _prefix + """yarnlist""")
)
                      

// @LINE:23
def yarnInfo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.yarnInfo(), HandlerDef(this, "controllers.YarnList", "yarnInfo", Seq(), "GET", """Dashboard""", _prefix + """yarnInfo""")
)
                      

// @LINE:25
def workerlist(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.YarnList.workerlist(), HandlerDef(this, "controllers.YarnList", "workerlist", Seq(), "GET", """""", _prefix + """workerlist""")
)
                      
    
}
                          
}
        
    