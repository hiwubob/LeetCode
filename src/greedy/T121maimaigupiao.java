package greedy;

public class T121maimaigupiao {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i != prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);//记录迄今为止得到的最小值
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);//记录利润
        }
        return maxProfit;
    }
}
