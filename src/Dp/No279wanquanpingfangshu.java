package Dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No279wanquanpingfangshu {
//    ��ȫƽ����
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//���赽��һ�������Ĳ���Ϊÿ��+1
            for (int j = 1; i - j * j >= 0; j++) { //i-j*j>=0 �ҵ�����j j*j����i����������ȫƽ����
                //dp[i-j*j]+1 ��ʾd[i-j*j]�Ĳ�����1 1��j*j�����ȫƽ����ֻ��Ҫһ��
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
