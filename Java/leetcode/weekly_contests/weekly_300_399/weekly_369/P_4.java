package leetcode.weekly_contests.weekly_300_399.weekly_369;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    static int n;
    static int k;
    static int[][] edges;
    static int[] coins;
    static int[][] g;
    static boolean[][] seen;
    static int[][] dp;

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        n = coins.length;
        this.k = k;
        this.edges = edges;
        this.coins = coins;
        g = packG();
        seen = new boolean[n][14];
        dp = new int[n][14];
        return dfs(0, -1, 0);
    }

    private static int dfs(int u, int p, int op2) {
        if (op2 > 13) {
            return 0;
        }
        if (seen[u][op2]) {
            return dp[u][op2];
        }
        final int[] curr = { (coins[u] >> op2) - k, coins[u] >> (op2 + 1) };
        for (int v : g[u]) {
            if (v == p) {
                continue;
            }
            curr[0] += dfs(v, u, op2);
            curr[1] += dfs(v, u, op2 + 1);
        }
        seen[u][op2] = true;
        return dp[u][op2] = Math.max(curr[0], curr[1]);
    }

    private static int[][] packG() {
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
