package jianzhioffer;

import java.util.ArrayList;

/**
 * 丑数
 *
 * @author hubo88
 * @description 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第 n个丑数。
 * @link
 */
public class J49_GetUglyNumber_Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        // 每个更大的丑数的产生都是在原来丑数的基础上*（2|3|5） 得到的， 定义三个记忆指针，分别指向 *2 *3 *5 的原来丑数走的位置
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index)//循环的条件
        {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2) {
                i2++;
            }
            if (min == m3) {
                i3++;
            }
            if (min == m5) {
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }
}
