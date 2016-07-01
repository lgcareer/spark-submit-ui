package modules

/**
 * Created by manbu on 16/6/1.
 */

import java.sql.{Connection, DriverManager}

import play.api.db._

trait DashboardMetrics {
    def getRunJobMetrics(): Unit ={
        val driver ="com.mysql.jdbc.Driver"
        val url ="jdbc:mysql://10.73.33.41:3306/test"
        val username = "admin"
        val password = "admin123!@#"
      var connection:Connection = null
      try {
        Class.forName(driver)
        connection = DriverManager.getConnection(url, username, password)
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("SELECT host, user FROM user")
        while ( resultSet.next() ) {
          val host = resultSet.getString("host")
          val user = resultSet.getString("user")
          println("host, user = " + host + ", " + user)
        }
      }
      catch {
        case e :Exception
         => e.printStackTrace
      }
      connection.close()
    }
}
