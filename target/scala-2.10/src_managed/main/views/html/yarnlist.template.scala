
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
    $(document).ready(function()"""),format.raw/*23.33*/("""{"""),format.raw/*23.34*/("""
        $.ajax("""),format.raw/*24.16*/("""{"""),format.raw/*24.17*/("""
            type:"GET",
            url:"/yarnInfo",
            dataType:"json",
            success:function(data)"""),format.raw/*28.35*/("""{"""),format.raw/*28.36*/("""
              var head= "<table border='10' width='439'><tr><th>JobID</th><th>User</th><th>Queue</th><th>State</th><th>FinalStatus</th><th>Progress</th><th>startedTime</th><th>finishedTime</th></tr>"
                var myobj=eval(data);
                for (var p in myobj) """),format.raw/*31.38*/("""{"""),format.raw/*31.39*/("""
                    var datamid = data[p];
                    for(var  x in datamid)"""),format.raw/*33.43*/("""{"""),format.raw/*33.44*/("""
                        var mid = eval(data[p][x]);
                        for (var i = 0; i < mid.length; i++) """),format.raw/*35.62*/("""{"""),format.raw/*35.63*/("""
                             if(mid[i].progress == 100)"""),format.raw/*36.56*/("""{"""),format.raw/*36.57*/("""
                             head += "<tr class= \"success\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*38.30*/("""}"""),format.raw/*38.31*/("""
                             if(mid[i].progress != 100)"""),format.raw/*39.56*/("""{"""),format.raw/*39.57*/("""
                             head += "<tr class= \"warning\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*41.30*/("""}"""),format.raw/*41.31*/("""
                             if(mid[i].FinalStatus == "FAILED")"""),format.raw/*42.64*/("""{"""),format.raw/*42.65*/("""
                             head += "<tr class= \"active\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*44.30*/("""}"""),format.raw/*44.31*/("""
                          """),format.raw/*45.27*/("""}"""),format.raw/*45.28*/(""";
                    """),format.raw/*46.21*/("""}"""),format.raw/*46.22*/("""

                """),format.raw/*48.17*/("""}"""),format.raw/*48.18*/(""";
                head += " </table>";
                $('#yarnInfo').html(head);
            """),format.raw/*51.13*/("""}"""),format.raw/*51.14*/("""
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/(""");
"""),format.raw/*53.1*/("""}"""),format.raw/*53.2*/(""");
    </script>
""")))})),format.raw/*55.2*/("""

"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jul 18 14:53:32 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/yarnlist.scala.html
                    HASH: a5085454f1758ba6c3d3346ddf9c3ede90957ace
                    MATRIX: 649->1|681->25|719->26|1161->433|1194->444|1287->509|1316->510|1360->526|1389->527|1534->644|1563->645|1867->921|1896->922|2010->1008|2039->1009|2181->1123|2210->1124|2294->1180|2323->1181|2760->1590|2789->1591|2873->1647|2902->1648|3339->2057|3368->2058|3460->2122|3489->2123|3925->2531|3954->2532|4009->2559|4038->2560|4088->2582|4117->2583|4163->2601|4192->2602|4314->2696|4343->2697|4379->2706|4408->2707|4438->2710|4466->2711|4515->2729
                    LINES: 22->1|22->1|22->1|41->20|41->20|44->23|44->23|45->24|45->24|49->28|49->28|52->31|52->31|54->33|54->33|56->35|56->35|57->36|57->36|59->38|59->38|60->39|60->39|62->41|62->41|63->42|63->42|65->44|65->44|66->45|66->45|67->46|67->46|69->48|69->48|72->51|72->51|73->52|73->52|74->53|74->53|76->55
                    -- GENERATED --
                */
            