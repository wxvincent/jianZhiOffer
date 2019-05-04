package cn.itwx6;

import java.util.ArrayDeque;

/**
 * 队列的最大值
 * @author wang
 *
 */
public class Offer59_2 {
	
	private ArrayDeque<InternalData> data = new ArrayDeque<>();
	private ArrayDeque<InternalData> max = new ArrayDeque<>();
	private class InternalData{
		int number;
		int index;
		public InternalData(int number, int index) {
			super();
			this.number = number;
			this.index = index;
		}
	}
	private int curIndex;
	
	public void push(int number) {
		InternalData curData = new InternalData(number, curIndex);
		data.addLast(curData);
		
		while(!max.isEmpty() && max.getLast().number<number) {
			max.removeLast();
		}
		max.addLast(curData);
		curIndex++;
	}
	
	public int pop() {
		if(data.isEmpty()) return 0;
		InternalData curData = data.removeFirst();
		if(curData.index==max.getFirst().index) {
			max.removeFirst();
		}
		return curData.number;
	}
	
	public int max() {
		if(max==null) return 0;
		return max.getFirst().number;
	}
	
}
