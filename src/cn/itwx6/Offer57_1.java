package cn.itwx6;

import java.util.ArrayList;

/**
 * 和为s的两个数字
 *
 * @author wang
 */
public class Offer57_1 {

    public ArrayList<Integer> findNumbersWithSum(int[] arr, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length <= 0) return list;

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                list.add(arr[low]);
                list.add(arr[high]);
                break;
            } else if (arr[low] + arr[high] < sum) {
                low++;
            } else {
                high--;
            }
        }
        return list;
    }
}
