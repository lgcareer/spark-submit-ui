package controllers


import models.Execute
import play.api.mvc.{Action, Controller}

/**
 * Created by liangkai on 16/7/25.
 */
object Oozie extends Controller with Secured{

  def oozie = IsAuthenticated { username => implicit request =>

    /**
     * 接入oozie 调度，调用API
     */
    Ok(views.html.dispatch())
  }


  def getJobList(jobtype:String)=Action{
    Ok(Execute.jobList(jobtype))
  }

  def oozielist =Action{
    Ok(views.html.oozie())
  }
}
