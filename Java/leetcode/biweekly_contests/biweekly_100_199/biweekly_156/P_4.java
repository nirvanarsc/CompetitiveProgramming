package leetcode.biweekly_contests.biweekly_100_199.biweekly_156;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    private static int n;
    private static int[][] g;
    private static int[] val;
    static boolean[][][] seen;
    static long[][][] dp;
    static int k;

    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {
        n = edges.length + 1;
        g = packG(edges);
        val = nums;
        seen = new boolean[n][k + 1][2];
        dp = new long[n][k + 1][2];
        this.k = k;
        return dfs(0, -1, 0, k);
    }

    private static long dfs(int u, int p, int inv, int dist) {
        if (seen[u][dist][inv]) {
            return dp[u][dist][inv];
        }
        long sumDontInvert = (inv == 1) ? -val[u] : val[u];
        for (int v : g[u]) {
            if (v != p) {
                sumDontInvert += dfs(v, u, inv, Math.min(k, dist + 1));
            }
        }
        long sumInvert = (long) -1e18;
        if (dist >= k) {
            sumInvert = (inv == 1) ? val[u] : -val[u];
            for (int v : g[u]) {
                if (v != p) {
                    sumInvert += dfs(v, u, 1 ^ inv, 1);
                }
            }
        }
        final long res = Math.max(sumDontInvert, sumInvert);
        seen[u][dist][inv] = true;
        dp[u][dist][inv] = res;
        return res;
    }

    private static int[][] packG(int[][] edges) {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
