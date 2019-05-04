package cn.itwx4;

/**
 * 数组中出现次数超过一半的数字
 * @author wang
 *
 */
public class Offer39 {

	public int moreThanHalfNum(int[] array) {
		if(array==null ||array.length==0) return 0;
		int maxCount = array[0];
		int number = array[0];
		int count = 1;
		
		for (int i = 1; i < array.length; i++) {
			if(number != array[i]) {
				if(count==0) {
					number = array[i];
					count = 1;
				}else{
					count--;
				}
			}else {
				count++;
			}
			
			if(count==1) {
				maxCount = number;
			}
		}
		
		//验证：因为可能会出现频率最高的数字并没有达到要求的标准
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]==maxCount) {
				num++;
			}
		}
		if(num*2 > array.length) {
			return maxCount;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Offer39 offer39 = new Offer39();
		int[] array = {1,2,3,2,2,2,5,4};
		int num = offer39.moreThanHalfNum(array);
		System.out.println(num);
	}
}
