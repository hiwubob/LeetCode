package greedy;

public class No665feidijianshulie {
    //非递减数列
    public boolean checkPossibility(int[] nums) {
        int count=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                //left=i-2;
                //right=i;
                nums[i] = nums[i - 1];//左大右，右边变大
            } else {
                nums[i - 1] = nums[i];//否则把左边变小
            }
        }
        return count<=1;
    }
}
