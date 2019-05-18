package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*请设计一个算法，帮助探险家找到脱困的最短路径。
 * 如前所述，迷宫是通过一个二维矩阵表示的，
 * 每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙 
5 5
02111
01a0A
01003
01001
01111*/
public class Maze2018 {

	static class Node {
		int x;
		int y;
		int key;
		int step;

		public Node(int x, int y, int key, int step) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.step = step;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		in.nextLine();
		char[][] G = new char[N][M];
		for (int i = 0; i < N; i++) {
			G[i] = in.nextLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (G[i][j] == '2') {
					System.out.println(bfs(i, j, N, M, G));
					return;
				}
			}
		}
	}

	private static int bfs(int si, int sj, int N, int M, char[][] G) {
		Queue<Node> queue = new LinkedList<>();
		int[][][] mp = new int[101][101][1025];//1025 钥匙用2进制表示，因为最多10把钥匙就是1024
		int[][] next = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		queue.offer(new Node(si, sj, 0, 0));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = node.x + next[i][0];
				int y = node.y + next[i][1];
				int key = node.key;
				if (x < 0 || x >= N || y < 0 || y >= M || G[x][y] == '0')
					continue;
				else if (G[x][y] == '3')
					return node.step + 1;
				else if (G[x][y] <= 'z' && G[x][y] >= 'a')
					key = key | (1 << (G[x][y] - 'a'));//保存钥匙
				else if (G[x][y] <= 'Z' && G[x][y] >= 'A' && (key & (1 << (G[x][y] - 'A'))) == 0)//没有钥匙
					continue;
				if (mp[x][y][key] == 0) {
					mp[x][y][key] = 1;
					queue.offer(new Node(x, y, key, node.step + 1));
				}

			}
		}
		return -1;
	}

}
