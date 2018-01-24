<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>行业发展分析</title>
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
		width:780px;
		margin-left:180px
	}
	.tab .nav-tabs li{
		margin: 0;
	}
	.tab .nav-tabs li a{
		font-size: 14px;
		/* color: #999898; */
		background: #fff;
		margin: 0;
		padding: 20px 24.6px;
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
		/* border: 0px solid; */
		border-top: none;
		width:758px;
		margin-left:180px
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
				<li><a href="#">行业发展分析</a></li>
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
						<li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">行业状况</a></li>
						<li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab">行业政策</a></li>
						<li role="presentation"><a href="#Section3" aria-controls="messages" role="tab" data-toggle="tab">行业特征及制约因素</a></li>
						<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab">市场格局及业内竞争</a></li>
					    <li role="presentation"><a href="#Section5" aria-controls="messages" role="tab" data-toggle="tab">行业现状及未来展望</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content tabs">
						<div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<!-- <h3>Section 1</h3> -->
							
						<div class="am-form-group">
												<div class="am-g">
											      <label  for="doc-ipt-text-1">行业类别:<span style="font-size:15px ">${data.有行业类别}</span></label>
											  
											      <!-- <input class="am-u-md-10 form-control"  id="doc-ipt-text-1" placeholder="输入标题信息"> -->
										      </div>
										    </div>
										    
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ipt-email-1">行业政策指向情况:<span style="font-size:15px ">${data.有行业政策指向情况}</span></label>
											       <span></span>
	<!-- 										      <input class="am-u-md-10 form-control"  id="doc-ipt-email-1" placeholder="输入电子邮件"> -->
											    </div>
										    </div>								    

										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ipt-pwd-1">行业所处发展阶段:<span style="font-size:15px ">${data.有行业所处发展阶段}</span></label>
											      <!-- <input type="password" class="am-u-md-10"   id="doc-ipt-pwd-1" placeholder="设置个密码吧"> -->
											  
											    </div>
										    </div>
										    
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ipt-phd-1">行业需求情况:<span style="font-size:15px ">${data.有行业需求情况}</span></label>
											      <!-- <input class="am-u-md-10 form-control"  id="doc-ipt-phd-1" placeholder="提示信息" -->
										
											    </div>
										    </div>
										    
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">行业竞争格局:<span style="font-size:15px ">${data.有行业竞争格局}</span></label>
											     <!--  <textarea class="am-u-md-10 form-control" rows="5" id="doc-ta-1"></textarea> -->
			

										    	</div>
										    </div>
										   <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">行业竞争形式:<span style="font-size:15px ">${data.有行业竞争形式}</span></label>		
										    	</div>
										    </div>
										     <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">公司在行业中竞争地位:<span style="font-size:15px ">${data.有行业中竞争地位}</span></label>		
										    	</div>
										    </div>
										     <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">行业竞争具体情况:<span style="font-size:15px ">${data.有行业竞争具体情况}</span></label>		
										    	</div>
										    </div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section2">
							<!-- <h3>Section 2</h3> -->							
							<div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1"><span style="font-size:15px ">
											${data.有行业相关政策}
												</span>
										</label>
											     <!--  <textarea class="am-u-md-10 form-control" rows="5" id="doc-ta-1"></textarea> -->
									</div>
							  </div>			
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section3">
							<!-- <h3>Section 3</h3> -->
<!-- 							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec urna aliquam, ornare eros vel, malesuada lorem. Nullam faucibus lorem at eros consectetur lobortis. Maecenas nec nibh congue, placerat sem id, rutrum velit. Phasellus porta enim at facilisis condimentum. Maecenas pharetra dolor vel elit tempor pellentesque sed sed eros. Aenean vitae mauris tincidunt, imperdiet orci semper, rhoncus ligula. Vivamus scelerisque.</p>
 -->					<div class="am-form-group">
									<div class="am-g">
										<label>${data.有行业特征及制约性因素}

												</span>
										</label>
											     <!--  <textarea class="am-u-md-10 form-control" rows="5" id="doc-ta-1"></textarea> -->
									</div>
							  </div>	
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section4">
							<!-- <h3>Section 4</h3> -->
							<div class="am-u-md-6">
						<div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1"><span style="font-size:15px ">
											${data.有市场格局及业内竞争}</span>
										</label>
									</div>

							  </div>			
		 </div>	
						</div>
											<div role="tabpanel" class="tab-pane fade" id="Section5">
							<!-- <h3>Section 4</h3> -->
							<div class="am-u-md-6">
						<div class="am-form-group">
									<div class="am-g">
										<label for="doc-ta-1"><span style="font-size:15px ">
											${data.有行业现状及未来展望}

</span>
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
	<!-- end: JavaScript-->
	
</body>
</html>
<script type="text/javascript" src="../resource/assets/js/charts/echarts.min.js" ></script>
<script type="text/javascript">
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
	            min: 0,
	          	max: 5,
	      
	        }
	    ],
	    series : [
	        {
	            name:'资金变动',
	            type:'bar',
	           
	            barWidth: '25%',
	            data:[3, 3, 0, 0]
	        }
	    ]
	};

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
            min: 0,
            max: 10,
            interval: 1,
            axisLabel: {
                formatter: '{value}'
            }
        },   {
            type: 'value',
            name: '负债期限（年）',
            min: 0,
            max: 5,
            interval: 1,
            axisLabel: {
                formatter: '{value}'
            }
        }
       
    ],
    series: [
        {
            name:'负债金额',
            type:'bar',
            barWidth : 40,//柱图宽度
            data:[2.0, 4.9, 7.0]
        },
        {
            name:'负债期限',
            type:'line',
            yAxisIndex: 1,
            data:[2.0, 2.2, 3.3]
        }
    
    ]
};
columnar4.setOption(option);
})();


</script>