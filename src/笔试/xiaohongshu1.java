package 笔试;

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

        // f[m][n] 表示从起始位置到当前位置的最短路径长度
        int[][] f = new int[n][m];
        // 先假设 f 中的每个点不可达，设为 Integer.MAX_VALUE
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        f[0][0] = 0;
        // 从头到尾遍历所有结点，每个点对应的 f 值都要更新
        // f[i][j] 的结果受到 f[i–1][j–2]，f[i+1][j–2]，f[i–2][j–1]，f[i+2][j–1] 的影响
        // 因为每次都从左边往右跳，所以需要先算左边列的答案
        for (int j = 1; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (grid[i][j]==0) {
                    // 除了边界点，对大多数点而言，有四个点可以到当前结点
                    // 判断条件满足 i 和 j 不越界，且当前结点的上一个位置不是不可达
                    // 即对应的 f 值不为 Integer.MAX_VALUE;
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

