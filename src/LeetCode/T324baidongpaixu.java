package LeetCode;

import java.util.Arrays;

public class T324baidongpaixu {
	public void wiggleSort(int[] nums) {
		if (nums.length == 1)
			return;
		Arrays.sort(nums);
		int mid = nums.length / 2;
		int[] res = new int[nums.length];
		if (nums.length % 2 == 0) {
			int j = 0;
			for (int i = 0; i < mid; i++) {
				res[j] = nums[i];
				j = j + 2;
			}

			int k = 1;
			for (int i = mid; i < nums.length; i++) {
				res[k] = nums[i];
				k = k + 2;
			}
		} else {
			int j = 0;
			for (int i = 0; i < mid; i++) {
				res[j] = nums[i];
				j = j + 2;
			}
			int k = 1;
			for (int i = mid + 1; i < nums.length; i++) {
				res[k] = nums[i];
				k = k + 2;
			}
		}
		
		for(int i=1;i<nums.length;i++) {
			if(res[i]==res[i-1]) {
				int tmp=res[i+1];
				res[i+1]=res[i-1];
				res[i-1]=tmp;
				
				int tepo=res[i];
				res[i]=res[i-2];
				res[i-2]=tepo;
			}
		}
		for(int i=0;i<res.length;i++) {
			nums[i]=res[i];
		}
	}
}
