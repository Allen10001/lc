package jianzhioffer;

/**
 * JZ16 数值的整数次方
 *
 * @author hubo88
 * @description 实现函数 double Power(double base, int exponent)，求base的exponent次方。  注意：
 * 1.保证base和exponent不同时为0。 2.不得使用库函数，同时不需要考虑大数问题 3.有特殊判题，不用考虑小数点后面0的位数。
 * @link https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=265&tqId=39220&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/20 7:48 PM
 */
public class J16_Power {

    /**
     * 1. 直接暴力法
     * 时间复杂度O(N)：循环计算只需要根据 exponent 的大小
     * 空间复杂度O(1)：需要常数级空间
     */
    class Solution01 {

        public double ower(double base, int exponent) {
            if (base == 0 && exponent < 0) {
                throw new RuntimeException("0 can not be denominator");
            }
            int absNum = exponent;
            if (exponent < 0) {
                absNum = -exponent;
            }
            double result = calculatePower(base, absNum);
            if (exponent < 0) {
                result = 1 / result;
            }
            return result;
        }

        private double calculatePower(double base, int exponent) {
            double result = 1;
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
            return result;
        }
    }

    /**
     * 2.
     * 算法思想二：递归
     * 如果exponent == 0，返回1
     * 如果exponent < 0，最终结果为 1 / x^{-n}
     * 如果exponent为奇数，最终结果为 x^n = x*((x*x)^(n/2))   （找规律得到）
     * 如果exponent为偶数，最终结果为 x^n = x^{2*(n/2)}
     * 时间复杂度：O(logn)：其中n表示exponent
     * 空间复杂度：O(logn)
     */
    class Solution02 {
        public double Power(double base, int exponent) {
            // 1. 递归结束条件：如果exponent等于0，直接返回1
            if (exponent == 0) {
                return 1;
            }
            // 2. 如果exponent小于0，把它改为正数
            if (exponent < 0) {
                return Power(1 / base, -exponent);
            }
            // 3. 根据exponent是奇数还是偶数来做不同的处理 递归
            return (exponent % 2 == 0) ? Power(base * base, exponent / 2) : base * Power(base * base, exponent / 2);
        }
    }
}