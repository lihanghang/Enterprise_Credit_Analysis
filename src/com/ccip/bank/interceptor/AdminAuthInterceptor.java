package com.ccip.bank.interceptor;


import com.ccip.bank.model.Admin;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
/**
 * 
 * @author Mason
 * 系统管理员操作的权限拦截器
 *
 */
public class AdminAuthInterceptor implements Interceptor  {

	@Override
	public void intercept(Invocation inv) {

Controller controller = inv.getController();
		
		Admin admin = controller.getSessionAttr(controller.getCookie("cadmin"));
		
		if (admin == null || inv.getMethodName().equals("login")) {
			//controller.setAttr("system", IndexService.getSysConfig());
			controller.render("login.html");
		}else{
			inv.invoke();
		}

	}
	
}
