package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T76 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {

                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        Integer[] res = new Integer[nums.length];
        for (int i = nums.length; i >= 0; i--) {
            int left = 0;
            int right = tmp.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tmp.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = left;
            tmp.add(left, nums[i]);

        }
        return Arrays.asList(res);
    }


}
