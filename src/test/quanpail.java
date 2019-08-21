package test;

import java.util.ArrayList;
import java.util.List;

public class quanpail {
    public List<List<Integer>> per(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        per(res, list, a, 0);
        return res;
    }

    private void per(List<List<Integer>> res, List<Integer> list, int[] a, int i) {
        if (i == a.length) {
            ArrayList per = new ArrayList();
            per.addAll(list);
            res.add(per);
            return;
        } else {
            for (int j = 0; j < a.length; j++) {
                if (!list.contains(a[j])) {
                    list.add(a[j]);
                    per(res,list,a,i+1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
