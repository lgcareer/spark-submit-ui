package models.metrics

import akka.actor.Cancellable
import models.{MetricsData, NodeData}
import models.TaskDataProvider.{AppDataObject, TaskData, YarnTaskInfoList}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import models.utils.{Config, Configuration}
import play.api.Logger
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WS
import play.libs.Akka

import scala.io.{BufferedSource, Source}

/**
  * Created by king on 2017/2/7.
  */
object HadoopMetricsProvider {

  private[this] val _config:Config =new Configuration


   val startMetrics: Cancellable = scheduleMetricsDate


  def getDFSInfo={
    val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystem"
    val json = Json.parse(Source.fromURL(url).mkString)

    val CapacityUsed = (json \ "CapacityUsed").as[Long]
    val CapacityUsedNonDFS =(json \ "CapacityUsedNonDFS").as[Long]
    val receivedBytes = (json \ "ReceivedBytes").as[Long]
    val sentBytes = (json \ "SentBytes").as[Long]
  }

  def calcSentInterval():Seq[Long] ={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics
    val result:Seq[Long]={
      for(i<- 0 until metrics.length)
     yield if(i==metrics.length-1){
       0
     }else{
       (metrics(i).sentBytes-metrics(i+1).sentBytes)
     }
    }.dropRight(1)
    Logger.debug(result.toString())
    result.reverse
  }


  def calcReceivedInterval():Seq[Long] ={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics
    val result:Seq[Long]={
      for(i<- 0 until metrics.length)
        yield if(i==metrics.length-1){
          0
        }else{
          (metrics(i).receivedBytes-metrics(i+1).receivedBytes)
        }
    }.dropRight(1)
    Logger.debug(result.toString())
    result.reverse
  }


  def getRpcInfo(json:JsValue)={
    val receivedBytes = (json \\ "ReceivedBytes")(0).as[Long]
    val sentBytes = (json \\ "SentBytes")(0).as[Long]
    (receivedBytes,sentBytes)
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

  import scala.concurrent.duration._

  private[this]  def scheduleMetricsDate={
    Akka.system.scheduler.schedule(0.second, _config.getLong("metrics.data-update.interval-ms") millis, new Runnable {
      override def run(): Unit = {
        val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx?qry=Hadoop:service=NameNode,name=RpcActivityForPort9000"
        WS.url(url).get() map{
          response => response.status match {
            case  200 => Some{

             val (receivedBytes,sentBytes) = getRpcInfo(response.json)
              /**
                * 每次更新增量数据
                */
              MetricsData.updateMetrics(MetricsData(receivedBytes,sentBytes,System.currentTimeMillis(),_config.getString("hadoop.metrics.host")))

            }
            case _ => None
          }
        }


      }
    })
  }





}
