package models.metrics

import java.text.SimpleDateFormat
import java.util.Date

import models._
import play.api.Logger
import play.api.libs.json.{Json}

/**
  * Created by laingkai1 on 2017/2/23.
  * <p>metric 数据计算相关 @host:port/jmx<p>
  *
  */
private[metrics] class MetricsFactory {


  def queryMetricsModels:PartialFunction[Class[_],BaseInfo]={
    case x if  x == RPCInfo.getClass =>
      RPCInfo(ReceivedInterval, SentInterval, getNowDate)

    case x if  x == DFSInfo.getClass =>
      DFSInfo(CapacityUsed,CapacityRemaining,CapacityUsedNonDFS,getNowDate)

    case x if x==MEMInfo.getClass =>
      MEMInfo(MemHeapUsedM,MemNonHeapUsedM,getNowDate)
    case _ => BadInfo("error")
  }



  private [this] def MemNonHeapUsedM={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics()
    val result:Seq[Double]={
      for(me<- metrics) yield (me.MemNonHeapUsedM)
    }
    Logger.debug("=>非堆内存使用量"+result.toString())
    Json.toJson(result.reverse)
  }


  private [this] def MemHeapUsedM ={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics()
    val result:Seq[Double]={
      for(me<- metrics) yield (me.MemHeapUsedM)
    }
    Logger.debug("=>堆内存使用量"+result.toString())
    Json.toJson(result.reverse)
  }


  private [this] def CapacityUsed = {
    val metrics: Seq[MetricsData] = MetricsData.getMetrics()
    val result:Seq[Long]={
      for(me<- metrics) yield (me.CapacityUsed / (1024*1024*1024))
    }
    Logger.debug("=>使用容量"+result.toString())
    Json.toJson(result.reverse)
  }

  private [this] def CapacityRemaining ={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics()
    val result:Seq[Long]={
      for(me<- metrics) yield (me.CapacityRemaining  / (1024*1024*1024))
    }
    Logger.debug("=> 剩余容量"+result.toString())
    Json.toJson(result.reverse)
  }

  private [this] def CapacityUsedNonDFS  ={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics()
    val result:Seq[Long]={
      for(me<- metrics) yield (me.CapacityUsedNonDFS / (1024*1024*1024))
    }
    Logger.debug("=> 使用的非DFS容量"+result.toString())
    Json.toJson(result.reverse)
  }






  private[this] def SentInterval  ={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics()
    val result:Seq[Long]={
      for(i<- 0 until metrics.length)
        yield if(i==metrics.length-1){
          0
        }else{
          (metrics(i).sentBytes-metrics(i+1).sentBytes)
        }
    }.dropRight(1)
    Logger.debug("=> RPC发送"+result.toString())
    Json.toJson(result.reverse)
  }


  private[this] def ReceivedInterval ={
    val metrics: Seq[MetricsData] = MetricsData.getMetrics()
    val result:Seq[Long]={
      for(i<- 0 until metrics.length)
        yield if(i==metrics.length-1){
          0
        }else{
          (metrics(i).receivedBytes-metrics(i+1).receivedBytes)
        }
    }.dropRight(1)
    Logger.debug("=> RPC接收"+result.toString())
    Json.toJson(result.reverse)
  }




  private[this] def getNowDate:String ={
    val before = 3*60*60*1000
    val currentTime = new Date(System.currentTimeMillis()-before);
    //将当前时间设置成整点
    currentTime.setMinutes(0)
    val formatter = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss");
    val dateString = formatter.format(currentTime);
    return dateString;
  }

}
