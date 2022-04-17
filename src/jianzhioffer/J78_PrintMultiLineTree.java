package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 把二叉树打印成多行
 * 关键点：两个队列
 * @author hubo88
 * @description 给定一个节点数为 n 二叉树，要求从上到下按层打印二叉树的 val 值，同一层结点从左至右输出，每一层输出一行，将输出的结果存放到一个二维数组中返回。
 */
public class J78_PrintMultiLineTree {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null){
            return resList;
        }
        LinkedList<TreeNode> list1 = new LinkedList();
        LinkedList<TreeNode> list2 = new LinkedList();
        list1.offer(pRoot);
        while(!list1.isEmpty() || !list2.isEmpty()){

            if(!list1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!list1.isEmpty()) {
                    TreeNode node1 = list1.pop();
                    list.add(node1.val);
                    if (node1.left != null) {
                        list2.offer(node1.left);
                    }
                    if (node1.right != null) {
                        list2.offer(node1.right);
                    }
                }
                resList.add(list);
            }
            if(!list2.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!list2.isEmpty()) {
                    TreeNode node2 = list2.pop();
                    list.add(node2.val);
                    if (node2.left != null) {
                        list1.offer(node2.left);
                    }
                    if (node2.right != null) {
                        list1.offer(node2.right);
                    }
                }
                resList.add(list);
            }
        }
        return resList;
    }
}
