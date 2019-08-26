package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bucket {
    public static void bucketSort(int[] a) {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        int bucketNum=(max-min)/a.length+1;
        List<List<Integer>> list = new ArrayList<>(bucketNum);
        for (int i = 0; i <bucketNum ; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < a.length; i++) {
            int num=(a[i]-min)/a.length;
            list.get(num).add(a[i]);
        }
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(list.get(i));
        }
        System.out.println(list.toArray());
    }

    public static void main(String[] args) {

    }
}
