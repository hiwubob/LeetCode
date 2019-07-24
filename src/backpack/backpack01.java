package backpack;

public class backpack01 {
    /*01背包问题的定义：
     有N种物品和一个容量为V的背包，每种物品只能装1件。
     第i种物品的费用是v，价值是w。求解将哪些物品装入背包可使这些物品
     的费用总和不超过背包容量，且价值总和最大。*/

    public static void main(String[] args) {

        int[] weight = {0, 3, 4, 5};//重量
        int[] value = {0, 3, 4, 5};//价格
        int maxWeight = 10;//最大载重
       //创建二维数组，实现所有情况：横向是背包载重，纵向是物品列表，将每次最优结果填充到数组中
        int[][] maxValue = new int[weight.length][maxWeight];

        for (int i = 0; i < maxWeight; i++) {//外层是背包的重量，从0-max，一个个测试
            for (int n = 0; n < weight.length; n++) {//每一次背包确定载重时，依次拿物品来装，取得当前载重最高价值
                if (i == 0 || n == 0) {//起始状态
                    maxValue[n][i]=0;
                }else {
                    //否则，开始判断当前物品能否装到当前载重的背包中
                    if (i < weight[n]) {//当前物品重量是超过载重的，则使用上一次最优结果
                        maxValue[n][i] = maxValue[n - 1][i];
                    }else {
                        //否则，可以放也可以不放，分别计算
                        int v1 = maxValue[n - 1][i];//不放，就是上次最大值
                        int v2 = maxValue[n - 1][i - weight[n]] + value[n];//放，上次最大值加上本次价值
                        maxValue[n][i] = Math.max(v1, v2);
                    }
                }
            }
        }

        for (int n = 0; n < weight.length; n++) {
            for (int i = 0; i < maxWeight; i++) {
                System.out.print(maxValue[n][i]+" ");
            }
            System.out.println();
        }

        System.out.println(maxValue[weight.length-1][maxWeight-1]);
    }

}
