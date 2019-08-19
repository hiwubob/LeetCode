package ±  ‘;

        import java.util.Map;
        import java.util.Scanner;

public class N360 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] positon = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                positon[i][j] = sc.nextInt();
            }
        }

        int[][] area = new int[n][m];
        int sum = 0;
        int aup;
        int adown;
        int aleft;
        int aright;
        int a1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (n == 1) {

                }
                if (i == 0 && j == 0) {
                    adown=Math.min(positon[i][j],positon[i+1][j]);
                    aright=Math.min(positon[i][j],positon[i][j+1]);
                    a1=4*positon[i][j]+2;
                    area[i][j]=a1-adown-aright;
                } else if (i == 0 && j == m - 1) {
                    aleft = Math.min(positon[i][j], positon[i][j - 1]);
                    adown = Math.min(positon[i][j], positon[i + 1][j]);
                    a1=4*positon[i][j]+2;
                    area[i][j] = a1 - adown  - aleft;
                } else if (i == 0) {
                    aleft = Math.min(positon[i][j], positon[i][j - 1]);
                    adown = Math.min(positon[i][j], positon[i + 1][j]);
                    aright = Math.min(positon[i][j], positon[i][j + 1]);
                    a1=4*positon[i][j]+2;
                    area[i][j] = a1 - adown - aright - aleft;
                }else if (i == n - 1 && j == 0) {
                    aup=Math.min(positon[i][j],positon[i-1][j]);
                    aright=Math.min(positon[i][j],positon[i][j+1]);
                    a1=4*positon[i][j]+2;
                    area[i][j]=a1-aup-aright;
                } else if (i == n - 1 && j == m - 1) {
                    aup=Math.min(positon[i][j],positon[i-1][j]);
                    aleft = Math.min(positon[i][j], positon[i][j - 1]);
                    a1=4*positon[i][j]+2;
                    area[i][j]=a1-aup-aleft;
                } else if (i == n - 1) {
                    aleft = Math.min(positon[i][j], positon[i][j - 1]);
                    aup=Math.min(positon[i][j],positon[i-1][j]);
                    aright=Math.min(positon[i][j],positon[i][j+1]);
                    a1=4*positon[i][j]+2;
                    area[i][j]=a1-aup-aright-aleft;
                }else {
                    aleft = Math.min(positon[i][j], positon[i][j - 1]);
                    aup = Math.min(positon[i][j], positon[i - 1][j]);
                    aright = Math.min(positon[i][j], positon[i][j + 1]);
                    adown = Math.min(positon[i][j], positon[i + 1][j]);
                    a1 = 4 * positon[i][j] + 2;
                    area[i][j] = a1 - aup - aright - aleft - adown;
                }
                sum += area[i][j];
            }
        }
        System.out.println(sum);

    }
}
