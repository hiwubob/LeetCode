package JIANZHIOffer;

import java.util.Arrays;

public class No45pukepaishunzi {
    //    ÆË¿ËÅÆshunzi
    public boolean isContinuous(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        int count=0;
        for (int num :
                nums) {
            if (num == 0) {
                count++;
            }
        }

        for (int i = count; i < nums.length-1; i++) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            count-=nums[i+1]-nums[i]-1;
        }
        return count>=0;
    }
}
