package ����;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class xiecheng2 {


    /*������������������ʵ����ĿҪ��Ĺ���
    ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^
    ******************************��ʼд����******************************/
    static String resolve(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int flag = 0;
        int i = 0;
        Stack<String> stack = new Stack<>();
        stack.push("");
        while(i < len){
            if(s.charAt(i) != '(' && flag == 0 ){
                sb.append(s.charAt(i));
                i++;
            }
            else if(s.charAt(i) == ')'){
                String tmp = stack.pop();
                flag--;
                if(flag == 0) sb.append(new StringBuilder(tmp).reverse().toString());
                else {
                    String str = new StringBuilder((stack.pop()+tmp)).reverse().toString();
                    stack.push(str);
                }
                i++;
            }
            else if(s.charAt(i) == '('){
                i++;
                int start  = i;
                flag++;
                while(s.charAt(i)!='(' && s.charAt(i) != ')')i++;
                if(s.charAt(i) == '(')continue;
                stack.push((s.substring(start,i)));
            }

            else{
                int start = i;
                while(s.charAt(i)!=')')i++;
                String temp = stack.pop();
                stack.push(temp+s.substring(start,i));
            }
        }
        return sb.toString();
    }

    /******************************����д����******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

