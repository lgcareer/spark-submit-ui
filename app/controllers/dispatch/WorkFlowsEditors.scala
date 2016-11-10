package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by king on 2016/11/9.
  */
object WorkFlowsEditors extends Controller{

  def editorsList=Action{
    Ok(views.html.oozie_editors_list())
  }

  def editors=Action{
    Ok(views.html.oozie_edit())
  }







}
