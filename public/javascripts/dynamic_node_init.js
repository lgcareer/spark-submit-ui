function initmultinodes(){



    $.ajax({
        type: "GET",
        url: "/names",
        dataType: "json",
        success: function (data) {
            var arr = eval(data);
            var head = '<select class="form-control chosen-select">';
            for (var i = 0; i < arr.length; i++) {
                head += '<option>' + arr[i] + '</option>';
            }

            head += '</select>';
            var kk = "$(function () {var config = {'.chosen-select': {},'.chosen-select-deselect': {allow_single_deselect: true},'.chosen-select-no-single': {disable_search_threshold: 10},'.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},'.chosen-select-width': {width: \"95%\"} }for (var selector in config) {$(selector).chosen(config[selector]);} });";

            var roles = '<select data-placeholder="请选择角色..." id="s2example-1" class="form-control chosen-select" multiple><option>namenode</option><option>secondarynamenode</option><option>datanode</option><option>jobtracker</option><option>tasktracker</option><option>resourcemanager</option><option>nodemanager</option><option>journalnode</option><option>dfszkfailovercontroller</option><option>client</option><option>zookeeper</option><option>master</option><option>regionserve</option></select>';
            console.log("<div class=\"form-group\"><label class=\"control-label\" for=\"about\">请输入IP列表换行分隔</label> <textarea class=\"form-control autogrow\" name=\"about\" id=\"about\" data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"ip.......\"></textarea> <label class=\"control-label\" for=\"about\">请输入hostname列表换行分隔</label> <textarea class=\"form-control autogrow\" name=\"about\" id=\"about\" data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"hostname.......\"></textarea>"+ "<label class=\"control-label\" for=\"about\">请选择集群名称</label>" +  head + "<label class=\"control-label\" for=\"about\">请选择节点角色</label>" + roles + "<script>" + kk + "</script>" + "</div>");
            $('#editable-sample_new3').click(function(e){
                swal({   title: "多节点数据",
                        text: "<div class=\"form-group\"> <label class=\"control-label\" for=\"about\">请输入IP列表换行分隔</label> <textarea class=\"form-control autogrow\" name=\"about\" id=\"about\" data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"ip.......\"></textarea> <label class=\"control-label\" for=\"about\">请输入hostname列表换行分隔</label> <textarea class=\"form-control autogrow\" name=\"about\" id=\"about\" data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"hostname.......\"></textarea>"+ "<label class=\"control-label\" for=\"about\">请选择集群名称</label>" +  head + "<label class=\"control-label\" for=\"about\">请选择节点角色</label>" + roles + "<script>" + kk + "</script>" + "</div>",
                        html:true,
                        showCancelButton: true,
                        closeOnConfirm: false
                });

            });

        }
    });


}

function editRowb(oTable, nRow, myid,isNew) {
    var aData = oTable.fnGetData(nRow);
    var jqTds = $('>td', nRow);

    $.ajax({
        type: "GET",
        url: "/names",
        dataType: "json",
        success: function (data) {
            var arr = eval(data);
            var head = '<select class="form-control chosen-select">';
            for (var i = 0; i < arr.length; i++) {
                head += '<option>' + arr[i] + '</option>';
            }

            head += '</select>';
            var ips =null;
            var host=null;

                     if(!isNew){
                             if(aData[0]!=null){
                                 var reg=new RegExp("<br>","g");
                                   ips=aData[0].replace(reg,"\n");
                                      }
                                 if(aData[1]!=null){
                                           var reg=new RegExp("<br>","g");
                                            host=aData[1].replace(reg,"\n");
                                   }
                     }else{
                        ips='';
                        host='';
                     }

                jqTds[0].innerHTML = '<textarea class=\"form-control autogrow\"   data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"请输入IP列表换行分隔\" style=\"width:100%;\">'+ips+'</textarea>'
                jqTds[1].innerHTML = '<textarea class=\"form-control autogrow\"   data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"请输入hostname列表换行分隔\" style=\"width:100%;\">'+host+'</textarea>';
                jqTds[2].innerHTML = '<select data-placeholder="请选择角色..." class="form-control chosen-select" style="width:100%;" multiple><option>namenode</option><option>secondarynamenode</option><option>datanode</option><option>jobtracker</option><option>tasktracker</option><option>resourcemanager</option><option>nodemanager</option><option>journalnode</option><option>dfszkfailovercontroller</option><option>client</option><option>zookeeper</option><option>master</option><option>regionserve</option></select>';
                jqTds[3].innerHTML = head;
                jqTds[4].innerHTML = '<a myid=' + myid + ' class="edit" href="">保存</a>';
                jqTds[5].innerHTML = '<a class="cancel" href="">取消</a>';

                var config = {
                    '.chosen-select': {},
                    '.chosen-select-deselect': {allow_single_deselect: true},
                    '.chosen-select-no-single': {disable_search_threshold: 10},
                    '.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},
                    '.chosen-select-width': {width: "95%"}
                }
                for (var selector in config) {
                    $(selector).chosen(config[selector]);
                }

        }
    });

}


