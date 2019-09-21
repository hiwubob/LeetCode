package ±  ‘;

import java.util.Arrays;
import java.util.Scanner;


public class tongcheng2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println(fun(numbers));
    }
    public static int fun(int[] nums) {
        int[] dishes = new int[nums.length];
        Arrays.fill(dishes, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dishes[i] = dishes[i - 1] + 1;
            }
        }
        int counts = dishes[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                dishes[i] = Math.max(dishes[i], dishes[i + 1] + 1);
            }
            counts += dishes[i];
        }
        return counts;
    }
}
