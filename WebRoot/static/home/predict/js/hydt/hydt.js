//tab窗口切换0604 by Hang Hang Li
function setTab(name,cursel){
	var links = document.getElementById("tab1").getElementsByTagName('li')
	 links_len=links.length;
	console.log(cursel)
 cursel_0=cursel;
 for(var i=1; i<=links_len; i++){
  var menu = document.getElementById(name+i);
  var menudiv = document.getElementById("con_"+name+"_"+i);
  if(i==cursel){
   menu.className="off";
   menudiv.style.display="block";
  }
  else{
   menu.className="";
   menudiv.style.display="none";
  }
 }
}
function Next(){
    cursel_0++;
    if (cursel_0>links_len) cursel_0=1
    setTab(name_0,cursel_0);
}
var name_0='one';
var cursel_0=1;
//var type = 0; 默认选中第一个行业
var links_len,iIntervalId;
onload=function(){
    var links = document.getElementById("tab1").getElementsByTagName('li')
    links_len=links.length;
    var funny = function(i){
    links[i].onclick = function(){
            console.log("第" + (i+1) + "个");
        }
    }    
    /*for(var i=0; i<links_len; i++){        
        type = i;
        console.log(i)
  // links[i].onmouseover=function(){
  //  //clearInterval(iIntervalId);
   
  // }
    }*/
 setTab(name_0,cursel_0);
}


// 数据处理Js

var reducer = function add(sumSoFar, item) {
	sumSoFar.sum = sumSoFar.sum + item;
	return sumSoFar;
};

function maths(data) {
	var val = [];
	for (var i = 0; i < data.length; i++) {
		val[i] = parseFloat(data[i]);
	}
	var total = val.reduce(reducer, {
		sum : 0
	});
	var info = [];
	var mean = val.reduce(sum) / val.length;
	var deviations = val.map(function(x) {
		return x - mean;
	});
	var stddev = Math.sqrt(deviations.map(square).reduce(sum)
			/ (val.length - 1));

	var arrCold = [];
	var arrLimit = [];
	// 偏冷线
	var cold = mean - 1.96 * stddev;
	// 适度下限
	var limit = mean - 1.28 * stddev;
	// 偏热线
	var hot = mean + 1.96 * stddev;
	// 适度上限
	var upper = mean + 1.28 * stddev;
	for (var i = 0; i < val.length; i++) {
		arrCold[i] = cold;
		arrLimit[i] = limit;
	}
	info.push(arrCold);
	info.push(arrLimit);
	info.push(hot)
	info.push(upper)
	return info;

}

// Echarts接口调用及数据处理

var pie3;
function hyZonghe(type) {

	if (pie3 != null && pie3 != "" && pie3 != undefined) {
		pie3.dispose();
	}
	pie3 = echarts.init(document.getElementById("pie3_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	option3 = {
		title : {
			text : '财务分析(综合)',
			left : '50%',
			textAlign : 'center'

		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			}
		},
		toolbox : {
			show: true,
			right: '15%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					/*title : "切换", */// 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				 /*  'bar' : "切换为柱状模式",
				   'line': "切换为折线模式"*/
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
				    title:"数据视图",
				    readOnly: true, //是否不可编辑（只读）
				// lang: ['数据视图', '关闭', '刷新'], //数据视图上有三个话术，默认是['数据视图', '关闭',
				// '刷新']
				// backgroundColor:"#fff", //数据视图浮层背景色。
				// textareaColor:"#fff", //数据视图浮层文本输入区背景色
				// textareaBorderColor:"#333", //数据视图浮层文本输入区边框颜色
				// textColor:"#000", //文本颜色。
				// buttonColor:"#c23531", //按钮颜色。
				// buttonTextColor:"#fff", //按钮文本颜色。
				}
			}

		},
		legend : {
			left : "0",
			data : [ '盈利能力', '偿债能力', '经营效率', '增长潜力', '综合风险' ]
		},
		xAxis : {
			type : 'category',
			name : '年份',
			data : [],
			boundaryGap : true,
			splitLine : {
				show : true,
				interval : 'auto',
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		},
		yAxis : [ {
			type : 'value',
			name : '指数',
			interval : 3,
			splitLine : {
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		}, {
			type : 'value',
			name : '潜力指数',
			/*
			 * max: '125', min:'95',
			 */
			splitLine : {
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		} ],
		series : [ {
			name : '盈利能力',
			type : 'line',
			smooth : true,
			markArea : {
				data : [ [ {
					yAxis : 18,
					itemStyle : {
						normal : {
							color : 'rgba(183,234,209,0.7)'
						}
					}
				}, {
					yAxis : 21
				} ], [ {
					yAxis : 18,
					itemStyle : {
						normal : {
							color : 'rgba(175,214,254,0.7)'
						}
					}
				}, {
					yAxis : 15
				} ], [ {
					yAxis : 15,
					itemStyle : {
						normal : {
							color : 'rgba(183,226,234,0.7)'
						}
					}
				}, {
					yAxis : 12
				} ], [ {
					yAxis : 12,
					itemStyle : {
						normal : {
							color : 'rgba(244,228,199,0.7)'
						}
					}
				}, {
					yAxis : 9
				} ], [ {
					// name: 'E',
					yAxis : 9,
					itemStyle : {
						normal : {
							color : 'rgba(254,201,219,0.7)'
						}
					}
				}, {
					yAxis : 6
				} ], [ {
					// name: 'E',
					yAxis : 6,
					itemStyle : {
						normal : {
							color : 'rgba(254,235,219,0.7)'
						}
					}
				}, {
					yAxis : 3
				} ], [ {
					// name: 'E',
					yAxis : 3,
					itemStyle : {
						normal : {
							color : 'rgba(254,224,219,0.7)'
						}
					}
				}, {
					yAxis : 0
				} ] ]
			},
			data : [],
			itemStyle : {
				normal : {
					color : '#f7b851',
				}
			}
		}, {
			name : '偿债能力',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#58c8da',
				}
			}
		}, {
			name : '经营效率',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#d14a61'
				}
			}
		}, {
			name : '增长潜力',
			type : 'line',
			smooth : true,
			yAxisIndex : 1,
			data : [],

			itemStyle : {
				normal : {
					color : '#5793f3',
				}
			}

		}, {
			name : '综合风险',
			type : 'line',
			smooth : true,
			yAxisIndex : 1,
			data : [],

			itemStyle : {
				normal : {
					color : '#9B30FF',
				}
			}

		}

		]
	};

	pie3.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据
	var profit = []; // 盈利能力
	var debt = []; // 偿债能力
	var manager = []; // 经营效率
	var increase = []; // 增长潜力
	var years = []; // 横坐标：年份
	
	       $.ajax({
				"url" : "./marketData", // 路径
				"cache" : false, // 不缓存
				"data" : {
					type : parseInt(type)
				}, // 向后台传参,type表示三大行业之一
				"async" : true, // 默认true即异步（优先选择）
				"type" : "GET", // POST方式提交
				"dataType" : "json", // json格式，重要
				"contentType" : "application/json", // json格式
				success : function(data) { // 成功同步请求数据
					// 请求成功时执行该函数内容，result即为服务器返回的json对象
					console.log("test")
					console.log(data['year'])
					console.log(data['r1'])
					console.log(data['r2'])
					console.log(data['r3'])
					console.log(data['r4'])
					// $.each(data, function(index,item) {

					// //console.log(index+"========"+item)
					// profit.push(item['盈利能力']);
					// debt.push(item['偿债能力']);
					// manager.push(item['经营效率']);
					// increase.push(item['增长潜力']);
					// /* for(var i =0;i<test.length;i++){
					// years.push((test[0][i]));
					// }*/

					// // console.log(data[index])

					// });
					// console.log(years);
					// add tips 20180518
					var element = document.getElementById("msg_home_" + type);
					if (type == 0) {
						element.innerHTML = "1997-2016年，房地产企业财务分析如下："
								+ '<br>'
								+ "【偿债能力】整体呈不断下降趋势；"
								+ '<br>'
								+ "【盈利能力】自2004年开始有所提升，2011年开始呈小幅下降趋势；"
								+ '<br>'
								+ "【经营效率】整体呈稳步上升态势，"
								+ '<br>'
								+ "【增长潜力】呈周期性波动，在经过2005年爆发式增长后，2006年开始有所下降，2008年基本回归历史平均水平后又开始恢复周期性波动。"
					} else if(type == 1) {

						element.innerHTML = "2000-2016年，汽车制造业财务分析如下："
							+ '<br>'
							+ "【偿债能力】2000年呈最高位，从2001年起整体呈平缓趋势；"
							+ '<br>'
							+ "【盈利能力】自2000年开始均呈小幅变化，2016年呈 爆发式增长；"
							+ '<br>'
							+ "【经营效率】整体呈周期波动趋势;"
							+ '<br>'
							+ "【增长潜力】从2000年开始呈不断增长态势,2010年起呈平缓趋势。"
					} else {
						element.innerHTML = "2001-2016年，信心技术服务业财务分析如下："
							+ '<br>'
							+ "【偿债能力】整体呈周期性波动，从2013年呈小幅下降趋势；"
							+ '<br>'
							+ "【盈利能力】自2003年开始呈稳步上升台数，2006年趋于平缓，2013年开始呈下降趋势；"
							+ '<br>'
							+ "【经营效率】整体呈小幅变化;"
							+ '<br>'
							+ "【增长潜力】从2001年开始呈上升趋势，然后趋于平缓，2010年开始有所下降，2013年基本趋于平缓。"
					}
					pie3.hideLoading(); // 隐藏加载动画
					pie3.setOption({ // 加载数据图表
						/*
						 * dataZoom: [{ type: 'inside', start: 0, end: 60 }, {
						 * show: true, type: 'slider', y: '90%', start: 0, end:
						 * 50 }],
						 */
						xAxis : {
							data : data['year']
						},
						series : [ {
							data : data['r1']
						}, {
							data : data['r3']
						}, {
							data : data['r4']
						}, {
							data : data['r2']
						}, {
							data : data['r5']
						} ]
					});
				},
				error : function(errorMsg) {
					// 请求失败时执行该函数
					alert("图表请求数据失败!");
					pie3.hideLoading();
				}
			});

	pie3.setOption(option3);
};

