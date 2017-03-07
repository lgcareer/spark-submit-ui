package models.metrics

/**
  * Created by king on 2017/3/2.
  */
trait MetricsProvider {

  def getMetricMouled[T](clz:Class[_]):T

}
