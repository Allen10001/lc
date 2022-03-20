package jianzhioffer;

/**
 * JZ15 二进制中1的个数
 *
 * @author hubo88
 * @description 输入一个整数 n ，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * @link https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=265&tqId=39219&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 10:06 PM
 */
public class J15_NumberOf1 {
    public int numberOf1(int n) {
        int count = 0;
        while(n!=0){// 说明n的二进制表示里面还有1呢
            count++;
            n = n-1 & n;   // n 和 n-1 与之后，总会去掉n的二进制表示的最后一位的1
        }
        return count;
    }
}
