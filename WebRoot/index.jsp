<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page  import="java.util.Iterator"%>
<%@page  import="com.jfinal.plugin.activerecord.Record"%>
<%@page  import="java.util.List"%>
<head>
                <!-- META TAGS -->
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>信用报告数据分析查询</title>
                
                <link rel="shortcut icon" href="./resource/index/images/favicon.png" />
                <!-- Style Sheet-->
                <link rel="stylesheet" href="./resource/index/css/style.css"/>
                <link rel="stylesheet" href="./resource/common/css/bootstrap.min.css"/>
            
                <link rel='stylesheet' id='responsive-css-css'  href='./resource/index/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='./resource/index/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='./resource/index/css/main5152.css?ver=1.0' type='text/css' media='all' />
             
</head>
<style type="text/css">
.table_box{
	width:998px;
	border:1px solid #89D5EF;
	background:#FFF;
	margin-bottom:25px;
	float:left;
	padding:1px
	}

.table_box table{
	border:1px solid #CCC;
	border-collapse:collapse;
	width:100%
	}
.table_box table td,.table_box table th{
	border-right:1px solid #ccc;
	border-bottom:1px solid #ccc;
	overflow:hidden;
	padding:0 3px
	}

table.list{border:1px solid #e4e4e4;border-collapse:collapse;width:100%;margin-bottom:4px;background:#fff}
table.list th{font-size:17px;background-color:#EEE;white-space:nowrap;text-align:center;padding:4px 4px 4px 14px}
table.list td{vertical-align:top}
table.list td.id{width:2%;text-align:center}
table.list td.checkbox{width:15px;padding:0}
table.list td.buttons{width:15%;white-space:nowrap;text-align:right}
table.list td.buttons a{padding-right:.6em}
table.list caption{text-align:left;padding:.5em .5em .5em 0}
table tbody tr:hover{background-color:#FFD}
table tr.highlight{background-color:#c90}


</style>
     <body>

                <!-- Start of Header -->
         <div class="header-wrapper">
               <header>
                      <div class="container">


                                        <div class="logo-container">
                                                <!-- Website Logo -->
                                               <!--  <a href="index-2.html"  title="Knowledge Base Theme">
                                                        <img src="./resource/index/images/logo.png" alt="Knowledge Base Theme">
                                                </a> -->
                                                <span class="tag-line">信用报告数据分析查询平台</span>
                                        </div>


                                        <!-- Start of Main Navigation -->
                                        <nav class="main-nav">
                                                <div class="menu-top-menu-container">
                                                        <!-- <ul id="menu-top-menu" class="clearfix">
                                                                <li class="current-menu-item"><a href="index-2.html">Home</a></li>
                                                                <li><a href="home-categories-description.html">Home 2</a></li>
                                                                <li><a href="home-categories-articles.html">Home 3</a></li>
                                                                <li><a href="articles-list.html">Articles List</a></li>
                                                                <li><a href="faq.html">FAQs</a></li>
                                                                <li><a href="#">Skins</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="blue-skin.html">Blue Skin</a></li>
                                                                                <li><a href="green-skin.html">Green Skin</a></li>
                                                                                <li><a href="red-skin.html">Red Skin</a></li>
                                                                                <li><a href="index-2.html">Default Skin</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="#">More</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="full-width.html">Full Width</a></li>
                                                                                <li><a href="elements.html">Elements</a></li>
                                                                                <li><a href="page.html">Sample Page</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="contact.html">Contact</a></li>
                                                        </ul> -->
                                                </div>
                                        </nav>
                                        <!-- End of Main Navigation -->

                                </div>
                        </header>
                </div>
                <!-- End of Header -->

                <!-- Start of Search Wrapper -->
                <div class="search-area-wrapper">
                        <div class="search-area container">
                                <h3 class="search-header">企业信用分析查询</h3>
                                <p class="search-tag-line">以企业名称（关键字）进行检索</p>

                                <form id="search-form" class="search-form clearfix" method="get" action="#" autocomplete="off">
                                        <input class="search-term required" type="text" id="s" name="s" placeholder="请输入公司(关键字)名称" title="请输入查询公司名称" />
                                        <input class="search-btn" type="button" onclick="search()" value="查询" />
                                        <div id="search-error-container"></div>
                                </form>
                        </div>
                </div>
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 page-content">
<!-- 	<h4 style="text-align:center;padding-left:300px;color:red">系统处于测试阶段，可测试公司序号为："1--10,15--20(部分数据局部调整)",其它公司数据正在调整中……</h4>
 -->  <div class="table_box" style="margin-left:80px">
  
	<table class="list" id="company">
		<tbody>
			<tr>
				<th width="8%">序号</th>
				<th width="50%">企业名称</th>
				<th width="12%">操作</th>
				<!-- <th width="12%">发布时间</th> -->				
			</tr>
			<%
	List<Record> list=(List<Record>)request.getAttribute("dataList");
	if(list!=null){
		Iterator<Record> iter=list.iterator();
		int i =0;
		while(iter.hasNext()){
			
			Record re=iter.next();%>
			<tr>
				<td style="text-align:center;"><%=i=i+1%></td>
				<td style="text-align:center;"><%=re.get("company_name")%></td>
				 
				<td style="text-align:center;">
					 &nbsp;&nbsp;<a href="./company/index?name=<%=re.get("company_name")%>">
						<div class = "btn-group">
						<button type="button" class="btn btn-default">查看信用报告分析</button></div></a>
				</td>
				
				<%-- <td style="text-align:left;">${x.title}</td> --%>
			</tr>
			                  <%	}
	}													
 %>     
		</tbody>
	</table>  
<ul class="pagination" id="page" style="margin-left:400px;margin-top:12px">
 <li><a href="#">&laquo;</a></li>
    <li><a href="?current_page=0">1</a></li>
    <li><a href="?current_page=1">2</a></li>
    <li><a href="?current_page=2">3</a></li>
    <li><a href="?current_page=4">4</a></li>
    <li><a href="?current_page=5">5</a></li>
    <li><a href="?current_page=1">&raquo;</a></li>
</ul> 
<%-- <ul class="pagination" id="page">总数${newsPage.total}</ul> --%>
	
	
	                                            <!-- Basic Home Page Template -->
                                                   <%--   <div class="row separator">
                                                        <section class="span4 articles-list">
                                                                <h3>企业名称</h3>
                                                                <ul class="articles">
   		
                                                                                                                        
                                      
 																<c:forEach items="${dataList }"  var="data" varStatus="status">
 														       <li class="article-entry standard">
                                                                                <h4><a href="./company/index?name=万联赢通"><c:out value='${data[i]}'/>${data[i]}fdfd</a></h4>
                                                                                <!-- <span class="article-meta">24 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                                                                                <span class="like-count">15</span> -->
                                                                </li>
                                                                </c:forEach> --%>
                                                                <!--        <li class="article-entry video">
                                                                                <h4><a href="single.html">Meta Tags in WordPress</a></h4>
                                                                                <span class="article-meta">23 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                                                                                <span class="like-count">8</span>
                                                                        </li>
                                                                        <li class="article-entry image">
                                                                                <h4><a href="single.html">WordPress in Your Language</a></h4>
                                                                                <span class="article-meta">22 Feb, 2013 in <a href="#" title="View all posts in Advanced Techniques">Advanced Techniques</a></span>
                                                                                <span class="like-count">6</span>
                                                                        </li>
                                                                        <li class="article-entry standard">
                                                                                <h4><a href="single.html">Know Your Sources</a></h4>
                                                                                <span class="article-meta">22 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                                                                                <span class="like-count">2</span>
                                                                        </li>
                                                                        <li class="article-entry standard">
                                                                                <h4><a href="single.html">Validating a Website</a></h4>
                                                                                <span class="article-meta">21 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                                                                                <span class="like-count">3</span>
                                                                        </li> -->
                                                              
                                                  


                                                      <!--   <section class="span4 articles-list">
                                                                <h3>Latest Articles</h3>
                                                                <ul class="articles">
                                                                        <li class="article-entry standard">
                                                                                <h4><a href="single.html">Integrating WordPress with Your Website</a></h4>
                                                                                <span class="article-meta">25 Feb, 2013 in <a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a></span>
                                                                                <span class="like-count">66</span>
                                                                        </li>
                                                                        <li class="article-entry standard">
                                                                                <h4><a href="single.html">Using Javascript</a></h4>
                                                                                <span class="article-meta">25 Feb, 2013 in <a href="#" title="View all posts in Advanced Techniques">Advanced Techniques</a></span>
                                                                                <span class="like-count">18</span>
                                                                        </li>
                                                                        <li class="article-entry image">
                                                                                <h4><a href="single.html">Using Images</a></h4>
                                                                                <span class="article-meta">25 Feb, 2013 in <a href="#" title="View all posts in Designing in WordPress">Designing in WordPress</a></span>
                                                                                <span class="like-count">7</span>
                                                                        </li>
                                                                        <li class="article-entry video">
                                                                                <h4><a href="single.html">Using Video</a></h4>
                                                                                <span class="article-meta">24 Feb, 2013 in <a href="#" title="View all posts in WordPress Plugins">WordPress Plugins</a></span>
                                                                                <span class="like-count">7</span>
                                                                        </li>
                                                                        <li class="article-entry standard">
                                                                                <h4><a href="single.html">WordPress Site Maintenance</a></h4>
                                                                                <span class="article-meta">24 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                                                                                <span class="like-count">15</span>
                                                                        </li>
                                                                        <li class="article-entry standard">
                                                                                <h4><a href="single.html">WordPress CSS Information and Techniques</a></h4>
                                                                                <span class="article-meta">24 Feb, 2013 in <a href="#" title="View all posts in Theme Development">Theme Development</a></span>
                                                                                <span class="like-count">1</span>
                                                                        </li>-->
                                                                </ul>
                                                        </section> 
                                                </div>
                                        </div>
                                        <!-- end of page content -->


                                        <!-- start of sidebar -->
                                    <!--     <aside class="span4 page-sidebar">

                                                <section class="widget">
                                                        <div class="support-widget">
                                                                <h3 class="title">Support</h3>
                                                                <p class="intro">Need more support? If you did not found an answer, contact us for further help.</p>
                                                        </div>
                                                </section>

                                                <section class="widget">
                                                        <div class="quick-links-widget">
                                                                <h3 class="title">Quick Links</h3>
                                                                <ul id="menu-quick-links" class="menu clearfix">
                                                                        <li><a href="index-2.html">Home</a></li>
                                                                        <li><a href="articles-list.html">Articles List</a></li>
                                                                        <li><a href="faq.html">FAQs</a></li>
                                                                        <li><a href="contact.html">Contact</a></li>
                                                                </ul>
                                                        </div>
                                                </section>

                                                <section class="widget">
                                                        <h3 class="title">Tags</h3>
                                                        <div class="tagcloud">
                                                                <a href="#" class="btn btn-mini">basic</a>
                                                                <a href="#" class="btn btn-mini">beginner</a>
                                                                <a href="#" class="btn btn-mini">blogging</a>
                                                                <a href="#" class="btn btn-mini">colour</a>
                                                                <a href="#" class="btn btn-mini">css</a>
                                                                <a href="#" class="btn btn-mini">date</a>
                                                                <a href="#" class="btn btn-mini">design</a>
                                                                <a href="#" class="btn btn-mini">files</a>
                                                                <a href="#" class="btn btn-mini">format</a>
                                                                <a href="#" class="btn btn-mini">header</a>
                                                                <a href="#" class="btn btn-mini">images</a>
                                                                <a href="#" class="btn btn-mini">plugins</a>
                                                                <a href="#" class="btn btn-mini">setting</a>
                                                                <a href="#" class="btn btn-mini">templates</a>
                                                                <a href="#" class="btn btn-mini">theme</a>
                                                                <a href="#" class="btn btn-mini">time</a>
                                                                <a href="#" class="btn btn-mini">videos</a>
                                                                <a href="#" class="btn btn-mini">website</a>
                                                                <a href="#" class="btn btn-mini">wordpress</a>
                                                        </div>
                                                </section>

                                        </aside> -->
                                        <!-- end of sidebar -->
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->

                <!-- Start of Footer -->
                <footer id="footer-wrapper">       
                        <!-- Footer Bottom -->
                        <div id="footer-bottom-wrapper">
                                <div id="footer-bottom" class="container">
                                        
                                              
                <p class="copyright" >
                                                              版权所有2017&copy;  <a href="http://ccip.ucas.ac.cn/" style="color:red;">UCAS_CCIP实验室</a>
            	</p>
                                              
                                       
                                </div>
                        </div>
                        <!-- End of Footer Bottom -->

                </footer>
                <!-- End of Footer -->
                <a href="#top" id="scroll-top"></a>
                <!-- script -->
                <script type='text/javascript' src='./resource/assets/js/jquery-2.1.0.js'></script>
                <script type='text/javascript' src='./resource/new/js/bootstrap-paginator.js'></script>
                <script type='text/javascript' src='./resource/index/js/jquery.easing.1.3.js'></script>
                <script type='text/javascript' src='./resource/index/js/prettyphoto/jquery.prettyPhoto.js'></script>
                <script type='text/javascript' src='./resource/index/js/jflickrfeed.js'></script>
                 <script type='text/javascript' src='./resource/common/js/bootstrap.min.js'></script>

               
        </body>
</html>
 <script>
        var search = function (){
            var trs = company.tBodies[0].rows;
            for(var i = 0; i < trs.length; i++){
                var tr = trs[i];
                if(tr.innerHTML.search(s.value) == -1)
                    tr.style.display = 'none';
                else
                    tr.style.display = '';
            }
              if (s.value == null)
            	  trs.style.dipaly = "";
        }
        

 </script>

