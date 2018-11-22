package com.ccip.bank.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.nd4j.nativeblas.Nd4jCpu.float_absolute_difference_loss;

import org.tensorflow.Graph;
import org.tensorflow.Operation;
import org.tensorflow.Output;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

import com.ccip.bank.utils.TensorFlowInferenceInterface;
import com.csvreader.CsvReader;

/**
 * @date 2018年9月3日 上午11:32:25
 * @author Mason
 */
public class TFModelPred {

	/**
	 * @deprecated 信用等级预测模型数据处理过程
	 * @param data
	 * @return grade
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public float CreditGrade(String ModelPath, String DataPath)
			throws NumberFormatException, IOException {
		// 加载模型 信用等级
		System.out.println(ModelPath);
		TensorFlowInferenceInterface tfi = new TensorFlowInferenceInterface(
				ModelPath, "index_type");
		final Operation operation = tfi.graphOperation("cnn");
		// 加载预测数据
		CsvReader reader = new CsvReader(DataPath, ',',
				Charset.forName("UTF-8"));
		String[] header = {};
		float grade = 0;
		while (reader.readRecord()) {
			float[] floatValue = new float[106];
			if (reader.getCurrentRecord() == 0) {
				header = reader.getValues();
			} else {
				String t = reader.getRawRecord();
				String[] raw_data = t.split(",");
				// 共106个特征
				for (int x = 0; x < 106; x++) {
					float d = Float.parseFloat(raw_data[x]);
					floatValue[x] = d;
				}
				float keep = 1.0f;
				tfi.feed("inputs", floatValue, 1, 106);
				Tensor keep_prob = Tensor.create(keep);
				tfi.addFeed("prob", keep_prob);
				tfi.run(new String[] { "cnn" }, false); // 输出张量
				long[] outPuts = new long[1]; // 结果分类
				tfi.fetch("cnn", outPuts); // 接收结果
											// outPuts保存的即为预测结果对应的概率，最大的一个通常为本次预测结果}
				grade = outPuts[0];
			}
		}
		return grade;
	}

	/**
	 * @deprecated 企业风险等级评估模型数据处理过程0905
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @author Mason
	 */
	public float RiskGrade(float predData[], String ModelPath)
			throws FileNotFoundException, IOException {
		float predValue = 0;
		try (Graph graph = new Graph()) {
			// 导入图
			byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(
					ModelPath));
			graph.importGraphDef(graphBytes);
			// 根据图建立Session
			try (Session sess = new Session(graph)) {
				float keep = 1.0f;
				Tensor x = Tensor.create(predData);
				Tensor keep_prob = Tensor.create(keep);
				Tensor<?> y = sess.runner().feed("input_x", x)
						.feed("keep_prob", keep_prob).fetch("output/predict")
						.run().get(0);
				float[][] t = new float[1][1];
				y.copyTo(t);
				float[] result = t[0];
				predValue = result[0];
			}
		}
		return predValue;
	}

	/**
	 * 
	 * @deprecated 基于记忆网络的企业科研投入推荐模型数据处理过程
	 * @author Mason
	 * @param modelPath
	 * @param inputVal
	 * @date 20181024
	 * @return predValue
	 *
	 */
	public long KnowledgePredict(String modelPath, float[] inputVal) {
		long predValue = 0;
		TensorFlowInferenceInterface tfi = new TensorFlowInferenceInterface(
				modelPath, "mytag"); // 加载模型
		tfi.feed("inputs", inputVal, 1, 9); // 数据传入网络
		tfi.run(new String[] { "pred" }, false); // 输出张量
		long[] outPuts = new long[1]; // 预测分类结果
		tfi.fetch("pred", outPuts);
		predValue = outPuts[0];
		return predValue;
	}
	
	/**
	 * @date 20181119
	 * @param modelPath
	 * @param inputVal
	 * @return res
	 * @deprecated 基于CNN的文本情感分析模型调用
	 * 
	 */
	public  float textSentiment(String modelPath, String text) {
		float res = 0;
		
		
		
		return res;
	}
}
