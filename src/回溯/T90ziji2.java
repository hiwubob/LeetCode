package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90ziji2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> tmp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            //和上一个数相同就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            getAns(nums, i + 1, tmp, ans);
            tmp.remove(tmp.size()-1);

        }
    }
}
