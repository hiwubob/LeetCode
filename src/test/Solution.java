package test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, a, list, res);
        return res;
    }

    private void dfs(int i, int[] a, List<Integer> list, List<List<Integer>> res) {
        for (int j = i; j < a.length; j++) {
            list.add(a[i]);
            List list1 = new ArrayList(list);
            res.add(list1);
            dfs(i + 1, a, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> list=s.subsets(nums);
        System.out.println(list);
    }
}
