package models

/**
  * Created by king on 2016/11/2.
  *         {
            "appName": "map-reduce-wf",
            "externalId": null,
            "conf": null,
            "run": 0,
            "acl": null,
            "appPath": null,
            "parentId": null,
            "lastModTime": "Tue, 01 Nov 2016 09:32:12 GMT",
            "consoleUrl": "http:\/\/hadoop01.localdomain:11000\/oozie?job=0000004-161101154203945-oozie-hado-W",
            "createdTime": "Tue, 01 Nov 2016 09:31:36 GMT",
            "startTime": "Tue, 01 Nov 2016 09:31:36 GMT",
            "toString": "Workflow id[0000004-161101154203945-oozie-hado-W] status[SUCCEEDED]",
            "id": "0000004-161101154203945-oozie-hado-W",
            "endTime": "Tue, 01 Nov 2016 09:32:12 GMT",
            "user": "hadoop",
            "actions": [

            ],
            "status": "SUCCEEDED",
            "group": null
        },
  */
case class WorkFlowData(
                       appName:String,
                       externalId:String,
                       conf:String,
                       run:Int,
                       acl:String,
                       appPath:String,
                       parentId:String,
                       lastModTime:String,
                       consoleUrl:String,
                       createdTime:String,
                       startTime:String,
                       id:String,
                       endTime:String,
                       user:String,
                       status:String,
                       group:String
                       )
