package leetcode.weekly_contests.weekly_103;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_909 {

    public int snakesAndLadders(int[][] board) {
        final Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);
        final int n = board.length;
        final int m = board.length;
        final boolean[] visited = new boolean[n * m + 1];
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                if (curr == n * m) {
                    return level;
                }
                for (int i = 1; i <= 6 && curr + i <= n * m; i++) {
                    final int[] coords = toCoord(curr + i, n, m);
                    if (board[coords[0]][coords[1]] != -1) {
                        if (!visited[board[coords[0]][coords[1]]]) {
                            visited[board[coords[0]][coords[1]]] = true;
                            q.offerLast(board[coords[0]][coords[1]]);
                        }
                    } else {
                        if (!visited[curr + i]) {
                            visited[curr + i] = true;
                            q.offerLast(curr + i);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int[] toCoord(int num, int rows, int cols) {
        num -= 1;
        final int r = num / cols;
        int c = num % cols;
        if (r % 2 != 0) {
            c = cols - c - 1;
        }
        return new int[] { rows - r - 1, c };
    }
}
