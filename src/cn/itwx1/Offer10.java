package cn.itwx1;

/**
 * 斐波那契数列的解法
 *
 * @author wang
 */
public class Offer10 {

    public int feibonacciByRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return feibonacciByRecursive(n - 1) + feibonacciByRecursive(n - 2);
    }

    public int feibonacciByCur(int n) {
        if (n <= 1) return n;

        int res = 0;
        int feibo1 = 0;
        int feibo2 = 1;
        for (int i = 0; i < n - 1; i++) {
            res = feibo1 + feibo2;
            feibo1 = feibo2;
            feibo2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer10 offer10 = new Offer10();
        int i = offer10.feibonacciByCur(6);
        System.out.println(i);
    }


}
