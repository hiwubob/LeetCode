package 回溯;

import java.util.ArrayList;
import java.util.List;

public class T131partition {
    List<List<String>> resList = new ArrayList<>();

    //分割回文串
    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0) {
            return resList;
        }
        dfs(s, new ArrayList<String>(), 0);
        return resList;
    }

    private void dfs(String s, List<String> list, int l) {
        //当l==s的len时，表示已经到底了
        if (l == s.length()) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int r = l; r < s.length(); r++) {
            //判断s 的l 到r 上是否是回文
            if (isPalindrome(s, l, r)) {
                list.add(s.substring(l, r + 1));
                //递归，r+1，再往右多取一个字符
                dfs(s, list, r + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 判断是否是回文，指针碰撞
     */
    private boolean isPalindrome(String str, int l, int r) {
        while (l < r && str.charAt(l) == str.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }


}
