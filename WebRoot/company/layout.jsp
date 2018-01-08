<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li>
							<a class="dropmenu" ><i class="icon-align-justify"></i><span class="hidden-tablet">企业概况</span><span class="label label-important"></span></a>
							<ul>
								<li><a class="submenu" href="./?name=${name}"><i class=""></i><span class="children"><span  class="hidden-tablet"> 基本信息</span></span></a></li>
								<li><a class="submenu" href="./relate?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet">公司关系</span></span></a></li>
								<!-- <li><a class="submenu" href="submenu3.html"><i class=""></i><span class="hidden-tablet"> Sub Menu 3</span></a></li> -->
							</ul>	
						</li>
						<li>
							<a class="dropmenu" ><i class="icon-star"></i><span class="hidden-tablet">企业信用分析</span><span class="label label-important"></span></a>
							<ul>
								<li><a class="submenu" href="./credit?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet"> 税务、负债、资信</span></span></a></li>
							</ul>	
						</li>
						<li>
							<a class="dropmenu" ><i class="icon-calendar"></i><span class="hidden-tablet">企业发展分析</span><span class="label label-important"></span></a>
							<ul>
								<li><a class="submenu" href="./status?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet"> 所处行业发展分析</span></span></a></li>
								<li><a class="submenu" href="./develop?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet"> 业务经营发展分析</span></span></a></li>
								<!-- <li><a class="submenu" href="submenu3.html"><i class=""></i><span class="hidden-tablet"> Sub Menu 3</span></a></li> -->
							</ul>	
						</li>
						<li>
							<a class="dropmenu" ><i class="icon-picture"></i><span class="hidden-tablet">财务分析</span><span class="label label-important"></span></a>
							<ul>
								<li><a class="submenu" href="./basic_financial?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet">财务指标分析</span></span></a></li>
								<li><a class="submenu" href="./financial_report?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet"> 财务报表分析</span></span></a></li>
							</ul>	
						</li>
						<li>
							<a class="dropmenu" ><i class="icon-book"></i><span class="hidden-tablet">企业新闻</span></a>
							<ul>
								<li><a class="submenu" href="./news?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet">公司新闻</span></span></a></li>
<%-- 								<li><a class="submenu" href="./company/financial_report?name=${name}"><i class=""></i><span class="children"><span class="hidden-tablet"> 财务报表分析</span></span></a></li>
 --%>							</ul>	
						</li>

					</ul>
				</div>
			</div>
			<!-- end: Main Menu -->			
</body>
</html>