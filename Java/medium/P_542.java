package medium;

import java.util.Deque;
import java.util.LinkedList;

public class P_542 {

    public int[][] updateMatrix(int[][] matrix) {
        final Deque<int[]> queue = new LinkedList<>();
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
            for (int[] dir : new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }) {
                final int newX = curr[0] + dir[0];
                final int newY = curr[1] + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m
                    && matrix[newX][newY] >= matrix[curr[0]][curr[1]] + 1) {
                    queue.offerLast(new int[] { newX, newY });
                    matrix[newX][newY] = matrix[curr[0]][curr[1]] + 1;
                }
            }

        }
        return matrix;
    }
}
