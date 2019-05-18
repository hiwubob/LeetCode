package Huisu;

import java.util.LinkedList;
import java.util.List;

public class T77zuhe2 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new LinkedList<>();
		List<Integer> li = new LinkedList<>();
		huisu(list, li, n, k);
		return list;
	}

	private void huisu(List<List<Integer>> list, List<Integer> li, int n, int k) {
		if (k == 0) {
			list.add(li);
			return;
		}
		if (n < k) {
			return;
		}

		for (int i = n; i >= 1; i--) {
			List<Integer> copy = new LinkedList<>();
			copy.addAll(li);
			copy.add(i);
			huisu(list, copy, i - 1, k - 1);
		}
	}
}
