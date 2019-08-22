package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class No452yongzuishaoshuliangdejianyinbaoqiqiu {
    //用最少数量的间引爆气球
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }

    public static void main(String[] args) {
        No452yongzuishaoshuliangdejianyinbaoqiqiu s=new No452yongzuishaoshuliangdejianyinbaoqiqiu();
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        int c=s.findMinArrowShots(points);
        System.out.println(c);
    }
}
