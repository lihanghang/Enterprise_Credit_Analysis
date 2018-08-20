package com.ccip.bank.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.tensorflow.*;

import com.ccip.bank.utils.TensorFlowInferenceInterface;
import com.csvreader.CsvReader;

/**
 * @date 2018年8月7日 下午5:17:31 ；20180820测试完成信用评级CNN模型的调用
 * @author Mason
 * 实现Java下TensorFlow神经网络模型调用
 */
public class TensorFlowForJava {

public static void main(String[] args) throws FileNotFoundException, IOException {
	//加载模型
	TensorFlowInferenceInterface tfi = new TensorFlowInferenceInterface(System.getProperty("user.dir")+"/TFModel/CreditModel/creditGrades.pb","dataType");
	final Operation operation = tfi.graphOperation("predicted");
	// 加载预测数据
	String srcCSV = System.getProperty("user.dir")+"/datasets/xypj/creditGrade_train_data.csv";         
    CsvReader reader = new CsvReader(srcCSV, ',', Charset.forName("UTF-8"));
    String[] header = {};   
    System.out.println("您预测的信用评级为：\n");
    while(reader.readRecord()) {
    	float[] floatValue = new float[106];
        if (reader.getCurrentRecord()==0){
            header = reader.getValues();            
        }
        else{
        	String t = reader.getRawRecord();
        	String[] raw_data = t.split(",");
        	//从第四列开始去预测数据
        	for (int x = 3; x < 109; x++) {
        		float d = Float.parseFloat(raw_data[x]); 
        		floatValue[x-3] = d;
        	}
        	float keep = 0.8f;
        	tfi.feed("inputs", floatValue,1, 106,1);
        	Tensor  keep_prob = Tensor.create(keep);
        	tfi.addFeed("keep",keep_prob);
        	tfi.run(new String[] { "predicted" }, false);//输出张量
        	long [] outPuts = new long [1];//结果分类
        	tfi.fetch("predicted", outPuts);//接收结果 outPuts保存的即为预测结果对应的概率，最大的一个通常为本次预测结果}
        	System.out.println(outPuts[0]);
        }
    }		
	
//	System.out.println(operation.numOutputs());
//	Output output = operation.output(0);
//	Shape shape = output.shape();
//	System.out.println(shape);
//	final int numClasses =  (int) shape.size(0);
//	System.out.println(numClasses);
//        try (Graph graph = new Graph()) {
//            //导入图
//            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(System.getProperty("user.dir")+"/TFModel/CreditModel/creditGrade.pb"));
//            graph.importGraphDef(graphBytes);
            //float[][] a = new float[1][106];
//            float[] floatValues = new float[106];
//            
//            
//            String data = ""
//            			+ "0,0,0,0,0,0,0,5,0,-18,0,604,0,0,0,972,1456,0,0,0,51,7,2,3,0,0,-63,"
//            			+ "0,0,20,83,1500,2,0,-129,1,1,0,416,416,5,5,2,58,349,0,0,0,2,1,0,3,0,3,"
//            			+ "3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0.3f,0.4f,"
//            			+ "416,0.2f,0.2f,0.2f,0,5.7f,768.3f,-749.2f,0,0,-98.8f,0.7f,0,0,1.1f,0"
//            			+ "";   
//            String[] raw_data = data.split(",");
//                for (int x = 0; x < 106; x++) {
//                	float d = Float.parseFloat(raw_data[x]);
//                    // int rgb1 = (pixel & 0xff00) >> 8;
//                    // int rgb2 = (pixel & 0xff);
//                    // System.out.println(rgb0 + "," + rgb1 + "," + rgb2);
//                    // 数值归一化
//                    floatValues[x] = d;
//                }
//            
//           
////            //根据图建立Session
//            try(Session sess = new Session(graph)){
//            Tensor x = Tensor.create(a);
//            Tensor  keep_prob = Tensor.create(keep);
//            //System.out.println(x);
//            List<Tensor<?>> y = sess.runner().feed("inputs", x).feed("keep",  keep_prob).fetch("predicted").run();        
//                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'in_put': 10.0})
//            for (Tensor s : y) {
//            	float[][] t = new float[1][1];
//            	s.copyTo(t);
//            	for (float i : t[0])
//                System.out.println("Risk_Index:"+i);
//            	}         
//            }
//        }
    }
  }    