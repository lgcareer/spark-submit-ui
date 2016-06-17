package models.utils

import scala.collection.mutable.ArrayBuffer
import scala.sys.process._

/**
  * Created by leslie on 16/4/21.
  */
object Execute {
  def main(args: Array[String]) {
    var stringbuffer = ""
    for(i <- 0 until args.length)
      stringbuffer += args(i) +" "
    println("don....")
    stringbuffer = stringbuffer.substring(0,stringbuffer.length-1)
    val executeArgument = stringbuffer!

  }
}
