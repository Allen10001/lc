package jianzhioffer;

/**
 * 复杂链表的复制
 *
 * @author hubo88
 * @description 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）。
 * 下图是一个含有5个结点的复杂链表。图中实线箭头表示next指针，虚线箭头表示random指针。为简单起见，指向null的指针没有画出。
 * @link https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * @date 2022/4/9 9:40 PM
 */
public class J35_ListClone {

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        RandomListNode clonedHead = null;
        RandomListNode pListHead = null;
        pListHead = CloneNode(pHead);
        pListHead = makeRandomIndex(pListHead);
        clonedHead = splitList(pListHead);
        return clonedHead;
    }
    //1.复制每个节点，将每个复制的节点放置于被复制的节点后面
    private RandomListNode CloneNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode clonedNode = new RandomListNode(pNode.label);
            clonedNode.next=pNode.next;
            pNode.next=clonedNode;
            pNode=clonedNode.next;
        }
        return pHead;
    }

    //2.为每个复制的节点的random引用赋值,其值是原来节点的random引用的下一个节点
    private RandomListNode makeRandomIndex(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode clonedNode = pNode.next;
            if(pNode.random!=null)//报空指针了，节操何在
                clonedNode.random = pNode.random.next;
            pNode = clonedNode.next;
        }
        return pHead;
    }

    //3.拆分链表
    private RandomListNode splitList(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode clonedHead = null;
        RandomListNode clonedNode = null;
        if(pNode!=null){
            clonedHead = pHead.next;
            clonedNode = clonedHead;
            pNode.next = clonedNode.next;
            pNode = clonedNode.next;
        }

        while(pNode!=null){
            clonedNode.next = pNode.next;
            clonedNode = clonedNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        return clonedHead;
    }
}
