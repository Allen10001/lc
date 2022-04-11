package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 *
 * @author hubo88
 * @description
 * @link
 */
public class J40_GetLeastNumbers_Solution {

    /**
     * 使用最大堆保存着k个数，最后返回最大堆中的数据即可
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        if (input == null || k == 0 || k > input.length) {
            return resList;
        }
        // java中的优先队列基于堆实现, 此处创建一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                maxHeap.offer(input[i]);
            } else {
                if (input[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }

        for (Integer item : maxHeap) {
            resList.add(item);
        }
        return resList;
    }
}
