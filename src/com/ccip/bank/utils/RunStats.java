package com.ccip.bank.utils;

/**
 *
 * @author yangzhenggang
 * @since jdk1.7
 * @version 2017年4月17日 yangzhenggang
 */
public class RunStats {
    
    /** fullTraceRunOptions */
    private static byte[] fullTraceRunOptions = new byte[] { 0x08, 0x03 };
    
    /** nativeHandle */
    private long nativeHandle;
    
    /**
     * 方法说明
     * 
     * @return 参数
     */
    public static byte[] runOptions() {
        return fullTraceRunOptions;
    }
    
    /**
     * 构造函数
     */
    public RunStats() {
        nativeHandle = allocate();
    }
    
    /**
     * 方法说明 参数
     */
    public void close() {
        if (nativeHandle != 0) {
            delete(nativeHandle);
        }
        nativeHandle = 0;
    }
    
    /**
     * 方法说明
     * 
     * @param runMetadata 参数
     */
    public synchronized void add(byte[] runMetadata) {
        add(nativeHandle, runMetadata);
    }
    
    /**
     * 方法说明
     * 
     * @return 参数
     */
    public synchronized String summary() {
        return summary(nativeHandle);
    }
    
    /**
     * 方法说明
     * 
     * @return 参数
     */
    private static native long allocate();
    
    /**
     * 方法说明
     * 
     * @param handle 参数
     */
    private static native void delete(long handle);
    
    /**
     * 方法说明
     * 
     * @param handle 参数
     * @param runMetadata 参数
     */
    private static native void add(long handle, byte[] runMetadata);
    
    /**
     * 方法说明
     * 
     * @param handle 参数
     * @return 参数
     */
    private static native String summary(long handle);
}
