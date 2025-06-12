package leetcode.biweekly_contests.biweekly_100_199.biweekly_157;

public class P_4 {

    private static int n;
    private static int h;
    private static int time;
    private static int[][] parents;
    private static int[][] edges;
    private static int[][] g;
    private static int[] parent;
    private static int[] depth;
    private static int[] in;
    private static int[] out;
    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("AccessStaticViaInstance")
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n = edges.length + 1;
        this.edges = edges;
        time = 0;
        h = 18;
        g = packG();
        parent = new int[n];
        depth = new int[n];
        in = new int[n];
        out = new int[n];
        final int[] pow = new int[n];
        pow[1] = 1;
        for (int i = 2; i < n; i++) {
            pow[i] = (int) ((2L * pow[i - 1]) % MOD);
        }
        dfs(0, 0);
        initParents();
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int u = queries[i][0] - 1;
            final int v = queries[i][1] - 1;
            final int lca = getLca(u, v);
            final int dist = depth[u] + depth[v] - 2 * depth[lca];
            res[i] = pow[dist];
        }
        return res;
    }

    private static void dfs(int u, int p) {
        parent[u] = p;
        in[u] = time++;
        for (int v : g[u]) {
            if (v != p) {
                depth[v] = depth[u] + 1;
                dfs(v, u);
            }
        }
        out[u] = time;
    }

    private static void initParents() {
        parents = new int[h + 1][n];
        parents[0] = parent;
        for (int i = 1; i <= h; i++) {
            for (int u = 0; u < n; u++) {
                final int nodeParent = parents[i - 1][u];
                parents[i][u] = parents[i - 1][nodeParent];
            }
        }
    }

    private static boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }

    private static int getLca(int u, int v) {
        if (isAncestor(u, v)) { return u; }
        if (isAncestor(v, u)) { return v; }
        for (int i = h; i >= 0; i--) {
            if (!isAncestor(parents[i][u], v)) {
                u = parents[i][u];
            }
        }
        return parents[0][u];
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
