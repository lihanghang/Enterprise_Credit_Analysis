function treeMenu(a){
    //列表map形式
    this.tree=a||[];
    this.groups={};
	//存放id与对应的name映射
	this.nameMap={}
	//得到每个点对应的层次,为了后期进行布局
	this.levelMap={}
	//样式设计
	this.style={"symbolSize":[60,50,40,30,20],"value":[8,6,4,2,1]}
};
treeMenu.prototype={
    init:function(pid){
        this.group();
		this.MapNamebyId();
		this.setIdLevel(pid);
        return this.rescusive(pid);
    },
    group:function(){
        for(var i=0;i<this.tree.length;i++){
            //存在该grops则直接添加
            if(this.groups[this.tree[i].pId]){
                this.groups[this.tree[i].pId].push(this.tree[i]);
            }else{
                this.groups[this.tree[i].pId]=[];
                this.groups[this.tree[i].pId].push(this.tree[i]);
            }
        }
    },
	//得到每个点的层次
	setIdLevel:function(pid){
		var level=1;
		this.levelMap[pid]=level;
		var gs=this.groups[pid];
		//str=JSON.stringify(gs)
		//alert("json:"+str)
		var temp=[]
		while(gs){
			level++;
			if(gs==null||gs==undefined||gs.length==0)
				break;
			temp=[]
			for(var i=0;i<gs.length;i++){
				var myid=gs[i]["id"];
				this.levelMap[myid]=level;
				subgs=this.groups[myid];
				if(subgs instanceof Array &&subgs!=null){
				for(var j=0;j<subgs.length;j++){
				temp.push(subgs[j]);
				}
				}
			}
			gs=temp;
		}
		
	},
	//根据所在层次设计不同大小的样式
	getStyleById:function(id){
		var level=this.levelMap[id]
		if(level>=5)
			level=5;
		var symbolize=0
		var value=0
		symbolize=this.style['symbolSize'][level-1]
		value=this.style['value'][level-1]
		var styleValue={}
		styleValue['symbolSize']=symbolize
		styleValue['value']=value
		return styleValue
	},
    MapNamebyId:function(){
		for(var i=0;i<this.tree.length;i++){
			map=this.tree[i]
			this.nameMap[map["id"]]=map["name"]
		}
	},
	//设置节点属性
	setNode:function(node,name,symbolize,value,children){
		    node['name']=name;
			node['symbolSize']=symbolize;
			node['value']=value
			node['children']=children
			return node;
	},
	rescusive:function (number){
		var data=[]
		var node={}
		var styleValue={}
		//某个节点下的子节点
		var a=this.groups[number];
		var nodeName=this.nameMap[number];
		if(a==null||a==undefined){
			styleValue=this.getStyleById(number)
			//设置节点
			this.setNode(node,nodeName,styleValue['symbolSize'],styleValue['value'],[])
			return node;
		}
		for(var i=0;i<a.length;i++){
			children=this.rescusive(a[i].id);
			data.push(children);
		}
		styleValue=this.getStyleById(number)
		this.setNode(node,nodeName,styleValue['symbolSize'],styleValue['value'],data)
		return node;
	},
	//创建组织结构图
	createTreeVisual:function(myChart,title,data){
		var option = {
        title : {
        text: title,
        position: 'center',       
        subtext: '被投资单位、关联企业、下属单位'
       },
        tooltip : {
        trigger: 'item',
        formatter: "{b}"
        },
      toolbox: {
        show : true,
        feature : {
            saveAsImage : {show: true}
         }
      },
	   itemStyle: {
                normal: {
                    label: {
                        show: true,
                        position: 'right',
                        textStyle: {
                            color: '#fa6900',
                            fontSize: 15,
                            fontWeight:  'bolder'
                        }
                    },
                    lineStyle: {
                        color: '#999966',
                        width: 1,
                        type: 'dashed' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                    }
                },
                emphasis: {
                    label: {
                        show: true
                    }
                }
            },
      calculable : false,
       series : [
         {
            name:'树图',
            type:'tree',
            orient: 'horizontal',  // vertical horizontal
            rootLocation: {x: 250, y: '75%'}, // 根节点位置  {x: 'center',y: 10}
            nodePadding: 20,
           /* symbol: '',*/
            data:data
        }]//series
	}	
     myChart.setOption(option);
	}
}
//得到数据
function getData(zNodes){
	var mytree=new treeMenu(zNodes)
	treeData=mytree.init(0)
	data=[]
	data.push(treeData)
	return data;
	//str=JSON.stringify(menu);
	//alert("responsing json:"+str)
}
function createTreeV(mychart,title,znodes){
	var mytree=new treeMenu(znodes)
	treeData=mytree.init(1)
	data=[]
	data.push(treeData)
	mytree.createTreeVisual(myChart,title,data)
}
//getData()
