package leetcode.weekly_contests.weekly_103;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_909 {

    public int snakesAndLadders(int[][] board) {
        final Deque<Integer> q = new ArrayDeque<>(Collections.singleton(1));
        final int n = board.length;
        final boolean[] visited = new boolean[n * n + 1];
        int res = 1;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                final int curr = q.removeFirst();
                for (int t = 1; t <= 6; t++) {
                    int next = curr + t;
                    if (getBoardValue(board, next, n) != -1) {
                        next = getBoardValue(board, next, n);
                    }
                    if (next == n * n) {
                        return res;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offerLast(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private static int getBoardValue(int[][] board, int num, int n) {
        final int oldRow = (num - 1) / n;
        final int row = n - 1 - oldRow;
        final int oldCol = (num - 1) % n;
        final int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;
        return board[row][col];
    }
}
