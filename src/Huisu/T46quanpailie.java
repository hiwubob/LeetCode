package Huisu;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class T46quanpailie {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		ArrayList list = new ArrayList<Integer>();
		dfs(res, list, nums, 0);
		return res;
	}

	public void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int index) {
		if (index == nums.length) {
			ArrayList perList = new ArrayList<>();
			perList.addAll(list);
			res.add(perList);
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!list.contains(nums[i])) {
					list.add(nums[i]);
					dfs(res, list, nums, index + 1);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		T46quanpailie t = new T46quanpailie();
		List<List<Integer>> l = new ArrayList<>();
		int[] nums= {1,2,3};
		l=t.permute(nums);
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
	}
}
