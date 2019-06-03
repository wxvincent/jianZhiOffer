package cn.itwx1;

import cn.source.TreeNode2;

/**
 * 二叉树的下一个节点
 *
 * @author wang
 */
public class Offer8 {

    public TreeNode2 getNextNode(TreeNode2 node) {
        if (node == null) return null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.father != null) {
            if (node.father.left == node) return node.father;
            node = node.father;
        }
        return null;
    }

}


