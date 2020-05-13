package dp;

/**
 * 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class JiDanDiaoLuo {

    public static void main(String[] args){
        JiDanDiaoLuo solution = new JiDanDiaoLuo();
        System.out.println(solution.superEggDrop(2, 100));
    }

    public int superEggDrop(int K, int N){
        // 记录容器
        int[][] resContainer = new int[K+1][N+1];
        return superEggDropHandler01(K,  N, resContainer);
    }

    /**
     * 基本解法：最简单的dp解法，时间复杂度  O（KN^2）
     * @param K
     * @param N
     * @param resContainer
     * @return
     */
    public int superEggDropHandler(int K, int N,int[][] resContainer) {
        // base case
        if(K==1){
            return N;
        }
        if(N==0){
            return 0;
        }
        if(resContainer[K][N]!=0){
            return resContainer[K][N];
        }
        int tryCount = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            tryCount = Math.min(tryCount,Math.max(
                    superEggDropHandler(K, N-i,resContainer)+1,
                    superEggDropHandler(K-1, i-1, resContainer)+1
            ));
        }
        resContainer[K][N]=tryCount;
        return tryCount;
    }

    /**
     * 特殊的二分法
     * https://leetcode-cn.com/problems/super-egg-drop/solution/ji-ben-dong-tai-gui-hua-jie-fa-by-labuladong/
     * @param K
     * @param N
     * @param resContainer
     * @return
     */
    public int superEggDropHandler01(int K, int N,int[][] resContainer) {
        // base case
        if(K==1){
            return N;
        }
        if(N==0){
            return 0;
        }
        if(resContainer[K][N]!=0){
            return resContainer[K][N];
        }
        int tryCount = Integer.MAX_VALUE;

        int low=1,high=N;
        while(low<=high){
            int mid = (low+high)>>1;
            int unbroken = superEggDropHandler01(K, N-mid,resContainer)+1;
            int broken = superEggDropHandler01(K-1, mid-1, resContainer)+1;
            if(broken>unbroken){   //  使用二分法，最终找到 broken==unbroken 的点（broken-unbroken）看成一个值的话是单调递增的
                high = mid-1;
                tryCount = Math.min(tryCount,broken);
            }else{
                low = mid+1;
                tryCount = Math.min(tryCount,unbroken);
            }
        }
        resContainer[K][N]=tryCount;
        return tryCount;
    }
}
