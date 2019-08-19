package ±  ‘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ø∆¥Û—∂∑…2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ((c - '0' >= 0) && (c - '0') <= 9) {
                    sb.append(c);

                }
            }

            StringBuilder ans = new StringBuilder();
            if (sb.length() == 0) {
                ans.append(-1);
            } else {

                int n = sb.length();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = sb.charAt(i)-'0';
                }
                Arrays.sort(nums);
                for (int i = 0; i < n; i++) {
                    ans.append(nums[i]);
                }
            }
            System.out.println(ans);
    }
}
