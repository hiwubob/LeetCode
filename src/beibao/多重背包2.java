package beibao;

public class ���ر���2 {

    public static int bag4(int W, int[] w, int[] v, int[] num) {
        int n = w.length - 1;// ��һ��ֵ������
        int[] f = new int[W + 1];
        for (int i = 1; i <= n; i++)
            for (int j = W; j >= w[i]; j--)
                for (int k = 0; k <= num[i]; k++) {
                    if (j - k * w[i] >= 0 && f[j - k * w[i]] + k * v[i] > f[j])
                        f[j] = f[j - k * w[i]] + k * v[i];
                }

        return f[W]; // ���Ž�
    }
}
