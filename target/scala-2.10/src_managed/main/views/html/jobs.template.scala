
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
object jobs extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[JobUi,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(job: JobUi):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.14*/("""
"""),_display_(Seq[Any](/*2.2*/main("Neptun Dashboard")/*2.26*/{_display_(Seq[Any](format.raw/*2.27*/("""
    <meta charset="UTF-8"/>
    <title>jobs</title>

    <link rel="stylesheet" href=""""),_display_(Seq[Any](/*6.35*/routes/*6.41*/.Assets.at("stylesheets/vis.min.css"))),format.raw/*6.78*/("""" type="text/css"/>
 <link rel="stylesheet" href=""""),_display_(Seq[Any](/*7.32*/routes/*7.38*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.81*/("""" type="text/css"/>
<!-- <link rel="stylesheet" href=""""),_display_(Seq[Any](/*8.36*/routes/*8.42*/.Assets.at("stylesheets/webui.css"))),format.raw/*8.77*/("""" type="text/css"/> -->
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*9.31*/routes/*9.37*/.Assets.at("stylesheets/timeline-view.css"))),format.raw/*9.80*/("""" type="text/css"/>


   <script src=""""),_display_(Seq[Any](/*12.18*/routes/*12.24*/.Assets.at("javascripts/sorttable.js"))),format.raw/*12.62*/("""" type="text/javascript" ></script>
   <script src=""""),_display_(Seq[Any](/*13.18*/routes/*13.24*/.Assets.at("javascripts/jquery-1.11.1.min.js"))),format.raw/*13.70*/(""""  type="text/javascript" ></script>
   <script src=""""),_display_(Seq[Any](/*14.18*/routes/*14.24*/.Assets.at("javascripts/vis.min.js"))),format.raw/*14.60*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*15.18*/routes/*15.24*/.Assets.at("javascripts/bootstrap-tooltip.js"))),format.raw/*15.70*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*16.18*/routes/*16.24*/.Assets.at("javascripts/initialize-tooltips.js"))),format.raw/*16.72*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*17.18*/routes/*17.24*/.Assets.at("javascripts/table.js"))),format.raw/*17.58*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*18.18*/routes/*18.24*/.Assets.at("javascripts/additional-metrics.js"))),format.raw/*18.71*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*19.18*/routes/*19.24*/.Assets.at("javascripts/timeline-view.js"))),format.raw/*19.66*/("""" type="text/javascript"></script>

<div class="container-fluid">
   <div class="row-fluid">
       <div class="span12">
           <h3 style="vertical-align: bottom; display: inline-block;">
               Spark 任务监控
           </h3>
       </div>
   </div>
   </div>
   <div>
       """),_display_(Seq[Any](/*31.9*/Html(job.timeline))),format.raw/*31.27*/("""
       """),_display_(Seq[Any](/*32.9*/Html(job.active))),format.raw/*32.25*/("""
       """),_display_(Seq[Any](/*33.9*/Html(job.completed))),format.raw/*33.28*/("""
   </div>
   <div>
       """),_display_(Seq[Any](/*36.9*/copyright())),format.raw/*36.20*/("""
   </div>
""")))})))}
    }
    
    def render(job:JobUi): play.api.templates.HtmlFormat.Appendable = apply(job)
    
    def f:((JobUi) => play.api.templates.HtmlFormat.Appendable) = (job) => apply(job)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 07 18:41:32 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/jobs.scala.html
                    HASH: 93f77b946615cdb8379197969b721077031108b0
                    MATRIX: 554->1|660->13|696->15|728->39|766->40|889->128|903->134|961->171|1047->222|1061->228|1125->271|1215->326|1229->332|1285->367|1374->421|1388->427|1452->470|1527->509|1542->515|1602->553|1691->606|1706->612|1774->658|1864->712|1879->718|1937->754|2025->806|2040->812|2108->858|2196->910|2211->916|2281->964|2369->1016|2384->1022|2440->1056|2528->1108|2543->1114|2612->1161|2700->1213|2715->1219|2779->1261|3100->1547|3140->1565|3184->1574|3222->1590|3266->1599|3307->1618|3370->1646|3403->1657
                    LINES: 19->1|22->1|23->2|23->2|23->2|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|52->31|52->31|53->32|53->32|54->33|54->33|57->36|57->36
                    -- GENERATED --
                */
            