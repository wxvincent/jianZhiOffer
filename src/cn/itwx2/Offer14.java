package cn.itwx2;

/**
 * 剪绳子
 *
 * @author wang
 */
public class Offer14 {

    /**
     * 动态规划:注意1、2、3要单独考虑
     * @param length
     * @return
     */
    public int maxProductAfterCutting_solution(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int[] product = new int[length + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (max < product[j] * product[i - j]) {
                    max = product[j] * product[i - j];
                }
            }
            product[i] = max;
        }

        return product[length];
    }

    public int maxProductAfterCutting_solution2(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }


}
