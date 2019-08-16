package ±ÊÊÔ;

public class sdfhask {
    public int foo(int i) {
        if (i < 2) {
            return 1;
        }else
            return foo(i-3)+foo(i-2)+1;
    }

    public static void main(String[] args) {
        sdfhask s=new sdfhask();
        int m = s.foo(9);
        System.out.println(m);
    }
}
