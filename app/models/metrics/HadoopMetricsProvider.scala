package models.metrics

import akka.actor.Cancellable
import models.{BaseInfo, MetricsData, NodeData, RPCInfo}
import models.TaskDataProvider.{AppDataObject, TaskData, YarnTaskInfoList}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import models.utils.{Config, Configuration}
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WS
import play.libs.Akka

import scala.io.{BufferedSource, Source}

/**
  * Created by king on 2017/2/7.
  */
object HadoopMetricsProvider {

  private[this] val _config:Config =new Configuration
  private[this] val _factory: MetricsFactory = new MetricsFactory

   val startMetrics: Cancellable = scheduleMetricsDate




  private def getMENInfo(json:JsValue)={
    val memNonHeapUsedM = (json \\ "MemNonHeapUsedM")(0).as[Double]
    val memHeapUsedM = (json \\ "MemHeapUsedM")(0).as[Double]
    (memNonHeapUsedM,memHeapUsedM)
  }


  /**
    * 使用的HDFS
    * 剩余的HDFS
    * 使用的非HDFS
    * @param json
    * @return
    */
  private def getDFSInfo(json:JsValue)={
    val CapacityUsed = (json \\ "CapacityUsed")(0).as[Long]
    val CapacityRemaining = (json \\ "CapacityRemaining")(0).as[Long]
    val CapacityUsedNonDFS=(json \\ "CapacityUsedNonDFS")(0).as[Long]
    (CapacityUsed,CapacityRemaining,CapacityUsedNonDFS)
  }


  /**
    *
    * @param clz
    * @tparam T
    * @return
    */
   def getMetricMouled[T](clz:Class[_])={
    clz.getClass match  {
      case _=> _factory.queryMetricsModels(clz).asInstanceOf[T]
    }

  }

  /**
    * RPC SENT AND RECIVED BYTE
    * @param json
    * @return
    */
  private def getRpcInfo(json:JsValue)={
    val receivedBytes = (json \\ "ReceivedBytes")(0).as[Long]
    val sentBytes = (json \\ "SentBytes")(0).as[Long]
    (receivedBytes,sentBytes)
  }

  private def getQueuedInfo={
    val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystem"
    val json = Json.parse(Source.fromURL(url).mkString)

    val used: String = Json.stringify(json \ "QueuedEditsSize")
    val usednondfs: String = Json.stringify(json \ "LagTimeMillis")

    (used,usednondfs)
  }

  private def getDFMOTEN={
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
        val url="http://"+_config.getString("hadoop.metrics.host")+":50070/jmx"
        WS.url(url).get() map{
          response => response.status match {
            case  200 => Some{

             val (receivedBytes,sentBytes) = getRpcInfo(response.json)
             val (capacityUsed,capacityRemaining,capacityUsedNonDFS)=getDFSInfo(response.json)
             val  (memNonHeapUsedM,memHeapUsedM)=getMENInfo(response.json)
              /**
                * 每次更新增量数据
                */
              MetricsData.updateMetrics(MetricsData(
                receivedBytes,
                sentBytes,
                System.currentTimeMillis(),
                _config.getString("hadoop.metrics.host"),
                capacityUsed,
                capacityRemaining,
                capacityUsedNonDFS,
                memNonHeapUsedM,
                memHeapUsedM))

            }
            case _ => None
          }
        }


      }
    })
  }





}
