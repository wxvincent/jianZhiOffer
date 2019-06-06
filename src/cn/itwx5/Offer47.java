package cn.itwx5;

/**
 * 礼物的最大价值
 *
 * @author wang
 */
public class Offer47 {

    public int maxValueOfGifts(int[][] values) {
        if (values == null || values.length < 1 || values[0].length < 1) return 0;

        int[][] matrix = new int[values.length][values[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    matrix[i][j] = values[0][0];
                } else if (i == 0) {
                    matrix[i][j] = matrix[0][j - 1] + values[0][j];
                } else if (j == 0) {
                    matrix[i][j] = matrix[i - 1][0] + values[i][0];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j] + values[i][j],
                            matrix[i][j - 1] + values[i][j]);
                }
            }
        }

        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String[] args) {
        Offer47 offer47 = new Offer47();
        int[][] matrix = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int i = offer47.maxValueOfGifts(matrix);
        System.out.println(i);
    }

}
