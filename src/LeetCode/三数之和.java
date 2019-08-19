package LeetCode;

import java.util.Arrays;

public class 三数之和 {
    public int count3(int[] nums,int target) {
        int n=nums.length;
        int cnt=0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int l=i+1;
            int r=n-1;
            target-=nums[i];
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (target == sum) {
                    cnt++;
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return cnt;
    }
}
