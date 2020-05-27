package dp;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiDaJuXing {

    /**
     * 解法1： 动态规划 - 使用柱状图的优化暴力方法
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {

        int area = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return area;
        }
        int[][] widthMetrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                widthMetrix[i][j] = j==0 ? 1 : widthMetrix[i][j-1]+1;
                int width = widthMetrix[i][j];
                for(int m=i;m>=0;m--){
                    width = Math.min(width,widthMetrix[m][j]);
                    area = Math.max(area,width*(i-m+1));
                }
            }
        }
        return area;
    }
}
