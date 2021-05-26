package binarysearch.weekly_40;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_2 {

    private static final int[][] DIRS =
            { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

    public int solve(int[][] board) {
        final int n = board.length;
        final int m = board[0].length;
        final Deque<int[]> dq = new ArrayDeque<>();
        final boolean[][] seen = new boolean[n][m];
        int kX = -1;
        int kY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    dq.offerLast(new int[] { i, j });
                } else if (board[i][j] == 2) {
                    kX = i;
                    kY = j;
                }
            }
        }
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int x = curr[0];
                final int y = curr[1];
                if (x == kX && y == kY) {
                    return level;
                }
                if (seen[x][y]) {
                    continue;
                }
                seen[x][y] = true;
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && !seen[nx][ny]) {
                        dq.offerLast(new int[] { nx, ny });
                    }
                }
            }
        }
        return -1;
    }
}
