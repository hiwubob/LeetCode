package stack;

import java.util.HashMap;
import java.util.Stack;

public class T496nextGreaterElement {
//	下一个最大元素
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] resArr = new int[nums1.length];
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums2) {
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}

		for (int i = 0; i < nums1.length; i++) {
			resArr[i] = map.getOrDefault(nums1[i], -1);

		}
		return resArr;
	}
}
