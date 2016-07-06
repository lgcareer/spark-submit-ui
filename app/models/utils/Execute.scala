package models.utils

import org.apache.spark.deploy.SparkSubmit
import play.Logger

import scala.sys.process._

/**
  * Created by leslie on 16/4/21.
  */
object Execute {
  def main(args: Array[String]) {
    var stringbuffer = ""
    for(i <- 0 until args.length)
      stringbuffer += args(i) +" "

    stringbuffer = stringbuffer.substring(0,stringbuffer.length-1)
    Logger.info(stringbuffer)
    val executeArgument = stringbuffer!


   // SparkSubmit.main(args)
  }
}
