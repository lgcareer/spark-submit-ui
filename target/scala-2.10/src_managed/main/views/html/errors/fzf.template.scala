
package views.html.errors

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
object fzf extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="eng" lang="eng">
  <head> 
  <title>页面未找到 : 404</title>
   <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*5.54*/routes/*5.60*/.Assets.at("images/favicon.png"))),format.raw/*5.92*/("""">
   <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.49*/routes/*6.55*/.Assets.at("stylesheets/error.css"))),format.raw/*6.90*/("""" type="text/css" />
   </head> 
   <body> 
   <div class="controller">
    <div class="objects"> 
    <!-- text area -->
    <div class="text-area rotate">
    <p class="error">Error 404</p>
    <p class="details">嗯..有些不对劲..<br /><br />您访问的页面不存在！</p> 
    </div> 
    <!-- text area -->
    <!-- home page --> 
    <div class="homepage rotate">
    <a href="/">返回首页</a> 
    </div> <!-- home page --> 
    </div> <!-- social-icons --> 
 
    </div> 

</body>
</html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 06 15:28:15 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/errors/fzf.scala.html
                    HASH: b5a9ed19ac454617d1b7c3520e3e8314cd4ccebd
                    MATRIX: 642->0|962->285|976->291|1029->323|1115->374|1129->380|1185->415
                    LINES: 22->1|26->5|26->5|26->5|27->6|27->6|27->6
                    -- GENERATED --
                */
            