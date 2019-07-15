package DBFS;

import java.util.ArrayList;
import java.util.List;

public class No46È«ÅÅÁĞ {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(res,new ArrayList<Integer>(),nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> leverList, int[] nums) {
        if (leverList.size() == nums.length) {
            res.add(new ArrayList<>(leverList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leverList.contains(nums[i])) {
                continue;
            }
            leverList.add(nums[i]);
            dfs(res, leverList, nums);
            leverList.remove(leverList.size() - 1);
        }
    }
}
