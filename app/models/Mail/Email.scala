package models

import java.text.SimpleDateFormat
import java.util.Date

import models._
import org.apache.commons.lang3.StringUtils
import org.apache.commons.mail.{DefaultAuthenticator, HtmlEmail, SimpleEmail}
import play.api.Logger

/**
  * Created by liangkai on 16/6/16.
  */
object Email {
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
  def sendHtmlMail[T](user:T):String={

      val email = new HtmlEmail()
      email.setHostName("smtp.sina.com")
      email.setSmtpPort(25)
      email.setAuthenticator(new DefaultAuthenticator("server_noreplay@sina.com", "adminadmin"))
      email.setSSLOnConnect(true)
      email.setFrom("server_noreplay@sina.com", "DSP&DBA")
      email.setCharset("UTF-8")
      user match {
        case u : User => {u.asInstanceOf[User];
          email.setSubject("注册账号激活邮件");
          email.addTo(u.email) ;
          email.setHtmlMsg(makeRegisterEmail(u))}
        case v : Verify=>{v.asInstanceOf[Verify];
          email.setSubject("重置密码信息")
          email.addTo(v.email)
          email.setHtmlMsg(makeFindPasswordEmail(v))
        }
      }
      email.send()
      "发送邮件成功,请检查邮件"
    }


  /**
    * 找回密码邮件
    * @param verify
    * @return
    */
     def makeFindPasswordEmail(verify:Verify): String ={
       val time: String = dateFormat.format(new Date(System.currentTimeMillis()))
       val validateCode=MD5Utils.encode2hex(verify.email)
       val email=verify.email
       val username=verify.name
        val hostname="http://10.209.72.198:9000"
       "\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n   " +
         " <meta charset=\"UTF-8\">\n  " +
         "  <title>注册结果</title>\n</head>\n<body>\n" +
         "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
         "<table cellpadding=\"0\" align=\"center\" style=\"width: 600px; margin: 0px auto; " +
         "text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse;" +
         " background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n<tbody>\n<tr>\n<th valign=\"middle\" style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #C46200; background-color: #FEA138; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n<font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">NEPTUNE（新浪微博大数据平台）</font>\n</th>\n</tr>\n<tr>\n<td>\n" +
         "<div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
         "<h2 style=\"margin: 5px 0px; \"><font color=\"#333333\" style=\"line-height: 20px; \"><font style=\"line-height: 22px; \" size=\"4\">亲爱的:"+username+"</font></font></h2>\n<p>\n您收到这封邮件，是由于在NEPTUNE（新浪微博大数据平台）进行了新用户注册，或用户修改密码使用了这个邮箱地址。<br/>\n如果您并没有访问过NEPTUNE或没有进行上述操作，请忽略这封邮件，您不需要进行其他进一步的操作\n" +
         "\n<p>您可以通过下面的链接重置您的密码:<br/>\n <a href="+hostname+"/mail/setpwd?email="+email+"&pwdToken="+validateCode+">"+hostname+"/mail/setpwd?email="+email+"&pwdToken="+validateCode+"</a></p>\n<p align=\"right\"> 某官方团队</p>" +
         "\n<p align=\"right\">"+time+"</p>\n</div>\n</td>\n</tr>\n</tbody>\n</table>\n</div>\n\n\n</body>\n</html>"
     }


    /**
    * 注册激活邮件
    * @param user
    * @return
    */
    def makeRegisterEmail(user: User): String ={
      val validateCode=MD5Utils.encode2hex(user.email)
      val time: String = dateFormat.format(new Date(System.currentTimeMillis()))
      val email=user.email
      val username=user.name
      val adminemail="jiazheng1@staff.weibo.com"
      val hostname="http://10.209.72.198:9000"

      "\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n   " +
        " <meta charset=\"UTF-8\">\n  " +
        "  <title>注册结果</title>\n</head>\n<body>\n" +
        "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
        "<table cellpadding=\"0\" align=\"center\" style=\"width: 600px; margin: 0px auto; " +
        "text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse;" +
        " background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n<tbody>\n<tr>\n<th valign=\"middle\" style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #C46200; background-color: #FEA138; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n<font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">NEPTUNE（新浪微博大数据平台）</font>\n</th>\n</tr>\n<tr>\n<td>\n" +
        "<div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
        "<h2 style=\"margin: 5px 0px; \"><font color=\"#333333\" style=\"line-height: 20px; \"><font style=\"line-height: 22px; \" size=\"4\">亲爱的:"+username+"</font></font></h2>\n<p>\n您收到这封邮件，是由于在NEPTUNE（新浪微博大数据平台）进行了新用户注册，或用户修改密码使用了这个邮箱地址。<br/>\n如果您并没有访问过NEPTUNE或没有进行上述操作，请忽略这封邮件，您不需要进行其他进一步的操作\n" +
        "<p>\n\n<h2 style=\"margin: 5px 0px; \"><font color=\"#333333\" style=\"line-height: 20px; \"><font style=\"line-height: 22px; \" size=\"4\">账号激活说明</font></font></h2>\n<p>如果您是NEPTUNE的用户，我们需要对您的地址有效性进行校验\n您只需点击下面的连接即可激活您的账号<br/>\n <a href="+hostname+"/mail/verifyingmail?email="+email+"&validateCode="+validateCode+">"+hostname+"/mail/verifyingmail?email="+email+"&validateCode="+validateCode+"</a></p>\n\n<p/>\n如果您有什么疑问可以联系管理员，Email: "+adminemail+"。</p>\n<p align=\"right\"> 某官方团队</p>" +
        "\n<p align=\"right\">"+time+"</p>\n</div>\n</td>\n</tr>\n</tbody>\n</table>\n</div>\n\n\n</body>\n</html>"

    }


  /**
    * 验证用户激活信息
    *
    * @return
    */
  def activateUser : PartialFunction[(String,String),EmailStatus]={
      case user if User.findByEmail(user._1).isEmpty =>  EmailExecption("用户邮箱不存在")
      case user if User.findByStatusByEmail(user._1) !=0 =>  VerifyException("用户已激活,不需要重复激活")
      case user if (StringUtils.equals(MD5Utils.encode2hex(User.findByEmail(user._1).get.email),user._2))
        =>{
            Logger.info(user._1+"####"+user._2)
          if(User.updateStatus(user._1)>0)  Success("激活成功") else  Failure("激活失败")
        }
      case _ => Failure("激活失败,请检查注册信息")
    }


  /**
    * 验证用户找回密码信息
    *
    * @return
    */
  def activatePWD : PartialFunction[(String,String),EmailStatus]={
    case user if User.findByEmail(user._1).isEmpty =>  EmailExecption("用户邮箱不存在")
    case user if User.findByStatusByEmail(user._1) ==0 =>  VerifyException("用户未激活,需要激活")
    case user if(StringUtils.equals(MD5Utils.encode2hex(User.findByEmail(user._1).get.email),user._2))
    =>{
      Success("验证成功")
    }
    case _ => Failure("验证失败")
  }

}
