package cn.itwx6;

/**
 * 翻转单词顺序
 * @author wang
 *
 */
public class Offer58_1 {

	public String reverseSentence(char[] chars) {
		if(chars==null || chars.length<=0) return null;
		reverseSb(chars,0,chars.length-1);
		
		int start = 0;
		int end = 0;
		while(start<chars.length) {
			while(end<chars.length && chars[end]!=' ') {
				end++;
			}
			reverseSb(chars, start, end-1);
			end++;
			start = end;
		}
		return String.valueOf(chars);
	}

	private void reverseSb(char[] chars, int start, int end) {
		while(start<end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		Offer58_1 offer58_1 = new Offer58_1();
		String string = offer58_1.reverseSentence("I am a student.".toCharArray());
		System.out.println(string);
	}
	
}
