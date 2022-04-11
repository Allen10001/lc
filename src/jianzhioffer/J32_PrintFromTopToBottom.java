package jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 从上往下打印二叉树
 *
 * @author hubo88
 * @description 不分行从上往下打印出二叉树的每个节点，同层节点从左至右打印。例如输入{8,6,10,#,#,2,1}，如以下图中的示例二叉树，则依次打印8,6,10,2,1(空节点不打印，跳过)，请你将打印的结果存放到一个数组里面，返回。
 * @link https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=265&tqId=39234&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/4/9 8:05 PM
 */
public class J32_PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return (ArrayList<Integer>) list;
        }
        Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node05 = queue.poll();
            list.add(node05.val);
            if (node05.left != null) {
                queue.add(node05.left);
            }
            if (node05.right != null) {
                queue.add(node05.right);
            }
        }
        return (ArrayList<Integer>) list;
    }
}

