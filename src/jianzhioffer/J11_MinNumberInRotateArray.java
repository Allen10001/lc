package jianzhioffer;

/**
 * JZ11 旋转数组的最小数字
 *
 * @author hubo88
 * @description 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
 * 数据范围：1 \le n \le 100001≤n≤10000，数组中任意元素的值: 0 \le val \le 100000≤val≤10000 要求：空间复杂度：O(1)O(1)
 * ，时间复杂度：O(logn)O(logn)
 * @link https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=265&tqId=39215&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 9:24 PM
 */
public class J11_MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        // 特殊情况，旋转偏移量为 0
        if (array[0] < array[array.length - 1]) {
            return array[0];
        }
        return minNumberInRotateArrayHandler(array, 0, array.length - 1);
    }

    // 定义两个指针，start 指向前面递增的子数组，end 指向后面递增的子数组，对于最一般的情况（3，4，5，1，2），
    // 最小值在后面的子数组的第一个位置，通过使用二分法，不断缩小start和end指针之间的距离，
    // 直到 start 指向前面子数组的最后一个元素，end指向后面子数组的第一个元素，
    // 此时end-start=1，且array[end]值为最小值。
    // 非一般的情况：（1，2，3，4，5）
    // （1，0，1，1，1）
    // 以上两种需要特殊处理
    public int minNumberInRotateArrayHandler(int[] array, int start, int end) {

        while (end - start != 1) {
            int mid = (start + end) / 2;
            // 特殊情况 array[preIndex]=array[mid]=array[beIndex], 需要遍历，不能使用二分法
            if (array[start] == array[mid] && array[end] == array[mid]) {
                int temp = array[start];
                for (int i = start; i <= end; i++) {
                    if (array[i] < temp) {
                        temp = array[i];
                    }
                }
                return temp;
            }

            if (array[mid] >= array[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return array[end];
    }

}
