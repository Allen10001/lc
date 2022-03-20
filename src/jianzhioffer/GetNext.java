package jianzhioffer;

/**
 * JZ8 二叉树的下一个结点
 *
 * @author hubo88
 * @description 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。下图为一棵有9个节点的二叉树。树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
 * @link https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=265&tqId=39212&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 8:32 PM
 */
public class GetNext {

    public class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 根据当前节点的右节点是否为空区分两种情况
        //1. 当前节点的右节点非空，找右节点的最左边的节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //2. 当前节点的右节点为空，需要根据当前节点是父节点的左节点还是右节点做出不同处理
        while (pNode.next != null) {
            if (pNode == pNode.next.left) { // 如果当前节点是父节点的左节点，直接返回父节点
                return pNode.next;
            }
            pNode = pNode.next;
        }
        // 只有当前节点是尾节点时才会，没找到，返回null
        return null;
    }

}
