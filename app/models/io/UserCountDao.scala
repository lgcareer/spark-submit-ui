package models.io

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json.{JsValue, Json}

import scala.collection.mutable.ArrayBuffer

/**
 * Created by manbu on 16/7/22.
 */
case class  UserCountDao(group:String,tatol:Long)
object UserCountDao {
   val simple = {
     get[String]("group") ~
     get[Long]("tatol") map{
       case group ~ tatol => UserCountDao(group,tatol)
     }
   }

  /**
   * 统计每组用户人数
   * @return
   */
  def findAll(): Seq[UserCountDao] = {
    DB.withConnection { implicit connection =>
      SQL("select `group`,count(*) as tatol " +
        "from user_group group by `group`").as(UserCountDao.simple *)
    }
  }
9
  /**
   * 根据用户获取用户组
   * @param userEmail
   * @return
   */
  def userBygroup(userEmail:String) :String ={
    DB.withConnection { implicit connection =>
      val user_group = SQL("select g.group as `group` from user_group g where g.email = {email}")
                        .on("email" -> userEmail)
      val group = user_group().map(
       row => row[String]("group")
      ).toList
      group(0)
    }
  }

   def userResourceRateSpark (username:String):String = {
     /**
      * 获取登录用户所属组
      * 获取接口数据
      * 转成JsValue对象
      */
      val group = UserCountDao.userBygroup(username)
      val sparkJson :JsValue = Json.parse(scala.io.Source.fromURL("http://10.77.136.159:8080/json").mkString)

     /**
      * 获取spark worker整体计算资源
      * Memory
      * CPU
      */
     var sparkRate :Double = 0.00
     //整体计算资源
     val memoryBuffer =ArrayBuffer[Long]()
     val coreBuffer = ArrayBuffer[Long]()
     //已使用资源
     val memoryusedBuffer = ArrayBuffer[Long]()
     val coresusedBuffer = ArrayBuffer[Long]()

     val MemoryList = sparkJson \ "workers" \\ "memory"
     val coreList = sparkJson \ "workers" \\ "cores"

     val memoryusedList = sparkJson \ "workers" \\ "memoryused"
     val coresusedList = sparkJson \ "workers" \\ "coresused"

     var tallyMemory = 0.00
     var tallyCore = 0.00

       for (i <- 0 until MemoryList.length) {
         memoryBuffer += MemoryList(i).toString().toLong
         coreBuffer += coreList(i).toString().toLong
         memoryusedBuffer += memoryusedList(i).toString().toLong
         coresusedBuffer += coresusedList(i).toString().toLong
       }
        tallyMemory = memoryBuffer.sum / 1024
        tallyCore = coreBuffer.sum

       val usedMemory = memoryusedBuffer.sum / 1024
       val usedCore = coresusedBuffer.sum
       sparkRate = Math.round((
         (usedMemory * 1.0 + usedCore * 1.0) / (tallyMemory * 1.0 + tallyCore * 1.0))
         * 100)
     if(group == "") {
       /**
        * 获取运行任务使用资源
        * Memory
        * CPU
        */

       val runCoresBuffer = ArrayBuffer[Long]()
       val runMemoryBuffer = ArrayBuffer[Long]()

       val runList = sparkJson \ "activeapps" \\ "user"
       val runTask = sparkJson \ "activeapps"

       /**
        *
        * 提取相同用户到同一ArrayBuffer
         */

       /**
        * 根据用户权限
        * 获取Spark整体已使用资源
        */

       for (i <- 0 until runList.length) {
         val user = runList(i)
         if (user.toString() == "\"" + group + "\"") {
           runMemoryBuffer += (Json.parse(runTask(i).toString()) \ "memoryperslave").toString().toLong
           runCoresBuffer += (Json.parse(runTask(i).toString()) \ "cores").toString().toLong
         }
       }
       println("runMemoryBuffer" + runMemoryBuffer.sum/1024)
       println("runCoresBuffer" + runCoresBuffer.sum)
       println("tallyMemory" + tallyMemory)
       println("tallyCore" + tallyCore)

       sparkRate = Math.round((runMemoryBuffer.sum/1024 * 1.0 + runCoresBuffer.sum * 1.0)
         / (tallyMemory * 1.0 + tallyCore * 1.0) * 100)
       println("==>" + sparkRate)

     }
     sparkRate.toString
   }