// 增长潜力
var pie6;
function zengzhang(type) {
	if (pie6 != null && pie6 != "" && pie6 != undefined) {
		pie6.dispose();
	}
	pie6 = echarts.init(document.getElementById("pie6_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	option6 = {
		title : {
			text : '增长潜力',
			left : '50%',
			textAlign : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			}
		},
		toolbox : {
			show: true,
			right: '5%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					//title : "切换", // 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				// 'bar'（切换为柱状图）,
				// 'stack'（切换为堆叠模式）,
				// 'tiled'（切换为平铺模式）
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
					title : "数据视图",
					readOnly : false, // 是否不可编辑（只读）
					lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
					// '关闭', '刷新']
					backgroundColor : "#fff", // 数据视图浮层背景色。
					textareaColor : "#fff", // 数据视图浮层文本输入区背景色
					textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
					textColor : "#000", // 文本颜色。
					buttonColor : "#c23531", // 按钮颜色。
					buttonTextColor : "#fff", // 按钮文本颜色。
				}
			}
		},
		legend : {
			left : "20",
			// orient: 'ver',
			data : [ '增长潜力', '偏冷', '适度下限' ]
		},
		xAxis : {
			type : 'category',
			name : '年份',
			data : [],
			boundaryGap : true,
			splitLine : {
				show : true,
				interval : 'auto',
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		},
		yAxis : {
			type : 'value',
			name : '指数',
			splitLine : {
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		// ,
		// min:'-25',
		// max:'95'
		},
		series : [ {
			name : '增长潜力',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#f7b851'
				}
			}
		}, {
			name : '偏冷',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#58c8da',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			},
		}, {
			name : '适度下限',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#d14a61',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			},
		} ]
	};

	pie6.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据

	var increase = []; // 增长潜力
	var cold = []; // 偏冷线
	var limit = []; // 适度下限
	var years = []; // 横坐标：年份
	
			$.ajax({
				"url" : "./marketData", // 路径
				"cache" : false, // 不缓存
				"data" : {
					type : parseInt(type)
				}, // 向后台传参,type表示三大行业之一
				"async" : true, // 默认true即异步（优先选择）
				"type" : "GET", // POST方式提交
				"dataType" : "json", // json格式，重要
				"contentType" : "application/json", // json格式
				success : function(data) { // 成功同步请求数据
					// 请求成功时执行该函数内容，result即为服务器返回的json对象
					// $.each(data, function(index,item) {
					// increase.push(item['增长潜力']);
					// years.push(item['id']);
					// //console.log(item['id']);
					// });

					// add tips 20180518

					var element = document.getElementById("msg_zengzhang_"
							+ type);
					if (type == 0) {
						element.innerHTML = "近10年来，房地产企业【增长潜力】一直未向下突破适度下限值，2004年之前增长潜力呈现周期性波动，个别年份出现增长潜力为负值的情况，2004年起增长潜力激增，并在2006年达到峰值，之后又迅速回落至10附近。"
					} else if(type == 1){
						element.innerHTML = "近17年来，汽车制造业【增长潜力】从2000年开始不断呈上升趋势，2010年达到历史最高值。2010年之后波动趋于平缓。"
					}else{
						element.innerHTML = "近16年来，信息技术服务业【增长潜力】2001年在适度下限以下。2002年之前整体呈上升趋势，2010年达到历史最高值。2010年之后，增长潜力不断下降，趋于平缓。"
					}

					var compute = maths(data['r2']); // 指标计算
					pie6.hideLoading(); // 隐藏加载动画
					pie6.setOption({ // 加载数据图表
						/*
						 * dataZoom: [{ type: 'inside', start: 0, end: 60 }, {
						 * show: true, type: 'slider', y: '90%', start: 0, end:
						 * 50 }],
						 */
						xAxis : {
							data : data['year']
						},
						series : [ {
							data : data['r2']
						}, {
							data : compute[0]
						}, {
							data : compute[1]
						} ]
					});
				},
				error : function(errorMsg) {
					// 请求失败时执行该函数
					alert("图表请求数据失败!");
					pie6.hideLoading();
				}
			});

	pie6.setOption(option6);
};

// 偿债能力
var pie7;
function changzhai(type) {
	if (pie7 != null && pie7 != "" && pie7 != undefined) {
		pie7.dispose();
	}
	pie7 = echarts.init(document.getElementById("pie7_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	option7 = {
		title : {
			text : '偿债能力',
			left : '50%',
			textAlign : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			}
		},
		toolbox : {
			show: true,
			right: '5%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					//title : "切换", // 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				// 'bar'（切换为柱状图）,
				// 'stack'（切换为堆叠模式）,
				// 'tiled'（切换为平铺模式）
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
					title : "数据视图",
					readOnly : false, // 是否不可编辑（只读）
					lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
					// '关闭', '刷新']
					backgroundColor : "#fff", // 数据视图浮层背景色。
					textareaColor : "#fff", // 数据视图浮层文本输入区背景色
					textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
					textColor : "#000", // 文本颜色。
					buttonColor : "#c23531", // 按钮颜色。
					buttonTextColor : "#fff", // 按钮文本颜色。
				}
			}
		},
		legend : {
			left : "20",
			// orient: 'ver',
			data : [ '偿债能力', '偏冷', '适度下限' ]
		},
		xAxis : {
			type : 'category',
			name : '年份',
			data : [],
			boundaryGap : false,
			splitLine : {
				show : true,
				interval : 'auto',
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		},
		yAxis : {
			type : 'value',
			name : '指数',
			splitLine : {
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		// ,
		// max: '20',
		// min:'0'
		},
		series : [ {
			name : '偿债能力',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#f7b851'

				}
			}
		}, {
			name : '偏冷',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#58c8da',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			}
		}, {
			name : '适度下限',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#d14a61',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			}
		} ]
	};

	pie7.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据

	var debt = []; // 偿债能力
	var cold = []; // 偏冷线
	var limit = []; // 适度下限
	var years = []; // 横坐标：年份
	$.ajax({
		"url" : "./marketData", // 路径
		"cache" : false, // 不缓存
		"data" : {
			type : parseInt(type)
		}, // 向后台传参,type表示三大行业之一
		"async" : true, // 默认true即异步（优先选择）
		"type" : "GET", // POST方式提交
		"dataType" : "json", // json格式，重要
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			/*
			 * $.each(data, function(index,item) { debt.push(item['偿债能力']);
			 * years.push(item['id']); //console.log(item['id']); });
			 */

			// add tips 20180518
			var element = document.getElementById("msg_changzhai_" + type);
			if (type == 0) {
				element.innerHTML = "近10年来，房地产企业的【偿债能力】不断下降，2015年起开始向下突破适度下限值。"
			} else if(type == 1){
				element.innerHTML = "近17年来，汽车制造业【偿债能力】一直在适度下限值之上波动。2001年之前整体呈下降趋势，2001年达到历史最低值。2001年之后波动趋于平缓。"
			}else{
				element.innerHTML = "近16年来，信息技术服务业【偿债能力】2002年接近适度下限值临界值。2008年之前整体呈上升趋势，2008年达到历史最高值。2008年之后，偿债能力不断下降。"
			}
			var compute = maths(data['r3']); // 指标计算 偏冷热线数据计算

			pie7.hideLoading(); // 隐藏加载动画
			pie7.setOption({ // 加载数据图表
				/*
				 * dataZoom: [{ type: 'inside', start: 0, end: 60 }, { show:
				 * true, type: 'slider', y: '90%', start: 0, end: 50 }],
				 */
				xAxis : {
					data : data['year']
				},
				series : [ {
					data : data['r3']
				}, {
					data : compute[0]
				}, {
					data : compute[1]
				} ]
			});
		},
		error : function(errorMsg) {
			// 请求失败时执行该函数
			alert("图表请求数据失败!");
			pie7.hideLoading();
		}
	});

	pie7.setOption(option7);
};

/**
 * 盈利能力 0907 add CNN model
 */
