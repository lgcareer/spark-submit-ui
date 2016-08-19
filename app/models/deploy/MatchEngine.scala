package models.deploy

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



  def matchMode :PartialFunction[String,Regex]={
    case m if m.startsWith("yarn") =>   regex_on_yarn
    case m if m.startsWith("standalone") => regex_on_standalone
    case m if m.startsWith("local") => regex_on_local
  }

}
