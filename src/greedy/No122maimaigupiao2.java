package greedy;

public class No122maimaigupiao2 {
    public int maxProfitII(int[] prices) {
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {//�����ķ�ȶ�Ҫ�ӽ�ȥ
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
