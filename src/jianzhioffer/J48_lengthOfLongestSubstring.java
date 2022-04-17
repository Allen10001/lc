package jianzhioffer;

import java.util.HashMap;

/**
 * 最长不含重复字符的子字符串
 *
 * @author hubo88
 * @description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 数据范围: \ \text{s.length}\le 40000
 * s.length≤40000 示例1 输入： "abcabcbb"  返回值： 3  说明： 因为无重复字符的最长子串是"abc"，所以其长度为 3。
 * @date 2022/4/17 1:52 PM
 */
public class J48_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring (String s) {
        // write code here
        char[] sArr = s.toCharArray();
        // 保存字符上一次出现的 index 位置
        HashMap<Character, Integer> indexMap = new HashMap();

        // 最终结果
        int res = 0;
        // 包含 sArr[j] 的最优结果
        int temp = 0;
        for (int j=0; j<sArr.length; j++) {
            int i = indexMap.getOrDefault(sArr[j],-1);
            indexMap.put(sArr[j], j);
            temp = j-i > temp ? temp+1:j-i;
            res = Math.max(res, temp);
        }
        return res;
    }

}
