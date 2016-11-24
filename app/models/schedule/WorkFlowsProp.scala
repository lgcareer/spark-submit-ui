package models

import play.api.Logger

import scala.xml.{Elem, XML}

/**
  * Created by king on 2016/11/22.
  */
class WorkFlowsProp {

}

object  WorkFlowsProp{
    val filePath = "conf/oozie/mr-workflow.xml"


   def createProp(para:Seq[String]): String ={
     val len: Int = para.size
     val iterator: Iterator[String] = para.iterator
     /**
       * add new node config
       */
     val  el =  <workflow-app xmlns="uri:oozie:workflow:0.2" name="map-reduce-wf">
       <start to="mr-node"></start>
       <action name="mr-node">
         <map-reduce>
           <job-tracker>${"jobTracker"}</job-tracker>
           <name-node>${"nameNode"}</name-node>
           <configuration>{
             for (i <- 1 to len/2) yield
               <property>
                 <name>{iterator.next()}</name>
                 <value>{iterator.next()}</value>
               </property>


             }</configuration>
         </map-reduce>
         <ok to="end"/>
         <error to="fail"/>
       </action>
       <kill name="fail">
         <message>Map/Reduce failed, error message[${"wf:errorMessage(wf:lastErrorNode())"}]</message>
       </kill>
       <end name="end"/>
     </workflow-app>
     Logger.info(">>>>>>>>> create xml file <<<<<<<<")
     Logger.info(el.toString())
     XML.save(filePath,el,"UTF-8")
     filePath
   }


}
