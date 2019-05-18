package Huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.CORBA.portable.RemarshalException;

public class T40zuhezonghe2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		func(ans, list, candidates, target, 0);
		return ans;
	}

	public void func(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int num) {
		if (target == 0) {
			ans.add(tmp);
			return;
		}
		for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
			List list = new ArrayList<>(tmp);
			list.add(candidates[i]);
			func(ans, list, candidates, target - candidates[i], i + 1);
			while (i < candidates.length - 1 && candidates[i + 1] == candidates[i])
				i++;
		}
	}
}
