package com.ccip.bank.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ccip.bank.model.User;
import com.ccip.bank.service.CompanyService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

public class CompanyController extends Controller {	
	
		static CompanyService service = new CompanyService();	
			//定义前缀常量
	    String filePath = "A://work/project_finance/basic_data/rdf_data/100/test20/";
	    //拦截器，防止未登录用户进入
	    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
		public void index() {
		    //封装前台展示的数据
		    User name = getSessionAttr(getCookie("cuser"));		    
		    setAttr("companyData",service.getByOrgNum(getPara()));
		    setAttr("name",name);	
			render("company.html");					
		}
		
		//企业背景页面
		public void basicInfo()
		{
			render("companyInfo.html");
		}
		//经营状况页面
		public void operation()
		{
			render("operatingstatus.html");
		}
		//风险状况页面
		public void lawsuit()
		{
			render("lawsuit.html");
			}		
		
		//知识产权页面
		public void intellectProperty()
		{
			render("intellectualproperty.html");
		}
		public void companyList(){
			String company = getPara("keyword");
			render("companyList.html");
			System.out.print(company);
		}

}
