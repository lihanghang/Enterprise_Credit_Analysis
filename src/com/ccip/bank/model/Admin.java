package com.ccip.bank.model;

import java.util.List;
import com.jfinal.plugin.activerecord.Model;

/**
 * 
 * @author Mason
 * 管理员数据模型操作
 */


public class Admin extends Model<Admin>{
    		
	
	private static final long serialVersionUID = 1L;
	public static final Admin dao = new Admin();
   
	//获取所有admin
	public List<Admin> getAllAdmin(){
		return dao.find("select * from admin order by id desc");
	}
	
	public List<Admin> getAllSuAdmin(){
		return dao.find("select * from admin where type = ?  order by id desc",0);
	}
}
