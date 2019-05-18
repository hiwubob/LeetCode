package Huisu;

public class T79fangfa2 {
	int m, n;
	private int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		if (board == null || word == null) {
			throw new IllegalArgumentException("board or word can not be null.");
		}
		m = board.length;
		if (m == 0) {
			throw new IllegalArgumentException("board can not be empty.");
		}
		n = board[0].length;
		if (n == 0) {
			throw new IllegalArgumentException("board can not be empty.");
		}
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int index, int startx, int starty) {
		if (index == word.length() - 1) {
			return word.charAt(index) == board[startx][starty];
		}
		if (board[startx][starty] == word.charAt(index)) {
			visited[startx][starty] = true;
			for (int i = 0; i < 4; i++) {
				int newx = startx + d[i][0];
				int newy = starty + d[i][1];
				if (newx >= 0 && newx < m && newy >= 0 && newy < n && !visited[newx][newy]
						&& dfs(board, word, index + 1, newx, newy)) {
					return true;
				}
			}
			visited[startx][starty] = false;
		}
		return false;
	}
}
