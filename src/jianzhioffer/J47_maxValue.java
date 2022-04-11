package jianzhioffer;

/**
 * 礼物的最大价值
 *
 * @author hubo88
 * @description 在一个m\times nm×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 如输入这样的一个二维数组， [ [1,3,1], [1,5,1], [4,2,1] ] 那么路径 1→3→5→2→1
 * 可以拿到最多价值的礼物，价值为12
 * @link
 */
public class J47_maxValue {

    public int maxValue(int[][] grid) {
        // write code here
        if (grid.length == 0) {
            return 0;
        }
        int[] dp = new int[grid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[j + 1] = Math.max(dp[j], dp[j + 1]) + grid[i][j];
            }
        }
        return dp[grid[0].length];
    }
}
