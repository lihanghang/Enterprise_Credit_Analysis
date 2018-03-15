package demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class UserController extends Controller{
	
	static UserService service = new UserService();
	
    public void index(){
			
    	String company = getPara("name");
		setAttr("company_name", company);
		List<User> users = User.dao.find("select * from en_user");
		//setAttr("userPage", service.paginate(getParaToInt(1, 10), 10));
		setAttr("userlst", users);
		render("./userManager.html");				
	}		
	
	public void userUpdate(){
		
	
		index();
		
	}
	
	public void userDel(){
		
		 String companys = getPara("name");
		 System.out.print(companys);
		//service.deleteById(getParaToInt());
		//redirect("/user/index?name="+companys);			
		
	}

}
