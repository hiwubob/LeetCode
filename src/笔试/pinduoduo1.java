package ±  ‘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pinduoduo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split("[,;]");
        int n = Integer.parseInt(str1[str1.length - 1]);
        int[] nums = new int[str1.length - 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str1[i]);
        }
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count == n) break;
            if (nums[i] % 2 == 0) {
                result.add(nums[i]);
                count++;
            }
        }
        if (count < n) {
            int delt = n - count;
            int tmp = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (tmp == delt) break;
                if (nums[i] % 2 == 1) {
                    result.add(nums[i]);
                    tmp++;
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ",");
            }
        }

    }
}

