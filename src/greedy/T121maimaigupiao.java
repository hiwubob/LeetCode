package greedy;

public class T121maimaigupiao {
    //������Ʊ
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i != prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);//��¼����Ϊֹ�õ�����Сֵ
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);//��¼����
        }
        return maxProfit;
    }
}
