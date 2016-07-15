
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
object confirm extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.18*/("""
<script type="text/javascript">

  function getConfirmation()"""),format.raw/*4.29*/("""{"""),format.raw/*4.30*/("""
             var retVal = confirm(""""),_display_(Seq[Any](/*5.37*/message)),format.raw/*5.44*/("""");
             if( retVal == true )"""),format.raw/*6.34*/("""{"""),format.raw/*6.35*/("""
                return true;
             """),format.raw/*8.14*/("""}"""),format.raw/*8.15*/("""
             else"""),format.raw/*9.18*/("""{"""),format.raw/*9.19*/("""
               return false;
             """),format.raw/*11.14*/("""}"""),format.raw/*11.15*/("""
          """),format.raw/*12.11*/("""}"""),format.raw/*12.12*/("""

</script>
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 15 15:42:48 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/confirm.scala.html
                    HASH: 3c3f50a4acc472e0472da1b939d0920bdc3272cf
                    MATRIX: 558->1|668->17|757->79|785->80|857->117|885->124|949->161|977->162|1047->205|1075->206|1120->224|1148->225|1219->268|1248->269|1287->280|1316->281
                    LINES: 19->1|22->1|25->4|25->4|26->5|26->5|27->6|27->6|29->8|29->8|30->9|30->9|32->11|32->11|33->12|33->12
                    -- GENERATED --
                */
            