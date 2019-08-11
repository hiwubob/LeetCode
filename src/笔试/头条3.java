package ±  ‘;

import java.util.Scanner;

public class Õ∑Ãı3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] year = new int[n];
        for (int i = 0; i < n; i++) {
            year[i] = sc.nextInt();
        }

        int[] money = new int[n];
        money[0]=100;
        int min=100;
        for (int i = 1; i < n; i++) {
            if (year[i - 1] < year[i]) {
                money[i]=money[i-1]+100;
            } else if (year[i - 1] == year[i]) {
                money[i] = money[i - 1];
            } else {
                money[i]=money[i-1]-100;
            }
            if (min > money[i]) {
                min = money[i];
            }
        }
        int sums=0;
        if (min < 100) {
            for (int mon :
                    money) {
                sums += mon + 100 - min;
            }
        } else {
            for (int mon :
                    money) {
                sums+=mon;
            }
        }
        System.out.println(sums);
    }
}
