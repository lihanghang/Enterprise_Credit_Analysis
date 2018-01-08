<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!-- start: Meta -->
	<title>企业信用报告数据展示平台</title>
	<meta name="description" content="company_credit">
	<!-- end: Meta -->
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
		width:738px;
		margin-left:200px;
		overflow-y:auto
	}
	.tab .nav-tabs li{
		margin: 0;
	}
	.tab .nav-tabs li a{
		font-size: 15px;
		/* color: #999898; */
		background: #fff;
		margin: 0;
		padding: 20px 25px;
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
		font-size: 14px;
		
		line-height: 20px;
		background: #fff;
		padding: 10px;
		/* border: 1px solid; */
		border-top: none;
		width:720px;
		margin-left:200px;
		font-wight:800px;
		
	
	}
	.tab .tab-content h3{
		font-size: 24px;
		color: #999898;
		margin-top: 1;
	}
	@media only screen and (max-width: 500px){
		.tab .nav-tabs li{
			width: 1000px;
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
			<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="../">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">企业基本信息</a></li>
			</ul>

<div class="row-fluid">
<%  
    String name = (String) session.getAttribute("name");//获取session中的用户昵称  
%> 
<h3 style="text-align:center; font-size:30px; font-weight:400px;font-family: sans-serif">${data.有名称}</h3>
	<div class="demo">
		<div class="container">
			<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="tab" role="tabpanel">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">企业介绍</a></li>
						<li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab">股东构成</a></li>
						<li role="presentation"><a href="#Section3" aria-controls="messages" role="tab" data-toggle="tab">员工学历构成</a></li>
						<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab">员工年龄构成及占比</a></li>
						<li role="presentation"><a href="#Section5" aria-controls="messages" role="tab" data-toggle="tab">岗位构成及员工占比</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content tabs">
						<div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<!-- <h3>Section 1</h3> -->
							<div class="am-u-md-6">
										<!-- <form class="am-form am-text-sm" > -->
											
												<div class="am-g">
											     <label  for="doc-ipt-text-1">企业名称:<span style="font-size:15px ">${data.有名称}</span></label>
										  
											      <!-- <input class="am-u-md-10 form-control"  id="doc-ipt-text-1" placeholder="输入标题信息"> -->
										      </div>
										    
										    
										   
										    	<div class="am-g">
											      <label for="doc-ipt-email-1">信用代码:<span style="font-size:15px ">${data.有信用代码}</span></label>
											       <span></span>
	<!-- 										      <input class="am-u-md-10 form-control"  id="doc-ipt-email-1" placeholder="输入电子邮件"> -->
											    </div>
										   							    

										  
										    	<div class="am-g">
											      <label for="doc-ipt-pwd-1">登记机关:<span style="font-size:15px ">${data.有登记机关}</span></label>
											      <!-- <input type="password" class="am-u-md-10"   id="doc-ipt-pwd-1" placeholder="设置个密码吧"> -->
											  
											    </div>
										 
										    
										  
										    	<div class="am-g">
											      <label for="doc-ipt-phd-1">中&nbsp;&nbsp;征&nbsp;&nbsp;码:<span style="font-size:15px ">${data.有中征码}</span></label>
											      <!-- <input class="am-u-md-10 form-control"  id="doc-ipt-phd-1" placeholder="提示信息" -->
										
											    </div>
										   
										    
										  
										    	<div class="am-g">
											      <label for="doc-ta-1">基本账户开户行:<span style="font-size:15px ">${data.有基本账户开户行}</span></label>
											     <!--  <textarea class="am-u-md-10 form-control" rows="5" id="doc-ta-1"></textarea> -->
			

										    	</div>
										   
										   
										    	<div class="am-g">
											      <label for="doc-ta-1">从业人数:<span style="font-size:15px ">${data.有从业人数}</span></label>		
										    	</div>
										 
										    
										    	<div class="am-g">
											      <label for="doc-ta-1">注册登记日期:<span style="font-size:15px ">${data.有注册登记日期}</span></label>		
										    	</div>
										   
										    
										    	<div class="am-g">
											      <label for="doc-ta-1">注册资本（万元）:<span style="font-size:15px ">${data.有注册资本}</span></label>		
										    	</div>
										   
										  
										    	<div class="am-g">
											      <label for="doc-ta-1">营业执照到期日:<span style="font-size:15px ">${data.有营业执照到期日}</span></label>		
										    	</div>
										   
										     
										    	<div class="am-g">
											      <label for="doc-ta-1">股本（万元）:<span style="font-size:15px ">${data.有股本}</span></label>		
										    	</div>
										   
										     <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">经营范围:<span style="font-size:15px ">${data.有经营范围}</span></label>		
										    	</div>
										    </div>
										<!-- </form> -->
									</div>
						
									<div class="am-u-md-6">
										<!-- <form class="am-form am-text-sm"> -->
											<div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">主营业务:<span style="font-size:15px ">${data.有主营业务}</span></label>		
										    	</div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">注册地址:<span style="font-size:15px ">${data.有注册地址}</span></label>		
										    	</div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">通讯地址:<span style="font-size:15px ">${data.有通讯地址}</span></label>		
										    	</div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">邮政编码:<span style="font-size:15px ">${data.有邮政编码}</span></label>		
										    	</div>
										    </div>

										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">联系人:<span style="font-size:15px ">${data.有联系人}</span></label>		
										    	</div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">联系电话:<span style="font-size:15px ">${data.有联系电话}</span></label>		
										    	</div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">传真电话:<span style="font-size:15px ">${data.有传真电话}</span></label>		
										    	</div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label for="doc-ta-1">网址:<span style="font-size:15px ">${data.有网址}</span></label>		
										    	</div>
										    </div>
										 
									</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section2">
							<!-- <h3>Section 2</h3> -->							
							<div id="pie3" style="width: 1000px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section3">
							<!-- <h3>Section 3</h3> -->
<!-- 							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec urna aliquam, ornare eros vel, malesuada lorem. Nullam faucibus lorem at eros consectetur lobortis. Maecenas nec nibh congue, placerat sem id, rutrum velit. Phasellus porta enim at facilisis condimentum. Maecenas pharetra dolor vel elit tempor pellentesque sed sed eros. Aenean vitae mauris tincidunt, imperdiet orci semper, rhoncus ligula. Vivamus scelerisque.</p>
 -->					<div id="pie5" style="width:1000px;height: 400px"></div>		
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section4">
							<!-- <h3>Section 4</h3> -->
							<div id="pie4" style="width:1000px;height: 400px"></div>	
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section5">
						<!-- 	<h3>Section 5</h3> -->
						<div id="pie1" style="width:1000px;height: 400px"></div>
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
		
	<div class="modal hide fade" id="myModal">
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

	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<ul class="list-inline item-details">
				<li><a href="#">Admin templates</a></li>
				<li><a href="http://themescloud.org">Bootstrap themes</a></li>
			</ul>
		</div>
	</div>



<div class="clearfix"></div>
	
	<footer>

		<p style = "text-align:center; padding:1px">
			<span >版权所有2017&copy;  <a href="http://ccip.ucas.ac.cn/" alt="Bootstrap_Metro_Dashboard">UCAS_CCIP实验室</a></span>
			
		</p>

	</footer>
	
	<!-- start: JavaScript-->

		<script src="../resource/new/js/jquery-2.1.0.js"></script>
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
		<script  src="../resource/assets/js/charts/echarts.min.js" ></script>
		<script src="../resource/index/js/getParam.js"></script>
	<!-- end: JavaScript-->
	


<script type="text/javascript">
//Echarts接口调用及数据处理
	(function(){
    	var pie3 = echarts.init(document.getElementById("pie3"));
    	pie3.showLoading({
            text: "图表数据正在努力加载..."
        });
		option = {
    		title : {
        	/* text: '股东构成信息',
        	x:'left', */
        	
    		},
    	tooltip : {
        	trigger: 'item',
        	formatter: "{a} <br/>{b} : {c} ({d}%)"
    		},
    	legend: {
        	orient: 'vertical',
        	left: 'left',
        	/* data: ['穆丽杰','北京爱侬世家管理咨询中心（有限合伙）','李洁璐','张穆森'] */
        	data:[]
   			 },
 
    	series : [
        	{
            	name: '投资金额（万元)及占股比例',
            	type: 'pie',
            	radius : '48%',
            	center: ['34%', '50%'],  //控制左右、上下位置
           		/* data:[
					{value:66.6667, name:'北京爱侬世家管理咨询中心（有限合伙）'},
                	{value:925.00, name:'穆丽杰'},               
                	{value:50.00, name:'李洁璐'},                	
                	{value:25, name:'张穆森'},
            	] */
            	data: [],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
 pie3.showLoading();    //数据加载完之前先显示一段简单的loading动画
//ajax异步请求数据
	var names = [];    //类别数组（用于存放饼图的类别）
	var moneys = [];
	$.ajax({
   
        type: 'get',  
        url: '../company/shareHold?name='+getParam('name',"UTF-8"),//请求数据的地址
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
            pie3.hideLoading();    //隐藏加载动画
            pie3.setOption({        //加载数据图表                
                legend: {
                    data: names
                },
                series: [{
                    data: moneys
                }]
            });
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            pie3.hideLoading();
        }
    });
  
pie3.setOption(option);
})();

(function(){
	var pie5 = echarts.init(document.getElementById("pie5"));
	option = {
		title : {
    /* 	text: '员工学历构成及占比',
    	subtext: '截至2015年12月31日',
    	x:'center',
 		color:['#bbe2e8','#6cacde']  */
		},
	tooltip : {
    	trigger: 'item',
    	formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
	legend: {
    	orient: 'vertical',
    	left: 'left',
    	data: []
			 },

	series : [
    	{
        	name: '学历人数及占比',
        	
        	type: 'pie',
        	radius : '48%',
        	center: ['34%', '50%'],  //控制左右、上下位置
       		data:[	],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }
]
};
	 pie5.showLoading();    //数据加载完之前先显示一段简单的loading动画
	//ajax异步请求数据
		var names = [];    //类别数组（用于存放饼图的类别）
		var moneys = [];
	    $.ajax({
	        type: 'get',  
	       url: '../company/study?name='+getParam('name',"UTF-8"),//请求数据的地址
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
	            pie5.hideLoading();    //隐藏加载动画
	            pie5.setOption({        //加载数据图表                
	                legend: {
	                    data: names
	                },
	                series: [{
	                    data: moneys
	                }]
	            });
	        },
	        error: function (errorMsg) {
	            //请求失败时执行该函数
	            alert("图表请求数据失败!");
	            pie5.hideLoading();
	        }
	    });
pie5.setOption(option);	
})();



(function(){
    	var pie4 = echarts.init(document.getElementById("pie4"));
		option = {
    		title : {
        	/* text: '员工年龄年龄构成及占比',
        	subtext: '截至2015年12月31日',
        	x:'center',
     		color:['#bbe2e8','#6cacde']  */
    		},
    	tooltip : {
        	trigger: 'item',
        	formatter: "{a} <br/>{b} : {c} ({d}%)"
    		},
    	legend: {
        	orient: 'vertical',
        	left: 'left',
        	data: []
   			 },
 
    	series : [
        	{
            	name: '年龄构成及占比',
            	
            	type: 'pie',
            	radius : '48%',
            	center: ['34%', '50%'],  //控制左右、上下位置
           		data:[],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
		 pie4.showLoading();    //数据加载完之前先显示一段简单的loading动画
			//ajax异步请求数据
				var type = [];    //类别数组（用于存放饼图的类别）
				var age = [];
			    $.ajax({
			        type: 'get',  
			       url: '../company/age?name='+getParam('name',"UTF-8"),//请求数据的地址
			        dataType: "json",//返回数据形式为json
			        success: function (data) {        	
			            //请求成功时执行该函数内容，result即为服务器返回的json对象
			            $.each(data, function(index,item) {
			                type.push(index);    //挨个取出类别并填入类别数组 
			               	age.push({
			               		name:index,
			                   	value:item                    
			                });
			            });
			            console.log(type.length)
			            if(type.length !=0 && age.length!=0){
			            pie4.hideLoading();    //隐藏加载动画
			            pie4.setOption({        //加载数据图表                
			                legend: {
			                    data: type
			                },
			                series: [{
			                    data: age
			                }]
			            });
			        }
			        
			    else{
			    	alert("无员工年龄信息！")
			    }},
			        
			        error: function (errorMsg) {
			            //请求失败时执行该函数
			            alert("图表请求数据失败!");
			            pie4.hideLoading();
			        }
			    });
pie4.setOption(option);
})();
(function(){
    	var pie1 = echarts.init(document.getElementById("pie1"));
		option = {
    		title : {
        	/* text: '公司岗位构成及员工占比',
        	subtext: '截至2015年12月31日',
        	x:'center' */
    		},
    	tooltip : {
        	trigger: 'item',
        	formatter: "{a} <br/>{b} : {c} ({d}%)"
    		},
    	legend: {
        	orient: 'vertical',
        	left: 'left',
        	data: []
   			 },
 
    	series : [
        	{
            	name: '岗位构成比例及人数',
            	
            	type: 'pie',
            	radius : '48%',
            	center: ['34%', '50%'],  //控制左右、上下位置
           		data:[],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
		 pie1.showLoading();    //数据加载完之前先显示一段简单的loading动画
			//ajax异步请求数据
				var position = [];    //类别数组（用于存放饼图的类别）
				var num = [];
			    $.ajax({
			        type: 'get',  
			       url: '../company/position?name='+getParam('name',"UTF-8"),//请求数据的地址
			        dataType: "json",//返回数据形式为json
			        success: function (data){	        	
			            //请求成功时执行该函数内容，result即为服务器返回的json对象
			            $.each(data, function(index,item) {
			            	 position.push(index);    //挨个取出类别并填入类别数组 
			               	 num.push({
			               		name:index,
			                   	value:item                    
			                });
			            });  
			            console.dir(position);
			            pie1.hideLoading();    //隐藏加载动画
			            pie1.setOption({        //加载数据图表                
			                legend: {
			                    data: position	
			                },
			                series: [{
			                    data: num
			                }]
			            });
			        },
			        error: function (errorMsg) {
			            //请求失败时执行该函数
			            alert("图表请求数据失败!");
			            pie1.hideLoading();
			        }
			    });
			  
pie1.setOption(option);
})();

</script>
</body>
</html>