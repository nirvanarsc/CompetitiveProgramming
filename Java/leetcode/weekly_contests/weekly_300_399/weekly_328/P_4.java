package leetcode.weekly_contests.weekly_300_399.weekly_328;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] price;
    static long[] dist;

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.n = n;
        this.edges = edges;
        this.price = price;
        dist = new long[n];
        g = packG();
        final int l = (int) farthest(0, -1, 0)[1];
        final int r = (int) farthest(l, -1, 0)[1];
        dfs(l, -1, 0);
        dfs(r, -1, 0);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dist[i] - price[i]);
        }
        return res;
    }

    private static long[] farthest(int u, int p, long d) {
        d += price[u];
        long[] res = { d, u };
        for (int v : g[u]) {
            if (v != p) {
                final long[] next = farthest(v, u, d);
                if (next[0] > res[0]) {
                    res = next;
                }
            }
        }
        return res;
    }

    private static void dfs(int u, int p, long d) {
        d += price[u];
        dist[u] = Math.max(dist[u], d);
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, d);
            }
        }
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
