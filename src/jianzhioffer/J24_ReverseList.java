package jianzhioffer;

/**
 * 反转链表
 *
 * @author hubo88
 * @description 给定一个单链表的头结点pHead(该头节点是有值的 ， 比如在下图 ， 它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * @link https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class J24_ReverseList {

    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode pre=null;
        ListNode Nnext=null;
        while(head!=null){
            Nnext = head.next;
            head.next = pre;
            pre = head;
            head = Nnext;
        }
        return pre;
    }
}
