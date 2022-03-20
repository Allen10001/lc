package jianzhioffer;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 *
 * @author hubo88

 * @link https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=265&tqId=39210&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 7:10 PM
 *
 * @description
 * 1. 递归解法
 * 2. 栈解法
 */
public class PrintListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}

