package cn.itwx6;

/**
 * 左旋转字符串
 *
 * @author wang
 */
public class Offer58_2 {

    public String leftRotateString(char[] chars, int n) {
        if (chars == null || chars.length <= 0) return null;
        if (n <= 0 || n > chars.length) return null;

        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }


}
