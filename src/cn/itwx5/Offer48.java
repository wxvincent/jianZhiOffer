package cn.itwx5;

import java.util.Arrays;

/**
 * 最长不含重复字符的子字符串
 * @author wang
 *
 */
public class Offer48 {

	public int maxLength(String str) {
		if(str==null || str.length()<=0) return 0;
		
		int preLength = 0;
		int curLength = 0;
		int maxLength = 0;
		int[] pos = new int[26];
		Arrays.fill(pos, -1);
		
		for (int i = 0; i < str.length(); i++) {
			int letterNumber = str.charAt(i)-'a';
			if(pos[letterNumber]<0 || i-pos[letterNumber]>preLength) {
				curLength = preLength+1;
			}else {
				curLength = i-pos[letterNumber];
			}
			pos[letterNumber] = i;
			if(curLength>maxLength) {
				maxLength = curLength;
			}
			preLength = curLength;
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		Offer48 offer48 = new Offer48();
		String str = "abbc";
		int i = offer48.maxLength(str);
		System.out.println(i);
	}
}
