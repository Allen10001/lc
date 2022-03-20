package jianzhioffer;

/**
 * JZ14 剪绳子
 *
 * @author hubo88
 * @description 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ），每段绳子的长度记为
 * k[1],...,k[m] 。请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？
 * <p>
 * <p>
 * 例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18 。  数据范围：2≤n≤60 进阶：空间复杂度 O(1)O(1) ，时间复杂度
 * O(n)O(n)
 * @link https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=265&tqId=39218&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 9:42 PM
 */
public class J14_cutRope {

    // 动态规划：迭代，而不是递归
    // 动态规划，只记录子结构中最优的解。
    public int cutRope(int target) {

        // 至少剪一刀
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }

        // 初始化结果数组
        int[] resArr = new int[target + 1];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = -1;
        }

        resArr[1] = 1;
        resArr[2] = 2;
        resArr[3] = 3;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                resArr[i] = Math.max(resArr[i], j * resArr[i - j]);
            }
        }
        return resArr[target];
    }

}
