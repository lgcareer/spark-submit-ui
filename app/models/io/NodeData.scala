package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import play.api.Play.current

/**
  * Created by liangkai1 on 16/9/8.
  */
case class NodeData(id:Int,ip:String,host:String,role:String,name:String,pid:Int)
case class NodeDataList(list:Seq[NodeData])
object NodeData {

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
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          INSERT INTO `playdb`.`nodedata` (`ip`, `host`, `role`,`name`,`pid`) VALUES ({ip}, {host}, {role},{name},{pid})
        """).on(
        'ip -> nodeData.ip,
        'host -> nodeData.host,
        'role -> nodeData.role,
        'name -> nodeData.name,
        'pid-> nodeData.pid
      ).executeUpdate()
    }
    nodeData
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
    nodeData
  }

  def deleteNodeData(id:String)={
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


}
