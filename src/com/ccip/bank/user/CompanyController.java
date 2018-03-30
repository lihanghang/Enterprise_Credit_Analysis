package com.ccip.bank.user;

import java.util.Map;
import com.ccip.bank.model.EnterpriseInfoRdf;
import com.ccip.bank.model.User;
import com.ccip.bank.service.CompanyService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class CompanyController extends Controller {	
	
		static CompanyService service = new CompanyService();
		static EnterpriseInfoRdf test = new EnterpriseInfoRdf(); //实例化RDF查询Model
	    //拦截器，防止未登录用户进入
	    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
		public void index() {
		    //封装前台展示的数据
		    User name = getSessionAttr(getCookie("cuser"));		    
		    setAttr("companyData",service.getByOrgNum(getPara("num")));
		    setAttr("name",name);	
			render("company.html");					
		}
			    
		//企业背景页面;基于RDF存储，SPARQL查询语言获取数据
	    //拦截器，防止未登录用户进入
	    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
		public void basicInfo()
		{		    		
	    	String company = getPara("name");	    	
		    Map data = test.basicInfo(company);	  
		    setAttr("rdfData", data);
			setAttr("companyData",service.getByOrgNum(getPara("num")));
			render("companyInfo.html");
		}
	    
		//经营状况页面
	    //拦截器，防止未登录用户进入
	    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
		public void operation()
		{
			setAttr("companyData",service.getByOrgNum(getPara("num")));
			render("operatingstatus.html");
		}
		//风险状况页面
	    //拦截器，防止未登录用户进入
	    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
		public void lawsuit()
		{
			setAttr("companyData",service.getByOrgNum(getPara("num")));
			render("lawsuit.html");
			}		
		
		//知识产权页面
	    //拦截器，防止未登录用户进入
	    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
		public void intellectProperty()
		{
			setAttr("companyData",service.getByOrgNum(getPara("num")));
			render("intellectualproperty.html");
		}
	    //拦截器，防止未登录用户进入
	    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
		public void companyList(){
			String company = getPara("keyword");
			render("companyList.html");
			System.out.print(company);
		}

}
