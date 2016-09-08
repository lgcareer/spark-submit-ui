package controllers

import models.{MetaData, MetaDataList, NodeData, NodeDataList}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}


/**
  * Created by king on 16/9/5.
 *  集群元数据管理
  */
object MetaDataManager extends Controller{


  def metadata=Action{
    Ok(views.html.metadata())
  }

  def metadatas=Action{
    implicit val residentWrites = Json.writes[MetaData]
    implicit val clusterListWrites = Json.writes[MetaDataList]
    val data: JsValue = Json.toJson(MetaDataList(MetaData.findMetaDatas))
    Ok(data)
  }



  def update(id:Int,name:String,unit: String,version:String,url:String)=Action{
    MetaData.addOrUpdate(MetaData(id,name,unit,version,url))
    Ok("操作成功")
  }


  def rm(id:String)=Action{
    MetaData.deleteMetaData(id)
    Ok("操作成功")
  }

  def getNodaDatas =Action{
    implicit val residentWrites = Json.writes[NodeData]
    implicit val clusterListWrites = Json.writes[NodeDataList]
    val data: JsValue = Json.toJson(NodeDataList(NodeData.findNodeDatas))
    Ok(data)

  }


}
