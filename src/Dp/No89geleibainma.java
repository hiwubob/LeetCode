package Dp;

import java.util.ArrayList;
import java.util.List;

public class No89geleibainma {
    //格雷编码
//    知道了 n = 2 的解的话，如果是 { 0, 1, 3, 2}，
//    那么 n = 3 的解就是 { 0, 1, 3, 2, 2 + 4, 3 + 4, 1 + 4, 0 + 4 }，
//    即 { 0 1 3 2 6 7 5 4 }。之前的解直接照搬过来，然后倒序把每个数加上 1 << ( n - 1) 添加到结果中即可。


    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        gray.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            //倒序遍历
            for (int j = gray.size(); j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }
}
