package Dp;

public class No322零钱兑换 {
//    给定不同面额的硬币 coins 和一个总金额 amount。
//    编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
//    No322零钱兑换如果没有任何一种硬币组合能组成总金额，返回?-1。


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0]=0;
        for (int i = 1; i <=amount; i++) {
            dp[i]=Integer.MAX_VALUE;
            for (int coin :
                    coins) {
                if (i >= coin && dp[i - coin] != -1 && coin >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - coin] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i]=-1;
            }
        }
        return dp[amount];
    }
}
