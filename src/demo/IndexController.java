package demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;






import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;


public class IndexController extends Controller {

	
		public void index() throws BiffException, IOException{
			/*
			 * 数据库调用
			 */
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(new Date());
//			String sql = "select distinct company_name from  company_news_data";			
//			List<Record> company =  Db.find(sql);
	        setAttr("currentDate",time);
			render("index.html");
		}	
		
		//封装数据
		public void  dataJson() throws BiffException, IOException{
			String filePath = "A://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/123.xls";
			Workbook rwb = null;        
	        FileInputStream stream = new FileInputStream(filePath);
			rwb = Workbook.getWorkbook(stream);
		    Sheet sheet = rwb.getSheet(2);
		    int num = 1;
		    ArrayList<String>  name = new ArrayList<String> ();
			ArrayList<String>  zone = new ArrayList<String> ();
			ArrayList<String>  data = new ArrayList<String> ();
			ArrayList<String> status = new ArrayList<String> ();
			ArrayList<String>  capital = new ArrayList<String> ();						
			Map<String,ArrayList<String>> map = new IdentityHashMap<String, ArrayList<String>>();	
			while(num<=766)
			{
				name.add(sheet.getCell(0,num).getContents());
				capital.add(sheet.getCell(1,num).getContents());
				data.add(sheet.getCell(2,num).getContents());
				status.add(sheet.getCell(3,num).getContents());
				zone.add( sheet.getCell(12,num).getContents());				
				num++;
			} 					
			map.put("company_name", name);
			map.put("zone", zone);
			map.put("status", status);
			map.put("data", data);
			map.put("capital", capital);	
			String json = JsonKit.toJson(map); //封装为JSON数据格式，提供至前台使用	
			renderJson(json);
			//System.out.print(map);
		}

}

