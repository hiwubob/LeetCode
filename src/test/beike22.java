package test;

import java.util.Scanner;

public class beike22 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int len=sc.nextInt();
            int times=sc.nextInt();
            String t=sc.next();
            int[] next=new int[len];
            find(t,next);
            String tmp=t.substring(next[len-1]+1,len);
            StringBuilder sb=new StringBuilder();
            sb.append(t);
            for (int i = 0; i <times-1 ; i++) {
                sb.append(tmp);
            }
            System.out.println(sb);
        }
        public static int[] find(String sub,int[] a) {
            char[] c = sub.toCharArray();
            int length=sub.length();
            int i,j;
            a[0] = -1;
            i = 0;
            for(j=1;j<length;j++) {
                i = a[j - 1];
                while(i>=0&&c[j]!=c[i+1]) {
                    i = a[i];
                }
                if(c[j]==c[i+1]) {
                    a[j] = i+1;
                }
                else {
                    a[j] = -1;
                }
            }
            return a;

        }

}
