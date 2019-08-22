package Dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No279wanquanpingfangshu {
//    完全平方数
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//假设到这一步的最大的步数为每次+1
            for (int j = 1; i - j * j >= 0; j++) { //i-j*j>=0 找到最大的j j*j就是i里面最大的完全平方数
                //dp[i-j*j]+1 表示d[i-j*j]的步数＋1 1即j*j这个完全平方数只需要一步
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.offer(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int square : squares) {
                    int remain = cur - square;
                    if (remain < 0) {
                        break;
                    }
                    if (remain == 0) {
                        return level;
                    }
                    if (marked[remain]) {
                        continue;
                    }
                    marked[remain] = true;
                    queue.add(remain);
                }
            }
        }
        return -1;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int base = (int) Math.sqrt(n);
        for (int i = 1; i <= base; i++) {
            squares.add((int) Math.pow(i, 2));
        }
        return squares;
    }
}
