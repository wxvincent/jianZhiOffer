package cn.itwx6;

/**
 * 数组中只出现一次的两个数字
 * @author wang
 *
 */
public class Offer56_1 {

	/**
	 * 
	 * @param arr
	 * @param num1 num1[0]就是返回的第一个数
	 * @param num2 num2[0]就是返回的第二个数
	 */
	public void findNumsAppearOnce(int[] arr,int[] num1,int[] num2) {
		if(arr==null || arr.length<=0) return;
		int resultExclusiveOR = 0;
		for (int i = 0; i < arr.length; i++) {
			resultExclusiveOR = resultExclusiveOR^arr[i];
		}
		
		int indexOf1 = 0;
		while((resultExclusiveOR&1)==0 && indexOf1<=4*8) {
			resultExclusiveOR = resultExclusiveOR>>1;
			indexOf1++;
		}
		
		num1[0] = 0;
		num2[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			if(((arr[i]>>indexOf1)&1)==1) {
				num1[0]^=arr[i];
			}else {
				num2[0]^=arr[i];
			}
		}
		
	}
	
	
}
