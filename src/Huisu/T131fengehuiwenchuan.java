package Huisu;

import java.util.ArrayList;
import java.util.List;

public class T131fengehuiwenchuan {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null) {
			return result;
		}

		List<String> tmp = new ArrayList<String>();
		if (s.length() == 0) {
			result.add(tmp);
			return result;
		}

		search(s, result, tmp, 0);
		return result;
	}

	private void search(String s, List<List<String>> result, List<String> tmp, int start) {
		if (start == s.length()) {
			List<String> p = new ArrayList<String>(tmp);
			result.add(p);
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPartition(s.substring(start, i + 1))) {
				tmp.add(s.substring(start, i + 1));
				search(s, result, tmp, i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

	private boolean isPartition(String tmp) {
		int i = 0;
		int j = tmp.length() - 1;
		while (i < j) {
			if (tmp.charAt(i) != tmp.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
