package cn.itwx3;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * @author wang
 *
 */
public class Offer29 {

	public ArrayList<Integer> printMatrix(int[][] matrix){
		
		ArrayList<Integer> list = new ArrayList<>();
		if(matrix==null) return list;
		int start = 0;
		while(matrix.length>start*2 && matrix[0].length>start*2) {
			printOneCircle(matrix,start,list);
			start++;
		}
		return list;
	}

	private void printOneCircle(int[][] matrix, int start, ArrayList<Integer> list) {
		int endX = matrix[0].length-1-start;
		int endY = matrix.length-1-start;
		
		for (int i = start; i <= endX; i++) {
			list.add(matrix[start][i]);
		}
		
		if(start<endY) {
			for (int i = start+1; i <=endY; i++) {
				list.add(matrix[i][endX]);
			}
		}
		
		if(start<endX && start<endY) {
			for (int i = endX-1; i >= start; i--) {
				list.add(matrix[endY][i]);
			}
		}
		
		if(start<endX && start<endY-1) {
			for (int i = endY-1; i >= start+1; i--) {
				list.add(matrix[i][start]);
			}
		}
	}
	
}
