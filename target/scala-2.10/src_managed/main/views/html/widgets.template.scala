
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
object widgets extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

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
    <div id="sparkinfo"  class="col-md-4 span_4">

        <div>
            <table class="table" id = "servicelist">

            </table>
        </div>
            </div>
    </div>

<script charset="utf-8">
    $(document).ready(function()"""),format.raw/*20.33*/("""{"""),format.raw/*20.34*/("""
        $.ajax("""),format.raw/*21.16*/("""{"""),format.raw/*21.17*/("""
            type:"GET",
            url:"/serviceplan",
            dataType:"json",
            success:function(data)"""),format.raw/*25.35*/("""{"""),format.raw/*25.36*/("""
                var head= "<table border='10' width='439'><tr><th>IP</th><th>服务</th></tr>";
                var service=eval(data);
                console.log(service);
                for (var ip in service) """),format.raw/*29.41*/("""{"""),format.raw/*29.42*/("""
                    var ser = service[ip];
                    head += "<tr><td>"+ip+"</td><td>"+ser+"</td></tr>";
                   """),format.raw/*32.20*/("""}"""),format.raw/*32.21*/(""";
                head += " </table>";
                $('#servicelist').html(head);
            """),format.raw/*35.13*/("""}"""),format.raw/*35.14*/("""
        """),format.raw/*36.9*/("""}"""),format.raw/*36.10*/(""");
   """),format.raw/*37.4*/("""}"""),format.raw/*37.5*/(""");
  </script>
""")))})),format.raw/*39.2*/("""
"""),_display_(Seq[Any](/*40.2*/copyright())))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 21 17:32:08 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/widgets.scala.html
                    HASH: 6c165c2c343c01e754b10a654bcef3b5fab12453
                    MATRIX: 648->1|680->25|718->26|788->69|816->70|865->93|892->94|1248->422|1277->423|1322->440|1351->441|1503->565|1532->566|1775->781|1804->782|1970->920|1999->921|2127->1021|2156->1022|2193->1032|2222->1033|2256->1040|2284->1041|2333->1059|2371->1062
                    LINES: 22->1|22->1|22->1|25->4|25->4|27->6|27->6|41->20|41->20|42->21|42->21|46->25|46->25|50->29|50->29|53->32|53->32|56->35|56->35|57->36|57->36|58->37|58->37|60->39|61->40
                    -- GENERATED --
                */
            