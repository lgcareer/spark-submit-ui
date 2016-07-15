
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
object registed extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(result:Option[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.25*/("""

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册结果</title>
</head>
<body>
    """),_display_(Seq[Any](/*10.6*/if(!result.isEmpty)/*10.25*/{_display_(Seq[Any](format.raw/*10.26*/("""
     <p>"""),_display_(Seq[Any](/*11.10*/result/*11.16*/.get)),format.raw/*11.20*/("""</p>
    """)))})),format.raw/*12.6*/("""
</body>
</html>"""))}
    }
    
    def render(result:Option[String]): play.api.templates.HtmlFormat.Appendable = apply(result)
    
    def f:((Option[String]) => play.api.templates.HtmlFormat.Appendable) = (result) => apply(result)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 10:42:00 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/registed.scala.html
                    HASH: e026361f07ecf94e6e36f2074373cb30c9d8a4f0
                    MATRIX: 567->1|684->24|832->137|860->156|899->157|945->167|960->173|986->177|1027->187
                    LINES: 19->1|22->1|31->10|31->10|31->10|32->11|32->11|32->11|33->12
                    -- GENERATED --
                */
            