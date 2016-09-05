import com.typesafe.config.{Config, ConfigException, ConfigFactory}
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

/**
  * Created by king on 16/9/2.
  */
@RunWith(classOf[JUnitRunner])
class ComplexApp extends Specification{


  def demoConfigInSimpleLib(config: Config) {
    println(config.getString("spark.home"))

    println(config.getString("spark.master.url"))


  }

 //System.setProperty("simple-lib.whatever", "This value comes from a system property")

  ///////////

  // "config1" is just an example of using a file other than application.conf
  val config1 = ConfigFactory.load("neptun")

  // use the config ourselves
  //println("config1, complex-app.something=" + config1.getString("complex-app.something"))

  // use the config for a library
  demoConfigInSimpleLib(config1)







}
