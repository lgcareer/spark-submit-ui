


            function editRowb(oTable, nRow,myid) {
                     var aData = oTable.fnGetData(nRow);
                     var jqTds = $('>td', nRow);

                         $.ajax({
                             type:"GET",
                             url:"/names",
                             dataType:"json",
                             success:function(data){
                                         var arr=eval(data);
                                         var head= '<select>';
                                         for(var i=0; i < arr.length; i++){
                                                head += '<option>'+arr[i]+'</option>';
                                         }

                                         head+='</select>';
                                        jqTds[3].innerHTML=head;

                                                       }
                                                     });

                jqTds[0].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[1] + '">';
                //jqTds[3].innerHTML = '<select><option>Apple</option><option>Apple2</option><option>角色1</option><option>角色2</option></select>'
                jqTds[2].innerHTML = '<select style="width:100%;" multiple><option>namenode</option><option>secondarynamenode</option><option>datanode</option><option>jobtracker</option><option>tasktracker</option><option>resourcemanager</option><option>nodemanager</option><option>journalnode</option><option>dfszkfailovercontroller</option><option>client</option><option>zookeeper</option><option>master</option><option>regionserve</option></select>';
                jqTds[4].innerHTML = '<a myid='+myid+' class="edit" href="">保存</a>';
                jqTds[5].innerHTML = '<a class="cancel" href="">取消</a>';
            }



                                    function restoreRow(oTable, nRow) {
                                        var aData = oTable.fnGetData(nRow);
                                        var jqTds = $('>td', nRow);

                                        for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                                            oTable.fnUpdate(aData[i], nRow, i, false);
                                        }

                                        oTable.fnDraw();
                                    }





function initNodeData() {

    $('#dynamic-table').dataTable( {
        "aaSorting": [[ 4, "desc" ]]
    } );



    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#editable-sample2').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] ,sDefaultContent: '',  aTargets: [ '_all' ] }
        ],
        "aaSorting": [[1, 'asc']]
    });

                var nEditing = null;

                //新增
                $('#editable-sample_new2').click(function (e) {
                    e.preventDefault();
                    var aiNew = oTable.fnAddData(['', '', '', '',
                            '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="new" href="">取消</a>'
                    ]);
                    var nRow = oTable.fnGetNodes(aiNew[0]);
                    editRowb(oTable, nRow,0);
                    nEditing = nRow;
                });

                          //保存
                            $('#editable-sample2 a.edit').live('click', function (e) {
                                e.preventDefault();

                                /* Get the row as a parent of the link that was clicked on */
                                var nRow = $(this).parents('tr')[0];

                                if (nEditing !== null && nEditing != nRow) {
                                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                                    restoreRow(oTable, nEditing);
                                    editRowb(oTable, nRow,0);
                                    nEditing = nRow;
                                } else if (nEditing == nRow && this.innerHTML == "保存") {
                                    /* Editing this row and want to save it */
                                           var v_id = $(e.target).attr('myid');

                                            var jqInputs = $('input', nEditing);

                                            var jqSelect = $('select', nEditing);
                                                    var $ip = jqInputs[0].value;
                                                    var $host = jqInputs[1].value;

                                                        if(jqSelect.val()!=null){
                                                          var _list = arrayToJson(jqSelect.val())
                                                        }else{
                                                            alert("请选择角色");
                                                            return;
                                                        }

                                                     var $name =jqSelect[1].value;

                                                    //id:Int,ip:String,host: String,role:String,name:String
                                                    $(document).ready(function(){
                                                            $.ajax({
                                                                type:"GET",
                                                                url:"/addnode",
                                                                data:{id:v_id,ip:$ip,host:$host,role:_list,name:$name},
                                                                dataType:"text",
                                                                success:function(data){
                                                                            swal({
                                                                                                                              title: "操作完成!",
                                                                                                                              text: data+" /节点信息更新成功",
                                                                                                                              type: "success",
                                                                                                                              showCancelButton: false,
                                                                                                                              confirmButtonText: "确定",
                                                                                                                              closeOnConfirm: true,
                                                                                                                              closeOnCancel: false },
                                                                                                                              function(isConfirm){
                                                                                                                                        window.location="/metadata";
                                                                                                                                        nEditing = null;

                                                                                                                                    });


                                                                }
                                                            });
                                                    });

                                } else {
                                    /* No edit in progress - let's start one */
                                    var v_id = $(e.target).attr('myid');
                                    editRowb(oTable, nRow,v_id);
                                    nEditing = nRow;
                                }
                            });




                                        //删除
                                        $('#editable-sample2 a.delete').live('click', function (e) {
                                            e.preventDefault();
                                                        var nRow = $(this).parents('tr')[0];
                                                          var $thisTD = $(this).parents('tr').find("td:eq(0)");

                                                            var $v_id = $(e.target).attr('myid');
                                                                 swal({
                                                                    title: "请确认?",
                                                                    text: "确定删除 "+$(this).parents('tr').find("td:eq(0)").text()+"?",
                                                                    type: "warning",
                                                                    confirmButtonColor: "#DD6B55",
                                                                    confirmButtonText: "确认",
                                                                    cancelButtonText: "取消",
                                                                    showCancelButton: true,
                                                                    closeOnConfirm: false,
                                                                     },
                                                                    function(isConfirm){
                                                                    if (isConfirm) {

                                                                        $(document).ready(function(){
                                                                            $.ajax({
                                                                                type:"GET",
                                                                                url:"/rmnode",
                                                                                data:{id:$v_id},
                                                                                dataType:"text",
                                                                                success:function(data){
                                                                                     oTable.fnDeleteRow(nRow);
                                                                                     swal("操作成功", $thisTD.text()+" "+data, "success");

                                                                                }
                                                                            });
                                                                        });

                                                                       }  });

                                        });



}


/**
array 转json
*/
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