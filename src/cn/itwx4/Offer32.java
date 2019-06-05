package cn.itwx4;

import cn.source.BinaryTreeNode;

import java.util.*;


/**
 * 从上到下打印二叉树
 *
 * @author wang
 */
public class Offer32 {

    /**
     * 不分行从上到下打印二叉树
     *
     * @param node
     * @return
     */
    public ArrayList<Integer> printFromTopToBottom(BinaryTreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null) return list;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        return list;
    }

    /**
     * 分行从上到下打印二叉树
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> print1(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                BinaryTreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }

        return res;
    }

    /**
     * 之字形打印二叉树
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> print2(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack1.push(root);
        int level = 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (level % 2 == 1) {
                while (!stack1.isEmpty()) {
                    BinaryTreeNode node = stack1.pop();
                    if (node != null) {
                        list.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }
                }

                if (!list.isEmpty()) {
                    res.add(new ArrayList<>(list));
                    level++;
                    list.clear();
                }
            } else {
                while (!stack2.isEmpty()) {
                    BinaryTreeNode node = stack2.pop();
                    if (node != null) {
                        list.add(node.val);
                        stack1.push(node.right);
                        stack1.push(node.left);
                    }
                }

                if (!list.isEmpty()) {
                    res.add(new ArrayList<>(list));
                    level++;
                    list.clear();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Offer32 offer32 = new Offer32();
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        ArrayList<ArrayList<Integer>> res = offer32.print1(root);
        for (ArrayList<Integer> list : res) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

}

