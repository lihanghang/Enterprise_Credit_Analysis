package com.ccip.bank.user;

import java.util.List;

import DEA.research;

import com.ccip.bank.bean.ScienceInvest;
import com.ccip.bank.model.InvestFactor;
import com.ccip.bank.model.InvestPotential;
import com.ccip.bank.model.Market;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWComplexity;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
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
	
	//0405 实现
	public void kytr_model() throws MWException{
		
		//接受测试参数
		ScienceInvest paraBean = getBean(ScienceInvest.class);
		System.out.println(paraBean);
		research test = new research();
		//System.out.println(sci_invest);				
		//new int[]{11,2}代表矩阵为11行2列的矩阵
				//MWClassID.DOUBLE代表矩阵中数为double类型，MWComplexity.REAL代表矩阵中是实数
				//in 投入矩阵  out 产出矩阵
				MWNumericArray in = MWNumericArray.newInstance
								(new int[]{4,1}, MWClassID.DOUBLE, MWComplexity.REAL);
				MWNumericArray out = MWNumericArray.newInstance
						(new int[]{6,1}, MWClassID.DOUBLE, MWComplexity.REAL);
				//组装投入数据为矩阵
				in.set(new int[]{1,1}, paraBean.getSci_invest() );
				in.set(new int[]{2,1}, (paraBean.getSci_invest()/paraBean.getReceipt_num()));
				in.set(new int[]{3,1}, paraBean.getEdu_num());
				in.set(new int[]{4,1}, paraBean.getWork_num());
				//组装产出数据为矩阵
				out.set(new int[]{1,1}, paraBean.getSoft_num());
				out.set(new int[]{2,1}, paraBean.getPatent_num());	
				out.set(new int[]{3,1}, paraBean.getBrand_num());
				out.set(new int[]{4,1}, paraBean.getWorks_num());
				out.set(new int[]{5,1}, paraBean.getWeb_num());
				out.set(new int[]{6,1}, paraBean.getProfit_num());
				//用于接收返回值
				Object[] result = null;
				//模型实例化
				String  f_in  = "D://java-project/enterpriseInfo/datasets/zhibiao-input.xlsx";
				String  f_out = "D://java-project/enterpriseInfo/datasets/zhibiao-output.xlsx";				
				result = test.importFile(3,f_in,f_out,in,out);
				double scale = (double) result[2];
				setAttr("msg", result);
				setAttr("scale", scale);
				render("kytr.html");
		
	}
	
	
	
	
	
	
	//贷后预警页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void dhyj(){

		render("dhyj.html");
	}

	
}
