package binarysearch.weekly_34;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_2 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int solve(int[][] matrix) {
        final Deque<int[]> q = new ArrayDeque<>();
        final int n = matrix.length;
        final int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 2) {
                    q.offerLast(new int[] { i, j });
                }
            }
        }
        final boolean[][] seen = new boolean[n][m];
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int[] curr = q.removeFirst();
                final int x = curr[0];
                final int y = curr[1];
                if (matrix[x][y] == 3) {
                    return level;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] != 1) {
                        if (!seen[nx][ny]) {
                            seen[nx][ny] = true;
                            q.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return -1;
    }
}
