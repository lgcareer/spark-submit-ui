
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
<div id="wrapper">
<!-- Navigation -->
<nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
    <a class="navbar-brand" href=""""),_display_(Seq[Any](/*35.36*/routes/*35.42*/.Assets.at("/"))),format.raw/*35.57*/("""">Neptune Data Platform</a> </div>
  <!-- /.navbar-header -->
  <ul class="nav navbar-nav navbar-right">
    <li class="dropdown"> <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src=""""),_display_(Seq[Any](/*38.104*/routes/*38.110*/.Assets.at("images/favicon.png"))),format.raw/*38.142*/(""""><span class="badge">0</span></a>
      <ul class="dropdown-menu">
        <li class="dropdown-menu-header text-center"> <strong>账户信息</strong> </li>
        <li class="m_2"><a href="#"><i class="fa fa-envelope-o"></i> 信息 <span class="label label-success">0</span></a></li>
        <li class="m_2"><a href="#"><i class="fa fa-tasks"></i> App状态 <span class="label label-danger">0</span></a></li>
        <li class="m_2"><a href="#"><i class="fa fa-user"></i> 个性化</a></li>
        <li class="m_2"><a href="#"><i class="fa fa-wrench"></i> 设置</a></li>
        <li class="m_2"><a href="#"><i class="fa fa-usd"></i> Payments <span class="label label-default">0</span></a></li>
        <li class="m_2"><a href="#"><i class="fa fa-file"></i> 任务列表 <span class="label label-primary">0</span></a></li>
        <li class="divider"></li>
        <li class="m_2"><a href=""""),_display_(Seq[Any](/*48.35*/routes/*48.41*/.Authentication.logout)),format.raw/*48.63*/(""""><i class="fa fa-lock"></i> 退出</a></li>
      </ul>
    </li>
  </ul>
  <form class="navbar-form navbar-right">
    <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*53.120*/("""{"""),format.raw/*53.121*/("""this.value = 'Search...';"""),format.raw/*53.146*/("""}"""),format.raw/*53.147*/("""">
  </form>
  <div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
      <ul class="nav" id="side-menu">
        <li> <a href=""""),_display_(Seq[Any](/*58.24*/routes/*58.30*/.Application.index)),format.raw/*58.48*/(""""><i class="fa fa-dashboard fa-fw nav_icon"></i>仪表盘</a> </li>
        <li> <a href="#"><i class="fa fa-check-square-o nav_icon"></i>数据应用面板<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*61.28*/routes/*61.34*/.SparkJar.uploadpage)),format.raw/*61.54*/("""">spark-jar应用</a></li>
            <li> <a href=""""),_display_(Seq[Any](/*62.28*/routes/*62.34*/.SparkSql.sqlpage)),format.raw/*62.51*/("""">spark-sql应用</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*63.28*/routes/*63.34*/.SparkStream.stream)),format.raw/*63.53*/("""">spark-stream基于HDFS的应用</a></li>
            <li> <a href=""""),_display_(Seq[Any](/*64.28*/routes/*64.34*/.SparkStream.stream)),format.raw/*64.53*/("""">spark-stream基于Kafka的应用</a></li>
          </ul>
          <!-- /.nav-second-level --> 
        </li>
        <li> <a href="#"><i class="fa fa-table nav_icon"></i>App数据<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*70.28*/routes/*70.34*/.YarnList.yarnlist)),format.raw/*70.52*/("""">Yarn数据列表</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*71.28*/routes/*71.34*/.YarnList.sparklist)),format.raw/*71.53*/("""">Spark数据列表</a> </li>
          </ul>
          <!-- /.nav-second-level --> 
        </li>

         <li> <a href="#"><i class="fa fa-table nav_icon"></i>任务调度<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*78.28*/routes/*78.34*/.YarnList.yarnlist)),format.raw/*78.52*/("""">OOZIE任务调度</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*79.28*/routes/*79.34*/.YarnList.yarnlist)),format.raw/*79.52*/("""">Spark任务调度</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*80.28*/routes/*80.34*/.YarnList.sparklist)),format.raw/*80.53*/("""">Yarn任务调度</a> </li>
          </ul>
        </li>

           <li> <a href="#"><i class="fa fa-table nav_icon"></i>监控和报警<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*86.28*/routes/*86.34*/.YarnList.yarnlist)),format.raw/*86.52*/("""">Streaming监控</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*87.28*/routes/*87.34*/.YarnList.yarnlist)),format.raw/*87.52*/("""">临时任务监控</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*88.28*/routes/*88.34*/.YarnList.sparklist)),format.raw/*88.53*/("""">调度监控</a> </li>
          </ul>
        </li>

               <li> <a href="#"><i class="fa fa-table nav_icon"></i>报警管理<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*94.28*/routes/*94.34*/.YarnList.yarnlist)),format.raw/*94.52*/("""">磁盘空间报警</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*95.28*/routes/*95.34*/.YarnList.yarnlist)),format.raw/*95.52*/("""">内存相关报警</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*96.28*/routes/*96.34*/.YarnList.sparklist)),format.raw/*96.53*/("""">其他报警</a> </li>
          </ul>

        <li> <a href="#"><i class="fa fa-table nav_icon"></i>用户管理<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*101.28*/routes/*101.34*/.YarnList.yarnlist)),format.raw/*101.52*/("""">用户统计</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*102.28*/routes/*102.34*/.YarnList.yarnlist)),format.raw/*102.52*/("""">添加用户</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*103.28*/routes/*103.34*/.YarnList.sparklist)),format.raw/*103.53*/("""">权限分配</a> </li>
          </ul>

        </li>

                <li> <a href="#"><i class="fa fa-table nav_icon"></i>节点分布情况<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li> <a href=""""),_display_(Seq[Any](/*110.28*/routes/*110.34*/.YarnList.yarnlist)),format.raw/*110.52*/("""">服务划分</a> </li>
            <li> <a href=""""),_display_(Seq[Any](/*111.28*/routes/*111.34*/.YarnList.yarnlist)),format.raw/*111.52*/("""">功能划分</a> </li>
          </ul>

        </li>

      </ul>
    </div>
    <!-- /.sidebar-collapse --> 
  </div>
  <!-- /.navbar-static-side --> 
</nav>
<div id="page-wrapper">
"""),_display_(Seq[Any](/*123.2*/content)),format.raw/*123.9*/("""
</div>
<!-- /#wrapper --> 
<!-- Bootstrap Core JavaScript --> 
<script src=""""),_display_(Seq[Any](/*127.15*/routes/*127.21*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*127.63*/(""""></script>
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
                    DATE: Thu Jun 30 14:55:01 CST 2016
                    SOURCE: /Users/manbu/Desktop/ficusspark/app/views/main.scala.html
                    HASH: 8a64ee5a5cefe2404001b05e15b5883a5b30de61
                    MATRIX: 565->1|714->56|787->95|813->100|907->159|921->165|974->197|1151->340|1178->347|1284->425|1313->426|1370->454|1400->455|1460->486|1490->487|1542->510|1572->511|1660->563|1675->569|1740->612|1847->683|1862->689|1918->723|2024->793|2039->799|2096->834|2183->885|2198->891|2262->933|2348->983|2363->989|2424->1028|2502->1070|2517->1076|2575->1112|2683->1184|2698->1190|2762->1232|2824->1258|2839->1264|2896->1299|2984->1351|2999->1357|3055->1391|3117->1417|3132->1423|3191->1460|3713->1946|3728->1952|3765->1967|4010->2175|4026->2181|4081->2213|4976->3072|4991->3078|5035->3100|5296->3332|5326->3333|5380->3358|5410->3359|5623->3536|5638->3542|5678->3560|5958->3804|5973->3810|6015->3830|6101->3880|6116->3886|6155->3903|6242->3954|6257->3960|6298->3979|6394->4039|6409->4045|6450->4064|6761->4339|6776->4345|6816->4363|6900->4411|6915->4417|6956->4436|7256->4700|7271->4706|7311->4724|7396->4773|7411->4779|7451->4797|7536->4846|7551->4852|7592->4871|7855->5098|7870->5104|7910->5122|7997->5173|8012->5179|8052->5197|8134->5243|8149->5249|8190->5268|8454->5496|8469->5502|8509->5520|8591->5566|8606->5572|8646->5590|8728->5636|8743->5642|8784->5661|9026->5866|9042->5872|9083->5890|9164->5934|9180->5940|9221->5958|9302->6002|9318->6008|9360->6027|9627->6257|9643->6263|9684->6281|9765->6325|9781->6331|9822->6349|10037->6528|10066->6535|10181->6613|10197->6619|10262->6661
                    LINES: 19->1|22->1|26->5|26->5|27->6|27->6|27->6|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|31->10|31->10|33->12|33->12|33->12|35->14|35->14|35->14|37->16|37->16|37->16|38->17|38->17|38->17|40->19|40->19|40->19|42->21|42->21|42->21|44->23|44->23|44->23|45->24|45->24|45->24|47->26|47->26|47->26|48->27|48->27|48->27|56->35|56->35|56->35|59->38|59->38|59->38|69->48|69->48|69->48|74->53|74->53|74->53|74->53|79->58|79->58|79->58|82->61|82->61|82->61|83->62|83->62|83->62|84->63|84->63|84->63|85->64|85->64|85->64|91->70|91->70|91->70|92->71|92->71|92->71|99->78|99->78|99->78|100->79|100->79|100->79|101->80|101->80|101->80|107->86|107->86|107->86|108->87|108->87|108->87|109->88|109->88|109->88|115->94|115->94|115->94|116->95|116->95|116->95|117->96|117->96|117->96|122->101|122->101|122->101|123->102|123->102|123->102|124->103|124->103|124->103|131->110|131->110|131->110|132->111|132->111|132->111|144->123|144->123|148->127|148->127|148->127
                    -- GENERATED --
                */
            