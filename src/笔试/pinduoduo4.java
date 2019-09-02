package ±  ‘;

import java.util.Scanner;

public class pinduoduo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int result = solve(n, m, n * m + 1 - k);
        System.out.println(result);
    }

    private static int solve(int m, int n, int k) {
        int low = 1 * 1;
        int high = m * n;
        while (low < high) {
            int mid = (low + high) >> 1;
            int count = func(mid, m, n);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private static int func(int val, int m, int n) {
        int i = m;
        int j = 1;
        int sum = 0;
        while (i > 0 && j <= n) {
            if (i * j <= val) {
                sum += i;
                j++;
            } else {
                i--;
            }
        }
        return sum;
    }

}
