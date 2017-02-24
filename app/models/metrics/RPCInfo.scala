package models

import play.api.libs.json.JsValue

/**
  * Created by liangkai on 2017/2/21.
  */


sealed class  BaseInfo;
/**
  *
  * @param rec_rpc 接收字节
  * @param sent_rpc 发送字节
  * @param time  时间
  */
case class RPCInfo(rec_rpc:JsValue,
                   sent_rpc :JsValue,
                   time:String) extends  BaseInfo

/**
  * HDFS 磁盘详情
  * @param capacityUsed
  * @param capacityRemaining
  * @param capacityUsedNonDFS
  * @param time
  */
case  class DFSInfo(capacityUsed:JsValue,
                    capacityRemaining:JsValue,
                    capacityUsedNonDFS:JsValue,
                    time:String) extends  BaseInfo

/**
  * 内存与非堆内存
  * @param memHeapUsedM
  * @param memNonHeapUsedM
  * @param time
  */
case class MEMInfo(memHeapUsedM:JsValue,memNonHeapUsedM:JsValue,time:String) extends  BaseInfo


case class  BadInfo(msg:String)extends  BaseInfo{

  override def toString: String = this.msg

}




