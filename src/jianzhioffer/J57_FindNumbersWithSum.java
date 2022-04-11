package jianzhioffer;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 *
 * @author hubo88
 * @description 输入一个升序数组 array 和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，返回任意一组即可，如果无法找出这样的数字，返回一个空数组即可。
 * @link
 */
public class J57_FindNumbersWithSum {

    /**
     * 二分法的变形
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList<Integer> resList = new ArrayList<Integer>();
        if(array==null || array.length==0){
            return resList;
        }
        int low = 0;
        int high = array.length-1;
        while(low<high){
            int tempRes = array[low]+array[high];
            if(tempRes > sum){
                high--;
            }else if(tempRes < sum){
                low++;
            }else{
                resList.add(array[low]);
                resList.add(array[high]);
                return resList;
            }
        }
        return resList;
    }

}
