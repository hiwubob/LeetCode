package DBFS;

public class T130solve {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1 - 1};
    int row, col;

    //扫边界
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    dfs130(board, i, j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = 'X';

                }
                if (board[i][j] == 'M') {
                    board[i][j] = '0';
                }
            }
        }
    }

    private void dfs130(char[][] board, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != '0') {
            return;
        }
        board[x][y] = 'M';
        for (int i = 0; i < dx.length; i++) {
            dfs130(board, x + dx[i], y + dy[i]);
        }
    }
}
