package ±  ‘;

import java.util.Scanner;

public class toutiao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k=sc.nextInt();
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder();

        int start = 0;
        for(int i =0; i<k-2;i++) {
            int tmp=(s.charAt(0)-'0')^0;
            for (int j = 1; j <k-1 ; j++) {
                tmp^=(s.charAt(j)-'0');
            }
            sb.append(tmp);
        }
        for (int i = k-1; i < n; i++) {
            int tmp=sb.charAt(i)-'0';
            for (int j = i; j >0 ; j--) {
                tmp^=(s.charAt(j)-'0');
            }
            sb.append(tmp);
        }
        System.out.println(sb.toString());
    }
}
