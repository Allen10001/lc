package jianzhioffer;

/**
 * 链表中环的入口结点
 *
 * @author hubo88
 * @description 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 * @link https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * @date 2022/4/9 4:52 PM
 */

class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class J23_EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 无环
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        //先判断有没有环
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                //没有环,返回
                return null;
            }
        }

        //循环出来的话就是有环，且此时fast==slow.
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}



