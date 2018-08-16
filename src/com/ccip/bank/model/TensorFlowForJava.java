package com.ccip.bank.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.tensorflow.*;

/**
 * @date 2018年8月7日 下午5:17:31 
 * @author Mason
 * 实现Java下TensorFlow神经网络模型调用
 */
public class TensorFlowForJava {


	public static void main(String[] args) throws FileNotFoundException, IOException {
//		    SavedModelBundle b = SavedModelBundle.load("D://java-project/enterpriseInfo/TFModel/Risk/", "risk");
//	        Session tfSession = b.session();
//	        Operation operationPredict = b.graph().operation("predict");   //要执行的
//	        Output output = new Output(operationPredict, 0);
//	        System.out.println(output);
//	        float[][] a = new float[1][9];
//	        a[0] = new float[]{0.517647f,0.839216f,0.992157f,0.996078f,0.992157f,0.796079f,0.635294f,0.160784f,0.796079f};
//	        Tensor input_x = Tensor.create(a);
//	        float out = tfSession.runner().feed("input_x", input_x).fetch(output).run().get(0).floatValue();
//	        for (Tensor s : out) {
//	            float[][] t = new float[1][1];
//	            s.copyTo(t);
//	            for (float i : t[0])
//	                System.out.println(i);
//	        }

//		
		        try (Graph graph = new Graph()) {
		            //导入图
		            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream("D://java-project/enterpriseInfo/TFModel/Risk/risk.pb"));
		            graph.importGraphDef(graphBytes);
		            float[][] a = new float[1][9];
			        a[0] = new float[]{0.110502605575513f,0.176740518459297f,0.255217838189331f,3.3848964220829f,0.770701674854596f,0.172805926106074f,3.3848964220829f,0.770701674854596f,0.172805926106074f};
			        float keep = 0.8f;
		            //根据图建立Session
		            try(Session sess = new Session(graph)){
		            	Tensor x = Tensor.create(a);
		            	Tensor keep_drop = Tensor.create(keep);
		            	//System.out.println(x);
		            	List<Tensor<?>> y = sess.runner().feed("input_x", x).feed("Placeholder_1", keep_drop).fetch("output/predict").run();
//		                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'in_put': 10.0})
		            	 for (Tensor s : y) {
		     	            float[][] t = new float[1][1];
		     	            s.copyTo(t);
		     	            for (float i : t[0])
		     	                System.out.println(i);
		     	        }		         
		            }
		        }
		    }	    		    	
	    }	    