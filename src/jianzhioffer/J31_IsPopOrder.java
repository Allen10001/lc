package jianzhioffer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author hubo88
 * @description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 1. 0<=pushV.length == popV.length <=1000 2. -1000<=pushV[i]<=1000 3. pushV 的所有数字均不相同
 * @link https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * @date 2022/4/9 6:31 PM
 */
public class J31_IsPopOrder {

    /**
     * 题干中 所有数字都不相同很重要
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        boolean bool = false;
        Stack<Integer> stack = new Stack<Integer>();
        int pushIndex = 0, popIndex = 0;
        if (pushA != null || popA != null) {
            while (pushIndex < pushA.length) {
                stack.push(pushA[pushIndex]);
                // 两个数组的长度相等，popIndex < popA.length 条件可以不加
                while (popIndex < popA.length && !stack.isEmpty() && stack.peek() == popA[popIndex]) {
                    stack.pop();
                    popIndex++;
                    if (popIndex == popA.length) {
                        break;  // 跳出单层循环
                    }
                }
                pushIndex++;
            }
        }
        //按照上面的逻辑，所有入栈的都能出栈，说明popA是pushA的弹出序列
        if (stack.size() == 0) {
            bool = true;
        }
        return bool;
    }

    public static void main(String[] args) {
        J31_IsPopOrder j31_isPopOrder = new J31_IsPopOrder();
        int[] pushA = {2,1,0};
        int[] popA = {1,2,0};
        System.out.println(j31_isPopOrder.IsPopOrder(pushA, popA));
    }
}
