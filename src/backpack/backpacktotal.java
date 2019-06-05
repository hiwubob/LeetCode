package backpack;

import java.util.Arrays;

public class backpacktotal {
   /* 完全背包问题的定义：
    有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是v，价值是w。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
    这里问题具体为：*/

    public static void main(String[] args) {
        int[] w = {0, 3, 2, 5, 1, 6, 4};
        int[] v = {0, 6, 5, 10, 2, 16, 8};
        int max=10;

        int[] m = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            m[i] = w[i];
        }
        Arrays.sort(m);


    }
}