  /**
   * 用户组Yarn资源计算
   * @return
   *
   */
      def userResourceRate (username:String) :String ={
      //获取登录用户所属组
      val group = UserCountDao.userBygroup(username)
      //用户组与队列映射
      val group_queue = find_group_queue()


      /**
       * 接口调用数据
       */
            val scheduleryarn = scala.io.Source.
              fromURL("http://10.77.136.159:8088/ws/v1/cluster/scheduler").mkString
      //转成JsValue 格式
      val scheduler :JsValue = Json.parse(scheduleryarn)
      //获取childQueues 列表
      val childQueues = (scheduler \ "scheduler" \ "schedulerInfo"
        \ "rootQueue" \ "childQueues")
      /**
       *  定义队列数组大小
       */
      val queueNameList = childQueues \\ "queueName"
      val queueNameListSize = queueNameList.length
      var resourceRate = 0.00
      var rateMemoryRate = 0.00

      //全局memory
      val globalMemory =ArrayBuffer[Long]()
      //全局cpu
      val globalVcore =ArrayBuffer[Long]()
       //已使用memory
       val useredMemory =ArrayBuffer[Long]()
      //已使用cpu
       val useredVcore =ArrayBuffer[Long]()

      if(group_queue(group) == "") {
        for(i <- 0 until queueNameListSize) {
          //全局最大内存
          globalMemory += (Json.parse((childQueues \\ "maxResources")(i)
            .toString()) \ "memory").toString().toLong
          //全局最大CPU数
          globalVcore += (Json.parse((childQueues \\ "maxResources")(i)
            .toString()) \ "vCores").toString().toLong
          //已使用最大内存数
          useredMemory += (Json.parse((childQueues \\ "usedResources")(i)
            .toString()) \ "memory").toString().toLong
          //已使用最大CPU数
          useredVcore += (Json.parse((childQueues \\ "usedResources")(i)
            .toString()) \ "vCores").toString().toLong
           }
        //资源度量计算

        resourceRate = Math.round((useredMemory.sum * 0.7 + useredVcore.sum * 0.3)
          /(globalMemory.max * 0.7 + globalVcore.max * 0.3) * 100)
        //内存使用占比
        rateMemoryRate =Math.round((useredMemory.max * 1.0/globalMemory.max * 1.0) * 100)
      }
      //遍历数据，获取相关计算指标
      for(i <- 0 until queueNameListSize){
        val queue = childQueues(i)
        //队列名称
        val queueName = queue \ "queueName"
        if(queueName.toString() == "\"" + group_queue(group)+ "\"") {
          //该队列最大资源
          val maxMemoryJson = Json.parse((queue \ "maxResources").toString())
          val maxMemory: Long = (maxMemoryJson \ "memory").toString().toLong / 1024
          val maxVCores: Long = (maxMemoryJson \ "vCores").toString().toLong / 1
          //该队列已使用资源
          val usedResources = Json.parse((queue \ "usedResources").toString())
          val usedMemory: Long = (usedResources \ "memory").toString().toLong / 1024
          val usedCores: Long = (usedResources \ "vCores").toString().toLong / 1

          //资源度量计算
           resourceRate = Math.round((usedMemory * 0.7 + usedCores * 0.3)
            / (maxMemory * 0.7 + maxVCores * 0.3) * 100)

          //内存使用占比
          rateMemoryRate =Math.round((usedMemory * 1.0/maxMemory * 1.0) * 100)
           }
        }
         val rateJson = "{\"resourceRate\":" + "\"" + resourceRate + "\",\"rateMemory\":" + "\"" + rateMemoryRate + "\"}"
           rateJson.toString
      }


    //待审核用户
    def auditUser() :Long= {
      DB.withConnection { implicit connection =>
       val audit = SQL("select count(distinct name) as tatol " +
          "from user where audit = 0")
       val auditUser = audit().map(row =>
        row [Long]("tatol")
        ).toList
        auditUser(0)
      }
    }

    //用户统计
  def userCount(): List[String] = {
    DB.withConnection("default") { implicit connection =>
      val user_group = SQL("select name from user_group")
      val users = user_group().map(row =>
        row[String]("name")
      ).toList
      users.toList
    }
  }

  /**
   * 获取用户组和队列映射关系
   * @return
   */
  def find_group_queue(): Map[String,String] = {
    DB.withConnection("default") { implicit connection =>
      var group_queue:Map[String,String] = Map()
      SQL("select `group`,queue from user_group group by `group`,queue")().foreach { row =>
          group_queue += (row[String]("group") -> row[String]("queue"))
      }
      group_queue
    }
  }
  case class group_queue_Info(group: String, queue: String)

}
