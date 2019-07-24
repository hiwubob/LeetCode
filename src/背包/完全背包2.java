package 背包;

public class 完全背包2 {
    public static int completePack2(int V,int N,int[] weight,int[] value){
        /**
         * 完全背包的第二种解法
         * 思路：
         * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
         * 用顺序来实现
         */
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //顺序实现！！！！！！！！！与01背包的区别
            //0，1背包是从大到小遍历，完全背包是从小到大遍历
            for(int j=weight[i-1];j<V+1;j++){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }
}
