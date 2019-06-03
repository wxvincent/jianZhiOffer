package cn.itwx1;

import cn.source.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * @author wang
 */
public class Offer6 {

    public static List<Integer> printListFromTailToHeadByStack(ListNode node) {
        if (node == null) return null;
        Stack<ListNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }
        return list;
    }

    private static List<Integer> list2 = new ArrayList<>();

    public static void printListFromTailToHeadByRecursive(ListNode node) {

        if (node != null) {
            printListFromTailToHeadByRecursive(node.next);
            list2.add(node.val);
        }

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printListFromTailToHeadByRecursive(node);
        for (Integer integer : list2) {
            System.out.println(integer);
        }
    }
}


