package controllers

import com.google.inject.Inject
import models.utils.Config
import play.api.mvc.{Action, Controller}

import scala.io.Source

/**
  * Created by king on 2017/3/7.
  */
class SparkList @Inject()(conf:Config) extends Controller {

  def getSparkInfo=Action{
    Ok(Source.fromURL("http://"+conf.getString("spark.master.host")+"/json").mkString)
  }


}
