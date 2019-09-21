package 笔试;

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
        int i = 0;    // 第一个指针
        int j;        // 第二个指针
        int n = A.length;
        if (n <=1 ) return n;
        // 遍历数组
        for (j = 1; j < n; j++) {
            if (!A[j] .equals(A[i]) ) { // 若两个指针所指元素不同，则i+1位置保存j所指元素的值
                A[++i] = A[j];
            }
        }
        return i+1;    // 返回新数组的长度
    }
}
