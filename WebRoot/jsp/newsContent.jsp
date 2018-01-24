<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@page  import="java.util.Iterator"%>
<%@page  import="com.jfinal.plugin.activerecord.Record"%>
<%@page  import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>新闻内容</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
		<link rel="stylesheet" href="../resource/assets/css/core.css" />
		<link rel="stylesheet" href="../resource/assets/css/menu.css" />
		<link rel="stylesheet" href="../resource/assets/css/index.css" />
		
	<link id="bootstrap-style" href="../resource/new/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resource/new/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="../resource/new/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="../resource/new/css/style-responsive.css" rel="stylesheet">	
	<!-- end: CSS -->		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="../resource/new/img/favicon.ico">
	<!-- end: Favicon -->
	
<style type="text/css">
.table_box{
	width:998px;
	border:1px solid #89D5EF;
	background:#FFF;
	margin-bottom:25px;
	float:left;
	padding:1px;
	margin-left:50px
	}

.table_box table{
	border:1px solid #CCC;
	border-collapse:collapse;
	width:100%
	}
.table_box table td,.table_box table th{
	border-right:1px solid #ccc;
	border-bottom:1px solid #ccc;
	overflow:hidden;
	padding:0 3px
	}

table.list{border:1px solid #e4e4e4;border-collapse:collapse;width:100%;margin-bottom:4px;background:#fff}
table.list th{background-color:#EEE;white-space:nowrap;text-align:center;padding:4px 4px 4px 14px}
table.list td{vertical-align:top}
table.list td.id{width:2%;text-align:center}
table.list td.checkbox{width:15px;padding:0}
table.list td.buttons{width:15%;white-space:nowrap;text-align:right}
table.list td.buttons a{padding-right:.6em}
table.list caption{text-align:left;padding:.5em .5em .5em 0}
table tbody tr:hover{background-color:#FFD}
table tr.highlight{background-color:#c90}


</style>
		
		
</head>

<body>
		<!-- start: Header -->
			<jsp:include page="header.jsp" />
		<!-- end: Header -->
		<div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<jsp:include page="layout.jsp" />
			<!-- end: Main Menu -->			
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="../">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="./news?name=${name}">返回新闻列表</a></li>
			</ul>

<div class="row-fluid">
<h3 style="text-align:center; font-size:30px; font-weight:400px;font-family: sans-serif">${title}</h3>
<p style="text-align:center">发布时间：${data}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp新闻来源：${source}</p>
	<div class="demo">
		<div class="container">
<div class="table_box">
	<%-- <table class="list">
		<tbody>
			<tr>
				<th width="4%">序号</th>
				<th width="35%">标题</th>
				<th width="12%">来源</th>
				<th width="12%">发布时间</th>				
			</tr>
			<%
	List<Record> list=(List<Record>)request.getAttribute("news_data");
	if(list!=null){
		Iterator<Record> iter=list.iterator();
		int i =0;
		while(iter.hasNext()){
			
			Record re=iter.next();%>
		
			<tr>
				<td style="text-align:center;"><%=i=i+1%></td>
				<td style="text-align:left;"><a href="./newsContent?id=<%=re.get("id")%>"><%=re.get("news_title")%></a></td>
				 
				<td style="text-align:center;"><%=re.get("source")%></td>
				<td style="text-align:center;"><%=re.get("publish_data")%></td>
			</tr>
		     <%	}
	}													
 %>     
		</tbody> --%>
	</table>
	${content}
	<!-- <#include "/common/_paginate.html" />
	<@paginate currentPage=blogPage.pageNumber totalPage=blogPage.totalPage actionUrl="/blog/" /> -->
</div>
			<!-- <div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="tab" role="tabpanel">
					Nav tabs
					<ul class="nav nav-tabs" role="tablist">
						<li>heoop</li>
						<li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">2013--2015基本财务指标分析</a></li>
						<li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab">2013-2015运营能力指标分析</a></li>
						<li role="presentation"><a href="#Section3" aria-controls="messages" role="tab" data-toggle="tab">2013-2015盈利能力指标分析</a></li>
						<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab">2013-2015偿债能力指标分析</a></li>
						 <li role="presentation"><a href="#Section5" aria-controls="messages" role="tab" data-toggle="tab">2013-2015其他财务指标</a></li>
						  <li role="presentation"><a href="#Section6" aria-controls="messages" role="tab" data-toggle="tab">2013-2015经营趋势分析</a></li>
						   <li role="presentation"><a href="#Section7" aria-controls="messages" role="tab" data-toggle="tab">经营变动情况</a></li>
					</ul> -->
					<!-- Tab panes -->
					<!-- <div class="tab-content tabs">
						<div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<h3>Section 1</h3>
							<div id="columnar1" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section2">
							<h3>Section 2</h3>							
							<div id="columnar8" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section3">
							<h3>Section 3</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec urna aliquam, ornare eros vel, malesuada lorem. Nullam faucibus lorem at eros consectetur lobortis. Maecenas nec nibh congue, placerat sem id, rutrum velit. Phasellus porta enim at facilisis condimentum. Maecenas pharetra dolor vel elit tempor pellentesque sed sed eros. Aenean vitae mauris tincidunt, imperdiet orci semper, rhoncus ligula. Vivamus scelerisque.</p>
					<div id="columnar3" style="width:1000px;height: 400px"></div>		
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section4">
							<h3>Section 2</h3>							
							<div id="columnar4" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section5">
							<h3>Section 2</h3>							
							<div id="columnar5" style="width: 1000px;height: 400px;"></div>
						</div>													
						</div>			 -->			
					</div>
				</div>
			</div>
		</div>	
		</div>	
	</div>
			</div>
			

		
		
			
			<!--/row-->
			
       

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
<!-- 	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">Ã</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	 -->
<!-- 	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<ul class="list-inline item-details">
				<li><a href="#">Admin templates</a></li>
				<li><a href="http://themescloud.org">Bootstrap themes</a></li>
			</ul>
		</div>
	</div>
	 -->

	
	<footer>

		<p style = "text-align:center;">
			<span style = "text-align:center;" >版权所有2017&copy;  <a href="http://ccip.ucas.ac.cn/" alt="Bootstrap_Metro_Dashboard">UCAS_CCIP实验室</a></span>
			
		</p>

	</footer>
	
	<!-- start: JavaScript-->

		<script src="../resource/new/js/jquery-1.9.1.min.js"></script>
	<script src="../resource/new/js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="../resource/new/js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="../resource/new/js/jquery.ui.touch-punch.js"></script>
	
		<script src="../resource/new/js/modernizr.js"></script>
	
		<script src="../resource/new/js/bootstrap.min.js"></script>
	
		<script src="../resource/new/js/jquery.cookie.js"></script>
	
		<script src='../resource/new/js/fullcalendar.min.js'></script>
	
		<script src='../resource/new/js/jquery.dataTables.min.js'></script>

		<script src="../resource/new/js/excanvas.js"></script>
	<script src="../resource/new/js/jquery.flot.js"></script>
	<script src="../resource/new/js/jquery.flot.pie.js"></script>
	<script src="../resource/new/js/jquery.flot.stack.js"></script>
	<script src="../resource/new/js/jquery.flot.resize.min.js"></script>
	
		<script src="../resource/new/js/jquery.chosen.min.js"></script>
	
		<script src="../resource/new/js/jquery.uniform.min.js"></script>
		
		<script src="../resource/new/js/jquery.cleditor.min.js"></script>
	
		<script src="../resource/new/js/jquery.noty.js"></script>
	
		<script src="../resource/new/js/jquery.elfinder.min.js"></script>
	
		<script src="../resource/new/js/jquery.raty.min.js"></script>
	
		<script src="../resource/new/js/jquery.iphone.toggle.js"></script>
	
		<script src="../resource/new/js/jquery.uploadify-3.1.min.js"></script>
	
		<script src="../resource/new/js/jquery.gritter.min.js"></script>
	
		<script src="../resource/new/js/jquery.imagesloaded.js"></script>
	
		<script src="../resource/new/js/jquery.masonry.min.js"></script>
	
		<script src="../resource/new/js/jquery.knob.modified.js"></script>
	
		<script src="../resource/new/js/jquery.sparkline.min.js"></script>
	
		<script src="../resource/new/js/counter.js"></script>
	
		<script src="../resource/new/js/retina.js"></script>

		<script src="../resource/new/js/custom.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>
<script type="text/javascript" src="../resource/assets/js/charts/echarts.min.js" ></script>
<script type="text/javascript">
(function(){
var columnar1 = echarts.init(document.getElementById("columnar1"));

option = {


	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['资产总额','所有者权益','负债总额','带息负债','营业收入','EBITDA'],
	        left:'-0.5%',
	        top:'-1.3%'
	    },
	    grid: {
	        left: '2%',
	        right: '4%',
	        bottom: '2%',
	        containLabel: true
	    },
	    toolbox: {
	       
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['2013','2014','2015']
	    },
	    yAxis:[ {
	        type: 'value',
	        name: '金额（万元）'
	    }],
	    series: [
/* 	        {
	            name:'资产总额',
	            type:'line',
	            stack: '总量',
	            data:[2342, 2054, 3084]
	        } ,
	        {
	            name:'所有者权益',
	            type:'line',
	            stack: '总量',
	            data:[1119, 1021, 1060]
	        }
	        ,
	        {
	            name:'负债总额',
	            type:'line',
	            stack: '总量',
	            data:[1223, 1033,2024]
	        }
	        ,
	        {
	            name:'带息负债',
	            type:'line',
	            stack: '总量',
	            data:[1, 0, 0]
	        }
	        ,
	        {
	            name:'营业收入',
	            type:'line',
	            stack: '总量',
	            data:[1589, 1936, 2350]
	        },
	        {
	            name:'EBITDA',
	            type:'line',
	            stack: '总量',
	            data:[27, 103, 148]
	        } */
	    ]
	};
columnar1.showLoading();    //数据加载完之前先显示一段简单的loading动画
 //ajax异步请求数据
 		 var assets=[];        //资产总额数组（存放服务器返回的所有资产值）
         var ower=[];        //所有者权益数组
         var debt=[];        //负债数组
         var interest=[];        //带息负债数组
         var income=[];    //收入数组
         var EBITDA=[];        //EBITDA数组
    $.ajax({
        type: 'get',  
        url: './financial',//请求数据的地址
        dataType: "json",//返回数据形式为json
        success: function (data){
        	
        	for(var i=2;i>=0; i-- ){
        		assets.push(data["count"][i]);
        		//console.dir(assets);
        		ower.push(data["ower"][i]);
        		debt.push(data["debt"][i]);
        		interest.push(data["interest"][i]);
        		income.push(data["income"][i]);
        		EBITDA.push(data["EBITDA"][i]);
        		
        	}
        	//assets.push("name")
        	console.dir(assets);
            //请求成功时执行该函数内容，result即为服务器返回的json对象
/*              var i = 2;
            $.each(data, function(index,item) {
            	
            	console.dir(data);
            	 assets.push(data[i]);
            	 i--;//挨个取出类别并填入类别数组 
               	 /* num.push({
               		name:index,
                   	value:item                    
                }); 
            }); */         
            columnar1.hideLoading();    //隐藏加载动画
            columnar1.setOption({        //加载数据图表                
                /* legend: {
                    data: position	
                }, */
                series: [ {
    	            name:'资产总额',
    	            type:'line',
    	            stack: '总量',
    	            data:assets
    	        } ,
    	        {
    	            name:'所有者权益',
    	            type:'line',
    	            stack: '总量',
    	            data:ower
    	        }
    	        ,
    	        {
    	            name:'负债总额',
    	            type:'line',
    	            stack: '总量',
    	            data:debt
    	        }
    	        ,
    	        {
    	            name:'带息负债',
    	            type:'line',
    	            stack: '总量',
    	            data:interest
    	        }
    	        ,
    	        {
    	            name:'营业收入',
    	            type:'line',
    	            stack: '总量',
    	            data:income
    	        },
    	        {
    	            name:'EBITDA',
    	            type:'line',
    	            stack: '总量',
    	            data:EBITDA
    	        } ]
            });
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            columnar1.hideLoading();
        }
    }); 
columnar1.setOption(option);
})();


(function(){

var columnar8 = echarts.init(document.getElementById("columnar8"));

option = {


	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['总资产周转次数','应收账款周转次数','存货周转次数'],
	        left:'-0.5%',
	        top:'1%'
	    },
	    grid: {
	        left: '10%',
	        right: '4%',
	        bottom: '10%',
	        containLabel: true
	    },
	    
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['2013','2014','2015']
	    },
	    yAxis:[ {
	        type: 'value',
	        name: '单位：次'
	    }],
	    series: [
]
	};
columnar8.showLoading();    //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
		var count_turn =[];        //总资产周转次数数组（存放服务器返回的所有资产值）
        var income_turn=[];        //应收账款周转次数数组
        var inventory_turn=[];        //存货周转次数数组
   $.ajax({
       type: 'get',  
       url: './operation',//请求数据的地址
       dataType: "json",//返回数据形式为json
       success: function (data){
       	
       	for(var i=2;i>=0; i-- ){
       		count_turn.push(data["count_turn"][i]);
       		//console.dir(assets);
       		income_turn.push(data["income_turn"][i]);
       		inventory_turn.push(data["inventory_turn"][i]);    		
       	}
       	console.dir(count_turn);     
           columnar8.hideLoading();    //隐藏加载动画
           columnar8.setOption({        //加载数据图表                
               /* legend: {
                   data: position	
               }, */
               series: [ 	        {
	            name:'总资产周转次数',
	            type:'line',
	            stack: '总量',
	            data:count_turn
	        } ,
	        {
	            name:'应收账款周转次数',
	            type:'line',
	            stack: '总量',
	            data:income_turn
	        }
	        ,
	        {
	            name:'存货周转次数',
	            type:'line',
	            stack: '总量',
	            data:inventory_turn
	        }]
           });
       },
       error: function (errorMsg) {
           //请求失败时执行该函数
           alert("图表请求数据失败!");
           columna8.hideLoading();
       }
   }); 
columnar8.setOption(option);
})();
(function(){

var columnar3 = echarts.init(document.getElementById("columnar3"));

option = {


	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['总资本盈利率','总资产报酬率','净资产收益率'],
	        left:'-0.5%',
	        top:'1%'
	    },
	    grid: {
	        left: '10%',
	        right: '4%',
	        bottom: '10%',
	        containLabel: true
	    },
	    
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['2013','2014','2015']
	    },
	    yAxis:[ {
	        type: 'value',
	        name: '比率（%）'
	    }],
	    series: []
	};
columnar3.showLoading();    //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
	  var pay =[];        //总资产报酬率数组（存放服务器返回的所有资产值）
      var profit=[];        //总资本盈利率数组
      var roe=[];        //净资产收益率数组
 $.ajax({
     type: 'get',  
     url: './profit',//请求数据的地址
     dataType: "json",//返回数据形式为json
     success: function (data){
     	
     	for(var i=2;i>=0; i-- ){
     		pay.push(data["pay"][i]);
     		//console.dir(assets);
     		profit.push(data["profit"][i]);
     		roe.push(data["roe"][i]);    		
     	}
     	console.dir(pay);     
         columnar3.hideLoading();    //隐藏加载动画
         columnar3.setOption({        //加载数据图表                
             /* legend: {
                 data: position	
             }, */
             series: [ 	        	        {
	            name:'总资本盈利率',
	            type:'line',
	            stack: '总量',
	            data:profit
	        } ,
	        {
	            name:'总资产报酬率',
	            type:'line',
	            stack: '总量',
	            data:pay
	        }
	        ,
	        {
	            name:'净资产收益率',
	            type:'line',
	            stack: '总量',
	            data:roe
	        }]
         });
     },
     error: function (errorMsg) {
         //请求失败时执行该函数
         alert("图表请求数据失败!");
         columna.hideLoading();
     }
 }); 
columnar3.setOption(option);
})();
(function(){	
var columnar4 = echarts.init(document.getElementById("columnar4"));
option = {

    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['流动比率','速动比率','资产负债率'],
        left:'-0.5%',
        top:'1%'
    },
    grid: {
        left: '10%',
        right: '4%',
        bottom: '10%',
        containLabel: true
    },
    
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['2013','2014','2015']
    },
    yAxis:[ {
        type: 'value',
        name: '比率（%）'
    }],
    series: []
};
columnar4.showLoading();    //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
	var CurrentRatio    = [];        //流动比率数组（存放服务器返回的所有资产值）
    var QuickRatio      = [];        //速动比率数组
    var debtAssetsRatio = [];        //资产负债率数组
