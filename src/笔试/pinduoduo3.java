package ±  ‘;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class pinduoduo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i]=sc.nextInt();
        }

        double sum=0;
        for (int i = 0; i < n; i++) {
            for (int j = x[i]; j >0 ; j--) {
                sum+=(1/i)*x[i];
            }
        }

        DecimalFormat bg = new DecimalFormat("#.00");
        System.out.println(bg.format(sum/n));
    }
}
