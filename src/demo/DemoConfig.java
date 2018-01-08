package demo;



import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.ModelRecordElResolver;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;


public class DemoConfig extends JFinalConfig {  
    public void configConstant(Constants me) {   
        me.setViewType(ViewType.JSP);
        loadPropertyFile("a_little_config");
        me.setDevMode(getPropertyToBoolean("devMode", false));
    }  
  
    public void configRoute(Routes me) { 
    	
    	me.add("/",IndexController.class);
    	me.add("/company", CompanyController.class,"/company"); 
    	
    }  
    public void configPlugin(Plugins me) { 
    	
    			// 配置C3p0数据库连接池插件
    			C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
    			me.add(c3p0Plugin);    			
    			// 配置ActiveRecord插件
    			
    			ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
    			me.add(arp);
    			arp.setShowSql(true);
    			arp.addMapping("company_news_data","id", Company.class);	// 映射company_news_data 表到 Company模型
    }  
  
    public void configInterceptor(Interceptors me) {  
    }  
    public void configHandler(Handlers me) {  
    }

	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub

		
	}  
}  
