
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object sparkjar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ExecuteModel],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[ExecuteModel]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/scripts/*2.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*2.13*/("""
    <script type="text/javascript">alert("上传成功！！");</script>
""")))};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*4.2*/("""


    """),_display_(Seq[Any](/*7.6*/main("Neptune Spark-Jar", scripts)/*7.40*/ {_display_(Seq[Any](format.raw/*7.42*/("""

        <div class="graphs">

            <div class="xs">
                <h3>执行参数</h3>
                <div class="tab-content">
                    <div class="tab-pane active" id="horizontal-form">
                    """),_display_(Seq[Any](/*15.22*/helper/*15.28*/.form(action = routes.SparkJar.executejar)/*15.70*/ {_display_(Seq[Any](format.raw/*15.72*/("""
                        <div class="form-horizontal" >

                            <div class="form-group mb-n">
                                <label for="largeinput" class="col-sm-2 control-label label-input-lg">--class</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1 input-lg" name="executeClass" id="executeClass" placeholder="Large Input">
                                </div>
                            </div>
                            <div class="form-group mb-n">
                                <label for="largeinput" class="col-sm-2 control-label label-input-lg">--num-executors</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1 input-lg" name="numExecutors" id="numExecutors" placeholder="Large Input">
                                </div>
                            </div>
                            <div class="form-group mb-n">
                                <label for="largeinput" class="col-sm-2 control-label label-input-lg">--driver-memory</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1 input-lg" name="driverMemory" id="driverMemory" placeholder="Large Input">
                                </div>
                            </div>
                            <div class="form-group mb-n">
                                <label for="largeinput" class="col-sm-2 control-label label-input-lg">
                                    --executor-memory</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1 input-lg" name="executorMemory" id="executorMemory" placeholder="Large Input">
                                </div>
                            </div>
                            <div class="form-group mb-n">
                                <label for="largeinput" class="col-sm-2 control-label label-input-lg">--executor-cores</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1 input-lg" name="executorCores" id="executorCores" placeholder="Large Input">
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
                                    <input type="text" class="form-control1 input-lg" name="args1" id="args1" placeholder="Large Input">
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
                    """)))})),format.raw/*71.22*/("""
                    </div>
                </div>


            </div>

            """),_display_(Seq[Any](/*78.14*/copyright())),format.raw/*78.25*/("""
        </div>
        </div>

    """)))})),format.raw/*82.6*/("""
"""))}
    }
    
    def render(form:Form[ExecuteModel]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[ExecuteModel]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 05 12:32:11 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/sparkjar.scala.html
                    HASH: 1966bbcfad00d9de38777bd71cbfd48e013fbf55
                    MATRIX: 571->1|674->29|688->36|772->40|874->27|901->103|943->111|985->145|1024->147|1285->372|1300->378|1351->420|1391->422|5267->4266|5389->4352|5422->4363|5490->4400
                    LINES: 19->1|21->2|21->2|23->2|26->1|27->4|30->7|30->7|30->7|38->15|38->15|38->15|38->15|94->71|101->78|101->78|105->82
                    -- GENERATED --
                */
            