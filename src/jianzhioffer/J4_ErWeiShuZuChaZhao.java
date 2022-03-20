package jianzhioffer;

/**
 * 二维数组中的查找
 *
 * @author hubo88
 * @description
 * 这是一道对二维数组进行二分查找的算法，考察对二分查找的灵活运用。
 *
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 *
 * 给定 target = 3，返回 false。
 *
 * 数据范围：矩阵的长宽满足 0 \le n,m \le 5000≤n,m≤500 ， 矩阵中的值满足 0 \le val \le 10^90≤val≤10
 * 9
 *
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n+m)O(n+m)
 *
 * @link https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=265&tqId=39208&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @date 2022/3/19 6:42 PM
 */
public class J4_ErWeiShuZuChaZhao {

    public boolean Find(int target, int [][] array) {
        if(array == null || array.length ==0){
            return false;
        }
        // 从二维矩阵的左下角开始找
        int i = array.length-1;
        int j = 0;
        while(i>=0 && j<array[0].length){
            if(array[i][j] > target){
                i--;
            }else if(array[i][j] < target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }

}
