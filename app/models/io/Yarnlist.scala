package models.io

/**
  * Created by manbu on 16/5/16.
 *
*name:TeraGen
*finishedTime:1.46115086317E12
*amHostHttpAddress:h136162.mars.grid.sina.com.cn:9044
*state:FINISHED
*queue:root.pt_user_increase
*trackingUI:History
*applicationType:MAPREDUCE
*memorySeconds:315783.0
*trackingUrl:http://h136159.mars.grid.sina.com.cn:8088/proxy/application_1461150703166_0001/jobhistory/job/job_1461150703166_0001
*applicationTags:
*clusterId:1.461213244716E12
*id:application_1461150703166_0001
*elapsedTime:83399.0
*finalStatus:SUCCEEDED
*amContainerLogs:http://h136162.mars.grid.sina.com.cn:9044/node/containerlogs/container_1461150703166_0001_01_000001/weibo_user_increase
*startedTime:1.461150779771E12
*user:weibo_user_increase
 *
 *
 *
 */
case class Yarnlist (name:String,jobid:String,status:String)  {
     val app_name = name
     val app_id = jobid
     val job_status = status

}
