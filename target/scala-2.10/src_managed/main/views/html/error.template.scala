
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
object error extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(mess:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.15*/("""

"""),_display_(Seq[Any](/*3.2*/mess)),format.raw/*3.6*/("""
"""))}
    }
    
    def render(mess:String): play.api.templates.HtmlFormat.Appendable = apply(mess)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (mess) => apply(mess)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 06 11:28:08 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/error.scala.html
                    HASH: 501d0bdeb5399e3f5d9880a3e068ff97a875b736
                    MATRIX: 556->1|663->14|700->17|724->21
                    LINES: 19->1|22->1|24->3|24->3
                    -- GENERATED --
                */
            