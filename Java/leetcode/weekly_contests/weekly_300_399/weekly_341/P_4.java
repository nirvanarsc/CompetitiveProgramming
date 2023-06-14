package leetcode.weekly_contests.weekly_300_399.weekly_341;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] count;
    static int[] price;
    static boolean[][] seen;
    static int[][] dp;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.n = n;
        this.edges = edges;
        this.price = price;
        g = packG();
        count = new int[n];
        for (int[] trip : trips) {
            count[trip[0]]++;
            dfs2(trip[0], -1, trip[1]);
        }
        seen = new boolean[n][3];
        dp = new int[n][3];
        return dfs(0, -1, 0);
    }

    private static boolean dfs2(int u, int p, int d) {
        if (d == u) {
            return true;
        }
        for (int v : g[u]) {
            if (v != p) {
                count[v]++;
                if (dfs2(v, u, d)) {
                    return true;
                }
                count[v]--;
            }
        }
        return false;
    }

    private static int dfs(int u, int p, int take) {
        if (seen[u][take]) {
            return dp[u][take];
        }
        final int res;
        if (take == 1) {
            int curr = count[u] * price[u];
            for (int v : g[u]) {
                if (v != p) {
                    curr += dfs(v, u, 0);
                }
            }
            res = curr;
        } else {
            int curr1 = count[u] * price[u];
            int curr2 = count[u] * price[u] / 2;
            for (int v : g[u]) {
                if (v != p) {
                    curr1 += dfs(v, u, 0);
                    curr2 += dfs(v, u, 1);
                }
            }
            res = Math.min(curr1, curr2);
        }
        seen[u][take] = true;
        return dp[u][take] = res;
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
