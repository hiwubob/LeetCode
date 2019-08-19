package ±  ‘;

import java.util.Scanner;

public class n3602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] positon = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                positon[i][j] = sc.nextInt();
            }
        }

        int surface1=0;
        int surface2=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (positon[i][j] != 0) {
                    surface1+=positon[i][j]*4+2;
                }
                if (i != n - 1&&j!=m-1) {
                    surface2 += ((positon[i][j] > positon[i + 1][j]) ? positon[i + 1][j] : positon[i][j])*2;
                    surface2 += ((positon[i][j] > positon[i][j + 1]) ? positon[i][j + 1] : positon[i][j])*2;
                } else if (i == n - 1 && j != m - 1) {
                    surface2 += ((positon[i][j] > positon[i][j + 1]) ? positon[i][j + 1] : positon[i][j])*2;
                } else if (i != n - 1 && j == m - 1) {
                    surface2 += ((positon[i][j] > positon[i + 1][j]) ? positon[i + 1][j] : positon[i][j])*2;
                }
            }
        }
        System.out.println(surface1 - surface2);
    }
}
