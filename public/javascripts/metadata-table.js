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

            function editRow(oTable, nRow,myid) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[3] + '">';
                jqTds[4].innerHTML = '<a myid='+myid+' class="edit" href="">保存</a>';
                jqTds[5].innerHTML = '<a class="cancel" href="">取消</a>';
            }

            function saveRow(oTable, nRow,myid) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a  myid='+myid+'class="edit" href="">编辑</a>', nRow, 4, false);
                oTable.fnUpdate('<a myid='+myid+' class="delete" href="">删除</a>', nRow, 5, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">编辑</a>', nRow, 4, false);
                oTable.fnDraw();
            }

            var oTable = $('#editable-sample').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 15,
                "sDom": "<'row'<'col-lg-6'l><'col-lg-6'f>r>t<'row'<'col-lg-6'i><'col-lg-6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_ 条记录",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
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

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                        '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="new" href="">取消</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow,0);
                nEditing = nRow;
            });

            $('#editable-sample a.delete').live('click', function (e) {
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
                                                    url:"/rm",
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

            $('#editable-sample a.cancel').live('click', function (e) {
                e.preventDefault();
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
            });

            $('#editable-sample a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];


                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow,0);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "保存") {
                    /* Editing this row and want to save it */
                           var v_id = $(e.target).attr('myid');

                            var jqInputs = $('input', nEditing);
                                    var $name = jqInputs[0].value;
                                    var $unit = jqInputs[1].value;
                                    var $version = jqInputs[2].value;
                                    var $url = jqInputs[3].value;

                                    $(document).ready(function(){
                                            $.ajax({
                                                type:"GET",
                                                url:"/update",
                                                data:{id:v_id,name:$name,unit:$unit,version:$version,url:$url},
                                                dataType:"text",
                                                success:function(data){
                                                    saveRow(oTable, nEditing,v_id);
                                                    nEditing = null;
                                                                                                              swal({
                                                                                                              title: "操作完成!",
                                                                                                              text: "操作成功,"+$name+" 添加(修改成功)",
                                                                                                              type: "success",
                                                                                                              showCancelButton: false,
                                                                                                              confirmButtonText: "确定",
                                                                                                              closeOnConfirm: true,
                                                                                                              closeOnCancel: false },
                                                                                                              function(isConfirm){
                                                                                                                        window.location="/metadata";
                                                                                                                    });
                                                }
                                            });
                                    });

                } else {
                    /* No edit in progress - let's start one */
                    var v_id = $(e.target).attr('myid');
                    editRow(oTable, nRow,v_id);
                    nEditing = nRow;
                }
            });
        }

    };

}();