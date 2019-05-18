package Huisu;

public class T79dancisousuo {
	public boolean exist(char[][] board, String word) {
		// 首先找到首字母相同的位置，然后深搜。
		boolean visited[][] = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(visited, board, word, i, j, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean dfs(boolean visited[][], char[][] board, String word, int x, int y, int index) {
		// 如果已经比较完，返回true
		if (index == word.length()) {
			return true;
		}
		// 如果越界|点已访问|比较的位置不相等,返回false
		else if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]
				|| board[x][y] != word.charAt(index)) {
			return false;
		} else {
			// 标记当前点为访问
			visited[x][y] = true;
			// 往上下左右四个方向尝试
			boolean exist = (dfs(visited, board, word, x + 1, y, index + 1)
					|| dfs(visited, board, word, x, y + 1, index + 1)
					|| dfs(visited, board, word, x - 1, y, index + 1)
					|| dfs(visited, board, word, x, y - 1, index + 1)) ? true : false;

			visited[x][y] = false;
			return exist;

		}
	}
}
