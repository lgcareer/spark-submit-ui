package models

/**
  * Created by king on 2017/2/21.
  */

/**
  *
  * @param rec_rpc 接收字节
  * @param sent_rpc 发送字节
  * @param time  时间
  */
case class RPCInfo(rec_rpc:play.api.libs.json.JsValue,
                   sent_rpc :play.api.libs.json.JsValue,
                   time:String)

