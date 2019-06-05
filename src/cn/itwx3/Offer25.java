package cn.itwx3;

import cn.source.ListNode;

/**
 * 合并两个排序的链表
 *
 * @author wang
 */
public class Offer25 {

    public ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode newNode = null;
        if (list1.val <= list2.val) {
            newNode = list1;
            newNode.next = merge(list1.next, list2);
        } else {
            newNode = list2;
            newNode.next = merge(list1, list2.next);
        }
        return newNode;
    }
}
