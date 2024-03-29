package leetcode.weekly_contests.weekly_0_99.weekly_84;

public class P_834 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] size;
    static int[] res;

    public int[] sumOfDistancesInTree(int m, int[][] e) {
        n = m;
        edges = e;
        g = packG();
        size = new int[n];
        res = new int[n];
        dfs1(0, -1, 0);
        dfs2(0, -1);
        return res;
    }

    private static void dfs1(int u, int par, int d) {
        res[0] += d;
        size[u] = 1;
        for (int v : g[u]) {
            if (v != par) {
                dfs1(v, u, d + 1);
                size[u] += size[v];
            }
        }
    }

    private static void dfs2(int u, int par) {
        for (int v : g[u]) {
            if (v != par) {
                res[v] = res[u] + n - 2 * size[v];
                dfs2(v, u);
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
