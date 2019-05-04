package cn.itwx2;

/**
 * 数值的整数次方
 * @author wang
 *
 */
public class Offer16 {

	public double power(double base,int exponent) {
		double res = 0;
		if(equal(base,0)) {
			return 0;
		}
		if(exponent==0) return 1;
		if(exponent>0) {
			res = mutiply(base,exponent);
		}else{
			res = mutiply(1/base,-exponent);
		}
		return res;
	}

	private double mutiply(double base, int exponent) {
		double sum = 1;
		for (int i = 1; i <= exponent; i++) {
			sum = sum*base;
		}
		return sum;
	}

	private boolean equal(double a, double b) {
		if(a-b<0.000001 && a-b>-0.000001) {
			return true;
		}
		return false;
	}
	
}
