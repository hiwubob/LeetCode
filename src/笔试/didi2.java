package ±  ‘;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class didi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt()-1;
            nums[i][1] = sc.nextInt()-1;
        }


        int max=Integer.MIN_VALUE;
        List<Integer>[] con = new List[n];

        for (int i = 0; i < n; i++) {
            con[i] = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                if (nums[j][0] == i) {
                    con[i].add(nums[j][1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[j][1] == i) {
                    con[i].add(nums[j][1]);
                }
            }
        }

        int flag=0;
        for (int i = 0; i < n; i++) {
            int result=0;
            if (con[i].size() == 0) {
                flag++;
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (!con[i].contains(j)) {
                    result++;
                    max = Math.max(result, max);
                }else{
                    continue;
                }
            }

        }
        if (flag == n) {
            System.out.println(n);
        } else {
            System.out.println(max);
        }

    }
}
