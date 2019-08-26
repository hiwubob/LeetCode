package test;

import java.util.Arrays;
import java.util.Scanner;

public class beike11 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int S = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);

            int rs = 0,number = 0;
            for (int i = 0; i < n; i++) {
                if (number+nums[i] < S) {
                    number += nums[i];
                    rs++;
                }
            }
            System.out.println(rs);
        }

}
