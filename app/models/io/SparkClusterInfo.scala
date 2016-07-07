package models

import anorm._
import play.api.Play.current
import play.api.db.DB


/**
 *  Spark_Cluster_Info
    alive_workers  节点数
    cores 总core数
    memory  总内存数
    applications application数
    drivers 驱动数
    status 主节点状态
 *
 */

object SparkTotalinfo {
  def findAll(): String={
     DB.withConnection("test") { implicit connection =>
      val findall = SQL("select * from spark_total_info order by id desc limit 1")
      val result = findall().map(row =>
        row[String]("alive_workers") -> row[String]("cores")
         -> row[String]("memory") -> row[String]("applications")
         -> row[String]("drivers") -> row[String]("status")
      ).toList
       val alive_workers = findall.apply().head[String]("alive_workers")
       val cores = findall.apply().head[String]("cores")
       val memory = findall.apply().head[String]("memory")
       val applications = findall.apply().head[String]("applications")
       val drivers = findall.apply().head[String]("drivers")
       val status = findall.apply().head[String]("status")
       val spark_info ="{alive_workers:"+alive_workers+","+"cores:"+cores+","+"memory:"+memory+","+"applications:"+applications+","+"drivers:"+drivers+","+"status:"+status+"}"
       val spark_info_json = "{\"alive_workers\":"+"\""+alive_workers+"\""+","+"\"cores\":"+"\""+cores+"\""+","+"\"memory\":"+"\""+memory+"\""+","+"\"applications\":"+"\""+applications+"\""+","+"\"drivers\":"+"\""+drivers+"\""+","+"\"status\":"+"\""+status+"\""+"}"
       spark_info_json
    }
  }
}
