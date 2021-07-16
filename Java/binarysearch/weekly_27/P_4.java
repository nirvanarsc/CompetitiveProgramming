package binarysearch.weekly_27;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int solve(int[][] matrix, int row, int col, int erow0, int ecol0, int erow1, int ecol1) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final long[][] d1 = dijkstra(row, col, matrix, n, m);
        final long[][] d2 = dijkstra(erow0, ecol0, matrix, n, m);
        final long[][] d3 = dijkstra(erow1, ecol1, matrix, n, m);
        long res = (long) 1e18;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.min(res, d1[i][j] + d2[i][j] + d3[i][j] - 2L * matrix[i][j]);
            }
        }
        return (int) res;
    }

    private static long[][] dijkstra(int r, int c, int[][] matrix, int n, int m) {
        final long[][] d = new long[n][m];
        for (long[] row : d) {
            Arrays.fill(row, (long) 1e18);
        }
        d[r][c] = matrix[r][c];
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[2]));
        pq.offer(new long[] { r, c, d[r][c] });
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final int x = (int) curr[0];
            final int y = (int) curr[1];
            final long dd = curr[2];
            if (d[x][y] > dd) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (d[nx][ny] > d[x][y] + matrix[nx][ny]) {
                        d[nx][ny] = d[x][y] + matrix[nx][ny];
                        pq.offer(new long[] { nx, ny, d[nx][ny] });
                    }
                }
            }
        }
        return d;
    }
}
