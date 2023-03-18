package leetcode.biweekly_contests.biweekly_0_99.biweekly_56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    static int[][][] g;
    static int[][] edges;
    static int n;

    public int minCost(int maxTime, int[][] e, int[] passingFees) {
        edges = e;
        n = passingFees.length;
        g = packG();
        final int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }
        dp[0][0] = passingFees[0];
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { passingFees[0], 0, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int d = curr[0];
            final int u = curr[1];
            final int time = curr[2];
            if (dp[u][time] < d) {
                continue;
            }
            for (int[] next : g[u]) {
                final int nextTime = time + next[1];
                if (nextTime <= maxTime) {
                    if (dp[next[0]][nextTime] > dp[u][time] + passingFees[next[0]]) {
                        dp[next[0]][nextTime] = dp[u][time] + passingFees[next[0]];
                        pq.offer(new int[] { dp[next[0]][nextTime], next[0], nextTime });
                    }
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i <= maxTime; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res == (int) 1e9 ? -1 : res;
    }

    private static int[][][] packG() {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
            g[edge[1]][--size[edge[1]]] = new int[] { edge[0], edge[2] };
        }
        return g;
    }
}
