package cn.itwx3;

import cn.source.ListNode;

/**
 * 反转链表
 * @author wang
 *
 */
public class Offer24 {

	public ListNode reverseList(ListNode head) {
		
		if(head==null) return null;
		
		ListNode temp = null;
		while(head!=null) {
			ListNode p = head.next;
			head.next = temp;
			temp = head;
			head = p;
		}
		return temp;
 	}
	
}
