package cn.itwx6;

import java.util.LinkedList;

/**
 * 队列的最大值
 *
 * @author wang
 */
public class Offer59_2 {

    private LinkedList<InternalData> data = new LinkedList<>();
    private LinkedList<InternalData> max = new LinkedList<>();

    private class InternalData {
        int number;
        int index;

        public InternalData(int number, int index) {
            super();
            this.number = number;
            this.index = index;
        }
    }

    private int curIndex;

    public void push(int number) {
        InternalData curData = new InternalData(number, curIndex);
        data.addLast(curData);

        while (!max.isEmpty() && max.getLast().number < number) {
            max.removeLast();
        }
        max.addLast(curData);
        curIndex++;
    }

    public int pop() {
        if (data.isEmpty()) throw new RuntimeException();
        InternalData curData = data.removeFirst();
        if (curData.index == max.getFirst().index) {
            max.removeFirst();
        }
        return curData.number;
    }

    public int max() {
        if (max.isEmpty()) throw new RuntimeException();
        return max.getFirst().number;
    }

}
