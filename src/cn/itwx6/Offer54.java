package cn.itwx6;

import cn.source.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第K大节点
 *
 * @author wang
 */
public class Offer54 {

    public TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k <= 0) return null;
        List<TreeNode> list = new ArrayList<>();
        getKthNode(root, list);
        if (k > list.size()) return null;
        return list.get(k - 1);
    }

    private void getKthNode(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        getKthNode(root.left, list);
        list.add(root);
        getKthNode(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Offer54 offer54 = new Offer54();
        TreeNode treeNode = offer54.KthNode(node1, 3);
        System.out.println(treeNode.val);
    }

}
