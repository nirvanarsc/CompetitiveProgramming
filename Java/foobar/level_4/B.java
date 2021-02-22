package foobar.level_4;

import java.util.Arrays;

@SuppressWarnings("UtilityClassWithoutPrivateConstructor")
public final class B {

    // First run a bellman ford algorithm on the initial graph to check for negative cycles.
    // This step takes O(V^3) -> O(7^3) ~ O(243) complexity.
    // If a negative cycle is present we can save all bunnies, so return that.
    // Then run an all pairs shortest paths floyd warshall algorithm O(7^3) ~ O(243) complexity.
    // Finally do bit-masking DP on the relaxed graph returned from floyd warshall.
    // State is [curr_node][curr_mask (saved bunnies)][curr_time]
    // Complexity of this step and the bottleneck of the algorithm is O(n*2^n*2000) ~ O(7*128*2000) ~ O(2e6).
    public static int[] solution(int[][] times, int times_limit) {
        final int n = times.length;
        final long[] bf = bellmanFord(times, 0, n);
        for (int i = 1; i < n; i++) {
            if (bf[i] == (long) -1e18) {
                final int[] all = new int[n - 2];
                for (int j = 0; j < all.length; j++) {
                    all[j] = j;
                }
                return all;
            }
        }
        final int[][] fw = floydWarshall(times, n);
        final int[][][] dp = new int[n][1 << n][2010];
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        final int bestMask = dfs(fw, 0, 0, times_limit, dp);
        final int[] res = new int[Integer.bitCount(bestMask) - 1];
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((bestMask & (1 << i)) != 0) {
                res[idx++] = i - 1;
            }
        }
        return res;
    }

    // Bitmask DP - O(n*2^n*2000) ~ O(7*128*2000) ~ O(2e6)
    private static int dfs(int[][] g, int curr, int mask, int time, int[][][] dp) {
        // Time may become negative but still case should not be discarded
        // as we might recover when we reach the bulkhead. However do set a lower limit.
        if (time < -1000) {
            return 0;
        }
        if (curr == g.length - 1) {
            return time >= 0 ? mask : 0;
        }
        if (dp[curr][mask][time + 1000] != -1) {
            return dp[curr][mask][time + 1000];
        }
        int bestMask = 0;
        for (int i = 1; i < g.length; i++) {
            if (i != curr && (mask & (1 << i)) == 0) {
                final int endMask = dfs(g, i, mask | (1 << i), time - g[curr][i], dp);
                if (Integer.bitCount(bestMask) < Integer.bitCount(endMask)) {
                    bestMask = endMask;
                } else if (Integer.bitCount(bestMask) == Integer.bitCount(endMask)) {
                    // If both masks have the same number of bits pick the lexicographically smaller one.
                    for (int j = 0; j < g.length; j++) {
                        if ((bestMask & (1 << j)) != 0 && (endMask & (1 << j)) == 0) {
                            break;
                        } else if ((bestMask & (1 << j)) == 0 && (endMask & (1 << j)) != 0) {
                            bestMask = endMask;
                            break;
                        }
                    }
                }
            }
        }
        return dp[curr][mask][time + 1000] = bestMask;
    }

    // Floyd-Warshall O(n^3)
    private static int[][] floydWarshall(int[][] graph, int n) {
        final int[][] dist = graph.clone();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }

    // Bellman-Ford O (V*E) == O(V^3)
    private static long[] bellmanFord(int[][] g, int start, int n) {
        final long[] dist = new long[n];
        Arrays.fill(dist, (long) 1e18);
        dist[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        if (dist[j] == (long) 1e18) {
                            continue;
                        }
                        dist[k] = Math.min(dist[k], dist[j] + g[j][k]);
                    }
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        if (dist[j] == (long) 1e18) {
                            continue;
                        }
                        if (dist[j] + g[j][k] < dist[k]) {
                            dist[k] = (long) -1e18;
                        }
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        final int[][] g = {
                { 0, 2, 2, 2, -5 },
                { 9, 0, 2, 2, -1 },
                { 9, 3, 0, 2, -1 },
                { 9, 3, 2, 0, -1 },
                { 9, 3, 2, 2, 0 }
        };
        System.out.println(Arrays.toString(solution(g, 1)));
    }
}
