package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树中和为某一值的路径(三)
 *
 * @author hubo88
 * @description 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。 1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
 * 2.总节点数目为n 3.保证最后返回的路径个数在整形范围内(即路径个数小于231-1)
 */
public class J84_FindPath3 {

    int result = 0;

    public void cengci(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            result++;
        }
        //递归遍历左右子树
        cengci(root.left, sum - root.val);
        cengci(root.right, sum - root.val);
    }

    public int FindPath(TreeNode root, int sum) {
        // write code here
        //如果为空直接返回
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.poll();
            //遍历当前层
            cengci(tmp, sum);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return result;
    }

}
