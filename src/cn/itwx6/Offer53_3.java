package cn.itwx6;

/**
 * 数组中数值和下标相等的元素
 *
 * @author wang
 */
public class Offer53_3 {

    public int getNumberSameAsIndex(int[] arr) {
        if (arr == null || arr.length <= 0) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] > mid) {
                high = mid - 1;
            } else if (arr[mid] < mid) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
