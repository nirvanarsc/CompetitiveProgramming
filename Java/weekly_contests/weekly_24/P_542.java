package weekly_contests.weekly_24;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_542 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] matrix) {
        final Deque<int[]> queue = new ArrayDeque<>();
        final int n = matrix.length;
        final int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offerLast(new int[] { i, j });
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            final int[] curr = queue.removeFirst();
            final int x = curr[0];
            final int y = curr[1];
            for (int[] dir : DIRS) {
                final int newX = x + dir[0];
                final int newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m
                    && matrix[newX][newY] > matrix[x][y] + 1) {
                    queue.offerLast(new int[] { newX, newY });
                    matrix[newX][newY] = matrix[x][y] + 1;
                }
            }
        }
        return matrix;
    }
}
