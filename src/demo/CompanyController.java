package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class CompanyController extends Controller {	
	
			//定义前缀常量
		String prefix="PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+ 
		     "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#>"+ 
		     "PREFIX owl:<http://www.w3.org/2002/07/owl#>"+ 
		     "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"+ 
		     "PREFIX base:<http://ccip.ucas.ac.cn/resource#>"+ 
		     "PREFIX enterprise:<http://ccip.ucas.ac.cn/ontology/company#>";
	    String filePath = "A://work/project_finance/basic_data/rdf_data/100/test20/";	    
		OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		
		public void index() throws BiffException, IOException{
			String company = getPara("name","UTF-8");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(new Date());
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/123.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(2);
		    int num = 1;
		    int col = 4;
		    //封装前台展示的数据
		    ArrayList<String> data = new ArrayList<String> ();
		    while(num<=766)
			{	String info = "";
				if(sheet.getCell(0, num).getContents().equals(company)){
					while(col<=15){
						//System.out.print(sheet.getCell(col, num).getContents());
						info = sheet.getCell(col, num).getContents();
						if(info.length()==0 || info == null)
							info = "暂未统计";
						data.add(info);
						col++;
					}
					
				}
				num++;
			} 	
		    //System.out.println("**************"+data);
			
			
			
//			ontModel.read(filePath + company +".rdf");	
//			String queryString = "SELECT ?property ?value"
//					+" WHERE " +
//					"{ base:"+ company  +"的企业概况 ?property    ?value}";
//			Query query = QueryFactory.create(prefix + queryString);
//			QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
//			ResultSet rs = qe.execSelect();
//			Map<String, String> params=new HashMap<String, String> ();
//			while(rs.hasNext()){
//			QuerySolution soln = rs.nextSolution() ;
//			RDFNode key = soln.get("property");
//			RDFNode value = soln.get("value");
//			String keys = key.toString().split("#")[1];
//			params.put(keys, value.toString());
//			}	
	        setAttr("currentDate",time);
			setAttr("company_name",company);
			//System.out.print(data);
			setAttr("data",data);		
			render("./basicInfo/index.html");					
		}
		
		public void companyList(){
			String company = getPara("keyword");
			render("companyList.html");
			System.out.print(company);
		}
		public void taxInfo() throws BiffException, IOException{
			
			String company = getPara("name");		
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/公司信息税务负债偿还借款人资信1.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int num = 1;
		    int col = 1;
		    
		    //封装前台展示的数据
		    ArrayList<String> data = new ArrayList<String> ();
		    while(num<=766)
			{
				if(sheet.getCell(0, num).getContents().equals(company)){
					while(col<=9){
						String info = sheet.getCell(col, num).getContents();
						if(info.length()==0)
							info = "未统计";									
						data.add(info);
						col++;
					}
					
				}
				num++;
			} 	   
		  
		    setAttr("company_name",company);
			setAttr("data",data);
			render("./basicInfo/swxx.html");
			
		}
		
		
		public void taxGrade() throws BiffException, IOException{
			String company = getPara("name");		
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/公司信息税务负债偿还借款人资信1.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int row = 1;		    
		    //税务评级数据处理
		    HashMap hm = new HashMap();	    
		    while(row<=745)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 24;
				if(sheet.getCell(24, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=29){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						//System.out.print(info+"+++++++++++++++");
						
						taxData.add(info);
						
						Pcol++;
					}
					
					hm.put(sheet.getCell(25, row).getContents(), taxData);
						
				}
				
				row++;
				
			} 
		  
		    String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
		    renderJson(json);
		    //System.out.print(json);
		}
		
		//股东构成
		public void shareHold(){
			
			String name = getPara("name","UTF-8");
	/*		System.out.print(company);
		ontModel.read(filePath + company + ".rdf");				
		String queryString = "SELECT ?name ?money "
				+" WHERE{ " +
				"{?a    enterprise:股东名称     ?name."
				+ "?a enterprise:货币  ?money}"
				+"}";				
			Query query = QueryFactory.create(prefix + queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
			ResultSet rs = qe.execSelect();
			Map<String, String> map = new HashMap<String, String>();
			while(rs.hasNext()){
				QuerySolution soln = rs.nextSolution();
				RDFNode key = soln.get("name");			
				RDFNode value = soln.get("money");				
				String keys = key.toString();
				String values = value.toString().split("万元")[0];			
				map.put( keys, values);			
				}
			String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用				
			renderJson(json);*/
			setAttr("company_name", name);
			render("./basicInfo/gdxx.html");
				
		}
		//股东数据0117
		public void shareHoldData() throws BiffException, IOException{
			String company = getPara("name");		
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/123.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(3);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=4839)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=3){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(1, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
		    String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
		    renderJson(json);
		    //System.out.print(json);
			
		}
		public void Ehtml(){
			
			String company = getPara("name");
			setAttr("company_name", company);
			render("./basicInfo/qygx.html");
		}
		//position update Erelate企业关系--分支机构数据0117@ hanghang
		public void  Erelate() throws BiffException, IOException{
			String company = getPara("name","UTF-8");
//			ontModel.read(filePath + company + ".rdf");				
//			String queryString = "SELECT ?position"
//					+" WHERE{ " +
//					"{?a enterprise:岗位构成   ?position}"+"}";					
//				Query query = QueryFactory.create(prefix + queryString);
//				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
//				ResultSet rs = qe.execSelect();
//				Map<String, String> map = new HashMap<String, String>();
//				try { 
//				while(rs.hasNext()){
//					QuerySolution soln = rs.nextSolution();
//					RDFNode position = soln.get("position");				
//					String positions = position.toString();		
//					int len = positions.split(",").length;
//					for(int i= 0; i<len; i++){
//					 String a =	positions.split(",")[i];
//					 String[] data = a.split(":");
//					 map.put(data[0], data[1]);
//							}
//					}
//					}
//				catch (Exception e){
//					
//				}
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/123.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(1);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=238)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=4){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(1, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json);					
			}
		public void invest(){
			
			String company = getPara("name");
			setAttr("company_name", company);			
			render("./basicInfo/dwtz.html");
		}
		public void investData() throws IOException, BiffException{
			
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/123.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=2579)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=7){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未公开";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(1, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json);	
			
			
			
			
			
		}
		
	  //risk
		public void riskHtml()
		{
			String company = getPara("name");
			setAttr("company_name", company);		
			render("./basicInfo/risk.html");
			
		}
		
		//法律诉讼
		public void riskData() throws IOException, BiffException
		{
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/展示数据/经营-司法风险/司法风险.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=2818)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=5){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未公开";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(2, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json);
				
			
			
		}
		//行政处罚
		public void admniData() throws IOException, BiffException
		{
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/展示数据/经营-司法风险/经营风险.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(1);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=131)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=4){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未公开";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(2, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String admnijson = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(admnijson);
				renderJson(admnijson);
				
			
			
		}
		
		public void study(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?study"
					+" WHERE{ " +
					"{?a enterprise:学历构成   ?study}"+"}";					
				Query query = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs = qe.execSelect();
				Map<String, String> map = new HashMap<String, String>();
				try { 
				while(rs.hasNext()){
					QuerySolution soln = rs.nextSolution();
					RDFNode study = soln.get("study");				
					String studys = study.toString();		
					int len = studys.split(",").length;
					for(int i= 0; i<len; i++){
					 String a =	studys.split(",")[i];
					 String[] data = a.split(":");
					 map.put(data[0], data[1]);
							}
					}
				}
				catch (Exception e){
					
				}
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用				
				renderJson(json);					
			}	
		public void age(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?age"
					+" WHERE{ " +
					"{?a enterprise:年龄构成   ?age}"+"}";					
				Query query = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs = qe.execSelect();
				Map<String, String> map = new HashMap<String, String>();
				try { 
				while(rs.hasNext()){
					QuerySolution soln = rs.nextSolution();
					RDFNode age = soln.get("age");				
					String ages = age.toString();		
					int len = ages.split(",").length;
					for(int i= 0; i<len; i++){
					 String a =	ages.split(",")[i];
					 String[] data = a.split(":");
					 map.put(data[0], data[1]);
							}
					}
				}
				catch (Exception e){
					
				}
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json+"#########");
				renderJson(json);								
			}	
			
		public void relate(){
			//企业关系构成	
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");			
			String queryString = "SELECT ?invest_name ?relate_name ?sub_name"
					+" WHERE{ " +
					"{?a enterprise:被投资单位名称  	?invest_name}"+
					"}";	
			Query query = QueryFactory.create(prefix + queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
			ResultSet rs = qe.execSelect();
			List<Map<String, Object>> relate = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			ArrayList<String>  name = new ArrayList<String> ();
			while(rs.hasNext()){
				QuerySolution soln = rs.nextSolution();
				RDFNode names = soln.get("invest_name");				
				String company_name= names.toString();
				name.add(company_name);
				map.put("name", company_name);
				relate.add(map);
			}
				System.out.print(map);
				setAttr("name",company);
				render("company_relate.jsp");
		}
		
		public void credit(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");			
			String queryString = "SELECT ?property ?value"
					+" WHERE{ " +
					"{ base:"+company+"税务信息  ?property    ?value.}"
					+"UNION"+ "{base:"+company+"借贷人资信情况 ?property    ?value }" +"}";
			Query query = QueryFactory.create(prefix + queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
			ResultSet rs = qe.execSelect();
			Map<String, String> params=new HashMap<String, String> ();
			while(rs.hasNext()){
			QuerySolution soln = rs.nextSolution() ;
			RDFNode key = soln.get("property");
			RDFNode value = soln.get("value");
			String keys = key.toString().split("#")[1];
			params.put(keys, value.toString());
			}
			setAttr("name",company);
			setAttr("data", params);										
			render("credit.jsp");
			qe.close();
		}
		
		public void status(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");			
			String queryString = "SELECT ?property ?value"
					+" WHERE{ " +
					"{ base:"+company+"所处行业政策及需求  ?property    ?value.}"
					+"UNION"+ "{base:"+company+"所处行业竞争 ?property    ?value }" +"}";
			Query query = QueryFactory.create(prefix + queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
			ResultSet rs = qe.execSelect();
			Map<String, String> params=new HashMap<String, String> ();
			while(rs.hasNext()){
			QuerySolution soln = rs.nextSolution() ;
			RDFNode key = soln.get("property");
			RDFNode value = soln.get("value");
			String keys = key.toString().split("#")[1];
			params.put(keys, value.toString());
			}
			qe.close();
			String name = getPara("name");
			setAttr("data", params);
			setAttr("name",name);
			render("business_status.jsp");
		}
		
		public void develop(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");			
			String queryString = "SELECT ?property ?value"
					+" WHERE{ " +
					"{ base:"+company+"主营业务（产品）?property    ?value.}"
					+"UNION"+ "{base:"+company+"外部经营环境 ?property    ?value. }"+"UNION"+ "{base:"+company+"主要客户及经营情况  ?property    ?value }" +"}";
			Query query = 	QueryFactory.create(prefix + queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
			ResultSet rs = qe.execSelect();
			Map<String, String> params=new HashMap<String, String> ();
			while(rs.hasNext()){
			QuerySolution soln = rs.nextSolution() ;
			RDFNode key = soln.get("property");
			RDFNode value = soln.get("value");
			String keys = key.toString().split("#")[1];
			params.put(keys, value.toString());
			}
			qe.close();
			//System.out.print(params);
			setAttr("data", params);
			String name = getPara("name");
			setAttr("name",name);
			render("company_develop.jsp");
		}
		
		
		public void basic_financial(){
			String name = getPara("name");
			setAttr("name",name);
			render("basic_financial.jsp");
				
		}
		
		
		public void financial() throws BiffException, IOException{
			String company = getPara("name");
		  
/*			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?count ?ower ?debt ?interest  ?income ?EBITDA"
					+" WHERE{ " +
					"{?a enterprise:资产总额   ?count."
					+"?a enterprise:所有者权益   ?ower."
					+ "?a enterprise:负债总额   ?debt."
					+ "?a enterprise:带息负债   ?interest."
					+ "?a enterprise:营业收入   ?income."
					+ "?a enterprise:EBITDA   ?EBITDA }"
					+"}";			
				Query query = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs = qe.execSelect();
				ArrayList<String>  str_count = new ArrayList<String> ();
				ArrayList<String>  str_ower = new ArrayList<String> ();
				ArrayList<String>  str_debt = new ArrayList<String> ();
				ArrayList<String>  str_interest = new ArrayList<String> ();
				ArrayList<String>  str_income = new ArrayList<String> ();
				ArrayList<String>  str_EBITDA = new ArrayList<String> ();								
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String count = qs.get("count").toString().split("万元")[0];
			          String ower = qs.get("ower").toString().split("万元")[0];
			          String debt = qs.get("debt").toString().split("万元")[0];
			          String interest = qs.get("interest").toString().split("万元")[0];
			          String income = qs.get("income").toString().split("万元")[0];
			          String EBITDA = qs.get("EBITDA").toString().split("万元")[0];
			          str_count.add(count);
			          str_ower.add(ower);
			          str_debt.add(debt);
			          str_interest.add(interest);
			          str_income.add(income);
			          str_EBITDA.add(EBITDA);
			        } 
			        map.put("count", str_count);
			        map.put("ower", str_ower);
			        map.put("debt", str_debt);
			        map.put("interest", str_interest);
			        map.put("income", str_income);
			        map.put("EBITDA", str_EBITDA);							
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				renderJson(json );*/
		    	
				setAttr("company_name", company);
				render("financial.html");
		}
		//财务报表展示
		public void financialData() throws BiffException, IOException{
			
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/financial.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(1);
		    int row = 2;
		    int col = 7;
		    int year = 1;
		    Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>(); 
		    ArrayList<String> colData = new ArrayList<String> ();
		    while(col <=146){
		    	
		    	String col_Name = sheet.getCell(col, 1).getContents();
		    	colData.add(col_Name);
		    	col++;
		    }		    
		    //2013/2014/2015 37 37 34 32
		    ArrayList<String> taxData1 = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    ArrayList<String> taxData2 = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    ArrayList<String> taxData3 = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    while(row<=2083)
			{	
		    	
		    	int Pcol = 7;
				if(sheet.getCell(1, row).getContents().trim().equals(company) ){
				 while(year<=2){
					while(Pcol<=146){
						
						String info1 = sheet.getCell(Pcol, row).getContents();
						String info2 = sheet.getCell(Pcol, row+1).getContents();
						String info3 = sheet.getCell(Pcol, row+2).getContents();
						taxData1.add(info1);
						taxData2.add(info2);	
						taxData3.add(info3);	
						Pcol++;
					}
					year++;
				 }
				}				
				row = row+3;				
			} 
		    	map.put("key", colData);
		    	map.put("2013", taxData1);
		    	map.put("2014", taxData2);
		    	map.put("2015", taxData3);		    	
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				System.out.println("test" + json);
				setAttr("DataList", colData);
				renderJson(json);
		}
		
		
		public void knowRight()
		{
			
			String company = getPara("name");
			setAttr("company_name", company);
			render("./development/zscq.html");
		}
		public void Iproperty() throws BiffException, IOException{
			
			
			
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/知识产权.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=13520)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=5){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未公开";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(3, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String markjson = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				System.out.print(markjson);
				renderJson(markjson);
			
			
			
			}
public void zhuanli() throws BiffException, IOException{
			
			
			
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/知识产权.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(1);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=25671)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=4){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未公开";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(2, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String ZLjson = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				System.out.print(ZLjson);
				renderJson(ZLjson);
			
			
			
			}
public void softWare() throws BiffException, IOException{
	
	
	
	String company = getPara("name");
	String filePath = "A://work/project_finance/basic_data/excel_data_finance/知识产权.xls";
	Workbook rwb = null;        
    FileInputStream stream = new FileInputStream(filePath);
	rwb = Workbook.getWorkbook(stream);
    Sheet sheet = rwb.getSheet(2);
    int row = 1;		    
    //股东数据
    HashMap hm = new HashMap();	    
    while(row<=15245)
	{	
    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
    	int Pcol = 1;
		if(sheet.getCell(0, row).getContents().equals(company)){
			//System.out.print(row);
			while(Pcol<=5){
				
				String info = sheet.getCell(Pcol, row).getContents();	
				if(info.length() == 0 || info.equals(" "))
					info = "未公开";
				//System.out.print(info+"+++++++++++++++");						
				taxData.add(info);						
				Pcol++;
			}					
			hm.put(sheet.getCell(4, row).getContents(), taxData);						
		}				
		row++;				
	} 		  
		String SFjson = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
		System.out.print("数量"+hm.size());
		renderJson(SFjson);
	
	
	
	}
public void book() throws BiffException, IOException{
	
	
	
	String company = getPara("name");
	String filePath = "A://work/project_finance/basic_data/excel_data_finance/知识产权.xls";
	Workbook rwb = null;        
    FileInputStream stream = new FileInputStream(filePath);
	rwb = Workbook.getWorkbook(stream);
    Sheet sheet = rwb.getSheet(3);
    int row = 1;		    
    //股东数据
    HashMap hm = new HashMap();	    
    while(row<=140)
	{	
    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
    	int Pcol = 1;
		if(sheet.getCell(0, row).getContents().equals(company)){
			//System.out.print(row);
			while(Pcol<=6){
				
				String info = sheet.getCell(Pcol, row).getContents();	
				if(info.length() == 0 || info.equals(" "))
					info = "未公开";
				//System.out.print(info+"+++++++++++++++");						
				taxData.add(info);						
				Pcol++;
			}					
			hm.put(sheet.getCell(2, row).getContents(), taxData);						
		}				
		row++;				
	} 		  
		String Bjson = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
		System.out.print(Bjson);
		renderJson(Bjson);
	
	
	
	}
public void  web() throws BiffException, IOException{
	
	
	
	String company = getPara("name");
	String filePath = "A://work/project_finance/basic_data/excel_data_finance/知识产权.xls";
	Workbook rwb = null;        
    FileInputStream stream = new FileInputStream(filePath);
	rwb = Workbook.getWorkbook(stream);
    Sheet sheet = rwb.getSheet(4);
    int row = 1;		    
    //股东数据
    HashMap hm = new HashMap();	    
    while(row<=2948)
	{	
    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
    	int Pcol = 1;
		if(sheet.getCell(0, row).getContents().equals(company)){
			//System.out.print(row);
			while(Pcol<=7){
				
				String info = sheet.getCell(Pcol, row).getContents();	
				if(info.length() == 0 || info.equals(" "))
					info = "未公开";
				//System.out.print(info+"+++++++++++++++");						
				taxData.add(info);						
				Pcol++;
			}					
			hm.put(sheet.getCell(4, row).getContents(), taxData);						
		}				
		row++;				
	} 		  
		String Wjson = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
		System.out.print(Wjson);
		renderJson(Wjson);
	
	
	
	}
		public void product(){
					String company = getPara("name");
					setAttr("company_name", company);
					render("./development/product.html");
			}

		public void productData() throws BiffException, IOException{
			
			
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/所有爬取数据/经营状况/经营状况-产品信息.xls";
			Workbook rwb = null;        
		    FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=1037)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=4){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未公开";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(1, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				System.out.print(json);
				renderJson(json);
			
			
			}
		public void business(){
			String company = getPara("name");
			setAttr("company_name", company);
			render("./development/business.html");
		}
		public void businessData() throws BiffException, IOException{
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/所有爬取数据/企业发展/企业发展-企业业务.xls";
			Workbook rwb = null;        
		    FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=430)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=3){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未公开";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(1, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				System.out.print(json);
				renderJson(json);
		}
		public void finance(){
			String company = getPara("name");
			setAttr("company_name", company);
			render("./development/finance.html");
		}
		public void financeData() throws BiffException, IOException{
			String company = getPara("name");
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/所有爬取数据/企业发展/企业发展-融资历史.xls";
			Workbook rwb = null;        
		    FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(0);
		    int row = 1;		    
		    //股东数据
		    HashMap hm = new HashMap();	    
		    while(row<=409)
			{	
		    	ArrayList<String> taxData = new ArrayList<String> ();//每次创建一个新的字符串数组保存评级信息
		    	int Pcol = 1;
				if(sheet.getCell(0, row).getContents().equals(company)){
					//System.out.print(row);
					while(Pcol<=7){
						
						String info = sheet.getCell(Pcol, row).getContents();	
						if(info.length() == 0 || info.equals(" "))
							info = "未披露";
						//System.out.print(info+"+++++++++++++++");						
						taxData.add(info);						
						Pcol++;
					}					
					hm.put(sheet.getCell(1, row).getContents(), taxData);						
				}				
				row++;				
			} 		  
				String json = JsonKit.toJson(hm); //封装为JSON数据格式，提供至前台使用	
				System.out.print(json);
				renderJson(json);
		}
	
		public void creditPredict(){
			
			String company = getPara("name");
			setAttr("company_name", company);
			render("creditPre.html");
			
		}
		public void warning(){
			
			
			String company = getPara("name");
			setAttr("company_name", company);
			render("warning.html");
			
		}
		public void industry(){
	
	
			String company = getPara("name");
			setAttr("company_name", company);
			render("industry.html");
	
		}
		public void RD(){
	
			String company = getPara("name");
			setAttr("company_name", company);
			render("RD.html");
	
		}
		public void financeRiskPredict(){
			
			String company = getPara("name");
			setAttr("company_name", company);
			render("jrfx.html");
	
		}
		
		public void operation(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?count_turn  ?income_turn ?inventory_turn"
					+" WHERE{ " +
					"{?a enterprise:总资产周转次数   ?count_turn."
					+"?a enterprise:应收账款周转次数   ?income_turn."
					+ "?a enterprise:存货周转次数  ?inventory_turn.}"
					+"}";			
				Query query = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs = qe.execSelect();
				ArrayList<String>  count_turn = new ArrayList<String> ();
				ArrayList<String>  income_turn = new ArrayList<String> ();
				ArrayList<String>  inventory_turn = new ArrayList<String> ();
							
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String  count_turns = qs.get("count_turn").toString().split("次")[0];
			          String income_turns = qs.get("income_turn").toString().split("次")[0];
			          String inventory_turns = qs.get("inventory_turn").toString().split("次")[0];
			          count_turn.add(count_turns);
			          income_turn.add(income_turns);
			          inventory_turn.add(inventory_turns);

			        } 
			        map.put("count_turn", count_turn);
			        map.put("income_turn", income_turn);
			        map.put("inventory_turn",inventory_turn);							
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json );
		}
		
		
		public void profit(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?profit  ?pay ?roe"
					+" WHERE{ " +
					"{?a enterprise:总资本盈利率  ?profit."
					+"?a enterprise:总资产报酬率   ?pay."
					+"?a enterprise:净资产收益率  ?roe.}"
					+"}";			
				Query query = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs = qe.execSelect();
				ArrayList<String>  profit = new ArrayList<String> ();
				ArrayList<String>  pay = new ArrayList<String> ();
				ArrayList<String>  roe = new ArrayList<String> ();
							
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String profits = qs.get("profit").toString().split("%")[0];
			          String pays = qs.get("pay").toString().split("%")[0];
			          String roes = qs.get("roe").toString().split("%")[0];
			          System.out.print(profits);
			          profit.add(profits);
			          pay.add(pays);
			          roe.add(roes);

			        } 
			        map.put("profit",profit);
			        map.put("pay", pay);
			        map.put("roe",roe);							
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				renderJson(json );
		}
		
		
		public void debt(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?CurrentRatio  ?QuickRatio ?debtAssetsRatio"
					+" WHERE{ " +
					"{?a enterprise:流动比率  ?CurrentRatio."
					+"?a enterprise:速动比率   ?QuickRatio."
					+"?a enterprise:资产负债率  ?debtAssetsRatio.}"
					+"}";			
				Query query = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs = qe.execSelect();
				ArrayList<String>  CurrentRatio = new ArrayList<String> ();
				ArrayList<String>  QuickRatio = new ArrayList<String> ();
				ArrayList<String>  debtAssetsRatio = new ArrayList<String> ();
							
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String CurrentRatios = qs.get("CurrentRatio").toString().split("%")[0];
			          String QuickRatios = qs.get("QuickRatio").toString().split("%")[0];
			          String debtAssetsRatios = qs.get("debtAssetsRatio").toString().split("%")[0];
			          CurrentRatio.add(CurrentRatios);
			          QuickRatio.add(QuickRatios);
			          debtAssetsRatio.add(debtAssetsRatios);

			        } 
			    map.put("CurrentRatio",CurrentRatio);
			    map.put("QuickRatio", QuickRatio);
			    map.put("debtAssetsRatio",debtAssetsRatio);							
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				renderJson(json );
		}
		
		
		public void otherFinancial(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?increaseRate  ?profitsCost ?cashRatio ?cashRecovery"
					+" WHERE{ " +
					"{?a enterprise:营业收入增长率或EBITDA  ?increaseRate."
					+"?a enterprise:成本费用利润率   ?profitsCost."
					+"?a enterprise:现金流动负债比率或EBITDA  ?cashRatio."
					+ "?a enterprise:资产现金回收率  ?cashRecovery.}"
					+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> increaseRate  = new ArrayList<String> ();
				ArrayList<String>  profitsCost  = new ArrayList<String> ();
				ArrayList<String>  cashRatio    = new ArrayList<String> ();
				ArrayList<String>  cashRecovery = new ArrayList<String> ();							
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String increaseRates = qs.get("increaseRate").toString().split("%")[0];
			          String profitsCosts = qs.get("profitsCost").toString().split("%")[0];
			          String cashRatios = qs.get("cashRatio").toString().split("%")[0];
			          String cashRecoverys = qs.get("cashRecovery").toString().split("%")[0];
			          increaseRate.add(increaseRates);
			          profitsCost.add(profitsCosts);
			          cashRatio.add(cashRatios);
			          cashRecovery.add( cashRecoverys);

			        } 
			    map.put("increaseRate",increaseRate);
			    map.put("profitsCost", profitsCost);
			    map.put("cashRatio",cashRatio);
			    map.put("cashRecovery",cashRecovery);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				renderJson(json );
		}
		
		
		public void financial_report(){
			String name = getPara("name");
			setAttr("name",name);
			render("financial_report.jsp");
		}
		
		
		public void debtAssetfirst(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?assets ?liquiditycash ?fixedAssets ?noliquiditycash ?count"
					+" WHERE{ " +
					"{?a enterprise:货币资金             ?assets."
					+"?a enterprise:流动资产合计      ?liquiditycash."
					+"?a enterprise:固定资产净额       ?fixedAssets."
					+"?a enterprise:非流动资产合计 ?noliquiditycash."
					+"?a enterprise:资产总计            ?count.}"
					+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> assets  = new ArrayList<String> ();
				ArrayList<String>  liquiditycash  = new ArrayList<String> ();
				ArrayList<String>  fixedAssets   = new ArrayList<String> ();
				ArrayList<String>  noliquiditycash = new ArrayList<String> ();	
				ArrayList<String>  count = new ArrayList<String> ();		
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String assetss = qs.get("assets").toString().split("万元")[0];
			          String liquiditycashs = qs.get("liquiditycash").toString().split("万元")[0];
			          String fixedAssetss = qs.get("fixedAssets").toString().split("万元")[0];
			          String noliquiditycashs = qs.get("noliquiditycash").toString().split("万元")[0];
			          String counts = qs.get("count").toString().split("万元")[0];
			          assets.add(assetss);
			          liquiditycash.add(liquiditycashs);
			          fixedAssets.add(fixedAssetss);
			          noliquiditycash.add(noliquiditycashs);
			          count.add( counts);

			        } 
			    map.put("assets",assets);
			    map.put("liquiditycash", liquiditycash);
			    map.put("fixedAssets",fixedAssets);
			    map.put("noliquiditycash",noliquiditycash);
			    map.put("count",count);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用
				//System.out.print(json);
				renderJson(json );		
		}
		
		
		public void debtAssetsecond(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?receivables  ?otherecevie ?inventory"
					+" WHERE{ " +
					"{?a enterprise:应收账款             ?receivables."
					+"?a enterprise:其他应收款    ?otherecevie."
					+"?a enterprise:存货       ?inventory.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> receivables  = new ArrayList<String> ();
				ArrayList<String>  otherecevie  = new ArrayList<String> ();
				ArrayList<String>  inventory    = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String receivabless = qs.get("receivables").toString().split("万元")[0];
			          String otherecevies = qs.get("otherecevie").toString().split("万元")[0];
			          String inventorys = qs.get("inventory").toString().split("万元")[0];
			          receivables.add(receivabless);
			          otherecevie.add(otherecevies);
			          inventory.add(inventorys);
			        } 
			    map.put("receivables",receivables);
			    map.put("otherecevie", otherecevie);
			    map.put("inventory",inventory);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				System.out.print(json);
				renderJson(json );		
		}
		
		
		public void debtReport(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?advancePay  ?otherPay ?tcl ?undistributProfit ?owerInterest"
					+" WHERE{ " +
					"{?a enterprise:预收款项             ?advancePay."
					+"?a enterprise:其他应付款    ?otherPay."
					+"?a enterprise:流动负债合计       ?tcl."
					+ "?a enterprise:未分配利润      ?undistributProfit."
					+ "?a enterprise:所有者权益合计      ?owerInterest.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> advancePay  = new ArrayList<String> ();
				ArrayList<String>  otherPay  = new ArrayList<String> ();
				ArrayList<String>  undistributProfit    = new ArrayList<String> ();	
				ArrayList<String>  owerInterest  = new ArrayList<String> ();
				ArrayList<String>  tcl   = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String advancePays = qs.get("advancePay").toString().split("万元")[0];
			          String otherPays = qs.get("otherPay").toString().split("万元")[0];
			          String undistributProfits = qs.get("undistributProfit").toString().split("万元")[0];
			          String tcls = qs.get("tcl").toString().split("万元")[0];
			          String owerInterests = qs.get("owerInterest").toString().split("万元")[0];
			          advancePay.add( advancePays);
			          otherPay.add(otherPays);
			          undistributProfit.add(undistributProfits);
			          owerInterest.add(owerInterests);
			          tcl.add(tcls);
			        } 
			    map.put("advancePay",advancePay);
			    map.put("otherPay",  otherPay);
			    map.put("undistributProfit",undistributProfit);
			    map.put("owerInterest", owerInterest);
			    map.put("tcl",tcl);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用
				//System.out.print(json);
				renderJson(json );		
		}
		
		
		public void profitfirst(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?income ?cost"
					+" WHERE{ " +
					"{?a enterprise:营业收入          ?income."
					+"?a enterprise:营业成本    ?cost.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> income  = new ArrayList<String> ();
				ArrayList<String>  cost  = new ArrayList<String> ();
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String incomes = qs.get("income").toString().split("万元")[0];
			          String costs = qs.get("cost").toString().split("万元")[0];
			          income.add(incomes);
			          cost.add(costs);
			        } 
			    map.put("cost",cost);
			    map.put("income", income);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json );		
		}
		
		
		public void profitsecond(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?operProfit  ?countProfit ?netProfit"
					+" WHERE{ " +
					"{?a enterprise:营业利润    ?operProfit."
					+"?a enterprise:利润总额    ?countProfit."
					+"?a enterprise:净利润        ?netProfit.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> operProfit  = new ArrayList<String> ();
				ArrayList<String>  countProfit  = new ArrayList<String> ();
				ArrayList<String>  netProfit    = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String operProfits = qs.get("operProfit").toString().split("万元")[0];
			          String countProfits = qs.get("countProfit").toString().split("万元")[0];
			          String netProfits = qs.get("netProfit").toString().split("万元")[0];
			          operProfit.add(operProfits);
			          countProfit.add(countProfits);
			          netProfit.add(netProfits);
			        } 
			    map.put("operProfit",operProfit);
			    map.put("countProfit", countProfit);
			    map.put("netProfit",netProfit);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json );		
		}
		
		
		public void cashreport_first(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?operInCash  ?operOutCash ?investOutCash"
					+" WHERE{ " +
					"{?a enterprise:经营活动现金流入小计            ?operInCash."
					+"?a enterprise:经营活动现金流出小计            ?operOutCash."
					+"?a enterprise:投资活动现金流出小计            ?investOutCash.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> operInCash = new ArrayList<String> ();
				ArrayList<String> operOutCash  = new ArrayList<String> ();
				ArrayList<String> investOutCash   = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String operInCashs = qs.get("operInCash").toString().split("万元")[0];
			          String operOutCashs = qs.get("operOutCash").toString().split("万元")[0];
			          String investOutCashs = qs.get("investOutCash").toString().split("万元")[0];
			          operInCash.add(operInCashs);
			          operOutCash.add(operOutCashs);
			          investOutCash.add(investOutCashs);
			        } 
			    map.put("operInCash",operInCash);
			    map.put("operOutCash",operOutCash);
			    map.put("investOutCash",investOutCash);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				renderJson(json );		
		}
		
		
		public void cashreport_second(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?operCash  ?investCash ?CashEqual"
					+" WHERE{ " +
					"{?a enterprise:经营活动产生的现金流量净额           ?operCash."
					+"?a enterprise:投资活动产生的现金流量净额    ?investCash."
					+"?a enterprise:现金及现金等价物净增加额    ?CashEqual.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> operCash = new ArrayList<String> ();
				ArrayList<String>  investCash  = new ArrayList<String> ();
				ArrayList<String>  CashEqual    = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String operCashs = qs.get("operCash").toString().split("万元")[0];
			          String investCashs = qs.get("investCash").toString().split("万元")[0];
			          String cashRatios = qs.get("CashEqual").toString().split("万元")[0];
			          operCash.add(operCashs);
			          investCash.add(investCashs);
			          CashEqual.add(cashRatios);
			        } 
			    map.put("operCash",operCash);
			    map.put("investCash",investCash);
			    map.put("CashEqual",CashEqual);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json );		
		}
		
		
		//前五大销售客户
		public void custom(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?customname  ?pay"
					+" WHERE{ " +
					"{?a enterprise:客户名称  ?customname."
					+"?a enterprise:有销售金额 ?pay.}"
					+"}";		
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> pay = new ArrayList<String> ();
				ArrayList<String> customname  = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String customnames = qs.get("customname").toString();
			          String  pays = qs.get("pay").toString().split("万元")[0];
			          customname.add(customnames);
			          pay.add(pays);
			        } 
			    map.put("customname",customname);
			    map.put("pay",pay);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用
				//System.out.print(json);
				renderJson(json);		
		}
		
		
		public void opertrend(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?count ?pay"
					+" WHERE{" +
					"{?a enterprise:营业收入金额  ?count.}"
					+"{?a enterprise:利润总额 ?pay.}"
					+"}";	
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> profits = new ArrayList<String> ();
				ArrayList<String> cash  = new ArrayList<String> ();
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String itemprofitss = qs.get("count").toString().split("万元")[0];
			          String itemcashs = qs.get("pay").toString().split("万元")[0];
			          System.out.print(qs);
			          profits.add(itemprofitss);
			          cash.add(itemcashs);
			        } 
			    map.put("count",profits);
			    map.put("pay",cash);			    
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);		
				renderJson(json );		
		}
		
		
		//收入、成本、利润
		public void basicinfo(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?income  ?cost ?profits"
					+" WHERE{ " +
					"{?a enterprise:营业收入合计      ?income."
					+"?a enterprise:营业成本            ?cost."
					+"?a enterprise:利润总额           ?profits.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> income = new ArrayList<String> ();
				ArrayList<String> cost  = new ArrayList<String> ();
				ArrayList<String> profits   = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String incomes = qs.get("income").toString().split("万元")[0];
			          String costs = qs.get("cost").toString().split("万元")[0];
			          String profitss = qs.get("profits").toString().split("万元")[0];
			          income.add(incomes);
			          cost.add(costs);
			          profits.add(profitss);
			        } 
			    map.put("income",income);
			    map.put("cost",cost);
			    map.put("profits",profits);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				//System.out.print(json);
				renderJson(json );		
		}
		
		
		//公司业务占比
		/*public void business(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT  ?name ?money"
					+" WHERE{ " +
					"?a  enterprise:业务项目年份    ?year."
					+"?a enterprise:业务项目名称    ?name."
					+"?a enterprise:业务项目金额    ?money. FILTER(?year='2015年')"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				Map<String,String> map = new IdentityHashMap<String,String>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
						RDFNode key = qs.get("name");
						RDFNode value = qs.get("money");
						String keys = key.toString();
						String values = value.toString().split("万元")[0];
						map.put(keys, values);
			        } 		    
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				System.out.print(json);
				renderJson(json );		
		}*/
		
		
		public void costome(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?operInCash  ?operOutCash ?investOutCash"
					+" WHERE{ " +
					"{?a enterprise:经营活动现金流入小计            ?operInCash."
					+"?a enterprise:经营活动现金流出小计            ?operOutCash."
					+"?a enterprise:投资活动现金流出小计            ?investOutCash.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> operInCash = new ArrayList<String> ();
				ArrayList<String> operOutCash  = new ArrayList<String> ();
				ArrayList<String> investOutCash   = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String operInCashs = qs.get("operInCash").toString().split("万元")[0];
			          String operOutCashs = qs.get("operOutCash").toString().split("万元")[0];
			          String investOutCashs = qs.get("investOutCash").toString().split("万元")[0];
			          operInCash.add(operInCashs);
			          operOutCash.add(operOutCashs);
			          investOutCash.add(investOutCashs);
			        } 
			    map.put("operInCash",operInCash);
			    map.put("operOutCash",operOutCash);
			    map.put("investOutCash",investOutCash);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				renderJson(json );		
		}
		
		
		public void trend(){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?operCash  ?investCash ?CashEqual"
					+" WHERE{ " +
					"{?a enterprise:经营活动产生的现金流量净额           ?operCash."
					+"?a enterprise:投资活动产生的现金流量净额    ?investCash."
					+"?a enterprise:现金及现金等价物净增加额    ?CashEqual.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String> operCash = new ArrayList<String> ();
				ArrayList<String>  investCash  = new ArrayList<String> ();
				ArrayList<String>  CashEqual    = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String operCashs = qs.get("operCash").toString().split("万元")[0];
			          String investCashs = qs.get("investCash").toString().split("万元")[0];
			          String cashRatios = qs.get("CashEqual").toString().split("万元")[0];
			          operCash.add(operCashs);
			          investCash.add(investCashs);
			          CashEqual.add(cashRatios);
			        } 
			    map.put("operCash",operCash);
			    map.put("investCash",investCash);
			    map.put("CashEqual",CashEqual);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				System.out.print(json);
				renderJson(json );		
		}
		
		

		//税务、负债信息
		public void debtepay (){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?preperiodcash ?preyearpay ?Prepay   ?unPrepay"
					+" WHERE{ " +
					"{?a enterprise:有上年度发生额           ?preperiodcash."
					+"?a enterprise:有上年度支付额         ?preyearpay."
					+"?a enterprise:有上年度应付账款变动额    ?Prepay."
					+"?a enterprise:有上年末应付账款余额    ?unPrepay.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String>  Prepay  = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String preperiodcashs = qs.get("preperiodcash").toString().split("万元")[0];
			          String Prepays = qs.get("Prepay").toString().split("万元")[0];
			          String unPrepays = qs.get("unPrepay").toString().split("万元")[0];
			          String preyearpays = qs.get("preyearpay").toString().split("万元")[0];
			          Prepay.add(preperiodcashs);
			          Prepay.add(preyearpays);
			          Prepay.add(Prepays);
			          Prepay.add(unPrepays);
			          
			        } 
			    map.put("data",Prepay);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				renderJson(json );		
		}
		
		
		//负债情况
		public void debteinfo (){
			String company = getPara("name");
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?name ?money ?time"
					+" WHERE{ " +
					"{?a enterprise:负债项目名称      ?name."
					+"?a enterprise:负债项目金额     ?money."
					+"?a enterprise:负债项目期限    ?time.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				ArrayList<String>  name  = new ArrayList<String> ();	
				ArrayList<String>  money  = new ArrayList<String> ();	
				ArrayList<String>  time  = new ArrayList<String> ();	
				Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();			
			    while (rs.hasNext()) {  
			          QuerySolution qs = rs.next();
			          String names = qs.get("name").toString();
			          String moneys = qs.get("money").toString().split("万元")[0];
			          String times = qs.get("time").toString();   
			          name.add(names);
			          money.add(moneys);
			          time.add(times);			          
			        } 
			    map.put("names",name);
			    map.put("money",money);
			    map.put("time",time);
				String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
				System.out.print(json);
				renderJson(json );		
		}
		
		
		public void news() {
			String company = getPara("name").toString().trim();
			String sql = "SELECT * FROM company_news_data WHERE company_name = ?";
			List<Record> data = Db.find(sql,  company);
//			setAttr("newsPage", Company.dao.paginate(getParaToInt(0, 10), 10,company));
//			setAttr("news_data", data);
//			setAttr("name", company);
//			render("company_news.jsp");
			
		}
		public void newsContent() {
			int news_id = getParaToInt("id");
			Company content = Company.dao.findByIdLoadColumns(news_id, "company_name,news_title, content,publish_data,source");		
			setAttr("title", content.getStr("news_title"));
			setAttr("content", content.getStr("content"));
			setAttr("data", content.getStr("publish_data"));
			setAttr("source", content.getStr("source"));
			setAttr("name",content.getStr("company_name"));
			render("newsContent.jsp");
			
		}
		
		/*
		 * 0110 公司信息可视化
		 */
		public void Visualization(){
			String company = getPara("name").toString().trim();
			//relation：企业与法人、关联企业、投资企业、知识产权、高管
			ontModel.read(filePath + company + ".rdf");				
			String queryString = "SELECT ?income  ?cost ?profits"
					+" WHERE{ " +
					"{?a enterprise:主营业务收入      ?income."
					+"?a enterprise:营业成本            ?cost."
					+"?a enterprise:利润总额           ?profits.}"+"}";			
				Query query       = QueryFactory.create(prefix + queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, ontModel);	
				ResultSet rs      = qe.execSelect();
				System.out.print(rs.getRowNumber());
				while(rs.hasNext()){
					 QuerySolution qs = rs.next();
			          String income = qs.get("income").toString();
			          System.out.print(income);
					
			          
			          
				}
				
			
		
			setAttr("name", company);
			render("Visualization.jsp");
		}

}
