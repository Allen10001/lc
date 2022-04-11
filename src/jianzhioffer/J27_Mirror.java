package jianzhioffer;

/**
 * 二叉树的镜像
 *
 * @author hubo88
 * @description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @link https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * @date 2022/4/9 6:11 PM
 */
public class J27_Mirror {

    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return pRoot;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return pRoot;
        }
        //处理根节点，交换左右节点
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        //处理左子树
        Mirror(pRoot.left);
        //处理右子树
        Mirror(pRoot.right);
        return pRoot;
    }
}
