package dp;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class bian_ji_lv_li {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m==0 || n==0){
            return m+n;
        }
        int[][] D = new int[m+1][n+1];

        // i j 分别表示 word1 和 word2 的第 i 第j 个位置
        // word2 为空时，编辑距离是 word1 的长度
        for(int i=1;i<=m;i++){
            D[i][0] = i;
        }

        // word1 为空时，编辑距离是 word2 的长度
        for(int j=1;j<=n;j++){
            D[0][j] = j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int left = D[i][j-1]+1;
                int on = D[i-1][j]+1;
                int left_on = D[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1))
                    left_on += 1;
                D[i][j] = Math.min(left,Math.min(on,left_on));
            }
        }
        return D[m][n];
    }
}
