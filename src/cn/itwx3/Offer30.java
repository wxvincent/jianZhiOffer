package cn.itwx3;

import java.util.Stack;

/**
 * 包含min函数的栈
 * @author wang
 *
 */
public class Offer30 {
	
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	public void push(int num) {
		stack1.push(num);
		if(stack2.isEmpty()) {
			stack2.push(num);
		}else {
			if(stack2.peek()>=num) {
				stack2.push(num);
			}
		}
	}
	
	public int pop() {
		if(stack1.peek()==stack2.peek()) {
			stack2.pop();
		}
		return stack1.pop();
	}
	
	public int min() {
		return stack2.peek();
	}
}
