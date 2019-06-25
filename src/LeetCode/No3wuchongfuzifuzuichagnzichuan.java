package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No3wuchongfuzifuzuichagnzichuan {
//    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//    双指针
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
