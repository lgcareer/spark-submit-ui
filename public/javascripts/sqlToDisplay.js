/**
 * Created by jhazheng on 16/7/26.
 */


var DATA = "";
$(document).ready(function () {
    var myTextarea = document.getElementById('sql');
    var CodeMirrorEditor = CodeMirror.fromTextArea(myTextarea, {
        mode: "text/x-hive",
        theme:"neo",
        lineNumbers: true,
        autofocus:true
    });
    CodeMirrorEditor.setSize('auto', 'auto');
    $('#sql').focus();
    $("#submit").click(function () {
        $("#submit").addClass("fa fa-spinner fa-pulse fa-fw");
        console.log(CodeMirrorEditor.getValue());
        $.ajax({
            "data": {
                "sql": CodeMirrorEditor.getValue()
            },
            "method": "POST",
            "url": "/executesql",
            "dataType": "json",
            "success": function (data) {
                DATA = data;
                resultToTable();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#submit").removeClass().addClass("fa fa-play");
                alert(errorThrown);

            }
        });

        resultToCharts();
    });

});


$(function () {
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        // 获取已激活的标签页的名称
        var activeTab = e.target.href;
    });
});

function resultToCharts() {
    console.log("i'm here.....");
    $('#generate').click(function () {
        var header = DATA.header;
        var sql_data = DATA.data;
        var categories = [];
        var value = [];
        var x_index = header.indexOf($("#xargs").val());
        var y_index = header.indexOf($("#yargs").val());

        for (var j = 0; j < sql_data.length; j++) {
            categories.push(sql_data[j][x_index]);
            value.push(sql_data[j][y_index]);
        }
        console.log("click");

        $("#charts").highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: '数据图表',
                x: -20
            },
            xAxis: {
                categories: categories
            },
            yAxis: {
                min: 0,
                title: {
                    text: $("#xargs").val()
                }
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            credits: {
                text: 'DSP-NEPTUNE©️',
                href: 'http://t.cn'
            },
            series: [{
                name: $("#yargs").val(),
                data: value
            }]
        });
    });
}
function resultToTable() {

    if (DATA != "") {
        $("#submit").removeClass().addClass("fa fa-play");
        $("#submit").addClass("fa fa-play");
        toTab();
        var header = DATA.header;
        var sql_data = DATA.data;
        console.log(DATA);
        var result = "";
        var tr = "";
        var choice = "";
        for (var i = 0; i < header.length; i++) {
            tr += "<th>" + header[i] + "</th>";
            choice += "<option>" + header[i] + "</option>";
        }
        result += "<thead><tr>" + tr + "</tr></thead>";

        for (var j = 0; j < sql_data.length; j++) {
            tr = "";
            for (var i = 0; i < sql_data[j].length; i++) {
                tr += "<td>" + sql_data[j][i] + "</td>";
            }
            if (j % 2 == 0) {
                result += "<tr class='gray '>" + tr + "</tr>";
            } else {
                result += "<tr>" + tr + "</tr>";
            }

        }
        var kk = "<table class='table table-striped table-bordered table-hover table-condensed' id='example'>" + result + "</table>";
        $("#tables").html(kk);
        $("#xargs").html(choice + '<option selected = "selected">请选择X坐标:</option>');
        $("#yargs").html(choice + '<option selected = "selected">请选择Y坐标:</option>');
        $('#example').dataTable( {
            destroy: true,
            data: DATA.data

        } );
    }


}

function toTab() {

    var htmls = document.getElementById("readtodisplay").innerHTML;
    $("#todisplay").html(htmls);

}

highlightCode = function() { Prism.highlightElement($("#sql")); };
