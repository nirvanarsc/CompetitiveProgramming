package leetcode.weekly_contests.weekly_100_199.weekly_103;

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
                    final int u = curr + i - 1;
                    final int r = u / m;
                    final int x = n - r - 1;
                    final int y = r % 2 != 0 ? (m - (u % m) - 1) : u % m;
                    if (board[x][y] != -1) {
                        if (!visited[board[x][y]]) {
                            visited[board[x][y]] = true;
                            q.offerLast(board[x][y]);
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
}
