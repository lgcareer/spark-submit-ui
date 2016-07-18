
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
object sparksql extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.api.data.Form[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: play.api.data.Form[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""
"""),_display_(Seq[Any](/*2.2*/main("Neptune Spark-sql")/*2.27*/{_display_(Seq[Any](format.raw/*2.28*/("""
"""),_display_(Seq[Any](/*3.2*/confirm("确定执行？"))),format.raw/*3.18*/("""
<script charset="utf-8">

    $(document).ready(function()"""),format.raw/*6.33*/("""{"""),format.raw/*6.34*/("""
        alert("aa")
        $.ajax("""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
            type:"GET",
            url:"/executesql",
            success:function(data)"""),format.raw/*11.35*/("""{"""),format.raw/*11.36*/("""
            alert("bb")
              var head= "<table border='10' width='439'><tr><th>JobID</th><th>User</th><th>Queue</th><th>State</th><th>FinalStatus</th><th>Progress</th><th>startedTime</th><th>finishedTime</th></tr>"
                var myobj=eval(data);
                alert("cc")
                for (var p in myobj) """),format.raw/*16.38*/("""{"""),format.raw/*16.39*/("""
                    var datamid = data[p];
                    for(var  x in datamid)"""),format.raw/*18.43*/("""{"""),format.raw/*18.44*/("""
                        var mid = eval(data[p][x]);
                        for (var i = 0; i < mid.length; i++) """),format.raw/*20.62*/("""{"""),format.raw/*20.63*/("""
                             if(mid[i].progress == 100)"""),format.raw/*21.56*/("""{"""),format.raw/*21.57*/("""
                             head += "<tr class= \"success\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*23.30*/("""}"""),format.raw/*23.31*/("""
                             if(mid[i].progress != 100)"""),format.raw/*24.56*/("""{"""),format.raw/*24.57*/("""
                             head += "<tr class= \"warning\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*26.30*/("""}"""),format.raw/*26.31*/("""
                             if(mid[i].FinalStatus == "FAILED")"""),format.raw/*27.64*/("""{"""),format.raw/*27.65*/("""
                             head += "<tr class= \"active\"><td><a href ='"+mid[i].trackingUrl+"'>"+mid[i].id+"</a></td><td>"+mid[i].user+"</td><td>"+mid[i].queue+"</td><td>"+mid[i].state+"</td><td>"+mid[i].finalStatus+"</td><td>"+mid[i].progress+"</td><td>"+ new Date(mid[i].startedTime).toLocaleString()+"</td><td>"+new Date(mid[i].finishedTime).toLocaleString()+"</td></tr>"
                             """),format.raw/*29.30*/("""}"""),format.raw/*29.31*/("""
                          """),format.raw/*30.27*/("""}"""),format.raw/*30.28*/(""";
                    """),format.raw/*31.21*/("""}"""),format.raw/*31.22*/("""

                """),format.raw/*33.17*/("""}"""),format.raw/*33.18*/(""";
                head += " </table>";
                $('#executesql').html(head);
            """),format.raw/*36.13*/("""}"""),format.raw/*36.14*/("""
        """),format.raw/*37.9*/("""}"""),format.raw/*37.10*/(""");
"""),format.raw/*38.1*/("""}"""),format.raw/*38.2*/(""");
    </script>
<div class="graphs">
    <div class="xs">
        <h3>Neptune Spark Sql</h3>
        """),_display_(Seq[Any](/*43.10*/helper/*43.16*/.form(action=routes.SparkSql.executesql)/*43.56*/{_display_(Seq[Any](format.raw/*43.57*/("""
        <div class="tab-content">
            <div class="tab-pane active" id="horizontal-form">
                <div class="form-group">
                    <label for="txtarea1" class="col-sm-2 control-label">请输入要执行的SQL</label>
                    <div class="col-sm-8"><textarea name="sql" id="txtarea1" cols="50" rows="4" class="form-control1"></textarea></div>
                </div>
            </div>
        </div>

        <div class="bs-example" data-example-id="form-validation-states">
        </div>

        <div class="bs-example" data-example-id="form-validation-states-with-icons">
            <div class="panel-footer">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2">
                        <button class="btn-success btn" type="submit" id="sql_sum" >提交</button>
                        <button class="btn-inverse btn" type="reset" >重置</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="bs-example4" data-example-id="contextual-table">
        <table class="table" id = "result">

        </table>
    </div>
    """),_display_(Seq[Any](/*72.6*/copyright())),format.raw/*72.17*/("""
</div>
""")))})),format.raw/*74.2*/("""
""")))})),format.raw/*75.2*/("""
"""))}
    }
    
    def render(form:play.api.data.Form[String]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((play.api.data.Form[String]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jul 18 15:28:44 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/sparksql.scala.html
                    HASH: 705c4b5333993ba22d7b198852f38b4814824aea
                    MATRIX: 579->1|707->35|743->37|776->62|814->63|850->65|887->81|973->140|1001->141|1064->177|1092->178|1210->268|1239->269|1595->597|1624->598|1738->684|1767->685|1909->799|1938->800|2022->856|2051->857|2488->1266|2517->1267|2601->1323|2630->1324|3067->1733|3096->1734|3188->1798|3217->1799|3653->2207|3682->2208|3737->2235|3766->2236|3816->2258|3845->2259|3891->2277|3920->2278|4044->2374|4073->2375|4109->2384|4138->2385|4168->2388|4196->2389|4335->2492|4350->2498|4399->2538|4438->2539|5621->3687|5654->3698|5694->3707|5727->3709
                    LINES: 19->1|22->1|23->2|23->2|23->2|24->3|24->3|27->6|27->6|29->8|29->8|32->11|32->11|37->16|37->16|39->18|39->18|41->20|41->20|42->21|42->21|44->23|44->23|45->24|45->24|47->26|47->26|48->27|48->27|50->29|50->29|51->30|51->30|52->31|52->31|54->33|54->33|57->36|57->36|58->37|58->37|59->38|59->38|64->43|64->43|64->43|64->43|93->72|93->72|95->74|96->75
                    -- GENERATED --
                */
            