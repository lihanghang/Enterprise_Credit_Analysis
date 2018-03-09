package demo;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static final  User dao = new User().dao();

}
