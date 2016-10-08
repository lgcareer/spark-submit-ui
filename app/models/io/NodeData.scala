package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import play.api.Play.current


/**
  * Created by liangkai1 on 16/9/8.
  */
case class NodeData(id:Int,ip:String,host:String,role:String,name:String,pid:Int)
case class Node(id:Int,ip:String,host:String,role:String,name:String,pid:Int)
case class NodeDataList(details:Seq[NodeDetail],list:Seq[NodeData])
case class NodeList(list:Seq[NodeData])
case class NodeDetail(role:String,count:Int)
object NodeData {

  val ipdata ={
    get[String]("nodedata.ip") map{
      case ip => ip
    }
  }


  val nodedata = {
    get[Int]("nodedata.id") ~
      get[String]("nodedata.ip") ~
      get[String]("nodedata.host") ~
      get[String]("nodedata.role")~
      get[String]("nodedata.name")~
      get[Int]("nodedata.pid") map {
      case id ~ ip ~ host ~ role ~ name ~ pid=> models.NodeData(id,ip,host,role,name,pid)
    }
  }


  def findNodeDatas:Seq[NodeData]={
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("select * from nodedata ").as(nodedata *)
      }
    }
  }

  def findNodeIp : Seq[String] ={
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("select ip from nodedata ").as(ipdata *)
      }
    }
  }



  def findNodeDetail(pid:Int):NodeDataList ={
    var snakes = Map.empty[String, Int]
    val nodes: Seq[NodeData] = findNodeDatasById(pid)

    nodes.map(x=>{
        val split: Array[String] = x.role.split("\\s+")
         split.map{ r =>
           if (snakes.isDefinedAt(r)) {
             val value: Int = snakes(r) + 1
             snakes += (r -> value)
           } else {
             snakes += (r -> 1)
           }
         }

    })
    val datas=snakes.map{
      data => NodeDetail(data._1,data._2)
    }
    NodeDataList(datas.toIndexedSeq,nodes)
  }


  def findNodeDatasById(pid:Int):Seq[NodeData]={
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("select * from nodedata where pid ={pid}").on('pid -> pid).as(nodedata *)
      }
    }
  }


  def addOrUpdate(nodeData: NodeData) ={
    if(nodeData.id != 0) updataNodeaData(nodeData) else addNodeData(nodeData)
  }


  def addNodeData(nodeData: NodeData)={
    var nodes: Seq[Node] = Seq.empty[Node]
    val ips: Seq[String] = nodeData.ip.split("\n")
    val hosts: Array[String] = nodeData.host.split("\n")

    for(i <- 0 until ips.length){
      val id =nodeData.id
      val ip =ips(i)
      val host = hosts(i)
      val role = nodeData.role
      val cluster =nodeData.name
      val pid =nodeData.pid
      nodes=nodes :+ Node(id,ip,host,role,cluster,pid)
    }

    diffIP(ips,nodes)

  }

  def diffIP(newIp:Seq[String],nodes: Seq[Node])={
    val ips: Seq[String] = findNodeIp
    val uIps: Seq[String] = ips.intersect(newIp)

    if(uIps.nonEmpty){
      var uNodes: Seq[Node] = Seq.empty[Node]
      for(node<-nodes;ip<-uIps){
        if (node.ip.equals(ip)) {
          uNodes = uNodes :+ node
        }
      }
      batchupdataNodeaData(uNodes)
      var aNodes: Seq[Node] = Seq.empty[Node]
      val diff: Seq[String] = newIp.diff(ips)
      for(nodee<-nodes;aip<-diff){
        if (nodee.ip.equals(aip)) {
          aNodes = aNodes :+ nodee
        }
      }
      batchAddNodeData(aNodes)
    }else{
      batchAddNodeData(nodes)
    }
  }



  def batchAddNodeData(nodes:Seq[Node])={
    play.api.db.DB.withConnection { implicit connection =>
      nodes.map{
        node=>
          SQL(
            """
          INSERT INTO `playdb`.`nodedata` (`ip`, `host`, `role`,`name`,`pid`) VALUES ({ip}, {host}, {role},{name},{pid})
            """).on(
            'ip -> node.ip,
            'host -> node.host,
            'role -> node.role,
            'name -> node.name,
            'pid-> node.pid
          ).executeUpdate()
      }
    }
  }

  def batchupdataNodeaData(nodes:Seq[Node])= {
    play.api.db.DB.withConnection { implicit connection =>
      nodes.map{
        nodeData=>
          SQL(
            """
          update  nodedata set  host={host}, `role`={role}, name={name},pid={pid} where ip={ip}
            """).on(
            'ip -> nodeData.ip,
            'host -> nodeData.host,
            'role -> nodeData.role,
            'name -> nodeData.name,
            'pid -> nodeData.pid
          ).executeUpdate()
      }

    }
  }







  def updataNodeaData(nodeData: NodeData)= {
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          update  nodedata set ip= {ip}, host={host}, `role`={role}, name={name},pid={pid} where id={id}
        """).on(
        'ip -> nodeData.ip,
        'host -> nodeData.host,
        'role -> nodeData.role,
        'name -> nodeData.name,
        'pid -> nodeData.pid,
         'id -> nodeData.id
      ).executeUpdate()
    }
  }

  def deleteNodeData(id:Int)={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         delete  from nodedata where
         id = {id}
        """).on(
        'id -> id
      ).executeUpdate()
    }
  }


  def deleteNodeBatch(pid:Int) ={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         delete  from nodedata where
         pid = {pid}
        """).on(
        'pid -> pid
      ).executeUpdate()
    }
  }


}
