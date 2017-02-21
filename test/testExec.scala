import java.net.{URL, URLClassLoader}
import java.nio.file.{Files, Paths}
import java.text.{ParsePosition, SimpleDateFormat}
import java.util.Date

import scala.io.{BufferedSource, Source}

/**
  * Created by liangkai1 on 16/7/13.
  */
object testExec {

  def main(args: Array[String]) {
//    val process: Process = Runtime.getRuntime.exec("/Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/bin/java -classpath /Users/liangkai1/IdeaProjects/ficusspark/target/scala-2.10/classes models.Execute")
//    process.waitFor

//    val allBytes: Array[Byte] = Files.readAllBytes(Paths.get("/Users/liangkai1/Desktop/spark_2_1.0-1.0.jar"))
//    println("run")
//    println(allBytes


    val d=982098281654l
    val avg = 1024*1024*1024

    println(d/avg)


    def getNowDate() {
      val before = 4*60*60*1000
      val currentTime = new Date(System.currentTimeMillis()-before);
      currentTime.setMinutes(0)
      val formatter = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss");
      val dateString = formatter.format(currentTime);

      println(dateString)
      return dateString;
    }

      getNowDate()








  }

}
