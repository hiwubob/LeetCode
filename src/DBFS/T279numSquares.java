package DBFS;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T279numSquares {

    public int numSquares(int n) {
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
                for (int square :
                        squares) {
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

    public static void main(String[] args) {
        T279numSquares t = new T279numSquares();
        System.out.println(t.numSquares(12));
    }
}
