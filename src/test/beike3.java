package test;

import java.util.Scanner;

public class beike3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long bag = sc.nextLong();
        int[] number = new int[n];
        int[] sizes = new int[n];
        long result = 0;
        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
            sizes[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            long tmp = bag / sizes[i];
            if (tmp > number[i]) {
                result += number[i];
                bag -= number[i] * sizes[i];
            } else {
                result += tmp;
                bag -= tmp * sizes[i];
            }

        }
        System.out.println(result);
    }

}
