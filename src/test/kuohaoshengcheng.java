package test;

import java.util.ArrayList;
import java.util.List;

public class kuohaoshengcheng {
    public List<String> generate(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    private void generate(ArrayList<String> res, String s, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }
        if (count1 == n && count2 == n) {
            res.add(s);
        }
        if (count1 >= count2) {
            String s2 = new String(s);
            generate(res, s2 + "(", count1 + 1, count2, n);
            generate(res, s2 + ")", count1, count2 + 1, n);
        }
    }
}
