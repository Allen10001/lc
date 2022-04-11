package jianzhioffer;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径(二)
 *
 * @author hubo88
 * @description 输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点 2.叶子节点是指没有子节点的节点 3.路径只能从父节点到子节点，不能从子节点到父节点 4.总节点数目为n
 * @link https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * @date 2022/4/9 9:23 PM
 */

public class J34_FindPath {

    class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return resultList;
        }
        int curSum = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        FindPathByNode(root, target, root, curSum, resultList, list);

        return resultList;
    }

    //考虑递归函数的结构，每个节点进入之后首先进行什么样的处理，结束的条件
    private void FindPathByNode(TreeNode root, int target, TreeNode curNode,
        int curSum, ArrayList<ArrayList<Integer>> resultList,
        ArrayList<Integer> list) {

        list.add(curNode.val);
        curSum += curNode.val;
        boolean isLeaf = curNode.left == null && curNode.right == null;
        if (isLeaf && curSum == target) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            boolean bool = tempList.addAll(list);
            if (bool) {
                resultList.add(tempList);
            }
        } else {
            if (curNode.left != null) {
                FindPathByNode(root, target, curNode.left,
                    curSum, resultList, list);
            }
            if (curNode.right != null) {
                FindPathByNode(root, target, curNode.right,
                    curSum, resultList, list);
            }
        }

        //出栈前进行什么操作
        list.remove(list.size() - 1);
        curSum -= curNode.val;
    }

}
