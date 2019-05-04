package cn.itwx3;

import cn.source.ListNode;

/**
 * 链表中环的入口节点
 * 
 * @author wang
 *
 */
public class Offer23 {

	public ListNode entryNodeOfLoop(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				fast = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

}
