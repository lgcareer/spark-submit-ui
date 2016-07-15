
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
object nothing extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(args:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.15*/("""

"""),_display_(Seq[Any](/*3.2*/args)),format.raw/*3.6*/("""
"""))}
    }
    
    def render(args:String): play.api.templates.HtmlFormat.Appendable = apply(args)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (args) => apply(args)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 15:42:50 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/nothing.scala.html
                    HASH: 55a8bdfb0d1fcc19b8c9c56534cfd9a573dfc3bc
                    MATRIX: 558->1|665->14|702->17|726->21
                    LINES: 19->1|22->1|24->3|24->3
                    -- GENERATED --
                */
            