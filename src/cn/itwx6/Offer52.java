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
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            if (p1 != p2) {//若两个链表不相交，最后两个节点同时为null
                if (p1 == null) p1 = head2;
                if (p2 == null) p2 = head1;
            }
        }
        return p1;
    }

}


