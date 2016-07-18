package models.utils

/**
 * Created by manbu on 16/7/14.
 */
object TestConnectPool {
  def main(args: Array[String]): Unit = {
    for (x <- 1 to 20 ){
      val con=SparkSqlPool.getJdbcConn()
      println("当前连接："+x+"  "+con)
      if(x==6){
        println("释放的是："+x+" "+con)
        SparkSqlPool.releaseConn(con)
      }
    }
  }
}
