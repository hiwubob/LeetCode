package stack;

import java.util.Stack;

/*使用indexStack作为元素的索引栈，resArr存放返回结果
比对当前元素与栈顶元素的大小
若当前元素 < 栈顶元素：入栈
若当前元素 > 栈顶元素：弹出栈顶元素，记录两者下标差值即为所求天数**/
public class T739dailytemperatures {
	public int[] dailyTemperatures(int[] T) {
		int n = T.length;
		int[] resArr = new int[n];
		Stack<Integer> indexStack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!indexStack.isEmpty() && T[indexStack.peek()] < T[i]) {
				int curIndex = indexStack.pop();
				resArr[curIndex] = i - curIndex;
			}
			indexStack.push(i);
		}
		return resArr;
	}
}
