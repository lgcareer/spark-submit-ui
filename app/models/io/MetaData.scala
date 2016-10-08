package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import play.api.Play.current

/**
  * Created by liangkai1 on 16/9/6.
  */
case class MetaData(id:Int,name:String, unit:String,version:String,url:String)
case class MetaDataList(list:Seq[MetaData])
object MetaData {

  val names = {
    get[String]("metadata.name") map {
      case name => name
    }
  }

  val metadata = {
    get[Int]("metadata.id") ~
      get[String]("metadata.name") ~
      get[String]("metadata.unit") ~
      get[String]("metadata.version")~
      get[String]("metadata.url") map {
      case id ~ name ~ unit ~ version ~ url => models.MetaData(id,name,unit, version,url)
    }
  }

  def findMetaDatas:Seq[MetaData]={
     DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("select * from metadata").as(metadata *)
      }
    }
  }



  def addOrUpdate(metaData: MetaData) ={
   if(metaData.id != 0) updataMetaData(metaData) else addMetaData(metaData)
  }


  def addMetaData(metaData: MetaData)={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          INSERT INTO `playdb`.`metadata` (`name`, `unit`, `version`,`url`) VALUES ({name}, {unit}, {version},{url})
        """).on(
        'name -> metaData.name,
        'unit -> metaData.unit,
        'version -> metaData.version,
        'url -> metaData.url
      ).executeUpdate()
    }
  }

  def updataMetaData(metaData: MetaData)= {
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          update  metadata set name=
            {name}, unit={unit}, `version`={version}, url={url} where id={id}
        """).on(
        'name -> metaData.name,
        'unit -> metaData.unit,
        'version -> metaData.version,
        'url -> metaData.url,
        'id -> metaData.id
      ).executeUpdate()
    }
  }

  def deleteMetaData(id:Int)={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         delete  from metadata where
         id = {id}
        """).on(
        'id -> id
      ).executeUpdate()
    }
  }

  def findIdByName(name:String):Int={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         select id  from metadata where name = {name}
        """).on(
        'name -> name
      ).as(SqlParser.scalar[Int].single)
    }

  }

  def findNames : Seq[String]={
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("select * from metadata").as(names *)
      }
    }
  }



}
