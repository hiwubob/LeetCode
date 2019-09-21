package ±  ‘;

import java.util.Scanner;

public class tongcheng3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maps = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
            }
        }
        System.out.println(fun(maps));
    }

    public static int fun(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        for(int i = 1; i < m; i++){
            maps[i][0] += maps[i-1][0];
        }
        for(int i = 1; i < n; i++){
            maps[0][i] +=maps[0][i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                maps[i][j] += Math.min(maps[i-1][j], maps[i][j-1]);
            }
        }
        return maps[m-1][n-1];
    }
}