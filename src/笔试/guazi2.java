package ±  ‘;

import java.util.Scanner;

public class guazi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] <= nums[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }

    }
}
