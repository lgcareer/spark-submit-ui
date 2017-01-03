package models.utils

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by ruilin on 16/12/30.
 */
object TimeParseUtils {
  def timeFormat(time:String):String= {
    val sdf: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm")
    val date: String = sdf.format(new Date((time.toLong * 1000l)))
    date
  }
}