var pie8;
function yingli(type) {
	if (pie8 != null && pie8 != "" && pie8 != undefined) {
		pie8.dispose();
	}
	pie8 = echarts.init(document.getElementById("pie8_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	option8 = {
		title : {
			text : '盈利能力',
			left : '50%',
			textAlign : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			},
		},
		toolbox : {
			show: true,
			right: '5%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					//title : "切换", // 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				// 'bar'（切换为柱状图）,
				// 'stack'（切换为堆叠模式）,
				// 'tiled'（切换为平铺模式）
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
					title : "数据视图",
					readOnly : false, // 是否不可编辑（只读）
					lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
					// '关闭', '刷新']
					backgroundColor : "#fff", // 数据视图浮层背景色。
					textareaColor : "#fff", // 数据视图浮层文本输入区背景色
					textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
					textColor : "#000", // 文本颜色。
					buttonColor : "#c23531", // 按钮颜色。
					buttonTextColor : "#fff", // 按钮文本颜色。
				}
			}
		},
		legend : {
			left : "20",
			// orient: 'ver',
			data : [ '盈利能力', '偏冷', '适度下限' ]
		},
		xAxis : {
			type : 'category',
			name : '年份',
			data : [],
			boundaryGap : false,
			splitLine : {
				show : true,
				interval : 'auto',
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		},
		yAxis : {
			type : 'value',
			name : '指数',
			splitLine : {
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		// ,
		// max: '17',
		// min:'9',

		},
		series : [ {
			name : '盈利能力',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#f7b851'
				}
			}
		}, {
			name : '偏冷',
			type : 'line',
			smooth : true,
			showSymbol : true,
			symbol : 'circle',
			symbolSize : 2,
			data : [],

			itemStyle : {
				normal : {
					color : '#58c8da',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			}
		}, {
			name : '适度下限',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#d14a61',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			}
		} ]
	};

	pie8.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据
	var profit = []; // 盈利能力
	var cold = []; // 偏冷线
	var limit = []; // 适度下限
	var years = []; // 横坐标：年份
	$
			.ajax({
				"url" : "./marketData", // 路径
				"cache" : false, // 不缓存
				"data" : {
					type : parseInt(type)
				}, // 向后台传参,type表示三大行业之一
				"async" : true, // 默认true即异步（优先选择）
				"type" : "GET", // POST方式提交
				"dataType" : "json", // json格式，重要
				"contentType" : "application/json", // json格式
				success : function(data) { // 成功同步请求数据
					// 请求成功时执行该函数内容，result即为服务器返回的json对象
					// $.each(data, function(index,item) {
					// profit.push(item['盈利能力']);
					// years.push(item['id']);
					// //console.log(item['id']);
					// });

					// add tips 20180518
					var element = document.getElementById("msg_yingli_" + type);
					if (type == 0) {
						element.innerHTML = "近10年来，房地产企业【盈利能力】一直在适度下限值之上波动。2004年之前整体呈下降趋势，2004年达到历史最低值。2004年之后，盈利能力不断攀升，2011年达到峰值后逐渐回落。"
					} else if(type == 1){
						element.innerHTML = "近17年来，汽车制造业【盈利能力】一直在适度下限值之上波动。2015年之前整体呈 平缓趋势，2015年后不断增长达到峰值。"
					}else{
						element.innerHTML = "近16年来，信息技术服务业【盈利能力】一直在适度下限值之上波动。2005年之前整体呈上升趋势，2005年达到历史最高值。2005年之后，盈利能力不断下降后趋于平缓。"
					}
					var compute = maths(data['r1']); // 指标计算
					pie8.hideLoading(); // 隐藏加载动画
					pie8.setOption({ // 加载数据图表
						/*
						 * dataZoom: [{ type: 'inside', start: 0, end: 60 }, {
						 * show: true, type: 'slider', y: '90%', start: 0, end:
						 * 50 }],
						 */
						xAxis : {
							data : data['year']
						},
						series : [ {
							data : data['r1']
						}, {
							data : compute[0]
						}, {
							data : compute[1]
						} ]
					});
				},
				error : function(errorMsg) {
					// 请求失败时执行该函数
					alert("图表请求数据失败!");
					pie8.hideLoading();
				}
			});

	pie8.setOption(option8);
};

// 经营效率
var pie9;
function jingying(type) {
	if (pie9 != null && pie9 != "" && pie9 != undefined) {
		pie9.dispose();
	}
	pie9 = echarts.init(document.getElementById("pie9_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	option9 = {
		title : {
			text : '经营效率',
			left : '50%',
			textAlign : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			}
		},
		toolbox : {
			show: true,
			right: '5%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					//title : "切换", // 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				// 'bar'（切换为柱状图）,
				// 'stack'（切换为堆叠模式）,
				// 'tiled'（切换为平铺模式）
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
					title : "数据视图",
					readOnly : false, // 是否不可编辑（只读）
					lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
					// '关闭', '刷新']
					backgroundColor : "#fff", // 数据视图浮层背景色。
					textareaColor : "#fff", // 数据视图浮层文本输入区背景色
					textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
					textColor : "#000", // 文本颜色。
					buttonColor : "#c23531", // 按钮颜色。
					buttonTextColor : "#fff", // 按钮文本颜色。
				}
			}
		},
		legend : {
			left : "20",
			// orient: 'ver',
			data : [ '经营效率', '偏冷', '适度下限' ]
		},
		xAxis : {
			type : 'category',
			name : '年份',
			data : [],
			boundaryGap : false,
			splitLine : {
				show : true,
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		},
		yAxis : {
			type : 'value',
			name : '指数',
			splitLine : {
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		// ,
		// max: '13',
		// min:'-5',

		},
		series : [ {
			name : '经营效率',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#f7b851'
				}
			}
		}, {
			name : '偏冷',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#58c8da',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					},

				}
			}
		}, {
			name : '适度下限',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#d14a61',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					},

				}
			}
		} ]
	};

	pie9.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据

	var manager = []; // 经营效率
	var cold = []; // 偏冷线
	var limit = []; // 适度下限
	var years = []; // 横坐标：年份
	
			$.ajax({
				"url" : "./marketData", // 路径
				"cache" : false, // 不缓存
				"data" : {
					type : parseInt(type)
				}, // 向后台传参,type表示三大行业之一
				"async" : true, // 默认true即异步（优先选择）
				"type" : "GET", // POST方式提交
				"dataType" : "json", // json格式，重要
				"contentType" : "application/json", // json格式
				success : function(data) { // 成功同步请求数据
					// 请求成功时执行该函数内容，result即为服务器返回的json对象
					// $.each(data, function(index,item) {
					// manager.push(item['经营效率']);
					// years.push(item['id']);
					// //console.log(item['id']);
					// });

					// add tips 20180518
					var element = document.getElementById("msg_jingying_"
							+ type);
					if (type == 0) {
						element.innerHTML = "近10年来，房地产企业的【经营效率】不断提升，且一直位于适度下限值之上，2005年以来增长较快。"
					} else if(type==1){
						element.innerHTML = "近17年来，汽车制造业的【经营效率】呈现周期性变化，且一直位于适度下限值之上，2009年以来增长较快,2011年后趋于平缓。"
					}else{
						element.innerHTML = "近16年来，信息技术服务业的【经营效率】 趋于平缓，但一直位于适度下限值之上，2011年以来出现了一次小高峰。"
					}

					var compute = maths(data['r4']); // 指标计算
					pie9.hideLoading(); // 隐藏加载动画
					pie9.setOption({ // 加载数据图表
						/*
						 * dataZoom: [{ type: 'inside', start: 0, end: 60 }, {
						 * show: true, type: 'slider', y: '90%', start: 0, end:
						 * 50 }],
						 */
						xAxis : {
							data : data['year']
						},
						series : [ {
							data : data['r4']
						}, {
							data : compute[0]
						}, {
							data : compute[1]
						} ]
					});
				},
				error : function(errorMsg) {
					// 请求失败时执行该函数
					alert("图表请求数据失败!");
					pie9.hideLoading();
				}
			});

	pie9.setOption(option9);
};

// 按区域投资潜力
(function() {
	var s1 = document.getElementById("s1");
	var zone = []; // 地区数组
	var len = 0;
	$.ajax({
		"type" : 'GET',
		"url" : './getZone',
		"dataType" : 'json',
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象

			$.each(data, function(index, item) {
				s1.add(new Option(item["地区"], index)); // 一级
			});
		}
	});
})();

// 按发展程度

(function() {
	var s4 = document.getElementById("s4");
	var zone = []; // 地区数组
	var len = 0;
	$.ajax({
		"type" : 'GET',
		"url" : './getDevLevel',
		"dataType" : 'json',
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			console.log(data);
			$.each(data, function(index, item) {
				s4.add(new Option(item["发展程度"], index)); // 一级
			});
		}
	});
})();
// 二级状态改变事件
$("#s4").change(function() {

	var val = document.getElementById("s4");
	var index = val.selectedIndex;
	var txt = val.options[index].text;
	var s5 = document.getElementById("s5"); // 二级省份
	s5.options.length = 1; // 只保留首项option

	// 获取二级省份
	$.ajax({
		"type" : 'GET',
		"url" : './getCitys',
		"data" : {
			level : txt
		}, // 向后台传参
		"dataType" : 'json',
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			$.each(data, function(index, item) {
				s5.add(new Option(item["城市"], index)); // 二级
			});
		}
	})
});

