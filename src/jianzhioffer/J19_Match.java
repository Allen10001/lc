package jianzhioffer;

/**
 * JZ19 正则表达式匹配
 *
 * @author hubo88
 * @description 请实现一个函数用来匹配包括'.'和'*'的正则表达式。 1.模式中的字符'.'表示任意一个字符 2.模式中的字符'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @link https://www.nowcoder.com/practice/28970c15befb4ff3a264189087b99ad4?tpId=265&tqId=39221&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/20 8:46 PM
 */
public class J19_Match {

    public boolean match(String str, String pattern) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        // 一对一匹配 或 .
        boolean match = (str.length() > 0 && (str.charAt(0) == pattern.charAt(0)
            || pattern.charAt(0) == '.'));
        // 有*
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            // 0个 || 多个
            return match(str, pattern.substring(2)) || (match && match(str.substring(1), pattern));
        }
        // 无*
        else {
            return match && match(str.substring(1), pattern.substring(1));
        }

    }

}
