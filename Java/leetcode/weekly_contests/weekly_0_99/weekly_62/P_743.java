package leetcode.weekly_contests.weekly_0_99.weekly_62;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_743 {

    static int n;
    static int[][] edges;
    static int[][][] g;

    private static int[][][] packG() {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            edge[0]--;
            edge[1]--;
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

    public int networkDelayTime(int[][] times, int n, int k) {
        //noinspection AccessStaticViaInstance
        this.n = n;
        edges = times;
        g = packG();
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        final int[] dp = new int[n];
        Arrays.fill(dp, (int) 1e9);
        dp[k - 1] = 0;
        pq.offer(new int[] { k - 1, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.poll();
            final int u = curr[0];
            final int d = curr[1];
            if (dp[u] < d) {
                continue;
            }
            for (int[] next : g[u]) {
                if (dp[next[0]] > d + next[1]) {
                    dp[next[0]] = d + next[1];
                    pq.offer(new int[] { next[0], dp[next[0]] });
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max == (int) 1e9 ? -1 : max;
    }

    public int networkDelayTimeBF(int[][] times, int n, int k) {
        final int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[k - 1] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int[] edge : times) {
                final int u = edge[0] - 1;
                final int v = edge[1] - 1;
                final int w = edge[2];
                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
