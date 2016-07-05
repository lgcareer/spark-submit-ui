
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[scala.Tuple2[String, String]],Flash,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[(String,String)])(implicit flash: Flash):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""

"""),_display_(Seq[Any](/*3.2*/plain("Neptune Login")/*3.24*/{_display_(Seq[Any](format.raw/*3.25*/("""
<div class="login-logo"><img src=""""),_display_(Seq[Any](/*4.36*/routes/*4.42*/.Assets.at("images/favicon.png"))),format.raw/*4.74*/("""" alt=""/></div>
<h2 class="form-heading"><font color="#FBFBFB">欢迎登陆 Neptune Data Platform</font></h2>
<div class="app-cam">

  """),_display_(Seq[Any](/*8.4*/helper/*8.10*/.form(routes.Authentication.authenticate)/*8.51*/{_display_(Seq[Any](format.raw/*8.52*/("""
    """),_display_(Seq[Any](/*9.6*/form/*9.10*/.globalError.map/*9.26*/ { error =>_display_(Seq[Any](format.raw/*9.37*/("""
        <p class="error">
           <font color="red">错误的用户名或密码</font>
        </p>
    """)))})),format.raw/*13.6*/("""


    """),_display_(Seq[Any](/*16.6*/if(form.hasErrors && !form.error("email").isEmpty)/*16.56*/{_display_(Seq[Any](format.raw/*16.57*/("""
    <p class="error"><font color="red">"""),_display_(Seq[Any](/*17.41*/form/*17.45*/.error("email").get.message)),format.raw/*17.72*/("""</font></p>
    """)))})),format.raw/*18.6*/("""


    """),_display_(Seq[Any](/*21.6*/flash/*21.11*/.get("success").map/*21.30*/ { message =>_display_(Seq[Any](format.raw/*21.43*/("""
        <p class="success">
           <font color="red"> """),_display_(Seq[Any](/*23.32*/message)),format.raw/*23.39*/("""</font>
        </p>
    """)))})),format.raw/*25.6*/("""


    <input type="text" name="email" class="text" value=""""),_display_(Seq[Any](/*28.58*/form("email")/*28.71*/.value)),format.raw/*28.77*/("""" placeholder="E-mail Address" onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*28.165*/("""{"""),format.raw/*28.166*/("""this.value = 'E-mail Address';"""),format.raw/*28.196*/("""}"""),format.raw/*28.197*/("""">
    <input type="password" name="password" value="Password"  onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*29.119*/("""{"""),format.raw/*29.120*/("""this.value = 'Password';"""),format.raw/*29.144*/("""}"""),format.raw/*29.145*/("""">
    <div class="submit">
      <input type="submit" id="loginbutton" value="登陆">
    </div>
    <ul class="new">
      <li class="new_left">

        <p><a href="/findpwd"><font color="#FBFBFB"> 忘记密码 ?</font></a></p>
      </li>
      <li class="new_right">
        <p class="sign"><a href="/registration"><font color="#FBFBFB">没有帐号?</font></a></p>
      </li>
      <div class="clearfix"></div>
    </ul>
""")))})),format.raw/*43.2*/("""
</div>
<div class="copy_layout login">
  <p><font color="#FBFBFB">Copyright &copy; 2016.Sina DSP All rights reserved.More Infomation 新浪微博 </font></p>
</div>
""")))})),format.raw/*48.2*/("""
"""))}
    }
    
    def render(form:Form[scala.Tuple2[String, String]],flash:Flash): play.api.templates.HtmlFormat.Appendable = apply(form)(flash)
    
    def f:((Form[scala.Tuple2[String, String]]) => (Flash) => play.api.templates.HtmlFormat.Appendable) = (form) => (flash) => apply(form)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 05 12:32:11 CST 2016
                    SOURCE: /Users/manbu/IdeaProjects/ficusspark/app/views/login.scala.html
                    HASH: 8ac1ad89e677da19baee68388b79e52962c5c4b4
                    MATRIX: 590->1|736->53|773->56|803->78|841->79|912->115|926->121|979->153|1142->282|1156->288|1205->329|1243->330|1283->336|1295->340|1319->356|1367->367|1489->458|1532->466|1591->516|1630->517|1707->558|1720->562|1769->589|1817->606|1860->614|1874->619|1902->638|1953->651|2049->711|2078->718|2135->744|2231->804|2253->817|2281->823|2398->911|2428->912|2487->942|2517->943|2667->1064|2697->1065|2750->1089|2780->1090|3221->1500|3411->1659
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|29->8|29->8|29->8|29->8|30->9|30->9|30->9|30->9|34->13|37->16|37->16|37->16|38->17|38->17|38->17|39->18|42->21|42->21|42->21|42->21|44->23|44->23|46->25|49->28|49->28|49->28|49->28|49->28|49->28|49->28|50->29|50->29|50->29|50->29|64->43|69->48
                    -- GENERATED --
                */
            