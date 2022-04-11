package jianzhioffer;

/**
 * 连续子数组的最大和
 *
 * @author hubo88
 * @description 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
 * @link
 */
public class J42_FindGreatestSumOfSubArray {

    /**
     * 状态转移方程：dp[i] = max(array[i], dp[i-1]+array[i])
     * O(n) 空间复杂度：O(n)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];   //包含array[i]的连续数组最大值
        int res = array[0]; //记录当前所有子数组的和的最大值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
