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

            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" class="form-control1 small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<a class="cancel" href="">删除</a>';
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
                oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 5, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
                oTable.fnDraw();
            }

            var oTable = $('#editable-sample').dataTable({
                "bPaginate": false, //翻页功能
                "bLengthChange": false, //改变每页显示数据数量
                "bFilter": false, //过滤功能
                "bSort": false, //排序功能
                "bInfo": false,//页脚信息
                "bAutoWidth": false //自动宽度
            });

            //jQuery('#editable-sample_wrapper .dataTables_filter input').addClass("form-control meduim"); // modify table search input
            //jQuery('#editable-sample_wrapper .dataTables_length select').addClass("form-control small"); // modify table per page dropdown

            var nEditing = null;

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '',  '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#editable-sample a.delete').live('click', function (e) {
                e.preventDefault();
                            var nRow = $(this).parents('tr')[0];
                              var $thisTD = $(this).parents('tr').find("td:eq(0)");


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
                                                    url:"/rmgroup",
                                                    data:{email:$thisTD.text()},
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
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Save") {
                    /* Editing this row and want to save it */

                            var jqInputs = $('input', nEditing);
                                    var $email = jqInputs[0].value;
                                    var $name = jqInputs[1].value;
                                    var $group = jqInputs[2].value;
                                    var $queue = jqInputs[3].value;

                                    $(document).ready(function(){
                                            $.ajax({
                                                type:"GET",
                                                url:"/addgroup",
                                                data:{email:$email,name:$name,group:$group,queue:$queue},
                                                dataType:"text",
                                                success:function(data){
                                                    saveRow(oTable, nEditing);
                                                    nEditing = null;
                                                    swal("操作成功!",$email+" "+data,"success");
                                                }
                                            });
                                    });



                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();