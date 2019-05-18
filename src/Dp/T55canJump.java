package Dp;

public class T55canJump {
    /** - DP[i]: 在i点记录，i点之前的步数是否可以走到i点？ True of false.
            * - 其实j in [0~i)中间只需要一个能到达i 就好了
            * - Function: DP[i] = DP[j] && (A[j] >= i - j), for all j in [0 ~ i)
            * - Return: DP[dp.length - 1];
            * - Time: O(n^2)*/
    public boolean canJump(int[] nums) {
        if (nums==null||nums.length==0){
            return false;
        }
        int len = nums.length;
        boolean[] dp=new boolean[len];
        dp[0]=true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++){
                if (dp[j] && (nums[j] >= i - j)) {
                    dp[i]=true;
                }
                break;
            }

        }
        return dp[len-1];
    }
}
