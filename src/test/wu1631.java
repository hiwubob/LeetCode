package test;

import java.util.Scanner;

public class wu1631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i]=sc.nextInt();
        }
        int q=sc.nextInt();
        int[] num = new int[q];
        for (int i = 0; i < q; i++) {
            num[i]=sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            paiming(n, score, num[i]);
        }

    }

    private static void paiming(int n, int[] score, int i) {
        int count=0;
        for (int j = 0; j <n ; j++) {
            if (score[j]>score[i]){
                count++;
            }
        }
        int percent=(count-1)/n;
        System.out.println(percent);
    }

}
