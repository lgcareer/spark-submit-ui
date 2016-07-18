package models.io

import java.sql.ResultSet

import models.utils.SparkSqlPool

import scala.collection.mutable.{ArrayBuffer, Map}

/**
 * Created by manbu on 16/7/11.
 */
object daosql {
  def daosqlImpl(sql: String) = {
    val conn=SparkSqlPool.getJdbcConn()
    var columnSize = 0
    var arr = new ArrayBuffer[Map[String, String]]()
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val rs = statement.executeQuery(sql)
    columnSize = rs.getMetaData.getColumnCount
    while (rs.next) {
      var tableMap = Map[String, String]()
      for (i <- 1 to columnSize) {
        val columnName = rs.getMetaData.getColumnLabel(i)
        val columnValue = rs.getString(columnName)
        tableMap += (columnName -> columnValue)
      }
      arr += tableMap
      println(arr)
    }
    SparkSqlPool.releaseConn(conn)
    arr
  }

}