// 二级状态改变事件
$("#s1").change(function() {

	var val = document.getElementById("s1");
	var index = val.selectedIndex;
	var txt = val.options[index].text;
	var s2 = document.getElementById("s2"); // 二级省份
	s2.options.length = 1; // 只保留首项option

	// 获取二级省份
	$.ajax({
		"type" : 'GET',
		"url" : './getProvince',
		"data" : {
			zone : txt
		}, // 向后台传参
		"dataType" : 'json',
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			$.each(data, function(index, item) {
				s2.add(new Option(item["省份"], index)); // 二级
			});

		}
	})
});

// 三级状态改变事件
$("#s2").change(function() {

	var val = document.getElementById("s2");
	var index = val.selectedIndex;
	var txt = val.options[index].text;
	var s3 = document.getElementById("s3"); // 三级级市区
	s3.options.length = 1; // 只保留首项option
	// 获取二级省份
	$.ajax({
		"type" : 'GET',
		"url" : './getCity',
		"data" : {
			province : txt
		}, // 向后台传参
		"dataType" : 'json',
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			$.each(data, function(index, item) {
				s3.add(new Option(item["城市"], index)); // 二级
			});
		}
	});
});

$(document).ready(
		function() {
			$("#s3").change(
					function() {
						var main = echarts
								.init(document.getElementById("main"));
						var val = document.getElementById("s3");
						var index = val.selectedIndex;
						var txt = val.options[index].text;
						// 获取因子数据
						var potential = [];
						var years = [];
						var economy = [];
						var population = [];
						var local = [];
						var supply = [];
						option = {
							title : {
								text : txt + ' 市（区）投资潜力指数',
								left : '50%',
								top : '18',
								textAlign : 'center'
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : {
									lineStyle : {
										color : '#000'
									}
								}
							},
							toolbox : {
								show: true,
								right: '5%',
								feature : {
									restore : {
										show : true, // 是否显示该工具。
										title : "还原",
									},
									saveAsImage : {
										show : true, // 是否显示该工具。
										title : "保存为图片",
										pixelRatio : 1
									},
									magicType : { // 动态类型切换
										show : true,
//										title : "切换", // 各个类型的标题文本，可以分别配置。
										type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
									// 'bar'（切换为柱状图）,
									// 'stack'（切换为堆叠模式）,
									// 'tiled'（切换为平铺模式）
									},
									dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
										show : true, // 是否显示该工具。
										title : "数据视图",
										readOnly : false, // 是否不可编辑（只读）
										lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
										// '关闭',
										// '刷新']
										backgroundColor : "#fff", // 数据视图浮层背景色。
										textareaColor : "#fff", // 数据视图浮层文本输入区背景色
										textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
										textColor : "#000", // 文本颜色。
										buttonColor : "#c23531", // 按钮颜色。
										buttonTextColor : "#fff", // 按钮文本颜色。
									}
								}
							},
							legend : {
								left : "20",
								top : "0",
								// orient: 'ver',
								data : [ '投资潜力因子', '经济因子', '人口因子', '区位因子',
										'市场供需因子' ]
							},
							xAxis : {
								type : 'category',
								name : '时间',
								data : [],
								boundaryGap : false,
								splitLine : {
									show : true,
									// interval: 'auto',
									lineStyle : {
										color : [ '#D4DFF5' ]
									}
								},
								nameTextStyle:{						          
						            fontSize:12,  
						            padding:10
						        }
							},
							yAxis : [ {
								type : 'value',
								name : '投资潜力因子、区位因子',
								max : '105.5',
								min : '100',
								splitLine : {
									lineStyle : {
										color : [ '#D4DFF5' ]
									}
								}
							}, {
								type : 'value',
								name : '市场供需因子、经济因子、人口因子',
								max : '101.5',
								min : '99',
								splitLine : {
									lineStyle : {
										color : [ '#D4DFF5' ]
									}
								}
							} ],
							series : [ {
								name : '投资潜力因子',
								type : 'line',
								smooth : true,
								data : [],

								itemStyle : {
									normal : {
										color : '#f7b851'
									}
								},
								lineStyle : {
									normal : {
										width : 3,
										type : 'dotted' // 'dotted'虚线 'solid'实线
									}
								}
							}, {
								name : '区位因子',
								type : 'line',
								smooth : true,
								data : [],

								itemStyle : {
									normal : {
										color : '#58c8da',
										lineStyle : {
											width : 2,

										}
									}
								},
							}, {
								name : '人口因子',
								type : 'line',
								smooth : true, // 实现变虚线设置为false，默认为true
								yAxisIndex : 1, // 指代第二条y轴
								data : [],
								/*
								 * markLine: { data: [{ type: 'average', name:
								 * '平均值' }] },
								 */
								itemStyle : {
									normal : {
										color : '#8B1A1A',
										lineStyle : {
											width : 2,
										// type:'dotted' //'dotted'虚线 'solid'实线
										}
									}
								},

							}, {
								name : '市场供需因子',
								type : 'line',
								smooth : true, // 实现变虚线设置为false，默认为true
								yAxisIndex : 1, // 指代第二条y轴
								data : [],
								/*
								 * markLine: { data: [{ type: 'average', name:
								 * '平均值' }] },
								 */
								itemStyle : {
									normal : {
										color : '#BF3EFF',
										lineStyle : {
											width : 2,
										// type:'dotted' //'dotted'虚线 'solid'实线
										}
									}
								},

							}, {
								name : '经济因子',
								type : 'line',
								smooth : true, // 实现变虚线设置为false，默认为true
								yAxisIndex : 1, // 指代第二条y轴
								data : [],
								/*
								 * markLine: { data: [{ type: 'average', name:
								 * '平均值' }] },
								 */
								itemStyle : {
									normal : {
										color : '#5793f3',
										lineStyle : {
											width : 2,
										// type:'dotted' //'dotted'虚线 'solid'实线
										}
									}
								},

							}

							]
						};
						var map = {}
						main.showLoading(); // 数据加载完之前先显示一段简单的loading动画
						$.ajax({
							"type" : 'GET',
							"url" : './getFactorData',
							"data" : {
								city : txt
							}, // 向后台传参
							"dataType" : 'json',
							"contentType" : "application/json", // json格式
							success : function(data) { // 成功同步请求数据
								// 请求成功时执行该函数内容，result即为服务器返回的json对象
								// console.log(data);
								$.each(data, function(index, item) {
									potential.push(item['投资潜力因子']);
									years.push(item['年份']);
									economy.push(item['经济因子']);
									population.push(item['人口因子']);
									local.push(item['区位因子']);
									supply.push(item['市场供需因子']);
									map[item['投资潜力因子']] = item['年份']
								});
								var element = document
										.getElementById("msg_potential");
								// 增加投资潜力提示信息
								console.log(potential)
								var pmax = potential.max()
								var pmin = potential.min()
								var index_a = potential[0]

								var index_b = potential[potential.length - 1]
								console.log(index_a + "==" + index_b)
								if (index_a < index_b) {
									element.innerHTML = "该段时间内，[" + txt
											+ "市(区)]投资潜力整体呈上升趋势，在 " + map[pmax]
											+ "年投资潜力达到最大值，在" + map[pmin]
											+ "年投资潜力最小。"
								} else {
									element.innerHTML = "该段时间内，[" + txt
											+ "市(区)]投资潜力整体呈下降趋势，在 " + map[pmax]
											+ "年投资潜力达到最大值，在" + map[pmin]
											+ "年投资潜力最小。"
								}
								main.hideLoading(); // 隐藏加载动画
								main.setOption({ // 加载数据图表
									xAxis : {
										data : years
									},
									series : [ {
										data : potential
									}, {
										data : economy
									}, {
										data : population
									}, {
										data : local
									}, {
										data : supply
									} ]
								});
							},
							error : function(errorMsg) {
								// 请求失败时执行该函数
								alert("图表请求数据失败!");
								main.hideLoading();
							},
						})
						main.setOption(option);
					});

			$("#s5").change(
					function() {
						var main = echarts.init(document
								.getElementById("mains"));
						var val = document.getElementById("s5");
						var index = val.selectedIndex;
						var txt = val.options[index].text;
						// 获取因子数据
						var potential = [];
						var years = [];
						var economy = [];
						var population = [];
						var local = [];
						var supply = [];
						option = {
							title : {
								text : txt + ' 市（区）投资潜力指数',
								left : '50%',
								top : '18',
								textAlign : 'center'
							},
							tooltip : {
								trigger : 'axis',
								axisPointer : {
									lineStyle : {
										color : '#000'
									}
								}
							},
							toolbox : {
								show: true,
								right: '5%',
								feature : {
									restore : {
										show : true, // 是否显示该工具。
										title : "还原",
									},
									saveAsImage : {
										show : true, // 是否显示该工具。
										title : "保存为图片",
										pixelRatio : 1
									},
									magicType : { // 动态类型切换
										show : true,
										//title : "切换", // 各个类型的标题文本，可以分别配置。
										type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
									// 'bar'（切换为柱状图）,
									// 'stack'（切换为堆叠模式）,
									// 'tiled'（切换为平铺模式）
									},
									dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
										show : true, // 是否显示该工具。
										title : "数据视图",
										readOnly : false, // 是否不可编辑（只读）
										lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
										// '关闭',
										// '刷新']
										backgroundColor : "#fff", // 数据视图浮层背景色。
										textareaColor : "#fff", // 数据视图浮层文本输入区背景色
										textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
										textColor : "#000", // 文本颜色。
										buttonColor : "#c23531", // 按钮颜色。
										buttonTextColor : "#fff", // 按钮文本颜色。
									}
								}
							},
							legend : {
								left : "20",
								top : "0",
								// orient: 'ver',
								data : [ '投资潜力因子', '经济因子', '人口因子', '区位因子',
										'市场供需因子' ]
							},
							xAxis : {
								type : 'category',
								name : '时间',
								data : [],
								boundaryGap : false,
								splitLine : {
									show : true,
									// interval: 'auto',
									lineStyle : {
										color : [ '#D4DFF5' ]
									}
								},
								nameTextStyle:{						          
						            fontSize:12,  
						            padding:10
						        }
							
							},
							yAxis : [ {
								type : 'value',
								name : '投资潜力因子、区位因子',
								max : '105.5',
								min : '100',
								splitLine : {
									lineStyle : {
										color : [ '#D4DFF5' ]
									}
								}
							}, {
								type : 'value',
								name : '市场供需因子、经济因子、人口因子',
								max : '101.5',
								min : '99',
								splitLine : {
									lineStyle : {
										color : [ '#D4DFF5' ]
									}
								}
							} ],
							series : [ {
								name : '投资潜力因子',
								type : 'line',
								smooth : true,
								data : [],

								itemStyle : {
									normal : {
										color : '#f7b851'
									}
								},
								lineStyle : {
									normal : {
										width : 3,
										type : 'dotted' // 'dotted'虚线 'solid'实线
									}
								}
							}, {
								name : '区位因子',
								type : 'line',
								smooth : true,
								data : [],

								itemStyle : {
									normal : {
										color : '#58c8da',
										lineStyle : {
											width : 2,

										}
									}
								},
							}, {
								name : '人口因子',
								type : 'line',
								smooth : true, // 实现变虚线设置为false，默认为true
								yAxisIndex : 1, // 指代第二条y轴
								data : [],
								/*
								 * markLine: { data: [{ type: 'average', name:
								 * '平均值' }] },
								 */
								itemStyle : {
									normal : {
										color : '#8B1A1A',
										lineStyle : {
											width : 2,
										// type:'dotted' //'dotted'虚线 'solid'实线
										}
									}
								},

							}, {
								name : '市场供需因子',
								type : 'line',
								smooth : true, // 实现变虚线设置为false，默认为true
								yAxisIndex : 1, // 指代第二条y轴
								data : [],
								/*
								 * markLine: { data: [{ type: 'average', name:
								 * '平均值' }] },
								 */
								itemStyle : {
									normal : {
										color : '#BF3EFF',
										lineStyle : {
											width : 2,
										// type:'dotted' //'dotted'虚线 'solid'实线
										}
									}
								},

							}, {
								name : '经济因子',
								type : 'line',
								smooth : true, // 实现变虚线设置为false，默认为true
								yAxisIndex : 1, // 指代第二条y轴
								data : [],
								/*
								 * markLine: { data: [{ type: 'average', name:
								 * '平均值' }] },
								 */
								itemStyle : {
									normal : {
										color : '#5793f3',
										lineStyle : {
											width : 2,
										// type:'dotted' //'dotted'虚线 'solid'实线
										}
									}
								},

							}

							]
						};
						var map = {}
						main.showLoading(); // 数据加载完之前先显示一段简单的loading动画
						$.ajax({
							"type" : 'GET',
							"url" : './getFactorData',
							"data" : {
								city : txt
							}, // 向后台传参
							"dataType" : 'json',
							"contentType" : "application/json", // json格式
							success : function(data) { // 成功同步请求数据
								// 请求成功时执行该函数内容，result即为服务器返回的json对象
								console.log(data);
								$.each(data, function(index, item) {
									potential.push(item['投资潜力因子']);
									years.push(item['年份']);
									economy.push(item['经济因子']);
									population.push(item['人口因子']);
									local.push(item['区位因子']);
									supply.push(item['市场供需因子']);
									map[item['投资潜力因子']] = item['年份']
								});
								var element = document
										.getElementById("msg_potential2");
								// 增加投资潜力提示信息
								console.log(potential)
								var pmax = potential.max()
								var pmin = potential.min()
								var index_a = potential[0]
								var index_b = potential[potential.length - 1]
								console.log(index_a + "==" + index_b)
								if (index_a < index_b) {
									element.innerHTML = "该段时间内，[" + txt
											+ "市(区)]投资潜力整体呈上升趋势，在 " + map[pmax]
											+ "年投资潜力达到最大值，在" + map[pmin]
											+ "年投资潜力最小。"
								} else {
									element.innerHTML = "该段时间内，[" + txt
											+ "市(区)]投资潜力整体呈下降趋势，在 " + map[pmax]
											+ "年投资潜力达到最大值，在" + map[pmin]
											+ "年投资潜力最小。"
								}

								main.hideLoading(); // 隐藏加载动画
								main.setOption({ // 加载数据图表
									xAxis : {
										data : years
									},
									series : [ {
										data : potential
									}, {
										data : economy
									}, {
										data : population
									}, {
										data : local
									}, {
										data : supply
									} ]
								});
							},
							error : function(errorMsg) {
								// 请求失败时执行该函数
								alert("图表请求数据失败!");
								main.hideLoading();
							}
						})
						main.setOption(option);
					});
		});

