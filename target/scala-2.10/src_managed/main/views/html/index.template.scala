
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Neptun Dashboard")/*1.26*/{_display_(Seq[Any](format.raw/*1.27*/("""
<style type='text/css'>
    #worklist"""),format.raw/*3.14*/("""{"""),format.raw/*3.15*/("""
    width:100%;
    background-color:rgb(100%,100%,90%);
    """),format.raw/*6.5*/("""}"""),format.raw/*6.6*/("""
    #date"""),format.raw/*7.10*/("""{"""),format.raw/*7.11*/("""
    width:50%;
    """),format.raw/*9.5*/("""}"""),format.raw/*9.6*/("""
    #sparkinfo"""),format.raw/*10.15*/("""{"""),format.raw/*10.16*/("""
    width:50%;
    line-height:1.2;
    """),format.raw/*13.5*/("""}"""),format.raw/*13.6*/("""
    .col-md-6 """),format.raw/*14.15*/("""{"""),format.raw/*14.16*/("""
    width: 50%;
    height: 20%;
    """),format.raw/*17.5*/("""}"""),format.raw/*17.6*/("""

    .col_1_of_2.span_1_of_2 """),format.raw/*19.29*/("""{"""),format.raw/*19.30*/("""
    padding: 2px;
    """),format.raw/*21.5*/("""}"""),format.raw/*21.6*/("""
