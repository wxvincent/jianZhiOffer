package cn.itwx4;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 字符串的序列
 * @author wang
 *
 */
public class Offer38 {

	public ArrayList<String> permutation(String str){
		ArrayList<String> res = new ArrayList<>();
		if(str==null || str.length()==0) return res;
		char[] chars = str.toCharArray();
		TreeSet<String> temp = new TreeSet<>();
		permutation(chars,0,temp);
		res.addAll(temp);
		return res;
	}

	private void permutation(char[] chars, int index, TreeSet<String> result) {
		if(chars==null || chars.length==0) return;
		if(index<0 || index>chars.length-1) return;
		if(index==chars.length-1) {
			result.add(chars.toString());
		}else {
			for (int i = index; i < chars.length; i++) {
				swap(chars,index,i);
				permutation(chars, index+1, result);
				swap(chars, index, i);
			}
		}
	}

	private void swap(char[] chars, int a, int b) {
		char temp = chars[a];
		chars[a] = chars[b];
		chars[b] = temp;
	}


}
