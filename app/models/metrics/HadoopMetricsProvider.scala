package models.metrics


import models.utils.{Config, Configuration}
import play.api.libs.json.Json
import scala.io.{BufferedSource, Source}

/**
  * Created by king on 2017/1/5.
  */
object HadoopMetricsProvider {

  private[this] val _config:Config =new Configuration

  def getDFSInfo={
    val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystem"
    val json = Json.parse(Source.fromURL(url).mkString)

    val used: String = Json.stringify(json \ "CapacityUsed")
    val usednondfs: String = Json.stringify(json \ "CapacityUsedNonDFS")

    (used,usednondfs)
  }




}
