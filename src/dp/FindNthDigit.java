package dp;

public class FindNthDigit {
    public static int findNthDigitSolution(int n){
        // 1. 计算这个数是几位数
        int digits = 1; // 几位数
        int base = 1;
        int count = 9*base*digits;
        while(n-count>0){
            digits++;
            n -= count;
            base *= 10;
            count = 9*base*digits;
        }

        // 2.计算这个数是几
        int index = n%digits; // target 位于这个数的第几位
        if(index == 0){
            index = digits;  // 能整除，说明在 digits 位
        }
        int num = base+(index == digits ? n/digits-1:n/digits);
        // 3.计算这个数的 index 位是几
        while(index<digits){
            num /= 10;
            index++;
        }
        return num%10; // 经验证可知，n==0时，这样的逻辑能返回正确结果0。
    }

    public static void main(String[] args){
        System.out.println(findNthDigitSolution(189));
    }
}
