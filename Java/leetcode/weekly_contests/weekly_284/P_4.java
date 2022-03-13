package leetcode.weekly_contests.weekly_284;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_4 {

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        final Map<Integer, List<int[]>> g = new HashMap<>();
        final Map<Integer, List<int[]>> rev = new HashMap<>();
        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            final int w = edge[2];
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { v, w });
            rev.computeIfAbsent(v, val -> new ArrayList<>()).add(new int[] { u, w });
        }
        final long[] a = dijkstra(g, n, src1);
        final long[] b = dijkstra(g, n, src2);
        if (a[dest] == (long) 1e18 || b[dest] == (long) 1e18) {
            return -1;
        }
        final long[] c = dijkstra(rev, n, dest);
        long res = (long) 1e18;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, a[i] + b[i] + c[i]);
        }
        return res;
    }

    private static long[] dijkstra(Map<Integer, List<int[]>> g, int n, int u) {
        final long[] d = new long[n];
        Arrays.fill(d, (long) 1e18);
        d[u] = 0;
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[] { 0, u });
        while (!pq.isEmpty()) {
            final long[] pop = pq.remove();
            final int curr = (int) pop[1];
            final long w = pop[0];
            if (d[curr] < w) {
                continue;
            }
            for (int[] v : g.getOrDefault(curr, Collections.emptyList())) {
                if (d[v[0]] > d[curr] + v[1]) {
                    d[v[0]] = d[curr] + v[1];
                    pq.offer(new long[] { d[curr] + v[1], v[0] });
                }
            }
        }
        return d;
    }
}
