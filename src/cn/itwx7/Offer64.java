package cn.itwx7;

/**
 * 求1+2+。。。+n
 *
 * @author wang
 */
public class Offer64 {

    public int getSum(int n) {
        int sum = n;

        boolean flag = (n > 1) && ((sum += getSum(n - 1)) > 0);
        return sum;
    }


}
