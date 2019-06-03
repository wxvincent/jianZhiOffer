package cn.itwx2;

/**
 * 二进制中1的个数
 *
 * @author wang
 */
public class Offer15 {

    public static int numOf1(int n) {
        int count = 0;
        while (n != 0) {
            //将一个整数减1，再与原整数做位与运算，可消去最右边的1
            n = (n - 1) & n;
            count++;
        }
        return count;
    }

}
