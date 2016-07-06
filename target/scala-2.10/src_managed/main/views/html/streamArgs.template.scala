
package views.html

import play.templates._
import play.templates.TemplateMagic._
import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import controllers.spark.ExecuteModel
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object streamArgs extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ExecuteModel],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[ExecuteModel]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/scripts/*2.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*2.13*/("""
    <script type="text/javascript">alert("上传成功！！");</script>
""")))};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*4.2*/("""
"""),_display_(Seq[Any](/*5.2*/main("Neptune Spark-Jar",scripts)/*5.35*/{_display_(Seq[Any](format.raw/*5.36*/("""

<div class="graphs">
                    <div class="xs">
                        <h3>基于执行参数设置</h3>
                        <div class="tab-content">
                            <div class="tab-pane active" id="horizontal-form">
                            """),_display_(Seq[Any](/*12.30*/helper/*12.36*/.form(action= controllers.spark.routes.SparkJar.executejar)/*12.95*/ {_display_(Seq[Any](format.raw/*12.97*/("""
                                <div class="form-horizontal" >
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg" id="DataSource">--DataSource</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="executeClass"  id="executeClass" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg" id="DataSink">--DataSink</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="executeClass"  id="executeClass" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg" id="Kafka topic<">--Kafka Topic</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="executeClass"  id="executeClass" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg" id="ZkAdress<">--ZkAdress</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="executeClass"  id="executeClass" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg">--cass</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="executeClass"  id="executeClass" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg">--num-executors</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="numExecutors"  id="numExecutors" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg">--driver-memory</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="driverMemory"  id="driverMemory" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg">--executor-memory</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="executorMemory"  id="executorMemory" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg">--executor-cores</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="executorCores"  id="executorCores" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg">jar location</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="jarLocation" id="largeinput" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="form-group mb-n">
                                        <label for="largeinput" class="col-sm-2 control-label label-input-lg">args</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1 input-lg" name="args1"  id="args1" placeholder="Large Input">
                                        </div>
                                    </div>
                                    <div class="panel-footer">
                                        <div class="row">
                                            <div class="col-sm-8 col-sm-offset-2">
                                                <button class="btn-success btn">提交</button>
                                                <button class="btn-inverse btn" type="reset" >重置</button>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            """)))})),format.raw/*90.30*/("""
                            </div>
                        </div>






                    </div>
                   """),_display_(Seq[Any](/*100.21*/copyright())),format.raw/*100.32*/("""
                </div>
            </div>




  """)))})),format.raw/*107.4*/("""
"""))}
    }
    
    def render(form:Form[ExecuteModel]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[ExecuteModel]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 06 15:28:15 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/streamArgs.scala.html
                    HASH: a63fc6486c3f9de720e6a78ede6083128c494b26
                    MATRIX: 573->1|676->29|690->36|774->40|876->27|903->103|939->105|980->138|1018->139|1314->399|1329->405|1397->464|1437->466|7804->6801|7961->6921|7995->6932|8077->6982
                    LINES: 19->1|21->2|21->2|23->2|26->1|27->4|28->5|28->5|28->5|35->12|35->12|35->12|35->12|113->90|123->100|123->100|130->107
                    -- GENERATED --
                */
            