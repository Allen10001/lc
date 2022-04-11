package jianzhioffer;

/**
 * 数组中只出现一次的两个数字
 *
 * @author hubo88
 * @description 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @link
 */
public class J56_FindNumsAppearOnce {

    /**
     * 利用 异或 的特性
     * @param array
     * @return
     */
    public int[] FindNumsAppearOnce (int[] array) {

        // 先将全部数进行异或运算，得出最终结果
        int tmp = 0;
        for(int num: array){
            tmp ^= num;
        }

        // 找到那个可以充当分组去进行与运算的数
        // 从最低位开始找起
        int mask = 1;
        while((tmp&mask) == 0){
            mask <<= 1;
        }

        // 进行分组，分成两组，转换为两组 求出现一次的数字 去求
        int a = 0;
        int b = 0;
        for(int num:array){
            if((num&mask) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }
        // 因为题目要求小的数放前面，所以这一做个判断
        if(a > b){
            int c = a;
            a = b;
            b = c;
        }
        return new int[]{a,b};
    }
}
