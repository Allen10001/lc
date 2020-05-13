package dp;

/**
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZhengZeBiaoDaPiPei {

    public static void main(String[] args){
        System.out.println(isMatch01("ab",".*"));
    }

    /**
     * 方法1：暴力解法
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');

        if(p.length()>=2 && p.charAt(1)=='*'){
            return (firstMatch && isMatch(s.substring(1),p)) || isMatch(s,p.substring(2));
        }else{
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }

    }

    /**
     * dp问题：带备忘录的递归解法
     * @param s
     * @param p
     * @return
     */

    public static Boolean isMatch01(String s, String p) {
        Boolean[][] container = new Boolean[s.length()+1][p.length()+1];
        return dp01(0,0, s, p, container);
    }

    public static Boolean dp01(int i,int j,String s, String p,Boolean[][] container){
        if(container[i][j]!=null){
            return container[i][j];
        }
        if(j==p.length()){
            return i==s.length();
        }
        // 当前 i 和 j指向的字符是否匹配
        Boolean firstMatch = i<s.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='.');

        if(j<=p.length()-2 && p.charAt(j+1)=='*'){
            container[i][j] = (firstMatch && dp01(i+1,j, s, p,container)) || dp01(i,j+2, s, p, container);
        }else{
            container[i][j] = firstMatch && dp01(i+1,j+1, s, p, container);
        }
        return container[i][j];
    }

}
