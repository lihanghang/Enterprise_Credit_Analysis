<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>经营发展分析</title>
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
		width:980px;
		margin-left:68px;
	}
	.tab .nav-tabs li{
		margin: 0;
	}
	.tab .nav-tabs li a{
		font-size: 13x;
		
		background: #fff;
		margin: 0;
		padding: 20px 10px;
		border-radius: 0;
		border: none;
		border-right: 1px solid #ddd;
		text-transform: uppercase;
		position: relative;
	}
	.tab .nav-tabs li a:hover{
		border-top: none;
		border-bottom: none;
		/* border-right-color: #ddd; */
	}
	.tab .nav-tabs li.active a,
	.tab .nav-tabs li.active a:hover{
		color: black;
		border: none;
		background: #fff
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
		border-top: 10px;
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
		width:960px;
		margin-left:68px;
	
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
				<li><a href="#">业务经营发展分析</a></li>
			</ul>

<div class="row-fluid">
<h3 style="text-align:center; font-size:30px; font-weight:400px;font-family: sans-serif">${name}(2013--2015业务经营)</h3>
	<div class="demo">
		<div class="container">
			<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="tab" role="tabpanel">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">经营趋势分析</a></li>
<!-- 		
 -->					<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab">2015年各业务占比</a></li>
						<li role="presentation"><a href="#Section5" aria-controls="messages" role="tab" data-toggle="tab">前5大销售客户</a></li>
						<li role="presentation"><a href="#Section7" aria-controls="messages" role="tab" data-toggle="tab">经营变动情况</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content tabs">
						<div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<!-- <h3>Section 1</h3> -->
							<div id="columnar6" style="width: 900px;height: 400px;"></div>
						</div>
						<!-- <div role="tabpanel" class="tab-pane fade" id="Section2">
							<h3>Section 2</h3>							
							<div id="columnar2" style="width: 900px;height: 400px;"></div>
						</div>  -->
					<!-- <div role="tabpanel" class="tab-pane fade" id="Section3">
							<h3>Section 3</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec urna aliquam, ornare eros vel, malesuada lorem. Nullam faucibus lorem at eros consectetur lobortis. Maecenas nec nibh congue, placerat sem id, rutrum velit. Phasellus porta enim at facilisis condimentum. Maecenas pharetra dolor vel elit tempor pellentesque sed sed eros. Aenean vitae mauris tincidunt, imperdiet orci semper, rhoncus ligula. Vivamus scelerisque.</p>
					<div id="columnar3" style="width:1000px;height: 400px"></div>		
						</div> -->
						<div role="tabpanel" class="tab-pane fade" id="Section4">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar4" style="width: 900px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section5">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar5" style="width: 900px;height: 400px;"></div>
						</div>
						
						<!-- <div role="tabpanel" class="tab-pane fade" id="Section6">
							<h3>Section 2</h3>							
							<div id="columnar6" style="width: 900px;height: 400px;"></div>
						</div> -->
						
						
						<div role="tabpanel" class="tab-pane fade" id="Section7">
							<!-- <h3>Section 4</h3> -->
							<div class="am-u-md-6">
					<div class="card-box">
						<h4 class="header-title m-t-0 m-b-30">经营变动情况</h4>
						<!-- <form class="am-form am-text-sm" > -->
					<div  style="width: 100%;height: 300px">	
							<div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">主营业务（产品）是否发生变化:<span style="font-size:15px ">
											${data.是否发生变化}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">主营业务（产品）生产经营是否正常:<span style="font-size:15px ">
											${data.生产经营是否正常}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">主营业务（产品）发展趋势:<span style="font-size:15px ">
											${data.发展趋势}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">主营业务（产品）具体情况:<span style="font-size:15px ">
											${data.主营业务具体情况}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">外部经营环境是否发生不利经营的重大变化:<span style="font-size:15px ">
											${data.是否发生不利经营的重大变化}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">对竞争变化或外部条件变化是否有应对措施:<span style="font-size:15px ">
											${data.对竞争变化或外部条件变化是否有应对措施}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">外部经营环境具体情况:<span style="font-size:15px ">
			${data.外部环境具体情况}
</span>									</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">主要客户及经营状况是否减少或流失:<span style="font-size:15px ">
											 ${data.是否减少或流失}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">现有主要客户:<span style="font-size:15px ">
											${data.现有主要客户}</span>
										</label>
									</div>
							  </div>
							  <div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1">目前经营状况:<span style="font-size:15px ">
											 ${data.目前经营状况}</span>
										</label>
									</div>
							  </div>
					</div>		
				</div>
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
			
       

	</div>	
		</div>
		</div>
	
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
		<script src="../resource/index/js/getParam.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>
<script type="text/javascript" src="../resource/assets/js/charts/echarts.min.js" ></script>
<script type="text/javascript">
/* (function(){
	
	var columnar1 = echarts.init(document.getElementById("columnar1"));

	option = {


		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['营业收入','营业成本','利润总额'],
		        left:'0.5%',
		        top:'1%'
		    },
		    grid: {
		        left: '2%',
		        right: '4%',
		        bottom: '10%',
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
	columnar1.showLoading();    		 //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var income = [];        //预收账款
	  var cost = [];        //其它应付款
	  var profits  = [];        //流动负债合计
	$.ajax({
	 type: 'get',  
	 url: './basicinfo?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	
	 	for(var i=2;i>=0; i-- ){
	 		income.push(data["income"][i]);
	 		cost.push(data["cost"][i]);
	 		profits.push(data["profits"][i]);
	 	}   
	     columnar1.hideLoading();    //隐藏加载动画
	     columnar1.setOption({        //加载数据图表                
	         /* legend: {
	             data: position	
	         }, */
/* 	         series: [
	      	        {
		            name:'营业收入',
		            type:'line',
		            stack: '总量',
		            data:income
		        } ,
		        {
		            name:'营业成本',
		            type:'line',
		            stack: '总量',
		            data:cost
		        }
		        ,
		        {
		            name:'利润总额',
		            type:'line',
		            stack: '总量',
		            data:profits
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
	})(); */
(function(){	
var columnar4 = echarts.init(document.getElementById("columnar4"));
option = {
	    title : {
	      text: '2015年公司业务占比情况',
	       subtext: '来源企业信用报告',
	       x:'center'
	   },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	    },
	    series : []
	};
columnar4.showLoading();    //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
	var names = [];    //类别数组（用于存放饼图的类别）
	var moneys = [];
  $.ajax({
      type: 'get',  
      url: './business?name='+getParam('name'),//请求数据的地址
      dataType: "json",//返回数据形式为json
      success: function (data) {        	
          //请求成功时执行该函数内容，result即为服务器返回的json对象
          $.each(data, function(index,item) {
              names.push(index);    //挨个取出类别并填入类别数组 
             	moneys.push({
             		name:index,
                 	value:item                    
              });
          });            
          columnar4.hideLoading();    //隐藏加载动画
          columnar4.setOption({        //加载数据图表                
              legend: {
            	  orient: 'vertical',
      	        left: 'left',
      	        data: names
              },
              series: [ {
	            name: '业务名称',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:moneys,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
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
		    title : {
		      text: '前5大销售客户及交易金额占比',
		       subtext: '来源企业信用报告',
		       x:'center'
		   },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        top:'8%',
		        data: []
		    },
		    series : []
		};
	columnar5.showLoading();    		 //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var name = [];        //客户名称
	  var cash = [];        //销售金额
	$.ajax({
	 type: 'get',  
	 url: './custom?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	console.log(data);
		for(var i=4;i>=0; i-- ){
       		name.push(data["customname"][i]);
       		console.dir(name);
       		cash.push({value:data["pay"][i],name:data["customname"][i]} );	
       	} 
	     columnar5.hideLoading();    //隐藏加载动画
	     columnar5.setOption({        //加载数据图表                
	          legend: {
	             data: name
	         }, 
	         series: [
	      	        		        {
		            name: '客户名称',
		            type: 'pie',
		            radius : '50%',
		            center: ['60%', "57%"],
		            data:cash,
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
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
	
	var columnar6 = echarts.init(document.getElementById("columnar6"));

	option = {

		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['营业收入','利润总额'],
		        left:'0.5%',
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
		    series: []
		};
	columnar6.showLoading();    		 //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var name = [];        //客户名称
	  var cash = [];        //销售金额
	$.ajax({
	 type: 'get',  
	 url: './opertrend?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
		
			
		
	 	console.log(data);
		for(var i=2;i>=0; i-- ){
       		name.push(data["count"][i]);
       		cash.push(data["pay"][i]);	
       	} 
		
		
	     columnar6.hideLoading();    //隐藏加载动画
	     columnar6.setOption({        //加载数据图表                
	         /*  legend: {
	             data: name
	         },  */
	         series: [
{
    name:'营业收入',
    type:'line',
    stack: '总量',
    data:name
} ,
{
    name:'利润总额',
    type:'line',
    stack: '总量',
    data:cash
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
</script>