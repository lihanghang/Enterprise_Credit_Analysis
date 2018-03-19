package com.ccip.bank.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


public class User extends Model<User>{
    
	/**
	 * 用户管理数据库操作
	 */
	
	private static final long serialVersionUID = 1L;
    public static final  User dao = new User().dao();
    
    // Jfinal提供分页
    public Page<User> paginate(int pageNumber,int pageSize){
        
        return paginate(pageNumber, pageSize, "select *", "from en_user order by id asc");
    }
    public java.lang.String getPwd() {
		return get("pwd");
	}
}
