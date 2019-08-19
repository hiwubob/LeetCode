package ±  ‘;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class QQ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] meter = new int[n][2];
        for (int i = 0; i < n; i++) {
            meter[i][0] = Integer.parseInt(sc.next());
            meter[i][1] = Integer.parseInt(sc.next());
        }

        Arrays.sort(meter, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int[] dp = new int[l+1];
        for (int i = 0; i < l+1; i++) {
            dp[i] = -1;
        }


        if (meter[0][0] != 0) {
            System.out.println("-1");
        }

        for (int i = meter[0][0]; i <= Math.min(meter[0][1], l); i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {

            if (meter[i][0] > l) {
                continue;
            }

            if (dp[meter[i][0] ]== -1) {
                System.out.println("-1");;
            }
            for (int j = meter[i][0]; j <= meter[i][1]; j++) {
                if (j > l) {
                    break;
                } else if (meter[i][0] == 0) {
                    dp[j] = 1;
                } else if (dp[j] == -1) {
                    dp[j] = dp[meter[i][0]] + 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[meter[i][0]] + 1);
                }
            }
        }
        System.out.println(dp[l]);
    }
}

