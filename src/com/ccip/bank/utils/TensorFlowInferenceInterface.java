package com.ccip.bank.utils;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.tensorflow.Graph;
import org.tensorflow.Operation;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

/**
 *
 * @author yangzhenggang
 * @since jdk1.7
 * @version 2017年4月17日 yangzhenggang
 */
public class TensorFlowInferenceInterface {
    
    /** modelName */
    private final String modelName;
    
    /** g */
    private final Graph g;
    
    /** sess */
    private final Session sess;
    
    /** runner */
    private Session.Runner runner;
    
    /** feedNames */
    private List<String> feedNames = new ArrayList<String>();
    
    /** feedTensors */
    private List<Tensor> feedTensors = new ArrayList<Tensor>();
    
    /** fetchNames */
    private List<String> fetchNames = new ArrayList<String>();
    
    /** fetchTensors */
    private List<Tensor<?>> fetchTensors = (List)new ArrayList<Tensor>();
    
    /** runStats */
    private RunStats runStats;
    
    /**
     * Load a TensorFlow model from the AssetManager or from disk if it is not
     * an asset file.
     * 
     * @param modelFile The AssetManager to use to load the model file.
     * 
     * @param model The filepath to the GraphDef proto representing the model.
     */
    public TensorFlowInferenceInterface(String modelFile, String model) {
        this.modelName = model;
        this.g = new Graph();
        this.sess = new Session(g);
        this.runner = sess.runner();
        try {
            loadGraph(modelFile, g);
            System.out.println("Successfully loaded model from '" + model + "'");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load model from '" + model + "'", e);
        }
    }
    
    /**
     * Runs inference between the previously registered input nodes (via feed*)
     * and the requested output nodes. Output nodes can then be queried with the
     * fetch* methods.
     *
     * @param outputNames
     *            A list of output nodes which should be filled by the inference
     *            pass.
     */
    public void run(String[] outputNames) {
        run(outputNames, false);
    }
    
    /**
     * Runs inference between the previously registered input nodes (via feed*)
     * and the requested output nodes. Output nodes can then be queried with the
     * fetch* methods.
     *
     * @param outputNames
     *            A list of output nodes which should be filled by the inference
     *            pass.
     * @param enableStats enableStats
     */
    public void run(String[] outputNames, boolean enableStats) {
        // Release any Tensors from the previous run calls.
        closeFetches();
        
        // Add fetches.
        for (String o : outputNames) {
            fetchNames.add(o);
            TensorId tid = TensorId.parse(o);
            runner.fetch(tid.name, tid.outputIndex);
        }
        
        // Run the session.
        try {
            if (enableStats) {
                Session.Run r = runner.setOptions(RunStats.runOptions()).runAndFetchMetadata();
                fetchTensors = r.outputs;
                
                if (runStats == null) {
                    runStats = new RunStats();
                }
                runStats.add(r.metadata);
            } else {
                fetchTensors = runner.run();
            }
        } catch (RuntimeException e) {
            // Ideally the exception would have been let through, but since this
            // interface predates the
            // TensorFlow Java API, must return -1.
            System.out.println("Failed to run TensorFlow inference with inputs:[" + feedNames + "], outputs:["
                + fetchNames + "]");
            throw e;
        } finally {
            // Always release the feeds (to save resources) and reset the
            // runner, this run is
            // over.
            closeFeeds();
            runner = sess.runner();
        }
    }
    
    /**
     * Returns a reference to the Graph describing the computation run during
     * inference.
     * 
     * @return Graph
     */
    public Graph graph() {
        return g;
    }
    
    /**
     * 方法说明
     * 
     * @param inputName 参数
     * @param src 参数
     * @param dims 参数
     */
    public void feed(String inputName, float[] src, long... dims) {
        addFeed(inputName, Tensor.create(dims, FloatBuffer.wrap(src)));
    }
    
    /**
     * 方法说明
     * @param inputName 参数
     * @param src 参数
     */
    public void feed(String inputName, byte[] src) {
        addFeed(inputName, Tensor.create(src));
    }
    
    /**
     * 方法说明
     * 
     * @param inputName 参数
     * @param t 参数
     */
    public void addFeed(String inputName, Tensor t) {
        // The string format accepted by TensorFlowInferenceInterface is
        // node_name[:output_index].
        TensorId tid = TensorId.parse(inputName);
        runner.feed(tid.name, tid.outputIndex, t);
        feedNames.add(inputName);
        feedTensors.add(t);
    }
    
