package Huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47quanpailie2 {
	private List<List<Integer>> ret;
	private boolean[] used;

	public List<List<Integer>> permuteUnique(int[] nums) {
		ret = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return ret;

		Arrays.sort(nums);
		used = new boolean[nums.length];
		dfs(nums, new ArrayList<>(nums.length));
		return ret;
	}

	private void dfs(int[] nums, List<Integer> list) {
		if (list.size() == nums.length) {
			ret.add(new ArrayList<>());
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				if (i != 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
					continue;
				}

				list.add(nums[i]);
				used[i] = true;
				dfs(nums, list);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}

	}
}
