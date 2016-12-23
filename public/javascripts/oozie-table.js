var EditableTable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }


            var oTable = $('#editable-sample').dataTable({
                "aLengthMenu": [
                    [5, 10,15, 20, -1],
                    [5, 10,15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 10,
                "sDom": "<'row'<'col-lg-6'l><'col-lg-6'f>r>t<'row'<'col-lg-6'i><'col-lg-6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_ 条记录",
                    "oPaginate": {
                        "sPrevious": "上一页",
                        "sNext": "下一页"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });
            jQuery('#editable-sample_wrapper .dataTables_filter input').addClass("form-control meduim"); // modify table search input
            jQuery('#editable-sample_wrapper .dataTables_length select').addClass("form-control small"); // modify table per page dropdown

            var nEditing = null;

            $('.bulkToolbarBtn').on("click", function (e) {
                e.preventDefault();

                  if ($(this).data("operation") == "kill"){
                       var _ids = [];
                           $("#editable-sample").find(":checkbox:checked").each(function(){
                              var val = $(this).parents('tr').find("td:eq(7)").text();
                              _ids.push(val);
                           });

                           if(_ids.length<1){
                                return
                           }

                                var ids=arrayToJson(_ids)

                                      $.post("/workflows/kill",
                                        {
                                          "ids": ids,
                                          "action": "what"
                                        },
                                        function (response) {

                                                swal({
                                                                                                    title: "finsh!",
                                                                                                    text: "操作完成",
                                                                                                    type: "success",
                                                                                                    showCancelButton: false,
                                                                                                    confirmButtonText: "确定",
                                                                                                    closeOnConfirm: true,
                                                                                                    closeOnCancel: false },
                                                                                                    function(isConfirm){
                                                                                                              refreshRunning()
                                                                                                          });

                                      });



                    }else if($(this).data("operation") == "resume"){
                                                       var _ids = [];
                                                           $("#editable-sample").find(":checkbox:checked").each(function(){
                                                              var val = $(this).parents('tr').find("td:eq(7)").text();
                                                              _ids.push(val);
                                                           });

                                                           if(_ids.length<1){
                                                                return
                                                           }

                                                                var ids=arrayToJson(_ids)

                                                                      $.post("/workflows/resume",
                                                                        {
                                                                          "ids": ids,
                                                                          "action": "what"
                                                                        },
                                                                        function (response) {

                                                                                swal({
                                                                                                                                    title: "finish!",
                                                                                                                                    text: "操作完成",
                                                                                                                                    type: "success",
                                                                                                                                    showCancelButton: false,
                                                                                                                                    confirmButtonText: "确定",
                                                                                                                                    closeOnConfirm: true,
                                                                                                                                    closeOnCancel: false },
                                                                                                                                    function(isConfirm){
                                                                                                                                              refreshRunning()
                                                                                                                                          });

                                                                      });





                    }else{
                                               var _ids = [];
                                                   $("#editable-sample").find(":checkbox:checked").each(function(){
                                                      var val = $(this).parents('tr').find("td:eq(7)").text();
                                                      _ids.push(val);
                                                   });

                                                   if(_ids.length<1){
                                                        return
                                                   }

                                                        var ids=arrayToJson(_ids)

                                                              $.post("/workflows/suspend",
                                                                {
                                                                  "ids": ids,
                                                                  "action": "what"
                                                                },
                                                                function (response) {

                                                                        swal({
                                                                                                                            title: "finish!",
                                                                                                                            text: "操作完成",
                                                                                                                            type: "success",
                                                                                                                            showCancelButton: false,
                                                                                                                            confirmButtonText: "确定",
                                                                                                                            closeOnConfirm: true,
                                                                                                                            closeOnCancel: false },
                                                                                                                            function(isConfirm){
                                                                                                                                      refreshRunning()
                                                                                                                                  });

                                                              });
                    }

            });




            function arrayToJson(o) {
                var r = [];
                if (typeof o == "string") return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
                if (typeof o == "object") {
                    if (!o.sort) {
                        for (var i in o)
                            r.push(i + ":" + arrayToJson(o[i]));
                        if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
                            r.push("toString:" + o.toString.toString());
                        }
                        r = "{" + r.join() + "}";
                    } else {
                        for (var i = 0; i < o.length; i++) {
                            r.push(arrayToJson(o[i]));
                        }
                        r = "[" + r.join() + "]";
                    }
                    return r;
                }
                return o.toString();
            }



        }

    };

}();

    var inited=false

     function refreshRunning() {

            $(document).ready(function(){
                $.ajax({
                    type:"GET",
                    url:"/joblist",
                    dataType:"json",
                    data:{jobtype:'wf'},
                    success:function(data){
                        var head= "<thead><tr><th></th><th>Submission</th><th>Status</th><th>Name</th><th>Progess</th><th>Submitter</th><th>Last Modified</th><th>Id</th></tr></thead><tbody>"
                            var datamid = eval(data);
                            for (var i = 0; i < datamid.length; i++) {
                                        var pro = new progress({
                                        width : 100,//进度条宽度
                                        height: 20,//进度条高度
                                        bgColor : "#3E4E5E",//背景颜色
                                        proColor : "#009988",//前景颜色
                                        fontColor : "#FFFFFF",//显示字体颜色
                                        val : 100,//默认值
                                        text:"#*val*#%",//显示文字信息
                                        showPresent : true,
                                        completeCallback:function(val){
                                            console.log('已完成');
                                        },
                                        changeCallback:function(val){
                                            console.log('当前进度为'+val+'%');
                                        }
                                    });
                                  var url = "/workflows/details?id="+datamid[i].id
                                head += "<tr><td style=\"text-align:center\"><input type=\"checkbox\" ></td><td>" + new Date(datamid[i].createdTime).toLocaleString() + "</td><td>" + switchState(datamid[i].status) + "</td><td>" + datamid[i].appName + "</td><td><div class=\"pro\">"+pro.getBody().outerHTML+"</div></td><td>"+datamid[i].user +"</td><td>"+new Date(datamid[i].lastModTime).toLocaleString()+"</td><td><a href="+url+">"+datamid[i].id+"</a></td></tr>";
                            };


                        head += "</tbody>";
                        $('#editable-sample').html(head);

                            if(!inited){
                                  jQuery(document).ready(function() {
                                                            EditableTable.init();
                                                        });
                                                        inited =true
                            }

                    }
                });
            });


     }


