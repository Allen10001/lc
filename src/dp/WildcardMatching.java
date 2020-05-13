package dp;

/**
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 *
 * *a*b
 */
public class WildcardMatching {
    public static void main(String[] args){
        System.out.println(new WildcardMatching().isMatch("adceb","*a"));
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        // base cases
        if (p.equals(s) || p.equals("*")) return true;
        if (p.isEmpty() || s.isEmpty()) return false;

        // init all matrix except [0][0] element as False
        boolean[][] d = new boolean[pLen + 1][sLen + 1];
        d[0][0] = true;

        // DP compute
        for(int pIdx = 1; pIdx < pLen + 1; pIdx++) {
            // the current character in the pattern is '*'
            if (p.charAt(pIdx - 1) == '*') {
                int sIdx = 1;
                // d[p_idx - 1][s_idx - 1] is a string-pattern match
                // on the previous step, i.e. one character before.
                // Find the first idx in string with the previous math.
                while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen + 1)) sIdx++;
                // If (string) matches (pattern),
                // when (string) matches (pattern)* as well
                d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1];
                // If (string) matches (pattern),
                // when (string)(whatever_characters) matches (pattern)* as well
                while (sIdx < sLen + 1) d[pIdx][sIdx++] = true;
            }
            // the current character in the pattern is '?'
            else if (p.charAt(pIdx - 1) == '?') {
                for(int sIdx = 1; sIdx < sLen + 1; sIdx++)
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1];
            }
            // the current character in the pattern is not '*' or '?'
            else {
                for(int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    // Match is possible if there is a previous match
                    // and current characters are the same
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                            (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
                }
            }
        }
        return d[pLen][sLen];
    }

}
