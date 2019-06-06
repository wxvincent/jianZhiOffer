package cn.itwx5;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * @author wang
 */
public class Offer45 {

    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return null;
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        });

        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

}
