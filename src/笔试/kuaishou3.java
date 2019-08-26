package ±  ‘;

import java.util.Scanner;

public class kuaishou3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] string1 = s1.split(" ");
        String[] string2 = s2.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = string1.length;
        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < n){
            for(int i =0; ind1+i<n&& i<4; i++){
                sb.append(string1[ind1+i]);
            }
            if(ind2<string2.length)
                sb.append(string2[ind2++]);
            ind1 += 4;
        }

        if(ind2<string2.length){
            while(ind2<string2.length)
                sb.append(string2[ind2++]);
        }
        String ans = sb.toString();
        for(int i =0; i<ans.length()-1; i++) {System.out.print(sb.charAt(i)+" ");}
        System.out.println(ans.charAt(ans.length()-1));

    }

}