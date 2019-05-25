package cn.itwx2;

/**
 * 旋转数组的最小数字
 *
 * @author wang
 */
public class Offer11 {

    public static int minNumInRotateArray(int[] arr) throws Exception {
        if (arr == null || arr.length <= 0) {
            throw new Exception("错误的输入");
        }
        if (arr.length == 1) return arr[0];

        int left = 0;
        int right = arr.length - 1;
        int mid = left;

        while (arr[left] >= arr[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (arr[left] == arr[right] && arr[left] == arr[mid]) {
                int temp = arr[left];
                for (int i = left + 1; i <= right; i++) {
                    if (arr[i] < temp) {
                        temp = arr[i];
                    }
                }
                return temp;
            }

            if (arr[left] <= arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return arr[mid];
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {3, 3, 4, 4, 5, 1, 2, 2};
        int i = minNumInRotateArray(arr);
        System.out.println(i);
    }
}
