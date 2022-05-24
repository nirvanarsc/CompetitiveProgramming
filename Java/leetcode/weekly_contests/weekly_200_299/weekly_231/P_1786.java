package leetcode.weekly_contests.weekly_200_299.weekly_231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_1786 {

    private static final int MOD = (int) (1e9 + 7);

    public int countRestrictedPaths(int n, int[][] edges) {
        final List<List<int[]>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            final int u = e[0] - 1;
            final int v = e[1] - 1;
            final int w = e[2];
            g.get(u).add(new int[] { v, w });
            g.get(v).add(new int[] { u, w });
        }
        final int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { n - 1, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[0];
            final int w = curr[1];
            if (dp[u] < w) {
                continue;
            }
            for (int[] v : g.get(u)) {
                if (dp[v[0]] > w + v[1]) {
                    dp[v[0]] = w + v[1];
                    pq.offer(new int[] { v[0], w + v[1] });
                }
            }
        }
        final int[][] indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { dp[i], i };
        }
        final long[] count = new long[n];
        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        count[n - 1] = 1;
        for (int i = 0; i < n; i++) {
            final int u = indexed[i][1];
            for (int[] v : g.get(u)) {
                if (dp[u] < dp[v[0]]) {
                    count[v[0]] = (count[v[0]] + count[u]) % MOD;
                }
            }
        }
        return (int) count[0];
    }
}
