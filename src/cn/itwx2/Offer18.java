package cn.itwx2;

import cn.source.ListNode;

/**
 * 删除链表的节点
 * @author wang
 *
 */
public class Offer18 {
	
	/**
	 * 在O（1）时间内删除链表节点
	 * @param head 头节点
	 * @param deNode 被删除的节点
	 */
	public void deleteNode(ListNode head,ListNode deNode) {
		if(head==null || deNode==null) return;
		if(head==deNode) {
			head = null;
		}else {
			if(deNode.next==null) {
				ListNode temp = head;
				while(temp.next.next!=null) {
					temp = temp.next;
				}
				temp.next = null;
			}else {
				deNode.val = deNode.next.val;
				deNode.next = deNode.next.next;
			}
		}
	}
	
	/**
	 * 删除排序链表中重复的节点
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplication(ListNode head) {
		if(head==null) return null;
		ListNode yummy = new ListNode(-1);
		yummy.next = head;
		
		ListNode cur = head;
		ListNode preNode = yummy;
		
		while(cur!=null && cur.next!=null) {
			if(cur.val==cur.next.val) {
				int temp = cur.val;
				while(cur!=null && cur.val==temp) {
					cur = cur.next;
				}
				preNode.next = cur;
			}else {
				preNode = cur;
				cur = cur.next;
			}
		}
		return yummy.next;
	}
}


