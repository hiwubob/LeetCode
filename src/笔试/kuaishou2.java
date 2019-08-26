package ±  ‘;

import java.util.Scanner;

public class kuaishou2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i : nums) {
            System.out.println(function(i));
        }

    }

    public static boolean function(int n) {
        int tmp = n;
        while (true) {
            tmp = func2(tmp);
            if (tmp == 1) {
                return true;
            } else if (tmp == 89) {
                return false;
            }
        }
    }
    public static int func2(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }
}
