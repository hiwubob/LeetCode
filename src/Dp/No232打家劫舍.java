package Dp;

public class No232打家劫舍 {
    //头尾相接
//    只是把首位相连，我们可以将这道题拆分一下，既然首尾相连，我们就把这个数组拆分成nums[0]-nums[n-1]和nums[1]-nums[n]两个部分，然后按照上一题的方法分别计算一下两个数组的最大金额，然后取这两个值中较大的那个值就是我们能在这个环形的小区所能够偷得最大值
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
        int[] result1 = new int[nums.length - 1];
        int[] result2 = new int[nums.length - 1];

        result1[0]=nums[0];
        result1[1] = Math.max(nums[0], nums[1]);

        result2[0] = nums[1];
        result2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < result1.length; i++) {
            result1[i] = Math.max(nums[i] + result1[i - 2], result1[i - 1]);
        }

        for (int j = 2; j < result2.length; j++) {
            result2[j] = Math.max(nums[j + 1] + result2[j - 2], result2[j - 1]);
        }
        return Math.max(result1[nums.length - 2], result2[nums.length - 2]);
    }
}
