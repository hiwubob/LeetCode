package Huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class T140dancifenge2 {
	Map<String, List<String>> map = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();

		if (wordDict.contains(s)) {
			res.add(s);
		}

		for (int i = 1; i < s.length(); i++) {
			String str = s.substring(0, i);
			if (wordDict.contains(str)) {
				List<String> list = wordBreak(s.substring(i), wordDict);
				if (list.size() > 0) {
					for (String ss : list) {
						res.add(str + " " + ss);
					}
				}
			}
		}
		map.put(s, res);
		return res;
	}
	public static void main(String[] args) {
		String s="catsanddog";
		List<String> wordDict=new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		T140dancifenge2 t=new T140dancifenge2();
		t.wordBreak(s, wordDict);
		List<String> result=new ArrayList<>();
		Iterator<String> it=result.iterator();
		while(it.hasNext()) {
			String str=(String)it.next();
			System.out.println(str);
		}
	}
}
