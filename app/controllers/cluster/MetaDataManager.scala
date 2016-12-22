package controllers

import models._
import org.apache.spark.{SparkConf, SparkContext}
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}


/**
  * Created by liangkai on 16/9/5.
 *  集群元数据管理
  */
object MetaDataManager extends Controller with Secured{


  def metadata=IsAuthenticated{
    username => implicit request =>
      if(UserGroup.hasAdminGroup(username)) Ok(views.html.metadata())  else
        Ok(views.html.readmetadata())
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


  def rm(id:Int)=Action{
    MetaData.deleteMetaData(id)
    Ok("操作成功")
  }

  def getNodaDatas(pid:Int) =Action{
    implicit val residentWrites = Json.writes[NodeData]
    implicit val resident = Json.writes[NodeDetail]
    implicit val clusterListWrites = Json.writes[NodeDataList]
    val data: JsValue = Json.toJson(NodeData.findNodeDetail(pid))
    Ok(data)
  }


  def nodeList =Action{
    implicit val residentWrites = Json.writes[NodeData]
    implicit val clusterListWrites = Json.writes[NodeList]
    val data: JsValue = Json.toJson(NodeList(NodeData.findNodeDatas))
    Ok(data)
  }



  def updateNode =Action{
    //import play.api.libs.json._
    //val jsValue: JsValue = Json.parse(role)
   //val roles: String = jsValue.as[List[String]].mkString("\n")

    implicit request =>
      val (id, ip, host, role, name) = addnode.bindFromRequest.get
      val pid: Int = MetaData.findIdByName(name)
      NodeData.addOrUpdate(NodeData(id,ip,host,role,name,pid))

    Ok("操作成功")
  }


  def deleteNode(id:Int) =Action{
    NodeData.deleteNodeData(id)
    Ok("操作成功")
  }

  def getNames()=Action{
    import play.api.libs.json._
    val names: Seq[String] = MetaData.findNames
    Ok(Json.toJson(names))
  }


  def getProducts =Action{
    implicit val residentWrites = Json.writes[ProductData]
    implicit val clusterListWrites = Json.writes[ProductDataList]
    val data: JsValue = Json.toJson(ProductDataList(ProductData.findProductDatas))
    Ok(data)
  }

  def updataProduct(id:Int,unit:String,desc:String,contact:String,cluster:String)=Action{
    ProductData.addOrUpdate(ProductData(id,unit,desc,contact,cluster))
    Ok("操作成功")
  }

  def deleteProduct(id:Int)=Action {
    ProductData.deleteProductData(id)
    Ok("操作成功")
  }

  val addnode = Form(
    tuple(
      "id" -> number,
      "ip" -> text,
      "host" -> text,
      "role" -> text,
      "name" -> text
    )
  )






}
