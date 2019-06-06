package cn.itwx6;

/**
 * 数组中唯一只出现一次的数字
 *
 * @author wang
 */
public class Offer56_2 {

    public int findNumberAppearingOnce(int[] arr) {
        if (arr == null || arr.length <= 0) throw new RuntimeException();

        int[] bitSum = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = arr[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;//此处需要先乘2，可以仔细想下
            result = result + (bitSum[i] % 3);
        }

        return result;
    }
}
