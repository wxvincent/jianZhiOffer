package cn.itwx5;

/**
 * 丑数
 *
 * @author wang
 */
public class Offer49 {

    public int getUglyNumber(int index) {
        if (index <= 0) return 0;
        int[] arr = new int[index];
        arr[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < arr.length; i++) {
            int min = Math.min(arr[multiply2] * 2,
                    Math.min(arr[multiply3] * 3, arr[multiply5] * 5));
            arr[i] = min;

            if (arr[multiply2] * 2 == min) multiply2++;
            if (arr[multiply3] * 3 == min) multiply3++;
            if (arr[multiply5] * 5 == min) multiply5++;
        }
        return arr[index - 1];
    }

}
