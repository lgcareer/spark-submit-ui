package models

import java.io.PrintStream

import models.utils.Config
import org.apache.activemq.util.ByteArrayOutputStream
import org.apache.oozie.client.OozieClient
import play.api.Logger
import play.api.libs.json.Json

/**
  * Created by king on 2016/11/2.
  * oozie process
  */
class ScheduleProvider(config: Config) {
  private [this] var client :OozieClient = _


  def  jobList(jobtype:String): String ={
    val url = "http://"+config.getString("hadoop.oozie.host")+"/oozie/v2/jobs?jobtype="+jobtype
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

  def resumeJobs(ids:Seq[String]): Unit ={
    ids.map{
      id =>
      client.resume(id)
    }
  }

  def suspendJobs(ids:Seq[String])={
    ids.map{
      id=> client.suspend(id)
    }
  }

  def getJobInfosById(id:String): JobInfo ={
      /**
        * 错误日志
        */
      val error: ByteArrayOutputStream = new ByteArrayOutputStream()
      client.getJobErrorLog(id,new PrintStream(error))
      /**
        * job日志
        */
      val jobLog: String = client.getJobLog(id)
      /**
        * 描述信息
        */
     val definition: String=models.utils.XmlFormatter.format(client.getJobDefinition(id))
      /**
        * DAG img
        */
      val jobDAG = "http://"+config.getString("hadoop.oozie.host")+"/oozie/v2/job/"+id+"?show=graph"

      val audit: ByteArrayOutputStream = new ByteArrayOutputStream()
      /**
        * audit log
        */
      client.getJobAuditLog(id,new PrintStream(audit))

       val jobConf: String = models.utils.XmlFormatter.format(client.getJobInfo(id).getConf)
      JobInfo(id,jobLog,new String(audit.toByteArray),new String(error.toByteArray),jobDAG,definition,jobConf)
  }







}
