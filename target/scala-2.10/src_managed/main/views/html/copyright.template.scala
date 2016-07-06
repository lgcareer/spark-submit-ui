
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
object copyright extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="copy">
     <p>Copyright &copy; 2016.Sina DSP All rights reserved.More Infomation <a href="http://www.weibo.com/" target="_blank" title="新浪微博">新浪微博</a></p>
</div>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 06 12:18:05 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/copyright.scala.html
                    HASH: 420e5de58ec3ac768c770b3f010f2e3d80fdc03b
                    MATRIX: 641->0
                    LINES: 22->1
                    -- GENERATED --
                */
            