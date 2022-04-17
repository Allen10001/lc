package jianzhioffer;

/**
 * 二叉树中和为某一值的路径(一)
 *
 * @author hubo88
 * @description 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点 2.叶子节点是指没有子节点的节点 3.路径只能从父节点到子节点，不能从子节点到父节点 4.总节点数目为n
 */
public class J82_hasPathSum {


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        int count = 0;
        return hasPathSolution(root, sum, count);
    }

    public boolean hasPathSolution(TreeNode node, int sum, int count) {
        if (node == null) {
            return false;
        }
        boolean isLeaf = node.left == null && node.right == null;
        count += node.val;
        if (isLeaf && count == sum) {
            return true;
        }
        if (node.left != null && hasPathSolution(node.left, sum, count)) {
            return true;
        }
        if (node.right != null && hasPathSolution(node.right, sum, count)) {
            return true;
        }
        count -= node.val;
        return false;
    }
}
