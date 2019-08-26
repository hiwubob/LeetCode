package test;

import java.util.Arrays;
import java.util.Scanner;
public class Beike24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();

        int[] dp = new int[1000005];
        for (int i = 0; i < n; i++) {
            for (int j = sum/2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        int diff = sum-2*dp[sum/2];
        System.out.print(diff+" ");
        int sum1 = (sum+diff)/2;
        int sum2 = sum-sum1;

        int cnt = Math.min(find(nums,sum1), find(nums, sum2));
        System.out.println(Math.abs(n-2*cnt));


    }

    public static int find(int[] nums, int sum){
        int cnt = 0;
        int tmp = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (tmp+nums[i] < sum) {
                tmp += nums[i];
                cnt ++;
            }else if (tmp+nums[i] > sum) {
                continue;
            } else if (tmp+nums[i] == sum){
                tmp += nums[i];
                cnt ++;
            }
        }
        return cnt;
    }

}