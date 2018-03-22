package com.ccip.bank.user;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ccip.bank.model.User;
import com.ccip.bank.utils.DateUtils;
import com.ccip.bank.utils.MD5;
import com.jfinal.aop.Before;
import com.jfinal.captcha.CaptchaRender;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;
import com.jfinal.kit.JsonKit;


/**
 * @author Mason 前端控制器
 */

public class IndexController extends Controller {

		//进入首页
		@ActionKey("/")
		public void index() {
			String serverIp = getRequest().getRemoteAddr();
			System.out.println(serverIp);
			render("index.html");
		}
		
		// 添加拦截器，判读用户是否登录系统0309 author:Mason
		//公司搜索主方法,列表展示
		@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
		public void search(){
			
			render("./company/companyList.html");
		}
		
		/*
		 * login 0309 
		 * Author:Mason
		 * param：username/passwd/type
		 */
		//登录页面
		public void login()
		{
			render("/user/login.html");
		}
		//验证器
		//@Before(com.ccip.bank.validator.LoginValidator.class) 
		public void doLogin(){
			
			String uname = getPara("username");
			String passwd = getPara("password");
			String sql = "select * from en_user where username = ? limit 1";
			User user = User.dao.findFirst(sql, uname);
			if(user != null)
			{	
				String pwd = MD5.GetMD5Code((passwd) + user.getRegDate());
				System.out.println(pwd);
				if(user.getPwd().equals(pwd))	
				{				  	
					String sessionId = SessionIdKit.me().generate(getRequest());
					 // 设置服务器端session
					setSessionAttr(sessionId, user);
					setSessionAttr("user",user.getUname());
					// 设置用户端cookie
					setCookie("cuser", sessionId, 60000);					
				    redirect("/");
				    }
			
			else{

				// 密码不正确
				setAttr("UnameErrMsg", "用户名或密码不正确！");
				//setAttr("system", IndexService.getSysConfig());
				render("/user/login.html");	
				return;
				}			
		}else {
				// 用户名不存在
				setAttr("UnameErrMsg", "用户名不存在！");
				render("/user/login.html");
				return;
			}
}
	
		// 已经登录用户的退出操作
		public void logout() {
			removeSessionAttr("user");
			removeCookie("cuser");
			redirect("/");
		}
		/**
		 * register 0309
		 * Author：Mason
		 * param:username/passwd
		 * 用户注册
		 */
		
		public void regist(){
			
			
			render("/user/reg.html");
		}
		//@ActionKey("register")
		//@Before(RegistValidator.class)
		public void register(){
			

			// 验证码校验
			boolean result = validateCaptcha("verifycode");
			if (!result) {
				setAttr("vcMsg", "验证码错误！");
				render("/user/reg.html");
				return;
			}
			
			
			
			User user = this.getModel(User.class);
			String uname = getPara("username");
	        String pwd = getPara("passwd");
	        String confirm = getPara("repasswd");
	        String email = getPara("email");	
	        if(pwd.length()<6 || pwd.length()>20){
				setAttr("pwdMsg", "密码最短6位,最长20位！");				
				render("/user/reg.html");
				return;
			}
	        if (!confirm.equals(pwd)) {
				setAttr("confirmMsg", "两次密码不一致！");
				render("/user/reg.html");
				return;
			}
	     // 如果用户名已经被注册，提示错误信息
			if (user.findFirst("select * from en_user where username = ?", uname) != null) {
				setAttr("unameMsg", "该用户名已被注册");
				render("/user/reg.html");
				return;
			} else {
				// 使用工具包把当前时间转换成unix时间戳再转换成string类型
				// 注册时间，并作为用户密码md5加密的salt
				String reg_date = DateUtils.getNowTime();
				// 使用jfinal标识生成工具生成随机数作为密码的盐
				String pwds = MD5.GetMD5Code(pwd + reg_date);
				//使用session id生成工具生成用户媒体文件夹名称
				//String media_path = SessionIdKit.me().generate(getRequest());
				user.setUname(uname);
				user.setPwd(pwds);
				user.setEmail(email);
				user.setStatus(0);
				//用户角色 默认为VIP用户
				user.setType(0); 
				user.setRegDate(reg_date);				
				//用户媒体文件夹名称
				//user.setMediaPath(media_path);
				user.save();

				// 生成唯一标识
				String sessionId = SessionIdKit.me().generate(getRequest());
				// 设置服务器端session
				setSessionAttr(sessionId, user);
				// 设置用户端cookie
				setCookie("cuser", sessionId, 600);
				setAttr("user", user);
				login();
			}
	     
		}
		
		
		
		//Jfinal 公共库使用  验证码生成
		@ActionKey("/verifycode")
		public void verifycode(){
			render(new CaptchaRender());
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

