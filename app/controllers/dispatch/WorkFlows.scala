package controllers


import models.Execute
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
 * Created by liangkai on 16/7/25.
 */
object WorkFlows extends Controller with Secured{

  def workflows = IsAuthenticated { username => implicit request =>

    /**
     * 接入oozie 调度，调用API
     */
    Ok(views.html.dispatch())
  }


  def getJobList(jobtype:String)=Action{
    Ok(Execute.jobList(jobtype))
  }

  val jobs = Form(
    tuple(
      "ids" -> text,
      "action" -> text
    )
  )

  def  killJobs = Action{
    implicit request =>
        val (ids,action)= jobs.bindFromRequest().get
      val _ids: Seq[String] = Json.parse(ids).as[Seq[String]]
      Execute.killJobs(_ids)
      Ok("kill success")
  }

}
