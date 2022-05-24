package leetcode.weekly_contests.weekly_200_299.weekly_263;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_4 {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        final List<List<int[]>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            final int u = edge[0] - 1;
            final int v = edge[1] - 1;
            g.get(u).add(new int[] { v, time });
            g.get(v).add(new int[] { u, time });
        }
        final long[][] d = new long[n][2];
        for (long[] row : d) {
            Arrays.fill(row, (long) 1e18);
        }
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[] { 0, 0 });
        d[0][0] = 0;
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final int u = (int) curr[0] / 2;
            long w = curr[1];
            if (w > d[u][1]) {
                continue;
            }
            if ((w / change) % 2 != 0) {
                w += change;
                w /= 2 * change;
                w *= 2 * change;
            }
            w += time;
            for (int[] v : g.get(u)) {
                final int e = v[0];
                if (w < d[e][0]) {
                    d[e][0] = w;
                    pq.offer(new long[] { e * 2, w });
                } else if (w < d[e][1] && w > d[e][0]) {
                    d[e][1] = w;
                    pq.offer(new long[] { e * 2 + 1, w });
                }
            }
        }
        return (int) d[n - 1][1];
    }
}
