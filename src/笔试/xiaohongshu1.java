package ����;

import java.util.Scanner;

public class xiaohongshu1 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[][] obstacle=new int[n][k];
        for (int i = 0; i < 2*k; i++) {
            obstacle[sc.nextInt()][sc.nextInt()]=1;
        }

        int result = shortestPath(obstacle);
        System.out.println(result);
    }
    public int shortestPath(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }

        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        // f[m][n] ��ʾ����ʼλ�õ���ǰλ�õ����·������
        int[][] f = new int[n][m];
        // �ȼ��� f �е�ÿ���㲻�ɴ��Ϊ Integer.MAX_VALUE
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        f[0][0] = 0;
        // ��ͷ��β�������н�㣬ÿ�����Ӧ�� f ֵ��Ҫ����
        // f[i][j] �Ľ���ܵ� f[i�C1][j�C2]��f[i+1][j�C2]��f[i�C2][j�C1]��f[i+2][j�C1] ��Ӱ��
        // ��Ϊÿ�ζ��������������������Ҫ��������еĴ�
        for (int j = 1; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (grid[i][j]==0) {
                    // ���˱߽�㣬�Դ��������ԣ����ĸ�����Ե���ǰ���
                    // �ж��������� i �� j ��Խ�磬�ҵ�ǰ������һ��λ�ò��ǲ��ɴ�
                    // ����Ӧ�� f ֵ��Ϊ Integer.MAX_VALUE;
                    if (i >= 1 && j >= 1 && f[i - 1][j - 1] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                    }
                    if (i + 1 < n && j >= 1 && f[i + 1][j - 1] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i + 1][j - 1] + 1);
                    }
                    if (i >= 1 && j >= 1 && f[i - 1][j - 1] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                    }
                    if (i + 1 < n && j >= 1 && f[i + 1][j - 1] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i + 1][j - 1] + 1);
                    }
                }
            }
        }


        if (f[n - 1][m - 1] == Integer.MAX_VALUE) {
            return 0;
        }

        return f[n - 1][m - 1];
    }
}

