package Dp;

public class No198打家劫舍 {
    //头尾不相邻   Math.max(nums[index] + result[index - 2], result[index - 1])
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] result = new int[nums.length];
        result[0]=nums[0];
        result[1] = nums[1];
        for (int index = 2; index < result.length; index++) {
            result[index] = Math.max(nums[index] + result[index - 2], result[index - 1]);
        }
        return result[nums.length - 1];
    }
}
