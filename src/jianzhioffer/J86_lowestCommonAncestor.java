package jianzhioffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * 需要 和 二叉树搜索树的最近公共祖先 区别开
 * @author hubo88
 * @description
 * @link https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class J86_lowestCommonAncestor {

    /**
     * 层次遍历法变形
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        //记录遍历到的每个节点的父节点。
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root.val, Integer.MIN_VALUE);//根节点没有父节点，给他默认一个值
        queue.add(root);
        //直到两个节点都找到为止。
        while (!parent.containsKey(o1) || !parent.containsKey(o2)) {
            //队列是一边进一边出，这里poll方法是出队，
            TreeNode node = queue.poll();
            if (node.left != null) {
                //左子节点不为空，记录下他的父节点
                parent.put(node.left.val, node.val);
                //左子节点不为空，把它加入到队列中
                queue.add(node.left);
            }
            //右节点同上
            if (node.right != null) {
                parent.put(node.right.val, node.val);
                queue.add(node.right);
            }
        }
        // o1 的祖先节点集合
        Set<Integer> ancestors = new HashSet<>();
        //记录下o1和他的祖先节点，从o1节点开始一直到根节点。
        while (parent.containsKey(o1)) {
            ancestors.add(o1);
            o1 = parent.get(o1);
        }
        //查看o1和他的祖先节点是否包含o2节点，如果不包含再看是否包含o2的父节点……
        while (!ancestors.contains(o2)) {
            o2 = parent.get(o2);
        }
        return o2;
    }
}
