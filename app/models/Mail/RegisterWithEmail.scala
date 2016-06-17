package models.Mail

import java.net.URL

import models.User
import models.utils.MD5Utils
import org.apache.commons.mail.{DefaultAuthenticator, HtmlEmail, SimpleEmail}

/**
  * Created by liangkai on 16/6/16.
  */
object RegisterWithEmail {

    /**
      * 发送纯文本邮件
      *
      * @return
      */
    val sendTextMail =textMail _

      def textMail(): String ={
          val email = new SimpleEmail()
          email.setHostName("smtp.163.com")
          email.setSmtpPort(465)
          email.setAuthenticator(new DefaultAuthenticator("kingekinge@163.com", "zhang66261123"))
          email.setSSLOnConnect(true)
          email.setFrom("kingekinge@163.com")
          email.setSubject("NEPTUNE DATA PLATFORM注册激活")
          email.setMsg("This is a test mail ... :-)")
          email.addTo("444517160@qq.com")
          email.send()
        }

    /**
    * 发送Html邮件
 *
    * @return
    */
  def sendHtmlMail(user:User):String={
      // Create the email message
      val email = new HtmlEmail()
      email.setHostName("smtp.163.com")
      email.setSmtpPort(465)
      email.setAuthenticator(new DefaultAuthenticator("kingekinge@163.com", "zhang66261123"))
      email.setSSLOnConnect(true)
      email.setFrom("kingekinge@163.com", "新浪微博")
      email.setSubject("NEPTUNE DATA PLATFORM注册激活")

      //embed the image and get the content id
//      val url = new URL("http://img5.imgtn.bdimg.com/it/u=326438122,4029994037&fm=11&gp=0.jpg")
//      val cid = email.embed(url, "Apache logo")
       email.setHtmlMsg(makeEmail(user.email,MD5Utils.encode2hex(user.email)))
       email.setCharset("UTF-8")
       email.setTextMsg("激活邮件")
       email.addTo(user.email)
       email.send()
    }

    def makeEmail(email:String,validateCode:String): String ={
        ///邮件的内容
        val sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>")
        sb.append("<a href=\"http://localhost:9000/mail/verifyingmail?validateCode='adafadsad'&email=")
        sb.append(email)
        sb.append("&validateCode=")
        sb.append(email)
        sb.append("\">http://localhost:9000/mail/verifyingmail?validateCode='adafadsad'&email=")
        sb.append(email)
        sb.append("&validateCode=")
        sb.append(validateCode)
        sb.append("</a>")
        sb.toString
    }

    def verifyingmail() : PartialFunction[S]={

    }

}
