
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String,scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.57*/("""
<!DOCTYPE HTML>
<html>
<head>
<title>"""),_display_(Seq[Any](/*5.9*/title)),format.raw/*5.14*/("""</title>
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.51*/routes/*6.57*/.Assets.at("images/favicon.png"))),format.raw/*6.89*/("""">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
"""),_display_(Seq[Any](/*9.2*/scripts)),format.raw/*9.9*/("""
<script type="application/x-javascript"> addEventListener("load", function() """),format.raw/*10.78*/("""{"""),format.raw/*10.79*/(""" setTimeout(hideURLbar, 0); """),format.raw/*10.107*/("""}"""),format.raw/*10.108*/(""", false); function hideURLbar()"""),format.raw/*10.139*/("""{"""),format.raw/*10.140*/(""" window.scrollTo(0,1); """),format.raw/*10.163*/("""}"""),format.raw/*10.164*/(""" </script>
<!-- Bootstrap Core CSS -->
<link href=""""),_display_(Seq[Any](/*12.14*/routes/*12.20*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*12.63*/("""" rel="stylesheet" type="text/css" />
<!-- Custom CSS -->
<link href=""""),_display_(Seq[Any](/*14.14*/routes/*14.20*/.Assets.at("stylesheets/main.css"))),format.raw/*14.54*/("""" rel="stylesheet" type="text/css" />
<!-- Graph CSS -->
<link href=""""),_display_(Seq[Any](/*16.14*/routes/*16.20*/.Assets.at("stylesheets/lines.css"))),format.raw/*16.55*/("""" rel="stylesheet" type="text/css" />
<link href=""""),_display_(Seq[Any](/*17.14*/routes/*17.20*/.Assets.at("stylesheets/font-awesome.css"))),format.raw/*17.62*/("""" rel="stylesheet">
<!-- jQuery
<script src=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Assets.at("javascripts/jquery.min.js"))),format.raw/*19.60*/(""""></script>
 -->
<script src=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("javascripts/jquery-1.11.1.min.js"))),format.raw/*21.67*/(""""></script>
<!-- Nav CSS -->
<link href=""""),_display_(Seq[Any](/*23.14*/routes/*23.20*/.Assets.at("stylesheets/custom.css"))),format.raw/*23.56*/("""" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src=""""),_display_(Seq[Any](/*25.15*/routes/*25.21*/.Assets.at("javascripts/metisMenu.min.js"))),format.raw/*25.63*/(""""></script>
<script src=""""),_display_(Seq[Any](/*26.15*/routes/*26.21*/.Assets.at("javascripts/custom.js"))),format.raw/*26.56*/(""""></script>
<!-- Graph JavaScript -->
<script src=""""),_display_(Seq[Any](/*28.15*/routes/*28.21*/.Assets.at("javascripts/d3.v3.js"))),format.raw/*28.55*/(""""></script>
<script src=""""),_display_(Seq[Any](/*29.15*/routes/*29.21*/.Assets.at("javascripts/rickshaw.js"))),format.raw/*29.58*/(""""></script>
</head>
<body>
<div id="wrapper">
<!-- Navigation -->
<nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
    <a class="navbar-brand" href=""""),_display_(Seq[Any](/*37.36*/routes/*37.42*/.Assets.at("/"))),format.raw/*37.57*/("""">Neptune Data Platform</a> </div>
  <!-- /.navbar-header -->
  <ul class="nav navbar-nav navbar-right">
    <li class="dropdown"> <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src=""""),_display_(Seq[Any](/*40.104*/routes/*40.110*/.Assets.at("images/favicon.png"))),format.raw/*40.142*/(""""><span class="badge">0</span></a>
      <ul class="dropdown-menu">
        <li class="dropdown-menu-header text-center"> <strong>账户信息</strong> </li>
        <li class="m_2"><a href="#"><i class="fa fa-envelope-o"></i> 信息 <span class="label label-success">0</span></a></li>
        <li class="m_2"><a href="#"><i class="fa fa-tasks"></i> App状态 <span class="label label-danger">0</span></a></li>
        <li class="m_2"><a href="#"><i class="fa fa-user"></i> 个性化</a></li>
        <li class="m_2"><a href="#"><i class="fa fa-wrench"></i> 设置</a></li>
        <li class="m_2"><a href="#"><i class="fa fa-usd"></i> Payments <span class="label label-default">0</span></a></li>
        <li class="m_2"><a href="#"><i class="fa fa-file"></i> 任务列表 <span class="label label-primary">0</span></a></li>
        <li class="divider"></li>
        <li class="m_2"><a href=""""),_display_(Seq[Any](/*50.35*/routes/*50.41*/.Authentication.logout)),format.raw/*50.63*/(""""><i class="fa fa-lock"></i> 退出</a></li>
      </ul>
    </li>
  </ul>
  <form class="navbar-form navbar-right">
    <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*55.120*/("""{"""),format.raw/*55.121*/("""this.value = 'Search...';"""),format.raw/*55.146*/("""}"""),format.raw/*55.147*/("""">
  </form>
  <div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
      <ul class="nav" id="side-menu">
        <li> <a href=""""),_display_(Seq[Any](/*60.24*/routes/*60.30*/.Application.index)),format.raw/*60.48*/(""""><i class="fa fa-dashboard fa-fw nav_icon"></i>仪表盘</a> </li>
        <li> <a href="#"><i class="fa fa-check-square-o nav_icon"></i>数据应用面板<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*63.28*/routes/*63.34*/.SparkJar.uploadpage)),format.raw/*63.54*/("""">spark-jar应用</a></li>
            <li> <a href=""""),_display_(Seq[Any](/*64.28*/routes/*64.34*/.SparkSql.sqlpage)),format.raw/*64.51*/("""">spark-sql应用</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*65.28*/routes/*65.34*/.SparkStream.stream)),format.raw/*65.53*/("""">spark-stream基于HDFS的应用</a></li>
            <li> <a href=""""),_display_(Seq[Any](/*66.28*/routes/*66.34*/.SparkStream.stream)),format.raw/*66.53*/("""">spark-stream基于Kafka的应用</a></li>
          </ul>
          <!-- /.nav-second-level --> 
        </li>
        <li> <a href="#"><i class="fa fa-table nav_icon"></i>App数据<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*72.28*/routes/*72.34*/.YarnList.yarnlist)),format.raw/*72.52*/("""">Yarn数据列表</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*73.28*/routes/*73.34*/.YarnList.sparklist)),format.raw/*73.53*/("""">Spark数据列表</a> </li>
          </ul>
          <!-- /.nav-second-level --> 
        </li>

         <li> <a href="#"><i class="fa fa-table nav_icon"></i>任务调度<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*80.28*/routes/*80.34*/.YarnList.yarnlist)),format.raw/*80.52*/("""">OOZIE任务调度</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*81.28*/routes/*81.34*/.YarnList.yarnlist)),format.raw/*81.52*/("""">Spark任务调度</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*82.28*/routes/*82.34*/.YarnList.sparklist)),format.raw/*82.53*/("""">Yarn任务调度</a> </li>
          </ul>
        </li>

           <li> <a href="#"><i class="fa fa-table nav_icon"></i>监控和报警<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*88.28*/routes/*88.34*/.MonitorController.streaming)),format.raw/*88.62*/("""">Streaming监控</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*89.28*/routes/*89.34*/.MonitorController.jobs)),format.raw/*89.57*/("""">临时任务监控</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*90.28*/routes/*90.34*/.YarnList.sparklist)),format.raw/*90.53*/("""">调度监控</a> </li>
           </ul>
           </li>

           <li> <a href="#"><i class="fa fa-table nav_icon"></i>报警管理<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*96.28*/routes/*96.34*/.YarnList.yarnlist)),format.raw/*96.52*/("""">磁盘空间报警</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*97.28*/routes/*97.34*/.YarnList.yarnlist)),format.raw/*97.52*/("""">内存相关报警</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*98.28*/routes/*98.34*/.YarnList.sparklist)),format.raw/*98.53*/("""">其他报警</a> </li>
          </ul>

        <li> <a href="#"><i class="fa fa-table nav_icon"></i>用户管理<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*103.28*/routes/*103.34*/.YarnList.yarnlist)),format.raw/*103.52*/("""">用户统计</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*104.28*/routes/*104.34*/.YarnList.yarnlist)),format.raw/*104.52*/("""">添加用户</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*105.28*/routes/*105.34*/.YarnList.sparklist)),format.raw/*105.53*/("""">权限分配</a> </li>
          </ul>

        </li>

           <li> <a href="#"><i class="fa fa-table nav_icon"></i>节点分布情况<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*112.28*/routes/*112.34*/.Serviceplan.serviceplan)),format.raw/*112.58*/("""">服务划分</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*113.28*/routes/*113.34*/.Serviceplan.functionplan)),format.raw/*113.59*/("""">功能划分</a> </li>
          </ul>

        </li>
          <!-- /.nav-second-level --> 
        </li>
      </ul>
    </div>
    <!-- /.sidebar-collapse --> 
  </div>
  <!-- /.navbar-static-side --> 
</nav>
<div id="page-wrapper">
"""),_display_(Seq[Any](/*126.2*/content)),format.raw/*126.9*/("""
</div>
<!-- /#wrapper --> 
<!-- Bootstrap Core JavaScript --> 
<script src=""""),_display_(Seq[Any](/*130.15*/routes/*130.21*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*130.63*/(""""></script>
</body>
</html>
"""))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
<<<<<<< HEAD
                    DATE: Thu Jul 21 17:54:20 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/main.scala.html
                    HASH: b23dcd4bd35fe8f5c72a4b9978acd450a03dbfbd
                    MATRIX: 565->1|714->56|787->95|813->100|907->159|921->165|974->197|1151->340|1178->347|1284->425|1313->426|1370->454|1400->455|1460->486|1490->487|1542->510|1572->511|1660->563|1675->569|1740->612|1847->683|1862->689|1918->723|2024->793|2039->799|2096->834|2183->885|2198->891|2262->933|2344->979|2359->985|2420->1024|2487->1055|2502->1061|2570->1107|2648->1149|2663->1155|2721->1191|2829->1263|2844->1269|2908->1311|2970->1337|2985->1343|3042->1378|3130->1430|3145->1436|3201->1470|3263->1496|3278->1502|3337->1539|3859->2025|3874->2031|3911->2046|4156->2254|4172->2260|4227->2292|5122->3151|5137->3157|5181->3179|5442->3411|5472->3412|5526->3437|5556->3438|5769->3615|5784->3621|5824->3639|6104->3883|6119->3889|6161->3909|6247->3959|6262->3965|6301->3982|6388->4033|6403->4039|6444->4058|6540->4118|6555->4124|6596->4143|6907->4418|6922->4424|6962->4442|7046->4490|7061->4496|7102->4515|7402->4779|7417->4785|7457->4803|7542->4852|7557->4858|7597->4876|7682->4925|7697->4931|7738->4950|8001->5177|8016->5183|8066->5211|8153->5262|8168->5268|8213->5291|8295->5337|8310->5343|8351->5362|8615->5590|8630->5596|8670->5614|8752->5660|8767->5666|8807->5684|8889->5730|8904->5736|8945->5755|9187->5960|9203->5966|9244->5984|9325->6028|9341->6034|9382->6052|9463->6096|9479->6102|9521->6121|9783->6346|9799->6352|9846->6376|9927->6420|9943->6426|9991->6451|10258->6682|10287->6689|10402->6767|10418->6773|10483->6815
                    LINES: 19->1|22->1|26->5|26->5|27->6|27->6|27->6|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|31->10|31->10|33->12|33->12|33->12|35->14|35->14|35->14|37->16|37->16|37->16|38->17|38->17|38->17|40->19|40->19|40->19|42->21|42->21|42->21|44->23|44->23|44->23|46->25|46->25|46->25|47->26|47->26|47->26|49->28|49->28|49->28|50->29|50->29|50->29|58->37|58->37|58->37|61->40|61->40|61->40|71->50|71->50|71->50|76->55|76->55|76->55|76->55|81->60|81->60|81->60|84->63|84->63|84->63|85->64|85->64|85->64|86->65|86->65|86->65|87->66|87->66|87->66|93->72|93->72|93->72|94->73|94->73|94->73|101->80|101->80|101->80|102->81|102->81|102->81|103->82|103->82|103->82|109->88|109->88|109->88|110->89|110->89|110->89|111->90|111->90|111->90|117->96|117->96|117->96|118->97|118->97|118->97|119->98|119->98|119->98|124->103|124->103|124->103|125->104|125->104|125->104|126->105|126->105|126->105|133->112|133->112|133->112|134->113|134->113|134->113|147->126|147->126|151->130|151->130|151->130
