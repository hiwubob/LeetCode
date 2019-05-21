package DBFS;

public class T695maxAreaOfIsland {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {1, -1, 0, 0};
    int row, col;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxArea = Math.max(maxArea, dfs695(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs695(int[][] grid, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) {
            return 0;
        }
        int area = 1;
        grid[x][y] = 0;
        for (int i = 0; i < dx.length; i++) {
            area += dfs695(grid, x + dx[i], y + dy[i]);
        }
        return area;
    }

}
