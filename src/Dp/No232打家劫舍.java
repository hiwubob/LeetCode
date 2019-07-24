package Dp;

public class No232��ҽ��� {
    //ͷβ���
//    ֻ�ǰ���λ���������ǿ��Խ��������һ�£���Ȼ��β���������ǾͰ���������ֳ�nums[0]-nums[n-1]��nums[1]-nums[n]�������֣�Ȼ������һ��ķ����ֱ����һ���������������Ȼ��ȡ������ֵ�нϴ���Ǹ�ֵ������������������ε�С�����ܹ�͵�����ֵ
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
