package Dp;

public class No122gupiao {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i ]> prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        int n=prices.length;
        int dpi0=0;
        int dpi1=Integer.MIN_VALUE;
       // int tmp;
        for (int i = 0; i < n; i++){
           int tmp=dpi0;
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, tmp - prices[i]);
        }
        return dpi0;
    }
}