</style>
<!----Calender -------->
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*24.31*/routes/*24.37*/.Assets.at("stylesheets/clndr.css"))),format.raw/*24.72*/("""" type="text/css" />
<script src=""""),_display_(Seq[Any](/*25.15*/routes/*25.21*/.Assets.at("javascripts/underscore-min.js"))),format.raw/*25.64*/("""" type="text/javascript"></script>
            <script src=""""),_display_(Seq[Any](/*26.27*/routes/*26.33*/.Assets.at("javascripts/moment-2.2.1.js"))),format.raw/*26.74*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*27.15*/routes/*27.21*/.Assets.at("javascripts/clndr.js"))),format.raw/*27.55*/("""" type="text/javascript"></script>
            <script src=""""),_display_(Seq[Any](/*28.27*/routes/*28.33*/.Assets.at("javascripts/site.js"))),format.raw/*28.66*/("""" type="text/javascript"></script>
<!----End Calender -------->
    <div class="graphs">
        <div class="col_3">
            <div class="col-md-3 widget widget1">
                <div class="r3_counter_box"><i class="pull-left fa fa-train fa-2x running icon-rounded"></i>
                  <div class="stats">
                    <h5><strong><font color="#17d9d7" id='run'>0</font></strong></h5>
                      <span>运行中</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 widget widget1">
                <div class="r3_counter_box"><i class="pull-left fa fa-check fa-2x complate icon-rounded"></i>
                  <div class="stats">
                    <h5><strong><font color="#11ce76" id='succ'>0</font></strong></h5>
                      <span>成功执行</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 widget widget1">
                <div class="r3_counter_box">
                    <i class="pull-left fa fa-times fa-2x failed icon-rounded"></i>
                    <div class="stats">
                      <h5><strong><font color="#ec0d11" id='fail'>0</font></strong></h5>
                      <span>失败</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 widget">
                <div class="r3_counter_box">
                    <i class="pull-left fa fa-plane fa-2x cordinate icon-rounded"></i>
                    <div class="stats">
                      <h5><strong><font color="#00aced" id='plain'>0</font></strong></h5>
                      <span>计划任务</span>
                    </div>
                </div>
             </div>
            <div class="clearfix"> </div>
      </div>
      <div class="col_1">
            <div id="date" class="col-md-4 span_7" >
              <div class="cal1 cal_2"><div class="clndr"><div class="clndr-controls"><div class="clndr-control-button"><p class="clndr-previous-button">previous</p></div><div class="month">July 2015</div><div class="clndr-control-button rightalign"><p class="clndr-next-button">next</p></div></div><table class="clndr-table" border="0" cellspacing="0" cellpadding="0"><thead><tr class="header-days"><td class="header-day">S</td><td class="header-day">M</td><td class="header-day">T</td><td class="header-day">W</td><td class="header-day">T</td><td class="header-day">F</td><td class="header-day">S</td></tr></thead><tbody><tr><td class="day adjacent-month last-month calendar-day-2015-06-28"><div class="day-contents">28</div></td><td class="day adjacent-month last-month calendar-day-2015-06-29"><div class="day-contents">29</div></td><td class="day adjacent-month last-month calendar-day-2015-06-30"><div class="day-contents">30</div></td><td class="day calendar-day-2015-07-01"><div class="day-contents">1</div></td><td class="day calendar-day-2015-07-02"><div class="day-contents">2</div></td><td class="day calendar-day-2015-07-03"><div class="day-contents">3</div></td><td class="day calendar-day-2015-07-04"><div class="day-contents">4</div></td></tr><tr><td class="day calendar-day-2015-07-05"><div class="day-contents">5</div></td><td class="day calendar-day-2015-07-06"><div class="day-contents">6</div></td><td class="day calendar-day-2015-07-07"><div class="day-contents">7</div></td><td class="day calendar-day-2015-07-08"><div class="day-contents">8</div></td><td class="day calendar-day-2015-07-09"><div class="day-contents">9</div></td><td class="day calendar-day-2015-07-10"><div class="day-contents">10</div></td><td class="day calendar-day-2015-07-11"><div class="day-contents">11</div></td></tr><tr><td class="day calendar-day-2015-07-12"><div class="day-contents">12</div></td><td class="day calendar-day-2015-07-13"><div class="day-contents">13</div></td><td class="day calendar-day-2015-07-14"><div class="day-contents">14</div></td><td class="day calendar-day-2015-07-15"><div class="day-contents">15</div></td><td class="day calendar-day-2015-07-16"><div class="day-contents">16</div></td><td class="day calendar-day-2015-07-17"><div class="day-contents">17</div></td><td class="day calendar-day-2015-07-18"><div class="day-contents">18</div></td></tr><tr><td class="day calendar-day-2015-07-19"><div class="day-contents">19</div></td><td class="day calendar-day-2015-07-20"><div class="day-contents">20</div></td><td class="day calendar-day-2015-07-21"><div class="day-contents">21</div></td><td class="day calendar-day-2015-07-22"><div class="day-contents">22</div></td><td class="day calendar-day-2015-07-23"><div class="day-contents">23</div></td><td class="day calendar-day-2015-07-24"><div class="day-contents">24</div></td><td class="day calendar-day-2015-07-25"><div class="day-contents">25</div></td></tr><tr><td class="day calendar-day-2015-07-26"><div class="day-contents">26</div></td><td class="day calendar-day-2015-07-27"><div class="day-contents">27</div></td><td class="day calendar-day-2015-07-28"><div class="day-contents">28</div></td><td class="day calendar-day-2015-07-29"><div class="day-contents">29</div></td><td class="day calendar-day-2015-07-30"><div class="day-contents">30</div></td><td class="day calendar-day-2015-07-31"><div class="day-contents">31</div></td><td class="day adjacent-month next-month calendar-day-2015-08-01"><div class="day-contents">1</div></td></tr></tbody></table></div></div>
            </div>
          <div id="sparkinfo"  class="col-md-4 span_4">
              <div   class="col_2">
                  <div class="box_1">
                      <div class="col-md-6 col_1_of_2 span_1_of_2">
                          <a class="tiles_info">
                              <div class="tiles-head tw1">
                                  <div class="text-center">Worker节点数</div>
                              </div>
                              <div class="tiles-body tw2" >
                                      <h2 id="alive_workers"></h2>
                              </div>
                          </a>
                      </div>
                      <div class="col-md-6 col_1_of_2 span_1_of_2">
                          <a class="tiles_info">
                              <div class="tiles-head tw1">
                                  <div class="text-center">Cores使用情况</div>
                              </div>
                              <div class="tiles-body tw2" >
                                  <h2 id="cores"></h2>
                              </div>
                          </a>
                      </div>

                      <div class="col-md-6 col_1_of_2 span_1_of_2">
                          <a class="tiles_info tiles_blue">
                              <div class="tiles-head tiles_blue1">
                                  <div class="text-center">Spark内存使用情况</div>
                              </div>
                              <div class="tiles-body blue1" >
                                  <h3 id="memory"></h3>
                              </div>
                          </a>
                      </div>
                      <div class="col-md-6 col_1_of_2 span_1_of_2">
                              <a class="tiles_info tiles_blue">
                                  <div class="tiles-head tiles_blue1">
                                      <div class="text-center">应用程序运行情况</div>
                                  </div>
                                  <div class="tiles-body blue1" >
                                  <h3 id="applications"></h3>
                                  </div>
                              </a>
                      </div>
                      <div class="col-md-6 col_1_of_2 span_1_of_2">
                          <a class="tiles_info">
                              <div class="tiles-head fb1">
                                  <div class="text-center">Drivers运行情况</div>
                              </div>
                              <div class="tiles-body fb2" >
                              <h3 id="drivers"></h3>
                              </div>
                          </a>
                      </div>
                      <div class="col-md-6 col_1_of_2 span_1_of_2">
                          <a class="tiles_info tiles_blue">
                              <div class="tiles-head fb1">
                                  <div class="text-center">HA Master状态</div>
                              </div>
                              <div class="tiles-body fb1" id="status">
                              </div>
                          </a>
                      </div>
                      <div class="clearfix"> </div>
                  </div>
              </div>
          </div>
          <div class="clearfix"></div>

      </div>
        <div class="span_11">

            <div id = 'worklist' class="col-md-4 stats-info">
                <div class="panel-heading">
                    <h1 class="panel-title"><b>Workers List</b></h1>
                </div>
                <div class="panel-body">
                    spark://h136159.mars.grid.sina.com.cn:8080
                        <div class="text-success pull-right">Alive</div>
                    <table id='work_table'  class="table table-striped">
                        <thead>
                        <tr class="success">
                            <th>id</th>
                            <th>host</th>
                            <th>cores</th>
                            <th>coresused</th>
                            <th>memory</th>
                            <th>memoryused</th>
                            <th>state</th>
                            <th>lastheartbeat</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="content_bottom">
            <div class="col-md-4 stats-info">
                <div class="panel-heading">
                    <h4 class="panel-title"><b>任务状态：</b></h4>
                </div>
                <div class="panel-body">
                    <ul>
                        <li><a href='javascript:void(0)' onclick='show_task(this)'>已完成的任务</a><div class="text-success pull-right"></div></li>
                        <li><a href='javascript:void(0)' onclick='show_task(this)'>运行中的任务</a><div class="text-success pull-right"></div></li>
                        <li><a href='javascript:void(0)' onclick='show_task(this)'>已失败任务</a><div class="text-success pull-right"></div></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-8 span_3">
                <div  class="bs-example1">
                    <table id='yarn_table' class="table table-striped">
                        <thead>
                        <tr>
                            <th>JobID</th>
                            <th>User</th>
                            <th>Queue</th>
                            <th>State</th>
                            <th>Progress</th>
                            <th>start</th>
                            <th>end</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
        </div>
        """),_display_(Seq[Any](/*206.10*/copyright())),format.raw/*206.21*/("""
        </div>
      <script charset="utf-8">
        $(document).ready(function()"""),format.raw/*209.37*/("""{"""),format.raw/*209.38*/("""
            $.ajax("""),format.raw/*210.20*/("""{"""),format.raw/*210.21*/("""
                type:"GET",
                url:"/yarnInfo",
                dataType:"json",
                success:function(data)"""),format.raw/*214.39*/("""{"""),format.raw/*214.40*/("""
                  var myobj=eval(data);
                  var app=myobj.apps.app;
                  for(var i=0;i<app.length;i++)"""),format.raw/*217.48*/("""{"""),format.raw/*217.49*/("""
                      var finalStatus = app[i].finalStatus;
                      if (finalStatus == 'SUCCEEDED')"""),format.raw/*219.54*/("""{"""),format.raw/*219.55*/("""
                        //console.log(app[i]);
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*223.23*/("""}"""),format.raw/*223.24*/("""
                  """),format.raw/*224.19*/("""}"""),format.raw/*224.20*/("""
                """),format.raw/*225.17*/("""}"""),format.raw/*225.18*/("""
            """),format.raw/*226.13*/("""}"""),format.raw/*226.14*/(""");
            show_work();
            task_count();
            cluster_info();
        """),format.raw/*230.9*/("""}"""),format.raw/*230.10*/(""");
        //任务类型判断
        function show_task(Obj)"""),format.raw/*232.32*/("""{"""),format.raw/*232.33*/("""
           var task_type = $(Obj).text();
           $.ajax("""),format.raw/*234.19*/("""{"""),format.raw/*234.20*/("""
                type:"GET",
                url:"/yarnInfo",
                dataType:"json",
                success:function(data)"""),format.raw/*238.39*/("""{"""),format.raw/*238.40*/("""
                  var myobj=eval(data);
                  var app=myobj.apps.app;
                  if(task_type == '已完成的任务')"""),format.raw/*241.44*/("""{"""),format.raw/*241.45*/("""
                    $('#yarn_table tbody').html('');
                    for(var i=0;i<app.length;i++)"""),format.raw/*243.50*/("""{"""),format.raw/*243.51*/("""
                      var finalStatus = app[i].finalStatus;
                      if (finalStatus == 'SUCCEEDED')"""),format.raw/*245.54*/("""{"""),format.raw/*245.55*/("""
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*248.23*/("""}"""),format.raw/*248.24*/("""
                    """),format.raw/*249.21*/("""}"""),format.raw/*249.22*/("""
                  """),format.raw/*250.19*/("""}"""),format.raw/*250.20*/("""
                  if(task_type == '运行中的任务')"""),format.raw/*251.44*/("""{"""),format.raw/*251.45*/("""
                    $('#yarn_table tbody').html('');
                    for(var i=0;i<app.length;i++)"""),format.raw/*253.50*/("""{"""),format.raw/*253.51*/("""
                      var state = app[i].state;
                      if (state == 'RUNNING')"""),format.raw/*255.46*/("""{"""),format.raw/*255.47*/("""
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*258.23*/("""}"""),format.raw/*258.24*/("""
                    """),format.raw/*259.21*/("""}"""),format.raw/*259.22*/("""
                  """),format.raw/*260.19*/("""}"""),format.raw/*260.20*/("""
                  if(task_type == '已失败任务')"""),format.raw/*261.43*/("""{"""),format.raw/*261.44*/("""
                    $('#yarn_table tbody').html('');
                    for(var i=0;i<app.length;i++)"""),format.raw/*263.50*/("""{"""),format.raw/*263.51*/("""
                      var finalStatus = app[i].finalStatus;
                      if (finalStatus == 'FAILED')"""),format.raw/*265.51*/("""{"""),format.raw/*265.52*/("""
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*268.23*/("""}"""),format.raw/*268.24*/("""
                    """),format.raw/*269.21*/("""}"""),format.raw/*269.22*/("""
                  """),format.raw/*270.19*/("""}"""),format.raw/*270.20*/("""
                """),format.raw/*271.17*/("""}"""),format.raw/*271.18*/("""
            """),format.raw/*272.13*/("""}"""),format.raw/*272.14*/(""");
        """),format.raw/*273.9*/("""}"""),format.raw/*273.10*/(""";
        //work list准实时展示
        function show_work()"""),format.raw/*275.29*/("""{"""),format.raw/*275.30*/("""
           $('#work_table tbody').html("");
           $.ajax("""),format.raw/*277.19*/("""{"""),format.raw/*277.20*/("""
                type:"GET",
                url:"/workerlist",
                dataType:"json",
                success:function(data)"""),format.raw/*281.39*/("""{"""),format.raw/*281.40*/("""
                  var myobj=eval(data);
                  var url = myobj.url;
                  var status = myobj.status;
                  var workers=myobj.workers;
                  for(var i=0;i<workers.length;i++)"""),format.raw/*286.52*/("""{"""),format.raw/*286.53*/("""
                    var str = "<tr class='info'><td>"+workers[i].id+"</a></td><td>"+workers[i].host+"</td><td>"+workers[i].cores+"</td><td>"+workers[i].coresused+"</td><td>"+workers[i].memory+"</td><td>"+workers[i].memoryused+"</td><td>"+workers[i].state+"</td><td>"+new Date(workers[i].lastheartbeat).toLocaleString()+"</td><tr>"
                    $('#work_table tbody').append(str);
                  """),format.raw/*289.19*/("""}"""),format.raw/*289.20*/("""
                """),format.raw/*290.17*/("""}"""),format.raw/*290.18*/("""
            """),format.raw/*291.13*/("""}"""),format.raw/*291.14*/(""");
        """),format.raw/*292.9*/("""}"""),format.raw/*292.10*/("""
        //setInterval(show_work,5000);
        //计算任务个数
        function task_count()"""),format.raw/*295.30*/("""{"""),format.raw/*295.31*/("""
            $.ajax("""),format.raw/*296.20*/("""{"""),format.raw/*296.21*/("""
                type:"GET",
                url:"/yarnInfo",
                dataType:"json",
                success:function(data)"""),format.raw/*300.39*/("""{"""),format.raw/*300.40*/("""
                  var myobj=eval(data);
                  var app=myobj.apps.app;
                  var succ_task = 0;
                  var run_task = 0;
                  var fail_task = 0;
     var plain_task =0;
                  for(var i=0;i<app.length;i++)"""),format.raw/*307.48*/("""{"""),format.raw/*307.49*/("""
                      var finalStatus = app[i].finalStatus;
                      var state = app[i].state
       //计算完成的
                      if(finalStatus == 'SUCCEEDED')"""),format.raw/*311.53*/("""{"""),format.raw/*311.54*/("""
                          succ_task += 1;
                      """),format.raw/*313.23*/("""}"""),format.raw/*313.24*/("""
                      if(state == 'RUNNING')"""),format.raw/*314.45*/("""{"""),format.raw/*314.46*/("""
                          run_task += 1;
                      """),format.raw/*316.23*/("""}"""),format.raw/*316.24*/("""
                      if(finalStatus == 'FAILED')"""),format.raw/*317.50*/("""{"""),format.raw/*317.51*/("""
                          fail_task += 1;
                      """),format.raw/*319.23*/("""}"""),format.raw/*319.24*/("""
          if(state == 'ACCEPTED')"""),format.raw/*320.34*/("""{"""),format.raw/*320.35*/("""
                          plain_task += 1;
                      """),format.raw/*322.23*/("""}"""),format.raw/*322.24*/("""
                  """),format.raw/*323.19*/("""}"""),format.raw/*323.20*/("""
                  $('#run').html(run_task);
                  $('#succ').html(succ_task);
                  $('#fail').html(fail_task);
                  $('#plain').html(plain_task);
                   """),format.raw/*328.20*/("""}"""),format.raw/*328.21*/("""
            """),format.raw/*329.13*/("""}"""),format.raw/*329.14*/(""");

        """),format.raw/*331.9*/("""}"""),format.raw/*331.10*/("""
    </script>
    <script>

         //spark集群运行情况
         function cluster_info()"""),format.raw/*336.33*/("""{"""),format.raw/*336.34*/("""
              $.ajax("""),format.raw/*337.22*/("""{"""),format.raw/*337.23*/("""
                type:"GET",
                url:"/spark_info",
                dataType:"json",
                 success:function(data)"""),format.raw/*341.40*/("""{"""),format.raw/*341.41*/("""
                  var sparkinfo = eval(data);
                    var alive_worker = sparkinfo.alive_workers;
                    var alive_workers = alive_worker +" "+"Workers"
                    var cores = sparkinfo.cores;
                    var memory = sparkinfo.memory;
                    var applications = sparkinfo.applications;
                    var drivers = sparkinfo.drivers;
                    var status = sparkinfo.status;

                  $('#alive_workers').html(alive_workers);
                  $('#cores').html(cores);
                  $('#memory').html(memory);
                  $('#applications').html(applications);
                  $('#drivers').html(drivers);
                  $('#status').html(status);


                """),format.raw/*359.17*/("""}"""),format.raw/*359.18*/("""
              """),format.raw/*360.15*/("""}"""),format.raw/*360.16*/(""");

         """),format.raw/*362.10*/("""}"""),format.raw/*362.11*/("""


    </script>

""")))})),format.raw/*367.2*/("""


"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 06 12:18:06 CST 2016
                    SOURCE: /Users/liangkai1/IdeaProjects/ficusspark/app/views/index.scala.html
                    HASH: 081d4f1f94c90a373df5ad0f832eb143b130e1cb
                    MATRIX: 646->1|678->25|716->26|781->64|809->65|897->127|924->128|961->138|989->139|1035->159|1062->160|1105->175|1134->176|1202->217|1230->218|1273->233|1302->234|1367->272|1395->273|1453->303|1482->304|1532->327|1560->328|1661->393|1676->399|1733->434|1804->469|1819->475|1884->518|1981->579|1996->585|2059->626|2144->675|2159->681|2215->715|2312->776|2327->782|2382->815|13957->12353|13991->12364|14103->12447|14133->12448|14182->12468|14212->12469|14374->12602|14404->12603|14563->12733|14593->12734|14736->12848|14766->12849|15324->13378|15354->13379|15402->13398|15432->13399|15478->13416|15508->13417|15550->13430|15580->13431|15698->13521|15728->13522|15808->13573|15838->13574|15928->13635|15958->13636|16120->13769|16150->13770|16305->13896|16335->13897|16467->14000|16497->14001|16640->14115|16670->14116|17181->14598|17211->14599|17261->14620|17291->14621|17339->14640|17369->14641|17442->14685|17472->14686|17604->14789|17634->14790|17757->14884|17787->14885|18298->15367|18328->15368|18378->15389|18408->15390|18456->15409|18486->15410|18558->15453|18588->15454|18720->15557|18750->15558|18890->15669|18920->15670|19431->16152|19461->16153|19511->16174|19541->16175|19589->16194|19619->16195|19665->16212|19695->16213|19737->16226|19767->16227|19806->16238|19836->16239|19920->16294|19950->16295|20042->16358|20072->16359|20236->16494|20266->16495|20516->16716|20546->16717|20981->17123|21011->17124|21057->17141|21087->17142|21129->17155|21159->17156|21198->17167|21228->17168|21343->17254|21373->17255|21422->17275|21452->17276|21614->17409|21644->17410|21937->17674|21967->17675|22171->17850|22201->17851|22295->17916|22325->17917|22399->17962|22429->17963|22522->18027|22552->18028|22631->18078|22661->18079|22755->18144|22785->18145|22848->18179|22878->18180|22973->18246|23003->18247|23051->18266|23081->18267|23314->18471|23344->18472|23386->18485|23416->18486|23456->18498|23486->18499|23599->18583|23629->18584|23680->18606|23710->18607|23875->18743|23905->18744|24695->19505|24725->19506|24769->19521|24799->19522|24841->19535|24871->19536|24922->19555
                    LINES: 22->1|22->1|22->1|24->3|24->3|27->6|27->6|28->7|28->7|30->9|30->9|31->10|31->10|34->13|34->13|35->14|35->14|38->17|38->17|40->19|40->19|42->21|42->21|45->24|45->24|45->24|46->25|46->25|46->25|47->26|47->26|47->26|48->27|48->27|48->27|49->28|49->28|49->28|227->206|227->206|230->209|230->209|231->210|231->210|235->214|235->214|238->217|238->217|240->219|240->219|244->223|244->223|245->224|245->224|246->225|246->225|247->226|247->226|251->230|251->230|253->232|253->232|255->234|255->234|259->238|259->238|262->241|262->241|264->243|264->243|266->245|266->245|269->248|269->248|270->249|270->249|271->250|271->250|272->251|272->251|274->253|274->253|276->255|276->255|279->258|279->258|280->259|280->259|281->260|281->260|282->261|282->261|284->263|284->263|286->265|286->265|289->268|289->268|290->269|290->269|291->270|291->270|292->271|292->271|293->272|293->272|294->273|294->273|296->275|296->275|298->277|298->277|302->281|302->281|307->286|307->286|310->289|310->289|311->290|311->290|312->291|312->291|313->292|313->292|316->295|316->295|317->296|317->296|321->300|321->300|328->307|328->307|332->311|332->311|334->313|334->313|335->314|335->314|337->316|337->316|338->317|338->317|340->319|340->319|341->320|341->320|343->322|343->322|344->323|344->323|349->328|349->328|350->329|350->329|352->331|352->331|357->336|357->336|358->337|358->337|362->341|362->341|380->359|380->359|381->360|381->360|383->362|383->362|388->367
                    -- GENERATED --
                */
            