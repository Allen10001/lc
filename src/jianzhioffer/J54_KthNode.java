package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k个节点
 *
 * @author hubo88
 * @description 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1 3.保证n个节点的值不一样
 * @link
 */
public class J54_KthNode {

    private List<Integer> inOrderSet = new ArrayList<>();

    /**
     * 中序遍历的变形
     * @param proot
     * @param k
     * @return
     */
    public int KthNode(TreeNode proot, int k) {
        //    如果是空树，或者k == 0，返回 -1
        if (proot == null || k == 0) {
            return -1;
        }

        //    中序遍历，结果会保存到ArrayList中
        inOrder(proot);

        //    如果k的大小超过了ArrayList的容量大小，返回-1
        if (k > inOrderSet.size()) {
            return -1;
        }

        //    否则，说明k的大小在ArrayList的大小范围内，返回size-1处的数值
        return inOrderSet.get(k - 1);
    }

    //    中序遍历【中序遍历左，根结点，中序遍历右】
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        inOrderSet.add(root.val);
        inOrder(root.right);
    }
}
