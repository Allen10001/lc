package jianzhioffer;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author hubo88
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false 。假设输入的数组的任意两个数字都互不相同。
 * @link https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=265&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class J33_VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifyBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 二分法：
     * 二叉树的后序遍历顺序是：左子树 -> 右子树 -> 根节点
     * 因此序列的最后一个数代表了根节点
     * 因此我们可以将一个序列划分为3段, 左子树+右子树+根, 例如[4, 8, 6, 12, 16, 14, 10]可以根据根节点的值将其划分为左子树[4, 8, 6],
     * 右子树[12, 16, 14], 根[10], 由于我们是先确定的右子树区间, 因此当左子树区间中出现大于根节点的值时,
     * 序列不合法, 我们再采用分治的思想, 对于每段序列代表的子树, 检查它的左子树和右子树, 当且仅当左右子树都合法时返回true
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    public boolean VerifyBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootNum = sequence[end];
        int i = start;
        // 1. 左子树上的值都比 root 值小
        while (sequence[i] < rootNum) {
            i++;
        }
        int j = i;
        // 2. 正常的话，右子树上的值都比 root 值大。如果出现小的 说明不是二插搜索树
        for (; j < end; j++) {
            if (sequence[j] < rootNum) {
                return false;
            }
        }
        return VerifyBST(sequence, start, i - 1) && VerifyBST(sequence, i, j - 1);
    }
}
