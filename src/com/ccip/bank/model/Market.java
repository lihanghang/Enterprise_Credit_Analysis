package com.ccip.bank.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * 
 * @author Mason
 * 管理员数据模型操作
 */


public class Market extends Model<Market>{
    		
	
	private static final long serialVersionUID = 1L;
	public static final Market dao = new Market();
    

	//获取所有admin
	public List<Market> getAllData(){
		return dao.find("select * from en_market order by id asc");
	}
	
	
}