    /**
     * 方法说明
     * 
     * @param outputName 参数
     * @param dst 参数
     */
    public void fetch(String outputName, float[] dst) {
        fetch(outputName, FloatBuffer.wrap(dst));
    }
    
    
    /**
     * 接收Int32型数据
     */
    public void fetch(String outputName, int[] dst) {
      fetch(outputName, IntBuffer.wrap(dst));
    }

    /**
     * 方法说明
     * 
     * @param outputName 参数
     * @param dst 参数
     * @return INT64
     */
    
    public void fetch(String outputName, long[] dst) {
            fetch(outputName, LongBuffer.wrap(dst));
    }
    /**
     * 方法说明
     * 
     * @param outputName 参数
     * @param dst 参数
     */
    public void fetch(String outputName, FloatBuffer dst) {
        getTensor(outputName).writeTo(dst);
    }
    

    public void fetch(String outputName, LongBuffer dst) {
        getTensor(outputName).writeTo(dst);
    }

    /**
     * 方法说明
     * 
     * @param outputName 参数
     * @param dst 参数
     */
    public void fetch(String outputName, IntBuffer dst) {
        getTensor(outputName).writeTo(dst);
    }
    
    /**
     * 方法说明
     * 
     * @param outputName 参数
     * @return 参数
     */
    private Tensor getTensor(String outputName) {
        int i = 0;
        for (String n : fetchNames) {
            if (n.equals(outputName)) {
                return fetchTensors.get(i);
            }
            ++i;
        }
        throw new RuntimeException("Node '" + outputName + "' was not provided to run(), so it cannot be read");
    }
    
    /**
     * 方法说明
     * 
     * @param operationName 参数
     * @return 参数
     */
    public Operation graphOperation(String operationName) {
        final Operation operation = g.operation(operationName);
        if (operation == null) {
            throw new RuntimeException("Node '" + operationName + "' does not exist in model '" + modelName + "'");
        }
        return operation;
    }
    
    /**
     * Returns the last stat summary string if logging is enabled.
     * 
     * @return 返回
     */
    public String getStatString() {
        return (runStats == null) ? "" : runStats.summary();
    }
    
    /**
     * Cleans up the state associated with this Object. initializeTensorFlow()
     * can then be called again to initialize a new session.
     */
    public void close() {
        closeFeeds();
        closeFetches();
        sess.close();
        g.close();
        if (runStats != null) {
            runStats.close();
        }
        runStats = null;
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
    
    /**
     * 方法说明
     * 
     * @param path 参数
     * @param graph 参数
     * @throws IOException 参数
     */
    private void loadGraph(String path, Graph graph) throws IOException {
        final long startMs = System.currentTimeMillis();
        try {
            byte[] graphDef = Files.readAllBytes(Paths.get(path));
            graph.importGraphDef(graphDef);
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            throw e;
        }
        final long endMs = System.currentTimeMillis();
        System.out
            .println("Model load took " + (endMs - startMs) + "ms, TensorFlow version: " + TensorFlow.version());
    }
    
    /**
     *
     * @author yangzhenggang
     * @since jdk1.7
     * @version 2017年4月17日 yangzhenggang
     */
    private static class TensorId {
        
        /** name */
        String name;
        
        /** outputIndex */
        int outputIndex;
        
        /**
         * Parse output names into a TensorId.
         * E.g., "foo" --> ("foo", 0), while "foo:1" --> ("foo", 1)
         * 
         * @param name 参数
         * @return 参数
         */
        public static TensorId parse(String name) {
            TensorId tid = new TensorId();
            int colonIndex = name.lastIndexOf(':');
            if (colonIndex < 0) {
                tid.outputIndex = 0;
                tid.name = name;
                return tid;
            }
            try {
                tid.outputIndex = Integer.parseInt(name.substring(colonIndex + 1));
                tid.name = name.substring(0, colonIndex);
            } catch (NumberFormatException e) {
                tid.outputIndex = 0;
                tid.name = name;
            }
            return tid;
        }
    }
    
    /**
     * 方法说明 参数
     */
    private void closeFeeds() {
        for (Tensor t : feedTensors) {
            t.close();
        }
        feedTensors.clear();
        feedNames.clear();
    }
    
    /**
     * 方法说明 参数
     */
    private void closeFetches() {
        for (Tensor t : fetchTensors) {
            t.close();
        }
        fetchTensors.clear();
        fetchNames.clear();
    }
}
