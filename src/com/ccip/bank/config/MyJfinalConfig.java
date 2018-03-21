package com.ccip.bank.config;

import com.ccip.bank.model.User;
import com.ccip.bank.routes.AdminRoutes;
import com.ccip.bank.routes.FrontRoutes;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class MyJfinalConfig extends JFinalConfig {  
    public void configConstant(Constants me) {   
    	PropKit.use("a_little_config");
    	me.setDevMode(PropKit.getBoolean("devMode", false));
    }  
  
    @Override
	public void configRoute(Routes me) {
		//配置前端路由
		me.add(new FrontRoutes());
		//配置后端路由
		me.add(new AdminRoutes());
	}
     

    public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
    public void configPlugin(Plugins me) { 
    	
    		DruidPlugin druidPlugin = createDruidPlugin();
			me.add(druidPlugin);
			ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
    		arp.addMapping("en_user","id", User.class);	// 映射到用户表
    		me.add(arp);
    }  
  
    public void configInterceptor(Interceptors me) {  
    	
    	//me.add(new MyInterceptor());
    }  
    public void configHandler(Handlers me) {  
    }

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);
		me.addSharedFunction("/company/common/_layout.html");
		me.addSharedFunction("/company/common/_menu.html");
		me.addSharedFunction("/company/common/company_info.html");
		
	}  
}  
