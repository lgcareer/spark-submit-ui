package controllers

import models.metrics.HadoopMetricsProvider
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}


/**
  * Created by king on 2017/2/21.
  */
object HadoopMetrics  extends Controller{


  /**
    * 获取RPC发送的平均字节数
    * @return
    */
  def getRPCSentInfo=Action{
    val sentInterval: Seq[Long] = HadoopMetricsProvider.calcSentInterval()
    val json: JsValue = Json.toJson(sentInterval)
    Ok(json)
  }


  /**
    * 获取RPC接收的平均字节数
    * @return
    */
  def getRPCReceivedInfo=Action{
    val sentInterval: Seq[Long] = HadoopMetricsProvider.calcReceivedInterval()
    val json: JsValue = Json.toJson(sentInterval)
    Ok(json)
  }





}
