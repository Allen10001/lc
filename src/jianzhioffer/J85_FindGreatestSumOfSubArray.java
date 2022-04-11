package jianzhioffer;

/**
 * 连续子数组的最大和(二)
 *
 * @author hubo88
 * @description 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
 * 1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组 2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
 * 3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组 4.返回的数组不计入空间复杂度计算
 * @link
 * @date 2022/4/10 11:07 PM
 */
public class J85_FindGreatestSumOfSubArray {

    public int[] FindGreatestSumOfSubArray(int[] array) {
        // write code here
        // write code here
        int[] dp = new int[array.length];
        dp[0] = array[0];
        // 该题定义的子数组的最小长度为1；
        int maxLength = 1, maxSum = array[0], left = 0, right = 0, snapLeft = 0, snapRight = 0;
        for (int i = 1; i <= array.length - 1; ++i) {
            right++;
            // 状态转移方程跟J42 一样
            dp[i] = Math.max(array[i] + dp[i - 1], array[i]);
            if (array[i] + dp[i - 1] < array[i]) {
                left = right;
            }

            // 更新最大值时需要记录当前 快慢指针的位置，更新的条件需要注意下
            if (dp[i] > maxSum || dp[i] == maxSum && (right - left + 1) > maxLength) {
                snapLeft = left;
                snapRight = right;
                maxLength = right - left + 1;
                maxSum = dp[i];
            }
        }

        // 组装返回结果
        int[] res = new int[maxLength];
        int idx = 0;
        for (int i = snapLeft; i <= snapRight; ++i) {
            res[idx++] = array[i];
        }
        return res;
    }

}
