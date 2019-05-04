package cn.itwx6;

import cn.itwx6.Offer54.TreeNode;

/**
 * 二叉树的深度
 * @author wang
 *
 */
public class Offer55_1 {

	public int treeDepth(TreeNode root) {
		
		if(root==null) return 0;
		
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		
		return Math.max(left+1, right+1);
	}
	
	
	
}
