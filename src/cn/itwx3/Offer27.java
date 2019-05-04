package cn.itwx3;

import cn.source.BinaryTreeNode;

import java.util.Stack;

/**
 * 二叉树的镜像
 * 
 * @author wang
 *
 */
public class Offer27 {

	/**
	 * 递归方式
	 * 
	 * @param root
	 */
	public void mirrorRecursively(BinaryTreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;

		BinaryTreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		if (root.left != null) {
			mirrorRecursively(root.left);
		}
		if (root.right != null) {
			mirrorRecursively(root.right);
		}
	}

	/**
	 * 非递归方式
	 * 
	 * @param root
	 */
	public void mirrorByStack(BinaryTreeNode root) {

		if (root == null)
			return;

		Stack<BinaryTreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				BinaryTreeNode temp = root.left;
				root.left = root.right;
				root.right = temp;

				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}
		}
		
	}

}


