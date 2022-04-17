package jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 滑动窗口的最大值
 *
 * @author hubo88
 * @description 给定一个长度为 n 的数组 nums 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。  例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @link
 */
public class J59_maxInWindows {

    /**
     * 滑动窗口借助 队列 先进先出的特性
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        int begin;
        // 存储索引的队列
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty()) {
                q.add(i);
            // 通过这样保证 队列中的 index 都是生效的（在当前的滑动窗口中）
            } else if (begin > q.peekFirst()) {
                q.pollFirst();
            }
            // 通过这样 保证 队首元素 总是最大值
            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i]) {
                q.pollLast();
            }
            q.add(i);
            if (begin >= 0) {
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}
