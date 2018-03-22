package com.ccip.bank.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;


public class PredictController extends Controller{
	
//	static UserService service = new UserService();
	
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
    public void index(){
		
		render("predict.html");		
	}		
	
	

}
