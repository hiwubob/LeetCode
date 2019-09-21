package ±  ‘;

import java.util.Scanner;
import java.util.Stack;

public class baidu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        s.push(n);
        int min = 2 + k;
        int count = 0;
        if (n <= min) {
            System.out.println(1);
        } else {
            while (!s.isEmpty()) {
                int tmp = s.pop();
                count++;
                if (tmp > min) {
                    int s1=tmp+k;
                    int s2=tmp-k;
                    if (s1%2 == 0 ) {
                        if(s2 % 2 == 0){
                        int x = s1 / 2;
                        int y = s2 / 2;
                        s.push(x);
                        s.push(y);
                    }}
                } else {
                    continue;
                }
            }
            System.out.println(count);
        }
    }
}
