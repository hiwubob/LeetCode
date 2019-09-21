package 笔试;


import java.util.Scanner;

public class BigData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(new BigData().add(s1,s2));
    }
    //        大数相加
//        字符串相加
    public String add(String n1, String n2) {

        StringBuffer result = new StringBuffer();

        // 反转字符串
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n2.length();
        int maxLen = len1 > len2 ? len1 : len2;

        int c = 0;//进位
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                n1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                n2 += "0";
            }
        }

        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + c;
            int ap = nSum % 10;
            result.append(ap);
            c = nSum / 10;
        }
        //最高位进位
        if (c > 0) {
            result.append(c);
        }


        return result.reverse().toString();


    }


}


