package com.ccip.bank.utils.javaDea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetExcelInfo {
 
    public Map<String, DeaRecord> readExcel(File file) {
    	Map<String, DeaRecord> records = new LinkedHashMap<>();;

        try {
            InputStream is = new FileInputStream(file.getAbsolutePath()); 
            Workbook wb = Workbook.getWorkbook(is); 
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) { 
                Sheet sheet = wb.getSheet(index);
                for (int i = 1; i < sheet.getRows(); i++) {
                	double[] input = new double[4];
                	double[] output= new double[6];
                    for (int j = 1; j < sheet.getColumns(); j++) {  
                        String cellinfo = sheet.getCell(j, i).getContents();
                        double tmp = Double.valueOf(cellinfo.toString());
                        if(j<7) {
                        	output[j-1]=tmp;
                        }else {
                        	input[j-7]=tmp;
                        }
                    }
                    records.put(sheet.getCell(0, i).getContents(), new DeaRecord(output,input));
                }  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (BiffException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return records;
    }  
}
