package models.metrics


import models.utils.{Config, Configuration}
import play.api.libs.iteratee.Input.Empty
import play.api.libs.json.Json

import scala.io.{BufferedSource, Source}

/**
  * Created by king on 2017/2/7.
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

  def getCapacityInfo={
    val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystem"
    val json = Json.parse(Source.fromURL(url).mkString)

    val used: String = Json.stringify(json \ "CapacityUsed")
    val usednondfs: String = Json.stringify(json \ "CapacityUsedNonDFS")

    (used,usednondfs)
  }

  def getQueuedInfo={
    val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystem"
    val json = Json.parse(Source.fromURL(url).mkString)

    val used: String = Json.stringify(json \ "QueuedEditsSize")
    val usednondfs: String = Json.stringify(json \ "LagTimeMillis")

    (used,usednondfs)
  }

  def getDFMOTEN={
    val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystem"
    val json = Json.parse(Source.fromURL(url).mkString)

    val used: String = Json.stringify(json \ "ImplementationName")
    val usednondfs: String = Json.stringify(json \ "ImplementationVersion")

    (used,usednondfs)
  }




}