=======
                    DATE: Fri Jul 15 16:01:47 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/main.scala.html
                    HASH: 198c5f1152e32e2308646b1fe7401cdf11a3c572
                    MATRIX: 565->1|714->56|787->95|813->100|907->159|921->165|974->197|1151->340|1178->347|1284->425|1313->426|1370->454|1400->455|1460->486|1490->487|1542->510|1572->511|1660->563|1675->569|1740->612|1847->683|1862->689|1918->723|2024->793|2039->799|2096->834|2183->885|2198->891|2262->933|2348->983|2363->989|2424->1028|2502->1070|2517->1076|2575->1112|2683->1184|2698->1190|2762->1232|2824->1258|2839->1264|2896->1299|2984->1351|2999->1357|3055->1391|3117->1417|3132->1423|3191->1460|3713->1946|3728->1952|3765->1967|4010->2175|4026->2181|4081->2213|4976->3072|4991->3078|5035->3100|5296->3332|5326->3333|5380->3358|5410->3359|5623->3536|5638->3542|5678->3560|5958->3804|5973->3810|6015->3830|6101->3880|6116->3886|6155->3903|6242->3954|6257->3960|6298->3979|6394->4039|6409->4045|6450->4064|6761->4339|6776->4345|6816->4363|6900->4411|6915->4417|6956->4436|7256->4700|7271->4706|7311->4724|7396->4773|7411->4779|7451->4797|7536->4846|7551->4852|7592->4871|7855->5098|7870->5104|7920->5132|8007->5183|8022->5189|8067->5212|8149->5258|8164->5264|8205->5283|8469->5511|8484->5517|8524->5535|8606->5581|8621->5587|8661->5605|8743->5651|8758->5657|8799->5676|9041->5881|9057->5887|9098->5905|9179->5949|9195->5955|9236->5973|9317->6017|9333->6023|9375->6042|9637->6267|9653->6273|9694->6291|9775->6335|9791->6341|9832->6359|10099->6590|10128->6597|10243->6675|10259->6681|10324->6723
                    LINES: 19->1|22->1|26->5|26->5|27->6|27->6|27->6|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|31->10|31->10|33->12|33->12|33->12|35->14|35->14|35->14|37->16|37->16|37->16|38->17|38->17|38->17|40->19|40->19|40->19|42->21|42->21|42->21|44->23|44->23|44->23|45->24|45->24|45->24|47->26|47->26|47->26|48->27|48->27|48->27|56->35|56->35|56->35|59->38|59->38|59->38|69->48|69->48|69->48|74->53|74->53|74->53|74->53|79->58|79->58|79->58|82->61|82->61|82->61|83->62|83->62|83->62|84->63|84->63|84->63|85->64|85->64|85->64|91->70|91->70|91->70|92->71|92->71|92->71|99->78|99->78|99->78|100->79|100->79|100->79|101->80|101->80|101->80|107->86|107->86|107->86|108->87|108->87|108->87|109->88|109->88|109->88|115->94|115->94|115->94|116->95|116->95|116->95|117->96|117->96|117->96|122->101|122->101|122->101|123->102|123->102|123->102|124->103|124->103|124->103|131->110|131->110|131->110|132->111|132->111|132->111|145->124|145->124|149->128|149->128|149->128
>>>>>>> 6c87dee3ccd36f4abb322413020222f473a51e93
                    -- GENERATED --
                */
            