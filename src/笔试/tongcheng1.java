package ����;

import java.util.Scanner;

public class tongcheng1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String [] chars=str.split(",");
        int n=removeDuplicates(chars);
        System.out.println(n);

    }

    static int removeDuplicates(String  A[]) {
        int i = 0;    // ��һ��ָ��
        int j;        // �ڶ���ָ��
        int n = A.length;
        if (n <=1 ) return n;
        // ��������
        for (j = 1; j < n; j++) {
            if (!A[j] .equals(A[i]) ) { // ������ָ����ָԪ�ز�ͬ����i+1λ�ñ���j��ָԪ�ص�ֵ
                A[++i] = A[j];
            }
        }
        return i+1;    // ����������ĳ���
    }
}
