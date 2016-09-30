function editRowc(oTable, nRow, myid,isNew) {
    var aData = oTable.fnGetData(nRow);
    var jqTds = $('>td', nRow);

    $.ajax({
        type: "GET",
        url: "/names",
        dataType: "json",
        success: function (data) {
            var arr = eval(data);
            var names = '<select class="form-control chosen-select">';
            for (var i = 0; i < arr.length; i++) {
                names += '<option>' + arr[i] + '</option>';
            }

            names += '</select>';
            var ips =null;
            var host=null;

                jqTds[0].innerHTML = '<textarea class=\"form-control autogrow\"   data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"请输产品单元名称\" style=\"width:100%;\">'+aData[0]+'</textarea>'
                jqTds[1].innerHTML = '<textarea class=\"form-control autogrow\"   data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"请输入产品描述\" style=\"width:100%;\">'+aData[1]+'</textarea>';
                jqTds[2].innerHTML = '<textarea class=\"form-control autogrow\"   data-validate=\"minlength[10]\" rows=\"5\" placeholder=\"请输联系人\" style=\"width:100%;\">'+aData[2]+'</textarea>'
                jqTds[3].innerHTML = names;
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


function restoreRowc(oTable, nRow) {
    var aData = oTable.fnGetData(nRow);
    var jqTds = $('>td', nRow);

    for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
        oTable.fnUpdate(aData[i], nRow, i, false);
    }

    oTable.fnDraw();
}


function initProductData() {

    $('#dynamic-table').dataTable({
        "aaSorting": [[4, "desc"]]
    });


    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#editable-sample3').dataTable({
        "aoColumnDefs": [
            {"bSortable": false, "aTargets": [0], sDefaultContent: '', aTargets: ['_all']}
        ],
        "aaSorting": [[1, 'asc']]
    });

    var nEditing = null;

    //新增
    $('#editable-sample_new4').click(function (e) {
        e.preventDefault();
        var aiNew = oTable.fnAddData(['', '', '', '',
            '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="new" href="">取消</a>'
        ]);
        var nRow = oTable.fnGetNodes(aiNew[0]);
        editRowc(oTable, nRow, 0,true);
        nEditing = nRow;
    });

    //保存
    $('#editable-sample3 a.edit').live('click', function (e) {
        e.preventDefault();

        /* Get the row as a parent of the link that was clicked on */
        var nRow = $(this).parents('tr')[0];

        if (nEditing !== null && nEditing != nRow) {
            /* Currently editing - but not this row - restore the old before continuing to edit mode */
            restoreRowc(oTable, nEditing);
            editRowc(oTable, nRow, 0,false);
            nEditing = nRow;
        } else if (nEditing == nRow && this.innerHTML == "保存") {
            /* Editing this row and want to save it */
            var v_id = $(e.target).attr('myid');

            var jqInputs = $('textarea', nEditing);

            var jqSelect = $('select', nEditing);
            var $unit = jqInputs[0].value;
            var $desc = jqInputs[1].value;
             var $contact = jqInputs[2].value;


            var $name = jqSelect[0].value;

            //id:Int,ip:String,host: String,role:String,name:String
            $(document).ready(function () {
                $.ajax({
                    type: "GET",
                    url: "/addproduct",
                    data: {id: v_id, unit: $unit, desc: $desc, contact: $contact, cluster: $name},
                    dataType: "text",
                    success: function (data) {
                        swal({
                                title: "操作完成!",
                                text: data + " /产品单元信息更新成功",
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
            editRowc(oTable, nRow, v_id,false);
            nEditing = nRow;
        }
    });


                    $('#editable-sample3 a.cancel').live('click', function (e) {
                        e.preventDefault();
                        if ($(this).attr("data-mode") == "new") {
                            var nRow = $(this).parents('tr')[0];
                            oTable.fnDeleteRow(nRow);
                        } else {
                            restoreRowc(oTable, nEditing);
                            nEditing = null;
                        }
                    });


    //删除
    $('#editable-sample3 a.delete').live('click', function (e) {
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
                            url: "/rmproduct",
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