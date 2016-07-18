
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
object streaming extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[StreamingUi,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(streaming: StreamingUi):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""
"""),_display_(Seq[Any](/*2.2*/main("Neptun Dashboard")/*2.26*/{_display_(Seq[Any](format.raw/*2.27*/("""


<style type='text/css'>
    #sparkinfo"""),format.raw/*6.15*/("""{"""),format.raw/*6.16*/("""
    width:10%;
    line-height:2.5;
    """),format.raw/*9.5*/("""}"""),format.raw/*9.6*/("""
</style>
<!--
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*12.31*/routes/*12.37*/.Assets.at("stylesheets/vis.min.css"))),format.raw/*12.74*/("""" type="text/css"/>

<link rel="stylesheet" href=""""),_display_(Seq[Any](/*14.31*/routes/*14.37*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*14.80*/("""" type="text/css"/>

<link rel="stylesheet" href=""""),_display_(Seq[Any](/*16.31*/routes/*16.37*/.Assets.at("stylesheets/webui.css"))),format.raw/*16.72*/("""" type="text/css"/>
-->
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*18.31*/routes/*18.37*/.Assets.at("stylesheets/timeline-view.css"))),format.raw/*18.80*/("""" type="text/css"/>
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*19.31*/routes/*19.37*/.Assets.at("stylesheets/streaming-page.css"))),format.raw/*19.81*/("""" type="text/css"/>


<script src=""""),_display_(Seq[Any](/*22.15*/routes/*22.21*/.Assets.at("javascripts/d3.min.js"))),format.raw/*22.56*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*23.19*/routes/*23.25*/.Assets.at("javascripts/sorttable.js"))),format.raw/*23.63*/("""" type="text/javascript" ></script>
<script src=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("javascripts/jquery-1.11.1.min.js"))),format.raw/*24.67*/(""""  type="text/javascript" ></script>
    <script src=""""),_display_(Seq[Any](/*25.19*/routes/*25.25*/.Assets.at("javascripts/vis.min.js"))),format.raw/*25.61*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*26.15*/routes/*26.21*/.Assets.at("javascripts/bootstrap-tooltip.js"))),format.raw/*26.67*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.Assets.at("javascripts/initialize-tooltips.js"))),format.raw/*27.73*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*28.15*/routes/*28.21*/.Assets.at("javascripts/table.js"))),format.raw/*28.55*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*29.19*/routes/*29.25*/.Assets.at("javascripts/additional-metrics.js"))),format.raw/*29.72*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*30.15*/routes/*30.21*/.Assets.at("javascripts/timeline-view.js"))),format.raw/*30.63*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*31.19*/routes/*31.25*/.Assets.at("javascripts/streaming-page.js"))),format.raw/*31.68*/("""" type="text/javascript"></script>

<div>
    <h3 style="text-align:center;"> Spark Stream任务监控</h3>
    <div class="sparkinfo">"""),_display_(Seq[Any](/*35.29*/Html(streaming.statTable))),format.raw/*35.54*/("""</div>
</div>

    """),_display_(Seq[Any](/*38.6*/copyright())),format.raw/*38.17*/("""
</div>
""")))})),format.raw/*40.2*/("""


"""))}
    }
    
    def render(streaming:StreamingUi): play.api.templates.HtmlFormat.Appendable = apply(streaming)
    
    def f:((StreamingUi) => play.api.templates.HtmlFormat.Appendable) = (streaming) => apply(streaming)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 16:01:48 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/streaming.scala.html
                    HASH: 23916c40db99e7b0127147adf42b9b8bc68ea1a3
                    MATRIX: 565->1|683->25|719->27|751->51|789->52|857->93|885->94|952->135|979->136|1060->181|1075->187|1134->224|1221->275|1236->281|1301->324|1388->375|1403->381|1460->416|1550->470|1565->476|1630->519|1716->569|1731->575|1797->619|1869->655|1884->661|1941->696|2030->749|2045->755|2105->793|2191->843|2206->849|2274->895|2365->950|2380->956|2438->992|2523->1041|2538->1047|2606->1093|2695->1146|2710->1152|2780->1200|2865->1249|2880->1255|2936->1289|3025->1342|3040->1348|3109->1395|3194->1444|3209->1450|3273->1492|3362->1545|3377->1551|3442->1594|3606->1722|3653->1747|3708->1767|3741->1778|3781->1787
                    LINES: 19->1|22->1|23->2|23->2|23->2|27->6|27->6|30->9|30->9|33->12|33->12|33->12|35->14|35->14|35->14|37->16|37->16|37->16|39->18|39->18|39->18|40->19|40->19|40->19|43->22|43->22|43->22|44->23|44->23|44->23|45->24|45->24|45->24|46->25|46->25|46->25|47->26|47->26|47->26|48->27|48->27|48->27|49->28|49->28|49->28|50->29|50->29|50->29|51->30|51->30|51->30|52->31|52->31|52->31|56->35|56->35|59->38|59->38|61->40
                    -- GENERATED --
                */
            