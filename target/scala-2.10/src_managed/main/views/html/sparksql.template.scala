
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
object sparksql extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[SqlModel],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[SqlModel]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.24*/("""
"""),_display_(Seq[Any](/*2.2*/main("Neptune Spark-sql")/*2.27*/{_display_(Seq[Any](format.raw/*2.28*/("""
"""),_display_(Seq[Any](/*3.2*/confirm("确定执行？"))),format.raw/*3.18*/("""
<div class="graphs">
 <div class="xs">
   <h3>Neptune Spark Sql</h3>
   """),_display_(Seq[Any](/*7.5*/helper/*7.11*/.form(action=routes.SparkSql.executesql)/*7.51*/{_display_(Seq[Any](format.raw/*7.52*/("""
   <div class="tab-content">
    <div class="tab-pane active" id="horizontal-form">
        <div class="form-group">
        <label for="txtarea1" class="col-sm-2 control-label">请输入要执行的SQL</label>
          <div class="col-sm-8"><textarea name="sql" id="txtarea1" cols="50" rows="4" class="form-control1"></textarea></div>
        </div>
    </div>
  </div>

  <div class="bs-example" data-example-id="form-validation-states">
  </div>
  
  <div class="bs-example" data-example-id="form-validation-states-with-icons">
      <div class="panel-footer">
        <div class="row">
          <div class="col-sm-8 col-sm-offset-2">
            <button class="btn-success btn" type="submit" onclick="getConfirmation();" >提交</button>
            <button class="btn-inverse btn" type="reset" >重置</button>
          </div>
        </div>
      </div>
  </div>
</div>
"""),_display_(Seq[Any](/*31.2*/copyright())),format.raw/*31.13*/("""
</div>
""")))})),format.raw/*33.2*/("""
""")))})),format.raw/*34.2*/("""

"""))}
    }
    
    def render(form:Form[SqlModel]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[SqlModel]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 15:42:50 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/sparksql.scala.html
                    HASH: 8badc0386630e24fd35d55645bbdac163d3ed9c4
                    MATRIX: 567->1|683->23|719->25|752->50|790->51|826->53|863->69|971->143|985->149|1033->189|1071->190|1965->1049|1998->1060|2038->1069|2071->1071
                    LINES: 19->1|22->1|23->2|23->2|23->2|24->3|24->3|28->7|28->7|28->7|28->7|52->31|52->31|54->33|55->34
                    -- GENERATED --
                */
            