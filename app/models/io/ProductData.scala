package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import play.api.Play.current

/**
  * Created by liangkai1 on 16/9/28.
  */
case class ProductData(id:Int,unit:String,desc:String,contact:String,cluster:String)
case class ProductDataList(list:Seq[ProductData])
object ProductData {


  val product = {
      get[Int]("productdata.id") ~
      get[String]("productdata.unit") ~
      get[String]("productdata.desc") ~
      get[String]("productdata.contact")~
      get[String]("productdata.cluster") map {
      case id ~ unit ~ desc ~ contact ~ cluster => models.ProductData(id,unit,desc,contact,cluster)
    }
  }

  def findProductDatas:Seq[ProductData]={
    DB.withConnection { implicit connection =>
      play.api.db.DB.withConnection { implicit connection =>
        SQL("select * from productdata").as(product *)
      }
    }
  }


  def addOrUpdate(productData: ProductData) ={
    if(productData.id != 0) updataProductData(productData) else addProductData(productData) ;updateProducWithCluster(productData)
  }

  def updateProducWithCluster(productData: ProductData)={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          update  metadata set unit=
            {unit}  where name={cluster}
        """).on(
        'unit -> productData.unit,
        'cluster -> productData.cluster
      ).executeUpdate()
    }
  }


  def addProductData(productData: ProductData)={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          INSERT INTO `playdb`.`productdata` (`unit`, `desc`, `contact`,`cluster`) VALUES ({unit}, {desc}, {contact},{cluster})
        """).on(
        'unit -> productData.unit,
        'desc -> productData.desc,
        'contact -> productData.contact,
        'cluster -> productData.cluster
      ).executeUpdate()
    }
  }

  def updataProductData(productData: ProductData)= {
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
          update  productdata set unit=
            {unit}, `desc`={desc}, `contact`={contact}, cluster={cluster} where id={id}
        """).on(
        'unit -> productData.unit,
        'desc -> productData.desc,
        'contact -> productData.contact,
        'cluster -> productData.cluster,
        'id -> productData.id
      ).executeUpdate()
    }
  }

  def deleteProductData(id:Int)={
    play.api.db.DB.withConnection { implicit connection =>
      SQL(
        """
         delete  from productdata where
         id = {id}
        """).on(
        'id -> id
      ).executeUpdate()
    }
  }









}
