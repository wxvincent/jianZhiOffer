package cn.itwx3;

import cn.source.ListNode;

/**
 * 链表中倒数第K个节点
 * 
 * @author wang
 *
 */
public class Offer22 {

	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while (k > 1) {
			if (fast.next != null) {
				fast = fast.next;
			} else {
				return null;
			}
			k--;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}

}

