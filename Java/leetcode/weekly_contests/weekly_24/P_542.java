package leetcode.weekly_contests.weekly_24;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_542 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        final int[][] res = new int[n][m];
        for (int[] row : res) {
            Arrays.fill(row, (int) 1e9);
        }
        final Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    dq.offerLast(new int[] { i, j });
                }
            }
        }
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int x = curr[0];
                final int y = curr[1];
                if (res[x][y] < level) {
                    continue;
                }
                res[x][y] = level;
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (res[nx][ny] > level + 1) {
                            res[nx][ny] = level + 1;
                            dq.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return res;
    }
}
