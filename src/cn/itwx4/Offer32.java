package cn.itwx4;

import cn.source.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 从上到下打印二叉树
 * @author wang
 *
 */
public class Offer32 {
	
	/**
	 * 不分行从上到下打印二叉树
	 * @param node
	 * @return
	 */
	public ArrayList<Integer> printFromTopToBottom(BinaryTreeNode node){
		ArrayList<Integer> list = new ArrayList<>();
		if(node==null) return list;
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			list.add(temp.val);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
		
		return list;
	}
	
	/**
	 * 分行从上到下打印二叉树
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> print1(BinaryTreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root==null) return res;
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		ArrayList<Integer> list = new ArrayList<>();
		int start = 0;
		int end = 1;
		
		while(!queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
			list.add(node.val);
			start++;
			if(node.left!=null) queue.add(node.left);
			if(node.right!=null) queue.add(node.right);
			
			if(start==end) {
				start = 0;
				end = queue.size();
				res.add(new ArrayList<>(list));
				list.clear();
			}
		}
		
		return null;
	}
	
	/**
	 * 之字形打印二叉树
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> print2(BinaryTreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root==null) return res;
		
		Stack<BinaryTreeNode> stack1 = new Stack<>();
		Stack<BinaryTreeNode> stack2 = new Stack<>();
		
		stack1.push(root);
		int level = 1;
		ArrayList<Integer> list = new ArrayList<>();
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			if(level%2 == 1) {
				while(!stack1.isEmpty()) {
					BinaryTreeNode node = stack1.pop();
					if(node!=null) {
						list.add(node.val);
						stack2.push(node.left);
						stack2.push(node.right);
					}
				}
				
				if(!list.isEmpty()) {
					res.add(new ArrayList<>(list));
					level++;
					list.clear();
				}
			}else {
				while(!stack2.isEmpty()) {
					BinaryTreeNode node = stack2.pop();
					if(node!=null) {
						list.add(node.val);
						stack1.push(node.right);
						stack1.push(node.left);
					}
				}
				
				if(!list.isEmpty()) {
					res.add(new ArrayList<>(list));
					level++;
					list.clear();
				}
			}
		}
		
		return res;
	}
	
}

