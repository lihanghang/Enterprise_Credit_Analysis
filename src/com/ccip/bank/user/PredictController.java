package com.ccip.bank.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lpsolve.LpSolveException;
import manage.manage_org;
import strategy.risk;
import tec.riskTec;
import trainClassifier_Tree.creditQuality;

import com.ccip.bank.bean.ScienceInvest;
import com.ccip.bank.bean.businessBean;
import com.ccip.bank.bean.creditQualityBean;
import com.ccip.bank.bean.financialRiskBean;
import com.ccip.bank.model.Company;
import com.ccip.bank.model.InvestFactor;
import com.ccip.bank.model.InvestPotential;
import com.ccip.bank.model.Market;
import com.ccip.bank.service.CompanyService;
import com.ccip.bank.utils.javaDea.DataEnvelopmentAnalysis;
import com.ccip.bank.utils.javaDea.DeaRecord;
import com.ccip.bank.utils.javaDea.GetExcelInfo;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Page;
import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;
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
		
	static CompanyService service = new CompanyService();
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

	
	//update 0410
	public void creditQuality() throws MWException, IOException{
		
		//接受测试参数.【caution！！】需要在form表单中将字段name改为Bean名首字母小写.字段名，如本表单：creditQuality.Cost
		creditQualityBean paraBean = getBean(creditQualityBean.class);
		System.out.println(paraBean);
		//实例化信用评级模型对象
		creditQuality CQ = new creditQuality();
		String input = "D://java-project/enterpriseInfo/datasets/Data554.mat";
		//初始化1*6矩阵
		MWNumericArray test_data = MWNumericArray.newInstance
				(new int[]{1,6}, MWClassID.DOUBLE, MWComplexity.REAL);
		Object [] result = null;
		//组装投入数据为矩阵
		test_data.set(new int[]{1,1}, paraBean.getDebt_rate());
		test_data.set(new int[]{1,2}, paraBean.getInterest());
		test_data.set(new int[]{1,3}, paraBean.getInventoryTurn());
		test_data.set(new int[]{1,4}, paraBean.getFlowDebt());
		test_data.set(new int[]{1,5}, paraBean.getCost());
		test_data.set(new int[]{1,6}, paraBean.getOwnerEquity());						
		result = CQ.trainClassifier_Tree(3,input,test_data);
		//得到公司信用评级
		MWNumericArray cqNum   = (MWNumericArray)result[2];
		List lst = new ArrayList();
		lst.add(cqNum.getInt());				
		//读取mat文件
		MatFileReader read = new MatFileReader(input);
		MLArray mlArray=read.getMLArray("Data");//获取mat中Data矩阵变量的内容
		MLDouble d=(MLDouble)mlArray;
		HashMap<String,double[]> map1 = new HashMap<String,double[]>();
		double[][] matrix=(d.getArray());
		int len = matrix.length;
		double[] debt = new double[len];
		double[] interst = new double[len];
		double[] turn = new double[len];
		double[] rate = new double[len];
		double[] profit = new double[len];
		double[] owner = new double[len];	
		for(int i=0;i< len;i++){
			debt   [i] = matrix[i][0];	
			interst[i] = matrix[i][1];
			turn   [i] = matrix[i][2];	
			rate   [i] = matrix[i][3];
			profit [i] = matrix[i][4];	
			owner  [i] = matrix[i][5];
		}	
		map1.put("debt", debt);
		map1.put("interest", interst);
		map1.put("turn", turn);
		map1.put("rate", rate);
		map1.put("profit", profit);
		map1.put("owner", owner);
		setAttr("map",map1);
		setAttr("lst",lst);
		setAttr("para",paraBean);
		String matrixData = JsonKit.toJson(map1);
		renderJson(new String[]{"map","lst","para"});
	}
	
	//风险评估页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void fxpg(){

		render("fxpg.html");
	}
	//财务风险
	public void financial_risk_model() {
	 
		financialRiskBean paraBean = getBean(financialRiskBean.class);		
		renderJson("data",paraBean);
		
	}
	//0417风险等级评估模型算法
	public void fxpg_model(){
		
		 int num1 = getParaToInt("num1"); 
		 int num2 = getParaToInt("num2"); 
		 int num3 = getParaToInt("num3"); 		
		try {
			String input = "D://java-project/enterpriseInfo/datasets/fxpg/输入指标集excel模板.xls";
			risk str = new risk();
			Object[] result = null;
			result = str.strategy(1, input,num3, num1, num2);
			renderJson("result",result[0].toString());
						
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	//0417风险等级评估模型算法--技术专利
		public void jszl_model(){
			
			 int num1 = getParaToInt("num1"); 
			 int num2 = getParaToInt("num2"); 
			 int num3 = getParaToInt("num3"); 		
			try {
				String input = "D://java-project/enterpriseInfo/datasets/fxpg/输入指标集excel模板.xls";
				riskTec str = new riskTec();
				Object[] result = null;
				result = str.tec(1, input,num1, num2, num3);
				renderJson("tec",result[0].toString());
							
			} catch (MWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
	
		//0417风险等级评估模型算法--经营组织 update param at 20180502
		public void org_risk_model(){
			
			businessBean paraBean = getBean(businessBean.class);
			
			int num1 = getParaToInt("num1"); 
			int num2 = getParaToInt("num2"); 
			int num3 = getParaToInt("num3"); 		
			int num4 = getParaToInt("num4"); 
			int num5 = getParaToInt("num5"); 
			int num6 = getParaToInt("num6"); 	
			int num7 = getParaToInt("num7"); 
			double num8 = Double.parseDouble(getPara("num8"));  	
			try {
				String input = "D://java-project/enterpriseInfo/datasets/fxpg/输入指标集excel模板.xls";
				manage_org str = new manage_org();
				Object[] result = null;
				result = str.manage(2, input,num1, num2, num3,num4, num5, num6,num7, num8);
				setAttr("manage",result[1].toString());
				setAttr("org",result[0].toString());				
				renderJson(new String[]{"manage","org"});
									
					} catch (MWException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
		}
		
		
	//科研投入页面
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void kytr(){

		render("kytr.html");
	}
	
	//0405 实现 0425update java dea
	public void kytr_model() throws MWException{
		
		//接受测试参数
			ScienceInvest paraBean = getBean(ScienceInvest.class);
		//System.out.println(paraBean);
		//基于Java实现DEA算法
			Map<String, DeaRecord> records = new LinkedHashMap<>();	        
	        GetExcelInfo obj = new GetExcelInfo(); 
	        File file = new File("D://java-project/enterpriseInfo/datasets/zhibiao.xls");
	        records = obj.readExcel(file);	        
	        double []input = new double[4];
	        double []output= new double[6];
	        input[0] = paraBean.getSci_invest();
	        input[1] = paraBean.getSci_invest()/paraBean.getReceipt_num();
	        input[2] = paraBean.getEdu_num();
	        input[3] = paraBean.getWork_num();	        
	        output[0]= paraBean.getSoft_num();
	        output[1]= paraBean.getPatent_num();
	        output[2]= paraBean.getBrand_num();
	        output[3]= paraBean.getWorks_num();
	        output[4]= paraBean.getWeb_num();
	        output[5]= paraBean.getProfit_num();
	        records.put("new", new DeaRecord(output,input));
	        System.out.println(System.getProperty("java.library.path"));
	        DataEnvelopmentAnalysis dea = new DataEnvelopmentAnalysis();
	        Map<String, Double> results =null;
			try {
				results = dea.estimateEfficiency(records);
			} catch (LpSolveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			renderJson("ret",(new TreeMap<>(results)).get("new"));
//		research test = new research();			
//		//new int[]{11,2}代表矩阵为11行2列的矩阵
//				//MWClassID.DOUBLE代表矩阵中数为double类型，MWComplexity.REAL代表矩阵中是实数
//				//in 投入矩阵  out 产出矩阵
//				MWNumericArray in = MWNumericArray.newInstance
//								(new int[]{4,1}, MWClassID.DOUBLE, MWComplexity.REAL);
//				MWNumericArray out = MWNumericArray.newInstance
//						(new int[]{6,1}, MWClassID.DOUBLE, MWComplexity.REAL);
//				//组装投入数据为矩阵
//				in.set(new int[]{1,1}, paraBean.getSci_invest() );
//				in.set(new int[]{2,1}, (paraBean.getSci_invest()/paraBean.getReceipt_num()));
//				in.set(new int[]{3,1}, paraBean.getEdu_num());
//				in.set(new int[]{4,1}, paraBean.getWork_num());
//				//组装产出数据为矩阵
//				out.set(new int[]{1,1}, paraBean.getSoft_num());
//				out.set(new int[]{2,1}, paraBean.getPatent_num());	
//				out.set(new int[]{3,1}, paraBean.getBrand_num());
//				out.set(new int[]{4,1}, paraBean.getWorks_num());
//				out.set(new int[]{5,1}, paraBean.getWeb_num());
//				out.set(new int[]{6,1}, paraBean.getProfit_num());
//				//用于接收返回值
//				Object[] result = null;
//				//模型实例化
//				String  f_in  = "D://java-project/enterpriseInfo/datasets/zhibiao-input.xlsx";
//				String  f_out = "D://java-project/enterpriseInfo/datasets/zhibiao-output.xlsx";				
//				result = test.importFile(3,f_in,f_out,in,out);
//				MWNumericArray ccr   = (MWNumericArray)result[0];
//				MWNumericArray bcc   = (MWNumericArray)result[1];
//				MWNumericArray scale = (MWNumericArray)result[2];
//				List lst = new ArrayList();
//				lst.add(ccr.getFloat());
//				lst.add(bcc.getFloat());
//				lst.add(scale.getFloat());				
//				renderJson("ret",lst);
	}
	
	//贷后预警页面	
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void dhyj() {
		
		render("dhyj.html");
	}
	
	@Before(com.ccip.bank.interceptor.UserAuthInterceptor.class)
	public void dhyjContent() {
		String code = getPara("num");
		String cname = getPara("name");		
		setAttr("cname",cname);
		setAttr("code",code);
		render("dhyjContent.html");
	}
	
	public void renderPageForLayUI(Page<?> page){
        renderPageForLayUI(page,0,"");
    }
	/**
     * 按照layUI格式分页获取数据
     * @param page
     * @param code
     * @param message
     */
    public void renderPageForLayUI(Page<?> page,int code,String message){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", message);
        result.put("count", page.getTotalRow());
        result.put("data", page.getList());        
        super.renderJson(result);
    }
    
    //0428 基于layUI的分页实现
    public void getMethod_change(){
        int pageIndex = getParaToInt("page");
        int pageSize = getParaToInt("limit"); 
        String code = getPara("num");
        Page<Company> page = service.paginat_change(pageIndex, pageSize, code);
        renderPageForLayUI(page,0,"操作成功");
    }
    
    public void getMethod_lawsuit(){
        int pageIndex = getParaToInt("page");
        int pageSize = getParaToInt("limit"); 
        String code = getPara("num");
        Page<Company> pages = service.paginats(pageIndex, pageSize, code);
        renderPageForLayUI(pages,0,"操作成功");
    }
    
    //获取所有公司并分页
    public void getAllCompany() {
    	int pageIndexs = getParaToInt("page");
        int pageSizes  = getParaToInt("limit"); 
        Page<Company> page_all = service.paginats_all_company(pageIndexs, pageSizes);
        renderPageForLayUI(page_all,0,"操作成功");
    }
    
    
}
