package jianzhioffer;

/**
 * 替换空格
 *
 * @author hubo88
 * @description
 * @link https://www.nowcoder.com/practice/0e26e5551f2b489b9f58bc83aa4b6c68?tpId=265&tqId=39209&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 7:00 PM
 */
public class J5_ReplaceSpace {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace (String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int spaceNum = 0;
        int m = s.length();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                spaceNum++;
            }
        }
        //p1指向原字符串末尾
        int p1 = m - 1;
        //p2指向替换之后字符串的末尾，spaceNum为空格数，3是"%20"的长度
        int p2 = p1 + spaceNum * 2;

        char[] tmp = new char[p2+1];
        for (int i = 0; i < s.length(); i++) {
            tmp[i] = s.charAt(i);
        }

        //当p1和p2指向同一位置时，说明已经替换完毕
        while (p1 >= 0 && p1 != p2) {
            if (tmp[p1] == ' ') {
                tmp[p2--] = '0';
                tmp[p2--] = '2';
                tmp[p2--] = '%';
            }else {
                tmp[p2--] = tmp[p1];
            }
            p1--;
        }

        return new String(tmp);
    }

}
