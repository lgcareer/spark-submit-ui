package models.Mail

import java.text.SimpleDateFormat
import java.util.Date

import models.User
import models.utils.MD5Utils
import org.apache.commons.lang3.StringUtils
import org.apache.commons.mail.{DefaultAuthenticator, HtmlEmail, SimpleEmail}

/**
  * Created by liangkai on 16/6/16.
  */
object RegisterWithEmail {
  val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd H:m")
    /**
      * 发送纯文本邮件
      *
      * @return
      */
    val sendTextMail =textMail _

      def textMail(): String ={
          val email = new SimpleEmail()
          email.setHostName("smtp.sina.com")
          email.setSmtpPort(25)
          email.setAuthenticator(new DefaultAuthenticator("server_noreplay@sina.com", "adminadmin"))
          email.setSSLOnConnect(true)
          email.setFrom("server_noreplay@sina.com")
          email.setSubject("NEPTUNE DATA PLATFORM注册激活")
          email.setMsg("This is a test mail ... :-)")
          email.addTo("444517160@qq.com")
          email.send()
        }

    /**
    * 发送Html邮件
    * @return
    */
  def sendHtmlMail(user:User):String={
      // Create the email message
      val email = new HtmlEmail()
      email.setHostName("smtp.sina.com")
      email.setSmtpPort(25)
      email.setAuthenticator(new DefaultAuthenticator("server_noreplay@sina.com", "adminadmin"))
      email.setSSLOnConnect(true)
      email.setFrom("server_noreplay@sina.com", "新浪微博")
      email.setSubject("NEPTUNE DATA PLATFORM注册激活")
       email.setHtmlMsg(makeEmail(user.email,MD5Utils.encode2hex(user.email)))
       email.setCharset("UTF-8")
       email.setTextMsg("激活邮件")
       email.addTo(user.email)
       email.send()
      "发送邮件成功,请检查邮件"
    }

    def makeEmail(email:String,validateCode:String): String ={
        ///邮件的内容
//        val sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>")
//        sb.append("<a href=\"http://localhost:9000/mail/verifyingmail?email=")
//        sb.append(email)
//        sb.append("&validateCode=")
//        sb.append(validateCode)
//        sb.append("\">http://localhost:9000/mail/verifyingmail?email=")
//        sb.append(email)
//        sb.append("&validateCode=")
//        sb.append(validateCode)
//        sb.append("</a>")
//        sb.toString

      val time: String = dateFormat.format(new Date(System.currentTimeMillis()))
      val title ="NEPTUNE（新浪微博大数据平台）"
      val username=email
      val adminemail="jiazheng1@staff.weibo.com"

      "\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n   " +
        " <meta charset=\"UTF-8\">\n  " +
        "  <title>注册结果</title>\n</head>\n<body>\n" +
        "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
        "<table cellpadding=\"0\" align=\"center\" style=\"width: 600px; margin: 0px auto; " +
        "text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse;" +
        " background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n<tbody>\n<tr>\n<th valign=\"middle\" style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #C46200; background-color: #FEA138; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n<font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">NEPTUNE（新浪微博大数据平台）</font>\n</th>\n</tr>\n<tr>\n<td>\n" +
        "<div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
        "<h2 style=\"margin: 5px 0px; \"><font color=\"#333333\" style=\"line-height: 20px; \"><font style=\"line-height: 22px; \" size=\"4\">亲爱的:"+username+"</font></font></h2>\n<p>\n您收到这封邮件，是由于在NEPTUNE（新浪微博大数据平台）进行了新用户注册，或用户修改密码使用了这个邮箱地址。<br/>\n如果您并没有访问过NEPTUNE或没有进行上述操作，请忽略这封邮件，您不需要进行其他进一步的操作\n" +
        "<p>\n\n<h2 style=\"margin: 5px 0px; \"><font color=\"#333333\" style=\"line-height: 20px; \"><font style=\"line-height: 22px; \" size=\"4\">账号激活说明</font></font></h2>\n<p>如果您是NEPTUNE的用户，我们需要对您的地址有效性进行校验\n您只需点击下面的连接即可激活您的账号<br/>\n <a href=\"http://localhost:9000/mail/verifyingmail?email="+email+"&validateCode="+validateCode+"\">http://localhost:9000/mail/verifyingmail?email="+email+"&validateCode="+validateCode+"</a></p>\n\n<p/>\n如果您有什么疑问可以联系管理员，Email: "+adminemail+"。</p>\n<p align=\"right\"> 某官方团队</p>" +
        "\n<p align=\"right\">"+time+"</p>\n</div>\n</td>\n</tr>\n</tbody>\n</table>\n</div>\n\n\n</body>\n</html>"





    }


  /**
    * 验证用户激活信息
    *
    * @return
    */
  def activateUser : PartialFunction[(String,String),RegisterStatus]={
      case user if User.findByEmail(user._1).isEmpty =>  EmailExecption("用户邮箱不存在")
      case user if User.findByStatusByEmail(user._1) !=0 =>  VerifyException("用户已激活,不需要重复激活")
      case user if(StringUtils.equals(MD5Utils.encode2hex(User.findByEmail(user._1).get.email),user._2))
        =>{
          if(User.updateStatus(user._1)>0)  Success("激活成功") else  Failure("激活失败")
        }
      case _ => Failure("激活失败")
    }

}
