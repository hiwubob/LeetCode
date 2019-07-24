package Dp;

public class No322��Ǯ�һ� {
//    ������ͬ����Ӳ�� coins ��һ���ܽ�� amount��
//    ��дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ�����
//    No322��Ǯ�һ����û���κ�һ��Ӳ�����������ܽ�����?-1��


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
