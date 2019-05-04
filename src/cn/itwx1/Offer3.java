package cn.itwx1;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0~n-1的范围内。
 * 
 * 
 * @author wang
 *
 */
public class Offer3 {

	public static Set<Integer> findDuplicate(int[] arr) {
		if (arr == null || arr.length < 1)
			return null;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] >= arr.length) {
				return null;
			}
		}

		Set<Integer> set = new HashSet<>();
		a:for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i) {
				if (arr[i] == arr[arr[i]]) {
					set.add(arr[i]);
					continue a;
				}
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}
		return set;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,1,0,2,5,3};
		Set<Integer> set = findDuplicate(arr);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
	
}
