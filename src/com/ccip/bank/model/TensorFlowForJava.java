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

        try (Graph graph = new Graph()) {
            //导入图
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream("D://java-project/enterpriseInfo/TFModel/CreditModel/creditGrade.pb"));
            graph.importGraphDef(graphBytes);
            float[][][] a = new float[1][1][106];
            a[0][0] = new float[]{199,0,0,69,204,12,0,484,350,18,0,604,0,0,0,972,1456,0,0,0,51,7,2,3,0,0,63,0,0,20,83,1500,2,0,-129,1373,1373,1456,416,416,5,5,2,58,349,0,0,0,2,1,0,3,0,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0.3f,0.4f,416,0.2f,0.2f,0.2f,0,5.7f,768.3f,749.2f,0,0,98.8f,0.7f,0,0,1.1f,0
};
            float keep = 1.0f;
            //根据图建立Session
            try(Session sess = new Session(graph)){
            Tensor x = Tensor.create(a);
            Tensor  keep_prob = Tensor.create(keep);
            //System.out.println(x);
            List<Tensor<?>> y = sess.runner().feed("inputs", x).feed("keep",  keep_prob).fetch("predicted").run();        
                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'in_put': 10.0})
            for (Tensor s : y) {
            	float[][] t = new float[1][1];
            	s.copyTo(t);
            	for (float i : t[0])
                System.out.println("Risk_Index:"+i);
            	}         
            }
        }
    }
  }    