package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 * 关键点： 两个栈
 * @author hubo88
 * @description 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 */
public class J77_PrintZTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return listAll;
        }
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        int current = 0, next = 1;
        stacks[0].push(pRoot);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (stacks[0].size() != 0 || stacks[1].size() != 0) {
            TreeNode TreeNode = stacks[current].pop();
            list.add(TreeNode.val);
            if (current == 0) {
                if (TreeNode.left != null) {
                    stacks[next].push(TreeNode.left);
                }
                if (TreeNode.right != null) {
                    stacks[next].push(TreeNode.right);
                }
            } else {
                if (TreeNode.right != null) {
                    stacks[next].push(TreeNode.right);
                }
                if (TreeNode.left != null) {
                    stacks[next].push(TreeNode.left);
                }
            }
            if (stacks[current].size() == 0) {
                listAll.add(list);
                list = new ArrayList<Integer>();
                current = 1 - current;
                next = 1 - next;
            }
        }
        return listAll;
    }
}
