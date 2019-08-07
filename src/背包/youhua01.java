package 背包;

public class youhua01 {
    //    /**
//     * 0-1背包的优化解法
//     *只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
//     *      * 用逆序来实现
//          * 思路：
//
//     * 0-1背包问题
//     * @param V 背包容量
//     * @param N 物品种类
//     * @param weight 物品重量
//     * @param value 物品价值
//     * @return
//     */
    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            //v背包容量
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }
}
