package com.ccip.bank.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

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
    public static final Market industry = new Market(); //扩散指数数据模型0326
	//获取所有财务数据
	public List<Market> getAllData(){
		return dao.find("select * from en_market order by id asc");
	}
	//获取合成指数数据
	public List<Market> getCi(int type){
		return ci.find("select * from en_hc_yj  where type = ?", type);
	}
	//获取扩散指数数据
	public List<Market> getDiffusionIndex(int type){
		return diffusion.find("select * from en_diffusion_index where type = ?", type);
	}
	
	//获取风险预警数据0328
	public List<Market> getRiskPreAlarming(int type){
		return ci.find("select year,领先指数_Y,偏冷线,偏热线,适度上限,适度下限  from en_hc_yj where type = ?", type);
	}
	
	//处理制造业和信息技术业的财务数据0529
	public List<Market> getManufactureData(){
		return industry.find("select year,净资产收益率,总资产报酬率,销售利润率,盈余现金保障倍数	from en_manufacture_financial");
	}
	
	
}
