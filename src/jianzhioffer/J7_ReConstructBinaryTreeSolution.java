package jianzhioffer;

import java.util.Stack;

/**
 * 重建二叉树
 *
 * @author hubo88
 * @link https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=265&tqId=39211&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/12 6:58 PM
 * @description
描述
给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。

提示:
1.vin.length == pre.length
2.pre 和 vin 均无重复元素
3.vin出现的元素均出现在 pre里
4.只需要返回根结点，系统会自动输出整颗树做答案对比
数据范围：n \le 2000n≤2000，节点的值 -10000 \le val \le 10000−10000≤val≤10000
要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 */
public class J7_ReConstructBinaryTreeSolution {

    // Definition for binary tree
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方案1： 递归
     *
     * @return
     */
    class Solution01{

        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
            return root;
        }

        //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
        private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in,
            int startIn, int endIn) {

            if (startPre > endPre || startIn > endIn) {
                return null;
            }
            // 前序首节点即为根节点
            TreeNode root = new TreeNode(pre[startPre]);

            // 对中序进行遍历
            for (int i = startIn; i <= endIn; i++) {
                if (in[i] == pre[startPre]) {
                    root.left = reConstructBinaryTree(pre, startPre + 1, startPre + (i - startIn), in,
                        startIn, i - 1);
                    root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in,
                        i + 1, endIn);
                    break;
                }
            }
            return root;
        }
    }

    /**
     * 方案2：栈
     * 解题思路：
     * 二叉树的前序遍历：根左右；中序遍历：左根右
     * 借助栈来解决问题需要关注一个问题，就是前序遍历挨着的两个值比如m和n，它们会有下面两种情况之一的关系。
     * 1、n是m左子树节点的值。
     * 2、n是m右子树节点的值或者是m某个祖先节点的右节点的值。
     * 对于第一种情况很容易理解，如果m的左子树不为空，那么n就是m左子树节点的值。
     * 对于第二种情况，如果一个结点没有左子树只有右子树，那么n就是m右子树节点的值，如果一个结点既没有左子树也没有右子树，那么n就是m某个祖先节点的右节点，只要找到这个祖先节点就可以
     */
    class Solution02 {

        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            if (pre.length == 0) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<>();
            // 1. 前序的第一个其实就是根节点
            TreeNode root = new TreeNode(pre[0]);
            TreeNode cur = root;
            // 2. 只需要遍历前序列表
            for (int i = 1, j = 0; i < pre.length; i++) {
                //第一种情况
                if (cur.val != in[j]) {  // 说明有左子树
                    cur.left = new TreeNode(pre[i]);
                    stack.push(cur);
                    cur = cur.left;
                } else { //第二种情况
                    j++;
                    //找到合适的cur，然后确定他的右节点
                    while (!stack.empty() && stack.peek().val == in[j]) {
                        cur = stack.pop();
                        j++;
                    }
                    //给cur添加右节点
                    cur = cur.right = new TreeNode(pre[i]);
                }
            }
            return root;
        }
    }

}




