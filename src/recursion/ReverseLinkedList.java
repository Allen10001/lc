package recursion;

/**
 * 用递归的方式翻转链表
 *
 * @author hubo88
 * @description
 * @date 2022/4/19 5:22 PM
 */

public class ReverseLinkedList {

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public Node solution(Node pre, Node cur){
        if (cur.next == null) {
            cur.next = pre;
            return cur;
        }
        Node sltNode = solution(cur, cur.next);
        cur.next = pre;
        return sltNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node head = reverseLinkedList.solution(null, node1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
