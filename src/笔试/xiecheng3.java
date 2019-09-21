package 笔试;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class xiecheng3 {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        int min = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        if (array.length == 0) {
            return 0;
        }
        if (m >= array.length) {
            Arrays.sort(array);
            res = array[array.length - 1];
        } else if (m == 1) {
            res = sum(0, array.length,array);
        } else if (m == 2) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = array.length - 1; j > i ; j--) {
                    int sum1 = sum(0, j, array);
                    int sum2 = sum(j, array.length, array);
                    res = Math.max(sum1,sum2);
                }
            }
        } else {
            for (int i = 0; i < array.length - 2; i++) {
                for (int j = array.length - 1; j > i + 1; j--) {
                    int sum1 = sum(0, i + 1, array);
                    int sum2 = sum(i + 1, j, array);
                    int sum3 = sum(j, array.length, array);
                    min = Math.max(sum1, Math.max(sum2, sum3));
                    res = Math.min(res, min);
                }
            }
        }
        return res;
    }

    private static int sum(int i, int j, int[] array) {
        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += array[k];
        }
        return sum;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}
