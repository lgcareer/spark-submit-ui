
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
object strem extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Neputune Spark-jar-uploadJar")/*1.38*/ {_display_(Seq[Any](format.raw/*1.40*/("""
"""),_display_(Seq[Any](/*2.2*/confirm("确定上传jar文件吗？"))),format.raw/*2.24*/("""
<div class="graphs">
<div class="xs">
 <h3>Neptune Spark Stream</h3>

 <div class="bs-example" data-example-id="form-validation-states-with-icons">

    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
    <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
  </div>
"""),_display_(Seq[Any](/*12.2*/helper/*12.8*/.form(action = routes.SparkStream.upload, 'enctype -> "multipart/form-data")/*12.84*/ {_display_(Seq[Any](format.raw/*12.86*/("""
  <div class="form-group">
    <label for="exampleInputFile">文件上传</label>
    <input type="file" name="file">
    <p class="help-block">请上传需要执行的jar文件！</p>
  </div>
  <div class="panel-footer">
    <div class="row">
      <div class="col-sm-8 col-sm-offset-2">
        <button class="btn-success btn" type="submit">提交</button>
        <button class="btn-inverse btn" type="reset">重置</button>
      </div>
    </div>
  </div>
""")))})),format.raw/*26.2*/("""

</div>
</div>
"""),_display_(Seq[Any](/*30.2*/copyright())),format.raw/*30.13*/("""
</div>
""")))})),format.raw/*32.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 24 12:35:10 CST 2016
                    SOURCE: /Users/manbu/Desktop/ficusspark/app/views/strem.scala.html
                    HASH: 8328e28d2db8e5421777f5cc358a3a17a0b89ca5
                    MATRIX: 646->1|690->37|729->39|765->41|808->63|1166->386|1180->392|1265->468|1305->470|1762->896|1814->913|1847->924|1887->933
                    LINES: 22->1|22->1|22->1|23->2|23->2|33->12|33->12|33->12|33->12|47->26|51->30|51->30|53->32
                    -- GENERATED --
                */
            