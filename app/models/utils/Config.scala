package models.utils

/**
  * Created by king on 16/9/2.
  */
trait Config {


  def getString(path:String):String

  def getBoolean(path:String):Boolean

  def getLong(path:String):Long

  def getInt(path:String):Int

  def getDouble(path:String):Double





}
