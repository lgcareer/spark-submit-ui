
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
object register extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Registration],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[Registration]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.28*/("""

"""),_display_(Seq[Any](/*3.2*/plain("注册")/*3.13*/{_display_(Seq[Any](format.raw/*3.14*/("""
<div class="login-logo"><img src=""""),_display_(Seq[Any](/*4.36*/routes/*4.42*/.Assets.at("images/favicon.png"))),format.raw/*4.74*/("""" alt=""/></div>
<h2 class="form-heading"><font color="#FBFBFB">欢迎注册 Neptune Data Platform</font></h2>
<div class="app-cam">

    """),_display_(Seq[Any](/*8.6*/helper/*8.12*/.form(routes.Authentication.verifying)/*8.50*/{_display_(Seq[Any](format.raw/*8.51*/("""
    <input type="text" name="email" class="text" value=""""),_display_(Seq[Any](/*9.58*/form("email")/*9.71*/.value)),format.raw/*9.77*/("""" placeholder="请输入邮箱" onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*9.156*/("""{"""),format.raw/*9.157*/("""this.value = '请输入邮箱';"""),format.raw/*9.178*/("""}"""),format.raw/*9.179*/("""">
    """),_display_(Seq[Any](/*10.6*/if(form.hasErrors && !form.error("email").isEmpty)/*10.56*/{_display_(Seq[Any](format.raw/*10.57*/("""
        """),_display_(Seq[Any](/*11.10*/if(form.error("email").get.message.equals("error.required"))/*11.70*/{_display_(Seq[Any](format.raw/*11.71*/("""
        <font color="red">邮箱不能为空</font>
        """)))}/*13.10*/else/*13.14*/{_display_(Seq[Any](format.raw/*13.15*/("""
    <p class="error"><font color="red">"""),_display_(Seq[Any](/*14.41*/form/*14.45*/.error("email").get.message)),format.raw/*14.72*/("""</font></p>
        """)))})),format.raw/*15.10*/("""
    """)))})),format.raw/*16.6*/("""
    <input type="text" name="name" class="text" value=""""),_display_(Seq[Any](/*17.57*/form("name")/*17.69*/.value)),format.raw/*17.75*/("""" placeholder="请输入姓名" onfocus="this.value = '';" onblur="if (this.value == '') """),format.raw/*17.154*/("""{"""),format.raw/*17.155*/("""this.value = '请输入姓名';"""),format.raw/*17.176*/("""}"""),format.raw/*17.177*/("""">
    """),_display_(Seq[Any](/*18.6*/if(!form.error("name").isEmpty)/*18.37*/{_display_(Seq[Any](format.raw/*18.38*/("""
        """),_display_(Seq[Any](/*19.10*/if(form.error("name").get.message.equals("error.required"))/*19.69*/{_display_(Seq[Any](format.raw/*19.70*/("""
            <font color="red">姓名不能为空</font>
    """)))}/*21.6*/else/*21.10*/{_display_(Seq[Any](format.raw/*21.11*/("""
    <p class="error"><font color="red">"""),_display_(Seq[Any](/*22.41*/form/*22.45*/.error("name").get.message)),format.raw/*22.71*/("""</font></p>
        """)))})),format.raw/*23.10*/("""
    """)))})),format.raw/*24.6*/("""
    <input type="password" name="password"  placeholder="请输入密码" onfocus="this.value = '' onblur="if (this.value == '') """),format.raw/*25.120*/("""{"""),format.raw/*25.121*/("""this.value = '请输入密码';"""),format.raw/*25.142*/("""}"""),format.raw/*25.143*/("""">
    <input type="password" name="repassword"  placeholder="请再次确认密码" onfocus="this.value = '' onblur="if (this.value == '') """),format.raw/*26.124*/("""{"""),format.raw/*26.125*/("""this.value = '请再次输入密码';"""),format.raw/*26.148*/("""}"""),format.raw/*26.149*/("""">
    """),_display_(Seq[Any](/*27.6*/if(form.hasErrors && !form.error("repassword").isEmpty)/*27.61*/{_display_(Seq[Any](format.raw/*27.62*/("""
    """),_display_(Seq[Any](/*28.6*/if(form.error("repassword").get.message.equals("error.required"))/*28.71*/{_display_(Seq[Any](format.raw/*28.72*/("""
        <font color="red">密码不能为空</font>
    """)))}/*30.6*/else/*30.10*/{_display_(Seq[Any](format.raw/*30.11*/("""
     <p class="error"><font color="red">"""),_display_(Seq[Any](/*31.42*/form/*31.46*/.error("repassword").get.message)),format.raw/*31.78*/("""</font></p>
     """)))})),format.raw/*32.7*/("""
    """)))})),format.raw/*33.6*/("""

    """),_display_(Seq[Any](/*35.6*/if(form.hasErrors)/*35.24*/{_display_(Seq[Any](format.raw/*35.25*/("""
    """),_display_(Seq[Any](/*36.6*/form/*36.10*/.globalError.map/*36.26*/ { error =>_display_(Seq[Any](format.raw/*36.37*/("""
    <p class="error">
        <font color="red">"""),_display_(Seq[Any](/*38.28*/error/*38.33*/.message)),format.raw/*38.41*/("""</font>
    </p>
    """)))})),format.raw/*40.6*/("""
    """)))})),format.raw/*41.6*/("""
    <div class="submit">
        <input type="submit" id="loginbutton" value="注册">
    </div>

    <ul class="new">
        <li class="new_left">
            <p class="sign"><a href="/login"><font color="#FBFBFB"> 已有账号? 登录</font></a></p>
        </li>
        <div class="clearfix"></div>
    </ul>

    """)))})),format.raw/*53.6*/("""
</div class="app-cam">
<div class="copy_layout login">
    <p><font color="#FBFBFB">Copyright &copy; 2016.Sina DSP All rights reserved.More Infomation 新浪微博 </font></p>
</div>
""")))})),format.raw/*58.2*/("""
"""))}
    }
    
    def render(form:Form[Registration]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[Registration]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 16:01:47 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/register.scala.html
                    HASH: c16a493ff402e0b19bec45c3018836cbeda94f5f
                    MATRIX: 571->1|691->27|728->30|747->41|785->42|856->78|870->84|923->116|1088->247|1102->253|1148->291|1186->292|1279->350|1300->363|1327->369|1434->448|1463->449|1512->470|1541->471|1584->479|1643->529|1682->530|1728->540|1797->600|1836->601|1905->651|1918->655|1957->656|2034->697|2047->701|2096->728|2149->749|2186->755|2279->812|2300->824|2328->830|2436->909|2466->910|2516->931|2546->932|2589->940|2629->971|2668->972|2714->982|2782->1041|2821->1042|2889->1092|2902->1096|2941->1097|3018->1138|3031->1142|3079->1168|3132->1189|3169->1195|3318->1315|3348->1316|3398->1337|3428->1338|3583->1464|3613->1465|3665->1488|3695->1489|3738->1497|3802->1552|3841->1553|3882->1559|3956->1624|3995->1625|4059->1671|4072->1675|4111->1676|4189->1718|4202->1722|4256->1754|4305->1772|4342->1778|4384->1785|4411->1803|4450->1804|4491->1810|4504->1814|4529->1830|4578->1841|4664->1891|4678->1896|4708->1904|4761->1926|4798->1932|5135->2238|5343->2415
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|29->8|29->8|29->8|29->8|30->9|30->9|30->9|30->9|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|34->13|34->13|34->13|35->14|35->14|35->14|36->15|37->16|38->17|38->17|38->17|38->17|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|42->21|42->21|42->21|43->22|43->22|43->22|44->23|45->24|46->25|46->25|46->25|46->25|47->26|47->26|47->26|47->26|48->27|48->27|48->27|49->28|49->28|49->28|51->30|51->30|51->30|52->31|52->31|52->31|53->32|54->33|56->35|56->35|56->35|57->36|57->36|57->36|57->36|59->38|59->38|59->38|61->40|62->41|74->53|79->58
                    -- GENERATED --
                */
            