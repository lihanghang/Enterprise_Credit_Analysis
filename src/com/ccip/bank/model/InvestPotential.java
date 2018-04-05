/**
 * 
 */
package com.ccip.bank.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
/**
 * @date 2018年4月2日 上午11:12:58 
 * @author Mason
 * 投资潜力数据模型
 */
public class InvestPotential extends Model<InvestPotential> {
	
	private static final long serialVersionUID = 1L;
	public static final InvestPotential dao = new InvestPotential(); //投资潜力指数
	
	public List<InvestPotential> getZone() {
		
		return dao.find("select distinct(地区) from en_market_city");
	}
	public List<InvestPotential> getProvince(String zone) {
		
		return dao.find("select distinct(省份) from en_market_city where 地区 = ?", zone);
	}
	
	public List<InvestPotential> getCity(String province) {
		
		return dao.find("select distinct(城市) from en_market_city where 省份 = ?", province);
	}
	
	public List<InvestPotential> devlopLevel() {
		
		return dao.find("select distinct(发展程度) from en_market_city");
	}
	
	public List<InvestPotential> getCitys(String level) {
		
		return dao.find("select distinct(城市) from en_market_city where 发展程度 = ?", level);
	}
}





