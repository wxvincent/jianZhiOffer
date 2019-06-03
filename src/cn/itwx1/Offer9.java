package cn.itwx1;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author wang
 */
public class Offer9 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int ele) {
        stack1.push(ele);
    }

    public int deleteHead() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈已空");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

