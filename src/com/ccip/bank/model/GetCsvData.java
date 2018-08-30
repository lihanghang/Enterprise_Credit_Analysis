/**
 * 
 */
package com.ccip.bank.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @date 2018年6月21日 下午5:17:31 
 */
/**
 * @author Mason
 *
 */
public class GetCsvData {
	
	   public static final int COLUMN_NUM = 5;//csv文件列数
	    
	    //获取指定csv文件数据，存入二维数组并返回
	    public static String[][] getCsvDataNew(String filePath) throws IOException{
	         BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
	         String line = "";
	         ArrayList<String[]> lineList = new ArrayList<String[]>(); 
	        // Read a single line from the file until there are no more lines to read
	         while((line = br.readLine()) != null) { 
	             StringTokenizer st = new StringTokenizer(line, ","); // 以逗号作为分隔符
	             String[] currCol = new String[COLUMN_NUM]; // Each currCol has 9 fields, so we need room for the 8 tokens.
	             for(int i = 0; i < COLUMN_NUM; i++) { // For each token in the line that we've read:
	                 //先判断是否还有待读取数据，防止溢出
	                 if(st.hasMoreTokens()){
	                     currCol[i]  = st.nextToken(); 
	                 }
	             
	             }
	             lineList.add(currCol); 
	         }
	         
	        String[][] str = new String[lineList.size()][5];
	        for(int i = 0; i < lineList.size(); i++) {
	              for(int j = 0; j < 5; j++) {
	               str[i][j] = lineList.get(i)[j];
	               //System.out.println(str[i][x]);
	              }
	        }
	        
	        br.close();
	        
	        return str;
	    }

	    //获取目录当前路径下所有csv文件的绝对路径
	    public static ArrayList<String> getFileList(String dirPath){
	        File dir = new File(dirPath);
	        File[] fileList = dir.listFiles();
	        ArrayList<String> strList = new ArrayList<String>();
	        for(File f:fileList){
	                            
	            if((f.isFile()) 
	                    && (".csv".equals(
	                            f.getName().
	                            substring(
	                                    f.getName().lastIndexOf("."), 
	                                    f.getName().length())))){
	                strList.add(f.getAbsolutePath());
	                
	            }
	        }
	        
	        
	        return strList;

	    }
	    
}

