import scala.collection.immutable.Range.Inclusive
import scala.xml.{Elem, Node, XML}

/**
  * Created by king on 2016/11/22.
  */
object testXML {


  def main(args: Array[String]): Unit = {
    val node: Elem = XML.loadFile("conf/oozie/workflow.xml")

    /**
      * parent node
      */
    val start =node.child(1)
    val kill =node.child(5)
    val end: Node = node.child(7)
    val action: Node = node.child(3)
    /**
      * action node
      */
    val mapreduce: Node = action.child(1)
    val ok =action.child(3)
    val error =action.child(5)

    //val cfNode = <configuration>{ for (i <- 1 to 3) yield <li>{ i }</li> }</configuration>


    val inclusive: Inclusive = 1 to 6
    val len = inclusive.size
    val iterator: Iterator[Int] = inclusive iterator


    /**
      * add new node config
      */
    val  el =  <workflow-app xmlns="uri:oozie:workflow:0.2" name="map-reduce-wf">
      <start to="mr-node"></start>
      <action name="mr-node">
        <map-reduce>
          <job-tracker>${"jobTracker"}</job-tracker>
          <name-node>${"nameNode"}</name-node>
          <prepare>
            <delete path="${nameNode}/user/${wf:user()}/${examplesRoot}/output-data/${outputDir}"/>
          </prepare>
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

    XML.save("conf/oozie/mr-workflow.xml",el,"UTF-8")

    println(el)









//    UUID uuid = UUID.randomUUID();
//
//    FileSystem hdfs = null;
//    try {
//      //目标文件
//      String destfile = "workspance/king/wf-"+uuid+"/lib/";
//      //源文件
//      String fsrc = "/tmp/file/oozie-examples-4.2.0.jar";
//
//      Configuration config = new Configuration();
//      // 程序配置
//      config.set("fs.default.name", "hdfs://hadoop01:9000");
//
//      hdfs = FileSystem
//        .get(new URI("hdfs://hadoop01:9000"), config, "hadoop");
//      Path srcPath = new Path(fsrc);
//      Path destPath = new Path(destfile);
//
//      if(!hdfs.exists(destPath)){
//        hdfs.mkdirs(destPath);
//      }
//
//      hdfs.copyFromLocalFile(srcPath, destPath);
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    } finally {
//      if (hdfs != null) {
//        try {
//          hdfs.closeAll();
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }
//    }








  }
}
