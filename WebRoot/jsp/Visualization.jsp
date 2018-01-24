<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>企业信息可视化</title>
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
		height:650px;
		line-height: 20px;
		background: #fff;
		padding: 10px;
		padding-left:"10px";
		/* border: 1px solid; */
		border-top: none;
		width:1200px;
		margin-left:30px;
	
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
				<li><a href="#">企业信息可视化</a></li>
			</ul>

<div class="row-fluid">
<h3 style="text-align:center; font-size:30px; font-weight:400px;font-family: sans-serif">${name}信息可视化</h3>
	<div class="demo">
		<div class="container">
			<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="tab" role="tabpanel">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<!-- <li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">经营趋势分析</a></li>
		
					<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab">2015年各业务占比</a></li>
						<li role="presentation"><a href="#Section5" aria-controls="messages" role="tab" data-toggle="tab">前5大销售客户</a></li> -->
<!-- 						<li role="presentation" class="active"><a href="#Section7" aria-controls="messages" role="tab" data-toggle="tab">Visualization</a></li>
 -->					</ul>
					<!-- Tab panes -->
					
						<!-- <div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<h3>Section 1</h3>
							<div id="columnar6" style="width: 900px;height: 400px;"></div>
						</div>
			
						<div role="tabpanel" class="tab-pane fade" id="Section4">
							<h3>Section 2</h3>							
							<div id="columnar4" style="width: 900px;height: 400px;"></div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="Section5">
							<h3>Section 2</h3>							
							<div id="columnar5" style="width: 900px;height: 400px;"></div>
						</div> -->
						
						<!-- <div role="tabpanel" class="tab-pane fade" id="Section6">
							<h3>Section 2</h3>							
							<div id="columnar6" style="width: 900px;height: 400px;"></div>
						</div> -->
						
						
						
							<!-- <h3>Section 4</h3> -->
							
					
<!-- 						<h4 class="header-title m-t-0 m-b-30">visualization</h4>
 -->						<div id="main" style="width:1300px; height:600px;">
						<!-- <form class="am-form am-text-sm" > -->
		
			
		
						
						
				
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
		<script src="../resource/assets/js/charts/echarts.min.js" ></script>
	<!-- end: JavaScript-->
	
