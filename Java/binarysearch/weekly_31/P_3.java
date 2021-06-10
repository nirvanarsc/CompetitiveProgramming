package binarysearch.weekly_31;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_3 {
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] res = new int[n][m];
        final boolean[][] seen = new boolean[n][m];
        final Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dq.offerLast(new int[] { i, j });
                    seen[i][j] = true;
                }
            }
        }
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int x = curr[0];
                final int y = curr[1];
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && res[nx][ny] < level + 1 && !seen[nx][ny]) {
                        seen[nx][ny] = true;
                        res[nx][ny] = level + 1;
                        dq.offerLast(new int[] { nx, ny });
                    }
                }
            }
        }
        return res;
    }
}
