package binarysearch.weekly_35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int solve(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        n++;
        final Map<Integer, List<long[]>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], val -> new ArrayList<>()).add(new long[] { e[1], e[2] });
            g.computeIfAbsent(e[1], val -> new ArrayList<>()).add(new long[] { e[0], e[2] });
        }

        final long[] distances = new long[n];
        Arrays.fill(distances, (long) 1e18);
        distances[n - 1] = 0L;
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(val -> val[1]));
        pq.offer(new long[] { n - 1, 0 });
        while (!pq.isEmpty()) {
            final long[] s = pq.remove();
            final int u = (int) s[0];
            final long currW = s[1];
            if (distances[u] < currW) {
                continue;
            }
            for (long[] next : g.getOrDefault(u, Collections.emptyList())) {
                final int v = (int) next[0];
                final long w = next[1];
                if (distances[v] > distances[u] + w) {
                    distances[v] = distances[u] + w;
                    pq.offer(new long[] { v, distances[v] });
                }
            }
        }

        final long[][] sorted = new long[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i] = new long[] { i, distances[i] };
        }
        Arrays.sort(sorted, Comparator.comparingLong(val -> val[1]));

        final long[] dp = new long[n];
        dp[n - 1] = 1L;
        for (int i = 1; i < n; i++) {
            final int u = (int) sorted[i][0];
            for (long[] e : g.getOrDefault(u, Collections.emptyList())) {
                final int v = (int) e[0];
                if (distances[u] > distances[v]) {
                    dp[u] = (dp[u] + dp[v]) % MOD;
                }
            }
        }
        return (int) dp[0];
    }
}
