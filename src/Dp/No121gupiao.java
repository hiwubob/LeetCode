package Dp;

public class No121gupiao {
    //��Ʊ
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dpi0=0;//��i�첻����
        int dpi1=Integer.MIN_VALUE;//��i�����
        for (int i = 0; i < n; i++) {
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, -prices[i]);
        }
        return dpi0;
    }

    public int maxProfit2(int[] prices) {
        int maxprofit=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length ;j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit=profit;
                }
            }
        }
        return maxprofit;
    }
}
