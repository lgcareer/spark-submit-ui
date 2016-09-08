package controllers

import models.io.ServicePlan
import play.api.mvc.Controller

/**
 * Created by manbu on 16/7/20.
 * 节点功能划分
 * 节点分布情况
 * 服务关系
 *
 */
object Serviceplan extends Controller with Secured{

  def servicedao = IsAuthenticated { username => implicit request =>
    val service =ServicePlan.service()
    Ok(views.html.widgets(service))
  }
  def functionplan = IsAuthenticated { username => implicit request =>
    Ok(views.html.widgetsfun())
  }

  def graph = IsAuthenticated {username => implicit request =>
    /**
     * spark graph 处理
     * 根据元数据
     */
    val ip = "10.75.16.239"
    Ok(views.html.graph(ip))
  }

}
