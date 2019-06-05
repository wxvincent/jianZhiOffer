package cn.itwx3;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author wang
 */
public class Offer21 {

    public static void reOrderArray(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (i < j && (arr[i] & 1) != 0) {
                i++;
            }
            while (i < j && (arr[j] & 1) == 0) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reOrderArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
