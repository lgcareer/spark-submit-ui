
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
object stream extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

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
"""),_display_(Seq[Any](/*12.2*/helper/*12.8*/.form(action = routes.SparkStream.stremupload, 'enctype -> "multipart/form-data")/*12.89*/ {_display_(Seq[Any](format.raw/*12.91*/("""
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
                    DATE: Thu Jul 07 14:23:36 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/stream.scala.html
                    HASH: 118311e70dfe996efe0d2aead5836c961c533dbb
                    MATRIX: 647->1|691->37|730->39|766->41|809->63|1167->386|1181->392|1271->473|1311->475|1768->901|1820->918|1853->929|1893->938
                    LINES: 22->1|22->1|22->1|23->2|23->2|33->12|33->12|33->12|33->12|47->26|51->30|51->30|53->32
                    -- GENERATED --
                */
            