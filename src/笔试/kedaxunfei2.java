package ±  ‘;

import java.util.Scanner;

public class kedaxunfei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int low=0;
        int high=0;
        int count=0;
        int len=str.length();
        char c;
        StringBuilder sb = new StringBuilder();
        while (low < len) {
            high=low;
            c = str.charAt(low);
            while ((high < len) && (str.charAt(high) == c)) {
                high++;
            }
            count=high-low;
            if (count > 1) {
                sb.append(count);
                sb.append(c);
            } else {
                sb.append(c);
            }

            low=high;
        }
        System.out.println(sb.toString());
    }
}
