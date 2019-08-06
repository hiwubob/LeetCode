package ±  ‘;

import java.util.Scanner;

public class ∆¥∂‡∂‡1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA=sc.nextLine().toString();
        String numA[]=strA.split(" ");
        int[] a = new int[numA.length];
        for (int i = 0; i < numA.length; i++) {
            a[i] = Integer.parseInt(numA[i]);
        }
        String strB=sc.nextLine().toString();
        String numB[]=strB.split(" ");
        int[]  b = new int[numB.length];
        for (int i = 0; i < numB.length; i++) {
            b[i] = Integer.parseInt(numB[i]);
        }

        int tmp;
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < a.length-1; i++) {
            if (a[i - 1] > a[i] && a[i] < a[i + 1]) {
                for (int j = 0; j < b.length; j++) {
                    if (b[j] > a[i - 1] && b[j] < a[i + 1]) {
                        if (b[j] > max) {
                            max = b[j];
                        }
                        a[i] = max;
                    } else {
                        if (j == b.length - 1) {
                            System.out.println("No");
                        }
                    }
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
