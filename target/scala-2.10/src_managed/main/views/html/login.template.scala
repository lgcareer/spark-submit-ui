
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
"""),_display_(Seq[Any](/*2.2*/plain("Neptune Login")/*2.24*/{_display_(Seq[Any](format.raw/*2.25*/("""
<div class="login-logo"><img src=""""),_display_(Seq[Any](/*3.36*/routes/*3.42*/.Assets.at("images/favicon.png"))),format.raw/*3.74*/("""" alt=""/></div>
<h2 class="form-heading"><font color="#FBFBFB">欢迎登陆 Neptune Data Platform</font></h2>
<div class="app-cam">

  """),_display_(Seq[Any](/*7.4*/helper/*7.10*/.form(routes.Authentication.authenticate)/*7.51*/{_display_(Seq[Any](format.raw/*7.52*/("""
    """),_display_(Seq[Any](/*8.6*/form/*8.10*/.globalError.map/*8.26*/ { error =>_display_(Seq[Any](format.raw/*8.37*/("""
        <p class="error">
           <font color="red">错误的用户名或密码</font>
        </p>
    """)))})),format.raw/*12.6*/("""
    
    """),_display_(Seq[Any](/*14.6*/flash/*14.11*/.get("success").map/*14.30*/ { message =>_display_(Seq[Any](format.raw/*14.43*/("""
        <p class="success">
           <font color="red"> """),_display_(Seq[Any](/*16.32*/message)),format.raw/*16.39*/("""</font>
        </p>
    """)))})),format.raw/*18.6*/("""
    <input type="text" name="email" class="text" value=""""),_display_(Seq[Any](/*19.58*/form("email")/*19.71*/.value)),format.raw/*19.77*/("""" placeholder="E-mail Address" onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*19.165*/("""{"""),format.raw/*19.166*/("""this.value = 'E-mail Address';"""),format.raw/*19.196*/("""}"""),format.raw/*19.197*/("""">
    <input type="password" name="password" value="Password"  onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*20.119*/("""{"""),format.raw/*20.120*/("""this.value = 'Password';"""),format.raw/*20.144*/("""}"""),format.raw/*20.145*/("""">
    <div class="submit">
      <input type="submit" id="loginbutton" value="登陆">
    </div>
    <ul class="new">
      <li class="new_left">
        <p><a href="#"><font color="#FBFBFB"> 忘记密码 ?</font></a></p>
      </li>
      <li class="new_right">
        <p class="sign"><a href="register.html"><font color="#FBFBFB">没有帐号?</font></a></p>
      </li>
      <div class="clearfix"></div>
    </ul>
""")))})),format.raw/*33.2*/("""
</div>
<div class="copy_layout login">
  <p><font color="#FBFBFB">Copyright &copy; 2016.Sina DSP All rights reserved.More Infomation 新浪微博 </font></p>
</div>
""")))})),format.raw/*38.2*/("""
"""))}
    }
    
    def render(form:Form[scala.Tuple2[String, String]],flash:Flash): play.api.templates.HtmlFormat.Appendable = apply(form)(flash)
    
    def f:((Form[scala.Tuple2[String, String]]) => (Flash) => play.api.templates.HtmlFormat.Appendable) = (form) => (flash) => apply(form)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 21 12:18:17 CST 2016
                    SOURCE: /Users/manbu/Desktop/ficusspark/app/views/login.scala.html
                    HASH: a03183ce8c5689b73d75be7247a82add14b5387f
                    MATRIX: 590->1|736->53|772->55|802->77|840->78|911->114|925->120|978->152|1141->281|1155->287|1204->328|1242->329|1282->335|1294->339|1318->355|1366->366|1488->457|1534->468|1548->473|1576->492|1627->505|1723->565|1752->572|1809->598|1903->656|1925->669|1953->675|2070->763|2100->764|2159->794|2189->795|2339->916|2369->917|2422->941|2452->942|2885->1344|3075->1503
                    LINES: 19->1|22->1|23->2|23->2|23->2|24->3|24->3|24->3|28->7|28->7|28->7|28->7|29->8|29->8|29->8|29->8|33->12|35->14|35->14|35->14|35->14|37->16|37->16|39->18|40->19|40->19|40->19|40->19|40->19|40->19|40->19|41->20|41->20|41->20|41->20|54->33|59->38
                    -- GENERATED --
                */
            