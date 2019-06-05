package backpack;

import java.util.Arrays;

public class backpacktotal {
   /* 完全背包问题的定义：
    有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是v，价值是w。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
    这里问题具体为：*/


    /**
     * 完全背包
     * 01背包每种物品只有一个，用二维数组防止重复 arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j - weight[i]] + value[i]);
     * 完全背包用一维数据即可  arr[j] = Math.max(arr[j],arr[j - weight[i]] + value[i]);
     *
     */

    public static void main(String[] args) {
        int[] weight = {0, 3, 2, 5, 1, 6, 4};
        int[] value = {0, 6, 5, 10, 2, 16, 8};
        int max=10;

        int[] maxValue = new int[max+1];

        //依次轮转，把当背包中有一个、二个、三个，，，
        for (int i = 0; i < weight.length; i++) {//i表示背包可以放前i+1种物品
            for (int j = weight[i]; j <= max; j++) {//j表示当前背包的容量
                maxValue[j] = Math.max(maxValue[j], maxValue[j - weight[i]] + value[i]);
            }
        }
        for (int i = 0; i <= max; i++) {
            System.out.print(maxValue[i]+" ");
        }


    }
}
