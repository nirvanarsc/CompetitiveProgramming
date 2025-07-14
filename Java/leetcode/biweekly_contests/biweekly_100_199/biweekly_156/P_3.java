package leetcode.biweekly_contests.biweekly_100_199.biweekly_156;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({ "AccessStaticViaInstance", "unchecked" })
public class P_3 {

    private static int n;

    public int maxWeight(int n, int[][] edges, int k, int t) {
        // Longest path in a DAG is n-1 edges, when the DAG is a tree.
        if (k >= n) { return -1; }
        this.n = n;
        final int[][][] g = packG(edges);
        Set<Integer>[] dp = new HashSet[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashSet<>(Set.of(0));
        }
        for (int d = 0; d < k; d++) {
            final Set<Integer>[] ndp = new HashSet[n];
            for (int i = 0; i < n; i++) {
                ndp[i] = new HashSet<>();
            }
            for (int u = 0; u < n; u++) {
                for (int s : dp[u]) {
                    for (int[] edge : g[u]) {
                        final int v = edge[0];
                        final int wt = edge[1];
                        final int newSum = s + wt;
                        if (newSum < t) {
                            ndp[v].add(newSum);
                        }
                    }
                }
            }
            dp = ndp;
        }
        int res = -1;
        for (int u = 0; u < n; u++) {
            for (int val : dp[u]) {
                res = Math.max(res, val);
            }
        }
        return res;
    }

    private static int[][][] packG(int[][] edges) {
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
