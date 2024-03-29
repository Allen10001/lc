package dp;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */

public class ZuiChangYouXiaoKuaHao {
    public int longestValidParentheses(String s) {

        if(s==null || "".equals(s)){
            return 0;
        }
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2 ? dp[i-2] : 0)+2;
                }else if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = i-dp[i-1] >=2 ? dp[i-1]+2+dp[i-dp[i-1]-2] : dp[i-1]+2;
                }
                if(dp[i]>maxLen){
                    maxLen = dp[i];
                }
            }
        }
        return maxLen;
    }
}
