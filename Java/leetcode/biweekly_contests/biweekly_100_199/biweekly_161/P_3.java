package leetcode.biweekly_contests.biweekly_100_199.biweekly_161;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("AccessStaticViaInstance")
public class P_3 {

    private static int n;
    private static int[][] edges;
    private static int[][][] g;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;
        this.edges = edges;
        g = packG();
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (f(mid, online) > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return f(lo, online) > k ? -1 : lo;
    }

    private static long f(int mid, boolean[] online) {
        final long[] dp = new long[n];
        Arrays.fill(dp, (long) 9e18);
        dp[0] = 0;
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[] { 0, dp[0] });
        while (!pq.isEmpty()) {
            final long[] pop = pq.remove();
            final int u = (int) pop[0];
            final long d = pop[1];
            if (dp[u] < d) {
                continue;
            }
            for (int[] v : g[u]) {
                if (v[1] >= mid && online[v[0]]) {
                    if (dp[v[0]] > dp[u] + v[1]) {
                        dp[v[0]] = dp[u] + v[1];
                        pq.offer(new long[] { v[0], dp[v[0]] });
                    }
                }
            }
        }
        return dp[n - 1];
    }

    private static int[][][] packG() {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
        }
        return g;
    }
}
