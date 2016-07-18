
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

   <script src=""""),_display_(Seq[Any](/*11.18*/routes/*11.24*/.Assets.at("javascripts/sorttable.js"))),format.raw/*11.62*/("""" type="text/javascript" ></script>
   <script src=""""),_display_(Seq[Any](/*12.18*/routes/*12.24*/.Assets.at("javascripts/jquery-1.11.1.min.js"))),format.raw/*12.70*/(""""  type="text/javascript" ></script>
   <script src=""""),_display_(Seq[Any](/*13.18*/routes/*13.24*/.Assets.at("javascripts/vis.min.js"))),format.raw/*13.60*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*14.18*/routes/*14.24*/.Assets.at("javascripts/bootstrap-tooltip.js"))),format.raw/*14.70*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*15.18*/routes/*15.24*/.Assets.at("javascripts/initialize-tooltips.js"))),format.raw/*15.72*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*16.18*/routes/*16.24*/.Assets.at("javascripts/table.js"))),format.raw/*16.58*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*17.18*/routes/*17.24*/.Assets.at("javascripts/additional-metrics.js"))),format.raw/*17.71*/("""" type="text/javascript"></script>
   <script src=""""),_display_(Seq[Any](/*18.18*/routes/*18.24*/.Assets.at("javascripts/timeline-view.js"))),format.raw/*18.66*/("""" type="text/javascript"></script>

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
       """),_display_(Seq[Any](/*30.9*/Html(job.timeline))),format.raw/*30.27*/("""
       """),_display_(Seq[Any](/*31.9*/Html(job.active))),format.raw/*31.25*/("""
       """),_display_(Seq[Any](/*32.9*/Html(job.completed))),format.raw/*32.28*/("""
   </div>
   <div>
       """),_display_(Seq[Any](/*35.9*/copyright())),format.raw/*35.20*/("""
   </div>
""")))})))}
    }
    
    def render(job:JobUi): play.api.templates.HtmlFormat.Appendable = apply(job)
    
    def f:((JobUi) => play.api.templates.HtmlFormat.Appendable) = (job) => apply(job)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jul 18 14:53:32 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/jobs.scala.html
                    HASH: cb1cf7290740b8b4bac047361d8622e5f3ba3a4c
                    MATRIX: 554->1|660->13|696->15|728->39|766->40|889->128|903->134|961->171|1047->222|1061->228|1125->271|1215->326|1229->332|1285->367|1374->421|1388->427|1452->470|1526->508|1541->514|1601->552|1690->605|1705->611|1773->657|1863->711|1878->717|1936->753|2024->805|2039->811|2107->857|2195->909|2210->915|2280->963|2368->1015|2383->1021|2439->1055|2527->1107|2542->1113|2611->1160|2699->1212|2714->1218|2778->1260|3099->1546|3139->1564|3183->1573|3221->1589|3265->1598|3306->1617|3369->1645|3402->1656
                    LINES: 19->1|22->1|23->2|23->2|23->2|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|51->30|51->30|52->31|52->31|53->32|53->32|56->35|56->35
                    -- GENERATED --
                */
            