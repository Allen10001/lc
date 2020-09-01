import java.math.BigInteger;
import java.util.*;

public class Solution01 {

    public static void main(String[] args){
        BigInteger sumRes=new BigInteger("0");
        Solution01 solution01 = new Solution01();
        ArrayList<Integer> resList = solution01.getResList(100);
        System.out.println(resList);
        //System.out.println(solution01.getNres(3));
        for(Integer item : resList){
           sumRes=sumRes.add(solution01.getNres(item));
        }
        System.out.println(sumRes);  //
    }
    // 求解100以内的素数
    ArrayList<Integer>  getResList(int k){

        ArrayList<Integer> resList = new ArrayList<>();
        if(k<2){
            return resList;
        }
        resList.add(2);
        for(int i=3;i<=k;i++){
            int count=0;
            for(int j=2;j<=Math.sqrt(i);j++) {
                if (i % j == 0){
                    count++;
                }
            }
            if (count==0){
                resList.add(i);
            }
        }
        return resList;
        }

    // 求解n的阶乘
    BigInteger getNres(Integer n){
        return n==1 ? BigInteger.valueOf(1) : BigInteger.valueOf(n).multiply(getNres(n-1)) ;
    }
}


