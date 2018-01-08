<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
	
	<!-- start: Meta -->
	
	<title>公司关系图</title>
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
		width:1025px;
		margin-left:60px;
		overflow-y:auto
	}
	.tab .nav-tabs li{
		margin: 0;
	}
	.tab .nav-tabs li a{
		font-size: 14px;
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
		border-top: 10px;
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
		width:1000px;
		height:500px;
		margin-left:65px;
		font-wight:500px;
		
	
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
				<li><a href="#">公司关系图</a></li>
			</ul>

<div class="row-fluid">
<h3 style="text-align:center; font-size:30px; font-weight:400px;font-family: sans-serif">${name}</h3>
	<div class="demo">
		<div class="container">
			<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="tab" role="tabpanel">
					<!-- Nav tabs -->
					<!-- <ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">公司关系图</a></li>
					</ul> -->
					<!-- Tab panes -->
					<div class="tab-content tabs">
						<div role="tabpanel" class="tab-pane fade in active" id="Section1">
							<!-- <h3>Section 1</h3> -->
							<div id="main" style="width: 1000px;height: 500px;"></div>
								
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
		<script  src="../resource/assets/js/charts/echarts.min.js" ></script>
		<script  src="../resource/index/js/TreeGraph.js" ></script>
		<script src="../resource/index/js/getParam.js"></script>
	<!-- end: JavaScript-->
	



<script type="text/javascript" src="../resource/assets/js/charts/echarts-2.x.js" ></script>	
<script type="text/javascript">
//企业关系图实现
 //data=createDatabyHand()
/*  var myChart = echarts.init(document.getElementById("main"));
 var zNodes = [];   //企业关联数据
 $.ajax({
	   
     type: 'get',  
     url: 'https://open.api.tianyancha.com/services/v3/newopen/baseinfoV2.jsonid=22822',//请求数据的地址
     dataType: "json",//返回数据形式为json
     success: function (data) {
    	 alert(data);
         //请求成功时执行该函数内容，result即为服务器返回的json对象
    		var zNodes=[
    		            {id:1,pId:0,name:"董事长"},
    		            {id:11,pId:1,name:"经理"},
    		            {id:12,pId:1,name:"副总"},
    		            {id:13,pId:1,name:"秘书"},
    		            {id:16,pId:11,name:"财务经理"},
    		            {id:27,pId:11,name:"人事经理"},
    		            {id:18,pId:12,name:"HR"},
    		           ]
    		            data=getData(zNodes)
    		           	/* alert("data:"+JSON.stringify(data)) */
    		           
    		           	//setOption(myChart,"人事架构图",data)
/*     		           	createTreeV(myChart,"关联企业网图",zNodes);
     },
     error: function (errorMsg) {
         //请求失败时执行该函数
         alert("图表请求数据失败!");
         myChart.hideLoading();
     }
 });
  */
 
 

	
 
 (function(){
	var mychart = echarts.init(document.getElementById("main"));
option = {
    title : {
        text: '公司关系图',
        position: 'center',       
        subtext: '被投资单位、关联企业、下属单位'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{b}: {c}"
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : false,

    series : [
        {
            name:'树图',
            type:'tree',
            orient: 'horizontal',  // vertical horizontal
            rootLocation: {x: '25%', y: '60%'}, // 根节点位置  {x: 'center',y: 10}
            nodePadding: 30,
            symbol: 'circle',
            symbolSize: 40,
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        position: 'left',
                        textStyle: {
                            color: '#cc9999',
                            fontSize: 15,
                            fontWeight:  'bolder'
                        }
                    },
                    lineStyle: {
                        color: '#000',
                        width: 1,
                        type: 'curve' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                    }
                },
                emphasis: {
                    label: {
                        show: false
                    }
                }
            },
            data: [
                {
                    name: '北京爱侬养老服务股份有限公司',
                    
                   
                   
                    children: [
                        {
                            name: '被投资单位',
                            value: 7,
                           
                            itemStyle: {
                                normal: {
                                    label: {
                                        show: true
                                    }
                                }
                            },
                            children: [
                                {
                                    name: '北京市朝阳区爱侬养老院',
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    value: 30,
                                    itemStyle: {
                                        normal: {
                                            color: '#fa6900',
                                            label: {
                                                show: true,
                                                position: 'right'
                                            },
                                            
                                        },
                                        emphasis: {
                                            label: {
                                                show: false
                                            },
                                            borderWidth: 0
                                        }
                                    }
                                },
                                {
                                    name: '北京爱侬世家咨询服务有限公司',
                                    value: 200,
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    itemStyle: {
                                        normal: {
                                            label: {
                                                show: true,
                                                position: 'right',
                                                formatter: "{b}"
                                            },
                                            color: '#fa6900',
                                            borderWidth: 2,
                                            borderColor: '#cc66ff'

                                        },
                                        emphasis: {
                                            borderWidth: 0
                                        }
                                    }
                                },
                                {
                                    name: '北京市爱侬社区养老服务中心',
                                    value: 10,
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    itemStyle: {
                                        normal: {
                                            label: {
                                                position: 'right'
                                            },
                                            color: '#fa6900',
                                            brushType: 'stroke',
                                            borderWidth: 1,
                                            borderColor: '#999966',
                                        },
                                        emphasis: {
                                            borderWidth: 0
                                        }
                                    }
                                },
                                {
                                    name: '北京市西城区爱侬职业技能培训学校',
                                    value: 200,
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    itemStyle: {
                                        normal: {
                                            label: {
                                                position: 'right'
                                            },
                                            color: '#fa6900',
                                            brushType: 'stroke',
                                            borderWidth: 1,
                                            borderColor: '#999966',
                                        },
                                        emphasis: {
                                            borderWidth: 0
                                        }
                                    }
                                },
                                {
                                    name: '北京市朝阳区爱侬垡头养老照料中心',
                                    value: 5,
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    itemStyle: {
                                        normal: {
                                            label: {
                                                position: 'right'
                                            },
                                            color: '#fa6900',
                                            brushType: 'stroke',
                                            borderWidth: 1,
                                            borderColor: '#999966',
                                        },
                                        emphasis: {
                                            borderWidth: 0
                                        }
                                    }
                                },
                                {
                                    name: '北京市朝阳区爱侬职业技能培训学校',
                                    value: 50,
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    itemStyle: {
                                        normal: {
                                            label: {
                                                position: 'right'
                                            },
                                            color: '#fa6900',
                                            brushType: 'stroke',
                                            borderWidth: 1,
                                            borderColor: '#999966',
                                        },
                                        emphasis: {
                                            borderWidth: 0
                                        }
                                    }
                                },
                                {
                                    name: '北京市朝阳区养老服务指导中心',
                                    value: 5,
                                    symbol: 'circle',
                                    symbolSize: 10,
                                    itemStyle: {
                                        normal: {
                                            label: {
                                                position: 'right'
                                            },
                                            color: '#fa6900',
                                            brushType: 'stroke',
                                            borderWidth: 1,
                                            borderColor: '#999966',
                                        },
                                        emphasis: {
                                            borderWidth: 0
                                        }
                                    }
                                }
                            ]
                        },
                        {
                            name: '关联企业',
                           
                      		value: 2,
                            itemStyle: {
                                normal: {
                                    label: {
                                        show: true
                                    }
                                    
                                }
                            },children: [
                                        {
                                            name: '北京爱侬世家管理咨询中心（有限合伙)',
                                            symbol: 'circle',
                                            symbolSize: 10,
                                            itemStyle: {
                                                normal: {
                                                    label: {
                                                        position: 'right'
                                                    },
                                                    color: '#fa6900',
                                                    brushType: 'stroke',
                                                    borderWidth: 1,
                                                    borderColor: '#999966',
                                                },
                                                emphasis: {
                                                    borderWidth: 0
                                                }
                                            }
                        },{
                            name: '北京爱侬绿色餐饮管理有限公',
                         
                            symbol: 'circle',
                            symbolSize: 10,
                            itemStyle: {
                                normal: {
                                    label: {
                                        position: 'right'
                                    },
                                    color: '#fa6900',
                                    brushType: 'stroke',
                                    borderWidth: 1,
                                    borderColor: '#999966',
                                },
                                emphasis: {
                                    borderWidth: 0
                                }
                            }
        				},
                                        
                                        
                       ]},
                        {
                            name: '下属单位',
                            value: 38,
                            itemStyle: {
                                normal: {
                                    label: {
                                        show: true
                                    }
                                    
                                }
                            },
                            children : [
                                        {
                                            name: '北京市爱侬家政服务有限责任公司安贞里分部等共计38家分公司',
                                           
                                            symbol: 'circle',
                                            symbolSize: 10,
                                            itemStyle: {
                                                normal: {
                                                    label: {
                                                        position: 'right'
                                                    },
                                                    color: '#fa6900',
                                                    brushType: 'stroke',
                                                    borderWidth: 1,
                                                    borderColor: '#999966',
                                                },
                                                emphasis: {
                                                    borderWidth: 0
                                                }
                                            }
                        				}                                   
                                  ]                       
                        }
                    ]
                }
            ]
        }
    ]
},

mychart.setOption(option);

})(); 


/* columnar4.showLoading();    		 //数据加载完之前先显示一段简单的loading动画
ajax异步请求数据
var advancePay        = [];        //预收账款
var otherPay          = [];        //其它应付款
var tcl               = [];        //流动负债合计
var undistributProfit = [];        //未分配利润
var owerInterest      = [];        //所有者权益
$.ajax({
type: 'get',  
url: './debtReport',//请求数据的地址
dataType: "json",//返回数据形式为json
success: function (data){
	
	for(var i=2;i>=0; i-- ){
		advancePay.push(data["advancePay"][i]);
		otherPay.push(data["otherPay"][i]);
		tcl.push(data["tcl"][i]);
		undistributProfit.push(data["undistributProfit"][i]);
		owerInterest.push(data["owerInterest"][i]);  
	}   
	mychart.hideLoading();    //隐藏加载动画
   	mychart.setOption({        //加载数据图表                
       /* legend: {
           data: position	
       }, */
     /*   series: [
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
   mychart.hideLoading();
}
});                      */ 
/* mychart.setOption(option);

})(); */ 

</script>
</body>
</html>