package controllers


import models._
import play.api.data.Form
import play.api.data.Forms._


import scala.collection.JavaConversions._
import scala.io.Source
import scala.collection.mutable.HashMap
import scala.collection.immutable.ListMap
import scala.util.matching.Regex
import java.util.LinkedHashMap
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, Controller}
/**
  * Created by leslie on 16/11/22.
  * hbase 集群相关操作
  */
object HbaseOptions extends Controller with  Secured{

  def region=IsAuthenticated{
    username => implicit request =>
      if(UserGroup.hasAdminGroup(username)) Ok(views.html.metadata())  else
        Ok(views.html.readmetadata())
  }

  def findhot=Action{
    val output=""
    Ok(views.html.hbase(output))
  }
  def findHotRegion=Action{ implicit request =>
    val (ip,host) = hosts.bindFromRequest.get
    val read_request: Regex = "tbl.*.region.([0-9a-f]+).readrequestcount\" : ([0-9]+)".r
    val write_request: Regex = "tbl.*.region.([0-9a-f]+).writerequestcount\" : ([0-9]+)".r
    val map = findHotRegions(host, read_request, write_request)
    val zkinfo = getZookeeperInfo(host)
    val string = new StringBuffer()
    for(m <- map){
      string.append(m._1+" : "+m._2+"$")
    }
    val output = string.append(zkinfo).toString
    Ok(views.html.hbase(output))
//    val maps = new LinkedHashMap[String,String]()
//    for(m <- map){
//      maps.put(m._1,String.valueOf(m._2))
//    }
//    val strings = zkinfo.split("::")
//    maps.put(strings(0),strings(1))
//    Ok(views.html.hbase(maps))
  }

