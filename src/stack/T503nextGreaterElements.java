package stack;

import java.util.Arrays;
import java.util.Stack;

public class T503nextGreaterElements {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] resArr = new int[n];
		Arrays.fill(resArr, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 2 * n; i++) {
			int curNum = nums[i % n];
			while (!stack.isEmpty() && nums[stack.peek()] < curNum) {
				resArr[stack.pop()] = curNum;
			}
			if (i < n) {
				stack.push(i);
			}
		}
		return resArr;
	}
}
