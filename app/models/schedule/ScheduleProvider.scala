package models

import models.utils.Config
import org.apache.oozie.client.{OozieClient, WorkflowJob}
import play.api.Logger
import play.api.libs.json.Json

/**
  * Created by king on 2016/11/2.
  */
class ScheduleProvider(config: Config) {
  private [this] var client :OozieClient = _


  def  jobList(jobtype:String): String ={
    val url = "http://"+config.getString("hadoop.oozie.host")+"/oozie/v1/jobs?jobtype="+jobtype
    Logger.info(s"DEBUG ==>$url")
    val data = scala.io.Source.fromURL(url).mkString
    val json = Json.parse(data)

    jobtype match {
      case "wf"  => Json.stringify(json \ "workflows")
      case  "coord" =>Json.stringify(json \ "coordinatorjobs")
      case "bundle" =>Json.stringify(json \ "bundlejobs")
      case  _ => "None"
    }


  }


  def setClient(client:OozieClient): Unit ={
    this.client=client
  }

  def killJobs(ids:Seq[String]): Unit ={
    ids.map{
      id=> client.kill(id)
    }


  }









}
