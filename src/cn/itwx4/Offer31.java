package cn.itwx4;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 *
 * @author wang
 */
public class Offer31 {

    public boolean check(int[] push, int[] pop) {
        if (push == null || pop == null ||
                push.length != pop.length || push.length == 0) return false;

        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while ((!stack.empty()) && (stack.peek() == pop[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

}
