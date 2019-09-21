package ±  ‘;

import java.util.Arrays;
import java.util.Scanner;

public class didi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }

        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; i+m+j <= n; j++) {
                sum=count(nums,i,i+m+j);
                min=Math.min(sum, min);
            }
        }


        System.out.println(min);
    }

    private static int count(int[] nums, int i, int j) {
        int s=0;
        for (int k = i; k < j; k++) {
            s += nums[k];
        }
        return s;
    }
}
