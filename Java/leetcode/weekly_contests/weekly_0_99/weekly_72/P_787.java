package leetcode.weekly_contests.weekly_0_99.weekly_72;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("AccessStaticViaInstance")
public class P_787 {

    static int n;
    static int[][] edges;
    static int[][][] g;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.n = n;
        edges = flights;
        g = packG();
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        final int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        dp[src][k] = 0;
        pq.offer(new int[] { src, k, dp[src][k] });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[0];
            final int s = curr[1];
            final int d = curr[2];
            if (dp[u][s] < d) {
                continue;
            }
            for (int[] v : g[u]) {
                final int ns = v[0] == dst ? s : s - 1;
                if (ns >= 0 && dp[v[0]][ns] > dp[u][s] + v[1]) {
                    dp[v[0]][ns] = dp[u][s] + v[1];
                    pq.add(new int[] { v[0], ns, dp[v[0]][ns] });
                }
            }
        }
        int res = (int) 1e9;
        for (int s = 0; s <= k; s++) {
            res = Math.min(res, dp[dst][s]);
        }
        return res == (int) 1e9 ? -1 : res;
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
