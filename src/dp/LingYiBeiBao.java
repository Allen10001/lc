package dp;

// https://www.cnblogs.com/arsenalfaninecnu/p/8945548.html
public class LingYiBeiBao {

    public static void main(String[] args){
        int num = 5;  // 物品的个数
        int capacity = 6; // 背包的容量
        int[] weightList = new int[]{2, 2, 6, 5, 4}; // 物品的质量
        int[] valueList = new int[]{6, 3, 5, 4, 6};  // 物品的价值
        int res = getMaxValue(num,capacity,weightList,valueList);
        System.out.println(res);
    }

    public static int getMaxValue(int num,int capacity,int[] weightList,int[] valueList){
        int[][] sumValue = new int[num+1][capacity+1]; // num: 0-5,   capacity:0-10   , 要考虑初始情况容量为 0，加入背包的物品数为0

        for(int i=1;i<=num;i++){
            for(int j=1;j<=capacity;j++){
                if(j>=weightList[i-1]){
                    sumValue[i][j] = Math.max(sumValue[i-1][j-weightList[i-1]]+valueList[i-1] , sumValue[i-1][j]);
                }else{
                    sumValue[i][j] = sumValue[i-1][j];
                }
            }
        }
        return sumValue[num][capacity];
    }
}
