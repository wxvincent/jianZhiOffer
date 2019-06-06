package cn.itwx6;

/**
 * 在排序数组中查找数字
 *
 * @author wang
 */
public class Offer53_1 {

    public int getNumberOfK(int[] arr, int k) {
        if (arr == null || arr.length <= 0) return 0;
        int firstK = getFirstK(arr, 0, arr.length - 1, k);
        if (firstK == -1) return 0;
        int lastK = getLastK(arr, firstK, arr.length - 1, k);
        return lastK - firstK + 1;
    }

    private int getFirstK(int[] arr, int start, int end, int k) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        if (arr[mid] == k) {
            if (mid == 0 || arr[mid - 1] != k) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (arr[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getFirstK(arr, start, end, k);
    }

    private int getLastK(int[] arr, int start, int end, int k) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        if (arr[mid] == k) {
            if (mid == arr.length - 1 || arr[mid + 1] != k) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else {
            end = mid - 1;
        }
        return getLastK(arr, start, end, k);
    }

    public static void main(String[] args) {
        Offer53_1 offer53 = new Offer53_1();
        int[] arr = {1, 2, 3, 4, 4, 5, 5, 6, 7};
        int i = offer53.getNumberOfK(arr, 8);
        System.out.println(i);
    }


}
