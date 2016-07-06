package models.ui

/**
  * Created by liangkai1 on 16/6/30.
  */
class UI {

}

object UI{


  case class JobUi(val timeline:String,val active:String,val completed:String,val failed:String)

  case class StreamingUi(val statTable:String)
}
