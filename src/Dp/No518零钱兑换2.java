package Dp;

public class No518零钱兑换2 {
//    给定不同面额的硬币 coins 和一个总金额 amount。
//    编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
//    No322零钱兑换如果没有任何一种硬币组合能组成总金额，返回?-1。


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        // 设置起始状态
        dp[0]=1;
        for (int coin : coins) {
//            / 记录每添加一种面额的零钱，总金额i的变化
            for (int i = 1; i <=amount; i++) {
                if (i >= coin) {
                    dp[i]=dp[i]+dp[i-coin];
                }
            }
        }

        return dp[amount];
    }
}
