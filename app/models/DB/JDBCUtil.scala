package DB

/**
 * Created by manbu on 16/6/3.
 */

import java.sql.{Connection, DriverManager, ResultSet}

import scala.collection.mutable.ArrayBuffer
object JDBCUtil {


  def query()={
    val conn_str = "jdbc:mysql://10.73.33.41:3306/test?user=admin&password=admin123!@#"

    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://10.73.33.41:3306/test"
    val username = "admin"
    val password = "admin123!@#"
    var connection: Connection = null
    var MetriJson = ""
    var arr = new ArrayBuffer[String]()
    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("select * from dashboard_metric order by time desc limit 100")
      while (resultSet.next()) {
        val id = resultSet.getString("id")
        val time = resultSet.getString("time")
        val gauges = resultSet.getString("gauges")

        val times = time.split("-").mkString.split(" ").mkString.split(":").mkString
        val gauge = gauges.substring(gauges.indexOf("{") + 1, gauges.length())
        MetriJson = "{\"time\":" + times + "," + gauge

        arr += MetriJson
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
    arr
  }


}

