package leetcode.weekly_contests.weekly_300_399.weekly_323;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[] maxPoints(int[][] grid, int[] queries) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int q = queries.length;
        final int[][] sorted = new int[q][2];
        for (int i = 0; i < q; i++) {
            sorted[i] = new int[] { queries[i], i };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { grid[0][0], 0, 0 });
        final int[] res = new int[q];
        final boolean[] seen = new boolean[n * m];
        seen[0] = true;
        int size = 0;
        for (int[] s : sorted) {
            while (!pq.isEmpty() && pq.element()[0] < s[0]) {
                final int[] curr = pq.remove();
                final int r = curr[1];
                final int c = curr[2];
                size++;
                for (int[] dir : DIRS) {
                    final int nr = r + dir[0];
                    final int nc = c + dir[1];
                    if (0 <= nr && nr < n && 0 <= nc && nc < m && !seen[nr * m + nc]) {
                        seen[nr * m + nc] = true;
                        pq.offer(new int[] { grid[nr][nc], nr, nc });
                    }
                }
            }
            res[s[1]] = size;
        }
        return res;
    }
}
