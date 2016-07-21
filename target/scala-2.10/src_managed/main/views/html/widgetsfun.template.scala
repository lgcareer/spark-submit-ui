
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
object widgetsfun extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Neptun Dashboard")/*1.26*/{_display_(Seq[Any](format.raw/*1.27*/("""

<style type='text/css'>
    .col-md-6 """),format.raw/*4.15*/("""{"""),format.raw/*4.16*/("""
    width: 51%;
    """),format.raw/*6.5*/("""}"""),format.raw/*6.6*/("""
</style>
<div class="bs-example4" data-example-id="contextual-table">

    </div>

<script charset="utf-8">
  </script>
""")))})),format.raw/*14.2*/("""
"""),_display_(Seq[Any](/*15.2*/copyright())))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 21 18:10:07 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/widgetsfun.scala.html
                    HASH: 1c7205cb979cba85ede55e52498949153d58095c
                    MATRIX: 651->1|683->25|721->26|791->69|819->70|868->93|895->94|1056->224|1094->227
                    LINES: 22->1|22->1|22->1|25->4|25->4|27->6|27->6|35->14|36->15
                    -- GENERATED --
                */
            