$.ajax({
   type: 'get',  
   url: './debt',//请求数据的地址
   dataType: "json",//返回数据形式为json
   success: function (data){
   	
   	for(var i=2;i>=0; i-- ){
   		CurrentRatio.push(data["CurrentRatio"][i]);
   		//console.dir(assets);
   		QuickRatio.push(data["QuickRatio"][i]);
   		debtAssetsRatio.push(data["debtAssetsRatio"][i]);    		
   	}   
       columnar4.hideLoading();    //隐藏加载动画
       columnar4.setOption({        //加载数据图表                
           /* legend: {
               data: position	
           }, */
           series: [       
            {
               name:'流动比率',
               type:'line',
               stack: '总量',
               data:CurrentRatio
           } ,
           {
               name:'速动比率',
               type:'line',
               stack: '总量',
               data:QuickRatio
           }
           ,
           {
               name:'资产负债率',
               type:'line',
               stack: '总量',
               data:debtAssetsRatio
           }]
       });
   },
   error: function (errorMsg) {
       //请求失败时执行该函数
       alert("图表请求数据失败!");
       columnar4.hideLoading();
   }
}); 
columnar4.setOption(option);
})();

(function(){	
var columnar5 = echarts.init(document.getElementById("columnar5"));
option = {

	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['营业收入增长率','成本费用利润率','现金流动负债比率','资产现金回收率'],
	        left:'-0.5%',
	        top:'-1%'
	    },
	    grid: {
	        left: '10%',
	        right: '4%',
	        bottom: '10%',
	        containLabel: true
	    },
	    
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['2013','2014','2015']
	    },
	    yAxis:[ {
	        type: 'value',
	        name: '比率（%）'
	    }],
	    series: []
	};