var pie4; // 二次加载重新创建实例
// 合成指数异步加载
function hecheng(type) {
	if (pie4 != null && pie4 != "" && pie4 != undefined) {
		pie4.dispose();
	}
	pie4 = echarts.init(document.getElementById("pie4_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	if (type == '0') {
		var industry = "[房地产]"
		var ytitle = "HPY"
	} else if (type == '1') {
		var industry = "[汽车制造业]"
		var ytitle = "价格变化率"
	} else {
		var industry = "[信息服务业]"
		var ytitle = "SPY"
	}
	option = {
		title : {
			text : '市场景气-合成指数',
			left : '50%',
			textAlign : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			},
		},
		toolbox : {
			show: true,
			right: '15%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					//title : "切换", // 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				// 'bar'（切换为柱状图）,
				// 'stack'（切换为堆叠模式）,
				// 'tiled'（切换为平铺模式）
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
					title : "数据视图",
					readOnly : false, // 是否不可编辑（只读）
					lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
					// '关闭', '刷新']
					backgroundColor : "#fff", // 数据视图浮层背景色。
					textareaColor : "#fff", // 数据视图浮层文本输入区背景色
					textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
					textColor : "#000", // 文本颜色。
					buttonColor : "#c23531", // 按钮颜色。
					buttonTextColor : "#fff", // 按钮文本颜色。
				}
			}
		},
		legend : {
			left : "20",
			// orient: 'ver',
			data : [ '领先指数', '同步指数', '滞后指数', ytitle ]
		},
		xAxis : {
			type : 'category',
			name : '时间',
			data : [],
			boundaryGap : true,
			splitLine : {
				show : true,
				lineStyle : {
					color : '#fcc',
					width : 1
				}
			},
			
			nameTextStyle:{						          
	            fontSize:12,  
	            padding:10
	        },
			axisLine : {},
		},
		yAxis : [ {
			type : 'value',
			name : '合成指数',
			max : '132',
			min : '90',
			interval : 5,
			splitLine : {
				show : true,
				lineStyle : {
					color : '#fcc',
					width : 2
				}
			}
		}, {
			type : 'value',
			name : ytitle,
			max : '127',
			min : '95',
			interval : 5,
			splitLine : {
				lineStyle : {
					color : '#fcc',
					width : 2
				}
			}
		} ],
		series : [ {
			name : '领先指数',
			type : 'line',
			smooth : true,
			markArea : {
				data : [ [ {
					yAxis : 115,
					itemStyle : {
						normal : {
							color : 'rgba(183,234,209,0.7)'
						}
					}
				}, {
					yAxis : 132
				} ], [ {
					yAxis : 115,
					itemStyle : {
						normal : {
							color : 'rgba(175,214,254,0.7)'
						}
					}
				}, {
					yAxis : 105
				} ], [ {
					yAxis : 105,
					itemStyle : {
						normal : {
							color : 'rgba(254,231,219,0.7)'
						}
					}
				}, {
					yAxis : 90
				} ] ]
			},
			data : [],
			itemStyle : {
				normal : {
					color : '#f7b851'
				}
			}
		}, {
			name : '同步指数',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#58c8da'
				}
			}
		}, {
			name : '滞后指数',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#d14a61'
				}
			}
		}, {
			name : 'HPY',
			type : 'line',
			smooth : true,
			yAxisIndex : 1, // 指代第二条y轴
			data : [],
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			},
			itemStyle : {
				normal : {
					color : '#5793f3',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			},

		}

		]
	};

	pie4.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据
	var lead_index = []; // 领先指数
	var coincident_index = []; // 同步指数
	var lag_index = []; // 滞后指数
	var hpy = []; // HPY
	var years = []; // 横坐标：年份
	$.ajax({
		"url" : "./getCI", // 路径
		"cache" : false, // 不缓存
		"data" : {
			type : parseInt(type)
		},
		"async" : true, // 默认true即异步（优先选择）
		"type" : "GET", // POST方式提交
		"dataType" : "json", // json格式，重要
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			$.each(data, function(index, item) {
				lead_index.push(item['领先指数_Y']);
				coincident_index.push(item['同步指数_Y']);
				lag_index.push(item['滞后指数_Y']);
				hpy.push(item['HPY']);
				years.push(item['year']);
				// console.log(item['id']);
			});
			pie4.hideLoading(); // 隐藏加载动画
			pie4.setOption({ // 加载数据图表
				dataZoom : [ {
					type : 'inside',
					start : 0,
					end : 60
				}, {
					show : true,
					type : 'slider',
					y : '90%',
					start : 0,
					end : 50

				} ],
				xAxis : {
					data : years
				},
				series : [ {
					data : lead_index
				}, {
					data : coincident_index
				}, {
					data : lag_index
				}, {
					data : hpy
				} ]
			});
		},
		error : function(errorMsg) {
			// 请求失败时执行该函数
			alert("图表请求数据失败!");
			pie4.hideLoading();
		}
	});

	pie4.setOption(option);

	// 动态信息展示
	var map1 = {};
	var map2 = {};
	var tstart = ""
	var tend = ""

	pie4.on("dataZoom", function(params) {
		var element = document.getElementById("msg_hecheng_" + type);
		var opt = pie4.getOption()
		console.log(params)
		var dz = opt.dataZoom[0];
		var year = opt.xAxis[0].data;
		var hpy = opt.series[3].data;
		var lead = opt.series[0].data;
		for (var i = 0; i < year.length; i++) {
			map1[year[i]] = hpy[i]
			map2[year[i]] = lead[i]
		}
		tstart = opt.xAxis[0].data[dz.startValue];
		tstart1 = opt.xAxis[0].data[dz.startValue + 1];
		console.log(tstart1)
		tend = opt.xAxis[0].data[dz.endValue];
		var date = "『动态分析预测』" + tstart + "至" + tend

		if (map1[tstart] < map1[tend]) {
			if (map2[tstart1] < map2[tend])
				element.innerHTML = date + "期间，" + industry
						+ "行业整体处于上升趋势, 预期未来3-6个月整体呈上行趋势。"
			else
				element.innerHTML = date + "期间，" + industry
						+ "行业整体处于下降趋势, 预期未来3-6个月整体呈下行趋势。"
		} else {

			if (map2[tstart1] < map2[tend])
				element.innerHTML = date + "期间，" + industry
						+ "行业整体处于下降趋势，预期未来3-6个月整体呈上行趋势。"
			else
				element.innerHTML = date + "期间，" + industry
						+ "行业整体处于下降趋势，预期未来3-6个月整体呈下行趋势。"
		}
	});
};

