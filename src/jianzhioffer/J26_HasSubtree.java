package jianzhioffer;

/**
 * 树的子结构
 *
 * @author hubo88
 * @description 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
 * @link https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * @date 2022/4/9 5:04 PM
 */

class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class J26_HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null) {
            return result;
        }

        if (root1.val == root2.val) {
            result = tree1HaveTree2(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean tree1HaveTree2(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //先判断让root2是否为null
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return (tree1HaveTree2(root1.left, root2.left) &&
            tree1HaveTree2(root1.right, root2.right));
    }
}


