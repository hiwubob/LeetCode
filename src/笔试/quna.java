package ±  ‘;

import java.util.Scanner;

public class quna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j]= sc.nextInt();
            }
        }

        int tmp = sum(nums, 0);
        for (int i = 1; i < n; i++) {
            int sum = sum(nums, i);
            if (sum > tmp) {
                tmp = sum;
            }
        }
        System.out.println(tmp);
    }

    private static int sum(int[][] nums, int i) {
        int sum=0;
        for (int j = 0; j < nums[0].length; j++) {
            sum += nums[j][i];
        }
        return sum;
    }
}