var pie5;
// 扩散指数
function kuosan(type) {
	if (pie5 != null && pie5 != "" && pie5 != undefined) {
		pie5.dispose();
	}
	pie5 = echarts.init(document.getElementById("pie5_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	if (type == '0') {
		var industry = "[房地产]"
	} else if (type == '1') {
		var industry = "[汽车制造业]"
	} else {

		var industry = "[信息服务业]"
	}
	option = {
		title : {
			text : '市场景气-扩散指数',
			left : '50%',
			textAlign : 'center',
			subtext : industry
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			},
		},
		toolbox : {
			show: true,
			right: '10%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					//title : "切换", // 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				// 'bar'（切换为柱状图）,
				// 'stack'（切换为堆叠模式）,
				// 'tiled'（切换为平铺模式）
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
					title : "数据视图",
					readOnly : false, // 是否不可编辑（只读）
					lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
					// '关闭', '刷新']
					backgroundColor : "#fff", // 数据视图浮层背景色。
					textareaColor : "#fff", // 数据视图浮层文本输入区背景色
					textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
					textColor : "#000", // 文本颜色。
					buttonColor : "#c23531", // 按钮颜色。
					buttonTextColor : "#fff", // 按钮文本颜色。
				}
			}
		},
		legend : {
			left : "20",
			// orient: 'ver',
			data : [ '领先指数', '同步指数', '滞后指数' ]
		},
		xAxis : {
			type : 'category',
			name : '时间',
			data : [],
			boundaryGap : true,
			splitLine : {
				show : true,
				width : 1

			},
			axisLine : {
				onZero : true
			},
		},
		yAxis : {
			type : 'value',
			name : '扩散指数',
			max : '100',
			min : '-10',
			splitLine : {
				show : true,
				lineStyle : {
					color : '#fcc',
					width : 2
				}
			},
		},
		series : [ {
			name : '领先指数',
			type : 'line',
			smooth : true,
			itemStyle : {
				normal : {
					color : '#2dbeff'
				}
			},
			markArea : {
				data : [ [ {
					yAxis : 80,
					itemStyle : {
						normal : {
							color : 'rgba(183,234,209,0.7)'
						}
					}
				}, {
					yAxis : 100
				} ], [ {
					yAxis : 80,
					itemStyle : {
						normal : {
							color : 'rgba(175,214,254,0.7)'
						}
					}
				}, {
					yAxis : 60
				} ], [ {
					yAxis : 60,
					itemStyle : {
						normal : {
							color : 'rgba(183,226,234,0.7)'
						}
					}
				}, {
					yAxis : 40
				} ], [ {
					yAxis : 40,
					itemStyle : {
						normal : {
							color : 'rgba(244,228,199,0.7)'
						}
					}
				}, {
					yAxis : 20
				} ], [ {
					// name: 'E',
					yAxis : 20,
					itemStyle : {
						normal : {
							color : 'rgba(254,231,219,0.7)'
						}
					}
				}, {
					yAxis : 0
				} ], [ {
					// name: 'E',
					yAxis : 0,
					itemStyle : {
						normal : {
							color : 'rgba(254,131,219,0.7)'
						}
					}
				}, {
					yAxis : -10
				} ] ]
			},
			data : [],
		}, {
			name : '同步指数',
			type : 'line',
			smooth : true,
			itemStyle : {
				normal : {
					color : '#ff62a3'
				}
			},
			data : [],
		}, {
			name : '滞后指数',
			type : 'line',
			smooth : true,
			itemStyle : {
				normal : {
					color : '#23ca55'
				}
			},
			data : [],
		} ]
	};
	pie5.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据
	var lead_index = []; // 领先指数
	var coincident_index = []; // 同步指数
	var lag_index = []; // 滞后指数
	var years = []; // 横坐标：年份
	$.ajax({
		"url" : "./getDiffIndex", // 路径
		"cache" : false, // 不缓存
		"data" : {
			type : parseInt(type)
		}, // 向后台传参,type表示三大行业之一
		"async" : true, // 默认true即异步（优先选择）
		"type" : "GET", // POST方式提交
		"dataType" : "json", // json格式，重要
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			console.log("test" + data);
			$.each(data, function(index, item) {
				lead_index.push(item['领先指数']);
				coincident_index.push(item['同步指数']);
				lag_index.push(item['滞后指数']);
				years.push(item['year']);

			});
			console.log(lead_index);
			pie5.hideLoading(); // 隐藏加载动画
			pie5.setOption({ // 加载数据图表
				dataZoom : {
					show : true,
					realtime : true,
					start : 0,
					end : 60,
				},
				xAxis : {
					data : years
				},
				series : [ {
					data : lead_index
				}, {
					data : coincident_index
				}, {
					data : lag_index
				} ]
			});
		},
		error : function(errorMsg) {
			// 请求失败时执行该函数
			alert("图表请求数据失败!");
			pie5.hideLoading();
		}
	});
	pie5.setOption(option);
	// add analysis msg 0516

	var map2 = {};
	var tstart = ""
	var tend = ""

	var test = []
	pie5.on("dataZoom", function(params) {
		var test = []
		var element = document.getElementById("msg");
		var opt = pie5.getOption()
		var dz = opt.dataZoom[0];
		var year = opt.xAxis[0].data;
		var lead = opt.series[0].data;
		for (var i = 0; i < year.length; i++) {
			map2[year[i]] = lead[i]
		}
		var start = dz.startValue // 起点
		var end = dz.endValue // 终点
		// console.log(dz.startValue+"==>"+dz.endValue)
		tstart = opt.xAxis[0].data[start]; // 起点
		tend = opt.xAxis[0].data[end]; // 终点
		for (var i = start; i <= end; i++) {
			test[i] = lead[i];
		}
		// console.log(map1)
		var maxima = [];
		var minima = []
		// console.log(test)
		// 获取极大、极小值及对应年份
		var direction = test[0] > 0 ? -1 : 1;
		for (var i = 0; i < test.length - 1; i++) {
			if ((test[i + 1] - test[i]) * direction > 0) {
				direction *= -1;
				if (direction == 1) {
					maxima.push(opt.xAxis[0].data[i])
					// console.log("("+opt.xAxis[0].data[i]+","+test[i]+")"+"极大值");
				} else {
					minima.push(opt.xAxis[0].data[i])
					// console.log("("+opt.xAxis[0].data[i]+","+test[i]+")"+"极小值");
				}
			}
		}
		// var industry = "[房地产]"
		var date = tstart + "至" + tend
		// console.log(maxima+"=="+minima)"『动态分析预测』"+
		var element = document.getElementById("msg_kuosan_" + type);
		if (maxima.length != 0 && minima.length != 0) {
			element.innerHTML = date + "时间段内，" + "领先指数在时间点：" + maxima
					+ "为极大值点，表明此后3-6个月，" + industry + "市场景气可能会达到峰值并出现反转。"
					+ '<br>'
			element.append(date + "时间段内，" + "领先指数在时间点：" + minima
					+ "为极小值点，表明此后3-6个月，" + industry + "市场景气可能会进入低谷期并出现反转。")
		} else {
			// 无极值时判断走势
			if (lead[start] < lead[end])
				element.innerHTML = date + "时间段内表明未来3-6个月内，房地产市场整体将可能呈现上升趋势"
			else
				element.innerHTML = date + "时间段内表明未来3-6个月内，房地产市场整体将可能呈现下降趋势"
		}
	});

};

