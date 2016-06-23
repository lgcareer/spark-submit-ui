
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
object blank extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(arg:Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.21*/("""

"""),_display_(Seq[Any](/*3.2*/for( x <- arg) yield /*3.16*/{_display_(Seq[Any](format.raw/*3.17*/("""
    <b>"""),_display_(Seq[Any](/*4.9*/x)),format.raw/*4.10*/("""</b>
""")))})),format.raw/*5.2*/("""
"""))}
    }
    
    def render(arg:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(arg)
    
    def f:((Array[String]) => play.api.templates.HtmlFormat.Appendable) = (arg) => apply(arg)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 21 12:18:17 CST 2016
                    SOURCE: /Users/manbu/Desktop/ficusspark/app/views/blank.scala.html
                    HASH: 6d07e8203e5b8aa7e60dc26273f0e5bf05777732
                    MATRIX: 563->1|676->20|713->23|742->37|780->38|823->47|845->48|881->54
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|26->5
                    -- GENERATED --
                */
            