package 笔试;

import java.util.Scanner;

public class 贝壳3 {
    //    绝对值差的最小两个数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        long[] ans = new long[2];
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long tmp = Math.abs(nums[i] - nums[i - 1]);
            if (tmp < res) {
                ans[0] = nums[i];
                ans[1] = nums[i+1];
                res=tmp;
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
    }
}

