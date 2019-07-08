package beibao;

public class 多重背包2 {

    public static int bag4(int W, int[] w, int[] v, int[] num) {
        int n = w.length - 1;// 第一个值，不算
        int[] f = new int[W + 1];
        for (int i = 1; i <= n; i++)
            for (int j = W; j >= w[i]; j--)
                for (int k = 0; k <= num[i]; k++) {
                    if (j - k * w[i] >= 0 && f[j - k * w[i]] + k * v[i] > f[j])
                        f[j] = f[j - k * w[i]] + k * v[i];
                }

        return f[W]; // 最优解
    }
}
