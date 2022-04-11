package jianzhioffer;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author hubo88
 * @description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
 * @link https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * @date 2022/4/9 6:27 PM
 */
public class J30_minStack {

    Stack numStack = new Stack();
    Stack minStack = new Stack();

    public void push(int node) {
        if (numStack.empty() == true) {
            numStack.push(node);
            minStack.push(node);
        } else {
            int min = (int) minStack.peek();
            if (node < min) {
                numStack.push(node);
                minStack.push(node);
            } else {
                numStack.push(node);
            }
        }
    }

    public void pop() {
        int min = (int) minStack.peek();
        if ((int) numStack.pop() == min) {
            minStack.pop();
        }
    }

    public int top() {
        return (int) numStack.peek();
    }

    public int min() {
        return (int) minStack.peek();
    }
}
