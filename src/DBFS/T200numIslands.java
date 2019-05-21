package DBFS;

public class T200numIslands {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        //判断是否到达边界
        if (!validateInput(grid, x, y)) {
            return;
        }
        //被访问过后，改为0
        grid[x][y] = '0';
        for (int i = 0; i < dx.length; i++) {
            dfs(grid, x + dx[i], y + dy[i]);
        }
    }

    private boolean validateInput(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == '0') {
            return false;

        }
        return true;
    }
}
