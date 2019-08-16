package ±  ‘;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;

public class ±¥ø«1 {
//    æŸ÷ÿ

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(solve(nums));
    }

    static int solve(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += cnt(nums, i);
        }
        return res;
    }

    public static int cnt(int[] nums, int index) {
        int res = 0;
        if (index == nums.length - 1) {
            return res;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if ((nums[index] >= nums[i] * 0.9)) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}

