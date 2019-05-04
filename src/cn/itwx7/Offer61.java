package cn.itwx7;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 
 * @author wang
 *
 */
public class Offer61 {

	public boolean isContinuous(int[] arr) {
		if (arr == null || arr.length <= 0)
			return false;
		Arrays.sort(arr);

		int numberOf0 = 0;
		int numberOfGap = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				numberOf0++;
		}

		int small = numberOf0;
		int big = numberOf0 + 1;

		while (big < arr.length) {
			if (arr[small] == arr[big])
				return false;
			numberOfGap += arr[big++] - arr[small++] - 1;
		}

		if (numberOf0 >= numberOfGap)
			return true;
		return false;

	}

}
