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
	public static final Market dao = new Market(); //房地产财务数据0325
    public static final Market ci = new Market(); //合成指数数据模型0326
    public static final Market diffusion = new Market(); //扩散指数数据模型0326
	//获取所有财务数据
	public List<Market> getAllData(){
		return dao.find("select * from en_market order by id asc");
	}
	//获取合成指数数据
	public List<Market> getCi(){
		return ci.find("select * from en_ci order by id asc");
	}
	//获取扩散指数数据
	public List<Market> getDiffusionIndex(){
		return diffusion.find("select * from en_diffusion_index order by id asc");
	}
}
