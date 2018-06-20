package com.ccip.bank.model;

import java.io.File;
import java.io.IOException;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.examples.nlp.word2vec.Word2VecRawTextExample;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





/**
 * @date 2018年6月15日 下午9:36:19 
 * @project base on DL4J Credit_Classifiers
 * @author Mason
 *
 */
public class DL4J_Credit_Classifiers {
	
    private static Logger log = LoggerFactory.getLogger(DL4J_Credit_Classifiers.class);


    public static void main(String[] args) throws Exception{
    	    
    		
    		int seed = 123;
    		int batchSize = 100; //shap[20,17]
    		double learningRate = 0.02; //学习率   		
    		//Number of epochs (full passes of the data)
            int nEpochs = 500;
            int numInputs = 6;
            int numOutputs = 5;
            int numHiddenNodes = 20;           
            final String filenameTrain  = "D://java-project/enterpriseInfo/datasets/xypj/financial_train.csv";
            final String filenameTest  = "D://java-project/enterpriseInfo/datasets/xypj/financial_test.csv";
                                       	
			DataSet  trainIter = readCSVDataset(filenameTrain,batchSize,6,5);
			DataSet  testIter = readCSVDataset(filenameTest,batchSize,6,5);	
			
			log.info("Building model....");
		    MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
		                .seed(seed)
		                .updater(new Nesterovs(learningRate, 0.8))
		                .list()
		                .layer(0, new DenseLayer.Builder().nIn(numInputs).nOut(numHiddenNodes)
		                        .weightInit(WeightInit.XAVIER)
		                        .activation(Activation.TANH)		              
		                        .build())
		                .layer(1, new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD)
		                        .weightInit(WeightInit.XAVIER)
		                        .activation(Activation.SOFTMAX)
		                        .nIn(numHiddenNodes).nOut(numOutputs).build())
		                .pretrain(false).backprop(true).build();


		        MultiLayerNetwork model = new MultiLayerNetwork(conf);
		        model.init();
		        model.setListeners(new ScoreIterationListener(10));    //Print score every 10 parameter updates

		        for ( int n = 0; n < nEpochs; n++) {
		            model.fit( trainIter );
		        }
		        //44.20950832	-396.45	7.576666667	-16.25953114	-18.8582225	798.5133333

		        
		        Evaluation eval = new Evaluation(numOutputs);	       	   
		        INDArray features = testIter.getFeatureMatrix();
		        INDArray lables = testIter.getLabels();
		        INDArray predicted = model.output(features,false);
		        eval.eval(lables, predicted);
		        //Print the evaluation statistics
		         System.out.println(eval.stats());
		        		                       
    }   
    
    private static DataSet readCSVDataset(
        String csvFileClasspath, int batchSize, int labelIndex, int numClasses)
        throws IOException, InterruptedException{   	
        RecordReader rr = new CSVRecordReader();
        rr.initialize(new FileSplit(new File(csvFileClasspath)));
        DataSetIterator iterator = new RecordReaderDataSetIterator(rr,batchSize,labelIndex,numClasses);
        return iterator.next();
    }
    
}

