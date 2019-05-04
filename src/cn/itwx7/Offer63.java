package cn.itwx7;

/**
 * 股票的最大利润
 * @author wang
 *
 */
public class Offer63 {

	public int maxDiff(int[] arr) {
		
		if(arr==null || arr.length<2) return -1;
		
		int min = arr[0];
		int maxDiff = arr[1]-min;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1]<min) {
				min = arr[i-1];
			}
			if(arr[i]-min>maxDiff) {
				maxDiff = arr[i]-min;
			}
		}
		
		return maxDiff;
		
	}
	
	
}
