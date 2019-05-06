package com.ccip.bank.company;

import java.util.List;
import java.util.Map;

import com.ccip.bank.model.Company;
import com.ccip.bank.model.EnterpriseInfoRdf;
import com.ccip.bank.model.User;
import com.ccip.bank.service.CompanyService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class CompanyController extends Controller {	

    private static final int PAGE_SIZE = 3;
    static CompanyService comInfoservice = new CompanyService();
    static EnterpriseInfoRdf test = new EnterpriseInfoRdf(); //实例化RDF查询Model
    //拦截器，防止未登录用户进入
    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
    public void index() {
        //封装前台展示的数据
        User name = getSessionAttr(getCookie("cuser"));		    
        setAttr("companyData",comInfoservice.getByCreditNum(getPara("num")));
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
        setAttr("companyData",comInfoservice.getByCreditNum(getPara("num")));
        render("companyInfo.html");
    }


    //经营状况页面
    //拦截器，防止未登录用户进入
    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
    public void operation()
    {   
        String company = getPara("name");
        Map taxInfoMap = test.taxInfo(company); //税务信息
        Map debtInfoMap = test.debtInfo(company); //负债偿还情况
        setAttr("debtData", debtInfoMap);
        setAttr("taxData", taxInfoMap);
        setAttr("companyData",comInfoservice.getByCreditNum(getPara("num")));
        render("operatingstatus.html");
    }


    //风险状况页面0419 by Hang-Hang Li
    //拦截器，防止未登录用户进入
    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
    public void lawsuit()
    {	
        //获取公司编号
        String num = getPara("num");
        //将数据分页 默认展示第一页，每页3条
        List<Company> lawList = comInfoservice.paginats(1,PAGE_SIZE,num).getList();
        setAttr("lawSuit",lawList);
        setAttr("pageNum",comInfoservice.paginats(1,PAGE_SIZE,num).getPageNumber());
        setAttr("totalPage",comInfoservice.paginats(1,PAGE_SIZE,num).getTotalPage());


        setAttr("legalData", comInfoservice.paginats(1,3, num));
        setAttr("personData", comInfoservice.paginat_preson(1, 3, num));
        setAttr("sessionData",comInfoservice.paginat_session(1, 3, num));
        setAttr("noticeData", comInfoservice.paginat_notice(1, 3, num));

        //需要优化 目标是获取公司的编号和名字 ，涉及外键查询
        setAttr("companyData",comInfoservice.getByCreditNum(num));
        render("lawsuit.html");
    }		

    //基于Jfinal的ajax分页
    public void ajaxViewList() {


    }




    //知识产权页面0420 by Hang-Hang Li
    //拦截器，防止未登录用户进入
    @Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)	
    public void intellectProperty()
    {
        setAttr("brandData", comInfoservice.paginat_brand(getParaToInt(0, 1), 5, getPara("num")));
        setAttr("softData", comInfoservice.paginat_soft(getParaToInt(0, 1), 5, getPara("num")));
        setAttr("patentData",comInfoservice.paginat_zhuanli(getParaToInt(0, 1), 5, getPara("num")));
        setAttr("webData", comInfoservice.paginat_web(getParaToInt(0, 1), 5, getPara("num")));
        setAttr("worksData", comInfoservice.paginat_works(getParaToInt(0, 1), 5, getPara("num")));
        setAttr("companyData",comInfoservice.getByCreditNum(getPara("num")));
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
