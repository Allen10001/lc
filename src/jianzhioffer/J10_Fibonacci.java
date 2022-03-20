package jianzhioffer;

import java.util.ArrayList;

/**
 * JZ10 斐波那契数列
 *
 * @author hubo88
 * @description 描述 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 * @link https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=265&tqId=39214&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 8:58 PM
 * <p>
 * 方法一：递归 题目分析，斐波那契数列公式为：f[n] = f[n-1] + f[n-2], 初始值f[0]=0, f[1]=1，目标求f[n] 看到公式很亲切，代码秒秒钟写完。
 * <p>
 * class Solution { public: int J10_Fibonacci(int n) { if (n<=2) return 1; return J10_Fibonacci(n-1) +
 * J10_Fibonacci(n-2); } }; 优点，代码简单好写，缺点：慢，会超时 时间复杂度：O(2^n) 空间复杂度：递归栈的空间
 *
 * 方法二：dp，时间复杂度：O（n） 空间复杂度：O（n）
 */
public class J10_Fibonacci {

    /**
     * 实现方法二，该解最优
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        int[] ints = new int[n+1];
        ints[1]=1;
        ints[2]=1;
        for (int i = 3; i <ints.length ; i++) {
            ints[i]=ints[i-1]+ints[i-2];
        }
        return ints[n];
    }
}
