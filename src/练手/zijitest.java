package 练手;

import java.util.ArrayList;
import java.util.List;

public class zijitest {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, nums, list, res);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> list, List<List<Integer>> res) {
        for (; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(list);
            dfs(i + 1, nums, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        zijitest d=new zijitest();
        int[] nums = {1, 2, 3};
        d.subsets(nums);
        System.out.println(d.subsets(nums));
    }
}
