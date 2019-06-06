package cn.itwx6;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 *
 * @author wang
 */
public class Offer59_1 {

    public ArrayList<Integer> maxInWindow(int[] num, int size) {
        ArrayList<Integer> max = new ArrayList<>();
        if (num == null || num.length <= 0 || size <= 0 || size > num.length) return max;

        LinkedList<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexQueue.isEmpty() && num[i] > num[indexQueue.getLast()]) {
                indexQueue.removeLast();
            }
            indexQueue.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!indexQueue.isEmpty() && num[i] > num[indexQueue.getLast()]) {
                indexQueue.removeLast();
            }
            while (!indexQueue.isEmpty() && (i - indexQueue.getFirst()) >= size) {
                indexQueue.removeFirst();
            }
            indexQueue.addLast(i);
            max.add(num[indexQueue.getFirst()]);
        }

        return max;
    }


}
