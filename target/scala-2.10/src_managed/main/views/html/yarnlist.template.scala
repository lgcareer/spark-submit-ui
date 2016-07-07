
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

"""),_display_(Seq[Any](/*20.2*/copyright())),format.raw/*20.13*/("""
</div>
<script charset="utf-8">

    $(document).ready(function()"""),format.raw/*24.33*/("""{"""),format.raw/*24.34*/("""
        $.ajax("""),format.raw/*25.16*/("""{"""),format.raw/*25.17*/("""
            type:"GET",
            url:"/yarnInfo",
            dataType:"json",
            success:function(data)"""),format.raw/*29.35*/("""{"""),format.raw/*29.36*/("""
              var head= "<table border='10' width='439'><tr><th>JobID</th><th>User</th><th>Queue</th><th>State</th><th>FinalStatus</th><th>Progress</th><th>startedTime</th><th>finishedTime</th></tr>"
                var myobj=eval(data);
                for (var p in myobj) """),format.raw/*32.38*/("""{"""),format.raw/*32.39*/("""
                    var datamid = data[p];
                    for(var  x in datamid)"""),format.raw/*34.43*/("""{"""),format.raw/*34.44*/("""
                        var mid = eval(data[p][x]);
                        for (var i = 0; i < mid.length; i++) """),format.raw/*36.62*/("""{"""),format.raw/*36.63*/("""
                             if(mid[i].progress == 100)"""),format.raw/*37.56*/("""{"""),format.raw/*37.57*/("""
                             head += "<tr class= \"success\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*39.30*/("""}"""),format.raw/*39.31*/("""
                             if(mid[i].progress != 100)"""),format.raw/*40.56*/("""{"""),format.raw/*40.57*/("""
                             head += "<tr class= \"warning\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*42.30*/("""}"""),format.raw/*42.31*/("""
                             if(mid[i].FinalStatus == "FAILED")"""),format.raw/*43.64*/("""{"""),format.raw/*43.65*/("""
                             head += "<tr class= \"active\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*45.30*/("""}"""),format.raw/*45.31*/("""
                          """),format.raw/*46.27*/("""}"""),format.raw/*46.28*/(""";
                    """),format.raw/*47.21*/("""}"""),format.raw/*47.22*/("""

                """),format.raw/*49.17*/("""}"""),format.raw/*49.18*/(""";
                head += " </table>";
                $('#yarnInfo').html(head);
            """),format.raw/*52.13*/("""}"""),format.raw/*52.14*/("""
        """),format.raw/*53.9*/("""}"""),format.raw/*53.10*/(""");
"""),format.raw/*54.1*/("""}"""),format.raw/*54.2*/(""");
    </script>
""")))})),format.raw/*56.2*/("""

"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 07 10:32:13 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/yarnlist.scala.html
                    HASH: 2d4ac9cf8ce6cb59bb8618f75d0cb8052332f1ae
                    MATRIX: 649->1|681->25|719->26|1161->433|1194->444|1288->510|1317->511|1361->527|1390->528|1535->645|1564->646|1868->922|1897->923|2011->1009|2040->1010|2182->1124|2211->1125|2295->1181|2324->1182|2761->1591|2790->1592|2874->1648|2903->1649|3340->2058|3369->2059|3461->2123|3490->2124|3926->2532|3955->2533|4010->2560|4039->2561|4089->2583|4118->2584|4164->2602|4193->2603|4315->2697|4344->2698|4380->2707|4409->2708|4439->2711|4467->2712|4516->2730
                    LINES: 22->1|22->1|22->1|41->20|41->20|45->24|45->24|46->25|46->25|50->29|50->29|53->32|53->32|55->34|55->34|57->36|57->36|58->37|58->37|60->39|60->39|61->40|61->40|63->42|63->42|64->43|64->43|66->45|66->45|67->46|67->46|68->47|68->47|70->49|70->49|73->52|73->52|74->53|74->53|75->54|75->54|77->56
                    -- GENERATED --
                */
            