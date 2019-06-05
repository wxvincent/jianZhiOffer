package cn.itwx4;

import java.util.ArrayList;

/**
 * 最小的K个数
 *
 * @author wang
 */
public class Offer40 {

    //使用大顶堆即可
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) return leastNumbers;

        int[] numbers = new int[k];  //用于放最小的k个数
        for (int i = 0; i < k; i++) {
            numbers[i] = input[i];//先放入前k个数
        }
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(numbers, i, k - 1);//将数组构造成最大堆形式
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < numbers[0]) { //存在更小的数字时
                numbers[0] = input[i];
                adjustHeap(numbers, 0, k - 1);//重新调整最大堆
            }
        }
        for (int n : numbers) {
            leastNumbers.add(n);
        }
        return leastNumbers;
    }

    //最大堆的调整方法，忘记时可以复习一下堆排序。
    private void adjustHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = start * 2 + 1; i <= end; i = i * 2 + 1) {
            if (i < end && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;
    }

}
