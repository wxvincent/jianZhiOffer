package cn.itwx4;

import cn.source.BinaryTreeNode;

/**
 * 二叉搜索树与双向链表
 * @author wang
 *
 */
public class Offer36 {

	public BinaryTreeNode convert(BinaryTreeNode root) {
		BinaryTreeNode lastList = convertNode(root,null);
		BinaryTreeNode head = lastList;
		while(head!=null && head.left!=null) {
			head = head.left;
		}
		return head;
	}

	private BinaryTreeNode convertNode(BinaryTreeNode root, BinaryTreeNode lastList) {
		if(root==null) return null;
		BinaryTreeNode cur = root;
		if(cur.left!=null) {
			lastList = convertNode(cur.left, lastList);
		}
		cur.left = lastList;
		if(lastList!=null) {
			lastList.right = cur;
		}
		lastList = cur;
		if(cur.right!=null) {
			lastList = convertNode(cur.right, lastList);
		}
		return lastList;
	}
	
}
