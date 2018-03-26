package com.ccip.bank.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ccip.bank.model.User;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

public class CompanyController extends Controller {	
	
			//定义前缀常量
	    String filePath = "A://work/project_finance/basic_data/rdf_data/100/test20/";	    
		
		public void index() {
		    //封装前台展示的数据
		    User name = getSessionAttr(getCookie("cuser"));
		    setAttr("name",name);	
			render("company.html");					
		}
		
		//企业背景页面
		public void basicInfo()
		{
			render("companyInfo.html");
		}
		//经营状况页面
		public void operation()
		{
			render("operatingstatus.html");
		}
		//风险状况页面
		public void lawsuit()
		{
			render("lawsuit.html");
			}		
		
		//知识产权页面
		public void intellectProperty()
		{
			render("intellectualproperty.html");
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
		
		
		@SuppressWarnings("unchecked")
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
				
		
		public void financial() throws BiffException, IOException{
			    
			String company = getPara("name");
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
		
		public void Iproperty() throws BiffException, IOException
		{
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
		public void zhuanli() throws BiffException, IOException
		{							
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
		public void softWare() throws BiffException, IOException
		{
	
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
		
		public void book() throws BiffException, IOException
		{		
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
		public void  web() throws BiffException, IOException
		{
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

		public void investPotention(){
			
			String company = getPara("name");
			setAttr("company_name", company);
			render("invest.html");
			
		}
}
