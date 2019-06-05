package cn.itwx3;

import cn.source.BinaryTreeNode;

/**
 * 对称的二叉树
 *
 * @author wang
 */
public class Offer28 {

    public boolean isSymmetrical(BinaryTreeNode root) {
        if (root == null) return true;
        return isCommon(root.left, root.right);
    }

    private boolean isCommon(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null) {
            return left.val == right.val &&
                    isCommon(left.left, right.right) &&
                    isCommon(left.right, right.left);
        }
        return false;
    }

}