var Risk;
// 房地产风险预警
function yujing(type) {
	Risk = echarts.init(document.getElementById("Risk_" + type));
	/*
	 * pie3.showLoading({ text: "图表数据正在努力加载..." });
	 */
	if (type == '0') {
		var industry = "[房地产]"
	} else if (type == '1') {
		var industry = "[汽车制造业]"
	} else {
		var industry = "[信息服务业]"
	}
	option = {
		title : {
			text : industry + '市场风险预警',
			left : '50%',
			textAlign : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				lineStyle : {
					color : '#000'
				}
			}
		},
		toolbox : {
			show: true,
			right: '5%',
			feature : {
				restore : {
					show : true, // 是否显示该工具。
					title : "还原",
				},
				saveAsImage : {
					show : true, // 是否显示该工具。
					title : "保存为图片",
					pixelRatio : 1
				},
				magicType : { // 动态类型切换
					show : true,
					//title : "切换", // 各个类型的标题文本，可以分别配置。
					type : [ 'line', 'bar' ], // 启用的动态类型，包括'line'（切换为折线图）,
				// 'bar'（切换为柱状图）,
				// 'stack'（切换为堆叠模式）,
				// 'tiled'（切换为平铺模式）
				},
				dataView : { // 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
					show : true, // 是否显示该工具。
					title : "数据视图",
					readOnly : false, // 是否不可编辑（只读）
					lang : [ '数据视图', '关闭', '刷新' ], // 数据视图上有三个话术，默认是['数据视图',
					// '关闭', '刷新']
					backgroundColor : "#fff", // 数据视图浮层背景色。
					textareaColor : "#fff", // 数据视图浮层文本输入区背景色
					textareaBorderColor : "#333", // 数据视图浮层文本输入区边框颜色
					textColor : "#000", // 文本颜色。
					buttonColor : "#c23531", // 按钮颜色。
					buttonTextColor : "#fff", // 按钮文本颜色。
				}
			}
		},
		legend : {
			left : "20",
			// orient: 'ver',
			data : [ '领先指数', '偏热线', '偏冷线', '适度上限', '适度下限' ]
		},
		xAxis : {
			type : 'category',
			name : '时间',
			data : [],
			boundaryGap : false,
			splitLine : {
				show : true,
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		},
		yAxis : {
			type : 'value',
			name : '指数',
			max : '109',
			min : '90',
			splitLine : {
				lineStyle : {
					color : [ '#D4DFF5' ]
				}
			}
		},
		series : [ {
			name : '领先指数',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#f7b851'
				}
			}
		}, {
			name : '偏热线',
			type : 'line',
			smooth : true,
			data : [],
			itemStyle : {
				normal : {
					color : '#58c8da',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			},
		}, {
			name : '偏冷线',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#000093',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			},
		}, {
			name : '适度上限',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#d14a61',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			},
		}, {
			name : '适度下限',
			type : 'line',
			smooth : true,
			data : [],

			itemStyle : {
				normal : {
					color : '#5793f3',
					lineStyle : {
						width : 3,
						type : 'dotted' // 'dotted'虚线 'solid'实线
					}
				}
			},
		} ]
	};

	Risk.showLoading(); // 数据加载完之前先显示一段简单的loading动画

	// ajax异步请求数据
	var lead_index = []; // 领先指数
	var hot_line = []; // 偏热线
	var cold_line = []; // 偏冷线
	var upper = []; // 适度上限
	var limit = []; // 适度下限
	var years = []; // 横坐标：年份
	$.ajax({
		"url" : "./getRiskPreAlarming", // 路径
		"cache" : false, // 不缓存
		"data" : {
			type : parseInt(type)
		}, // 向后台传参,type表示三大行业之一
		"async" : true, // 默认true即异步（优先选择）
		"type" : "GET", // POST方式提交
		"dataType" : "json", // json格式，重要
		"contentType" : "application/json", // json格式
		success : function(data) { // 成功同步请求数据
			// 请求成功时执行该函数内容，result即为服务器返回的json对象
			$.each(data, function(index, item) {
				lead_index.push(item['领先指数_Y']);
				hot_line.push(item['偏热线']);
				cold_line.push(item['偏冷线']);
				upper.push(item['适度上限']);
				limit.push(item['适度下限']);
				years.push(item['year']);
			});
			Risk.hideLoading(); // 隐藏加载动画
			Risk.setOption({ // 加载数据图表
				dataZoom : [ {
					type : 'inside',
					start : 0,
					end : 60
				}, {
					show : true,
					type : 'slider',
					y : '90%',
					start : 0,
					end : 50
				} ],
				xAxis : {
					data : years
				},
				series : [ {
					data : lead_index
				}, {
					data : hot_line
				}, {
					data : cold_line
				}, {
					data : upper
				}, {
					data : limit
				} ]
			});
		},
		error : function(errorMsg) {
			// 请求失败时执行该函数
			alert("图表请求数据失败!");
			Risk.hideLoading();
		}
	});

	Risk.setOption(option);
	var map1 = {};
	var map2 = {};
	var tstart = ""
	var tend = ""
	Risk.on("dataZoom", function(params) {
		var element = document.getElementById("msg_risk_" + type);
		var opt = Risk.getOption()
		// console.log(params)
		var dz = opt.dataZoom[0];
		var lead = opt.series[0].data;
		var hot = opt.series[1].data[0];// 偏热线
		var cold = opt.series[2].data[0];// 偏冷线
		var upper = opt.series[3].data[0];
		var limit = opt.series[4].data[0];
		var start = dz.startValue;
		var end = dz.endValue;
		tstart = opt.xAxis[0].data[start];
		tend = opt.xAxis[0].data[end];
		var date = tstart + "至" + tend
		// console.log(upper+" "+limit)
		var ldata = []
		for (var i = start; i <= end; i++) {
			ldata[i] = lead[i]
		}

		var fdata = []
		for (var i = 0; i < ldata.length; i++) {
			if (ldata[i] != null || typeof (ldata[i]) != "undefined") {
				fdata.push(ldata[i])
			}
		}
		var lmax = fdata.max()
		var lmin = fdata.min()
		var hotData = []
		var coldData = []

		if (parseFloat(lmax) <= parseFloat(upper)
				&& parseFloat(lmin) >= parseFloat(limit)) {
			element.innerHTML = "根据领先指数判断，" + date + "期间，" + industry
					+ "市场处风险状况为：适度；"
		}
		for (var i = start; i <= end; i++) {
			if (parseFloat(ldata[i]) >= parseFloat(hot)) {
				hotData.push(opt.xAxis[0].data[i])
			}
			if (parseFloat(ldata[i]) <= parseFloat(limit)) {
				coldData.push(opt.xAxis[0].data[i])
			}
		}

		if (hotData.length != 0) {
			element.innerHTML = "根据领先指数判断，" + industry + "市场在，" + hotData
					+ "过热"
		}

		if (coldData.length != 0) {
			element.innerHTML = "根据领先指数判断，" + industry + "市场在，" + coldData
					+ "过冷"
		}
		// console.log(coldData.length+"============"+hotData.length)
		// issue：在获取数组长度时，通过.length()方法，出现判断失误，因此采用以下方法判断数组是否为false
		if (hotData != false && coldData != false) {
			element.innerHTML = "根据领先指数判断，" + industry + "市场在，" + hotData
					+ "过热" + '<br>'
			element.append("根据领先指数判断，" + industry + "市场在，" + coldData + "过冷")
		}
	});
};

// 基于神经网络

