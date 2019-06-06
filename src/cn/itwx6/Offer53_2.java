package cn.itwx6;

/**
 * 0~n-1中缺失的数字
 *
 * @author wang
 */
public class Offer53_2 {

    public static int getMissingNumber(int[] arr) {
        if (arr == null || arr.length <= 0) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] != mid) {
                if (mid == 0 || arr[mid - 1] == mid - 1) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4, 5};
        int number = getMissingNumber(arr);
        System.out.println(number);
    }
}