  def getStatics(host: String): String = {

    val statics = Source.fromURL("http://" + host + ":60030/jmx?format=json", "UTF-8").mkString

    //    println(statics)
    if (statics.contains("\"version\" : \"0.94.")) {
      statics
    } else {
      val statics96 = Source.fromURL("http://" + host + ":60030/rs-status#regionRequestStats", "UTF-8").mkString

      statics96
    }
  }
  def getStaticss(host: String, pattern: Regex): HashMap[String, Int] = {

    val statics = getStatics(host)
    val map = new HashMap[String, Int]
    for (matchString <- pattern.findAllIn(statics)) {
      val matchRead = matchString.replace(".readrequestcount\"", "").replace(",", "").split(":")
      //      println(matchRead(0)+":"+matchRead(1))
      map.put(matchRead(0).trim(), Integer.valueOf(matchRead(1).trim()))
    }
//    println(pattern.findAllIn(statics))
    map

  }
  def getZookeeperInfo(host: String): String = {
    var zks = ""
    var zkParent = "NULL"
    val result = getStatics(host)
    if (result.contains("\"version\" : \"0.94.")) {
      val info = Source.fromURL("http://" + host + ":60030/conf", "UTF-8").mkString
      val zkss = info.substring(info.indexOf("hbase.zookeeper.quorum"), info.length())

      zks = zkss.substring(0, zkss.indexOf("</value></property>")).replace("</name><value>", "::").split("::")(1)
      if (info.contains("zookeeper.znode.parent")) {
        val zkParents: String = info.substring(info.indexOf("zookeeper.znode.parent"), info.length())
        zkParent = zkParents.substring(0, zkParents.indexOf("</value></property>")).replace("</name><value>", "::").split("::")(1)
      } else {
        zkParent = "NULL"
      }
      zks + " : " + zkParent
    }else{
      val info = Source.fromURL("http://" + host + ":60030/conf", "UTF-8").mkString
      val zkss = info.substring(info.indexOf("hbase.zookeeper.quorum"), info.length())
      //println(zkss)
      zks = zkss.substring(0, zkss.indexOf("</source></property>")).replace("</name><value>", "::").replace("</value><source>hbase-site.xml", "").split("::")(1)
      if (info.contains("zookeeper.znode.parent")) {
        val zkParents: String = info.substring(info.indexOf("zookeeper.znode.parent"), info.length())
        zkParent = zkParents.substring(0, zkParents.indexOf("</source></property>")).replace("</name><value>", "::").split("::")(1)
      } else {
        zkParent = "NULL"
      }
      zks.replace("</value><source>hbase-site.xml", "") + " : " + zkParent.replace("</value><source>hbase-site.xml", "")
    }

  }
//  def moveRegion(zks: String, zkParent: String, regionName: String, destHost: String) = {
//    val conf: Configuration = HBaseConfiguration.create
//    conf.set("hbase.zookeeper.quorum", zks);
//    conf.set("zookeeper.znode.parent", zkParent)
//    val admin = new HBaseAdmin(conf)
//
//    admin.move(Bytes.toBytes(regionName), Bytes.toBytes(destHost));
//  }
  def getStaticss(host: String, patternRead: Regex, patternWrite: Regex): HashMap[String, Int] = {

    val statics = getStatics(host)

    val map = new HashMap[String, Int]
    if (statics.contains("\"version\" : \"0.94.")) {

      for (matchString <- patternRead.findAllIn(statics)) {
        val matchRead = matchString.replace("tbl.", "").replace("region.", "").replace("\"", "").split(":")

        map.put(matchRead(0).trim(), Integer.valueOf(matchRead(1).trim()))
      }
      for (matchString <- patternWrite.findAllIn(statics)) {
        val matchWrite = matchString.replace("tbl.", "").replace("region.", "").replace("\"", "").split(":")

        map.put(matchWrite(0).trim(), Integer.valueOf(matchWrite(1).trim()))
      }
      //    println(patternRead.findAllIn(statics))
      map
    } else {
      val string = getStatics(host)
      val subStr = string.substring(string.indexOf("<div class=\"tab-pane\" id=\"tab_regionRequestStats\">"), string.indexOf("<div class=\"tab-pane\" id=\"tab_regionStoreStats\">"))
      var subStrs = subStr.substring(subStr.indexOf("Write Request Count") + 40, subStr.length())
      //      println(subStrs)

      while (subStrs.contains("<tr>")) {
        val string1 = subStrs.substring(subStrs.indexOf("<tr>") + 4, subStrs.indexOf("</tr>"))

        val regionName = string1.substring(string1.indexOf("<td>") + 4, string1.indexOf("</td>") - 1)
        val region = regionName.substring(0, regionName.indexOf(",")) + regionName.substring(regionName.lastIndexOf("."), regionName.length() - 1).trim()
        val requests = string1.substring(string1.indexOf("</td>") + 5, string1.length()).trim()
        //        println(requests)
        val readRequest = requests.substring(requests.indexOf("<td>") + 4, requests.indexOf("</td>"))
        val writeRequest = requests.substring(requests.indexOf("</td>") + 5, requests.length()).replace(" ", "").replace("<td>", "").replace("</td>", "").trim()
        //        println(readRequest + ":" + writeRequest)
        map.put(region + ".readrequestcount", Integer.valueOf(readRequest))
        map.put(region + ".writerequestcount", Integer.valueOf(readRequest))
        subStrs = subStrs.substring(subStrs.indexOf("</tr>") + 5, subStrs.length())
      }

      map
    }

  }
  def findHotRegions(host: String, patternRead: Regex, patternWrite: Regex): LinkedHashMap[String, Int] = {
    println("start to collect....")
    val map = new HashMap[String, Int]
    val maps = new LinkedHashMap[String, Int]
    val map_former = getStaticss(host, patternRead, patternWrite)
    //    println(map_former)
    println("sleep 10s...")
    Thread.sleep(10000)
    val map_later = getStaticss(host, patternRead, patternWrite)
    //    println(map_later)
    if (map_later.size.equals(map_former.size)) {
      for ((k, v) <- map_later) {
        map.put(k, v - map_former.get(k).get)
      }

      map_former.clear(); map_later.clear()
      for (entry <- map.entrySet()) {
        if (entry.getKey.contains("readrequestcount")) {
          map_former.put(entry.getKey.trim(), entry.getValue)
        } else if (entry.getKey.contains("writerequestcount")) {
          map_later.put(entry.getKey.trim(), entry.getValue)
        }
      }
      val result_read = ListMap(map_former.toSeq.sortWith(_._2 > _._2): _*).entrySet().iterator()
      val result_write = ListMap(map_later.toSeq.sortWith(_._2 > _._2): _*).entrySet().iterator()

      for (i <- 0 until 10) {
        val s = result_read.next()
        maps.put(s.getKey, Integer.valueOf(s.getValue))
      }
      for (i <- 0 until 10) {
        val s = result_write.next()
        maps.put(s.getKey, Integer.valueOf(s.getValue))
      }

    } else {

    }
    maps
  }
  val hosts = Form(
    tuple(
      "ip" -> text,
      "host" -> text
    )
  )
}
