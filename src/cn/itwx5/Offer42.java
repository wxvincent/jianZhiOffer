package cn.itwx5;

/**
 * 连续子数组的最大和
 *
 * @author wang
 */
public class Offer42 {

    public static int findGreatSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            if (dp[i] > max) max = dp[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int i = findGreatSumOfSubArray(arr);
        System.out.println(i);
    }

}
