package ±  ‘;

import java.util.Scanner;

import static ±  ‘.no3.minNum;

public class no3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] year = new int[n];
        for (int i = 0; i < n; i++) {
            year[i] = sc.nextInt();
        }
        int res = minNum(year);
        System.out.println(res*100);
    }
    public static int minNum(int[] score){
        if (score.length==0) {
            return 0;
        }
        if (score.length==1) {
            return 1;
        }
        int[] res = new int[score.length];
        res[0]=1;
        for(int i=1;i<score.length;i++){
            if (score[i]>score[i-1]) {
                res[i]=res[i-1]+1;
            }
            else{
                res[i]=1;
            }
        }
        for(int i=score.length-2;i>=0;i--){
            if (score[i]>score[i+1] && res[i]<=res[i+1]) {
                res[i]=Math.max(res[i], res[i+1]+1);
            }
        }

        return sumArray(res);
    }
    public static int sumArray(int[] arr){
        int res=0;
        for(int ele:arr){
            res+=ele;
        }
        return res;
    }

}
