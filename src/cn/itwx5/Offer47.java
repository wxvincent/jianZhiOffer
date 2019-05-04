package cn.itwx5;

/**
 * 礼物的最大价值
 * @author wang
 *
 */
public class Offer47 {

	public int maxValueOfGifts(int[][] values) {
		if(values==null || values.length<1 || values[0].length<1) {
			return 0;
		}
		int row = values.length;
		int col = values[0].length;
		int[] maxValue = new int[col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int left = 0;
				int up = 0;
				if(i>0) {
					up = maxValue[j];
				}
				if(j>0) {
					left = maxValue[j-1];
				}
				maxValue[j] = Math.max(up, left)+values[i][j];
			}
		}
		return maxValue[col-1];
	}
	
}
