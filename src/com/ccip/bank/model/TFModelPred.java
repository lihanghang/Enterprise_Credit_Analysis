package com.ccip.bank.model;

import java.io.IOException;
import java.nio.charset.Charset;

import org.tensorflow.*;

import com.ccip.bank.utils.TensorFlowInferenceInterface;
import com.csvreader.CsvReader;

/**
 * @date 2018年9月3日 上午11:32:25 
 * @author Mason
 */
public class TFModelPred {

	/**
	 * 信用等级预测模型数据处理过程
	 * @param data
	 * @return grade
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public float CreditGrade(String ModelPath, String DataPath) throws NumberFormatException, IOException
	{

		// 加载模型 信用等级
		System.out.println(ModelPath);
		TensorFlowInferenceInterface tfi = new TensorFlowInferenceInterface(ModelPath, "dataType");
		final Operation operation = tfi.graphOperation("cnn");
		// 加载预测数据      
	    CsvReader reader = new CsvReader(DataPath, ',', Charset.forName("UTF-8"));
	    String[] header = {};   
	    System.out.println("您预测的信用评级为：\n");
	    float grade =0;
	    while(reader.readRecord()) {
	    	float[] floatValue = new float[106];
	        if (reader.getCurrentRecord()==0){
	            header = reader.getValues();            
	        }
	        else{
	        	String t = reader.getRawRecord();
	        	String[] raw_data = t.split(",");
	        	//共106个特征
	        	for (int x = 0; x < 106; x++) {
	        		float d = Float.parseFloat(raw_data[x]); 
	        		floatValue[x] = d;
	        	}
	        	float keep = 1.0f;
	        	tfi.feed("inputs", floatValue,1, 106);
	        	Tensor  keep_prob = Tensor.create(keep);
	        	tfi.addFeed("prob",keep_prob);
	        	tfi.run(new String[] { "cnn" }, false); //输出张量
	        	long [] outPuts = new long [1]; //结果分类
	        	tfi.fetch("cnn", outPuts); //接收结果 outPuts保存的即为预测结果对应的概率，最大的一个通常为本次预测结果}
	        	grade = outPuts[0];
	        }
	    }								
		return grade;
	}		
}

