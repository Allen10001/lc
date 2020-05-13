package dp;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args){
        System.out.println(longestPalindrome("a" ));
    }

    public static String longestPalindrome(String s) {
        if(s==null || "".equals(s)){
            return "";
        }
        String reverseStr = new StringBuffer(s).reverse().toString();

        char[] origin = s.toCharArray();
        char[] reverseArr = reverseStr.toCharArray();
        int [][] count = new int[origin.length][reverseArr.length];
        int max=0;
        int begin=0;
        for(int i=0;i<origin.length;i++){
            for(int j=0;j<reverseArr.length;j++){
                if(origin[i]==reverseArr[j]){
                    if(i==0 || j==0){
                        count[i][j]=1;
                    }else{
                        count[i][j] = count[i-1][j-1]+1;
                    }
                }
                if((origin.length-1-j) + (count[i][j]-1) ==i){
                    if(count[i][j]>max){
                        max = count[i][j];
                        begin = origin.length-1-j; // 回文串在原始字符串的开始位置
                    }
                }
                }
            }
        return s.substring(begin,begin+max);
        }
}
