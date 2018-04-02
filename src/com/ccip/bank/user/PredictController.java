package com.ccip.bank.user;

import java.util.List;

import com.ccip.bank.model.InvestFactor;
import com.ccip.bank.model.InvestPotential;
import com.ccip.bank.model.Market;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
/**
 * 
 * @author Mason
 * @data 20180323
 * 5大模型算法实现及数据操作
 */

public class PredictController extends Controller{
	
//	static UserService service = new UserService();
	@ActionKey("/predict")
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
    public void index(){
		
			
	}		
	//异步请求加载数据库：行业动态最终指标数据
	public void marketData(){
		
		List<Market> data = Market.dao.getAllData();
		String json = JsonKit.toJson(data);
		renderJson(json);
				
	}
	
	//房地产合成指数数据0326
	public void getCI(){
		
		List<Market> cIdata = Market.ci.getCi();
		String cJson = JsonKit.toJson(cIdata);
		renderJson(cJson);
	}

	//房地产扩散指数数据0326
	public void getDiffIndex(){
		
		List<Market> diffIdata = Market.diffusion.getDiffusionIndex();		
		String diffJson = JsonKit.toJson(diffIdata);
		System.out.println(diffJson);
		renderJson(diffJson);
	}
	
	//房地产风险预警数据0328
		public void getRiskPreAlarming(){
			
			List<Market> Riskdata = Market.ci.getRiskPreAlarming();			
			String RiskJson = JsonKit.toJson(Riskdata);			
			//System.out.println(RiskJson);
			renderJson(RiskJson);
		}
		
		//获取区域数据
		public void getZone() {
			
			List<InvestPotential> get_zone = InvestPotential.dao.getZone();
			renderJson(JsonKit.toJson(get_zone));//地区数据
			
		}
		public void getProvince() {
			String zone = getPara("zone");
			List<InvestPotential> get_province = InvestPotential.dao.getProvince(zone);
			renderJson(JsonKit.toJson(get_province));
			
		}
		public void getCity() {
			String province = getPara("province");
			List<InvestPotential> get_city = InvestPotential.dao.getCity(province);
			renderJson(JsonKit.toJson(get_city));
			
		}
		public void getFactorData() {
			String city = getPara("city");
			List<InvestFactor> get_factor = InvestFactor.dao.getDatas(city);
			renderJson(JsonKit.toJson(get_factor));
			
		}
		//按发展速度划分
		//获取区域数据
		public void getDevLevel() {
					
			List<InvestPotential> get_level_zone = InvestPotential.dao.devlopLevel();
			renderJson(JsonKit.toJson(get_level_zone));//地区数据
					
		}
		public void getCitys() {
			String level = getPara("level");
			List<InvestPotential> get_citys = InvestPotential.dao.getCitys(level);
			renderJson(JsonKit.toJson(get_citys));
			
		}
	//行业动态页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void hydt(){

		render("hydt.html");
	}
	
	//信用评级页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void xypj(){

		render("xypj.html");
	}

	//风险评估页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void fxpg(){

		render("fxpg.html");
	}

	//科研投入页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void kytr(){

		render("kytr.html");
	}
	
	//贷后预警页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void dhyj(){

		render("dhyj.html");
	}

}
