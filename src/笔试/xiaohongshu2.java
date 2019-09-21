package ±  ‘;

import java.util.*;

public class xiaohongshu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for(int i =0; i<str.length();i++){
            if(!s2.isEmpty()){
                if(str.charAt(i) == '(')s2.push(0);
                else if(str.charAt(i) == ')')s2.pop();
                else continue;
            }
            else if(str.charAt(i) == '('){
                s2.push(0);
            }
            else if(str.charAt(i) == '<'){
                if(!s1.isEmpty()){s1.pop();}
            }
            else s1.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!s1.isEmpty()){
            sb.append(s1.pop());
        }
        System.out.println(sb.reverse().toString());
    }

}