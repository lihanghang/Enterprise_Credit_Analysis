<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!-- start: Meta -->
	<title>财务报表分析</title>
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
	.demo{padding: 1em 1px;}
	a:hover,a:focus{
		outline: none;
		text-decoration: none;
	}
	.tab .nav-tabs{
		border: 0px solid #1fc1dd;
		width:1130px;
		margin-left:3px;
	}
	.tab .nav-tabs li{
		margin: 0;
		/*height:60px  */
	}
	.tab .nav-tabs li a{
		font-size: 13.2px;
		/* color: #999898; */
		background: #fff;
		margin: 0px;
		padding: 20px 3px;
		border-radius: 0;
		border: none;
		border-right: 1px solid #ddd;
		text-transform: uppercase;
		position: relative;
	}
	.tab .nav-tabs li a:hover{
		border-top: none;
		border-bottom: none;
		border-right-color: #ddd;
	}
	.tab .nav-tabs li.active a,
	.tab .nav-tabs li.active a:hover{
		color: black;
		border: none;
		background: #fff;
		border-right: 0px solid #ddd;
	}
	.tab .nav-tabs li.active a:before{
		content: "";
		width: 58%;
		height: 1px;
		background: #fff;
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		margin: 0 auto;
	}
	.tab .nav-tabs li.active a:after{
		content: "";
		border-top: 10px ;
		border-left: 10px solid transparent;
		border-right: 10px solid transparent;
		position: absolute;
		bottom: 10px;
		left: 20%;
		color:black;
	}
	.tab .tab-content{
		font-size: 13px;
		font-wight:500px;
		
		line-height: 20px;
		background: #fff;
		padding: 10px;
		padding-left:"10px";
		/* border: 1px solid; */
		border-top: none;
		width:1108px;
		margin-left:4px;
		color:black;
	
	}
	.tab .tab-content h3{
		font-size: 24px;
		color: #999898;
		margin-top: 1;
	}
	@media only screen and (max-width: 1296px){
		.tab .nav-tabs li{
			width: 100%;
			text-align: center;
		}
		.tab .nav-tabs li.active a,
		.tab .nav-tabs li.active a:after,
		.tab .nav-tabs li.active a:hover{
			border: none;
		}
	}
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
				<li><a href="#">财务报表分析</a></li>
			</ul>

<div class="row-fluid">
<h3 style="text-align:center; font-size:30px; font-weight:400px;font-family: sans-serif">${name}(2013-2015财报分析)</h3>
	<div class="demo">
		<div class="container">
			<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="tab" role="tabpanel">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">资产负债表（资产）一次</a></li>
						<li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab">资产负债表（资产）二次</a></li>
						<li role="presentation"><a href="#Section3" aria-controls="messages" role="tab" data-toggle="tab">资产负债表（负债及所有者权益）</a></li>
						<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab">利润表指标（一次）</a></li>
						<li role="presentation"><a href="#Section5" aria-controls="messages" role="tab" data-toggle="tab">利润表指标（二次）</a></li>
						<li role="presentation"><a href="#Section6" aria-controls="messages" role="tab" data-toggle="tab">现金流量表指标分析一次</a></li>
						<li role="presentation"><a href="#Section7" aria-controls="messages" role="tab" data-toggle="tab">现金流量表指标分析二次</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content tabs">
						<div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<!-- <h3>Section 1</h3> -->
							<div id="columnar1" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section2">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar8" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section3">
							<!-- <h3>Section 3</h3> -->
