package cn.itwx1;

import cn.source.TreeNode;

import java.util.Arrays;

/**
 * 根据前序遍历与中序遍历重建二叉树
 * @author wang
 *
 */
public class Offer7 {
	
	public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
		if(pre==null || in==null) return null;
		if(pre.length==0 || in.length==0) return null;
		if(pre.length!=in.length) return null;
		
		TreeNode root = new TreeNode(pre[0]);
		for (int i = 0; i < in.length; i++) {
			if(pre[0]==in[i]) {
				root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), 
						Arrays.copyOfRange(in, 0, i));
				root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), 
						Arrays.copyOfRange(in, i+1, in.length));
			}
		}
		return root;
	}
	
}

