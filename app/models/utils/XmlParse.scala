package models.utils

import play.api.libs.functional.~

import scala.collection.mutable._
import scala.xml._
/**
 * Created by manbu on 16/8/8.
 */
object XmlParse {
  /**
   *
   * @param queueName  队列名称
   * @param memory  最大内存
   * @param vcpu  最大使用CPU数
   * @param maxRunningApps  最大并行数
   * @return  String
   */

    /*
    *  声明全局变量
    *  队列名称
    * */
      val queueList = List("default","pt_UserGrowth")
    /*
     解析XML 文件
     fair-scheduler.xm
     */
     def XMLParses(queueName:String,memory:String,vcpu:String,maxRunningApps:String): String = {
      new yarnfair(queueName,memory,vcpu,maxRunningApps)
      /*
      load xml file
       */
      // s"public/download/fair-scheduler.xml"
//       val fairXml = XML.loadFile(s"tmp/fair-scheduler.xml")
       val fairXml = XML.loadFile(s"public/download/fair-scheduler.xml")
      //fetch nodes insert into Map
        val queueMap =
         (Map[String,String]() /:(fairXml \ "queue" \ "queue")){
           (map, queueName) =>
             val name =(queueName \ "@name").toString()
             val maxResources = (queueName \ "maxResources").text.toString
             val maxRunningApps = (queueName \ "maxRunningApps").text.toString
                   map += (name -> maxResources)
                   map += (name -> maxRunningApps)
                   map
         }

      /**
       * 获取具体队列相关参数
       */
       val default = (fairXml\\"queue").filter(x=>((x\"@name").text)==queueList(0))
       val pt_UserGrowth = (fairXml\\"queue").filter(x=>((x\"@name").text)==queueList(1))

       println("==>"+pt_UserGrowth)
       println("**********")

      /**
       * 提取队列参数
       * 可用于展示
       */
//             val maxResources = (default \ "maxResources").text.toString
//             val maxRunningApps = (default \ "maxRunningApps").text.toString
//             val memory = maxResources.split(",")(0)
//             val vcpu = maxResources.split(",")(1)
//             println("memory:"+memory)
//             println("vcpu:"+vcpu)
//             val map =Map[String,String]()
//             map += ("memory" -> memory,"vcpu" -> vcpu)

       //跟新队列名称修改对应参数
        println("队列"+ queueName)
        println("memory"+ memory)
        println("vcpu"+ vcpu)
        println("maxRunningApps"+ maxRunningApps)

       if(queueName == queueList(0)){
         //修改文件
         val defaultFile =
           <allocations>
             <queue name="root">
               <aclSubmitApps> </aclSubmitApps>
               <aclAdministerApps> </aclAdministerApps>
               <queue name={queueName}>
                 <minResources>13653 mb,5 vcores</minResources>
                 <maxResources>{memory},{vcpu}</maxResources>
                 <maxRunningApps>{maxRunningApps}</maxRunningApps>
                 <minSharePreemptionTimeout>300</minSharePreemptionTimeout>
                 <aclSubmitApps>*</aclSubmitApps>
                 <aclAdministerApps>*</aclAdministerApps>
                 <weight>1</weight>
               </queue>
               {pt_UserGrowth}
             </queue>
           </allocations>
         //保存文件路径
//         XML.save(s"tmp/fair-scheduler.xml", defaultFile)
         XML.save(s"public/download/fair-scheduler.xml", defaultFile)
       }
       if(queueName == queueList(1)) {
          val pt_UserGrowth =
            <allocations>
              <queue name="root">
                <aclSubmitApps> </aclSubmitApps>
                <aclAdministerApps> </aclAdministerApps>
                {default}
              <queue name={queueName}>
                <minResources>109227 mb,24 vcores</minResources>
                <maxResources>{memory},{vcpu}</maxResources>
                <maxRunningApps>{maxRunningApps}</maxRunningApps>
                <minSharePreemptionTimeout>300</minSharePreemptionTimeout>
                <aclSubmitApps>UserGrowth,root</aclSubmitApps>
                <aclAdministerApps>UserGrowth,root,hadoop</aclAdministerApps>
                <weight>9</weight>
              </queue>
              </queue>
            </allocations>
         //保存文件路径
//         XML.save(s"/tmp/newXmlFile.xml", pt_UserGrowth)
         XML.save(s"public/download/fair-scheduler.xml", pt_UserGrowth)
        }

       println(XML.load(s"public/download/fair-scheduler.xml"))
       println("-------分隔符---------")
       fairXml.toString()
   }

  /**
   *
   * @param elem tuple类型
   * @return
   */
      def updateXmlFile(elem: ((String, String),(String,String),(String,String))):Any ={
          val ((name1,memory),(name2,cpu),(name3,apps)) = elem
          <queue name={name1}>
            <minResources>13653 mb,6 vcores</minResources>
            <maxResources>{memory} mb,{cpu} vcores</maxResources>
            <maxRunningApps>6</maxRunningApps>
            <minSharePreemptionTimeout>300</minSharePreemptionTimeout>
            <aclSubmitApps>{apps}</aclSubmitApps>
            <aclAdministerApps>*</aclAdministerApps>
            <weight>1</weight>
          </queue>
            <queue name={name2}>@.{elem}</queue>
  }

     def updateXMLNodes(node:(String,String,String,String)) ={
          val (queueName,memory,vcores,maxRunningApps) = node
       <queue name="root">
         <minResources>13653 mb,6 vcores</minResources>
         <maxResources>13653 mb,10 vcores</maxResources>
         <maxRunningApps>6</maxRunningApps>
         <minSharePreemptionTimeout>300</minSharePreemptionTimeout>
         <aclSubmitApps>*</aclSubmitApps>
         <aclAdministerApps>*</aclAdministerApps>
         <weight>1</weight>
       </queue>
       <queue name={queueName}>
         <minResources>109227 mb,24 vcores</minResources>
         <maxResources>{memory} mb,{vcores} vcores</maxResources>
         <maxRunningApps>{maxRunningApps}</maxRunningApps>
         <minSharePreemptionTimeout>300</minSharePreemptionTimeout>
         <aclSubmitApps>UserGrowth,root</aclSubmitApps>
         <aclAdministerApps>UserGrowth,root,hadoop</aclAdministerApps>
         <weight>9</weight>
       </queue>
     }


}
  sealed trait dispatch
  case class yarnfair (queue:String,memory:String,vcores :String,maxRunningApps:String) extends dispatch



