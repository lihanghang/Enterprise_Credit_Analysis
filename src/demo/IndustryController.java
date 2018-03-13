package demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class IndustryController extends Controller{
	
	//static UserService service = new UserService();
    public void index(){
					
		render("invest.html");				
	}		
	
	

}
