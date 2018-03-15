package demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;

import sun.security.provider.MD5;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;


public class IndexController extends Controller {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		public void index() throws BiffException, IOException{
						
			
	        setAttr("currentDate",time);
			render("index.html");
		}
		// 添加拦截器，判读用户是否登录系统0309 author:Mason
		@Before(Interceptor.MyInterceptor.class)
		public void startUse(){
			
			render("./company/companyList.html");
		}
		public void  loginView(){
			
			
		}
		/*
		 * login 0309 
		 * Author:Mason
		 * param：username/passwd/type
		 */
		//验证器
		@Before(Validator.LoginValidator.class) 
		public void login(){
			
			String username = getPara("username");
	        String passwd = getPara("password");
	        String sql = "SELECT * FROM en_user WHERE username = ? AND passwd = ?";
			List<Record> data = Db.find(sql,  username, passwd);
			if(data.size()>0){
				getSession().setAttribute("username", username); //验证成功，保存session信息,提供给拦截器使用
				render("/index.html");
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

