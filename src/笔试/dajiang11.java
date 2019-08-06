package 笔试;

import java.util.ArrayList;
import java.util.Scanner;

public class dajiang11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int caseNum=Integer.parseInt(sc.next());
        ArrayList<int[][]> Mycase=new ArrayList<>();
        for (int i = 0; i <caseNum ; i++) {
            int N=Integer.parseInt(sc.next());
            int day=Integer.parseInt(sc.next());
            int[][] caseTemp=new int[N+1][2];
            caseTemp[0][0]=N;
            caseTemp[0][1]=day;
            for (int j=0;j<N;j++){
                caseTemp[j+1][0]=Integer.parseInt(sc.next());
                caseTemp[j+1][1]=Integer.parseInt(sc.next());
            }
            Mycase.add(caseTemp);
        }
        for (int i = 0; i <caseNum ; i++) {
            int[] value=new int[Mycase.get(i)[0][0]];//成就
            int[] day=new int[Mycase.get(i)[0][0]];//时间
            for (int j = 0; j < Mycase.get(i)[0][0]; j++) {
                value[j]=Mycase.get(i)[j+1][0];
                day[j]=Mycase.get(i)[j+1][1];
            }
            int a=knapsack(Mycase.get(i)[0][1],Mycase.get(i)[0][0],value,day);
            System.out.println(a);
        }

    }
    public static int knapsack(int days, int N, int[] value,int[] day) {
        int[][] dp = new int[N + 1][days + 1];
        for (int i = 1; i <= N; i++) {
            int w = day[i - 1], v = value[i - 1];
            for (int j = 1; j <= days; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][days];
    }
}