package cn.itwx4;

import cn.source.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
 * @author wang
 *
 */
public class Offer34 {

	public static ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode root, int expectedSum){
		if(root==null) return null;
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
		Stack<Integer> path = new Stack<>();
		findPath(root,expectedSum,path,pathList);
		return pathList;
	}

	private static void findPath(BinaryTreeNode root, int expectedSum, Stack<Integer> path,
			ArrayList<ArrayList<Integer>> pathList) {
		if(root==null) return;
		if(root.left==null && root.right==null) {
			if(root.val==expectedSum) {
				//这样做的话就省去最后删除当前节点的步骤，因为它没有加入最后一个数
				ArrayList<Integer> list = new ArrayList<>();
				for (Integer integer : path) {
					list.add(integer);
				}
				list.add(root.val);
				pathList.add(list);
			}
		}else {
			path.push(root.val);
			findPath(root.left, expectedSum-root.val, path, pathList);
			findPath(root.right, expectedSum-root.val, path, pathList);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode(8);
		BinaryTreeNode node1 = new BinaryTreeNode(8);
		BinaryTreeNode node2 = new BinaryTreeNode(7);
		BinaryTreeNode node3 = new BinaryTreeNode(9);
		BinaryTreeNode node4 = new BinaryTreeNode(2);
		BinaryTreeNode node5 = new BinaryTreeNode(4);
		BinaryTreeNode node6 = new BinaryTreeNode(7);
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		
		ArrayList<ArrayList<Integer>> list = findPath(root1, 25);
		for (ArrayList<Integer> arrayList : list) {
			for (Integer integer : arrayList) {
				System.out.println(integer);
			}
		}
	}
	
}
