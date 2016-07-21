
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
object sparklist extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Neptun Dashboard")/*1.26*/{_display_(Seq[Any](format.raw/*1.27*/("""
<style type='text/css'>
    #worklist"""),format.raw/*3.14*/("""{"""),format.raw/*3.15*/("""
    width:100%;
    background-color:rgb(100%,100%,90%);
    """),format.raw/*6.5*/("""}"""),format.raw/*6.6*/("""
</style>
<style type='text/css'>
    #date"""),format.raw/*9.10*/("""{"""),format.raw/*9.11*/("""
    width:50%;
    """),format.raw/*11.5*/("""}"""),format.raw/*11.6*/("""
</style>
<style type='text/css'>
    #sparkinfo"""),format.raw/*14.15*/("""{"""),format.raw/*14.16*/("""
    width:50%;
    line-height:2.5;
    """),format.raw/*17.5*/("""}"""),format.raw/*17.6*/("""
</style>
<!----Calender -------->
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*20.31*/routes/*20.37*/.Assets.at("stylesheets/clndr.css"))),format.raw/*20.72*/("""" type="text/css" />
<script src=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("javascripts/underscore-min.js"))),format.raw/*21.64*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*22.15*/routes/*22.21*/.Assets.at("javascripts/moment-2.2.1.js"))),format.raw/*22.62*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("javascripts/clndr.js"))),format.raw/*23.55*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("javascripts/site.js"))),format.raw/*24.54*/("""" type="text/javascript"></script>
<!----End Calender -------->
<div class="graphs">

    <div class="col_1">
        <div class="xs" >
            <h3 style="text-align:center;"> Spark 本地调度任务列表   </h3>
            <div class="bs-example4" data-example-id="contextual-table">
                <table class="table" id = "sparklist">

                </table>
            </div>
        </div>

        <div class="clearfix"></div>

    </div>

"""),_display_(Seq[Any](/*42.2*/copyright())),format.raw/*42.13*/("""
</div>
<script charset="utf-8">

    $(document).ready(function()"""),format.raw/*46.33*/("""{"""),format.raw/*46.34*/("""
        $.ajax("""),format.raw/*47.16*/("""{"""),format.raw/*47.17*/("""
            type:"GET",
            url:"/workerlist",
            dataType:"json",
            success:function(data)"""),format.raw/*51.35*/("""{"""),format.raw/*51.36*/("""
              var head= "<table border='10' width='439'><tr><th>Application ID</th><th>Name</th><th>User</th><th>Memory per Node</th><th>Submitted Time</th><th>State</th><th>Duration</th></tr>"
                var myobj=eval(data);
                var completedapps =myobj.completedapps
                for (var p in completedapps) """),format.raw/*55.46*/("""{"""),format.raw/*55.47*/("""
                    var id = completedapps[p].id
                    var name = completedapps[p].name
                    var user = completedapps[p].user
                    var memoryperslave = completedapps[p].memoryperslave
                    var submitdate = completedapps[p].submitdate
                    var state = completedapps[p].state
                    var duration = completedapps[p].duration
                  head += "<tr class= \"success\"><td><a a href='http://h136159.mars.grid.sina.com.cn:8080/app/?appId="+id+"' target='_blank'>"+id+"</td><td>"+name+"</td><td>"+user+"</td><td>"+memoryperslave+"</td><td>"+submitdate+"</td><td>"+state+"</td><td>"+duration+"</td></tr>"
                   """),format.raw/*64.20*/("""}"""),format.raw/*64.21*/(""";


                head += " </table>";
                $('#sparklist').html(head);
            """),format.raw/*69.13*/("""}"""),format.raw/*69.14*/("""
        """),format.raw/*70.9*/("""}"""),format.raw/*70.10*/(""");
   """),format.raw/*71.4*/("""}"""),format.raw/*71.5*/(""");
  </script>
""")))})),format.raw/*73.2*/("""


"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Tue Jul 19 16:24:36 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/sparklist.scala.html
                    HASH: 5a77444c4110a58a49d95c15471fcf9307cea3cf
                    MATRIX: 650->1|682->25|720->26|785->64|813->65|901->127|928->128|998->171|1026->172|1073->192|1101->193|1177->241|1206->242|1274->283|1302->284|1403->349|1418->355|1475->390|1546->425|1561->431|1626->474|1711->523|1726->529|1789->570|1874->619|1889->625|1945->659|2030->708|2045->714|2100->747|2578->1190|2611->1201|2705->1267|2734->1268|2778->1284|2807->1285|2954->1404|2983->1405|3344->1738|3373->1739|4113->2451|4142->2452|4267->2549|4296->2550|4332->2559|4361->2560|4394->2566|4422->2567|4469->2583
=======
                    DATE: Tue Jul 19 17:39:46 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/sparklist.scala.html
                    HASH: a1e0f179fb7949fd1b1327f2076046525795aff3
                    MATRIX: 650->1|682->25|720->26|785->64|813->65|901->127|928->128|998->171|1026->172|1073->192|1101->193|1177->241|1206->242|1274->283|1302->284|1403->349|1418->355|1475->390|1546->425|1561->431|1626->474|1723->535|1738->541|1801->582|1886->631|1901->637|1957->671|2054->732|2069->738|2124->771|2602->1214|2635->1225|2729->1291|2758->1292|2802->1308|2831->1309|2978->1428|3007->1429|3368->1762|3397->1763|4137->2475|4166->2476|4291->2573|4320->2574|4356->2583|4385->2584|4418->2590|4446->2591|4493->2607
>>>>>>> 6c87dee3ccd36f4abb322413020222f473a51e93
                    LINES: 22->1|22->1|22->1|24->3|24->3|27->6|27->6|30->9|30->9|32->11|32->11|35->14|35->14|38->17|38->17|41->20|41->20|41->20|42->21|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|45->24|45->24|45->24|63->42|63->42|67->46|67->46|68->47|68->47|72->51|72->51|76->55|76->55|85->64|85->64|90->69|90->69|91->70|91->70|92->71|92->71|94->73
                    -- GENERATED --
                */
            