package test;

import java.util.Scanner;

public class beike2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String str=sc.next();
        String tmp = "";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 1; i < str.length(); i++) {
            String s1=str.substring(0, str.length()-i);
            String s2=str.substring(i);
            if (s1.equals(s2)) {
                tmp = str.substring(str.length() - i);
                break;
            } else if (i == str.length() - 1) {
                tmp=str;
            }
        }
        for (int i = 0; i < k-1; i++) {
            sb.append(tmp);
        }
        System.out.println(sb.toString());
    }
}
