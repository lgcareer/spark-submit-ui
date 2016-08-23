package models

import scala.util.matching.Regex

/**
  * Created by king on 16/8/18.
  */
object MatchEngine {



  /**
    * on_local 模式匹配
    */
  val regex_on_local = """Starting executor ID driver on host localhost(.*)""".r.unanchored

  /**
    * on yarn-cluster 模式匹配
    */
  val regex_on_yarn = """Submitted application (.*)""".r.unanchored


  /**
    * standalone 模式匹配
    */
  val regex_on_standalone = """Spark cluster with app ID (.*)""".r.unanchored


  val spark_uri ="http://localhost:8080/json/"

  val yarn_uri="http://localhost:8088/ws/v1/cluster/apps"



  def matchMode :PartialFunction[String,Regex]={
    case m if m.startsWith("yarn") =>   regex_on_yarn
    case m if m.startsWith("spark") => regex_on_standalone
    case m if m.startsWith("local") => regex_on_local
  }

  def matchURI : PartialFunction[String,Option[(String,String)]]={
    case m if m.startsWith("application") => Some(("yarn",yarn_uri))
    case m if m.startsWith("app") => Some(("standalone",spark_uri))
    case m if m.startsWith("local") => None

  }

}