columnar5.showLoading();    //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
  var increaseRate = [];        //营业收入增长率数组（存放服务器返回的所有资产值）
  var profitsCost  = [];        //成本费用利润率数组
  var cashRatio    = [];        //现金流动负债比率数组
  var cashRecovery = []; 	    //资产现金回收率
$.ajax({
 type: 'get',  
 url: './otherFinancial',//请求数据的地址
 dataType: "json",//返回数据形式为json
 success: function (data){
 	
 	for(var i=2;i>=0; i-- ){
 		increaseRate.push(data["increaseRate"][i]);
 		profitsCost.push(data["profitsCost"][i]);
 		cashRatio.push(data["cashRatio"][i]);  
 		cashRecovery.push(data["cashRecovery"][i]);  
 	}   
     columnar5.hideLoading();    //隐藏加载动画
     columnar5.setOption({        //加载数据图表                
         /* legend: {
             data: position	
         }, */
         series: [       
           {
	            name:'营业收入增长率',
	            type:'line',
	            stack: '总量',
	            data:increaseRate
	        } 
	        ,
	        {
	            name:'成本费用利润率',
	            type:'line',
	            stack: '总量',
	            data:profitsCost
	        }
	        ,
	        {
	            name:'现金流动负债比率',
	            type:'line',
	            stack: '总量',
	            data:cashRatio
	        }
	        ,
	        {
	            name:'资产现金回收率',
	            type:'line',
	            stack: '总量',
	            data:cashRecovery
	        }]
     });
 },
 error: function (errorMsg) {
     //请求失败时执行该函数
     alert("图表请求数据失败!");
     columnar5.hideLoading();
 }
}); 
columnar5.setOption(option);
})();


(function(){

var columnar2 = echarts.init(document.getElementById("columnar2"));

option = {


	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['毛利润合计','家政服务','养老服务','培训服务','其他业务'],
	        left:'-0.5%',
	        top:'1%'
	    },
	    grid: {
	        left: '10%',
	        right: '4%',
	        bottom: '10%',
	        containLabel: true
	    },
	    
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['2013','2014','2015']
	    },
	    yAxis:[ {
	        type: 'value',
	        name: '金额（万元）'
	    }],
	    series: [
	        {
	            name:'毛利润合计',
	            type:'line',
	            stack: '总量',
	            data:[917, 646, 901]
	        } ,
	        {
	            name:'家政服务',
	            type:'line',
	            stack: '总量',
	            data:[917, 523, 550]
	        }
	        ,
	        {
	            name:'养老服务',
	            type:'line',
	            stack: '总量',
	            data:[0, 41,189]
	        }
	        ,
	        {
	            name:'培训服务',
	            type:'line',
	            stack: '总量',
	            data:[0, 34, 40]
	        }
	        ,
	        {
	            name:'其他业务',
	            type:'line',
	            stack: '总量',
	            data:[0, 48, 122]
	        }
	    ]
	};
columnar2.setOption(option);
})();
</script>