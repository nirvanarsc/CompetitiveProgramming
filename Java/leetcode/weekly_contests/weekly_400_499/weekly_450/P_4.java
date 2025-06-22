package leetcode.weekly_contests.weekly_400_499.weekly_450;

public class P_4 {

    private static int n;
    private static int h;
    private static int time;
    private static int[][] parents;
    private static int[][] edges;
    private static int[][][] g;
    private static int[] parent;
    private static int[] in;
    private static int[] out;
    private static int[] sum;

    @SuppressWarnings("AccessStaticViaInstance")
    public int[] minimumWeight(int[][] edges, int[][] queries) {
        n = edges.length + 1;
        this.edges = edges;
        time = 0;
        h = 18;
        g = packG();
        parent = new int[n];
        in = new int[n];
        out = new int[n];
        sum = new int[n];
        dfs(0, 0);
        initParents();
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int a = queries[i][0];
            final int b = queries[i][1];
            final int c = queries[i][2];
            final int lcaAB = getLca(a, b);
            final int lcaAC = getLca(a, c);
            final int lcaBC = getLca(b, c);
            final int ab = sum[a] + sum[b] - 2 * sum[lcaAB];
            final int bc = sum[b] + sum[c] - 2 * sum[lcaBC];
            final int ca = sum[c] + sum[a] - 2 * sum[lcaAC];
            res[i] = (ab + bc + ca) >>> 1;
        }
        return res;
    }

    private static void dfs(int u, int p) {
        parent[u] = p;
        in[u] = time++;
        for (int[] v : g[u]) {
            if (v[0] != p) {
                sum[v[0]] = sum[u] + v[1];
                dfs(v[0], u);
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
