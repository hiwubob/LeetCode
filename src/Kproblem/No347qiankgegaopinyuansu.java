package Kproblem;

import java.util.*;

public class No347qiankgegaopinyuansu {
    //    ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
    //Ͱ����
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count=entry.getValue();
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(entry.getKey());
        }
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
