package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	public List<Integer> topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> fre = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			fre.put(nums[i], fre.getOrDefault(nums[i], 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		int i = 0;
		List<Integer> topK = new ArrayList<>();
		for (Map.Entry<Integer, Integer> mapping : list) {
			if (i == k)
				break;
			topK.add(mapping.getKey());
			i++;
		}
		return topK;
	}
}
