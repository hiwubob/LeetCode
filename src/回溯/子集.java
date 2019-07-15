package ����;

import java.util.ArrayList;
import java.util.List;

public class �Ӽ� {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(0, nums, cur, result);
        result.add(new ArrayList<>());
        return result;
    }

    public void dfs(int curi, int[] nums, List<Integer> cur, List<List<Integer>> result) {
        for (; curi < nums.length; ++curi) {
            cur.add(nums[curi]);
            List<Integer> list = new ArrayList<>(cur);
            result.add(list);
            dfs(curi + 1, nums, cur, result);
            cur.remove(cur.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        �Ӽ� s=new �Ӽ�();
        List list=s.subsets(a);
        System.out.println(list);
    }
}