function restoreRowb(oTable, nRow) {
    var aData = oTable.fnGetData(nRow);
    var jqTds = $('>td', nRow);

    for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
        oTable.fnUpdate(aData[i], nRow, i, false);
    }

    oTable.fnDraw();
}


function initNodeData() {

    $('#dynamic-table').dataTable({
        "aaSorting": [[4, "desc"]]
    });


    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#editable-sample2').dataTable({
        "aoColumnDefs": [
            {"bSortable": false, "aTargets": [0], sDefaultContent: '', aTargets: ['_all']}
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
        editRowb(oTable, nRow, 0,true);
        nEditing = nRow;
    });

    //保存
    $('#editable-sample2 a.edit').live('click', function (e) {
        e.preventDefault();

        /* Get the row as a parent of the link that was clicked on */
        var nRow = $(this).parents('tr')[0];

        if (nEditing !== null && nEditing != nRow) {
            /* Currently editing - but not this row - restore the old before continuing to edit mode */
            restoreRowb(oTable, nEditing);
            editRowb(oTable, nRow, 0,false);
            nEditing = nRow;
        } else if (nEditing == nRow && this.innerHTML == "保存") {
            /* Editing this row and want to save it */
            var v_id = $(e.target).attr('myid');

            var jqInputs = $('textarea', nEditing);

            var jqSelect = $('select', nEditing);
            var $ip = jqInputs[0].value;
            var $host = jqInputs[1].value;

            if (jqSelect.val() != null) {
                var _list = arrayToJson(jqSelect.val())
            } else {
                alert("请选择角色");
                return;
            }

            var $name = jqSelect[1].value;

            //id:Int,ip:String,host: String,role:String,name:String
            $(document).ready(function () {
                $.ajax({
                    type: "GET",
                    url: "/addnode",
                    data: {id: v_id, ip: $ip, host: $host, role: _list, name: $name},
                    dataType: "text",
                    success: function (data) {
                        swal({
                                title: "操作完成!",
                                text: data + " /节点信息更新成功",
                                type: "success",
                                showCancelButton: false,
                                confirmButtonText: "确定",
                                closeOnConfirm: true,
                                closeOnCancel: false
                            },
                            function (isConfirm) {
                                window.location = "/metadata";
                                nEditing = null;

                            });


                    }
                });
            });

        } else {
            /* No edit in progress - let's start one */
            var v_id = $(e.target).attr('myid');
            editRowb(oTable, nRow, v_id,false);
            nEditing = nRow;
        }
    });


                    $('#editable-sample2 a.cancel').live('click', function (e) {
                        e.preventDefault();
                        if ($(this).attr("data-mode") == "new") {
                            var nRow = $(this).parents('tr')[0];
                            oTable.fnDeleteRow(nRow);
                        } else {
                            restoreRowb(oTable, nEditing);
                            nEditing = null;
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
                text: "确定删除 " + $(this).parents('tr').find("td:eq(0)").text() + "?",
                type: "warning",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确认",
                cancelButtonText: "取消",
                showCancelButton: true,
                closeOnConfirm: false,
            },
            function (isConfirm) {
                if (isConfirm) {

                    $(document).ready(function () {
                        $.ajax({
                            type: "GET",
                            url: "/rmnode",
                            data: {id: $v_id},
                            dataType: "text",
                            success: function (data) {
                                oTable.fnDeleteRow(nRow);
                                swal("操作成功", $thisTD.text() + " " + data, "success");

                            }
                        });
                    });

                }
            });

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