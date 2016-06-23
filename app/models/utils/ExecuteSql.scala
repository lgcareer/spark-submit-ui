package utils

import scala.sys.process._
import java.io._
/**
  * Created by leslie on 16/4/21.
  */
object ExecuteSql {
  def main(args: Array[String]) {

    val sql = args(0)

    val format = new java.text.SimpleDateFormat("yyyyMMddHHmmss")

    val current = format.format(new java.util.Date()).toString

    val writer = new PrintWriter(new File(current))
    writer.write(sql)
    writer.close()
    val executesqlfilr = "/usr/local/spark/bin/spark-sql --master spark://10.209.0.207:7077  -f "+current
    executesqlfilr! 
    val file = new File(current)
    file.delete
  }
}


