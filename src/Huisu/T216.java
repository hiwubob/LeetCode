package Huisu;

import java.util.ArrayList;
import java.util.List;

public class T216 {
	/**
	 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
	 * 所有数字都是正整数。
	 * 解集不能包含重复的组合。 
	 * */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if (n > 9 * k)
			return res;
		dfs(res, list, n, k, 1, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> list, int n, int k, int index, int sum) {
		if (list.size() == k) {
			if (sum == n) {
				res.add(new ArrayList<>(list));
			}
			return;
		} else {
			for (int i = index; i <= 9; i++) {
				if (sum + i <= n) {
					list.add(i);
					dfs(res, list, n, k, i + 1, sum + i);
					list.remove(list.size() - 1);
				} else {
					return;
				}
			}
		}

	}
}
