package dp;

/**
 * 划分数组为两个和相等的子集
 * https://my.oschina.net/liyurong/blog/1601477
 */
public class PartitionEqualSubset {
    public static void main(String[] args){
        int[] arr = new int[]{1, 5, 11, 5};
        System.out.println(isEqualSubset(arr));
        System.out.println(isEqualSubset02(arr));
    }

    /**
     * 方法1： 将这个问题看成特殊的 0-1 背包问题， 物品的价值 = 物品的重量
     * 时间复杂度和空间复杂度均为O（n*sum）
     */
    public static boolean isEqualSubset(int[] arr){
        if(arr.length==0 || arr.length==1){
            return false;
        }
        int sum = 0;
        for(int item:arr){
            sum += item;
        }
        if(sum%2 == 1){ // 奇数，肯定不能划分成两个相等的子集
            return false;
        }
        int capacity = sum/2;
        int[][] sumValue = new int[arr.length+1][capacity+1];

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=capacity;j++){
                if(j>=arr[i-1]){
                    sumValue[i][j] = Math.max(sumValue[i-1][j-arr[i-1]] + arr[i-1],sumValue[i-1][j]);
                }else{
                    sumValue[i][j] = sumValue[i-1][j];
                }
            }
        }
        return sumValue[arr.length][capacity] == capacity;
    }

    /**
     * 我们假设dp[j]表示第i轮迭代能否得到和为j的子数组，那么只要保证此时数组中存储的是上一轮（i-1轮）迭代的结果，
     * 我们就可以去掉一个维度。因此我们有如下关系：
     * dp[j] = dp[j] | dp[j - nums[i]]
     *
     * 时间复杂度为O（n*sum）
     * 空间复杂度均为O(sum)
     */
    public static boolean isEqualSubset02(int[] arr){
        if(arr==null || arr.length==1){
            return false;
        }
        int sum =0;
        for(int item:arr){
            sum += item;
        }
        if(sum%2==1){
            return false;
        }
        sum = sum>>1;
        boolean[] judgeArr = new boolean[sum+1];  // 默认为 false;
        judgeArr[0]=true;
        for(int i=0;i<arr.length;i++){
            for(int j=sum;j>=arr[i];j--){
                judgeArr[j] = judgeArr[j] || judgeArr[j-arr[i]];
            }
        }
        return judgeArr[sum];
    }
}