<!-- 							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec urna aliquam, ornare eros vel, malesuada lorem. Nullam faucibus lorem at eros consectetur lobortis. Maecenas nec nibh congue, placerat sem id, rutrum velit. Phasellus porta enim at facilisis condimentum. Maecenas pharetra dolor vel elit tempor pellentesque sed sed eros. Aenean vitae mauris tincidunt, imperdiet orci semper, rhoncus ligula. Vivamus scelerisque.</p>
 -->					<div id="columnar4" style="width:1000px;height: 400px"></div>		
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section4">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar3" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section5">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar2" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section6">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar6" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section7">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar7" style="width:1000px;height: 400px;"></div>
						</div>												
						</div>						
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
		<script type="text/javascript" src="../resource/assets/js/charts/echarts.min.js" ></script>
	
		<script src="../resource/index/js/getParam.js"></script>
	<!-- end: JavaScript-->	
</body>
</html>

<script type="text/javascript">
(function(){	
	var columnar1 = echarts.init(document.getElementById("columnar1"));

	option = {


		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['货币资金','流动资产合计','固定资产净额','非流动资产合计','资产总计'],
		        left:'11%',
		        top:'-1.3%'
		    },
		    grid: {
		    	top:'20%',
		        left: '11%',
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
		    series: []
		};
	
	columnar1.showLoading();    //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var assets          = [];        //营业收入增长率数组（存放服务器返回的所有资产值）
	  var liquiditycash   = [];        //成本费用利润率数组
	  var fixedAssets     = [];        //现金流动负债比率数组
	  var noliquiditycash = []; 	    //资产现金回收率
	  var count           = []; 
	$.ajax({
	 type: 'get',  
	 url: './debtAssetfirst?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	
	 	for(var i=2;i>=0; i-- ){
	 		assets.push(data["assets"][i]);
	 		liquiditycash.push(data["liquiditycash"][i]);
	 		fixedAssets.push(data["fixedAssets"][i]);  
	 		noliquiditycash.push(data["noliquiditycash"][i]);
	 		count.push(data["count"][i]);
	 	}   
	     columnar1.hideLoading();    //隐藏加载动画
	     columnar1.setOption({        //加载数据图表                
	         /* legend: {
	             data: position	
	         }, */
	         series: [       
	           	        {
		            name:'货币资金',
		            type:'line',
		            stack: '总量',
		            data:assets
		        } ,
		        {
		            name:'流动资产合计',
		            type:'line',
		            stack: '总量',
		            data:liquiditycash
		        }
		        ,
		        {
		            name:'固定资产净额',
		            type:'line',
		            stack: '总量',
		            data:fixedAssets
		        }
		        ,
		        {
		            name:'非流动资产合计',
		            type:'line',
		            stack: '总量',
		            data:noliquiditycash
		        }
		        ,
		        {
		            name:'资产总计',
		            type:'line',
		            stack: '总量',
		            data:count
		        }]
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

		    title: [{
		        text: '2013--2015资产负债表分析（资产）二次分析',
		        
		        x:"center"
		    }],
		    tooltip: {
		        trigger: 'axis'
		    },
		    grid: {
		    	top:'20%',
		        left: '13%',
		        right: '4%',
		        bottom: '2%',
		        containLabel: true
		    },
		    legend: {
		    	left:'15%',
			    top:'10%',
		        data: ['应收账款', '其它应收款', '存货']
		    },
		    toolbox: {
		        "show": false,
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: ['2013', '2014', '2015']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: []
		}
	columnar8.showLoading();    //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var receivables   = [];        //应收账款
	  var otherecevie   = [];        //其它应收款
	  var inventory     = [];        //存货
	$.ajax({
	 type: 'get',  
	 url: './debtAssetsecond?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	
	 	for(var i=2;i>=0; i-- ){
	 		receivables.push(data["receivables"][i]);
	 		otherecevie.push(data["otherecevie"][i]);
	 		inventory.push(data["inventory"][i]);  
	 	}   
	     columnar8.hideLoading();    //隐藏加载动画
	     columnar8.setOption({        //加载数据图表                
	         /* legend: {
	             data: position	
	         }, */
	         series: [{
			        name: '应收账款',
			        smooth: true,
			        type: 'line',		  
			        data: receivables
			    }, {
			        name: '其它应收款',
			        smooth: true,
			        type: 'line',
			        stack: '总量',
			        data: otherecevie
			    }, {
			        name: '存货',
			        smooth: true,
			        type: 'line',
			       	stack: '总量',
			        data: inventory			  
			    }]
	     });
	 },
	 error: function (errorMsg) {
	     //请求失败时执行该函数
	     alert("图表请求数据失败!");
	     columnar8.hideLoading();
	 }
	}); 
	columnar8.setOption(option);
	})();
(function(){	
var columnar4 = echarts.init(document.getElementById("columnar4"));
option = {
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            crossStyle: {
	                color: '#999'
	            }
	        }
	    },
	    grid: {
			   top:'18%',
			   left:'25%'
		   },
	    legend: {
	        data:['预收款项','其它应付款', '流动负债合计', '未分配利润', '所有者权益合计'],
	        left:'30%'
	    },
	    xAxis: [
	        {
	            type: 'category',
	            data: ['2013','2014','2015'],
	            axisPointer: {
	                type: 'shadow'
	            }
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '金额（万元）',
	           /*  min: 0,
	            max: 2000,
	            interval: 100, */
	            axisLabel: {
	                formatter: '{value}'
	            }
	        }
	    ],
	    series: []
	};

columnar4.showLoading();    		 //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
  var advancePay        = [];        //预收账款
  var otherPay          = [];        //其它应付款
  var tcl               = [];        //流动负债合计
  var undistributProfit = [];        //未分配利润
  var owerInterest      = [];        //所有者权益
$.ajax({
 type: 'get',  
 url: './debtReport?name='+getParam('name'),//请求数据的地址
 dataType: "json",//返回数据形式为json
 success: function (data){
 	
 	for(var i=2;i>=0; i-- ){
 		advancePay.push(data["advancePay"][i]);
 		otherPay.push(data["otherPay"][i]);
 		tcl.push(data["tcl"][i]);
 		undistributProfit.push(data["undistributProfit"][i]);
 		owerInterest.push(data["owerInterest"][i]);  
 	}   
     columnar4.hideLoading();    //隐藏加载动画
     columnar4.setOption({        //加载数据图表                
         /* legend: {
             data: position	
         }, */
         series: [
      	        {
    	            name:'预收款项',
    	            type:'line',
    	            barWidth : 30,//柱图宽度
    	            data:advancePay
    	        },
    	        {
    	            name:'其它应付款',
    	            type:'line',
    	            barWidth : 30,//柱图宽度
    	            data:otherPay
    	        },
    	        {
    	            name:'流动负债合计',
    	            type:'line',
    	            barWidth : 30,//柱图宽度
    	            data:tcl
    	        },
    	        {
    	            name:'未分配利润',
    	            type:'line',
    	            barWidth : 30,//柱图宽度
    	            data:undistributProfit
    	        },
    	        {
    	            name:'所有者权益合计',
    	            type:'line',
    	            barWidth : 30,//柱图宽度
    	            data:owerInterest
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
	var columnar3 = echarts.init(document.getElementById("columnar3"));
	option = {
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'cross',
		            crossStyle: {
		                color: '#999'
		            }
		        }
		    },
		    grid: {
		    	
		    	left:"50%"
		    	
		    	
		    },
		    toolbox: {
		        feature: {
		            dataView: {show: true, readOnly: false},
		            magicType: {show: true, type: [ 'bar']},
		            restore: {show: true},
		            saveAsImage: {show: true}
		        }
		    },
		    legend: {
		        data:['营业收入','营业成本']		       
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['2013','2014','2015'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		           /*  min: 0,
		            max: 2500,
		            interval: 100, */
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: []
		};
	
	columnar3.showLoading();    //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var income     = [];        //营业成本
	  var cost       = [];        //营业成本
	$.ajax({
	 type: 'get',  
	 url: './profitfirst?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	
	 	for(var i=2;i>=0; i-- ){
	 		console.dir(data["income"][i]);
	 		income.push(data["income"][i]);
	 		cost.push(data["cost"][i]); 
	 	}   
	     columnar3.hideLoading();    //隐藏加载动画
	     columnar3.setOption({        //加载数据图表                
	         /* legend: {
	             data: position	
	         }, */
	         series: [{
		            name:'营业收入',
		            type:'bar',
		            data:income
		        },
		        {
		            name:'营业成本',
		            type:'bar',
		            data:cost
		        }]
	     });
	 },
	 error: function (errorMsg) {
	     //请求失败时执行该函数
	     alert("图表请求数据失败!");
	     columnar3.hideLoading();
	 }
	}); 
	columnar3.setOption(option);
	})();
(function(){
	
	var columnar2 = echarts.init(document.getElementById("columnar2"));

	option = {
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'cross',
		            crossStyle: {
		                color: '#999'
		            }
		        }
		    },
		    toolbox: {
		        feature: {
		            dataView: {show: true, readOnly: false},
		            magicType: {show: true, type: [ 'bar']},
		            restore: {show: true},
		            saveAsImage: {show: true}
		        }
		    },
		    legend: {
		        data:['营业利润','利润总额', '净利润'],
		        left:"2%"
		        
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['2013','2014','2015'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		           /*  min: 0,
		            max: 50,
		            interval: 5, */
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: []
		};
	columnar2.showLoading();    //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var operProfit  = [];        //营业利润
	  var countProfit = [];        //总利润
	  var netProfit   = [];        //净利润
	$.ajax({
	 type: 'get',  
	 url: './profitsecond?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	
	 	for(var i=2;i>=0; i-- ){
	 		operProfit.push(data["operProfit"][i]);
	 		countProfit.push(data["countProfit"][i]);
	 		netProfit.push(data["netProfit"][i]); 
	 	}   
	     columnar2.hideLoading();    //隐藏加载动画
	     columnar2.setOption({        //加载数据图表                
	         /* legend: {
	             data: position	
	         }, */
	         series: [		        {
		            name:'营业利润',
		            type:'bar',
		            data:operProfit
		        },
		        {
		            name:'利润总额',
		            type:'bar',
		            data:countProfit
		        },
		        {
		            name:'净利润',
		            type:'bar',
		            data:netProfit
		        }]
	     });
	 },
	 error: function (errorMsg) {
	     //请求失败时执行该函数
	     alert("图表请求数据失败!");
	     columnar2.hideLoading();
	 }
	}); 
	columnar2.setOption(option);
	})();
(function(){	
	var columnar3 = echarts.init(document.getElementById("columnar3"));
	option = {
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'cross',
		            crossStyle: {
		                color: '#999'
		            }
		        }
		    },
		    toolbox: {
		        feature: {
		            dataView: {show: true, readOnly: false},
		            magicType: {show: true, type: [ 'bar']},
		            restore: {show: true},
		            saveAsImage: {show: true}
		        }
		    },
		    legend: {
		        data:['营业收入','营业成本']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['2013','2014','2015'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		           /*  min: 0,
		            max: 2500,
		            interval: 100, */
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'营业收入',
		            type:'bar',
		            barWidth : 40,//柱图宽度
		            data:[1589, 1936, 2350]
		        },
		        {
		            name:'营业成本',
		            type:'bar',
		            barWidth : 40,//柱图宽度
		            data:[917, 1290, 1449]
		        }
		    ]
		};
	columnar3.setOption(option);
	})();
(function(){
	
	var columnar6 = echarts.init(document.getElementById("columnar6"));

	option = {
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'cross',
		            crossStyle: {
		                color: '#999'
		            }
		        }
		    },
		   grid: {
			   top:'15%'
		   },
		    legend: {
		        data:['经营活动现金流入小计','经营活动现金流出小计','投资活动现金流出小计'],
		        left:"-2%"
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['2013','2014','2015'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '金额（万元）',
		          /*   min: 0,
		            max: 4000,
		            interval: 1000, */
		            axisLabel: {
		                formatter: '{value}'
		            }
		        },
		        {
		            type: 'value',
		            name: '金额万元',
		          /*   min: 0,
		            max: 250, */
		           /*  interval: 20, */
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: []
		};
	
	columnar6.showLoading();    //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var operInCash    = [];        //经营活动现金流量净额
	  var operOutCash   = [];        //投资活动现金流量净额
	  var investOutCash = [];        //现金及等价净增额
	$.ajax({
	 type: 'get',  
	 url: './cashreport_first?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	
	 	for(var i=2;i>=0; i-- ){
	 		operInCash.push(data["operInCash"][i]);
	 		operOutCash.push(data["operOutCash"][i]);
	 		investOutCash.push(data["investOutCash"][i]); 
	 	}   
	     columnar6.hideLoading();    //隐藏加载动画
	     columnar6.setOption({        //加载数据图表                
	         /* legend: {
	             data: position	
	         }, */
	         series: [			        {
		            name:'经营活动现金流入小计',
		            type:'bar',
		            barWidth : 40,//柱图宽度
		            data:operInCash
		        },
		        {
		            name:'经营活动现金流出小计',
		            type:'bar',
		            barWidth : 40,//柱图宽度
		            data:operOutCash
		        },
		        {
		            name:'投资活动现金流出小计',
		            type:'line',
		            yAxisIndex: 1,
		            data:investOutCash
		        }]
	     });
	 },
	 error: function (errorMsg) {
	     //请求失败时执行该函数
	     alert("图表请求数据失败!");
	     columnar6.hideLoading();
	 }
	}); 
	columnar6.setOption(option);
	})();
(function(){
	
	var columnar7 = echarts.init(document.getElementById("columnar7"));

	option = {
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		    	data:['经营活动产生的现金流量净额','投资活动产生的现金流量净额', '现金及现金等价物净增加额']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    yAxis : [
		        {
		            type : 'category',
		            axisTick : {show: false},
		            data: ['2013','2014','2015']
		        }
		    ],
		    series : []
		};
	columnar7.showLoading();    //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var operCash    = [];        //经营活动现金流量净额
	  var investCash  = [];        //投资活动现金流量净额
	  var CashEqual   = [];        //现金及等价净增额
	$.ajax({
	 type: 'get',  
	 url: './cashreport_second?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	
	 	for(var i=2;i>=0; i-- ){
	 		operCash.push(data["operCash"][i]);
	 		investCash.push(data["investCash"][i]);
	 		CashEqual.push(data["CashEqual"][i]); 
	 	}   
	     columnar7.hideLoading();    //隐藏加载动画
	     columnar7.setOption({        //加载数据图表                
	         /* legend: {
	             data: position	
	         }, */
	         series: [	 {
	        	 name:'经营活动产生的现金流量净额',
		         type:'bar',           			            
	             label: {
	                normal: {
	                    show: true,
	                    position: 'inside'
	                }
	            },
	            data:operCash
	        },
	        {
	        	name:'投资活动产生的现金流量净额',
	            type:'bar',
	            stack: '总量',
	            label: {
	                normal: {
	                    show: true
	                }
	            },
	            data:investCash
	        },
	        {
	        	 name:'现金及现金等价物净增加额',
	            type:'bar',
	            stack: '总量',
	            label: {
	                normal: {
	                    show: true,
	                    position: 'right'
	                }
	            },
	            data:CashEqual
	        }]
	     });
	 },
	 error: function (errorMsg) {
	     //请求失败时执行该函数
	     alert("图表请求数据失败!");
	     columnar7.hideLoading();
	 }
	}); 
	columnar7.setOption(option);
	})();
</script>