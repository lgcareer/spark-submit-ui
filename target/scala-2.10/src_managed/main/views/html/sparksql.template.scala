
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
object sparksql extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Neptune Spark-sql")/*1.27*/{_display_(Seq[Any](format.raw/*1.28*/("""
<!DOCTYPE html>
<html>
<head>
<title>Spark sql</title>
<script src=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Assets.at("javascripts/underscore-min.js"))),format.raw/*6.64*/("""" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href='"""),_display_(Seq[Any](/*8.62*/routes/*8.68*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*8.111*/("""'>
<script src=""""),_display_(Seq[Any](/*9.15*/routes/*9.21*/.Assets.at("javascripts/jquery-1.11.1.min.js"))),format.raw/*9.67*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*10.15*/routes/*10.21*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*10.63*/("""" type="text/javascript" ></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
</head>
<body>
<!--
<textarea class="form-control" id="sql" rows="3"></textarea>
-->
	<div class="tab-content">
		<div class="tab-pane active" id="horizontal-form">
			<div class="form-group">
				<label for="sql" class="col-sm-2 control-label">请输入要执行的SQL</label>
				<div class="col-sm-8">
					<textarea id="sql" cols="50" rows="4" class="form-control1"></textarea>
				</div>
			</div>
		</div>
	</div>

<div class="col-sm-8">
<button class="btn btn-primary" id="submit">提交</button>
	<div id="result"></div>
</div>
</body>


<script>
		function resultToTable(data) """),format.raw/*36.32*/("""{"""),format.raw/*36.33*/("""
			var header = data.header;
			var sql_data = data.data;
			var result = "";
			var tr = "";
			for (var i = 0;i < header.length;i++) """),format.raw/*41.42*/("""{"""),format.raw/*41.43*/("""
				tr += "<th>" + header[i] + "</th>";
			"""),format.raw/*43.4*/("""}"""),format.raw/*43.5*/("""
			result += "<tr>" + tr + "</tr>";

			for (var j = 0;j < sql_data.length;j++) """),format.raw/*46.44*/("""{"""),format.raw/*46.45*/("""
				tr = "";
				for (var i = 0;i < sql_data[j].length;i++) """),format.raw/*48.48*/("""{"""),format.raw/*48.49*/("""
					tr += "<td>" + sql_data[j][i] + "</td>";
				"""),format.raw/*50.5*/("""}"""),format.raw/*50.6*/("""
				result += "<tr>" + tr + "</tr>";
			"""),format.raw/*52.4*/("""}"""),format.raw/*52.5*/("""

			return "<table class='table table-bordered table-striped'>" + result + "</table>";
		"""),format.raw/*55.3*/("""}"""),format.raw/*55.4*/("""

		function resultToChart(data) """),format.raw/*57.32*/("""{"""),format.raw/*57.33*/("""
			var header = data.header;
			var select = "";
			for (var i = 0;i < header.length;i++) """),format.raw/*60.42*/("""{"""),format.raw/*60.43*/("""
				select += "<option value='" + header[i] + "'>" + header[i] + "</option>";
			"""),format.raw/*62.4*/("""}"""),format.raw/*62.5*/("""
//			select = "<select class='form-control'>" + select + "</select>";

			var result
					= "<div class='form-group'>"
					+ "<label class='col-sm-4 control-label' for='x'>x坐标：</label>"
					+ "<div class='col-sm-4'><select class='form-control' id='x'>" + select + "</select></div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label class='col-sm-4 control-label' for='y'>y坐标：</label>"
					+ "<div class='col-sm-4'><select class='form-control' id='y'>" + select + "</select></div>"
					+ "</div>";

			result += "<div class='form-group'><div class='col-sm-4'></div><button class='btn btn-default' id='generate'>生成</button></div>";
			result = "<div class='form-horizontal'>" + result + "</div>"
			result += "<div id='chartDiv'></div>";

			return result;
		"""),format.raw/*80.3*/("""}"""),format.raw/*80.4*/("""

		function toggleToChart(div, data) """),format.raw/*82.37*/("""{"""),format.raw/*82.38*/("""
			$(div).find("#generate").click(function() """),format.raw/*83.46*/("""{"""),format.raw/*83.47*/("""
				var header = data.header;
				var sql_data = data.data;
				var categories = [];
				var value = [];
				var x_index = header.indexOf($(div).find("#x").val());
				var y_index = header.indexOf($(div).find("#y").val());

				for (var j = 0;j < sql_data.length;j++) """),format.raw/*91.45*/("""{"""),format.raw/*91.46*/("""
					categories.push(sql_data[j][x_index]);
					value.push(sql_data[j][y_index]);
				"""),format.raw/*94.5*/("""}"""),format.raw/*94.6*/("""

				$(div).find("#chartDiv").highcharts("""),format.raw/*96.41*/("""{"""),format.raw/*96.42*/("""
					chart: """),format.raw/*97.13*/("""{"""),format.raw/*97.14*/("""
						type: 'column'
					"""),format.raw/*99.6*/("""}"""),format.raw/*99.7*/(""",
					xAxis: """),format.raw/*100.13*/("""{"""),format.raw/*100.14*/("""
						categories: categories
					"""),format.raw/*102.6*/("""}"""),format.raw/*102.7*/(""",
					yAxis: """),format.raw/*103.13*/("""{"""),format.raw/*103.14*/("""
						min: 0,
						title: """),format.raw/*105.14*/("""{"""),format.raw/*105.15*/("""
							text: $(div).find("#y").val()
						"""),format.raw/*107.7*/("""}"""),format.raw/*107.8*/("""
					"""),format.raw/*108.6*/("""}"""),format.raw/*108.7*/(""",
					plotOptions: """),format.raw/*109.19*/("""{"""),format.raw/*109.20*/("""
						column: """),format.raw/*110.15*/("""{"""),format.raw/*110.16*/("""
							pointPadding: 0.2,
							borderWidth: 0
						"""),format.raw/*113.7*/("""}"""),format.raw/*113.8*/("""
					"""),format.raw/*114.6*/("""}"""),format.raw/*114.7*/(""",
					series: ["""),format.raw/*115.15*/("""{"""),format.raw/*115.16*/("""
						name: $(div).find("#y").val(),
						data: value
					"""),format.raw/*118.6*/("""}"""),format.raw/*118.7*/("""]
				"""),format.raw/*119.5*/("""}"""),format.raw/*119.6*/(""");
			"""),format.raw/*120.4*/("""}"""),format.raw/*120.5*/(""")
		"""),format.raw/*121.3*/("""}"""),format.raw/*121.4*/("""

		function resultToDisplay(data) """),format.raw/*123.34*/("""{"""),format.raw/*123.35*/("""
			$("#result").html("");

			var result = "";
			result += '<li role="presentation" class="active"><a href="#table" aria-controls="table" role="tab" data-toggle="tab">表格</a></li>';
			result += '<li role="presentation"><a href="#chart" aria-controls="chart" role="tab" data-toggle="tab">图表</a></li>';
			result = "<ul class='nav nav-tabs' role='tablist'>" + result + "</ul>";

			result += '<div class="tab-content">'
					+ '<div role="tabpanel" class="tab-pane active" id="table">' + resultToTable(data) + '</div>'
					+ '<div role="tabpanel" class="tab-pane" id="chart">' + resultToChart(data) + '</div>'
					+ "</div>";

			$("#result").html(result);

			toggleToChart($("#chart"), data);
		"""),format.raw/*139.3*/("""}"""),format.raw/*139.4*/("""

		$(document).ready(function()"""),format.raw/*141.31*/("""{"""),format.raw/*141.32*/("""
			$("#submit").click(function()"""),format.raw/*142.33*/("""{"""),format.raw/*142.34*/("""
				$.ajax("""),format.raw/*143.12*/("""{"""),format.raw/*143.13*/("""
					"data": """),format.raw/*144.14*/("""{"""),format.raw/*144.15*/("""
						"sql": $("#sql").val()
					"""),format.raw/*146.6*/("""}"""),format.raw/*146.7*/(""",
					"method": "POST",
					"url": "/executesql",
					"dataType": "json",
					"success": function (data, textStatus, jqXHR)"""),format.raw/*150.51*/("""{"""),format.raw/*150.52*/("""
						resultToDisplay(data);
					"""),format.raw/*152.6*/("""}"""),format.raw/*152.7*/("""
				"""),format.raw/*153.5*/("""}"""),format.raw/*153.6*/(""");
			"""),format.raw/*154.4*/("""}"""),format.raw/*154.5*/(""")
		"""),format.raw/*155.3*/("""}"""),format.raw/*155.4*/(""")
	</script>
</html>
""")))})),format.raw/*158.2*/("""
"""),_display_(Seq[Any](/*159.2*/copyright())),format.raw/*159.13*/("""






"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Wed Jul 20 10:21:13 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/sparksql.scala.html
                    HASH: 9a54daf0181f1030316a7b99edec849995650d57
                    MATRIX: 649->1|682->26|720->27|825->97|839->103|903->146|1102->310|1116->316|1181->359|1233->376|1247->382|1314->428|1399->477|1414->483|1478->525|2181->1200|2210->1201|2374->1337|2403->1338|2474->1382|2502->1383|2611->1464|2640->1465|2729->1526|2758->1527|2836->1578|2864->1579|2932->1620|2960->1621|3077->1711|3105->1712|3166->1745|3195->1746|3314->1837|3343->1838|3452->1920|3480->1921|4284->2698|4312->2699|4378->2737|4407->2738|4481->2784|4510->2785|4807->3054|4836->3055|4951->3143|4979->3144|5049->3186|5078->3187|5119->3200|5148->3201|5202->3228|5230->3229|5273->3243|5303->3244|5366->3279|5395->3280|5438->3294|5468->3295|5525->3323|5555->3324|5627->3368|5656->3369|5690->3375|5719->3376|5768->3396|5798->3397|5842->3412|5872->3413|5955->3468|5984->3469|6018->3475|6047->3476|6092->3492|6122->3493|6211->3554|6240->3555|6274->3561|6303->3562|6337->3568|6366->3569|6398->3573|6427->3574|6491->3609|6521->3610|7248->4309|7277->4310|7338->4342|7368->4343|7430->4376|7460->4377|7501->4389|7531->4390|7574->4404|7604->4405|7667->4440|7696->4441|7852->4568|7882->4569|7945->4604|7974->4605|8007->4610|8036->4611|8070->4617|8099->4618|8131->4622|8160->4623|8214->4645|8252->4647|8286->4658
                    LINES: 22->1|22->1|22->1|27->6|27->6|27->6|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|57->36|57->36|62->41|62->41|64->43|64->43|67->46|67->46|69->48|69->48|71->50|71->50|73->52|73->52|76->55|76->55|78->57|78->57|81->60|81->60|83->62|83->62|101->80|101->80|103->82|103->82|104->83|104->83|112->91|112->91|115->94|115->94|117->96|117->96|118->97|118->97|120->99|120->99|121->100|121->100|123->102|123->102|124->103|124->103|126->105|126->105|128->107|128->107|129->108|129->108|130->109|130->109|131->110|131->110|134->113|134->113|135->114|135->114|136->115|136->115|139->118|139->118|140->119|140->119|141->120|141->120|142->121|142->121|144->123|144->123|160->139|160->139|162->141|162->141|163->142|163->142|164->143|164->143|165->144|165->144|167->146|167->146|171->150|171->150|173->152|173->152|174->153|174->153|175->154|175->154|176->155|176->155|179->158|180->159|180->159
=======
                    DATE: Fri Jul 15 16:01:47 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/sparksql.scala.html
                    HASH: 8badc0386630e24fd35d55645bbdac163d3ed9c4
                    MATRIX: 567->1|683->23|719->25|752->50|790->51|826->53|863->69|971->143|985->149|1033->189|1071->190|1965->1049|1998->1060|2038->1069|2071->1071
                    LINES: 19->1|22->1|23->2|23->2|23->2|24->3|24->3|28->7|28->7|28->7|28->7|52->31|52->31|54->33|55->34
>>>>>>> 6c87dee3ccd36f4abb322413020222f473a51e93
                    -- GENERATED --
                */
            