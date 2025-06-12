package leetcode.biweekly_contests.biweekly_100_199.biweekly_157;

public class P_3 {

    private static int n;
    private static int[][] edges;
    private static int[][] g;
    private static int[] depth;
    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("AccessStaticViaInstance")
    public int assignEdgeWeights(int[][] edges) {
        n = edges.length + 1;
        this.edges = edges;
        g = packG();
        depth = new int[n];
        final int[] pow = new int[n];
        pow[1] = 1;
        for (int i = 2; i < n; i++) {
            pow[i] = (int) ((2L * pow[i - 1]) % MOD);
        }
        dfs(0, -1);
        int maxD = 0;
        for (int i = 0; i < n; i++) {
            maxD = Math.max(maxD, depth[i]);
        }
        return pow[depth[maxD]];
    }

    private static void dfs(int u, int p) {
        for (int v : g[u]) {
            if (v != p) {
                depth[v] = depth[u] + 1;
                dfs(v, u);
            }
        }
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0] - 1];
            ++size[edge[1] - 1];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0] - 1][--size[edge[0] - 1]] = edge[1] - 1;
            g[edge[1] - 1][--size[edge[1] - 1]] = edge[0] - 1;
        }
        return g;
    }
}
