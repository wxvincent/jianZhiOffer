package cn.itwx1;

/**
 * 二维数组中的查找
 *
 * @author wang
 */
public class Offer4 {

    public static boolean findNum(int[][] arr, int num) {
        if (arr == null) return false;
        int row = 0;
        int col = arr[0].length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == num) return true;

            if (arr[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
