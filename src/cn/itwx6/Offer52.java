package cn.itwx6;

import cn.source.ListNode;

/**
 * 两个链表的第一个公共节点
 *
 * @author wang
 */
public class Offer52 {

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != p2) {
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
    }

}


