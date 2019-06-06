package cn.itwx6;

/**
 * 数组中的逆序对
 *
 * @author wang
 */
public class Offer51 {

    public int inversePairs(int[] arr) {
        if (arr == null || arr.length <= 0) return 0;
        int count = getCount(arr, 0, arr.length - 1);
        return count;
    }

    private int getCount(int[] arr, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) >> 1;
        int left = getCount(arr, start, mid);
        int right = getCount(arr, mid + 1, end);

        int count = 0;
        int i = mid;
        int j = end;
        int[] temp = new int[end - start + 1];
        int k = end - start;//临时区域的指针
        while (i >= start && j >= mid + 1) {
            if (arr[i] > arr[j]) {
                count += j - mid;
                temp[k--] = arr[i--];
            } else {
                temp[k--] = arr[j--];
            }
        }
        while (i >= start) {
            temp[k--] = arr[i--];
        }
        while (j >= start) {
            temp[k--] = arr[j--];
        }
        System.arraycopy(temp, 0, arr, start, temp.length);
        return count + left + right;
    }

}