</body>
</html>
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
 <script>
        //初始化echarts实例
        var myChart = echarts.init(document.getElementById("main"), "macarons");
        var option = {
            backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
                offset: 0,
                color: '#f7f8fa'
            }, {
                offset: 1,
                color: '#cdd0d5'
            }]),
            animationDuration: 3000,
            animationEasingUpdate: 'quinticInOut',
            tooltip: {
                show: true
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} : {b}'
            },
            toolbox: {
                show: true,
                feature: {
                    restore: { show: true },
                    magicType: { show: true, type: ['force', 'chord'] },
                    saveAsImage: { show: true }
                }
            },
            title: {
                text:"企业知识图谱可视化"
            },
            
           
          
            series: [{
                itemStyle: {
                    
                    normal: {
                        label: {
                            position: 'top',
                            show: true,
                            textStyle: {
                                color: '#333'
                            }
                        },
                        nodeStyle: {
                            brushType: 'both',
                            borderColor: 'rgba(255,215,0,0.4)',
                            borderWidth: 1
                        },
                        linkStyle: {
                            normal: {
                                color: 'source',
                                curveness: 0,
                                type: "solid"
                            }
                        }
                    },
                   
                },
                     force:{
                    initLayout: 'circular',
                    repulsion:100,
                },
                     animation: false,
                name:"",
                type: 'graph',//关系图类型
                layout: 'force',//引力布局
                roam: true,//可以拖动
              //  legendHoverLink: true,//是否启用图例 hover(悬停) 时的联动高亮。
               // hoverAnimation: false,//是否开启鼠标悬停节点的显示动画
               // coordinateSystem: null,//坐标系可选
              //  xAxisIndex: 0, //x轴坐标 有多种坐标系轴坐标选项
              //  yAxisIndex: 0, //y轴坐标 
               // ribbonType: true,
                useWorker: false,
                minRadius: 15,
                maxRadius: 25,
                gravity: 1.1,
               
                scaling: 1.1,
                /* nodes: ${requestScope.node},
                links: ${requestScope.link} */
            } ]            
        }
        myChart.setOption(option);
       //var ecConfig = require('echarts/config');
       ///合并数组去重复
       function mergeArray(arr1, arr2){ 
 for (var i = 0 ; i < arr1.length ; i ++ ){
   for(var j = 0 ; j < arr2.length ; j ++ ){
    if (arr1[i] === arr2[j]){
     arr1.splice(i,1); //利用splice函数删除元素，从第i个位置，截取长度为1的元素
    }
   }
 }
 for(var i = 0; i <arr2.length; i++){
  arr1.push(arr2[i]);
 }
 return arr1;
}
////比较数组去重复
  function subArray(arr1, arr2){ 
 for (var i = 0 ; i < arr1.length ; i ++ ){
   for(var j = 0 ; j < arr2.length ; j ++ ){
    if (arr1[i] === arr2[j]){
     arr1.splice(i,1); //利用splice函数删除元素，从第i个位置，截取长度为1的元素
    }
   }
 }
 return arr1;
}
      // var index=0;
        myChart.on('click',   function openOrFold(param) {
       
            var option = myChart.getOption();//获取已生成图形的option
            var nodesOption = option.series[0].nodes;//获得所有节点数组
            var linksOption = option.series[0].links;//获得所有连接的数组
            var data = param.data;//表示当前选择的某一节点
            var linksNodes = [];//中间变量
          var first=  nodesOption[0].id
          
            if (data.category == (0)) {
               
            }
            //添加点击事件
            if (typeof param.seriesIndex == 'undefined') {    
                return;    
            }  
            
            
			 // alert(param.data.flag)
            if (param.type == 'click'&&param.name!=first&&param.data.flag==true) { 
            	//alert(data.flag)
            	var jadata=[]; 
            	var jlink=[];  
				   var index=0;
           for(i=0;i<nodesOption.length;i++){
           if(nodesOption[i].id==data.id){
          // alert(nodesOption[i].id+"---"+data.id)
           index=i;
          // alert(index)
           }
           }
                $.ajax({ 
                    url:"Visualization", //服务器的地址 
                    data:"name="+param.name, //参数 
                 	
                    dataType:"text", //返回数据类型 
                    type:"POST", //请求类型 
                    success:function(ja){ 
                    	console.log("print"+param.name);
                    //param.data.flag=false
                        var result =JSON.parse(ja);//转化为json对象
                       // alert(nodesOption[index].flag)
                     nodesOption[index].flag=false
                       // 	alert(JSON.stringify(result))
                   //    if(index%2==0){
                  // nodesOption[i].flag = false
                       nodesOption= mergeArray(nodesOption,result)//数组合并
                     //  }else {
                     //  nodesOption= subArray(nodesOption,result)//删除重复
                     //  }
                      
                       
                        myChart.setOption(option);//重新绘制
                        
                    },
                    
                });	
							
                $.ajax({ 
                    url:"getNextLink", //服务器的地址 
                    data:"name="+param.name, //参数 
                    dataType:"text", //返回数据类型 
                
                    type:"POST", //请求类型 
                    success:function(jalink){ 
                   // param.data.flag=false
                        var result =JSON.parse(jalink);
                   //  alert(JSON.stringify(result[0]))
                //  if(index%2==0){
                	//linksOption[index].flag = false
                       linksOption= mergeArray(linksOption,result)//数组合并
                    //   }else {
                    //   linksOption= subArray(linksOption,result)//删除重复
                   //    }
                         myChart.setOption(option);//重新绘制
                    },
                    
                });	
             //index++;
            }    
            //判断是否选择到了连接线上
          /*  if (data != null && data != undefined) {
                
                if (data.flag) {
                    //遍历关系数组，最终获得所选节点的一层子节点
                    for ( var m in linksOption) {
                        //父节点为当前节点
                        if (linksOption[m].target == data.id) {
							
                            linksNodes.push(linksOption[m].source);//获得子节点数据
                        }
                    }
                    //遍历子节点数组，设置对应的option属性
                    if (linksNodes != null && linksNodes != undefined) {
                        for ( var p in linksNodes) {
                            nodesOption[linksNodes[p]].ignore = false;//设置展示该节点
                            nodesOption[linksNodes[p]].flag = true;
                        }
                    }
                    nodesOption[data.id].flag = false;//设置该节点的flag为false，下次点击折叠子孙节点
                    myChart.setOption(option);//重新绘制
                } else {
                    for ( var m in linksOption) {
                        
                        if (linksOption[m].target == data.id) {//父节点为当前节点
                            linksNodes.push(linksOption[m].source);//找到当前节点的第一层子节点
                        }
                        if (linksNodes != null && linksNodes != undefined) {
                            for ( var n in linksNodes) {
                                //第一层子节点作为父节点，找到所有子孙节点
                                if (linksOption[m].target == linksNodes[n]) {
                                    linksNodes.push(linksOption[m].source);
                                }
                            }
                        }
                    }
                    //遍历最终生成的连接关系数组
                    if (linksNodes != null && linksNodes != undefined) {
                        for ( var p in linksNodes) {
                            nodesOption[linksNodes[p]].ignore = true;//设置折叠该节点
                            nodesOption[linksNodes[p]].flag = true;
                            $(".message").hide();
                        }
                    }
                    nodesOption[data.id].flag = true;//设置该节点的flag为true，下次点击展开子节点
                    myChart.setOption(option);//重绘
                }
            }*/
        }
       
       ); 
       
    </script>