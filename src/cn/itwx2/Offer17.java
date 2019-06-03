package cn.itwx2;

/**
 * 打印从1到最大的n位数
 *
 * @author wang
 */
public class Offer17 {

    public static void print1ToMaxOfNDigits(int n) {
        int[] arr = new int[n];
        if (n <= 0) return;
        print(arr, 0);
    }

    private static void print(int[] arr, int index) {
        if (index == arr.length) {
            printNum(arr);
            return;
        }

        //循环让数字不断变化，递归使过程向后推进
        for (int i = 0; i < 10; i++) {
            arr[index] = i;
            print(arr, index + 1);
        }

    }

    private static void printNum(int[] arr) {
        boolean isFirstNo0 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i]);
                isFirstNo0 = true;
            } else {
                if (isFirstNo0) {
                    System.out.print(arr[i]);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }
}
