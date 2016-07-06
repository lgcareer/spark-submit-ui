
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
object yarnlist extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

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
            <script src=""""),_display_(Seq[Any](/*22.27*/routes/*22.33*/.Assets.at("javascripts/moment-2.2.1.js"))),format.raw/*22.74*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("javascripts/clndr.js"))),format.raw/*23.55*/("""" type="text/javascript"></script>
            <script src=""""),_display_(Seq[Any](/*24.27*/routes/*24.33*/.Assets.at("javascripts/site.js"))),format.raw/*24.66*/("""" type="text/javascript"></script>
<!----End Calender -------->
<div class="graphs">

    <div class="col_1">
        <div class="xs" >
            <h3 style="text-align:center;">  Yarn调度任务信息列表  </h3>
            <div class="bs-example4" data-example-id="contextual-table">
                <table class="table" id = "yarnInfo">

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
            url:"/yarnInfo",
            dataType:"json",
            success:function(data)"""),format.raw/*51.35*/("""{"""),format.raw/*51.36*/("""
              var head= "<table border='10' width='439'><tr><th>JobID</th><th>User</th><th>Queue</th><th>State</th><th>FinalStatus</th><th>Progress</th><th>startedTime</th><th>finishedTime</th></tr>"
                var myobj=eval(data);
                for (var p in myobj) """),format.raw/*54.38*/("""{"""),format.raw/*54.39*/("""
                    var datamid = data[p];
                    for(var  x in datamid)"""),format.raw/*56.43*/("""{"""),format.raw/*56.44*/("""
                        var mid = eval(data[p][x]);
                        for (var i = 0; i < mid.length; i++) """),format.raw/*58.62*/("""{"""),format.raw/*58.63*/("""
                             if(mid[i].progress == 100)"""),format.raw/*59.56*/("""{"""),format.raw/*59.57*/("""
                             head += "<tr class= \"success\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*61.30*/("""}"""),format.raw/*61.31*/("""
                             if(mid[i].progress != 100)"""),format.raw/*62.56*/("""{"""),format.raw/*62.57*/("""
                             head += "<tr class= \"warning\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*64.30*/("""}"""),format.raw/*64.31*/("""
                             if(mid[i].FinalStatus == "FAILED")"""),format.raw/*65.64*/("""{"""),format.raw/*65.65*/("""
                             head += "<tr class= \"active\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*67.30*/("""}"""),format.raw/*67.31*/("""
                          """),format.raw/*68.27*/("""}"""),format.raw/*68.28*/(""";
                    """),format.raw/*69.21*/("""}"""),format.raw/*69.22*/("""

                """),format.raw/*71.17*/("""}"""),format.raw/*71.18*/(""";
                head += " </table>";
                $('#yarnInfo').html(head);
            """),format.raw/*74.13*/("""}"""),format.raw/*74.14*/("""
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/(""");
"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/(""");
    </script>
""")))})),format.raw/*78.2*/("""

"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 06 15:13:29 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/yarnlist.scala.html
                    HASH: a9d18913663ad728c0d373b57699c23415282ae5
                    MATRIX: 649->1|681->25|719->26|784->64|812->65|900->127|927->128|997->171|1025->172|1072->192|1100->193|1176->241|1205->242|1273->283|1301->284|1402->349|1417->355|1474->390|1545->425|1560->431|1625->474|1722->535|1737->541|1800->582|1885->631|1900->637|1956->671|2053->732|2068->738|2123->771|2598->1211|2631->1222|2725->1288|2754->1289|2798->1305|2827->1306|2972->1423|3001->1424|3305->1700|3334->1701|3448->1787|3477->1788|3619->1902|3648->1903|3732->1959|3761->1960|4198->2369|4227->2370|4311->2426|4340->2427|4777->2836|4806->2837|4898->2901|4927->2902|5363->3310|5392->3311|5447->3338|5476->3339|5526->3361|5555->3362|5601->3380|5630->3381|5752->3475|5781->3476|5817->3485|5846->3486|5876->3489|5904->3490|5953->3508
                    LINES: 22->1|22->1|22->1|24->3|24->3|27->6|27->6|30->9|30->9|32->11|32->11|35->14|35->14|38->17|38->17|41->20|41->20|41->20|42->21|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|45->24|45->24|45->24|63->42|63->42|67->46|67->46|68->47|68->47|72->51|72->51|75->54|75->54|77->56|77->56|79->58|79->58|80->59|80->59|82->61|82->61|83->62|83->62|85->64|85->64|86->65|86->65|88->67|88->67|89->68|89->68|90->69|90->69|92->71|92->71|95->74|95->74|96->75|96->75|97->76|97->76|99->78
                    -- GENERATED --
                */
            