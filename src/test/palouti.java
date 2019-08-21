package test;

public class palouti {
    public int palouti(int[] n) {
        int sum = n[0];
        int m=n[0];
        for (int i = 1; i < n.length; i++) {
            if (m > 0) {
                m += n[i];
            } else {
                m = n[i];
            }
            if (sum < m) {
                sum = m;
            }
        }
        return sum;
    }
}
