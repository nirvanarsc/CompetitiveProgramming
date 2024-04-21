package leetcode.weekly_contests.weekly_200_299.weekly_297;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_2_2 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        final int n = grid.length;
        final int m = grid[0].length;
        final Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int u = (i - 1) * m + j;
                for (int k = 0; k < m; k++) {
                    final int v = i * m + k;
                    g.computeIfAbsent(1 + u, val -> new ArrayList<>())
                     .add(new int[] { 1 + v, grid[i - 1][j] + moveCost[grid[i - 1][j]][k] });
                }
            }
        }
        for (int i = 0; i < m; i++) {
            g.computeIfAbsent(0, val -> new ArrayList<>()).add(new int[] { i + 1, 0 });
        }
        final int[] d = new int[1 + (n * m)];
        Arrays.fill(d, (int) 1e9);
        d[0] = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int cost = curr[0];
            final int u = curr[1];
            if (d[u] < cost) {
                continue;
            }
            for (int[] next : g.getOrDefault(u, Collections.emptyList())) {
                if (d[next[0]] > cost + next[1]) {
                    d[next[0]] = cost + next[1];
                    pq.add(new int[] { d[next[0]], next[0] });
                }
            }
        }
        int res = (int) 1e9;
        for (int j = 0; j < m; j++) {
            res = Math.min(res, d[1 + (n - 1) * m + j] + grid[n - 1][j]);
        }
        return res;
    }
}
