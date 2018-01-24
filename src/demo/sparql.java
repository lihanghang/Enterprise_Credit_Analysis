package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;







import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import com.jfinal.json.Json;
import com.jfinal.kit.JsonKit;

public class sparql {

	static final String inputFileName = "D://work/project_finance/basic_data/rdf_data/100/test20/爱尚游北京科技股份有限公司.rdf";
	static final String enterpriseURI = "http://ccip.ucas.ac.cn/ontology/company#";
	public static void main(String[] args) throws JXLException, IOException {
		// TODO Auto-generated method stub
		
		String filePath = "D://work/project_finance/basic_data/excel_data_finance/标准数据/2018-1-4行业分类/企业背景0113.xls";
		System.out.print(dataJson(filePath));
	
		
		 
	}
	public static  ArrayList<String>  dataJson(String filePath) throws BiffException, IOException{
			
		Workbook rwb = null;        
        FileInputStream stream = new FileInputStream(filePath);
		rwb = Workbook.getWorkbook(stream);
	    Sheet sheet = rwb.getSheet(2);
	    int num = 1;	    
	    HashMap<String, String> map = new HashMap<String, String>();
	    ArrayList<String>  info = new ArrayList<String> ();
	    String json = "";
		while(num<=694)
		{
			map.put("company_name", sheet.getCell(0,num).getContents());
			map.put("capital", sheet.getCell(1,num).getContents());
			map.put("data", sheet.getCell(2,num).getContents());
			map.put("status", sheet.getCell(3,num).getContents());
			map.put("zone", sheet.getCell(12,num).getContents());
			json += JsonKit.toJson(map);
			num++;
		} 		
		json = json.replace("}{", "},{");
		info.add(json);
		return info;
	}

}
