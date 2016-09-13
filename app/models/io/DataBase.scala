package models.io

import controllers.SparkSql._
import models.utils.SparkSqlPool

import scala.collection.mutable.ArrayBuffer


/**
 * Created by manbu on 16/9/12.
 */
object DataBase {
  def SparkDataBase (): Map[String,Any] = {
    val connection = SparkSqlPool.getJdbcConn()
      val statement = connection.createStatement()
      val foundBase = statement.execute("show databases")
      val resultSet = statement.getResultSet()
      val rsmd = resultSet.getMetaData()
      val dataBaseArray = new ArrayBuffer[Any]()
      while (resultSet.next) {
        for(i <- 1 to rsmd.getColumnCount ){
          dataBaseArray += resultSet.getObject(i)
        }
      }

     var base_table = Map[String,Any]()
      for (i <- 0 until dataBaseArray.length) {
        val database = dataBaseArray(i)
        println("i ==>" + i)
        println("database ==>" + database)
        val foundTable = statement.execute("show tables in " + database)
        if(!foundTable){
          InternalServerError("error")
        }
        val resultSet = statement.getResultSet()
        val rsmd = resultSet.getMetaData()
        val tableArray = new ArrayBuffer[Any]()
        while (resultSet.next) {
          for(i <- 1 to rsmd.getColumnCount ){
            tableArray += resultSet.getObject(i)
          }
        }
        base_table += (database.toString -> tableArray)
        println("base_table ==>" + base_table)
      }
      SparkSqlPool.releaseConn(connection)
    base_table
  }

  def Sparktables (): ArrayBuffer[Any] = {
    val connection = SparkSqlPool.getJdbcConn()
      val statement = connection.createStatement()
      val found = statement.execute("show tables")
      val resultSet = statement.getResultSet()
      val rsmd = resultSet.getMetaData()
      val tableArray = new ArrayBuffer[Any]()
      while (resultSet.next) {
        for(i <- 1 to rsmd.getColumnCount ){
          tableArray += resultSet.getObject(i)
        }
      }
      SparkSqlPool.releaseConn(connection)
      tableArray
    }

}

