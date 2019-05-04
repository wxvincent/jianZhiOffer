package cn.itwx6;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 * @author wang
 *
 */
public class Offer57_2 {

	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
		ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<>();
		if(sum<=0) return sequenceList;
		
		int small = 1;
		int big = 2;
		int curSum = small+big;
		while(small<=sum/2) {
			if(curSum==sum) {
				ArrayList<Integer> sequence = new ArrayList<>();
				for (int i = small; i <= big; i++) {
					sequence.add(i);
				}
				sequenceList.add(sequence);
				curSum = curSum-small;
				small++;
			}
			if(curSum<sum) {
				big++;
				curSum+=big;
			}
			if(curSum>sum) {
				curSum-=small;
				small++;
			}
		}
		return sequenceList;
	}
	
	
}
