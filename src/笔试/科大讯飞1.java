package ±  ‘;

import java.util.Scanner;

public class ø∆¥Û—∂∑…1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target=sc.nextInt();

        int low=0;
        int high = nums.length;
        int index = getKey(nums, target, low, high);
        if (index == -1) {
            System.out.println("-1");
        } else {
            System.out.println(index+1);
        }
    }

    private static int getKey(int[] nums, int target, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            return getKey(nums, target, mid + 1, high);
        } else {
            return getKey(nums, target, low, mid - 1);
        }
    }
}