package ����;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NOƴ���4 {

    static class Box {
        int len;
        int weight;
    }
    public static void main(String[] args) {
/*        ��N���������ľ�� ÿ����ľ�ĸ߶���1������ΪLi
    ������ΪWi��������Ҫ����Щ��ľ��һ���߸ߵĽ�������
        ÿһ�����ҽ���һ���ľ��ɣ�ͬʱÿһ���ľ�ı߳������·��Ļ�ľС��
        ÿ���ľ���ܳ�������������7���������������߿��Դ�һ����ߵĽ�������*/

/*        ����Ӧ����ǰi����ľ�ܴ�ɸ�Ϊh�Ľ���������С����Ϊ״̬����ô״̬ת�Ʒ���Ϊ
        dp[i][h]=min(dp[i][h], dp[k][h-1]+b[i].weight)*/

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Box[] b = new Box[n + 1];
            b[0] = new Box();
            for (int i = 1; i < n+1; i++) {
                b[i] = new Box();
                b[i].len = in.nextInt();
            }
            for (int i = 1; i < n+1; i++) {
                b[i].weight = in.nextInt();
            }

            Arrays.sort(b, (b1, b2) -> b1.len==b2.len?b1.weight-b2.weight:b1.len-b2.len);

            int res=0;
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 0; i <n+1 ; i++) {
                for (int j = 0; j < n+1; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            dp[0][0]=0;
            for (int i = 1; i < n+1; i++) {
                for (int k = 0; k < i; k++) {
                    if (b[k].len < b[i].len) {
                        for (int j = 0; j <= k; j++) {
                            if (dp[k][j] != Integer.MAX_VALUE && dp[k][j] <= b[i].weight * 7) {
                                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[k][j] + b[i].weight);
                                res = Math.max(res, j + 1);
                            }
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
