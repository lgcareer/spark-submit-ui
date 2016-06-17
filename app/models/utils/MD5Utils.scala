package models.utils

import java.io.UnsupportedEncodingException
import java.security.{MessageDigest, NoSuchAlgorithmException}

/**
  * Created by liangkai1 on 16/6/17.
  */
object MD5Utils {

  /**
    * 将字符串使用MD5加密为字节数组
    *
    * @param source
    * @return
    */
  private[this] def encode2bytes(source: String): Array[Byte] = {
    var result: Array[Byte] = null
    try {
      val md = MessageDigest.getInstance("MD5");
      md.reset();
      md.update(source.getBytes("UTF-8"));
      result = md.digest()
    } catch {
      case e: NoSuchAlgorithmException => e.printStackTrace()
      case e: UnsupportedEncodingException => e.printStackTrace()
    }
     result;
  }

  /**
    * 将字符串使用MD5加密为32位16进制数
    *
    * @param source
    * @return
    */
  def encode2hex(source: String): String = {
    val data = encode2bytes(source);
    val hexString = new StringBuffer();
    for (byte <- data) {
      val hex: String = Integer.toHexString(0xff & byte);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    hexString.toString
  }

}
