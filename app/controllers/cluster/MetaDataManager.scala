package controllers

import java.io.FileInputStream

import models.{MetaData, MetaDataList, NodeData, NodeDataList}
import play.api.Logger
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
    import play.api.libs.json._

    val jsValue: JsValue = Json.parse(version)
    val versions: String = jsValue.as[List[String]].mkString("\n")

    MetaData.addOrUpdate(MetaData(id,name,unit,versions,url))
    Ok("操作成功")
  }


  def rm(id:String)=Action{
    MetaData.deleteMetaData(id)
    Ok("操作成功")
  }

  def getNodaDatas(pid:Int) =Action{
    implicit val residentWrites = Json.writes[NodeData]
    implicit val clusterListWrites = Json.writes[NodeDataList]
    val data: JsValue = Json.toJson(NodeDataList(NodeData.findNodeDatasById(pid)))
    Ok(data)
  }




  def nodeList =Action{
    implicit val residentWrites = Json.writes[NodeData]
    implicit val clusterListWrites = Json.writes[NodeDataList]
    val data: JsValue = Json.toJson(NodeDataList(NodeData.findNodeDatas))
    Ok(data)
  }



  def updateNode(id:Int,ip:String,host: String,role:String,name:String)=Action{
    import play.api.libs.json._

    val jsValue: JsValue = Json.parse(role)
    val roles: String = jsValue.as[List[String]].mkString("\n")
    val pid: Int = MetaData.findIdByName(name)
    NodeData.addOrUpdate(NodeData(id,ip,host,roles,name,pid))
    Ok("操作成功")
  }


  def deleteNode(id:String) =Action{
    NodeData.deleteNodeData(id)
    Ok("操作成功")
  }

  def getNames()=Action{
    import play.api.libs.json._
    val names: Seq[String] = MetaData.findNames
    Ok(Json.toJson(names))
  }






}
