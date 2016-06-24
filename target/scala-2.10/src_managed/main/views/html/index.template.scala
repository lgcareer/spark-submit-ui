
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
</style>
<style type='text/css'>
    #date"""),format.raw/*9.10*/("""{"""),format.raw/*9.11*/("""
    width:50%;
    """),format.raw/*11.5*/("""}"""),format.raw/*11.6*/("""
</style>
<style type='text/css'>
    #sparkinfo"""),format.raw/*14.15*/("""{"""),format.raw/*14.16*/("""
    width:50%;
    line-height:1.2;
    """),format.raw/*17.5*/("""}"""),format.raw/*17.6*/("""
</style>
<!----Calender -------->
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*20.31*/routes/*20.37*/.Assets.at("stylesheets/clndr.css"))),format.raw/*20.72*/("""" type="text/css" />
<script src=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("javascripts/underscore-min.js"))),format.raw/*21.64*/("""" type="text/javascript"></script>
            <script src=""""),_display_(Seq[Any](/*22.27*/routes/*22.33*/.Assets.at("javascripts/moment-2.2.1.js"))),format.raw/*22.74*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("javascripts/clndr.js"))),format.raw/*23.55*/("""" type="text/javascript"></script>
            <script src=""""),_display_(Seq[Any](/*24.27*/routes/*24.33*/.Assets.at("javascripts/site.js"))),format.raw/*24.66*/("""" type="text/javascript"></script>
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
                              <div class="tiles-body tw2" id="alive_workers">
                              </div>
                          </a>
                      </div>
                      <div class="box_1">
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
                      <div class="clearfix"> </div>
                  </div>
                  <div class="box_1">
                      <div class="col-md-6 col_1_of_2 span_1_of_2">
                          <a class="tiles_info">
                              <div class="tiles-head fb1">
                                  <div class="text-center">Drivers运行情况</div>
                              </div>
                              <div class="tiles-body fb2" >
                              <h2 id="drivers"></h2>
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
        """),_display_(Seq[Any](/*204.10*/copyright())),format.raw/*204.21*/("""
        </div>
      <script charset="utf-8">
        $(document).ready(function()"""),format.raw/*207.37*/("""{"""),format.raw/*207.38*/("""
            $.ajax("""),format.raw/*208.20*/("""{"""),format.raw/*208.21*/("""
                type:"GET",
                url:"/yarnInfo",
                dataType:"json",
                success:function(data)"""),format.raw/*212.39*/("""{"""),format.raw/*212.40*/("""
                  var myobj=eval(data);
                  var app=myobj.apps.app;
                  for(var i=0;i<app.length;i++)"""),format.raw/*215.48*/("""{"""),format.raw/*215.49*/("""
                      var finalStatus = app[i].finalStatus;
                      if (finalStatus == 'SUCCEEDED')"""),format.raw/*217.54*/("""{"""),format.raw/*217.55*/("""
                        //console.log(app[i]);
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*221.23*/("""}"""),format.raw/*221.24*/("""
                  """),format.raw/*222.19*/("""}"""),format.raw/*222.20*/("""
                """),format.raw/*223.17*/("""}"""),format.raw/*223.18*/("""
            """),format.raw/*224.13*/("""}"""),format.raw/*224.14*/(""");
            show_work();
            task_count();
            cluster_info();
        """),format.raw/*228.9*/("""}"""),format.raw/*228.10*/(""");
        //任务类型判断
        function show_task(Obj)"""),format.raw/*230.32*/("""{"""),format.raw/*230.33*/("""
           var task_type = $(Obj).text();
           $.ajax("""),format.raw/*232.19*/("""{"""),format.raw/*232.20*/("""
                type:"GET",
                url:"/yarnInfo",
                dataType:"json",
                success:function(data)"""),format.raw/*236.39*/("""{"""),format.raw/*236.40*/("""
                  var myobj=eval(data);
                  var app=myobj.apps.app;
                  if(task_type == '已完成的任务')"""),format.raw/*239.44*/("""{"""),format.raw/*239.45*/("""
                    $('#yarn_table tbody').html('');
                    for(var i=0;i<app.length;i++)"""),format.raw/*241.50*/("""{"""),format.raw/*241.51*/("""
                      var finalStatus = app[i].finalStatus;
                      if (finalStatus == 'SUCCEEDED')"""),format.raw/*243.54*/("""{"""),format.raw/*243.55*/("""
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*246.23*/("""}"""),format.raw/*246.24*/("""
                    """),format.raw/*247.21*/("""}"""),format.raw/*247.22*/("""
                  """),format.raw/*248.19*/("""}"""),format.raw/*248.20*/("""
                  if(task_type == '运行中的任务')"""),format.raw/*249.44*/("""{"""),format.raw/*249.45*/("""
                    $('#yarn_table tbody').html('');
                    for(var i=0;i<app.length;i++)"""),format.raw/*251.50*/("""{"""),format.raw/*251.51*/("""
                      var state = app[i].state;
                      if (state == 'RUNNING')"""),format.raw/*253.46*/("""{"""),format.raw/*253.47*/("""
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*256.23*/("""}"""),format.raw/*256.24*/("""
                    """),format.raw/*257.21*/("""}"""),format.raw/*257.22*/("""
                  """),format.raw/*258.19*/("""}"""),format.raw/*258.20*/("""
                  if(task_type == '已失败任务')"""),format.raw/*259.43*/("""{"""),format.raw/*259.44*/("""
                    $('#yarn_table tbody').html('');
                    for(var i=0;i<app.length;i++)"""),format.raw/*261.50*/("""{"""),format.raw/*261.51*/("""
                      var finalStatus = app[i].finalStatus;
                      if (finalStatus == 'FAILED')"""),format.raw/*263.51*/("""{"""),format.raw/*263.52*/("""
                        var str = "<tr class='active'><td><a href='http://h136159.mars.grid.sina.com.cn:8088/proxy/"+app[i].id+"' target='_blank'>"+app[i].id+"</a></td><td>"+app[i].user+"</td><td>"+app[i].queue+"</td><td>"+app[i].finalStatus+"</td><td>"+app[i].progress+"</td><td>"+new Date(app[i].startedTime).toLocaleString()+"</td><td>"+new Date(app[i].finishedTime).toLocaleString()+"</td><tr>"
                        $('#yarn_table tbody').append(str);
                      """),format.raw/*266.23*/("""}"""),format.raw/*266.24*/("""
                    """),format.raw/*267.21*/("""}"""),format.raw/*267.22*/("""
                  """),format.raw/*268.19*/("""}"""),format.raw/*268.20*/("""
                """),format.raw/*269.17*/("""}"""),format.raw/*269.18*/("""
            """),format.raw/*270.13*/("""}"""),format.raw/*270.14*/(""");
        """),format.raw/*271.9*/("""}"""),format.raw/*271.10*/(""";
        //work list准实时展示
        function show_work()"""),format.raw/*273.29*/("""{"""),format.raw/*273.30*/("""
           $('#work_table tbody').html("");
           $.ajax("""),format.raw/*275.19*/("""{"""),format.raw/*275.20*/("""
                type:"GET",
                url:"/workerlist",
                dataType:"json",
                success:function(data)"""),format.raw/*279.39*/("""{"""),format.raw/*279.40*/("""
                  var myobj=eval(data);
                  var url = myobj.url;
                  var status = myobj.status;
                  var workers=myobj.workers;
                  for(var i=0;i<workers.length;i++)"""),format.raw/*284.52*/("""{"""),format.raw/*284.53*/("""
                    var str = "<tr class='info'><td>"+workers[i].id+"</a></td><td>"+workers[i].host+"</td><td>"+workers[i].cores+"</td><td>"+workers[i].coresused+"</td><td>"+workers[i].memory+"</td><td>"+workers[i].memoryused+"</td><td>"+workers[i].state+"</td><td>"+new Date(workers[i].lastheartbeat).toLocaleString()+"</td><tr>"
                    $('#work_table tbody').append(str);
                  """),format.raw/*287.19*/("""}"""),format.raw/*287.20*/("""
                """),format.raw/*288.17*/("""}"""),format.raw/*288.18*/("""
            """),format.raw/*289.13*/("""}"""),format.raw/*289.14*/(""");
        """),format.raw/*290.9*/("""}"""),format.raw/*290.10*/("""
        //setInterval(show_work,5000);
        //计算任务个数
        function task_count()"""),format.raw/*293.30*/("""{"""),format.raw/*293.31*/("""
            $.ajax("""),format.raw/*294.20*/("""{"""),format.raw/*294.21*/("""
                type:"GET",
                url:"/yarnInfo",
                dataType:"json",
                success:function(data)"""),format.raw/*298.39*/("""{"""),format.raw/*298.40*/("""
                  var myobj=eval(data);
                  var app=myobj.apps.app;
                  var succ_task = 0;
                  var run_task = 0;
                  var fail_task = 0;
		 var plain_task =0;
                  for(var i=0;i<app.length;i++)"""),format.raw/*305.48*/("""{"""),format.raw/*305.49*/("""
                      var finalStatus = app[i].finalStatus;
                      var state = app[i].state
			 //计算完成的
                      if(finalStatus == 'SUCCEEDED')"""),format.raw/*309.53*/("""{"""),format.raw/*309.54*/("""
                          succ_task += 1;
                      """),format.raw/*311.23*/("""}"""),format.raw/*311.24*/("""
                      if(state == 'RUNNING')"""),format.raw/*312.45*/("""{"""),format.raw/*312.46*/("""
                          run_task += 1;
                      """),format.raw/*314.23*/("""}"""),format.raw/*314.24*/("""
                      if(finalStatus == 'FAILED')"""),format.raw/*315.50*/("""{"""),format.raw/*315.51*/("""
                          fail_task += 1;
                      """),format.raw/*317.23*/("""}"""),format.raw/*317.24*/("""
		      if(state == 'ACCEPTED')"""),format.raw/*318.32*/("""{"""),format.raw/*318.33*/("""
                          plain_task += 1;
                      """),format.raw/*320.23*/("""}"""),format.raw/*320.24*/("""
                  """),format.raw/*321.19*/("""}"""),format.raw/*321.20*/("""
                  $('#run').html(run_task);
                  $('#succ').html(succ_task);
                  $('#fail').html(fail_task);
                  $('#plain').html(plain_task);
                   """),format.raw/*326.20*/("""}"""),format.raw/*326.21*/("""
            """),format.raw/*327.13*/("""}"""),format.raw/*327.14*/(""");

        """),format.raw/*329.9*/("""}"""),format.raw/*329.10*/("""
    </script>
    <script>

         //spark集群运行情况
         function cluster_info()"""),format.raw/*334.33*/("""{"""),format.raw/*334.34*/("""
              $.ajax("""),format.raw/*335.22*/("""{"""),format.raw/*335.23*/("""
                type:"GET",
                url:"/spark_info",
                dataType:"json",
                 success:function(data)"""),format.raw/*339.40*/("""{"""),format.raw/*339.41*/("""
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


                """),format.raw/*357.17*/("""}"""),format.raw/*357.18*/("""
              """),format.raw/*358.15*/("""}"""),format.raw/*358.16*/(""");

         """),format.raw/*360.10*/("""}"""),format.raw/*360.11*/("""


    </script>

""")))})),format.raw/*365.2*/("""


"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 24 10:47:15 CST 2016
                    SOURCE: /Users/manbu/Desktop/ficusspark/app/views/index.scala.html
                    HASH: 39b46d113ba7423e493b3033e0009f7bdbc4dcf7
                    MATRIX: 646->1|678->25|716->26|781->64|809->65|897->127|924->128|994->171|1022->172|1069->192|1097->193|1173->241|1202->242|1270->283|1298->284|1399->349|1414->355|1471->390|1542->425|1557->431|1622->474|1719->535|1734->541|1797->582|1882->631|1897->637|1953->671|2050->732|2065->738|2120->771|13846->12460|13880->12471|13992->12554|14022->12555|14071->12575|14101->12576|14263->12709|14293->12710|14452->12840|14482->12841|14625->12955|14655->12956|15213->13485|15243->13486|15291->13505|15321->13506|15367->13523|15397->13524|15439->13537|15469->13538|15587->13628|15617->13629|15697->13680|15727->13681|15817->13742|15847->13743|16009->13876|16039->13877|16194->14003|16224->14004|16356->14107|16386->14108|16529->14222|16559->14223|17070->14705|17100->14706|17150->14727|17180->14728|17228->14747|17258->14748|17331->14792|17361->14793|17493->14896|17523->14897|17646->14991|17676->14992|18187->15474|18217->15475|18267->15496|18297->15497|18345->15516|18375->15517|18447->15560|18477->15561|18609->15664|18639->15665|18779->15776|18809->15777|19320->16259|19350->16260|19400->16281|19430->16282|19478->16301|19508->16302|19554->16319|19584->16320|19626->16333|19656->16334|19695->16345|19725->16346|19809->16401|19839->16402|19931->16465|19961->16466|20125->16601|20155->16602|20405->16823|20435->16824|20870->17230|20900->17231|20946->17248|20976->17249|21018->17262|21048->17263|21087->17274|21117->17275|21232->17361|21262->17362|21311->17382|21341->17383|21503->17516|21533->17517|21824->17779|21854->17780|22055->17952|22085->17953|22179->18018|22209->18019|22283->18064|22313->18065|22406->18129|22436->18130|22515->18180|22545->18181|22639->18246|22669->18247|22730->18279|22760->18280|22855->18346|22885->18347|22933->18366|22963->18367|23196->18571|23226->18572|23268->18585|23298->18586|23338->18598|23368->18599|23481->18683|23511->18684|23562->18706|23592->18707|23757->18843|23787->18844|24577->19605|24607->19606|24651->19621|24681->19622|24723->19635|24753->19636|24804->19655
                    LINES: 22->1|22->1|22->1|24->3|24->3|27->6|27->6|30->9|30->9|32->11|32->11|35->14|35->14|38->17|38->17|41->20|41->20|41->20|42->21|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|45->24|45->24|45->24|225->204|225->204|228->207|228->207|229->208|229->208|233->212|233->212|236->215|236->215|238->217|238->217|242->221|242->221|243->222|243->222|244->223|244->223|245->224|245->224|249->228|249->228|251->230|251->230|253->232|253->232|257->236|257->236|260->239|260->239|262->241|262->241|264->243|264->243|267->246|267->246|268->247|268->247|269->248|269->248|270->249|270->249|272->251|272->251|274->253|274->253|277->256|277->256|278->257|278->257|279->258|279->258|280->259|280->259|282->261|282->261|284->263|284->263|287->266|287->266|288->267|288->267|289->268|289->268|290->269|290->269|291->270|291->270|292->271|292->271|294->273|294->273|296->275|296->275|300->279|300->279|305->284|305->284|308->287|308->287|309->288|309->288|310->289|310->289|311->290|311->290|314->293|314->293|315->294|315->294|319->298|319->298|326->305|326->305|330->309|330->309|332->311|332->311|333->312|333->312|335->314|335->314|336->315|336->315|338->317|338->317|339->318|339->318|341->320|341->320|342->321|342->321|347->326|347->326|348->327|348->327|350->329|350->329|355->334|355->334|356->335|356->335|360->339|360->339|378->357|378->357|379->358|379->358|381->360|381->360|386->365
                    -- GENERATED --
                */
            