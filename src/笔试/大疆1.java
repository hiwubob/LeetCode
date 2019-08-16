package ±  ‘;

import java.util.ArrayList;
import java.util.Scanner;

public class ¥ÛΩÆ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        ArrayList<ArrayList<int[]>> res = new ArrayList<ArrayList<int[]>>(caseNum);
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < caseNum; i++) {
            int gameNum = sc.nextInt();
            int dayNum = sc.nextInt();
            int[] a = {gameNum, dayNum};
            list.add(a);
            int[] b = new int[2];
            for (int j = 0; j < gameNum; j++) {
                b[0] = sc.nextInt();
                b[1] = sc.nextInt();
                list.add(b);
            }
            res.add(list);
        }

        for (int i = 0; i < caseNum; i++) {
            ArrayList<int[]> result = new ArrayList<>();
            result = res.get(i);
            int totalgame = result.get(0)[0];
            int totalday = result.get(0)[1];
            int[] value = new int[totalgame];
            int[] day = new int[totalday];
            for (int j = 0; j < totalgame; j++) {
                value[j] = result.get(j + 1)[0];
                day[j] = result.get(j + 1)[1];
            }
            int maxValue = MaxValue(totalday, totalgame, value, day);
            System.out.println(maxValue);
        }
    }

    private static int MaxValue(int totalday, int totalgame, int[] value, int[] day) {
        int[][] dp = new int[totalgame + 1][totalday + 1];
        for (int i = 1; i <= totalgame; i++) {
            int w = day[i - 1], v = value[i - 1];
            for (int j = 1; j <= totalday; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[totalgame][totalday];

    }


}