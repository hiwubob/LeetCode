package Dp;

public class No518��Ǯ�һ�2 {
//    ������ͬ����Ӳ�� coins ��һ���ܽ�� amount��
//    ��дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ�����
//    No322��Ǯ�һ����û���κ�һ��Ӳ�����������ܽ�����?-1��


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        // ������ʼ״̬
        dp[0]=1;
        for (int coin : coins) {
//            / ��¼ÿ���һ��������Ǯ���ܽ��i�ı仯
            for (int i = 1; i <=amount; i++) {
                if (i >= coin) {
                    dp[i]=dp[i]+dp[i-coin];
                }
            }
        }

        return dp[amount];
    }
}
