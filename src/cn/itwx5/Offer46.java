package cn.itwx5;

/**
 * 把数字翻译成字符串
 *
 * @author wang
 */
public class Offer46 {

    public int getTranslationCount(int number) {
        if (number < 0) return 0;
        String str = String.valueOf(number);
        int len = str.length();
        int[] counts = new int[len];
        counts[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            counts[i] = counts[i + 1];
            if (canBeTrans(str, i)) {
                if (i == len - 2) {
                    counts[i] += 1;
                } else {
                    counts[i] += counts[i + 2];
                }
            }
        }
        return counts[0];
    }

    private boolean canBeTrans(String str, int i) {
        int a = str.charAt(i) - '0';
        int b = str.charAt(i + 1) - '0';
        int c = a * 10 + b;
        if (c >= 10 && c <= 25) return true;

        return false;
    }

}
