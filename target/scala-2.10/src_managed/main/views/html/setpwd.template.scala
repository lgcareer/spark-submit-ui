
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
object setpwd extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[scala.Tuple2[String, String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[(String,String)]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""

"""),_display_(Seq[Any](/*3.2*/plain("设置密码")/*3.15*/{_display_(Seq[Any](format.raw/*3.16*/("""
<div class="login-logo"><img src=""""),_display_(Seq[Any](/*4.36*/routes/*4.42*/.Assets.at("images/favicon.png"))),format.raw/*4.74*/("""" alt=""/></div>
<h2 class="form-heading"><font color="#FBFBFB">设置密码 Neptune Data Platform</font></h2>
<div class="app-cam">

    """),_display_(Seq[Any](/*8.6*/if(form.hasErrors)/*8.24*/{_display_(Seq[Any](format.raw/*8.25*/("""
    """),_display_(Seq[Any](/*9.6*/form/*9.10*/.globalError.map/*9.26*/ { error =>_display_(Seq[Any](format.raw/*9.37*/("""
    <p class="error">
        <font color="red">"""),_display_(Seq[Any](/*11.28*/error/*11.33*/.message)),format.raw/*11.41*/("""</font>
    </p>
    """)))})),format.raw/*13.6*/("""
    """)))})),format.raw/*14.6*/("""

    """),_display_(Seq[Any](/*16.6*/helper/*16.12*/.form(routes.Authentication.updatepwd)/*16.50*/{_display_(Seq[Any](format.raw/*16.51*/("""
    <input type="password" name="password"  placeholder="请输入密码" onfocus="this.value = '' onblur="if (this.value == '') """),format.raw/*17.120*/("""{"""),format.raw/*17.121*/("""this.value = '请输入密码';"""),format.raw/*17.142*/("""}"""),format.raw/*17.143*/("""">
    <input type="password" name="repassword"  placeholder="请再次确认密码" onfocus="this.value = '' onblur="if (this.value == '') """),format.raw/*18.124*/("""{"""),format.raw/*18.125*/("""this.value = '请再次输入密码';"""),format.raw/*18.148*/("""}"""),format.raw/*18.149*/("""">


    <div class="submit">
        <input type="submit" id="loginbutton" value="设置密码">
    </div>

    <ul class="new">
        <li class="new_left">
            <p class="sign"><a href="/login"><font color="#FBFBFB"> 已有账号? 登录</font></a></p>
        </li>
        <div class="clearfix"></div>
    </ul>

    """)))})),format.raw/*32.6*/("""
</div class="app-cam">
<div class="copy_layout login">
    <p><font color="#FBFBFB">Copyright &copy; 2016.Sina DSP All rights reserved.More Infomation 新浪微博 </font></p>
</div>
""")))})),format.raw/*37.2*/("""
"""))}
    }
    
    def render(form:Form[scala.Tuple2[String, String]]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[scala.Tuple2[String, String]]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 16:01:47 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/setpwd.scala.html
                    HASH: b294059e0e983f1ff9378ee010dbd61f3d2a8037
                    MATRIX: 585->1|708->30|745->33|766->46|804->47|875->83|889->89|942->121|1107->252|1133->270|1171->271|1211->277|1223->281|1247->297|1295->308|1381->358|1395->363|1425->371|1478->393|1515->399|1557->406|1572->412|1619->450|1658->451|1807->571|1837->572|1887->593|1917->594|2072->720|2102->721|2154->744|2184->745|2527->1057|2735->1234
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|29->8|29->8|29->8|30->9|30->9|30->9|30->9|32->11|32->11|32->11|34->13|35->14|37->16|37->16|37->16|37->16|38->17|38->17|38->17|38->17|39->18|39->18|39->18|39->18|53->32|58->37
                    -- GENERATED --
                */
            