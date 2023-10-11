package leetcode.biweekly_contests.biweekly_100_199.biweekly_113;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][][] g;
    static int[] res;
    static int curr;

    @SuppressWarnings("AccessStaticViaInstance")
    public int[] minEdgeReversals(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        g = packG();
        res = new int[n];
        curr = 0;
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    private static void dfs(int u, int p) {
        for (int[] v : g[u]) {
            if (v[0] != p) {
                curr += v[1];
                dfs(v[0], u);
            }
        }
    }

    private static void dfs2(int u, int p) {
        res[u] = curr;
        for (int[] v : g[u]) {
            if (v[0] != p) {
                curr -= v[1] == 1 ? 1 : -1;
                dfs2(v[0], u);
                curr += v[1] == 1 ? 1 : -1;
            }
        }
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
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], 0 };
            g[edge[1]][--size[edge[1]]] = new int[] { edge[0], 1 };
        }
        return g;
    }
}
