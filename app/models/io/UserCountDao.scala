package models.io

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json.{JsValue, Json}

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

  /**
   * 用户组资源计算
   * @return
   */
      def userResourceRate (username:String) :String ={
      //获取登录用户所属组
      val group = UserCountDao.userBygroup(username)

      //用户组与队列映射
      val group_queue = Map[String,String](
        "admin" -> "\"root.pt_UserGrowth\"",
        "user" -> "\"root.default\"",
        "test" -> "\"root.default\""
      )
      /**
       * 接口调用数据
       */
      val scheduleryarn = scala.io.Source.fromURL("http://10.77.136.159:8088/ws/v1/cluster/scheduler").mkString
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
      var rateMemory = 0.00
      //遍历数据，获取相关计算指标
      for(i <- 0 until queueNameListSize){
        val queue = childQueues(i)
        //队列名称
        val queueName = queue \ "queueName"
        if(queueName.toString() == group_queue(group)) {
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
           rateMemory =Math.round((usedMemory/maxMemory) * 100)
          println(rateMemory)

           }
        }
         val rateJson = "{\"resourceRate\":" + "\"" + resourceRate + "\",\"rateMemory\":" + "\"" + rateMemory + "\"}"
//          resourceRate.toString
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
