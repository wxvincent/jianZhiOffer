package cn.itwx2;

/**
 * 打印从1到最大的n位数
 * @author wang
 *
 */
public class Offer17 {

	public static void print1ToMaxOfNDigits(int n) {
		int[] arr = new int[n];
		if(n<=0) return;
		print(arr,0);
	}

	private static void print(int[] arr, int n) {
		for (int i = 0; i < 10; i++) {
			if(n!=arr.length) {
				arr[n] = i;
				print(arr, n+1);
			}else {
				boolean isFirstNo0 = false;
				for (int j = 0; j < arr.length; j++) {
					if(arr[j]!=0) {
						System.out.print(arr[j]);
						isFirstNo0 = true;
					}else {
						if(isFirstNo0) {
							System.out.print(arr[j]);
						}
					}
				}
				System.out.println();
				return;//此处不加return会导致打印十次(打印的这一次不需要再循环了)
			}
		}
	}
	
	public static void main(String[] args) {
		print1ToMaxOfNDigits(2);
	}
}
