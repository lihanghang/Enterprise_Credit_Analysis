/**
 * 
 */
package com.ccip.bank.utils;


/**
 * @date 2018年3月31日 上午10:19:06 
 */
/**
 * @author Mason
 *财务数据计算库
 */
public class Math {

	//均值
	public static double Average(double[] x) {
		int m=x.length;
		double sum=0;
		for(int i=0;i<m;i++){//求和
		    sum+=x[i];
		}
		double dAve=sum/m;//求平均值
		return dAve;
		
	}
	//方差s^2=[(x1-x)^2 +...(xn-x)^2]/n
	public static double Variance(double[] x) { 
		int m=x.length;
		double dAve= Average(x);//求平均值
		double dVar=0;
		for(int i=0;i<m;i++){//求方差
			dVar+=(x[i]-dAve)*(x[i]-dAve);
		}
		return dVar/m;
	}
	
	//计算偏冷线
	public static double cold_Line(double dAve,double dVar) {
		
		double cold = dAve - 1.96*dVar;		
		return cold;
	}
	//计算上限值
}

