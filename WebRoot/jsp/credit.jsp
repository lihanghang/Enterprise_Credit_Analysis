<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!-- start: Meta -->
	<title>企业税务资信情况</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link rel="shortcut icon" href="../resource/assets/img/inform.png">
	<link rel="stylesheet" href="../resource/assets/css/core.css" />
	<link rel="stylesheet" href="../resource/assets/css/menu.css" />
	<link rel="stylesheet" href="../resource/assets/css/index.css" />		
	<link id="bootstrap-style" href="../resource/new/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resource/new/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="../resource/new/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="../resource/new/css/style-responsive.css" rel="stylesheet">	
	<!-- end: CSS -->	
	
<style type="text/css">
	.demo{padding: 1em 1px;}
	a:hover,a:focus{
		outline: none;
		text-decoration: none;
	}
	.tab .nav-tabs{
		border: 0px solid #1fc1dd;
		width:780px;
		margin-left:180px
	}
	.tab .nav-tabs li{
		margin: 2px;
	}
	.tab .nav-tabs li a{
		font-size: 13.2px;
		/* color: black; */
		background: #fff;
		margin: 0;
		padding: 20px 55px;
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
		color: #fff;
		border: none;
		color:black;
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
		color:black
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
		line-height: 20px;
		background: #fff;
		padding: 10px;
		/* border: 1px solid; */
		border-top: none;
		width:758px;
		margin-left:180px;
		font-wight:500px;
		
	}
	.tab .tab-content h3{
		font-size: 24px;
		color: #999898;
		margin-top: 1;
	}
	@media only screen and (max-width: 480px){
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
		
		<!-- end: Header -->
		<div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			
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
				<li><a href="#">企业税务、负债、资信情况</a></li>
			</ul>

<div class="row-fluid">
<h3 style="text-align:center; font-size:30px; font-weight:400px;font-family: sans-serif">${name}</h3>
	<div class="demo">
		<div class="container">
			<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="tab" role="tabpanel">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">税务信息</a></li>
						<li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab">负债偿还情况</a></li>
						<li role="presentation"><a href="#Section3" aria-controls="messages" role="tab" data-toggle="tab">负债情况</a></li>
						<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab">借款人资信状况</a></li>
						<!-- <li role="presentation"><a href="#Section5" aria-controls="messages" role="tab" data-toggle="tab">岗位构成及员工占比</a></li> -->
					</ul>
					<!-- Tab panes -->
					<div class="tab-content tabs">
						<div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<!-- <h3>Section 1</h3> -->
							
						<div class="am-form-group">
												<div class="am-g">
											      <label  for="doc-ipt-text-1">国税机关:<span style="font-size:15px ">${data.有国税机关}</span></label>
											  
											      <!-- <input class="am-u-md-10 form-control"  id="doc-ipt-text-1" placeholder="输入标题信息"> -->
										      </div>
										    </div>
										    
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ipt-email-1">地税机关:<span style="font-size:15px ">${data.有地税机关}</span></label>
											       <span></span>
	<!-- 										      <input class="am-u-md-10 form-control"  id="doc-ipt-email-1" placeholder="输入电子邮件"> -->
											    </div>
										    </div>								    

										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ipt-pwd-1">统一社会信用代码:<span style="font-size:15px ">${data.有统一社会信用代码}</span></label>
											      <!-- <input type="password" class="am-u-md-10"   id="doc-ipt-pwd-1" placeholder="设置个密码吧"> -->
											  
											    </div>
										    </div>
										    
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ipt-phd-1">欠税信息:<span style="font-size:15px ">${data.欠税信息}</span></label>
											      <!-- <input class="am-u-md-10 form-control"  id="doc-ipt-phd-1" placeholder="提示信息" -->
										
											    </div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">纳税信用A级企业:<span style="font-size:15px ">${data.纳税信用A级企业}</span></label>
											     <!--  <textarea class="am-u-md-10 form-control" rows="5" id="doc-ta-1"></textarea> -->
			

										    	</div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">其它信息:<span style="font-size:15px ">${data.有其它信息}</span></label>
											     <!--  <textarea class="am-u-md-10 form-control" rows="5" id="doc-ta-1"></textarea> -->
			

										    	</div>
										    </div>
										   <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">主要税种及税率:<span style="font-size:15px ">${data.有主要税种及税率}</span></label>		
										    	</div>
										    </div>
										     <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">上年度缴税额（万元）:<span style="font-size:15px ">${data.有上年度缴税额}</span></label>		
										    	</div>
										    </div>
										     <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">上年未应交额（万元）:<span style="font-size:15px ">${data.有上年末应交额}</span></label>		
										    	</div>
										    </div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section2">
							<!-- <h3>Section 2</h3> -->							
							<div id="columnar1" style="width:770px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section3">
							<!-- <h3>Section 3</h3> -->
<!-- 							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec urna aliquam, ornare eros vel, malesuada lorem. Nullam faucibus lorem at eros consectetur lobortis. Maecenas nec nibh congue, placerat sem id, rutrum velit. Phasellus porta enim at facilisis condimentum. Maecenas pharetra dolor vel elit tempor pellentesque sed sed eros. Aenean vitae mauris tincidunt, imperdiet orci semper, rhoncus ligula. Vivamus scelerisque.</p>
 -->					<div id="columnar4" style="width:770px;height: 400px"></div>		
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section4">
							<!-- <h3>Section 4</h3> -->
							<div class="am-u-md-6">
					<div class="card-box">
						<h4 class="header-title m-t-0 m-b-30">借款人资信状况</h4>
						<!-- <form class="am-form am-text-sm" > -->
					<div  style="width: 100%;height: 300px">	
							<div class="am-form-group">
								<div class="am-g">
									<label  for="doc-ipt-text-1">涉诉查询记录:<span style="font-size:15px ">${data.涉诉查询记录}</span></label>											  											     
								 </div>
						  </div>
						  <div class="am-form-group">
								<div class="am-g">
									<label  for="doc-ipt-text-1">信用网查询记录:<span style="font-size:15px ">${data.信用网查询记录}</span></label>											  											     
								 </div>
						  </div>
						  <div class="am-form-group">
								<div class="am-g">
									<label  for="doc-ipt-text-1">纳税信用等级:<span style="font-size:15px ">${data.纳税信用等级}</span></label>											  											     
								 </div>
						  </div>
						  <div class="am-form-group">
								<div class="am-g">
									<label  for="doc-ipt-text-1">互联网查询情况:<span style="font-size:15px ">${data.互联网查询情况}</span></label>											  											     
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
	<div class="clearfix"></div>
	<footer>

		<p style = "text-align:center;">
			<span style = "text-align:center;" >版权所有2017&copy;  <a href="http://ccip.ucas.ac.cn/" alt="Bootstrap_Metro_Dashboard">UCAS_CCIP实验室</a></span>
			
		</p>

	</footer>
</body>
</html>
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
		<script src='../resource/new/js/jquery.dataTables.min.js'></script>
		
		<script src="../resource/index/js/getParam.js"></script>
	
	
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
<script type="text/javascript" src="../resource/assets/js/charts/echarts.min.js" ></script>
<script type="text/javascript">
/* alert(getParam('name')); */
(function(){
	
	var columnar1 = echarts.init(document.getElementById("columnar1"));

	option = {
		
		title: {
			text: "负债偿还情况",
			x:'left'
		},
		
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['上年度发生额', '上年度支付额', '上年度应\n付账款变动额', '上年末应付\n账款余额'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            name: '资金(万元)',
	           /*  min: 0,
	          	max: 5, */
	      
	        }
	    ],
	    series : []
	};
	columnar1.showLoading();    		 //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
	  var cash = [];        //销售金额
	$.ajax({
	 type: 'get',  
	 url: './debtepay?name='+getParam('name'),//请求数据的地址
	 dataType: "json",//返回数据形式为json
	 success: function (data){
	 	console.log(data);
		for(var i=0;i<=3; i++){
       		cash.push(data["data"][i]);
       		console.dir(name);	
       	} 
	     columnar1.hideLoading();    //隐藏加载动画
	     columnar1.setOption({        //加载数据图表                
	         /*  legend: {
	             data: name
	         },  */
	         series: [
{
    name:'资金变动',
    type:'bar',
   
    barWidth: '25%',
    data:cash
}
		            
		        ]
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
	
var columnar4 = echarts.init(document.getElementById("columnar4"));
option = {
	title: {
			text: "负债情况",
			x:'left'
		},
		
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
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    legend: {
        data:['负债金额','负债期限']
    },
    xAxis: [
        {
            type: 'category',
            data: ['应收票据贴现\n或背书转让','对外担保','未决诉讼或仲裁'],
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
            max: 10, 
            interval: 1,*/
            axisLabel: {
                formatter: '{value}'
            }
        },   {
            type: 'value',
            name: '负债期限（年）',
           /*  min: 0,
            max: 5, */
            interval: 1,
            axisLabel: {
                formatter: '{value}'
            }
        }
       
    ],
    series: []
};
columnar4.showLoading();    		 //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
  var name = [];        //销售金额
  var money = [];
  var time = [];
$.ajax({
 type: 'get',  
 url: './debteinfo?name='+getParam('name'),//请求数据的地址
 dataType: "json",//返回数据形式为json
 success: function (data){
 	console.log(data);
	for(var i=0;i<=3; i++){
   		name.push(data["names"][i]);
   		money.push(data["money"][i]);
   		time.push(data["time"][i]);
   		console.dir(name);	
   	} 
     columnar4.hideLoading();    //隐藏加载动画
     columnar4.setOption({        //加载数据图表                
           /* legend: {
             data: name
         },   */
         series: [{
             name:'负债金额',
             type:'bar',
             barWidth : 40,//柱图宽度
             data:money
         },
         {
             name:'负债期限',
             type:'line',
             yAxisIndex: 1,
             data:time
         }

	            
	        ]
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


</script>

