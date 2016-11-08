package controllers

import models.{NodeList, _}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}

/**
  * Created by liangkai1 on 2016/9/26.
  * <p>
  *   集群元数据API
  * </p>
  */
case class State(status:Int,msg:String)
object State{

  def fromProps(status: Int): State= {
    status match {
      case 0 =>  State(1,"fail")
      case _ =>  State(0,"success")
    }
  }
}
object MetaRestApi extends Controller{

  implicit val residentWrites = Json.writes[MetaData]
  implicit val clusterListWrites = Json.writes[MetaDataList]
  implicit val stateWrites = Json.writes[State]

   /**
    *集群信息列表
    * @return
    */
  def getClusterList=Action{
    val data: JsValue = Json.toJson(MetaDataList(MetaData.findMetaDatas))
    Ok(data)
  }

  /**
    * 更新集群信息
    * @param id
    * @param name
    * @param version
    * @param url
    * @return
    */
  def updateCluster(id:Int,name:String,version:String,url:String)=Action{
    import play.api.libs.json._
    val jsValue: JsValue = Json.parse(version)
    val versions: String = jsValue.as[List[String]].mkString("\n")
    val updataMetaData: Int = MetaData.updataMetaData(MetaData(id,name,null,versions,url))
    val state: State = State.fromProps(updataMetaData)
    Ok(Json.toJson(state))
  }



  /**
    * @param id
    * @return
    */
  def rmCluster(id:Int)=Action{
    val deleteMetaData: Int = MetaData.deleteMetaData(id)
    val state: State = State.fromProps(deleteMetaData)
    Ok(Json.toJson(state))
  }

  /**
    * 集群下的节点详情数据 {@link models.NodeDetail}
    * @param pid
    * @return
    */
  def getNodaDatas(pid:Int) =Action{
    implicit val residentWrites = Json.writes[NodeData]
    implicit val resident = Json.writes[NodeDetail]
    implicit val clusterListWrites = Json.writes[NodeDataList]
    Ok(Json.toJson(NodeData.findNodeDetail(pid)))
  }


  /**
    *节点列表
    * @return
    */
  def getNodeList =Action{
    implicit val residentWrites = Json.writes[NodeData]
    implicit val clusterListWrites = Json.writes[NodeList]
    Ok(Json.toJson(NodeList(NodeData.findNodeDatas)))
  }


  /**
    * 更新节点信息
    * @param id
    * @param ip
    * @param host
    * @param role
    * @param name
    * @return
    */
  def updateNode(id:Int,ip:String,host: String,role:String,name:String)=Action{
    import play.api.libs.json._
    val jsValue: JsValue = Json.parse(role)
    val roles: String = jsValue.as[List[String]].mkString("\n")
    val pid: Int = MetaData.findIdByName(name)
    val updataNodeaData: Int = NodeData.updataNodeaData(NodeData(id,ip,host,roles,name,pid))
    Ok(Json.toJson(State.fromProps(updataNodeaData)))
  }



  /**
    * 删除节点
    * @param id
    * @return
    */
  def deleteNode(id:Int) =Action{
    val deleteNodeData: Int = NodeData.deleteNodeData(id)
    Ok(Json.toJson(State.fromProps(deleteNodeData)))
  }

  /**
    * 集群名称列表
    * @return
    */
  def getNames=Action{
    import play.api.libs.json._
    Ok(Json.toJson(MetaData.findNames))
  }

  /**
    * 添加集群信息
    * @param id
    * @param name
    * @param version
    * @param url
    * @return
    */
  def addCluster(name:String,version:String,url:String)=Action{
    import play.api.libs.json._
    val jsValue: JsValue = Json.parse(version)
    val versions: String = jsValue.as[List[String]].mkString("\n")
    val updataMetaData: Int = MetaData.addMetaData(MetaData(id=0,name,null,versions,url))
    Ok(Json.toJson(State.fromProps(updataMetaData)))
  }


  /**
    * 添加节点信息
    * @return
    */
  def addNode=Action{
    implicit request =>
      import play.api.libs.json._
    val (ip, host, role, name) = addnode.bindFromRequest.get
    val pid: Int = MetaData.findIdByName(name)
    val addNodeData: Seq[Int] = NodeData.addNodeData(NodeData(id=0,ip,host,role,name,pid))
    val reduce: Int = addNodeData.reduce(_+_)
    Ok(Json.toJson(State.fromProps(reduce)))
  }


  /**
    * 批量节点删除
    * @param pid
    * @return
    */
  def deleteNodeBatch(pid:Int) =Action{
    val deleteNodeData: Int = NodeData.deleteNodeBatch(pid)
    Ok(Json.toJson(State.fromProps(deleteNodeData)))
  }


  /**
    * 查询产品单元
    * @return
    */
   def getProductList=Action{
     implicit val residentWrites = Json.writes[ProductData]
     implicit val clusterListWrites = Json.writes[ProductDataList]
     Ok(Json.toJson(ProductDataList(ProductData.findProductDatas)))
   }


  /**
    * 添加产品单元
    * @return
    */
  def addProductData(unit:String,desc:String,contact:String,cluster:String)=Action{
    val productData: Int = ProductData.addProductData(ProductData(id=0,unit,desc,contact,cluster))
    Ok(Json.toJson(State.fromProps(productData)))
  }

  /**
    * 删除产品单元
    * @return
    */
  def deleteProductData(id:Int)=Action{
    val productData: Int = ProductData.deleteProductData(id)
    Ok(Json.toJson(State.fromProps(productData)))
  }

  /**
    * 更新产品单元
    * @return
    */
  def updataProductData(id:Int,unit:String,desc:String,contact:String,cluster:String)=Action{
    val productData: Int = ProductData.updataProductData(ProductData(id,unit,desc,contact,cluster))
    Ok(Json.toJson(State.fromProps(productData)))
  }




  val addnode = Form(
    tuple(
      "ip" -> text,
      "host" -> text,
      "role" -> text,
      "name" -> text
    )
  )



}
