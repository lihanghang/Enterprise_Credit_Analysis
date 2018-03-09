package Interceptor;

import javax.servlet.http.HttpSession;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MyInterceptor implements Interceptor  {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		//拦截是否登录
		 HttpSession session = inv.getController().getSession(); 
		 if(session == null){  
	            inv.getController().redirect("/");  
	        }  
		  else{  
	            String nickname = (String) session.getAttribute("username");
	            if(nickname != null) {  
	            	inv.getController().render("/company/companyList.html");   
	            }  
	            else {  
	                inv.getController().redirect("/company/login.html");  
	            }  
	}

}
}
