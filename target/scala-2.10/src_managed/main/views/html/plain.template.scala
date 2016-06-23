
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
object plain extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE HTML>
<html>
<head>
<title>"""),_display_(Seq[Any](/*6.9*/title)),format.raw/*6.14*/("""</title>
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*7.51*/routes/*7.57*/.Assets.at("images/favicon.png"))),format.raw/*7.89*/("""">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() """),format.raw/*10.78*/("""{"""),format.raw/*10.79*/(""" setTimeout(hideURLbar, 0); """),format.raw/*10.107*/("""}"""),format.raw/*10.108*/(""", false); function hideURLbar()"""),format.raw/*10.139*/("""{"""),format.raw/*10.140*/(""" window.scrollTo(0,1); """),format.raw/*10.163*/("""}"""),format.raw/*10.164*/(""" </script>
<!-- Bootstrap Core CSS -->
<link href=""""),_display_(Seq[Any](/*12.14*/routes/*12.20*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*12.63*/("""" rel="stylesheet" type="text/css" />
<!-- Custom CSS -->
<link href=""""),_display_(Seq[Any](/*14.14*/routes/*14.20*/.Assets.at("stylesheets/main.css"))),format.raw/*14.54*/("""" rel="stylesheet" type="text/css" />
<!-- Graph CSS -->
<link href=""""),_display_(Seq[Any](/*16.14*/routes/*16.20*/.Assets.at("stylesheets/lines.css"))),format.raw/*16.55*/("""" rel="stylesheet" type="text/css" />
<link href=""""),_display_(Seq[Any](/*17.14*/routes/*17.20*/.Assets.at("stylesheets/font-awesome.css"))),format.raw/*17.62*/("""" rel="stylesheet">
<!-- jQuery -->
<script src=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Assets.at("javascripts/jquery.min.js"))),format.raw/*19.60*/(""""></script>
<!-- Nav CSS -->
<link href=""""),_display_(Seq[Any](/*21.14*/routes/*21.20*/.Assets.at("stylesheets/custom.css"))),format.raw/*21.56*/("""" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src=""""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("javascripts/metisMenu.min.js"))),format.raw/*23.63*/(""""></script>
<script src=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("javascripts/custom.js"))),format.raw/*24.56*/(""""></script>
<!-- Graph JavaScript -->
<script src=""""),_display_(Seq[Any](/*26.15*/routes/*26.21*/.Assets.at("javascripts/d3.v3.js"))),format.raw/*26.55*/(""""></script>
<script src=""""),_display_(Seq[Any](/*27.15*/routes/*27.21*/.Assets.at("javascripts/rickshaw.js"))),format.raw/*27.58*/(""""></script>
</head>
<body>
"""),_display_(Seq[Any](/*30.2*/content)),format.raw/*30.9*/("""
</body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 14 17:32:38 CST 2016
                    SOURCE: /Users/manbu/Desktop/ficusspark/app/views/plain.scala.html
                    HASH: 429414fdf3e84897c32172d9081d65cf6df53cba
                    MATRIX: 561->1|685->31|759->71|785->76|879->135|893->141|946->173|1193->392|1222->393|1279->421|1309->422|1369->453|1399->454|1451->477|1481->478|1569->530|1584->536|1649->579|1756->650|1771->656|1827->690|1933->760|1948->766|2005->801|2092->852|2107->858|2171->900|2257->950|2272->956|2333->995|2411->1037|2426->1043|2484->1079|2592->1151|2607->1157|2671->1199|2733->1225|2748->1231|2805->1266|2893->1318|2908->1324|2964->1358|3026->1384|3041->1390|3100->1427|3163->1455|3191->1462
                    LINES: 19->1|22->1|27->6|27->6|28->7|28->7|28->7|31->10|31->10|31->10|31->10|31->10|31->10|31->10|31->10|33->12|33->12|33->12|35->14|35->14|35->14|37->16|37->16|37->16|38->17|38->17|38->17|40->19|40->19|40->19|42->21|42->21|42->21|44->23|44->23|44->23|45->24|45->24|45->24|47->26|47->26|47->26|48->27|48->27|48->27|51->30|51->30
                    -- GENERATED --
                */
            