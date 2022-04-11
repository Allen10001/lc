package jianzhioffer;

/**
 * 对称的二叉树
 *
 * @author hubo88
 * @description 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * @link https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=265&tqId=39230&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/4/9 6:22 PM
 */
public class J28_isSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    boolean isSymmetrical(TreeNode pNode1, TreeNode pNode2) {
        if (pNode1 == null && pNode2 == null) {
            return true;
        }
        if (pNode1 == null || pNode2 == null) {
            return false;
        }
        if (pNode1.val != pNode2.val) {
            return false;
        }
        return isSymmetrical(pNode1.left, pNode2.right)
            && isSymmetrical(pNode1.right, pNode2.left);
    }
}
