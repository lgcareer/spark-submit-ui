
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
object findpwd extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[scala.Tuple2[String, String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[(String,String)]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""


"""),_display_(Seq[Any](/*4.2*/plain("密码找回")/*4.15*/{_display_(Seq[Any](format.raw/*4.16*/("""
<div class="login-logo"><img src=""""),_display_(Seq[Any](/*5.36*/routes/*5.42*/.Assets.at("images/favicon.png"))),format.raw/*5.74*/("""" alt=""/></div>
<h2 class="form-heading"><font color="#FBFBFB" >密码找回 Neptune Data Platform</font></h2>
<div class="app-cam">

      <script type="text/javascript">
     function refresh(obj)"""),format.raw/*10.27*/("""{"""),format.raw/*10.28*/("""
          document.getElementById(obj.id).src="/captcha";
     """),format.raw/*12.6*/("""}"""),format.raw/*12.7*/("""
     </script>

    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(routes.Authentication.resetpwd)/*15.49*/{_display_(Seq[Any](format.raw/*15.50*/("""
    <input type="text" name="email" id="email" class="text" value=""""),_display_(Seq[Any](/*16.69*/form("email")/*16.82*/.value)),format.raw/*16.88*/("""" placeholder="注册邮箱"  onblur="if (this.value == '') """),format.raw/*16.140*/("""{"""),format.raw/*16.141*/("""this.value = '注册邮箱';"""),format.raw/*16.161*/("""}"""),format.raw/*16.162*/("""">
    """),_display_(Seq[Any](/*17.6*/if(form.hasErrors && !form.error("email").isEmpty)/*17.56*/{_display_(Seq[Any](format.raw/*17.57*/("""
    <p class="error"><font color="red">"""),_display_(Seq[Any](/*18.41*/form/*18.45*/.error("email").get.message)),format.raw/*18.72*/("""</font></p>
    """)))})),format.raw/*19.6*/("""

    <div>
    <input type="text"   name="captcha" class="text" placeholder="验证码"   onblur="if (this.value == '') """),format.raw/*22.104*/("""{"""),format.raw/*22.105*/("""this.value = '验证码';"""),format.raw/*22.124*/("""}"""),format.raw/*22.125*/("""">
    <img src="/captcha" id="captcha" onclick="refresh(this)"></div >


    <div class="submit">
        """),_display_(Seq[Any](/*27.10*/if(form.hasErrors && !form.error("captcha").isEmpty)/*27.62*/{_display_(Seq[Any](format.raw/*27.63*/("""
        <p class="error"><font color="red">"""),_display_(Seq[Any](/*28.45*/form/*28.49*/.error("captcha").get.message)),format.raw/*28.78*/("""</font></p>
        """)))})),format.raw/*29.10*/("""
        <input type="submit" id="loginbutton" value="发送重置密码邮件">
    </div>
    <ul class="new">
        <li class="new_left">
            <p class="sign"><a href="/login"><font color="#FBFBFB"> 返回登录</font></a></p>
        </li>
        <div class="clearfix"></div>
    </ul>
    """)))})),format.raw/*38.6*/("""
</div>
<div class="copy_layout login">
    <p><font color="#FBFBFB">Copyright &copy; 2016.Sina DSP All rights reserved.More Infomation 新浪微博 </font></p>
</div>
""")))})),format.raw/*43.2*/("""
"""))}
    }
    
    def render(form:Form[scala.Tuple2[String, String]]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[scala.Tuple2[String, String]]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 15:42:48 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/findpwd.scala.html
                    HASH: 740682097f379525e1f2af8daff199033df7402d
                    MATRIX: 586->1|709->30|747->34|768->47|806->48|877->84|891->90|944->122|1163->313|1192->314|1283->378|1311->379|1368->401|1383->407|1429->444|1468->445|1573->514|1595->527|1623->533|1704->585|1734->586|1783->606|1813->607|1856->615|1915->665|1954->666|2031->707|2044->711|2093->738|2141->755|2285->870|2315->871|2363->890|2393->891|2537->999|2598->1051|2637->1052|2718->1097|2731->1101|2782->1130|2835->1151|3147->1432|3339->1593
                    LINES: 19->1|22->1|25->4|25->4|25->4|26->5|26->5|26->5|31->10|31->10|33->12|33->12|36->15|36->15|36->15|36->15|37->16|37->16|37->16|37->16|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|43->22|43->22|43->22|43->22|48->27|48->27|48->27|49->28|49->28|49->28|50->29|59->38|64->43
                    -- GENERATED --
                */
            