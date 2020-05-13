package dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i=0;
        for(int j=0;j<obstacleGrid[0].length;j++){
            if(obstacleGrid[i][j]==1){
                obstacleGrid[i][j] = 0;
                break;
            }
            obstacleGrid[i][j] = 1;
        }
        int j=0;
        for(;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][j]==1){
                obstacleGrid[i][j] = 0;
                break;
            }
            obstacleGrid[i][j] = 1;
        }

        for(i=1;i<obstacleGrid[0].length;i++){
            for(j=1;j<obstacleGrid.length;j++){
                if(obstacleGrid[i][j]==1){  // 有障碍物，可以到达的路径数为 0
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
            }
        }


        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

}
