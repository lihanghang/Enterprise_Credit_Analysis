package demo;


import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User>{
    /**
	 * 用户管理数据库操作
	 */
	private static final long serialVersionUID = 1L;
    public static final  User dao = new User().dao();
    
}
