package greedy;

public class No53zuidazixuhe {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preMaxSum=0;
        int maxSum=Integer.MAX_VALUE;
        for (int num :
                nums) {
            preMaxSum = Math.max(num, preMaxSum + num);
            maxSum = Math.max(maxSum, preMaxSum);
        }
        return maxSum;
    }
}
