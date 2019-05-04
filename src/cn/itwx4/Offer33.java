package cn.itwx4;

/**
 * 二叉搜索树的后序遍历序列
 * @author wang
 *
 */
public class Offer33 {

	public boolean verifySquenceOfBST(int sequence[]){
		if(sequence == null || sequence.length==0){
			return false;
		}
		return verifySquenceOfBST1(sequence, 0, sequence.length - 1);
	}
	 
	private boolean verifySquenceOfBST1(int[] sequence, int start, int end) {
		if(start >= end){
			return true;
		}
		int root = sequence[end]; //后序遍历的最后一个结点为根结点
			
		//在二叉搜索树中左子树的结点小于根结点
		int i = 0;
		for(; i < end; ++i){
			if(sequence[i] > root){
				break;
			}
		}
			
		//在二叉搜索树中右子树的结点大于根结点
		int j = i;
		for(; j < end; ++j){
			if(sequence[j] < root){
				return false;
			}
		}
		//判断左子树是不是二叉树
		boolean left = true;
		if(i > start){
			left = verifySquenceOfBST1(sequence, start, i-1);
		}
		//判断右子树是不是二叉树
		boolean right = true;
		if(i < end){
			right = verifySquenceOfBST1(sequence, i, end -1); 
		}
		return (left && right);
	}

}
