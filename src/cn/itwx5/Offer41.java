package cn.itwx5;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 *
 * @author wang
 */
public class Offer41 {

    //小顶堆，默认容量为11
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //大顶堆，容量11
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, (i1, i2) -> i2 - i1);

    public void Insert(Integer num) {
        if (((minHeap.size() + maxHeap.size()) & 1) == 0) {//偶数时,下个数字加入小顶堆
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {//奇数时，下一个数字放入大顶堆
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if ((minHeap.size() + maxHeap.size()) == 0)
            throw new RuntimeException();
        double median;
        if ((minHeap.size() + maxHeap.size() & 1) == 0) {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            median = minHeap.peek();
        }
        return median;
    }

}
