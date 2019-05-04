package cn.itwx7;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * @author wang
 *
 */
public class Offer62 {

	public int lastRemaining(int n,int m) {
		
		if(n<1 || m<1) return -1;
		
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		
		int removeIndex = 0;
		while(list.size()>1) {
			removeIndex = (removeIndex+m-1)%list.size();
			list.remove(removeIndex);
		}
		return list.get(0);
		
	}
	
	
}
