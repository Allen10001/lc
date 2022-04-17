package jianzhioffer;

/**
 * JZ21 调整数组顺序使奇数位于偶数前面(一)
 *
 * @author hubo88
 * @description 输入一个长度为 n 整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @link https://www.nowcoder.com/practice/ef1f53ef31ca408cada5093c8780f44b?tpId=265&tqId=39223&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/20 9:01 PM
 */
public class J21_reOrderArray {

    /**
     * 方法1：头尾双指针，一次遍历，头处理奇数，尾处理偶数；
     * @param array
     * @return
     */
    public int[] reOrderArray01 (int[] array) {
        // write code here
        //双指针，头尾指针
        int[] nums = new int[array.length];
        int head = 0;
        int tail = array.length-1;
        int index_head = head;
        int index_tail = tail;
        while(head < array.length && tail >= 0){
            if(array[head] % 2 == 1){
                //奇数，放前面
                nums[index_head] = array[head];
                index_head++;
            }
            head++;
            if(array[tail] % 2 == 0){
                //从后到前，如果为偶数，则从后开始填
                nums[index_tail] = array[tail];
                index_tail--;
            }
            tail--;
        }
        return nums;
    }

    /**
     * 2. 冒泡排序的思想
     * @param array
     * @return
     */
    public int[] reOrderArray02 (int[] array) {
        // write code here
        // write code here
        int i=0;
        for(int j=0; j< array.length; j++){
            // 为奇数
            if (array[j]%2==1) {
                int temp = array[j];
                for(int k=j;k>i;k--){
                    array[k]=array[k-1];
                }
                array[i] = temp;
                i++; // 先移动中间的偶数，再加1, i 始终指向移动后数组中的第一个偶数
            }
        }
        return array;
    }

}
