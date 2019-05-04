package cn.itwx6;

/**
 * 二叉搜索树的第K大节点
 * @author wang
 *
 */
public class Offer54 {

	public TreeNode KthNode(TreeNode root,int k) {
		TreeNode node = null;
		if(root==null || k<=0) return node;
		node = getKthNode(root,k);
		return node;
	}
	
	private TreeNode getKthNode(TreeNode root, int k) {
		TreeNode node = null;
		
		if(root.left!=null) {
			node = getKthNode(root.left, k);
		}
		
		if(node==null) {
			if(k==1) {
				node = root;
			}
			k--;
		}
		
		if(node==null && root.right!=null) {     
			node = getKthNode(root.right, k);
		}
		return node;
	}



	public class TreeNode{
		int val = 0;
        TreeNode left = null;
        TreeNode right = null;
 
        public TreeNode(int val) {
            this.val = val;
        }
	}
}
