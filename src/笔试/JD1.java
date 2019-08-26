package ±  ‘;

import java.util.*;

public class JD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int[] height = new int[num];
        for (int i = 0; i < num; i++) {
            height[i] = sc.nextInt();
        }
        int[][] pair = new int[num][2];
        for (int i = 0; i < num; i++) {
            pair[i][0] = height[i];
            pair[i][1] = i;
        }

        int count=0;
        int minIndex=0;
        int maxIndex=num;
        while (minIndex <maxIndex) {
            List<int[]> list = new ArrayList<>();
            for (int i = minIndex; i <maxIndex ; i++) {
                list.add(pair[i]);
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            minIndex = list.get(0)[1]+1;
            maxIndex = list.get(list.size() - 1)[1]-1;
            count+=2;
        }
        System.out.println(count);
    }
}
