package ±  ‘;

import java.util.Scanner;
import java.util.Stack;

public class QQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inPut = sc.next();
        StringBuilder s = new StringBuilder(inPut);
        Stack<Integer> stack = new Stack<>();
        while (s.toString().contains("[")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[') {
                    stack.push(i);
                }
                if (s.charAt(i) == ']') {
                    int last = stack.pop();
                    String temp = s.substring(last, i + 1);
                    s.replace(last, i + 1, trans(temp));
                    stack.clear();
                    break;
                }
            }
        }

        System.out.println(s);

    }

    private static String trans(String t) {
        int index = 2;
        for (; index < t.length(); index++) {
            if (t.charAt(index) == '|')
                break;
        }
        int cishu = Integer.parseInt(t.substring(1, index));
        String temp = t.substring(index + 1, t.length() - 1);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < cishu; i++) {
            ret.append(temp);
        }
        return ret.toString();
    }

}
