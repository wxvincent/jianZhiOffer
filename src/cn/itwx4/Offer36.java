package cn.itwx4;

import cn.source.BinaryTreeNode;

/**
 * 二叉搜索树与双向链表
 *
 * @author wang
 */
public class Offer36 {

    public BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode head = convertNode(root, null);
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private BinaryTreeNode convertNode(BinaryTreeNode root, BinaryTreeNode lastList) {
        if (root == null) return null;
        if (root.left != null) {
            lastList = convertNode(root.left, lastList);
        }
        root.left = lastList;
        if (lastList != null) {
            lastList.right = root;
        }
        lastList = root;
        if (root.right != null) {
            lastList = convertNode(root.right, lastList);
        }
        return lastList;
    }

}
