package leetcode.weekly_contests.weekly_0_99.weekly_84;

public class P_834 {

    int n;
    int[][] edges;
    int[][] g;
    int[] size;
    int[] res;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        g = packG();
        size = new int[n];
        res = new int[n];
        dfs1(0, -1, 0);
        dfs2(0, -1);
        return res;
    }

    private void dfs1(int u, int par, int d) {
        res[0] += d;
        size[u] = 1;
        for (int v : g[u]) {
            if (v != par) {
                dfs1(v, u, d + 1);
                size[u] += size[v];
            }
        }
    }

    private void dfs2(int u, int par) {
        for (int v : g[u]) {
            if (v != par) {
                res[v] = res[u] + n - 2 * size[v];
                dfs2(v, u);
            }
        }
    }

    private int[][] packG() {
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
