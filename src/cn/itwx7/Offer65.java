package cn.itwx7;

/**
 * 不用加减乘除作加法
 * @author wang
 *
 */
public class Offer65 {

	public int add(int num1,int num2) {
		while(num2!=0) {
			int sum = num1^num2;
			int carry = (num1&num2)<<1;
			num1 = sum;
			num2 = carry;
		}
		return num1;
	}
	
	
}
