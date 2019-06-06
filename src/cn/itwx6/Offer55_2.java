package cn.itwx6;


import cn.source.TreeNode;

/**
 * 平衡二叉树
 *
 * @author wang
 */
public class Offer55_2 {

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;

        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }


}
