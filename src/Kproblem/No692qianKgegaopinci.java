package Kproblem;

import java.util.*;

public class No692qianKgegaopinci {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word :
                words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String>[] bucket = new List[words.length + 1];
        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            int count = entry.getValue();
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(entry.getKey());
        }
        for (List<String> list : bucket) {
            if (list != null) {
                Collections.sort(list);
            }
        }
        flag:
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                for (String item : bucket[i]
                ) {
                    if (res.size() == k) {
                        break flag;
                    }
                    res.add(item);
                }
            }
        }
        return res;
    }
}
