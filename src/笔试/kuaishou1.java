package ±  ‘;



import java.util.Scanner;

public class kuaishou1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[][] str = new String[n][2];
        for (int i = 0; i < n; i++) {
            str[i][0]=sc.next();
            str[i][1]=sc.next();
        }

        for (int i = 0; i < n; i++) {
            boolean result= verify(str[i][0],str[i][1]);
            System.out.println(result);
        }
    }

    public static boolean verify(String s1, String s2){
        boolean flag = true;
        String[] pre = s1.split("\\.");
        String[] post = s2.split("\\.");

        int[] ipre = new int[pre.length];
        int[] ipost = new int[post.length];

        for(int i = 0;i < pre.length;i++){
            ipre[i] = Integer.parseInt(pre[i]);
        }
        for(int i = 0;i < post.length;i++){
            ipost[i] = Integer.parseInt(post[i]);
        }

        int count = 0;
        if(pre.length < post.length){
            count = validata(ipost, ipre);
            if(count > 0){
                flag = true;
            }else{
                flag = false;
            }
        }else{
            count = validata(ipre, ipost);
            if(count >= 0){
                flag = false;
            }else{
                flag = true;
            }
        }
        return flag;
    }

    public static int validata(int[] biglen,int[] snlen){
        int flag = 0;
        int temp = 0;
        for(int i = 0;i < biglen.length;i++){
            if(i > snlen.length-1){
                temp = 0;
            }else{
                temp = snlen[i];
            }
            if(temp < biglen[i]){
                flag = 1;
                return flag;
            }else if(temp > biglen[i]){
                flag = -1;
                return flag;
            }else{
                if(i == biglen.length-1){
                    flag = 0;
                }else{
                    continue;
                }
            }
        }
        return flag;
    }
}




