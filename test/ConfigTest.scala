import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by king on 16/9/2.
  */
object ConfigTest {

  def main(args: Array[String]) {
    val config: Config = ConfigFactory.load("/Users/king/IdeaProject/ficusspark/conf/application.conf")
    println(config.getString("play"))

  }

}