$('#industry').change(function() {
	var val = $('#industry').val();
	var all_options = document.getElementById("predIndex").options;
	// 如果不为房地产行业则设置区域投资潜力功能不可用 20181022
	if (val != 0) {
		all_options[2].disabled = true
	} else
		all_options[2].disabled = false
	all_options[0].selected = true
})

// 实现财务风险请求代码。201809010@Mason.
$('#Es3AndLstmBtn').click(
		function() {
			var industryVal = $("#industry").val(); // 获取Select选择的Value
			var predIndexVal = $("#predIndex").val(); // 获取Select选择的Value
			var predTimeVal = $("#predTime").val(); // 获取Select选择的Value
			var ModelTypeVal = $("#ModelType").val(); // 获取Select选择的Value
			// 选择请求方法
			if (industryVal == 0) {
				msg = "【商品房销售价格同比】"
			} else if (industryVal == 1) {
				msg = '【汽车制造业整体均价】'
			} else {
				msg = '【软件行业SPY】'
			}

			var data = {
				'industry' : parseInt(industryVal),
				'predIndex' : parseInt(predIndexVal),
				'predTime' : parseInt(predTimeVal),
				'ModelType' : parseInt(ModelTypeVal)
			};
			// ajax异步请求数据
			$.ajax({
				"url" : './ajaxReal', // 路径
				"cache" : false, // 不缓存
				"async" : true, // 默认true即异步（优先选择）
				"type" : "POST", // POST方式提交
				"dataType" : "json", // json格式，重要*/
				/* "contentType": "application/json", //打开后不能post数据，课后寻找原因哈 */

				"data" : data,
				error : function(request) {// 请求失败之后的操作
					return;
				},
				beforeSend : function(XMLHttpRequest) {
					$("#financialView").empty(); // 加载前先清空结果信息
					$("#financialView1").empty(); // 加载前先清空结果信息
					layui.use([ 'layer', 'form' ], function() {
						index = layer.load(1, {
							shade : 0.06
						});
					});
				},
				success : function(data) { // 成功同步请求数据
					// 请求成功时执行该函数内容，result即为服务器返回的json对象
					layui.use([ 'layer', 'form' ], function() {
						var layer = layui.layer
						layer.close(index);
						// 调用close方法,关闭全局变量index对应的加载效果
					});

					// 展示结果信息
					var element = document.getElementById("ResInfo");
					if (predIndexVal == 0) {
						// 三次指数平滑法
						if (ModelTypeVal == 0) {
							// 财务风险-单项指标及偏冷线和适度下限
							yl = data['r1']
							cz = data['r3']
							jy = data['r4']
							zz = data['r2']
							zh = data['r5']
							czSection = maths(cz)
							ylSection = maths(yl)
							jySection = maths(jy)
							zzSection = maths(zz)
							element.innerHTML = "您预测了【" + predTimeVal
									+ "】年的财务风险各分指标结果如下：<br/>" + "【偿债能力】"
									+ cz.slice(-predTimeVal) + "【偏冷线】"
									+ czSection[0][0] + "【适度下限】"
									+ czSection[1][0] + '<br/>' + "【盈利能力】"
									+ yl.slice(-predTimeVal) + "【偏冷线】"
									+ ylSection[0][0] + "【适度下限】"
									+ ylSection[1][0] + '<br/>' + "【经营效率】"
									+ jy.slice(-predTimeVal) + "【偏冷线】"
									+ jySection[0][0] + "【适度下限】"
									+ jySection[1][0] + '<br/>' + "【增长潜力】"
									+ zz.slice(-predTimeVal) + "【偏冷线】"
									+ zzSection[0][0] + "【适度下限】"
									+ zzSection[1][0] + '<br/>' + "【综合风险】"
									+ zh.slice(-predTimeVal)
						} else {
							// 长短期记忆网络模型。 20181015实现 by HangHang Li
							console.log(data['profitIndex'])
							element.innerHTML = "您预测了【" + predTimeVal
									+ "】年的财务风险各分指标结果如下：<br/>" + "【偿债能力】"
									+ data["debtIndex"] + '||' + "偏冷线："
									+ data['resDebt'][0] + ",适度下限："
									+ data['resDebt'][1] + '<br/>' + "【盈利能力】"
									+ data['profitIndex'] + '||' + "偏冷线："
									+ data['resProfit'][0] + ",适度下限："
									+ data['resProfit'][1] + '<br/>' + "【经营效率】"
									+ data['businessIndex'] + '||' + "偏冷线："
									+ data['resBusiness'][0] + ",适度下限："
									+ data['resBusiness'][1] + '<br/>'
									+ "【增长潜力】" + data['increaseIndex'] + '||'
									+ "偏冷线：" + data['resIncrease'][0]
									+ ",适度下限：" + data['resIncrease'][1]
						}
					}

					if (predIndexVal == 3 || predIndexVal == 1) {

						// 三次指数平滑法
						if (ModelTypeVal == 0) {

							// 合成指数预测值
							tb = data['tb']
							// 领先指标
							lead = data['lead']
							lag = data['lag']
							hpy = data['hpy']
							if (predIndexVal == 1) {
								// 输出风险预警
								Section = maths(lead)
								element.innerHTML = "您预测了【" + predTimeVal
										+ "】个季度的市场风险预警结果如下：<br />" + "【同步指数】"
										+ tb.slice(-predTimeVal) + '<br />'
										+ "【偏热线】" + Section[2] + '<br />'
										+ "【偏冷线】" + Section[0][0] + '<br />'
										+ "【适度上限】" + Section[3] + '<br />'
										+ "【适度下限】" + Section[1][0] + '<br />'
							} else {
								element.innerHTML = "您预测了【" + predTimeVal
										+ "】个季度的合成指数结果如下：<br />" + "【同步】"
										+ tb.slice(-predTimeVal) + '<br />'
										+ "【领先】" + lead.slice(-predTimeVal)
										+ '<br />' + "【滞后】"
										+ lag.slice(-predTimeVal) + '<br />'
										+ msg + hpy.slice(-predTimeVal)
							}

						} else {
							// LSTM模型20181010 by HangHangLi

							if (predIndexVal == 1) {
								// 输出风险预警
								element.innerHTML = "您预测了【" + predTimeVal
										+ "】个季度的市场风险预警结果如下：<br />" + "【同步指数】"
										+ data['leadIndex'] + '<br />'
										+ "【偏热线】" + data['res'][1] + '<br />'
										+ "【偏冷线】" + data['res'][0] + '<br />'
										+ "【适度上限】" + data['res'][2] + '<br />'
										+ "【适度下限】" + data['res'][3] + '<br />'
							} else {
								element.innerHTML = "您预测了【" + predTimeVal
										+ "】个季度的合成指数，各单项结果如下：<br />" + "【领先指数】"
										+ data['leadIndex'] + '<br />'
										+ "【同步指数】" + data['tbIndex'] + '<br />'
										+ "【滞后指数】" + data['lagIndex']
										+ '<br />' + msg + data['hpyIndex']

							}
						}
					}

					if (predIndexVal == 4) {
						// 三次指数平滑法
						if (ModelTypeVal == 0) {
							// 扩散指数预测值
							tb = data['tb']
							lead = data['lead']
							lag = data['lag']
							element.innerHTML = "您预测了【" + predTimeVal
									+ "】个季度的扩散指数结果如下：<br />" + "【同步】"
									+ tb.slice(-predTimeVal) + '<br />'
									+ "【领先】" + lead.slice(-predTimeVal)
									+ '<br />' + "【滞后】"
									+ lag.slice(-predTimeVal) + '<br />'
						} else {

							// 扩散指数预测值，长短期记忆网络
							element.innerHTML = "您预测了【" + predTimeVal
									+ "】个季度的扩散指数结果如下：<br />" + "【同步】"
									+ data['tbIndex'] + '<br />' + "【领先】"
									+ data['leadIndex'] + '<br />' + "【滞后】"
									+ data['lagIndex'] + '<br />'
						}
					}

					// 区位因子，仅房地产行业
					if (predIndexVal == 2) {
						// 三次指数平滑法
						if (ModelTypeVal == 0) {
							// 扩散指数预测值
							// 区位投资潜力指数预测值，长短期记忆网络
							element.innerHTML = "您预测了【" + predTimeVal
									+ "】个季度的区域投资潜力结果如下：<br />" + "【区位因子】"
									+ data['zone'] + '<br />' + "【经济因子】"
									+ data['financial'] + '<br />' + "【人口因子】"
									+ data['people'] + '<br />' + "【市场供需因子】"
									+ data['market'] + '<br />' + "【投资潜力因子】"
									+ data['invest'] + '<br />'
						} else {
							// 区位投资潜力指数预测值，长短期记忆网络
							element.innerHTML = "您预测了【" + predTimeVal
									+ "】个季度的区域投资潜力结果如下：<br />" + "【区位因子】"
									+ data['zoneIndex'] + '<br />' + "【经济因子】"
									+ data['financialIndex'] + '<br />'
									+ "【人口因子】" + data['peopleIndex'] + '<br />'
									+ "【市场供需因子】" + data['marketIndex']
									+ '<br />' + "【投资潜力因子】"
									+ data['investIndex'] + '<br />'
						}
					}

				}

			});

		})
