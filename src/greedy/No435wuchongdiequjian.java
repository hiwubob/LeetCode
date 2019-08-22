package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class No435wuchongdiequjian {
//    无重叠区间
    public int eraseOverlapIntervals(Inteval[] intevals) {
        if (intevals.length == 0) {
            return 0;
        }
        Arrays.sort(intevals, new Comparator<Inteval>() {
            @Override
            public int compare(Inteval o1, Inteval o2) {
                return o1.end - o2.end;
            }
        });
        int cnt=1;
        int end=intevals[0].end;
        for (int i = 1; i < intevals.length; i++) {
            if (intevals[i].start < end) {
                continue;
            }
            end=intevals[i].end;
            cnt++;
        }
        return intevals.length-cnt;
    }

    private class Inteval {
        int start;
        int end;

        Inteval() {
            start=0;
            end = 0;
        }

        Inteval(int s, int e) {
            start=s;
            end=e;
        }
    }
}
