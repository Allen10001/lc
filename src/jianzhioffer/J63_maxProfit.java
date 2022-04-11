package jianzhioffer;

/**
 * 买卖股票的最好时机(一)
 *
 * @author hubo88
 * @description 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格， 请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天 2.如果不能获取到任何利润，请返回0 3.假设买入卖出均无手续费
 * @link
 * @date 2022/4/10 8:20 PM
 */
public class J63_maxProfit {

    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int minPrice = Integer.MAX_VALUE;
        int maxProfile = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            // 每次都计算 i 之前的最小价格
            minPrice = Math.min(prices[i], minPrice);
            // 每次都更新最大利润
            maxProfile = Math.max(maxProfile, prices[i]-minPrice);
        }
        return maxProfile;
    }

}
