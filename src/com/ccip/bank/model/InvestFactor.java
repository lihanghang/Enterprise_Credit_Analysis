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



public class InvestFactor extends Model<InvestFactor> {
	
	private static final long serialVersionUID = 1L;
	public static final InvestFactor dao = new InvestFactor(); //投资潜力指数
	
	//通过foreign key city join table en_market_city_factor
	public List<InvestFactor> getDatas(String city) {
		
		String sql = "select f.* from en_market_city c inner join en_market_city_factor f on c.城市 = f.城市  where c.城市=?";
		return InvestFactor.dao.find(sql, city);
		
	}
}



