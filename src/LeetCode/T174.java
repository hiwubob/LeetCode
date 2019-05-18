package LeetCode;

public class T174 {

	// 求骑士走到右下角的最低生命值
	// 只能右或者下
	// DP
	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] life = new int[row][col]; // life[i][j] 表示i,j的时候需要的最小生命值，肯定不能小于1
		// 初始化
		if (dungeon[row - 1][col - 1] < 0) {
			life[row - 1][col - 1] = -dungeon[row - 1][col - 1] + 1;
		} else {
			life[row - 1][col - 1] = 1;
		}
		// 初始化最后一列
		for (int i = row - 2; i >= 0; i--) {
			if (life[i + 1][col - 1] == 1) { // 表示后面的可以自己满足
				life[i][col - 1] = Math.max(1, -dungeon[i][col - 1] + 1);
			} else { // 后面的不可以满足
				life[i][col - 1] = Math.max(life[i + 1][col - 1] - dungeon[i][col - 1], 1);
			}
		}
		// 初始话最后一行
		for (int j = col - 2; j >= 0; j--) {
			if (life[row - 1][j + 1] == 1) {
				life[row - 1][j] = Math.max(1, -dungeon[row - 1][j] + 1);
			} else {
				life[row - 1][j] = Math.max(life[row - 1][j + 1] - dungeon[row - 1][j], 1);
			}
		}
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				int min = Math.min(life[i][j + 1], life[i + 1][j]);
				if (min == 1) { // 后面可以满足
					life[i][j] = Math.max(1, -dungeon[i][j] + 1);
				} else {
					life[i][j] = Math.max(1, min - dungeon[i][j]);
				}
			}
		}
		return life[0][0];
	}
}
