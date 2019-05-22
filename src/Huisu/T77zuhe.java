package Huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T77zuhe {
//	给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。/**/
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (n <= 0 || k <= 0) {
			return result;
		}
		dfs(result, new ArrayList<Integer>(), 1, n, k);
		return result;
	}

	private void dfs(List<List<Integer>> result, ArrayList<Integer> list, int index, int n, int k) {
		for (int i = index; i <= n; i++) {
			list.add(i);
			if (list.size() == k) {
				result.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
				continue;
			}
			dfs(result, list, i + 1, n, k);
			list.remove(list.size() - 1);
		}
	}
}
