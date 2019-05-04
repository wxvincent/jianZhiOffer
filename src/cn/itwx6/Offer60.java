package cn.itwx6;

import java.text.NumberFormat;

/**
 * n个骰子的点数
 * 
 * @author wang
 *
 */
public class Offer60 {

	private final int maxValue = 6;

	public void printProbability(int number) {
		if (number <= 0)
			return;

		int[][] probabalities = new int[2][maxValue * number + 1];

		for (int i = 1; i <= 6; i++) {
			probabalities[0][i] = 1;
		}

		int flag = 0;
		for (int curNumber = 2; curNumber <= number; curNumber++) {
			for (int i = 0; i < curNumber; i++) {
				probabalities[1-flag][i] = 0;
			}
			for (int i = curNumber; i <= maxValue*number; i++) {
				for (int j = 1; j <=6 && j<=i; j++) {
					probabalities[1-flag][i] += probabalities[flag][i-j];
				}
			}
			flag = 1-flag;
		}
		
		int totalP = (int) Math.pow(maxValue, number);
		for (int i = number; i <= number*6; i++) {
			double ratio = (double)probabalities[flag][i]/totalP;
			NumberFormat format = NumberFormat.getPercentInstance();
			format.setMaximumFractionDigits(8);
			System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
		}
	}

}
