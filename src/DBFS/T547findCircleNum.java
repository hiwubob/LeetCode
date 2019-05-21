package DBFS;

public class T547findCircleNum {
    public int findCircleNum(int[][] M) {
        int count = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && !hasVisited[j]) {
                dfs(M, j, hasVisited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        T547findCircleNum t=new T547findCircleNum();
        int n = t.findCircleNum(m);
        System.out.println(n);
    }
}
