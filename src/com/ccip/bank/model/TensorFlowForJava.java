package com.ccip.bank.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import net.sf.javaml.core.Instance;
import net.sf.javaml.filter.normalize.NormalizeMidrange;
import net.sf.javaml.tools.InstanceTools;

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
	
	/**
	 * 信用模型调用
	 */
	// 加载模型 信用等级
//	TensorFlowInferenceInterface tfi = new TensorFlowInferenceInterface(System.getProperty("user.dir")+"/TFModel/CreditModel/cnn.pb","dataType");
//	final Operation operation = tfi.graphOperation("cnn");
//	// 加载预测数据
//	String srcCSV = System.getProperty("user.dir")+"/datasets/xypj/train.csv";         
//    CsvReader reader = new CsvReader(srcCSV, ',', Charset.forName("UTF-8"));
//    String[] header = {};   
//    System.out.println("您预测的信用评级为：\n");
//    while(reader.readRecord()) {
//    	float[] floatValue = new float[106];
//        if (reader.getCurrentRecord()==0){
//            header = reader.getValues();            
//        }
//        else{
//        	String t = reader.getRawRecord();
//        	String[] raw_data = t.split(",");
//        	//从第四列开始去预测数据
//        	for (int x = 3; x < 109; x++) {
//        		float d = Float.parseFloat(raw_data[x]); 
//        		floatValue[x-3] = d;
//        	}
//        	float keep = 1.0f;
//        	tfi.feed("inputs", floatValue,1, 106);
//        	Tensor  keep_prob = Tensor.create(keep);
//        	tfi.addFeed("prob",keep_prob);
//        	tfi.run(new String[] { "cnn" }, false);//输出张量
//        	long [] outPuts = new long [1];//结果分类
//        	tfi.fetch("cnn", outPuts);//接收结果 outPuts保存的即为预测结果对应的概率，最大的一个通常为本次预测结果}
//        	System.out.println(outPuts[0]);
//        }
//    }			
		
	/**
	 * Risk Model 调用
	 */
        try (Graph graph = new Graph()) {
            //导入图
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(System.getProperty("user.dir")+"/TFModel/Risk/QC_Model.pb"));
            graph.importGraphDef(graphBytes);
            //float[] a = new float[]{-2.52894469e-02f , -4.47493123e-02f , -1.11403992e-01f , -1.00096164e-01f,
           // -1.05890850e-01f , -3.96117458e-02f};
            float[] a = new float[]{-2.21283262e-02f,  -4.22827772e-02f,  -1.22634684e-01f,  -1.01158189e-01f,
            		   -1.16706481e-01f,  -3.61754572e-02f};
            //根据图建立Session        		
         try(Session sess = new Session(graph)){
            float keep = 1.0f;        
            Tensor x = Tensor.create(a);
            Tensor  keep_prob = Tensor.create(keep);
            Tensor<?> y = sess.runner().feed("input_x", x).feed("keep_prob", keep_prob).fetch("output/predict").run().get(0);  
            float[][] t = new float[1][1];
            y.copyTo(t);
            float[] result = t[0];          
            System.out.println("企业流动性为："+result[0]);
                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'in_put': 10.0})
//            for (Tensor s : y) {
//            	float[][] t = new float[1][1];
//            	s.copyTo(t);
//            	for (float i : t[0])
//                System.out.println("Risk:"+i);
//            	}         
            }
        }
    }



    /**
     * 0均值\标准差归一化 公式：X(norm) = (X - μ) / σ
     * X(norm) = (X - 均值) / 标准差
     *
     * @param points 原始数据
     * @return 归一化后的数据
     */
    public static float[] normalize4ZScore(float[] points) {
        if (points == null || points.length < 1) {
            return points;
        }
        float[] p = new float[points.length];
        float[] matrixJ;
        float avg;
        float std;
        for (int j = 0; j < points.length; j++) {
          
            
            avg = average(points);
            System.out.println(avg);
            std = standardDeviation(points);
            for (int i = 0; i < points.length; i++) {
                p[i]= std == 0 ? points[i] : (points[i]- avg) / std;
            }
        }
        return p;
    }
 
    /**
     * 方差s^2=[(x1-x)^2 +...(xn-x)^2]/n
     *
     * @param x x
     * @return 方差
     */
    public static float variance(float[] x) {
        int m = x.length;
        float sum = 0;
        for (int i = 0; i < m; i++) {//求和
            sum += x[i];
        }
        float dAve = sum / m;//求平均值
        float dVar = 0;
        for (int i = 0; i < m; i++) {//求方差
            dVar += (x[i] - dAve) * (x[i] - dAve);
        }
        return dVar / m;
    }
 
    /**
     * 标准差σ=sqrt(s^2)
     *
     * @param x x
     * @return 标准差
     */
    public static float standardDeviation(float[] x) {
        return (float)Math.sqrt(variance(x));
    }
 
    /**
     * 平均值
     *
     * @param x x
     * @return 平均值
     */
    public static float average(float[] x) {
        int m = x.length;
        float sum = 0;
        for (int i = 0; i < m; i++) {
            sum += x[i];
        }
        float dAve = sum / m;
        return dAve;
    }



    public static float[] getMatrixCol(float[][] points, int column) {
        float[] matrixJ = new float[points.length];
        for (int i = 0; i < points.length; i++) {
            matrixJ[i] = points[i][column];
        }
        return matrixJ;
    }










  }    