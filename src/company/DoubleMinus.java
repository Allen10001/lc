package company;

import java.util.Arrays;

/**
 * @Description
 *
 * 给定两个字符串，格式为 0.xxxxxxxx
 * 例如 0.86398198090932840823042347837073 和 0.7347874163674169646376496494697649764963
 * 输出字符串1 减去 字符串2 的结果
 *
 *
 * @Author Allen
 * @Date 2022/5/27 12:09
 **/
public class DoubleMinus {

}

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("0.86398198090932840823042347837073", "0.7347874163674169646376496494697649764963"));
    }

    public String solution(String a, String b){

        char[] aRrr = a.toCharArray();
        char[] bRrr = b.toCharArray();

        int aLen = a.length(), bLen = b.length(), maxLen = Math.max(aLen, bLen);
        char[] resArr = new char[maxLen];

        // 对齐
        char[] aCopy = Arrays.copyOf(aRrr, maxLen);
        char[] bCopy = Arrays.copyOf(bRrr, maxLen);
        Arrays.fill(aCopy, aLen, maxLen, '0');
        Arrays.fill(bCopy, bLen, maxLen, '0');

        int flag = 0;

        for(int j=maxLen-1; j>=0; j--){
            if(aCopy[j]=='.') {
                break;
            }

            int aNum = aCopy[j]-'0';
            int bNum = bCopy[j]-'0';
            int res = 0;
            if((aNum + flag) < bNum){
                res = flag+aNum+10-bNum;
                flag = -1;
            }else{
                res = flag+aNum-bNum;
                flag = 0;
            }
            char resChar = (char)(res+(int)'0');
            resArr[j] = resChar;
        }

        resArr[1] = '.';
        resArr[0] = '0';
        if(flag < 0){
            return "-"+String.valueOf(resArr);
        } else {
            return String.valueOf(resArr);
        }
    }
}