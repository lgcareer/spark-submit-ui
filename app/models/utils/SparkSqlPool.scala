package models.utils

import java.sql.{Connection, DriverManager}
import java.util

/**
  * Created by manbu on 16/7/18.
  */
object SparkSqlPool {
   private val max = 80
   private val connectionNum = 100
   private var conNum = 0
   private val pool = new util.LinkedList[Connection]()

   //获取连接
   def getJdbcConn() : Connection = {
     //同步代码块
     AnyRef.synchronized({
       if(pool.isEmpty){
         //加载驱动
         preGetConn()
         for(i <- 1 to connectionNum){
           val conn = DriverManager
             .getConnection("jdbc:hive2://h136159.mars.grid.sina.com.cn:10000","FicusSpark","d03fd7fc96bb5e6")
           pool.push(conn)
           conNum +=  1
         }
       }
       pool.poll()
     })
   }

   //加载驱动
   private def preGetConn() : Unit = {
     //控制加载
     if(conNum > max && pool.isEmpty){
       println("Jdbc Pool has no connection now, please wait a moments!")
       Thread.sleep(2000)
       preGetConn()
     }else{
       Class.forName("org.apache.hive.jdbc.HiveDriver");
     }
   }

   //释放连接
   def releaseConn(conn:Connection): Unit ={
     pool.push(conn)
   }
 }
