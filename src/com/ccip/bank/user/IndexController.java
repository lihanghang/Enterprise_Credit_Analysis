package com.ccip.bank.user;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ccip.bank.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;


/**
 * @author Mason 前端控制器
 */

public class IndexController extends Controller {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		
		//进入首页
		@ActionKey("/")
		public void index() {
			String cuser = getCookie("cuser");
			User u = getSessionAttr(cuser);
			System.out.print(cuser);
			render("index.html");
		}
		
		// 添加拦截器，判读用户是否登录系统0309 author:Mason
		//公司搜索主方法,列表展示
		//@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
		public void search(){
			String keyWord = getPara("keyWord");
			render("./company/companyList.html");
		}
		
		/*
		 * login 0309 
		 * Author:Mason
		 * param：username/passwd/type
		 */
		
		//验证器
		//@Before(com.ccip.bank.validator.LoginValidator.class) 
		public void login(){
			
			String uname = getPara("username");
			String sql = "select * from en_user where username = ? limit 1";
			User user = User.dao.findFirst(sql, uname);
			if(user != null)
			{
				 System.out.println(user.getPwd());
				  String passwd = getPara("password");
				  if(user.getPwd().equals(passwd)){
					  	
					  	String sessionId = SessionIdKit.me().generate(getRequest());
					// 设置服务器端session
						setSessionAttr(sessionId, user);
						// 设置用户端cookie
						setCookie("cuser", sessionId, 60000);
						redirect("/");
						
				  }
			
//	      
//	        String sql = "SELECT * FROM en_user WHERE username = ? AND passwd = ?";
//			List<Record> data = Db.find(sql,  username, passwd);
//			if(data.size()>0){
//				getSession().setAttribute("username", username); //验证成功，保存session信息,提供给拦截器使用
				
			}
			else{

				renderText("登录失败！");
						
		}
}
		
		/**
		 * register 0309
		 * Author：Mason
		 * param:username/passwd
		 */
		
		public void reg(){
			
			String username = getPara("username");
	        String pwd = getPara("password");
	        String email = getPara("email");
	        int type = getParaToInt("type"); 
	        int depart = getParaToInt("depart");	        
	        Record user = new Record().set("username", username).set("passwd", pwd).set("department", depart).set("email", email).set("type", type).set("reg_time", time); 
	        Db.save("en_user", user);
	        redirect("/company/login.html");
	     
		}
		
		public void  dataJson() throws BiffException, IOException{
			
			
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/123.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(2);
		    int num = 1;
		    ArrayList<String>  name = new ArrayList<String> ();
			ArrayList<String>  zone = new ArrayList<String> ();
			ArrayList<String>  data = new ArrayList<String> ();
			ArrayList<String> status = new ArrayList<String> ();
			ArrayList<String>  capital = new ArrayList<String> ();						
			Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();
			
			while(num<=766)
			{
				name.add(sheet.getCell(0,num).getContents());
				capital.add(sheet.getCell(1,num).getContents());
				data.add(sheet.getCell(2,num).getContents());
				status.add(sheet.getCell(3,num).getContents());
				zone.add( sheet.getCell(12,num).getContents());				
				num++;
			} 	
			
			map.put("company_name", name);
			map.put("zone", zone);
			map.put("status", status);
			map.put("data", data);
			map.put("capital", capital);	
			String json = JsonKit.toJson(map); 
			renderJson(json);

		}

}

