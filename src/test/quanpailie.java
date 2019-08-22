package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quanpailie {
//    字符串全排列
    public ArrayList<String> per(String string) {
        List<String> res = new ArrayList<>();
        if (string.length() == 0) {
            return (ArrayList<String>) res;
        }
        dfs(0, res, string.toCharArray());
        Collections.sort(res);
        return (ArrayList<String>) res;
    }

    private void dfs(int i, List<String> res, char[] ch) {
        if (i == ch.length - 1) {
            if (!res.contains(new String(ch))) {
                res.add(new String(ch));
                return;
            }
        } else {
            for (int j = i; j < ch.length; j++) {
                swap(ch, i, j);
                dfs(i + 1, res, ch);
                swap(ch, i, j);
            }
        }
    }

    private void swap(char[] ch, int i, int j) {
        if (i == j) {
            return;
        } else {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
    }
}
