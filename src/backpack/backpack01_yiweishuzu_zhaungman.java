package backpack;

public class backpack01_yiweishuzu_zhaungman {
    /*01背包问题的定义：
     有N种物品和一个容量为V的背包，每种物品只能装1件。
     第i种物品的费用是v，价值是w。求解将哪些物品装入背包可使这些物品
     的费用总和不超过背包容量，且价值总和最大。*/

    public static void main(String[] args) {

        int[] weight = {0, 3, 4, 5};//重量
        int[] v = {0, 3, 4, 5};//价格
        int max = 10;//最大载重
        //创建二维数组，实现所有情况：横向是背包载重，纵向是物品列表，将每次最优结果填充到数组中


        int[] f = new int[max + 1];
        for (int i = 1; i < f.length; i++) {
            f[i] = Integer.MIN_VALUE;//必须装满则f[0]=0,[1...m]初始化为无穷小
        }

        for (int i = 0; i < weight.length; i++) {
            for (int j = f.length - 1; j >= weight[i]; j--) {
                f[j] = Math.max(f[j], f[j - weight[i]] + v[i]);
            }
        }

        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] + " ");
        }

        System.out.println(f[f.length - 1]);
    }

}
